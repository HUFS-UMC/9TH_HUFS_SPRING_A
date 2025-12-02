package com.example.umc9th.domain.member.entity;

import com.example.umc9th.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor @Builder
@Entity @Table(name = "food")
public class Food extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")
    private Long id;

    @Column(name = "name", nullable = false, length = 30, unique = true)
    private String name;
}