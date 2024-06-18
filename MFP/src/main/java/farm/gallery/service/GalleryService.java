package farm.gallery.service;

import farm.gallery.domain.Gallery;
import farm.gallery.dto.GalleryDto;
import farm.gallery.repository.GalleryRepository;
import farm.member.domain.Member;
import farm.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GalleryService {

    private final GalleryRepository galleryRepository;

    private final MemberRepository memberRepository;

    @Autowired
    public GalleryService(GalleryRepository galleryRepository, MemberRepository memberRepository) {
        this.galleryRepository = galleryRepository;
        this.memberRepository = memberRepository;
    }

    public void saveGallery(byte[] image, String name, String memberName){
        Member member = findMember(memberName);
        saveGalleryDetails(image, name, member);
    }

    private void saveGalleryDetails(byte[] image, String name, Member member){
        galleryRepository.save(Gallery.createGallery(name, image, member));
    }

    public GalleryDto getGallery(String name, String memberName){
        Member member = findMember(memberName);
        Gallery gallery = findGallery(name, member);
        return getGalleryDetails(gallery);
    }

    private GalleryDto getGalleryDetails(Gallery gallery){
        return GalleryDto.createGalleryDto(gallery);
    }

    private Gallery findGallery(String name, Member member){
        return galleryRepository.findByName(name)
                .filter(gallery -> gallery.getMember().equals(member))
                .orElseThrow(() -> new IllegalArgumentException("해당 갤러리가 존재하지 않습니다."));
    }

    private Member findMember(String memberName){
        return memberRepository.findByUsername(memberName)
                .orElseThrow(() -> new IllegalArgumentException("해당 회원이 존재하지 않습니다."));
    }
}
