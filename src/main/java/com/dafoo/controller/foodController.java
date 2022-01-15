package com.dafoo.controller;

import com.dafoo.dto.foodResultDto;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/food")
@Slf4j

public class foodController {
    @GetMapping("/search")
    public String search() {
        return "food/search";
    }

    @PostMapping("/searchResult")
    public String searchREesult(@RequestBody String dataResult, Model model) {

        Gson gson = new Gson();
        Map<String, Object> map = gson.fromJson(dataResult, Map.class);

        log.info("map : " + map.get("dataResult"));
        log.info("dataResult : " +dataResult);

        foodResultDto dto = gson.fromJson(gson.toJson(map.get("dataResult")), foodResultDto.class);

        log.info(dto.toString());

        model.addAttribute("dto", dto);

        return "/food/searchResult";
    }
}