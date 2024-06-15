package farm.community.dto;

import farm.community.domain.Comment;
import farm.community.domain.Post;
import farm.member.domain.Member;

public class CommentDto {
    private String content;
    private Member member;
    private Post post;

    public CommentDto() {
    }

    public CommentDto(Comment comment) {
        this.content = comment.getContent();
        this.member = comment.getMember();
        this.post = comment.getPost();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
