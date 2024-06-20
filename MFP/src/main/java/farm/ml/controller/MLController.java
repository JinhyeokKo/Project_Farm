package farm.ml.controller;

import farm.ml.service.MLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class MLController {

    private final MLService mlService;

    @Autowired
    public MLController(MLService mlService) {
        this.mlService = mlService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        try {
            byte[] imageBytes = file.getBytes(); // MultipartFile을 byte[]로 변환 --> 안드로이드에서 받아오면 바로 byte[]로 db 저장
            // gallery 저장 코드 구현 필요
            String filename = file.getOriginalFilename(); // 원래 파일명 가져옴
            String prediction = mlService.predict(imageBytes, filename); // 예측 요청을 서비스에 전달
            return ResponseEntity.ok(prediction); // 테스트용
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error processing the file"); // 테스트용
        }
    }
}
