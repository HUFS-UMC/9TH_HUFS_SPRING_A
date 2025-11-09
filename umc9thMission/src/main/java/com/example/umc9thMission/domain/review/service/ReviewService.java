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
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public List<Review> getMyReviews(Long memberId, String restaurantName, Rating rating){
        return reviewRepository.findMyReviews(memberId,restaurantName,rating);
    }
}
