package com.example.umc_workbook.domain.store.entity;

import com.example.umc_workbook.domain.mission.entity.Mission;
import com.example.umc_workbook.domain.review.entity.Review;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "store")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    // 사장님 구별 번호 (ERD: bigint)
    @Column(name = "manager_number", nullable = false)
    private Long managerNumber;

    @Column(name = "detail_address", nullable = false)
    private String detailAddress;

    // FK: location_id → location(location_id)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    // Store : Mission = 1 : N
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Mission> missions = new ArrayList<>();

    // Store : Review = 1 : N
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Review> reviews = new ArrayList<>();

    /** 연관관계 편의 메서드 */
    public void addMission(Mission mission) {
        this.missions.add(mission);
        mission.setStore(this); // Mission에 setter 필요(연관관계용)
    }

    public void addReview(Review review) {
        this.reviews.add(review);
        review.setStore(this); // Review에 setter 필요(연관관계용)
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
