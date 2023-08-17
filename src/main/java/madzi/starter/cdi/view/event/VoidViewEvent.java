package madzi.starter.cdi.view.event;

import javafx.stage.Stage;

public record VoidViewEvent(Stage stage) implements ViewEvent<Void> {

    @Override
    public Void data() {
        return null;
    }
}
