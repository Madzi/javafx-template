package madzi.starter.cdi.view;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.enterprise.inject.Instance;
import jakarta.enterprise.inject.Produces;
import jakarta.enterprise.inject.spi.InjectionPoint;
import jakarta.inject.Inject;
import java.io.IOException;
import java.io.InputStream;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import madzi.starter.cdi.lang.MessageService;
import madzi.starter.cdi.view.event.ViewEvent;
import madzi.starter.lang.Message;

import org.slf4j.Logger;


@ApplicationScoped
public class FxmlViewFactory {

    @Inject
    private Logger logger;
    @Inject
    private Instance<Object> instance;
    @Inject
    private MessageService messageService;

    public void mainView(final @Observes @MainFxmlView ViewEvent<?> viewEvent) {
        logger.info("Main View");
        final var stage = viewEvent.stage();
        stage.setScene(new Scene(loadView("./view/main.fxml")));
        stage.setTitle(messageService.message(Message.APP_TITLE));
        stage.show();
    }

    private Parent loadView(final String path) {
        final var fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(param -> instance.select(param).get());
        fxmlLoader.setResources(messageService.resources());
        try (InputStream fxmlStream = getClass().getClassLoader().getResourceAsStream("./view/main.fxml")) { 
            return fxmlLoader.load(fxmlStream);
        } catch (final IOException ioException) {
            logger.error("Unable to load view: {}", path, ioException);
            throw new IllegalStateException("Unable to load view");
        }
    }
}
