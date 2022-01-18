package com.dafoo.config.service;

import com.dafoo.entity.Member;
import com.dafoo.repository.MemberRepository;
import groovy.util.logging.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class MemberDetailServiceTest {
    @Autowired
    private MemberDetailService memberDetailService;
   
    @Test
    void MemberDetailServiceTest(){
        String email = "test1";
        boolean sns = false;
        UserDetails userDetails = memberDetailService.loadUserByUsername(email);

        System.out.println("userDetails.toString() = " + userDetails.toString());

        System.out.println("username : "+ userDetails.getUsername());
        System.out.println("password : " + userDetails.getPassword());

    }
}