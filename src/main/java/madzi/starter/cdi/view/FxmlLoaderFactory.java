package madzi.starter.cdi.view;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import javafx.fxml.FXMLLoader;

@ApplicationScoped
public class FxmlLoaderFactory {

    @Inject
    private Instance<Object> instance;

    @Produces
    public FXMLLoader fxmlLoader() {
        final var loader = new FXMLLoader();
        loader.setControllerFactory(param -> instance.select(param).get());
        return loader;
    }
}
