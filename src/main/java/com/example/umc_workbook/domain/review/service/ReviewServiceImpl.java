package com.example.umc_workbook.domain.review.service;

import com.example.umc_workbook.domain.member.entity.Member;

import com.example.umc_workbook.domain.review.entity.Review;
import com.example.umc_workbook.domain.review.repository.ReviewRepository;
import com.example.umc_workbook.domain.store.entity.Store;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewServiceImpl {

    private final ReviewRepository reviewRepository;


    public List<Review> getReviewsByStore(Long storeId) {
        return reviewRepository.findReviewsByStoreId(storeId);
    }


    public List<Review> getReviewsByMember(Long memberId) {
        return reviewRepository.findReviewsByMemberId(memberId);
    }
}

//수정 필요
public List<MyReviewResponse> getMyReviews(Long memberId, int pageIndex) {
    PageRequest pageable = PageRequest.of(pageIndex, 10);

    Page<Review> page = reviewRepository.findByMemberId(memberId, pageable);

    return page.getContent().stream()
            .map(review -> MyReviewResponse.builder()
                    .reviewId(review.getId())
                    .storeId(review.getStore().getId())
                    .storeName(review.getStore().getName())
                    .content(review.getContent())
                    .rating(review.getRating())
                    .createdAt(review.getCreatedAt())
                    .build())
            .toList();
}

