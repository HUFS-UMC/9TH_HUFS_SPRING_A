package com.example.umc_workbook.domain.member.controller;

import com.example.umc_workbook.domain.member.dto.req.MemberReqDTO;
import com.example.umc_workbook.domain.member.dto.res.MemberResDTO;
import com.example.umc_workbook.domain.member.exception.code.MemberSuccessCode;
import com.example.umc_workbook.domain.member.service.command.MemberCommandService;
import com.example.umc_workbook.global.apiPayload.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberCommandService memberCommandService;

    // 회원가입
    @PostMapping("/sign-up")
    public ApiResponse<MemberResDTO.JoinDTO> signUp(
            @RequestBody MemberReqDTO.JoinDTO dto
    ){
     return null;
    }
}
