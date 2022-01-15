package com.dafoo.controller;

import com.dafoo.service.foodApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@RestController
@RequestMapping(value = "/foodApi")
@RequiredArgsConstructor
@Slf4j
public class FoodApiController{
    private final foodApiService service;

    @GetMapping(value = "/search")
    public String search(String searchVal) throws IOException{
        return service.getService1(searchVal);
    }
    @PostMapping(value = "/search")
    public String postSearch(@RequestBody String data) throws IOException{
        return service.postService(data);
    }

    @GetMapping("/searchResult")
    public String searchResult() {
        return "/food/searchResult";
    }
}
