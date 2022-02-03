package com.dafoo.dto;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DiaryDto {
    private String day;
    private String serving;
    private String food_cd;
    private String regDate;
    private Long mId;

}
