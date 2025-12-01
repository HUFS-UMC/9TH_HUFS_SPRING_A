package com.example.umc_workbook.domain.mission.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class StoreMissionDTO {
    Long missionId;
    LocalDate deadline;
    String conditional;
    Integer point;
}
