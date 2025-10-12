package com.example.umc9th.domain.member.service;

import com.example.umc9th.domain.member.entity.Gender;
import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Member register(String name, String email, Gender gender, String phone) {
        if (memberRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("이미 가입된 이메일입니다.");
        }
        Member member = Member.builder()
                .name(name)
                .email(email)
                .gender(gender)
                .phoneNumber(phone)
                .build();
        return memberRepository.save(member);
    }

    public Member get(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원"));
    }
}