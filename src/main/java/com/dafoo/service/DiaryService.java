package com.dafoo.service;

import com.dafoo.entity.Diary;

public interface DiaryService {
    public void addDiary(Diary diary);

    public void setDiary(String food_code);

    public void removeDiary(String food_code);

}
