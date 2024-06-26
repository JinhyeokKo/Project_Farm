package farm.chatting.controller;

import farm.chatting.domain.ChattingRoom;
import farm.chatting.dto.ChattingDto;
import farm.chatting.service.ChattingService;
import farm.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chatting")
public class ChattingController {

    private final ChattingService chattingService;
    private final SimpMessageSendingOperations messagingTemplate;
    private static final Logger logger = LoggerFactory.getLogger(ChattingController.class);

    @Autowired
    public ChattingController(ChattingService chattingService, SimpMessageSendingOperations messagingTemplate) {
        this.chattingService = chattingService;
        this.messagingTemplate = messagingTemplate;
    }

    // 메시지 전송 처리
    @MessageMapping("/sendMessage")
    @SendTo("/topic/messageStatus")
    public String sendMessage(@Payload ChattingDto chattingDto) {
        try {
            chattingService.sendMessage(chattingDto);
            logger.info("메시지 전송 성공: {}", chattingDto);
            return "success";
        } catch (IllegalArgumentException e) {
            logger.error("메시지 전송 중 오류 발생: {}", e.getMessage());
            messagingTemplate.convertAndSend("/topic/errors", e.getMessage());
            return "error";
        } catch (Exception e) {
            logger.error("메시지 전송 중 예상치 못한 오류 발생", e);
            messagingTemplate.convertAndSend("/topic/errors", "메시지 전송 중 오류가 발생했습니다.");
            return "error";
        }
    }

    // 새로운 채팅방을 생성
    @PostMapping("/chattingroom")
    public ResponseEntity<?> createChattingRoom(@RequestParam String user1, @RequestParam String user2) {
        try {
            ChattingRoom room = chattingService.createChattingRoom(user1, user2);
            return ResponseUtil.ok(room);
        } catch (IllegalArgumentException e) {
            return ResponseUtil.badRequest(e.getMessage());
        } catch (Exception e) {
            return ResponseUtil.serverError("채팅방 생성 중 오류가 발생했습니다.");
        }
    }
}