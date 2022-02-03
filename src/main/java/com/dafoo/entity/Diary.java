package com.dafoo.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long did;
    private String day;
    private String serving;
    private String regDate;
    private String food_cd;

    @ManyToOne
    @JoinColumn(name = "mid")
    private Member member;
}
