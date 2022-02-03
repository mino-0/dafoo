package com.dafoo.service;

import com.dafoo.dto.DiaryDto;
import com.dafoo.dto.foodResultDto;
import com.dafoo.entity.Diary;
import com.dafoo.entity.Member;
import com.dafoo.repository.DiaryRepository;
import com.dafoo.repository.MemberRepository;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class DiaryServiceImpl implements DiaryService {
    private final MemberRepository memberRepository;
    private final DiaryRepository diaryRepository;
    private final foodApiService foodApiService;

    @Override
    public void addDiary(DiaryDto diaryDto) throws IOException {

        Optional<Member> memberRepositoryById = memberRepository.findById(diaryDto.getMId());
        Member member = memberRepositoryById.get();


        Diary diary = Diary.builder()
            .regDate(diaryDto.getRegDate())
            .day(diaryDto.getDay())
            .serving(diaryDto.getServing())
            .member(member)
            .food_cd(diaryDto.getFood_cd())
            .build();

        diaryRepository.save(diary);
    }

    @Override
    public Map<Object, Object> getDiary(DiaryDto diaryDto) throws IOException {
        Optional<Member> byId = memberRepository.findById(diaryDto.getMId());
        Member member = byId.get();
        String regDate = diaryDto.getRegDate();
        ArrayList<Diary> byMemberAndRegDate = diaryRepository.findByMemberAndRegDate(member, regDate);

        Map<Object, Object> DiaryAndFood_Result = new HashMap<>();

        for (Diary foodCd : byMemberAndRegDate) {
            String result = foodApiService.API("FOOD_CD", foodCd.getFood_cd());
            Gson gson = new Gson();
            Map map = gson.fromJson(result, Map.class);
            map = gson.fromJson(gson.toJson(map.get("I2790")), Map.class);
            result = gson.toJson(map.get("row"));
            result = result.substring(1,result.length()-1);
            foodResultDto foodResultDto = gson.fromJson(result, foodResultDto.class);
            DiaryAndFood_Result.put(foodCd, foodResultDto);
        }
        for (Object key :
            DiaryAndFood_Result.keySet()) {
            foodResultDto foodresultDto =(foodResultDto) DiaryAndFood_Result.get(key);
            log.info(foodresultDto.toString());
        }
        log.info("DAFR:"+DiaryAndFood_Result.toString());


        log.info(byMemberAndRegDate.toString());
        return DiaryAndFood_Result;
    }

    @Override
    public void setDiary(String food_code) {

    }

    @Override
    public void removeDiary(String food_code) {

    }

    public foodResultDto searchResult(String dataResult) {
        log.info(dataResult);
        Gson gson = new Gson();
        Map<String, Object> map = gson.fromJson(dataResult, Map.class);

        log.info("map : " + map.get("dataResult"));
        log.info("dataResult : " + dataResult);

        log.info("map : " + map.get("dataResult"));
        foodResultDto dto = gson.fromJson(gson.toJson(map.get("dataResult")), foodResultDto.class);

        log.info(dto.toString());
        return dto;
    }
}
