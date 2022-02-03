package com.dafoo.config.service;

import com.dafoo.dto.MemberDTO;
import com.dafoo.entity.Member;
import com.dafoo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberDetailService implements UserDetailsService {
    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.info("MemberDetailService loadUserByUserName : " + email);
        Optional<Member> result = memberRepository.findByEmail(email, false);
        if (result.isEmpty()) {
            log.info("존재하지 않는 사용자");
            throw new UsernameNotFoundException("Check Email or Social");
        }
        log.info("존재하는 사용자");
        Member member = result.get();

        log.info("member : " + member);

        MemberDTO memberDTO = new MemberDTO(
                member.getEmail(),
                member.getPw(),
                member.getNickname(),
                member.isSns(),
                member.getMid(),
                member.getRoleSet().stream().map(role ->
                        new SimpleGrantedAuthority("ROLE_" + role.name())).collect(Collectors.toSet()));
        log.info("memberDTO : " + memberDTO.toString());

        return memberDTO;
    }
}
