package farm.community.controller;

import farm.community.dto.CommentDto;
import farm.community.service.CommentService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/comment/{postId}")
    public ResponseEntity<String> comment(@RequestParam("comment") String comment, @PathVariable("postId") long postId, Authentication authentication) {
        commentService.comment(comment, postId, authentication.getName());
        return ResponseUtil.ok("댓글 작성 완료");
    }

    @DeleteMapping("/comment/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable("commentId") long commentId, Authentication authentication) {
        commentService.deleteComment(commentId, authentication.getName());
        return ResponseUtil.ok("댓글 삭제 완료");
    }

    @PutMapping("/comment/{commentId}")
    public ResponseEntity<String> updateComment(@PathVariable("commentId") long commentId, @RequestBody String updateComment, Authentication authentication) {
        commentService.updateComment(commentId, updateComment, authentication.getName());
        return ResponseUtil.ok("댓글 수정 완료");
    }

    @GetMapping("/comments/comment/{commentId}")
    public ResponseEntity<CommentDto> getComment(@PathVariable("commentId") long commentId) {
        return ResponseUtil.ok(commentService.getComment(commentId));

    }

    @GetMapping("/comments/post/{postId}")
    public ResponseEntity<List<CommentDto>> getPostComment(@PathVariable("postId") long postId){
        return ResponseUtil.ok(commentService.getPostComment(postId));
    }

    @GetMapping("/comments")
    public ResponseEntity<List<CommentDto>> getAllComments() {
        return ResponseUtil.ok(commentService.getAllComments());

    }
}
