package com.example.umc_workbook.domain.member.service.command;

import com.example.umc_workbook.domain.member.dto.req.MemberReqDTO;
import com.example.umc_workbook.domain.member.dto.res.MemberResDTO;
import com.example.umc_workbook.domain.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    // 회원가입
    @Override
    public MemberResDTO.JoinDTO signup(
            MemberReqDTO.JoinDTO dto
    ){
        return null;
    }
}