package madzi.starter.cdi.lang;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.ResourceBundle;

@ApplicationScoped
public class ResourceMessageService implements MessageService {

    private final ResourceBundle resourceBundle = ResourceBundle.getBundle("lang/template");

    @Override
    public String message(final Key key) {
        return resourceBundle.getString(key.key());
    }

    @Override
    public ResourceBundle resources() {
        return resourceBundle;
    }
}
