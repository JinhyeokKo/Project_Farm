package farm.community.domain;

import farm.community.dto.PostDto;
import farm.member.domain.Member;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "posts")
@EntityListeners(AuditingEntityListener.class)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    private String title;

    private String content;

    private String createdBy;

    private int viewCount;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date postDate;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    private String category;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Like> likes = new HashSet<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Report> reports = new HashSet<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments = new HashSet<>();

    public Post() {
    }

    public static Post createPost(PostDto postDto, Member member){
        return new Post(postDto, member);
    }

    private Post(PostDto postDto, Member member){
        this.title = postDto.getTitle();
        this.content = postDto.getContent();
        this.createdBy = member.getUsername();
        this.category = postDto.getCategory();
        this.member = member;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public int getViewCount() {
        return viewCount;
    }

    public Date getPostDate() {
        return postDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public String getCategory() {
        return category;
    }

    public Member getMember() {
        return member;
    }

    public Set<Like> getLikes() {
        return likes;
    }

    public Set<Report> getReports() {
        return reports;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
