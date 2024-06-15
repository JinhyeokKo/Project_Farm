package farm.community.dto;

import farm.community.domain.Message;
import farm.member.domain.Member;

public class MessageDto {
    private String content;
    private Member sender;
    private Member receiver;

    public MessageDto(Message message) {
        this.content = message.getContent();
        this.sender = message.getSender();
        this.receiver = message.getReceiver();
    }

    public String getContent() {
        return content;
    }

    public Member getSender() {
        return sender;
    }

    public Member getReceiver() {
        return receiver;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSender(Member sender) {
        this.sender = sender;
    }

    public void setReceiver(Member receiver) {
        this.receiver = receiver;
    }
}
