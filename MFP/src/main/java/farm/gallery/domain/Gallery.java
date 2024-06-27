package farm.gallery.domain;

import farm.member.domain.Member;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Gallery {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Lob
    private byte[] image;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date addDate;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private String status;

    private Gallery(String name, byte[] image, Member member){
        this.name = name;
        this.image = image;
        this.member = member;
    }

    public Gallery() {

    }

    public static Gallery createGallery(String name, byte[] image, Member member){
        return new Gallery(name, image, member);
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public byte[] getImage() {
        return image;
    }

    public Date getAddDate() {
        return addDate;
    }

    public Member getMember() {
        return member;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
