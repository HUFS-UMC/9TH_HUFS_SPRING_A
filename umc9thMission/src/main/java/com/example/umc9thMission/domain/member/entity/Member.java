package com.example.umc9thMission.domain.member.entity;

import com.example.umc9thMission.domain.member.enums.Gender;
import com.example.umc9thMission.domain.mission.entity.MemberMission;
import com.example.umc9thMission.domain.mission.entity.Mission;
import com.example.umc9thMission.domain.review.entity.Review;
import com.example.umc9thMission.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name="member")
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name = "birth", nullable = false)
    private LocalDateTime birth;

    @Column(name = "phone_num", length = 11)
    private String phoneNum;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    private int point;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviewList=new ArrayList<>();

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();
}
