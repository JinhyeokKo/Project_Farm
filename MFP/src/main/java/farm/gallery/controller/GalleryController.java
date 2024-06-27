package farm.gallery.controller;

import farm.gallery.dto.GalleryDto;
import farm.gallery.service.GalleryService;
import farm.ml.controller.MLController;
import farm.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/gallery")
public class GalleryController {

    private final MLController mlController;
    private final GalleryService galleryService;

    @Autowired
    public GalleryController(GalleryService galleryService, MLController mlController) {
        this.galleryService = galleryService;
        this.mlController = mlController;
    }

    @PostMapping("/save")
    public void saveGallery(byte[] image, String name, String memberName){
        try{
            galleryService.saveGallery(image, name, memberName);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        } catch(Exception e){
            throw new RuntimeException("갤러리 저장에 실패했습니다.");
        }

    }

    @PostMapping("/get")
    public ResponseEntity<GalleryDto> getGallery(String name, Authentication authentication){
        try{
            return ResponseUtil.ok(galleryService.getGallery(name, authentication.getName()));
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        } catch(Exception e){
            throw new RuntimeException("갤러리 조회에 실패했습니다.");
        }
    }

    @PostMapping("/test")
    public void handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
            byte[] imageBytes = file.getBytes(); // MultipartFile을 byte[]로 변환 --> 안드로이드에서 받아오면 바로 byte[]로 db 저장
            // gallery 저장 코드 구현 필요
            String filename = file.getOriginalFilename(); // 원래 파일명 가져옴
            galleryService.saveGallery(imageBytes, filename, "qwer");
    }

    @PostMapping("/upload")
    public String uploadImage(@RequestBody String base64String) {
        // 업로드 디렉토리 경로 설정 (EC2 인스턴스 내부 경로)
        //String uploadDir = "/home/ubuntu/uploadedImages";
        String uploadDir = "./farm/gallery/img";

        // 고유한 파일명 생성
        String fileName = UUID.randomUUID().toString() + ".png";
        Path filePath = Paths.get(uploadDir, fileName);


        // Base64 문자열을 바이트 배열로 디코딩
        byte[] decodedBytes = Base64.getDecoder().decode(base64String);

        galleryService.saveGallery(decodedBytes, fileName, "qwer");

        try {
            // 디코딩된 바이트 배열을 파일로 저장
            Files.write(filePath, decodedBytes, StandardOpenOption.CREATE);
            mlController.handleFileUpload(decodedBytes, fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to save image";
        }

        return "Image uploaded successfully";
    }

    @GetMapping("/convert-to-gif")
    public ResponseEntity<byte[]> convertToGif(@RequestParam List<Long> ids) {
        try {
            byte[] gifData = galleryService.convertImagesToGif(ids);

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, "image/gif");

            return new ResponseEntity<>(gifData, headers, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
