package farm.community.controller;

import farm.community.domain.Like;
import farm.community.domain.Post;
import farm.community.repository.LikeRepository;
import farm.community.repository.PostRepository;
import farm.member.domain.Member;
import farm.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Transactional
@RestController
public class LikeController {

    private final LikeRepository likeRepository;

    private final PostRepository postRepository;

    private final MemberRepository memberRepository;

    @Autowired
    public LikeController(LikeRepository likeRepository, PostRepository postRepository, MemberRepository memberRepository) {
        this.likeRepository = likeRepository;
        this.postRepository = postRepository;
        this.memberRepository = memberRepository;
    }

    @PostMapping("/like/{postId}")
    public ResponseEntity<Void> likePost(@PathVariable Long postId, Authentication authentication) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("해당 포스트가 없습니다."));
        Member member = memberRepository.findByUsername(authentication.getName()).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다."));

        Optional<Like> like = likeRepository.findByPostAndMember(post, member);

        if (like.isPresent()) {
            likeRepository.delete(like.get());
        } else {
            Like newLike = new Like();
            newLike.setPost(post);
            newLike.setMember(member);
            likeRepository.save(newLike);
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/likes/{postId}")
    public ResponseEntity<Long> getLikeCount(@PathVariable Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("해당 포스트가 없습니다."));
        return ResponseEntity.ok(likeRepository.countByPost(post));
    }

}
