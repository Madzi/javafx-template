package madzi.starter.view;

import org.slf4j.Logger;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import javafx.scene.Parent;
import javafx.scene.Scene;
import madzi.starter.cdi.lang.MessageService;
import madzi.starter.cdi.view.FxmlView;
import madzi.starter.cdi.view.StartupScene;
import madzi.starter.cdi.view.event.ViewEvent;
import madzi.starter.lang.Message;

@ApplicationScoped
public class MainView {

    @Inject
    private Logger logger;
    @Inject
    private MessageService messageService;
    @Inject
    @FxmlView("./view/main.fxml")
    private Parent view;

    public void listener(final @Observes @StartupScene ViewEvent viewEvent) {
        logger.info("Show main view");
        final var stage = viewEvent.stage();
        stage.setScene(new Scene(view, 800.0, 600.0));
        stage.setTitle(messageService.message(Message.APP_TITLE));
        stage.show();
    }
}
