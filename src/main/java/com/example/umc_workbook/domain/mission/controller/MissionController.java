package com.example.umc_workbook.domain.mission.controller;

import com.example.umc_workbook.domain.mission.dto.MyMissionResponse;
import com.example.umc_workbook.domain.mission.dto.StoreMissionDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@GetMapping("/stores/{storeId}/missions")
public List<StoreMissionDTO> getStoreMissions(
        @PathVariable Long storeId,
        @PageParam @RequestParam Integer page
) {
    return missionService.getMissionsByStore(storeId, page);
}

@GetMapping("/missions/me/ongoing")
public List<MyMissionResponse> getMyOngoingMissions(
        @RequestHeader("X-MEMBER-ID") Long memberId,
        @PageParam @RequestParam Integer page
) {
    return missionService.getMyOngoingMissions(memberId, page);
}


