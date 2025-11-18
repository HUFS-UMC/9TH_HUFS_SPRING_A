package com.example.umc9th.domain.member.entity;

import com.example.umc9th.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor @Builder
@Entity @Table(name = "member")
public class Member extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Comment("이름(최대 3자)")
    @Column(name = "name", nullable = false, length = 3)
    private String name;

    @Column(name = "email", nullable = false, length = 100, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false, length = 10)
    @Builder.Default
    private Gender gender = Gender.NONE;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;
}