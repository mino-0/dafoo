package com.dafoo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Diary extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long did;
    private Long day;
    private Long serving;
    private String food_code;

    @ManyToOne
    @JoinColumn(name = "mid")
    private Member member;
}
