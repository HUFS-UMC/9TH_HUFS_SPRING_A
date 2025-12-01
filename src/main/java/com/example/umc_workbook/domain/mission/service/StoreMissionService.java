package com.example.umc_workbook.domain.mission.service;

import com.example.umc_workbook.domain.mission.dto.StoreMissionDTO;
import com.example.umc_workbook.domain.mission.entity.Mission;
import org.hibernate.query.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public class StoreMissionService {
    public List<StoreMissionDTO> getMissionsByStore(Long storeId, int pageIndex) {
        PageRequest pageable = PageRequest.of(pageIndex, 10);

        Page<Mission> page = missionRepository.findByStoreId(storeId, pageable);

        return page.getContent().stream()
                .map(m -> StoreMissionResponse.builder()
                        .missionId(m.getId())
                        .deadline(m.getDeadline())
                        .conditional(m.getConditional())
                        .point(m.getPoint())
                        .build())
                .toList();
    }

}
