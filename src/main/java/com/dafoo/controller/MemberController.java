package com.dafoo.controller;

import com.dafoo.config.service.MemberDetailService;
import com.dafoo.entity.Member;
import com.dafoo.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final MemberServiceImpl memberService;
    private final MemberDetailService memberDetailService;
    @GetMapping("/login")
    public void login() {
    }
    @GetMapping("/register")
    public void register() {

    }
    @PostMapping("/register")
    public void RegisterAction(Member member, Model model) {
        String msg = memberService.addMember(member);
        log.info(msg);
    }
}
