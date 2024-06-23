package farm.error.exception;

public class MemberNotFoundException extends RuntimeException {
    private static final String DEFAULT_MESSAGE = "존재하지 않는 회원입니다.";

    public MemberNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public MemberNotFoundException(String message){
        super(message);
    }
}
