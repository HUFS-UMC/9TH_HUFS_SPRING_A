// com.example.umc_workbook.domain.mission.repository.MissionRepository
package com.example.umc_workbook.domain.mission.repository;

import com.example.umc_workbook.domain.mission.entity.Mission;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    /**
     * 선택 지역에서 '도전 가능한' 미션 목록
     * - 회원이 이미 '완료'한 미션은 제외 (중복 도전 방지)
     * - Mission, Store, Location을 fetch join
     */
    @Query(value = """
        select m
        from Mission m
          join fetch m.store s
          join fetch s.location l
        where l.id = :locationId
          and not exists (
             select 1
             from MemberMission mm
             where mm.mission = m
               and mm.member.id = :memberId
               and mm.isComplete = true
          )
        order by m.createdAt desc
        """,
            countQuery = """
        select count(m)
        from Mission m
          join m.store s
          join s.location l
        where l.id = :locationId
          and not exists (
             select 1
             from MemberMission mm
             where mm.mission = m
               and mm.member.id = :memberId
               and mm.isComplete = true
          )
        """)
    Page<Mission> findAvailableByLocationForMember(
            @Param("locationId") Long locationId,
            @Param("memberId") Long memberId,
            Pageable pageable
    );

    /**
     * (옵션) 회원 조건 없이, 지역별 전체 미션 목록
     */
    @Query(value = """
        select m
        from Mission m
          join fetch m.store s
          join fetch s.location l
        where l.id = :locationId
        order by m.createdAt desc
        """,
            countQuery = """
        select count(m)
        from Mission m
          join m.store s
          join s.location l
        where l.id = :locationId
        """)
    Page<Mission> findAllByLocation(@Param("locationId") Long locationId, Pageable pageable);

    @Query("""
        select count(mm)
        from MemberMission mm
        where mm.member.id = :memberId
          and mm.isComplete = true
        """)
    long countCompleted(@Param("memberId") Long memberId);

    Page<Mission> findByStoreId(Long storeId, Pageable pageable);

}
