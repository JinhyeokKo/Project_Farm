package farm.community.repository;

import farm.community.domain.Message;
import farm.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByReceiver(Member member);
    List<Message> findBySender(Member member);
}
