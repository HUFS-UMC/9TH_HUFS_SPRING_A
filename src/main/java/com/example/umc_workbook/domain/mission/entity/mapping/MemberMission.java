package com.example.umc_workbook.domain.mission.entity.mapping;

import com.example.umc_workbook.domain.member.entity.Member;
import com.example.umc_workbook.domain.mission.entity.Mission;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "member_mission")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class MemberMission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_mission_id")
    private Long id;

    @Column(name = "is_complete", nullable = false)
    @Builder.Default
    private boolean isComplete = false;   // 기본값 false

    // FK: member_id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    // FK: mission_id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id", nullable = false)
    private Mission mission;

    /* ==========================
       편의(매핑) 메서드 ①
       - 미션과의 양방향 관계를 한 번에 설정
       - Mission 쪽 컬렉션에도 자신(this) 등록
       ========================== */
    public void setMission(Mission mission) {
        this.mission = mission;
        if (mission != null && !mission.getMemberMissions().contains(this)) {
            mission.getMemberMissions().add(this);
        }
    }

    /* ==========================
       편의(매핑) 메서드 ②
       - 회원과 미션을 동시에 연결하는 팩토리/세터
       - Mission 쪽 컬렉션까지 일관성 유지
       ========================== */
    public void link(Member member, Mission mission) {
        this.member = member;
        setMission(mission); // 위에서 컬렉션까지 정리
    }

    // 완료 처리 도메인 메서드(옵션)
    public void complete() { this.isComplete = true; }
    public void reopen()   { this.isComplete = false; }
}
