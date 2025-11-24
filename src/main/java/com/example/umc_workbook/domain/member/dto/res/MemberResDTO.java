package com.example.umc_workbook.domain.member.dto.res;

import lombok.Builder;

import java.time.LocalDateTime;

public class MemberResDTO {
    @Builder
    public record JoinDTO(
            long memberId,
            LocalDateTime createAt
    ){}
}
