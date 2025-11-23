package com.example.umc_workbook.domain.mission.service;

import com.example.umc_workbook.domain.mission.entity.mapping.MemberMission;
import com.example.umc_workbook.domain.mission.repository.MemberMissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionQueryService {

    private final MemberMissionRepository memberMissionRepository;

    /** 진행중 목록 */
    public Page<MemberMission> getOngoingMissions(Long memberId, Pageable pageable) {
        return memberMissionRepository.findOngoingByMemberId(memberId, pageable);
    }

    /** 완료 목록 */
    public Page<MemberMission> getCompletedMissions(Long memberId, Pageable pageable) {
        return memberMissionRepository.findCompletedByMemberId(memberId, pageable);
    }

    /** 통합(complete = null → 전체, true → 완료, false → 진행중) */
    public Page<MemberMission> getMyMissions(Long memberId, Boolean complete, Pageable pageable) {
        return memberMissionRepository.findAllByMemberIdAndStatus(memberId, complete, pageable);
    }
}
