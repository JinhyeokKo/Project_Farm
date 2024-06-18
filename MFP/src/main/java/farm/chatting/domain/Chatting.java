package farm.chatting.domain;

public class Chatting {
    private String message;

    public Chatting() {
    }

    public Chatting(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
