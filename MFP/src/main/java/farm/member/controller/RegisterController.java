package farm.member.controller;

import farm.member.dto.MemberDto;
import farm.member.service.RegisterService;
import farm.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Transactional
@RestController
@RequestMapping("/login")
public class RegisterController {

    private final RegisterService registerService;

    @Autowired
    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping("/doubleCheck")
    public ResponseEntity<String> doubleCheck(@RequestParam String username) {
        try {
            boolean check = registerService.doubleCheck(username);
            if (check) {
                return ResponseUtil.conflict("이미 사용중인 아이디입니다.");
            } else {
                return ResponseUtil.ok("사용 가능한 아이디입니다.");
            }
        } catch (Exception e) {
            return ResponseUtil.serverError("아이디 중복 확인 실패");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerMember(@RequestBody MemberDto memberDto) {
        try {
            registerService.registerMember(memberDto);
            return ResponseUtil.created("회원가입 성공");
        } catch (IllegalArgumentException e) {
            return ResponseUtil.badRequest(e.getMessage());
        } catch (Exception e) {
            return ResponseUtil.serverError("회원가입 실패");
        }
    }
}