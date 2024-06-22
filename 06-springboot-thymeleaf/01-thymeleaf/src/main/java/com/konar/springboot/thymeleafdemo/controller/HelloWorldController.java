package com.konar.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    @RequestMapping("/processFormV2")
    public String shoutOutDude(HttpServletRequest request, Model theModel) {

        String name = request.getParameter("studentName");

        name = name.toUpperCase();

        theModel.addAttribute("message", name);

        return "helloworld";
    }

    @RequestMapping("/processFormV3")
    public String processFormV3(@RequestParam("studentName") String name, Model theModel) {
        name = name.toUpperCase();

        theModel.addAttribute("message", name);

        return "helloworld";
    }

}
