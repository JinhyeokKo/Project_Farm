package com.project.android_connected.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Base64;
import java.util.UUID;

@RestController
public class ImageUploadController {

    @PostMapping("/upload")
    public String uploadImage(@RequestBody String base64String) {
        // 업로드 디렉토리 경로 설정 (EC2 인스턴스 내부 경로)
        String uploadDir = "/home/ubuntu/uploadedImages";

        // Base64 문자열을 바이트 배열로 디코딩
        byte[] decodedBytes = Base64.getDecoder().decode(base64String);

        // 고유한 파일명 생성
        String fileName = UUID.randomUUID().toString() + ".png";
        Path filePath = Paths.get(uploadDir, fileName);

        try {
            // 디코딩된 바이트 배열을 파일로 저장
            Files.write(filePath, decodedBytes, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to save image";
        }

        return "Image uploaded successfully";
    }
}