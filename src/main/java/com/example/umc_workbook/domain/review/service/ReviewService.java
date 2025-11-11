package com.example.umc_workbook.domain.review.service;

import com.example.umc_workbook.domain.review.entity.Review;

import java.util.List;

public interface ReviewService {

    // 리뷰 작성
    Review createReview(Long memberId, Long storeId, String content, Float star);

    // 가게별 리뷰 조회
    List<Review> getReviewsByStore(Long storeId);

    // 회원별 리뷰 조회
    List<Review> getReviewsByMember(Long memberId);
}
