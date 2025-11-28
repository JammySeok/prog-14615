package com.example.prog_14615.domain;

import com.example.prog_14615.domain.post.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class TestController {

    private final PostService postService;

    @GetMapping("/menu")
    public String menu() {
        return "menu";
    }

    // 서버에다 데이터 넘길수 도 있음
    @GetMapping("/param")
    public String param(String name, int age) {

        System.out.println("name = " + name);
        System.out.println("age = " + age);

        return "param";
    }

    @GetMapping("/getHtml")
    @ResponseBody
    public String getHtml(String name) {
        return "<h1 style='color: red'> %s </h1>".formatted(name);
    }

    @GetMapping("/getName")
    public String getName(String name, Model model) {

        model.addAttribute("name", name);

        return "name";
    }

    @GetMapping("/name")
    public String getList(Model model) {
        List<String> list = List.of("홍길동","김철수","박영희");

        model.addAttribute("list", list);

        return "name";
    }
}
