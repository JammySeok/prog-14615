package com.example.prog_14615.domain.wise;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class WiseController {

    private final WiseService wiseService;

    @GetMapping("/wise")
    public String wise(Model model) {
        List<Wise> wiseList = wiseService.getList();
        model.addAttribute("wiseList", wiseList);

        return "wise";
    }

    @PostMapping("/wise/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        wiseService.delete(id);

        return "redirect:/wise";
    }

    // Transactional 작동 테스트용
    @PostMapping("/wise/deleteOneTwoThree")
    public String deleteOneTwoThree() {
        wiseService.deleteOneTwoThree();
        return "redirect:/wise";
    }
}
