package farm.community.controller;

import farm.community.service.LikeService;
import farm.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LikeController {

    private final LikeService likeService;

    @Autowired
    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping("/like/{postId}")
    public ResponseEntity<String> likePost(@PathVariable long postId, Authentication authentication) {
        likeService.likePost(postId, authentication.getName());
        return ResponseUtil.ok("좋아요 수정 완료");
    }

    @GetMapping("/likes/{postId}")
    public ResponseEntity<Long> getLikeCount(@PathVariable long postId) {
        long count = likeService.likeCount(postId);
        return ResponseEntity.ok(count);
    }
}
