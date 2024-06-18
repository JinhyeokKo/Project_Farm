package farm.gallery.controller;

import farm.gallery.dto.GalleryDto;
import farm.gallery.service.GalleryService;
import farm.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gallery")
public class GalleryController {

    private final GalleryService galleryService;

    @Autowired
    public GalleryController(GalleryService galleryService) {
        this.galleryService = galleryService;
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
}
