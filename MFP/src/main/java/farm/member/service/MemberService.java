package farm.member.service;

import farm.member.domain.Member;
import farm.member.dto.MemberDto;
import farm.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerMember(MemberDto memberDto) {
        if (doubleCheck(memberDto.getUsername())) {
            throw new IllegalArgumentException("이미 사용중인 아이디입니다.");
        }
        registerMemberDetails(memberDto);
    }

    private void registerMemberDetails(MemberDto memberDto) {
        memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));
        memberRepository.save(Member.createMember(memberDto));
    }

    public boolean doubleCheck(String username) {
        return memberRepository.findByUsername(username).isPresent();
    }

    public MemberDto userInfo(String username){
        return userInfoDetails(username);
    }
    private MemberDto userInfoDetails(String username){
        Member member = memberRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        return MemberDto.createMemberDto(member);
    }
}