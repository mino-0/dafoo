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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String RegisterAction(Member member, RedirectAttributes rttr) {
        String msg = "";
        String result = memberService.addMember(member);
        if (result.equals("failed")) {
            msg = "이미 존재하는 아이디입니다.";
            rttr.addFlashAttribute("error", true);
            rttr.addFlashAttribute("msg", msg);
            log.info(msg);
            return "redirect:/member/register";
        }

        msg = "가입 성공";
        log.info(msg);
        return "redirect:/member/login?success";
    }

    @GetMapping("/info")
    public String getInfo() {
        return null;
    }
}
