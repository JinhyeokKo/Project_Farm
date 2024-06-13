package farm.member.controller;

import farm.member.domain.Member;
import farm.member.domain.Role;
import farm.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Transactional
@RestController
public class MemberController {

    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public MemberController(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login/doubleCheck")
    public ResponseEntity<String> doubleCheck(@RequestParam String username) {
        boolean check = memberRepository.findByUsername(username).isPresent();
        if(check){
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("중복된 아이디입니다.");
        } else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("사용 가능한 아이디입니다.");
        }
    }

    @PostMapping("/login/register")
    public ResponseEntity<String> registerMember(@RequestBody Member member) {
        Member savedMember;
        ResponseEntity<String> response = null;
        try {
            String hashPassword = passwordEncoder.encode(member.getPassword());
            member.setPassword(hashPassword);
            member.setRole(Role.ROLE_CUSTOMER);
            savedMember = memberRepository.save(member);
            if(savedMember.getId() > 0) {
                response = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("회원가입 완료");
            }
        } catch (Exception e) {
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("회원가입 실패 : " + e.getMessage());
        }
        return response;
    }

    @GetMapping("/login/loginCheck")
    public ResponseEntity<String> loginCheck(@RequestParam String username, @RequestParam String password) {
        Optional<Member> optionalMember = memberRepository.findByUsername(username);

        if (optionalMember.isPresent()) {
            Member member = optionalMember.get();
            boolean passwordMatches = passwordEncoder.matches(password, member.getPassword());
            if (passwordMatches) {
                return ResponseEntity.ok("로그인 성공");
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("아이디 또는 비밀번호가 잘못되었습니다.");
    }

}

