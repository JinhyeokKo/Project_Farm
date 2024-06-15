package farm.community.domain;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@Table(name = "reports")
@EntityListeners(AuditingEntityListener.class)
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reason;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date reportDate;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Report() {
    }

    public static Report createReport(String reason, Post post) {
        return new Report(reason, post);
    }

    private Report(String reason, Post post) {
        this.reason = reason;
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public String getReason() {
        return reason;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public Post getPost() {
        return post;
    }
}
