package com.example.umc_workbook.domain.mission.entity;

import com.example.umc_workbook.domain.mission.entity.mapping.MemberMission;
import com.example.umc_workbook.domain.store.entity.Store;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mission")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mission_id")
    private Long id;                       // PK

    @Column(nullable = false)
    private LocalDate deadline;            // 미션 기한 (date)

    @Column(nullable = false)
    private String conditional;            // 미션 조건 (varchar)

    @Column(nullable = false)
    private Integer point;                 // 성공 점수 (int)

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;       // 생성일자 (timestamp)

    // FK: store_id → store(store_id)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    // 역방향: member_mission (Mission : MemberMission = 1 : N)
    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<MemberMission> memberMissions = new ArrayList<>();

    // ---- 라이프사이클 콜백 ----
    @PrePersist
    void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public void setStore(Store store) {

    }
}
