package com.example.umc_workbook.domain.review.repository;

import com.example.umc_workbook.domain.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    // JPQL 방식 (가게별 리뷰 조회)
    @Query("SELECT r FROM Review r WHERE r.store.id = :storeId ORDER BY r.createdAt DESC")
    List<Review> findReviewsByStoreId(@Param("storeId") Long storeId);

    // JPQL 방식 (회원별 리뷰 조회)
    @Query("SELECT r FROM Review r WHERE r.user.id = :memberId ORDER BY r.createdAt DESC")
    List<Review> findReviewsByMemberId(@Param("memberId") Long memberId);
}
