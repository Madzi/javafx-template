package madzi.starter.lang;

import madzi.starter.cdi.lang.MessageService.Key;

public enum Message implements Key {
    APP_TITLE("app.title");

    Message(final String key) {
        this.key = key;
    }

    private final String key;

    @Override
    public String key() {
        return key;
    }
}
