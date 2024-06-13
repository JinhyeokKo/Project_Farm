package farm.community.controller;

import farm.community.domain.Comment;
import farm.community.domain.Post;
import farm.community.repository.CommentRepository;
import farm.community.repository.PostRepository;
import farm.member.domain.Member;
import farm.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Transactional
@RestController
public class CommentController {

    private final MemberRepository memberRepository;

    private final CommentRepository commentRepository;

    private final PostRepository postRepository;

    @Autowired
    public CommentController(MemberRepository memberRepository, CommentRepository commentRepository, PostRepository postRepository) {
        this.memberRepository = memberRepository;
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @PostMapping("/comment/{postId}")
    public ResponseEntity<String> comment(@RequestBody Comment comment, @PathVariable Long postId, Authentication authentication) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("해당 포스트가 없습니다."));
        Member member = memberRepository.findByUsername(authentication.getName()).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다."));

        comment.setPost(post);
        comment.setMember(member);
        commentRepository.save(comment);

        return ResponseEntity.ok("댓글 작성 완료");
    }
    
    @DeleteMapping("/comment/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable Long commentId, Authentication authentication) {
        String username = authentication.getName();
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다."));

        if (!comment.getMember().getUsername().equals(username)) {
            throw new IllegalArgumentException("해당 댓글을 삭제할 권한이 없습니다.");
        }
        commentRepository.delete(comment);
        return ResponseEntity.ok("댓글 삭제 완료");
    }

    @PutMapping("/comment/{commentId}")
    public ResponseEntity<String> updateComment(@PathVariable Long commentId, @RequestBody Comment updateComment, Authentication authentication) {
        String username = authentication.getName();
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다."));

        if (!comment.getMember().getUsername().equals(username)) {
            throw new IllegalArgumentException("해당 댓글을 수정할 권한이 없습니다.");
        }

        comment.setContent(updateComment.getContent());
        commentRepository.save(comment);

        return ResponseEntity.ok("댓글 수정 완료");
    }

    @GetMapping("/comments/{commentId}")
    public ResponseEntity<Comment> getComment(@PathVariable Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다."));
        return ResponseEntity.ok(comment);
    }

    @GetMapping("/comments")
    public ResponseEntity<List<Comment>> getAllComments() {
        List<Comment> comments = commentRepository.findAll();
        return ResponseEntity.ok(comments);
    }
}
