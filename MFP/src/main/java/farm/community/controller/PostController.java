package farm.community.controller;

import farm.community.domain.Post;
import farm.community.repository.PostRepository;
import farm.member.domain.Member;
import farm.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
public class PostController {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public PostController(PostRepository postRepository, MemberRepository memberRepository) {
        this.postRepository = postRepository;
        this.memberRepository = memberRepository;
    }

    @PostMapping("/post")
    public ResponseEntity<String> createPost(@RequestBody Post post, Authentication authentication) {

        Post savedPost;
        ResponseEntity<String> response = null;

        try{
            String username = authentication.getName();

            Member member = memberRepository.findByUsername(username)
                    .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 존재하지 않습니다."));
            post.setMember(member);
            post.setCreatedBy(member.getUsername());

            savedPost = postRepository.save(post);

            if(savedPost.getId() > 0){
                response = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("게시글 작성 완료");
            }
        }catch(Exception e){
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("게시글 작성 실패" + e.getMessage());
        }
        return response;
    }

    @PutMapping("/post/{postId}")
    public ResponseEntity<String> updatePost(@PathVariable Long postId, @RequestBody Post updatedPost, Authentication authentication) {

        String username = authentication.getName();

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));

        if (!post.getCreatedBy().equals(username)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("게시글 수정 권한이 없습니다.");
        }

        post.setTitle(updatedPost.getTitle());
        post.setContent(updatedPost.getContent());
        post.setCategory(updatedPost.getCategory());
        postRepository.save(post);

        return ResponseEntity.ok("게시글이 성공적으로 수정되었습니다.");
    }

    @DeleteMapping("/post/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable Long postId, Authentication authentication) {

        String username = authentication.getName();

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));

        if (!post.getCreatedBy().equals(username)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("게시글 삭제 권한이 없습니다.");
        }

        postRepository.delete(post);
        return ResponseEntity.ok("게시글이 성공적으로 삭제되었습니다.");
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<Post> getPost(@PathVariable Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
        return ResponseEntity.ok(post);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getAllPosts(){
        List<Post> posts = postRepository.findAll();
        return ResponseEntity.ok(posts);
    }
}
