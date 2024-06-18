package farm.gallery.dto;

import farm.gallery.domain.Gallery;

import java.util.Date;

public class GalleryDto {

    private String name;

    private byte[] image;

    private Date addDate;

    private String memberName;

    private GalleryDto(Gallery gallery){
        this.name = gallery.getName();
        this.image = gallery.getImage();
        this.addDate = gallery.getAddDate();
        this.memberName = gallery.getMember().getUsername();
    }

    public static GalleryDto createGalleryDto(Gallery gallery){
        return new GalleryDto(gallery);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
}