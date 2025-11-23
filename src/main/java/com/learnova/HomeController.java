package com.learnova;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("institute", "Learnova Teaching Institute");
        model.addAttribute("classes", new int[]{1,2,3,4,5});
        model.addAttribute("subjects", new String[]{"Maths", "English"});
        return "index";
    }
}
