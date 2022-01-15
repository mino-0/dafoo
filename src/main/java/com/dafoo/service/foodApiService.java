package com.dafoo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@Service
@Slf4j
public class foodApiService {

    public String API(String key, String value) throws IOException{
        StringBuilder urlBuilder = new StringBuilder("https://openapi.foodsafetykorea.go.kr/api/b8255f749edb438a8b70/I2790/json/1/100"); /*URL*/
        urlBuilder.append("/" + URLEncoder.encode(key,"UTF-8") + "=" + URLEncoder.encode(value, "UTF-8"));
        urlBuilder.append("?" + URLEncoder.encode("RESEARCH_YEAR", "UTF-8") + "=" + URLEncoder.encode("2017","UTF-8"));

        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        log.info("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        return sb.toString();
    }

    public String getService1(String searchVal) throws IOException {
        if (searchVal == null) {
            searchVal = "";
        }
        return API("DESC_KOR", searchVal);
    }

    public String postService(String foodcd)throws IOException{

        log.info("foodcd : " +foodcd);

        return API("FOOD_CD",foodcd);
    }
}
