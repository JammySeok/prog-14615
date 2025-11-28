package com.example.prog_14615.domain.post.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class PostController {

    private final PostService postService;

    @GetMapping("/post")
    public String post(Model model) {
        List<Post> postList = postService.getList();
        model.addAttribute("postList", postList);

        return "post";
    }
}
