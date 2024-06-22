package com.konar.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showHome() {
        return "home";
    }

    @GetMapping("/leader")
    public String leaderPage() {
        return "leaders";
    }

    @GetMapping("/system")
    public String systemPage() {
        return "system";
    }

}
