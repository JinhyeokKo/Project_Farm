package farm.community.controller;

import farm.community.dto.PostDto;
import farm.community.service.PostService;
import farm.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }


    @PostMapping("/post")
    public ResponseEntity<String> createPost(@RequestBody PostDto createPost, Authentication authentication) {
        postService.createPost(createPost, authentication.getName());
        return ResponseUtil.created("게시글이 성공적으로 작성되었습니다.");
    }

    @PutMapping("/post/{postId}")
    public ResponseEntity<String> updatePost(@PathVariable("postId") long postId, @RequestBody PostDto updatedPost, Authentication authentication) {
        postService.updatePost(postId, updatedPost, authentication.getName());
        return ResponseUtil.ok("게시글이 성공적으로 수정되었습니다.");
    }

    @DeleteMapping("/post/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable("postId") long postId, Authentication authentication) {
        postService.deletePost(postId, authentication.getName());
        return ResponseUtil.ok("게시글이 성공적으로 삭제되었습니다.");

    }

    @GetMapping("/post")
    public ResponseEntity<List<PostDto>> getMyPosts(Authentication authentication) {
        return ResponseUtil.ok(postService.getMyPosts(authentication.getName()));

    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto> getPost(@PathVariable("postId") long postId) {
        return ResponseUtil.ok(postService.getPost(postId));
    }

    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> getAllPosts() {
        return ResponseUtil.ok(postService.getAllPosts());

    }
}