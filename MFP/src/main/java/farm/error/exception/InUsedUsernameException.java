package farm.error.exception;

public class InUsedUsernameException extends RuntimeException {
    private static final String DEFAULT_MESSAGE = "이미 사용중인 아이디입니다.";

    public InUsedUsernameException() {
        super(DEFAULT_MESSAGE);
    }

    public InUsedUsernameException(String message) {
        super(message);
    }
}
