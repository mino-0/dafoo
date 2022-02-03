package com.dafoo.repository;

import com.dafoo.entity.Diary;
import com.dafoo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Long> {

    @Query("select d from Diary d where d.member = ?1 and d.regDate = ?2")
    ArrayList<Diary> findByMemberAndRegDate(Member member, String RegDate);
}
