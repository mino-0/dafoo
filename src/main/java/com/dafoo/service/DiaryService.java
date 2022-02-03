package com.dafoo.service;

import com.dafoo.dto.DiaryDto;

import java.io.IOException;
import java.util.Map;

public interface DiaryService {
    public void addDiary(DiaryDto diary) throws IOException;

    public void setDiary(String food_code);

    public Map<Object, Object> getDiary(DiaryDto diaryDto) throws IOException;

    public void removeDiary(String food_code);

}
