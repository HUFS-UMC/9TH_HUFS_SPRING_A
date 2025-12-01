package com.example.umc_workbook.domain.mission.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class MyMissionResponse {
    Long memberMissionId;
    Long missionId;
    String storeName;
    String conditional;
    Integer point;
    LocalDate deadline;
    Boolean isComplete;
}

