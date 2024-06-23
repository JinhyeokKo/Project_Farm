package farm.error.exception;

public class CommentNotFoundException extends RuntimeException {
    private static final String DEFAULT_MESSAGE = "해당 댓글이 없습니다.";

    public CommentNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public CommentNotFoundException(String message) {
        super(message);
    }
}
