// ReviewPhoto.java
package com.vitacheck.spring_a.domain.review.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity @Table(name = "review_photo")
public class ReviewPhoto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_photo_id")
    private Long id;

    @Column(name = "photo_url", nullable = false)
    private String photoUrl;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "review_id", nullable = false)
    private Review review;

    @Builder
    private ReviewPhoto(String photoUrl, Review review) {
        this.photoUrl = photoUrl;
        this.review = review;
        if (review != null) {
            review.getPhotos().add(this);
        }
    }
}
