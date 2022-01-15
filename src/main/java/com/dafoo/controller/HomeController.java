package com.dafoo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class HomeController {
    @GetMapping(value = {"/", "/main", "/index"})
    public String main() {
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "menu/about";
    }
}
