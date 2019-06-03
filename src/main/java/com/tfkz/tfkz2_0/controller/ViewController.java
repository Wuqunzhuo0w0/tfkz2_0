package com.tfkz.tfkz2_0.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class ViewController {

    @RequestMapping("/main")
    public String toJps(Model model) {
        System.out.println("jinlaila");
        model.addAttribute("welcome", "不建议使用jsp");
        return "/templates/main.html";
    }
    @RequestMapping("/login")
    public String login(Model model) {
        System.out.println("login");
        return "/templates/login.html";
    }
}
