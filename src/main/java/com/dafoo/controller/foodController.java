package com.dafoo.controller;

import com.dafoo.dto.foodResultDto;
import com.dafoo.entity.Diary;
import com.dafoo.service.DiaryServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/food")
@Slf4j
@RequiredArgsConstructor
public class foodController {
    private final DiaryServiceImpl diaryService;

    @GetMapping("/search")
    public String search(Model model) {
        return "food/search";
    }

    @PostMapping("/searchResult")
    public String searchResult(@RequestBody String dataResult, Model model) {
        foodResultDto dto = diaryService.searchResult(dataResult);
        model.addAttribute("dto", dto);

        return "/food/searchResult";
    }
    @PostMapping("/addFood")
    public String addFoodAction(Diary diary) {
        log.info("addFoodAction...");
        log.info("Diary : " + diary.toString());
        return "/food/search";
    }
}