package farm.community.dto;

import farm.community.domain.Comment;

public class CommentDto {
    private String comment;
    private String member;
    private Long post;

    public CommentDto() {
    }

    public CommentDto(Comment comment) {
        this.comment = comment.getComment();
        this.member = comment.getMember().getUsername();
        this.post = comment.getPost().getId();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public Long getPost() {
        return post;
    }

    public void setPost(Long post) {
        this.post = post;
    }
}
