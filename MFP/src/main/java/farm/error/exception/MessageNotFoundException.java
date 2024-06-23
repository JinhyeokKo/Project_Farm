package farm.error.exception;

public class MessageNotFoundException extends RuntimeException {
    private static final String DEFAULT_MESSAGE = "해당 메시지가 없습니다.";

    public MessageNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public MessageNotFoundException(String message) {
        super(message);
    }
}
