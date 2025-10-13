package com.vitacheck.spring_a.domain.mission.entity;

import com.vitacheck.spring_a.domain.store.entity.Store;
import com.vitacheck.spring_a.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Mission.java
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "mission")
public class Mission extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mission_id")
    private Long id;

    @Column(name = "deadline", nullable = false)
    private LocalDate deadline;

    @Column(name = "mission_condition", nullable = false)
    private String missionCondition;

    @Column(name = "point", nullable = false)
    private Integer point;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MemberMission> memberMissions = new ArrayList<>();

    @Builder
    public Mission(LocalDate deadline, String missionCondition, Integer point, Store store) {
        this.deadline = deadline;
        this.missionCondition = missionCondition;
        this.point = point;
        this.store = store;
    }
}
