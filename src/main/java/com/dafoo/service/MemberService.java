package com.dafoo.service;

import com.dafoo.entity.Member;

public interface MemberService {

    public String addMember(Member member);

    public void setMember();

    public void removeMember();

    public void getMemberList();

    public void getMemberInfo();
}
