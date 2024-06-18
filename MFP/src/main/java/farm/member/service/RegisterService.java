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
public class RegisterService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegisterService(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerMember(MemberDto memberDto, byte[] profileImage) {
        if (doubleCheck(memberDto.getUsername())) {
            throw new IllegalArgumentException("이미 사용중인 아이디입니다.");
        }
        registerMemberDetails(memberDto, profileImage);
    }

    private void registerMemberDetails(MemberDto memberDto, byte[] profileImage) {
        memberDto.setProfileImage(profileImage);
        memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));
        memberRepository.save(Member.createMember(memberDto));
    }

    public boolean doubleCheck(String username) {
        return memberRepository.findByUsername(username).isPresent();
    }
}