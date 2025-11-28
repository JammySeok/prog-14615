package com.example.prog_14615.domain.post.member;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/save")
    public void save() {
        List<String> memberList = List.of("이름1", "이름2", "이름3");
        memberService.save(memberList);
    }

    @GetMapping("/member")
    public String memberList(Model model) {
        List<Member> list = memberService.getList();
        model.addAttribute("memberList", list);

        return "member";
    }
}
