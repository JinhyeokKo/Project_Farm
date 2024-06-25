package farm.chatting.service;

import farm.chatting.domain.ChattingMessage;
import farm.chatting.domain.ChattingRoom;
import farm.chatting.dto.ChattingDto;
import farm.chatting.repository.ChattingRoomRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Transactional
public class ChattingService {

    private final SimpMessageSendingOperations messagingTemplate;
    private final ChattingRoomRepository chattingRoomRepository;
    private static final Logger logger = LoggerFactory.getLogger(ChattingService.class);

    @Autowired
    public ChattingService(SimpMessageSendingOperations messagingTemplate, ChattingRoomRepository chattingRoomRepository) {
        this.messagingTemplate = messagingTemplate;
        this.chattingRoomRepository = chattingRoomRepository;
    }

    // 메시지 전송 처리
    public void sendMessage(ChattingDto chattingDto) {
        logger.info("Sending message: {}", chattingDto);
        String roomId = chattingDto.getRoomId();
        ChattingRoom chattingRoom = findChattingRoomById(roomId);

        ChattingMessage message = createChattingMessage(chattingDto);
        messagingTemplate.convertAndSend("/topic/room/" + roomId, message);
    }

    // 새로운 채팅방 생성 또는 기존 채팅방 반환
    public ChattingRoom createChattingRoom(String user1, String user2) {
        logger.info("Creating chatting room for users: {} and {}", user1, user2);
        ChattingRoom existingRoom = findExistingRoom(user1, user2);
        if (existingRoom != null) {
            logger.info("Found existing room: {}", existingRoom);
            return existingRoom;
        }
        return createNewChattingRoom(user1, user2);
    }

    // 채팅방을 ID로 찾음
    private ChattingRoom findChattingRoomById(String roomId) {
        return chattingRoomRepository.findByRoomId(roomId)
                .orElseThrow(() -> new IllegalArgumentException("채팅방을 찾을 수 없습니다."));
    }

    // 기존 채팅방을 찾음
    private ChattingRoom findExistingRoom(String user1, String user2) {
        return chattingRoomRepository.findByUser1AndUser2(user1, user2)
                .orElse(chattingRoomRepository.findByUser1AndUser2(user2, user1)
                        .orElse(null));
    }

    // 새 채팅방을 생성
    private ChattingRoom createNewChattingRoom(String user1, String user2) {
        ChattingRoom newRoom = ChattingRoom.builder()
                .user1(user1)
                .user2(user2)
                .build();
        ChattingRoom savedRoom = chattingRoomRepository.save(newRoom);
        logger.info("Created new room: {}", savedRoom);
        return savedRoom;
    }

    // ChattingMessage 객체를 생성
    private ChattingMessage createChattingMessage(ChattingDto chattingDto) {
        return ChattingMessage.builder()
                .roomId(chattingDto.getRoomId())
                .content(chattingDto.getContent())
                .sender(chattingDto.getSender())
                .receiver(chattingDto.getReceiver())
                .type(ChattingMessage.MessageType.CHAT)
                .timestamp(LocalDateTime.now())
                .build();
    }
}