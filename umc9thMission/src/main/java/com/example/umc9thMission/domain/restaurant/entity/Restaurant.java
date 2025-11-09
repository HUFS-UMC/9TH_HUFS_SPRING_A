package com.example.umc9thMission.domain.restaurant.entity;

import com.example.umc9thMission.domain.restaurant.enums.FoodCategory;
import com.example.umc9thMission.domain.review.entity.Review;
import com.example.umc9thMission.global.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name="restaurant")
public class Restaurant extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "address", length = 100, nullable = false)
    private String address;


    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false)
    private FoodCategory category;

    @JsonBackReference
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Review> reviewList= new ArrayList<>();

}
