package madzi.starter;

import javafx.application.Application;
import madzi.starter.app.TemplateApplication;

/**
 * Entrypoint for application
 */
public class Starter {

    public static void main(final String... args) {
        System.setProperty("org.jboss.logging.provider", "slf4j");
        Application.launch(TemplateApplication.class, args);
    }
}
