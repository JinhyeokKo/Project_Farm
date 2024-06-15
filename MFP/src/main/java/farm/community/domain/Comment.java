package farm.community.domain;

import farm.member.domain.Member;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Table(name = "comments")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date commentDate;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Comment() {
    }

    public static Comment createComment(String comment, Post post, Member member) {
        return new Comment(comment, post, member);
    }

    private Comment(String comment, Post post, Member member) {
        this.content = comment;
        this.member = member;
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public Member getMember() {
        return member;
    }

    public Post getPost() {
        return post;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
