package farm.community.repository;

import farm.community.domain.Like;
import farm.community.domain.Post;
import farm.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findByPostAndMember(Post post, Member member);
    Long countByPost(Post post);
}
