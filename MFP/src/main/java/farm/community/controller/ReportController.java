package farm.community.controller;

import farm.community.service.ReportService;
import farm.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController {

    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping("/report/{postId}")
    public ResponseEntity<String> report(@RequestParam String reason, @PathVariable long postId) {
        reportService.report(reason, postId);
        return ResponseUtil.created("신고가 성공적으로 접수되었습니다.");

    }
}
