package farm.community.controller;

import farm.community.domain.Post;
import farm.community.domain.Report;
import farm.community.repository.PostRepository;
import farm.community.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Transactional
@RestController
public class ReportController {

    private final ReportRepository reportRepository;

    private final PostRepository postRepository;

    @Autowired
    public ReportController(ReportRepository reportRepository, PostRepository postRepository) {
        this.reportRepository = reportRepository;
        this.postRepository = postRepository;
    }

    @PostMapping("/report/{postId}")
    public ResponseEntity<String> report(@RequestBody Report report, @PathVariable Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
        report.setPost(post);
        reportRepository.save(report);
        return ResponseEntity.status(HttpStatus.CREATED).body("신고 완료");
    }
}
