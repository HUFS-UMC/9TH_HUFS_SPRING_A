package com.example.umc_workbook.domain.review.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "review_photo")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class ReviewPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_photo_id")
    private Long id;

    // NULL 허용 (ERD)
    @Column(name = "photo_url")
    private String photoUrl;

    // FK: review_id → review(review_id)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id", nullable = false)
    private Review review;

    // 연관관계 세터 (편의)
    public void setReview(Review review) {
        this.review = review;
    }
}
