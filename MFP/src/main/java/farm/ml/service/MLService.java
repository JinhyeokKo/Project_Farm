package farm.ml.service;

import farm.gallery.domain.Gallery;
import farm.gallery.repository.GalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.NoSuchElementException;

@Service
public class MLService {

    private final WebClient webClient;
    private final GalleryRepository galleryRepository;

    // flask 와 통신할 수 있도록 webclient 초기화
    @Autowired
    public MLService(WebClient.Builder webClientBuilder, GalleryRepository galleryRepository) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:5000").build();
        this. galleryRepository = galleryRepository;
    }

    public String predict(byte[] imageBytes, String filename) {
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>(); // 멀티파트 데이터 전송을 위한 폼 데이터 준비
        body.add("file", new ByteArrayResource(imageBytes) { // ByteArrayResource를 사용하여 byte[] 데이터를 리소스로 변환

            @Override
            public String getFilename() {
                return filename;
            }

            @Override
            public long contentLength() {
                return imageBytes.length;
            }
        });

        // WebClient를 사용하여 POST 요청을 보내고, 결과를 문자열로 반환
        return this.webClient.post()
                .uri("/predict") // Flask 서버의 예측 엔드포인트 설정
                .contentType(MediaType.MULTIPART_FORM_DATA) // 요청의 콘텐츠 타입을 멀티파트 폼 데이터로 설정
                .body(BodyInserters.fromMultipartData(body)) // 요청의 본문을 멀티파트 데이터로 설정
                .retrieve() // 요청을 전송하고 응답을 받음
                .bodyToMono(String.class) // 응답 본문을 문자열로 변환
                .block(); // 동기식으로 결과를 기다림
    }

    public void saveStatus(String prediction, String filename) {
        Gallery gallery = findGallery(filename);
        gallery.setStatus(prediction);
        galleryRepository.save(gallery);
    }

    private Gallery findGallery(String filename){
        return galleryRepository.findByName(filename)
                .orElseThrow(() -> new NoSuchElementException("찾을 수 없음"));
    }
}
