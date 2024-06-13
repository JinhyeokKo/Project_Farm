package farm.community.controller;

import farm.community.domain.Message;
import farm.community.repository.MessageRepository;
import farm.member.domain.Member;
import farm.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Transactional
@RestController
public class MessageController {

    private final MessageRepository messageRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public MessageController(MessageRepository messageRepository, MemberRepository memberRepository) {
        this.messageRepository = messageRepository;
        this.memberRepository = memberRepository;
    }

    @PostMapping("/message")
    public ResponseEntity<String> sendMessage(@RequestBody Message message, Authentication authentication) {

        Member sender = memberRepository.findByUsername(authentication.getName())
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 존재하지 않습니다."));

        Member receiver = memberRepository.findByUsername(message.getReceiver().getUsername())
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 존재하지 않습니다."));

        message.setSender(sender);
        message.setReceiver(receiver);
        messageRepository.save(message);

        return ResponseEntity.ok("쪽지 전송 완료");
    }

    @GetMapping("/message/received")
    public ResponseEntity<List<Message>> getAllMessages(Authentication authentication) {

        Member member = memberRepository.findByUsername(authentication.getName())
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 존재하지 않습니다."));

        List<Message> messages = messageRepository.findByReceiver(member);

        return ResponseEntity.ok(messages);
    }

    @GetMapping("/message/sent")
    public ResponseEntity<List<Message>> getSentMessages(Authentication authentication) {

        Member member = memberRepository.findByUsername(authentication.getName())
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 존재하지 않습니다."));

        List<Message> messages = messageRepository.findBySender(member);

        return ResponseEntity.ok(messages);
    }

    @GetMapping("/message/{messageId}")
    public ResponseEntity<Message> getMessage(@PathVariable Long messageId, Authentication authentication) {

        Message message = messageRepository.findById(messageId)
                .orElseThrow(() -> new IllegalArgumentException("해당 메시지가 존재하지 않습니다."));

        if(!message.getReceiver().getUsername().equals(authentication.getName()) || !message.getSender().getUsername().equals(authentication.getName())){
            throw new IllegalArgumentException("해당 메시지를 볼 권한이 없습니다.");
        }

        return ResponseEntity.ok(message);
    }
}
