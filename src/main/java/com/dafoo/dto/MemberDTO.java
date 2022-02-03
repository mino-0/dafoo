package com.dafoo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Slf4j
@Getter
@Setter
@ToString
public class MemberDTO extends User {
    private Long mId;
    private String nickname;
    private boolean sns;

    public MemberDTO(String email, String pw,String nickname, boolean sns, Long mId,
                         Collection<? extends GrantedAuthority> authorities) {
        super(email, pw, authorities);
        this.mId = mId;
        this.nickname = nickname;
        this.sns = sns;
    }
}
