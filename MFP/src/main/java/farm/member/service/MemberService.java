package farm.member.service;

import farm.member.domain.Member;
import farm.member.dto.MemberDto;
import farm.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public MemberDto userInfo(String username){
        return userInfoDetails(username);
    }

    private MemberDto userInfoDetails(String username){
        return MemberDto.createMemberDto(getMemberInfo(username));
    }

    public void editUserInfo(MemberDto memberDto, String username){
        editUserInfoDetails(memberDto, getMemberInfo(username));
    }

    private void editUserInfoDetails(MemberDto memberDto, Member member){
        member.setEmail(memberDto.getEmail());
        member.setAddress(memberDto.getAddress());
        member.setPhone(memberDto.getPhone());
        member.setProfileImage(memberDto.getProfileImage());
        memberRepository.save(member);
    }

    private Member getMemberInfo(String username){
        return memberRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
    }

    public void editUserPass(String password, String username){
        editUserPassDetails(password, getMemberInfo(username));
    }

    private void editUserPassDetails(String password, Member member){
        member.setPassword(passwordEncoder.encode(password));
        memberRepository.save(member);
    }
}
