package com.vitacheck.spring_a.domain.mission.entity;

import com.vitacheck.spring_a.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

// MemberMission.java
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "member_mission",
        uniqueConstraints = @UniqueConstraint(name = "uk_member_mission", columnNames = {"member_id","mission_id"}))
public class MemberMission {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_mission_id")
    private Long id;

    @Column(name = "is_complete", nullable = false)
    private boolean isComplete;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "mission_id", nullable = false)
    private Mission mission;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Builder
    private MemberMission(boolean isComplete, Mission mission, Member member) {
        this.isComplete = isComplete;
        this.mission = mission;
        this.member = member;

        if (mission != null) mission.getMemberMissions().add(this);
        if (member  != null) member.getMemberMissions().add(this);
    }
}
