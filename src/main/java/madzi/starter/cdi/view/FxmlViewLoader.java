package madzi.starter.cdi.view;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.enterprise.inject.spi.InjectionPoint;
import jakarta.inject.Inject;
import java.io.IOException;
import java.io.InputStream;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.slf4j.Logger;


@ApplicationScoped
public class FxmlViewLoader {

    @Inject
    private Logger logger;
    @Inject
    private FXMLLoader fxmlLoader;

    @Produces
    public Parent loadView(final InjectionPoint injectionPoint) {
        final var annotated = injectionPoint.getAnnotated();
        if (annotated.isAnnotationPresent(FxmlView.class)) {
            final var annotation = annotated.getAnnotation(FxmlView.class);
            return loadView(annotation.value());
        }
        throw new IllegalStateException("Unable to find @FxmlView annotation");
    }

    private Parent loadView(final String path) {
        try (InputStream fxmlStream = getClass().getClassLoader().getResourceAsStream("./view/main.fxml")) { 
            return fxmlLoader.load(fxmlStream);
        } catch (final IOException ioException) {
            logger.error("Unable to load view: {}", path, ioException);
            throw new IllegalStateException("Unable to load view");
        }
    }
}
