package com.example.umc9thMission.domain.mission.service;

import com.example.umc9thMission.domain.mission.entity.Mission;
import com.example.umc9thMission.domain.mission.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionService {
    private final MissionRepository missionRepository;

    public List<Mission> getAvailableMissions(Long memberId){
        return missionRepository.findAvailableMissionsByMember(memberId);
    }
}
