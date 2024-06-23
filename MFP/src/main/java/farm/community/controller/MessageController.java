package farm.community.controller;

import farm.community.dto.MessageDto;
import farm.community.service.MessageService;
import farm.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/message")
    public ResponseEntity<String> sendMessage(@RequestBody MessageDto messageDto, Authentication authentication) {
        messageService.sendMessage(messageDto, authentication.getName());
        return ResponseUtil.ok("쪽지 전송 완료");
    }

    @GetMapping("/message/received")
    public ResponseEntity<List<MessageDto>> getAllMessages(Authentication authentication) {
        return ResponseUtil.ok(messageService.getAllMessages(authentication.getName()));
    }

    @GetMapping("/message/sent")
    public ResponseEntity<List<MessageDto>> getSentMessages(Authentication authentication) {
        return ResponseUtil.ok(messageService.getSentMessages(authentication.getName()));
    }

    @GetMapping("/message/{messageId}")
    public ResponseEntity<MessageDto> getMessage(@PathVariable long messageId, Authentication authentication) {
        MessageDto messageDto = messageService.getMessage(messageId, authentication.getName());
        return ResponseEntity.ok(messageDto);
    }
}
