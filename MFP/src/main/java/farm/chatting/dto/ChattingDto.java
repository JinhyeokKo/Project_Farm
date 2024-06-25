package farm.chatting.dto;

import farm.chatting.domain.ChattingMessage;
import farm.chatting.domain.ChattingRoom;

// 채팅 관련 DTO 클래스
public class ChattingDto {
    private String roomId;
    private String content;
    private String sender;
    private String receiver;

    // 기본 생성자
    public ChattingDto() {}

    // 변환 생성자
    public ChattingDto(ChattingRoom chattingRoom) {
        this.roomId = chattingRoom.getRoomId();
        this.sender = chattingRoom.getUser1();
        this.receiver = chattingRoom.getUser2();
    }

    public ChattingDto(ChattingMessage chattingMessage) {
        this.roomId = chattingMessage.getRoomId();
        this.sender = chattingMessage.getSender();
        this.receiver = chattingMessage.getReceiver();
        this.content = chattingMessage.getContent();
    }

    // Getters and Setters
    public String getRoomId() { return roomId; }

    public void setRoomId(String roomId) { this.roomId = roomId; }

    public String getContent() { return content; }

    public void setContent(String content) { this.content = content; }

    public String getSender() { return sender; }

    public void setSender(String sender) { this.sender = sender; }

    public String getReceiver() { return receiver; }

    public void setReceiver(String receiver) { this.receiver = receiver; }
}