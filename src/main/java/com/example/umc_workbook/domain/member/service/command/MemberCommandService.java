package com.example.umc_workbook.domain.member.service.command;

import com.example.umc_workbook.domain.member.dto.req.MemberReqDTO;
import com.example.umc_workbook.domain.member.dto.res.MemberResDTO;

public interface MemberCommandService {
    //회원가입
    MemberResDTO.JoinDTO signup(
            MemberReqDTO.JoinDTO dto
    );
}
