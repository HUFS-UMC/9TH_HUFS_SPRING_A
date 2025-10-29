package com.example.umc9thMission.domain.review.service;

import com.example.umc9thMission.domain.member.entity.Member;
import com.example.umc9thMission.domain.restaurant.entity.Restaurant;
import com.example.umc9thMission.domain.review.entity.Review;
import com.example.umc9thMission.domain.review.enums.Rating;
import com.example.umc9thMission.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @Transactional
    public Review createReview(Member member, Restaurant restaurant, Rating rating, String body){
        Review review=Review.builder()
                .member(member)
                .restaurant(restaurant)
                .rating(rating)
                .body(body)
                .createdAt(LocalDateTime.now())
                .build();

        return reviewRepository.save(review);
    }


}
