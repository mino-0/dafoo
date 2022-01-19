package com.dafoo.service;

import com.dafoo.entity.Member;
import com.dafoo.entity.MemberRole;
import com.dafoo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public String addMember(Member memberinfo) {
        Optional<Member> result = memberRepository.findByEmail(memberinfo.getEmail(), false);
        if (result.isPresent()) {
            log.info("Already Using Id");
            return "failed";
        }
        else {
            Member member = Member.builder()
                    .email(memberinfo.getEmail())
                    .pw(passwordEncoder.encode(memberinfo.getPw()))
                    .nickname(memberinfo.getNickname())
                    .status("1")
                    .sns(false)
                    .build();
            member.addMemberRole(MemberRole.USER);
            memberRepository.save(member);
            log.info("Success Register ID");
            return "success";
        }
    }

    @Override
    public void setMember() {

    }

    @Override
    public void removeMember() {

    }

    @Override
    public void getMemberList() {

    }

    @Override
    public void getMemberInfo() {

    }
}
