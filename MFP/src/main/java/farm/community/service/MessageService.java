package farm.community.service;

import farm.community.domain.Message;
import farm.community.dto.MessageDto;
import farm.community.repository.MessageRepository;
import farm.error.exception.MemberNotFoundException;
import farm.error.exception.MessageNotFoundException;
import farm.error.exception.NoPermissionException;
import farm.member.domain.Member;
import farm.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository, MemberRepository memberRepository) {
        this.messageRepository = messageRepository;
        this.memberRepository = memberRepository;
    }

    public void sendMessage(MessageDto messageDto, String username) {
        getMemberByUsername(messageDto.getReceiver().getUsername());
        messageDto.setSender(getMemberByUsername(username));
        sendMessageDetails(messageDto);
    }

    private void sendMessageDetails(MessageDto messageDto) {
        messageRepository.save(Message.createMessage(messageDto));
    }

    public List<MessageDto> getAllMessages(String username) {
        return getAllMessagesDetails(getMemberByUsername(username));
    }

    private List<MessageDto> getAllMessagesDetails(Member member) {
        return messageRepository.findByReceiver(member).stream().map(MessageDto::new).toList();
    }

    public List<MessageDto> getSentMessages(String username) {
        return getSentMessagesDetails(getMemberByUsername(username));
    }

    private List<MessageDto> getSentMessagesDetails(Member member) {
        return messageRepository.findBySender(member).stream().map(MessageDto::new).toList();
    }

    public MessageDto getMessage(long messageId, String username) {
        return getMessageDetails(getFindByMessageId(messageId), username);
    }

    private MessageDto getMessageDetails(Message message, String username) {
        if (!message.getReceiver().getUsername().equals(username) || !message.getSender().getUsername().equals(username)) {
            throw new NoPermissionException();
        }
        return new MessageDto(message);
    }

    private Message getFindByMessageId(long messageId) {
        return messageRepository.findById(messageId)
                .orElseThrow(MessageNotFoundException::new);
    }

    private Member getMemberByUsername(String username) {
        return memberRepository.findByUsername(username)
                .orElseThrow(MemberNotFoundException::new);
    }
}
