package com.example.umc9th.domain.member.controller;

import com.example.umc9th.domain.member.entity.Gender;
import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public Member create(@RequestParam String name,
                         @RequestParam String email,
                         @RequestParam(defaultValue = "NONE") Gender gender,
                         @RequestParam(required = false) String phone) {
        return memberService.register(name, email, gender, phone);
    }

    @GetMapping("/{id}")
    public Member get(@PathVariable Long id) {
        return memberService.get(id);
    }
}