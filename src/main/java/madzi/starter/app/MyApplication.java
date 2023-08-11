package madzi.starter.app;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import jakarta.enterprise.util.AnnotationLiteral;
import javafx.application.Application;
import javafx.stage.Stage;
import madzi.starter.cdi.view.StartupScene;

public class MyApplication extends Application {

    private SeContainer container;

    @Override
    public void init() {
        container = SeContainerInitializer.newInstance().initialize();
    }

    @Override
    public void stop() {
        container.close();
    }

    @Override
    public void start(final Stage stage) throws Exception {
        container.getBeanContainer().getEvent().select(new AnnotationLiteral<StartupScene>() {}).fire(stage);
    }
}
