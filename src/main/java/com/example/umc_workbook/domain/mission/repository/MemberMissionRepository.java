package com.example.umc_workbook.domain.mission.repository;

import com.example.umc_workbook.domain.mission.entity.mapping.MemberMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

    /**
     * 내가 진행중인 미션 목록 (is_complete = false)
     * Mission, Store를 fetch join으로 함께 로딩 → N+1 방지
     */
    @Query(value = """
            select mm
            from MemberMission mm
            join fetch mm.mission m
            join fetch m.store s
            where mm.member.id = :memberId
              and mm.isComplete = false
            order by m.createdAt desc
            """,
            countQuery = """
            select count(mm)
            from MemberMission mm
            join mm.mission m
            where mm.member.id = :memberId
              and mm.isComplete = false
            """)
    Page<MemberMission> findOngoingByMemberId(@Param("memberId") Long memberId, Pageable pageable);


    /**
     * 내가 완료한 미션 목록 (is_complete = true)
     */
    @Query(value = """
            select mm
            from MemberMission mm
            join fetch mm.mission m
            join fetch m.store s
            where mm.member.id = :memberId
              and mm.isComplete = true
            order by m.createdAt desc
            """,
            countQuery = """
            select count(mm)
            from MemberMission mm
            join mm.mission m
            where mm.member.id = :memberId
              and mm.isComplete = true
            """)
    Page<MemberMission> findCompletedByMemberId(@Param("memberId") Long memberId, Pageable pageable);


    /**
     * 상태 필터를 파라미터로 받는 통합 버전 (complete=null이면 둘 다)
     * complete가 null일 경우 where절에서 상태 조건을 건너뜀
     */
    @Query(value = """
            select mm
            from MemberMission mm
            join fetch mm.mission m
            join fetch m.store s
            where mm.member.id = :memberId
              and (:complete is null or mm.isComplete = :complete)
            order by m.createdAt desc
            """,
            countQuery = """
            select count(mm)
            from MemberMission mm
            join mm.mission m
            where mm.member.id = :memberId
              and (:complete is null or mm.isComplete = :complete)
            """)
    Page<MemberMission> findAllByMemberIdAndStatus(
            @Param("memberId") Long memberId,
            @Param("complete") Boolean complete,
            Pageable pageable
    );
}
