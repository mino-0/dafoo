package com.dafoo.service;

import com.dafoo.dto.foodResultDto;
import com.dafoo.entity.Diary;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class DiaryServiceImpl implements DiaryService {
    @Override
    public void addDiary(Diary diary) {

    }

    @Override
    public void setDiary(String food_code) {

    }

    @Override
    public void removeDiary(String food_code) {

    }

    public foodResultDto searchResult(String dataResult) {
        Gson gson = new Gson();
        Map<String, Object> map = gson.fromJson(dataResult, Map.class);

        log.info("map : " + map.get("dataResult"));
        log.info("dataResult : " + dataResult);

        foodResultDto dto = gson.fromJson(gson.toJson(map.get("dataResult")), foodResultDto.class);

        log.info(dto.toString());
        return dto;
    }
}
