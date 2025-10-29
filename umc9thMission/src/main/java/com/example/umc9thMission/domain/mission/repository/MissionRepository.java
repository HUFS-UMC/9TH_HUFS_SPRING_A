package com.example.umc9thMission.domain.mission.repository;

import com.example.umc9thMission.domain.mission.entity.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MissionRepository extends JpaRepository<Mission,Long> {
    @Query("SELECT m FROM Mission m " +
            "JOIN FETCH m.member mem " +
            "WHERE mem.id = :memberId " +
            "AND m.status = 0 " +
            "ORDER BY m.id DESC")
    List<Mission> findAvailableMissionsByMember(@Param("memberId") Long memberId);
}