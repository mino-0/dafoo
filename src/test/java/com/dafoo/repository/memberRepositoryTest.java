package com.dafoo.repository;

import com.dafoo.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class memberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void saveMember(){
         Member member = Member.builder()
                 .email("test")
                 .pw("1234")
                 .nickname("test")
                 .sns(false)
                 .status("1")
                 .build();
         memberRepository.save(member);
     }

    @Test
    void checkEmail() {
    }
}
