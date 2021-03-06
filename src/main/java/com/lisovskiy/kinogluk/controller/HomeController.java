package com.lisovskiy.kinogluk.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Value("Library of games")
    String appName;

    @GetMapping ("/")
    public String homePage (Model model) {
        model.addAttribute("appName", appName);
        return "home";
    }
}
