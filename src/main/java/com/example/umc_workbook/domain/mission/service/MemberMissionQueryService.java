package com.example.umc_workbook.domain.mission.service;

import com.example.umc_workbook.domain.mission.dto.MyMissionResponse;
import com.example.umc_workbook.domain.mission.entity.mapping.MemberMission;
import com.example.umc_workbook.domain.mission.repository.MemberMissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public List<MyMissionResponse> getMyOngoingMissions(Long memberId, int pageIndex) {
        PageRequest pageable = PageRequest.of(pageIndex, 10);

        Page<MemberMission> page =
                memberMissionRepository.findByMemberIdAndIsComplete(memberId, false, pageable);

        return page.getContent().stream()
                .map(mm -> MyMissionResponse.builder()
                        .memberMissionId(mm.getId())
                        .missionId(mm.getMission().getId())
                        .storeName(mm.getMission().getStore().getName())
                        .conditional(mm.getMission().getConditional())
                        .point(mm.getMission().getPoint())
                        .deadline(mm.getMission().getDeadline())
                        .isComplete(mm.getIsComplete())
                        .build())
                .toList();
    }

}
