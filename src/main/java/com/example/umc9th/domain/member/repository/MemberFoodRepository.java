package com.example.umc9th.domain.member.repository;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.entity.MemberFood;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberFoodRepository extends JpaRepository<MemberFood, Long> {
    List<MemberFood> findByMember(Member member);
    void deleteByMember(Member member); // 회원 탈퇴 시 선호음식 일괄 삭제
}