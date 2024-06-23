package farm.error.exception;

public class PostNotFoundException extends RuntimeException {
    private static final String DEFAULT_MESSAGE = "해당 포스트가 없습니다.";

    public PostNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public PostNotFoundException(String message) {
        super(message);
    }
}
