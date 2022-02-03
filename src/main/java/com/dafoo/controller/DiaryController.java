package com.dafoo.controller;

import com.dafoo.dto.DiaryDto;
import com.dafoo.dto.MemberDTO;
import com.dafoo.entity.Diary;
import com.dafoo.entity.Member;
import com.dafoo.repository.MemberRepository;
import com.dafoo.service.DiaryServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

@Controller
@Slf4j
@RequestMapping("/diary")
@RequiredArgsConstructor
public class DiaryController {
    private final DiaryServiceImpl diaryService;
    private final MemberRepository memberRepository;

    @GetMapping("/mydiary")
    public String mydiary() {
        return "/member/mydiary";
    }

    @PostMapping("/addFood")
    public String addFoodAction(DiaryDto diaryDto,@AuthenticationPrincipal MemberDTO memberDTO) throws IOException {
        diaryDto.setMId(memberDTO.getMId());
        diaryService.addDiary(diaryDto);
        log.info("dto : " + diaryDto.toString());
        return "/food/search";
    }

    @PostMapping("/info")
    public String info(DiaryDto dto, @AuthenticationPrincipal MemberDTO memberDTO,Model model) throws IOException {
        dto.setMId(memberDTO.getMId());
        log.info(dto.toString());

        Map<Object,Object> diary = diaryService.getDiary(dto);



        model.addAttribute("diary", diary);

        return "member/mydiary :: #info";
    }

}
