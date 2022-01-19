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
    private Long day;
    private Long serving;
    private String food_cd;
    private LocalDate regDate;

    @ManyToOne
    @JoinColumn(name = "mid")
    private Member member;
}
