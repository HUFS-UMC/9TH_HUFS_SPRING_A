package com.example.umc9thMission.domain.review.repository;

import com.example.umc9thMission.domain.review.entity.Review;
import com.example.umc9thMission.domain.review.enums.Rating;

import java.util.List;

public interface ReviewRepositoryCustom {
    List<Review> findMyReviews(Long memberId, String restaurantName, Rating rating);
}
