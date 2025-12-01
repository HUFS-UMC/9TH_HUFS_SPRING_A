package com.example.umc_workbook.domain.mission.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MissionStatusUpdateResponse {
    Long memberMissionId;
    Long missionId;
    Boolean isComplete;
}
