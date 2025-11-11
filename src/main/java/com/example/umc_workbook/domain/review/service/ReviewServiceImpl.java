package com.example.umc_workbook.domain.review.service;

import com.example.umc_workbook.domain.member.entity.Member;
import com.example.umc_workbook.domain.member.repository.MemberRepository;
import com.example.umc_workbook.domain.review.entity.Review;
import com.example.umc_workbook.domain.review.repository.ReviewRepository;
import com.example.umc_workbook.domain.store.entity.Store;
import com.example.umc_workbook.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public Review createReview(Long memberId, Long storeId, String content, Float star) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 가게입니다."));

        Review review = Review.builder()
                .user(member)
                .store(store)
                .content(content)
                .star(star)
                .build();

        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getReviewsByStore(Long storeId) {
        return reviewRepository.findReviewsByStoreId(storeId);
    }

    @Override
    public List<Review> getReviewsByMember(Long memberId) {
        return reviewRepository.findReviewsByMemberId(memberId);
    }
}
