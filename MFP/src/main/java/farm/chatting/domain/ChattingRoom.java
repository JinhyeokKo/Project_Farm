package farm.chatting.domain;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "chattingrooms")
public class ChattingRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomId;
    private String user1;
    private String user2;

    // private 생성자
    // 범용 고유 식별자 UUID 표준 > 중복가능성 거의 없음.
    private ChattingRoom(String user1, String user2) {
        this.roomId = UUID.randomUUID().toString();
        this.user1 = user1;
        this.user2 = user2;
    }

    // JPA를 위한 기본 생성자
    protected ChattingRoom() {}

    // Getters
    public Long getId() { return id; }
    public String getRoomId() { return roomId; }
    public String getUser1() { return user1; }
    public String getUser2() { return user2; }

    // Builder 클래스
    public static class Builder {
        private String user1;
        private String user2;

        public Builder user1(String user1) { this.user1 = user1; return this; }
        public Builder user2(String user2) { this.user2 = user2; return this; }

        public ChattingRoom build() {
            return new ChattingRoom(user1, user2);
        }
    }

//    @Override
//    public String toString() {
//        return "ChattingRoom{" +
//                "id=" + id +
//                ", roomId='" + roomId + '\'' +
//                ", user1='" + user1 + '\'' +
//                ", user2='" + user2 + '\'' +
//                '}';
//    }

    public static Builder builder() {
        return new Builder();
    }
}