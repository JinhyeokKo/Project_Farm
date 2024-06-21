package farm.community.controller;

import farm.community.dto.MessageDto;
import farm.community.service.MessageService;
import farm.util.ResponseUtil;
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

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/message")
    public ResponseEntity<String> sendMessage(@RequestBody MessageDto messageDto, Authentication authentication) {
        try{
            messageService.sendMessage(messageDto, authentication.getName());
            return ResponseUtil.ok("쪽지 전송 완료");
        } catch (IllegalArgumentException e) {
            return ResponseUtil.badRequest(e.getMessage());
        }
    }

    @GetMapping("/message/received")
    public ResponseEntity<List<MessageDto>> getAllMessages(Authentication authentication) {
        try{
            return ResponseUtil.ok(messageService.getAllMessages(authentication.getName()));
        }catch (IllegalArgumentException e) {
            return ResponseUtil.notFound();
        }
    }

    @GetMapping("/message/sent")
    public ResponseEntity<List<MessageDto>> getSentMessages(Authentication authentication) {
        try{
            return ResponseUtil.ok(messageService.getSentMessages(authentication.getName()));
        }catch (IllegalArgumentException e) {
            return ResponseUtil.notFound();
        }
    }

    @GetMapping("/message/{messageId}")
    public ResponseEntity<MessageDto> getMessage(@PathVariable long messageId, Authentication authentication) {
        try{
            MessageDto messageDto = messageService.getMessage(messageId, authentication.getName());
            return ResponseEntity.ok(messageDto);
        }catch (IllegalArgumentException e) {
            return ResponseUtil.unauthorized();
        }

    }
}
