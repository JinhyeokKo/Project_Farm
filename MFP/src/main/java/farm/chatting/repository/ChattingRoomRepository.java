package farm.chatting.repository;

import farm.chatting.domain.ChattingRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// ChattingRoom 엔티티에 대한 데이터 접근 인터페이스
@Repository
public interface ChattingRoomRepository extends JpaRepository<ChattingRoom, Long> {
    Optional<ChattingRoom> findByUser1AndUser2(String user1, String user2);
    Optional<ChattingRoom> findByRoomId(String roomId);
}