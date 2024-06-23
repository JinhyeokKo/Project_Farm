package farm.community.service;

import farm.community.domain.Like;
import farm.community.domain.Post;
import farm.community.repository.LikeRepository;
import farm.community.repository.PostRepository;
import farm.error.exception.MemberNotFoundException;
import farm.error.exception.PostNotFoundException;
import farm.member.domain.Member;
import farm.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
public class LikeService {
    private final LikeRepository likeRepository;

    private final PostRepository postRepository;

    private final MemberRepository memberRepository;

    @Autowired
    public LikeService(LikeRepository likeRepository, PostRepository postRepository, MemberRepository memberRepository) {
        this.likeRepository = likeRepository;
        this.postRepository = postRepository;
        this.memberRepository = memberRepository;
    }

    public void likePost(long postId, String username) {
        Post post = checkPost(postId);
        Member member = checkMember(username);
        likePostDetails(post, member);
    }

    private void likePostDetails(Post post, Member member) {
        Optional<Like> like = likeRepository.findByPostAndMember(post, member);

        if (like.isPresent()) {
            likeRepository.delete(like.get());
        } else {
            likeRepository.save(Like.createLike(post, member));
        }
    }

    public long likeCount(long postId) {
        Post post = checkPost(postId);
        return likeCountDetails(post);
    }

    private long likeCountDetails(Post post) {
        return likeRepository.countByPost(post);
    }

    private Post checkPost(long postId) {
        return postRepository.findById(postId)
                .orElseThrow(PostNotFoundException::new);
    }

    private Member checkMember(String username) {
        return memberRepository.findByUsername(username)
                .orElseThrow(MemberNotFoundException::new);
    }
}