package farm.community.service;

import farm.community.domain.Comment;
import farm.community.domain.Post;
import farm.community.dto.CommentDto;
import farm.community.repository.CommentRepository;
import farm.community.repository.PostRepository;
import farm.error.exception.CommentNotFoundException;
import farm.error.exception.MemberNotFoundException;
import farm.error.exception.NoPermissionException;
import farm.error.exception.PostNotFoundException;
import farm.member.domain.Member;
import farm.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CommentService {

    private final MemberRepository memberRepository;
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Autowired
    public CommentService(MemberRepository memberRepository, CommentRepository commentRepository, PostRepository postRepository) {
        this.memberRepository = memberRepository;
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    public void comment(String comment, Long postId, String username) {
        Post post = findPost(postId);
        Member member = findMember(username);
        commentDetails(comment, post, member);
    }

    private void commentDetails(String comment, Post post, Member member) {
        commentRepository.save(Comment.createComment(comment, post, member));
    }

    public void deleteComment(Long commentId, String username) {
        Comment comment = findComment(commentId);
        commentAuth(comment, username);
        deleteCommentDetails(comment);
    }

    private void deleteCommentDetails(Comment comment) {
        commentRepository.delete(comment);
    }

    public void updateComment(Long commentId, String updateComment, String username) {
        Comment comment = findComment(commentId);
        commentAuth(comment, username);
        updateCommentDetails(comment, updateComment);
    }

    private void updateCommentDetails(Comment comment, String updateComment) {
        comment.setComment(updateComment);
        commentRepository.save(comment);
    }

    public CommentDto getComment(long commentId) {
        findComment(commentId);
        return getCommentDetails(commentId);
    }

    private CommentDto getCommentDetails(long commentId) {
        return new CommentDto(commentRepository.findById(commentId)
                .orElseThrow(CommentNotFoundException::new));
    }

    public List<CommentDto> getPostComment(long postId){
        return getPostCommentDetails(findPost(postId));
    }

    private List<CommentDto> getPostCommentDetails(Post post){
        return post.getComments().stream().map(CommentDto::new).toList();
    }

    public List<CommentDto> getAllComments() {
        return getAllCommentsDetails();
    }

    private List<CommentDto> getAllCommentsDetails() {
        return commentRepository.findAllByOrderByIdAsc().stream().map(CommentDto::new).toList();
    }

    private Post findPost(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(PostNotFoundException::new);
    }

    private Member findMember(String username) {
        return memberRepository.findByUsername(username)
                .orElseThrow(MemberNotFoundException::new);
    }

    private Comment findComment(Long commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(CommentNotFoundException::new);
    }

    private void commentAuth(Comment comment, String username) {
        if (!comment.getMember().getUsername().equals(username)) {
            throw new NoPermissionException();
        }
    }
}
