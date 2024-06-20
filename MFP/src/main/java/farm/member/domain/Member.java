package farm.member.domain;

import farm.community.domain.Comment;
import farm.community.domain.Like;
import farm.community.domain.Message;
import farm.community.domain.Post;
import farm.gallery.domain.Gallery;
import farm.member.dto.MemberDto;
import farm.program.domain.CustomerInfo;
import farm.program.domain.FarmInfo;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    private String name;

    private String email;

    private String phone;

    private String address;

    @Column(columnDefinition = "MEDIUMBLOB")
    @Lob
    private byte[] profileImage;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date regDate;

    @Column(name = "member_role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Post> posts;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Gallery> galleries;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Like> likes;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Comment> comments;

    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Message> messagesSent;

    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Message> messagesReceived;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<FarmInfo> farmInfos;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<CustomerInfo> customerInfos;

    public Member() {

    }

    private Member(MemberDto memberDto) {
        this.username = memberDto.getUsername();
        this.password = memberDto.getPassword();
        this.name = memberDto.getName();
        this.email = memberDto.getEmail();
        this.phone = memberDto.getPhone();
        this.address = memberDto.getAddress();
        this.profileImage = memberDto.getProfileImage();
        this.role = Role.ROLE_CUSTOMER;
    }

    public static Member createMember(MemberDto memberDto) {
        return new Member(memberDto);
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Date getRegDate() {
        return regDate;
    }

    public String getAddress() {
        return address;
    }

    public Role getRole() {
        return role;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public Set<Gallery> getGalleries() {
        return galleries;
    }

    public Set<Like> getLikes() {
        return likes;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public Set<Message> getMessagesSent() {
        return messagesSent;
    }

    public Set<Message> getMessagesReceived() {
        return messagesReceived;
    }

    public Set<FarmInfo> getFarmInfos() {
        return farmInfos;
    }

    public Set<CustomerInfo> getCustomerInfos() {
        return customerInfos;
    }

    public byte[] getProfileImage() {
        return profileImage;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setProfileImage(byte[] profileImage) {
        this.profileImage = profileImage;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
