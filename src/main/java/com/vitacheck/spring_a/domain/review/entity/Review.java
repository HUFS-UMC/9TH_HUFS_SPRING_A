package com.vitacheck.spring_a.domain.review.entity;

import com.vitacheck.spring_a.domain.member.entity.Member;
import com.vitacheck.spring_a.domain.store.entity.Store;
import com.vitacheck.spring_a.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity @Table(name = "review")
public class Review extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;

    // BaseEntity에 created_at이 있다면, 충돌 방지를 위해 written_at으로 저장
    @Column(name = "written_at", nullable = false)
    private LocalDateTime writtenAt;

    @Column(name = "rate", nullable = false)
    private Float rate;

    @Lob
    @Column(name = "content", nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReviewPhoto> photos = new ArrayList<>();

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reply> replies = new ArrayList<>();

    @Builder
    private Review(LocalDateTime writtenAt, Float rate, String content, Member member, Store store) {
        this.writtenAt = writtenAt;
        this.rate = rate;
        this.content = content;
        this.member = member;
        this.store = store;
    }
}
