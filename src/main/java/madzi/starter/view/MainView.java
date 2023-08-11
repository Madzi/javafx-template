package madzi.starter.view;

import com.typesafe.config.Config;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import madzi.starter.cdi.lang.MessageService;
import madzi.starter.cdi.view.StartupScene;
import madzi.starter.cdi.view.FxmlView;
import madzi.starter.lang.Message;
import org.slf4j.Logger;

@ApplicationScoped
public class MainView {

    @Inject
    private Logger logger;
    @Inject
    private MessageService messageService;
    @Inject
    private Config config;
    @Inject
    @FxmlView("./view/main.fxml")
    private Parent view;

    public void listener(final @Observes @StartupScene Stage stage) {
        logger.info("Show main view");
        logger.info("config: {}", config);
        stage.setScene(new Scene(view, 800.0, 600.0));
        stage.setTitle(messageService.message(Message.APP_TITLE));
        stage.show();
    }
}
