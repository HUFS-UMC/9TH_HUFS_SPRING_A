package com.example.umc9thMission.domain.review.controller;

import com.example.umc9thMission.domain.review.entity.Review;
import com.example.umc9thMission.domain.review.enums.Rating;
import com.example.umc9thMission.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/my")
    public ResponseEntity<List<Review>> getMyReviews(
        @RequestParam(required = false)Long memberId,
        @RequestParam(required=false) String restaurantName,
        @RequestParam(required=false) Rating rating
    ){
        List<Review> reviews = reviewService.getMyReviews(memberId,restaurantName,rating);
        return ResponseEntity.ok(reviews);
    }

}
