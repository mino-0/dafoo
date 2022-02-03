package com.dafoo.dto;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Dto {
        String total_count;
        ArrayList<foodResultDto2> row = new ArrayList<>();
    }

