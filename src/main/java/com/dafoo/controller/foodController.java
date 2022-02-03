package com.dafoo.controller;

import com.dafoo.dto.DiaryDto;
import com.dafoo.dto.MemberDTO;
import com.dafoo.dto.foodResultDto;
import com.dafoo.entity.Diary;
import com.dafoo.service.DiaryServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;

@Controller
@RequestMapping("/food")
@Slf4j
@RequiredArgsConstructor
public class foodController {
    private final DiaryServiceImpl diaryService;

    @GetMapping("/search")
    public String search(Model model,foodResultDto dto) {
        model.addAttribute("dto", dto);
        return "food/search";
    }


    @PostMapping("/searchResult")
    public String searchResult(@RequestBody String dataResult, Model model) {

        foodResultDto dto = diaryService.searchResult(dataResult);
        model.addAttribute("dto", dto);

        return "/food/searchResult";
    }


}