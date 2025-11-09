package com.example.umc9thMission.domain.mission.repository;

import com.example.umc9thMission.domain.mission.entity.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MissionRepository extends JpaRepository<Mission,Long> {
    @Query("SELECT m FROM Mission m " +
            "WHERE m.id NOT IN (" +
            "SELECT mm.mission.id FROM MemberMission mm WHERE mm.member.id = :memberId" +
            ") " +
            "AND m.status = 'IN_PROGRESS' " +
            "ORDER BY m.id DESC")
    List<Mission> findAvailableMissionsByMember(@Param("memberId") Long memberId);

}