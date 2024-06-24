package farm.member.controller;

import farm.member.dto.MemberDto;
import farm.member.service.MemberService;
import farm.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/userInfo")
    public ResponseEntity<MemberDto> userInfo(Authentication authentication) {
        return ResponseUtil.ok(memberService.userInfo(authentication.getName()));
    }

    @PostMapping("/editUserInfo")
    public ResponseEntity<String> editUserInfo(@RequestBody MemberDto memberDto, Authentication authentication){
            memberService.editUserInfo(memberDto, authentication.getName());
            return ResponseUtil.ok("회원정보 수정이 완료되었습니다.");
    }

    @PostMapping("/editUserPass")
    public ResponseEntity<String> editUserPass(@RequestParam("password") String password, Authentication authentication){
            memberService.editUserPass(password, authentication.getName());
            return ResponseUtil.ok("비밀번호 수정이 완료되었습니다.");
    }
    @DeleteMapping("/deleteUser")
    public ResponseEntity<String> deleteUser(Authentication authentication){
        memberService.deleteUser((authentication.getName()));
        return ResponseUtil.ok("회원탈퇴가 완료되었습니다.");
    }
}
