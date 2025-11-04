package com.example.umc9thMission.domain.mission.repository;

import com.example.umc9thMission.domain.mission.entity.MemberMission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberMissionRepository extends JpaRepository <MemberMission,Long>{
    @Query("SELECT mm FROM MemberMission mm " +
            "JOIN FETCH mm.mission m " +
            "JOIN FETCH m.restaurant r " +
            "JOIN FETCH mm.member mem " +
            "WHERE mem.id = :memberId " +
            "AND (mm.status < :status OR (mm.status = :status AND m.completeCount > 0)) " +
            "ORDER BY m.id DESC")
    List<MemberMission> findMemberMissions(
      @Param("memberId") Long memberId,
      @Param("status") int status
    );
}
