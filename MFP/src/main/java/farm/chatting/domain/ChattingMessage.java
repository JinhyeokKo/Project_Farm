package farm.chatting.domain;

import java.time.LocalDateTime;

// 채팅 메시지를 나타내는 클래스
public class ChattingMessage {
    private String roomId;
    private String content;
    private String sender;
    private String receiver;
    private MessageType type;
    private LocalDateTime timestamp;

    public ChattingMessage() {

    }

    // 메시지 타입을 정의하는 열거형
    public enum MessageType {
        CHAT, JOIN, LEAVE
    }

    // private 생성자
    private ChattingMessage(String roomId, String content, String sender, String receiver, MessageType type, LocalDateTime timestamp) {
        this.roomId = roomId;
        this.content = content;
        this.sender = sender;
        this.receiver = receiver;
        this.type = type;
        this.timestamp = timestamp;
    }

    // Getters
    public String getRoomId() { return roomId; }
    public String getContent() { return content; }
    public String getSender() { return sender; }
    public String getReceiver() { return receiver; }
    public MessageType getType() { return type; }
    public LocalDateTime getTimestamp() { return timestamp; }

    // Builder 클래스
    public static class Builder {
        private String roomId;
        private String content;
        private String sender;
        private String receiver;
        private MessageType type;
        private LocalDateTime timestamp;

        public Builder roomId(String roomId) { this.roomId = roomId; return this; }
        public Builder content(String content) { this.content = content; return this; }
        public Builder sender(String sender) { this.sender = sender; return this; }
        public Builder receiver(String receiver) { this.receiver = receiver; return this; }
        public Builder type(MessageType type) { this.type = type; return this; }
        public Builder timestamp(LocalDateTime timestamp) { this.timestamp = timestamp; return this; }

        public ChattingMessage build() {
            return new ChattingMessage(roomId, content, sender, receiver, type, timestamp);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}