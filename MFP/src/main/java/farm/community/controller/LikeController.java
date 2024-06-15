package farm.community.controller;

import farm.community.service.LikeService;
import farm.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;


@Transactional
@RestController
public class LikeController {

    private final LikeService likeService;

    @Autowired
    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping("/like/{postId}")
    public ResponseEntity<String> likePost(@PathVariable long postId, Authentication authentication) {
        try {
            likeService.likePost(postId, authentication.getName());
            return ResponseUtil.ok("좋아요 수정 완료");
        } catch (NoSuchElementException e) {
            return ResponseUtil.notFound(e.getMessage());
        } catch (IllegalArgumentException e) {
            return ResponseUtil.badRequest(e.getMessage());
        }
    }

    @GetMapping("/likes/{postId}")
    public ResponseEntity<Long> getLikeCount(@PathVariable long postId) {
        try {
            long count = likeService.likeCount(postId);
            return ResponseEntity.ok(count);
        } catch (NoSuchElementException e) {
            return ResponseUtil.notFound();
        }
    }
}
