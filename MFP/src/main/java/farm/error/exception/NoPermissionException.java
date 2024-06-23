package farm.error.exception;

public class NoPermissionException extends RuntimeException {
    private static final String DEFAULT_MESSAGE = "해당 작업을 수행할 권한이 없습니다.";

    public NoPermissionException() {
        super(DEFAULT_MESSAGE);
    }

    public NoPermissionException(String message) {
        super(message);
    }
}
