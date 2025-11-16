package com.example.umc_workbook.domain.review.service;

import com.example.umc_workbook.domain.member.entity.Member;

import com.example.umc_workbook.domain.review.entity.Review;
import com.example.umc_workbook.domain.review.repository.ReviewRepository;
import com.example.umc_workbook.domain.store.entity.Store;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewServiceImpl   {

    private final ReviewRepository reviewRepository;
    

    
    public List<Review> getReviewsByStore(Long storeId) {
        return reviewRepository.findReviewsByStoreId(storeId);
    }

    
    public List<Review> getReviewsByMember(Long memberId) {
        return reviewRepository.findReviewsByMemberId(memberId);
    }
}
//수정 필요