package madzi.starter.cdi.view.event;

import javafx.stage.Stage;

public interface ViewEvent<T> {

    Stage stage();

    T data();
}
