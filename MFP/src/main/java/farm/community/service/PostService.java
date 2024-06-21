package farm.community.service;

import farm.community.domain.Post;
import farm.community.dto.PostDto;
import farm.community.repository.PostRepository;
import farm.member.domain.Member;
import farm.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class PostService {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public PostService(PostRepository postRepository, MemberRepository memberRepository) {
        this.postRepository = postRepository;
        this.memberRepository = memberRepository;
    }

    public void createPost(PostDto createPost, String username) {
        Member member = getMemberByUsername(username);
        createPostDetails(createPost, member);
    }

    private void createPostDetails(PostDto createPost, Member member) {
        postRepository.save(Post.createPost(createPost, member));
    }

    public void updatePost(long postId, PostDto updatedPost, String username) {
        Post post = getPostAndCheckAuthorization(postId, username);
        updatePostDetails(post, updatedPost);
    }

    private void updatePostDetails(Post post, PostDto updatedPost) {
        post.setTitle(updatedPost.getTitle());
        post.setContent(updatedPost.getContent());
        post.setCategory(updatedPost.getCategory());
        postRepository.save(post);
    }

    public void deletePost(long postId, String username) {
        Post post = getPostAndCheckAuthorization(postId, username);
        deletePostDetails(post);
    }

    private void deletePostDetails(Post post) {
        postRepository.delete(post);
    }

    public List<PostDto> getMyPosts(String username) {
        List<Post> posts = postRepository.findAllByCreatedBy(username);
        if (posts.isEmpty()) {
            throw new NoSuchElementException("작성한 게시글이 존재하지 않습니다.");
        }
        return posts.stream().map(PostDto::new).toList();
    }

    public PostDto getPost(long postId) {
        Post post = checkPost(postId);
        postViewCount(post);
        return new PostDto(post);
    }

    private void postViewCount(Post post){
        post.setViewCount(post.getViewCount()+1);
        postRepository.save(post);
    }

    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        if (posts.isEmpty()) {
            throw new NoSuchElementException("게시글이 존재하지 않습니다.");
        }
        return posts.stream().map(PostDto::new).toList();
    }

    private Member getMemberByUsername(String username) {
        return memberRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 존재하지 않습니다."));
    }

    private Post checkPost(long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new NoSuchElementException("해당 게시글이 존재하지 않습니다."));
    }

    private void checkPostAuthorization(Post post, String username) {
        if (!post.getCreatedBy().equals(username)) {
            throw new IllegalCallerException("게시글 수정 권한이 없습니다.");
        }
    }

    private Post getPostAndCheckAuthorization(long postId, String username) {
        Post post = checkPost(postId);
        checkPostAuthorization(post, username);
        return post;
    }
}