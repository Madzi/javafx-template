package madzi.starter.cdi.lang;

@FunctionalInterface
public interface MessageService {

    String message(Key key);

    @FunctionalInterface
    interface Key {

        String key();
    }
}
