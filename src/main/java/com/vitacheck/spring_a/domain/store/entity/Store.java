package com.vitacheck.spring_a.domain.store.entity;

import com.vitacheck.spring_a.domain.mission.entity.Mission;
import com.vitacheck.spring_a.domain.review.entity.Review;
import com.vitacheck.spring_a.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity @Table(name = "store")
public class Store extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "manager_number")
    private String managerNumber;

    @Column(name = "detail_address")
    private String detailAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @OneToMany(mappedBy = "store")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mission> missions = new ArrayList<>();

    @Builder
    public Store(String name, String managerNumber, String detailAddress, Location location) {
        this.name = name;
        this.managerNumber = managerNumber;
        this.detailAddress = detailAddress;
        this.location = location;
    }
}
