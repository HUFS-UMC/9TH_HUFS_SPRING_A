package com.example.umc_workbook.domain.review.controller;

import com.example.umc_workbook.domain.review.dto.res.ReviewResDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@GetMapping("/reviews/me")
public List<ReviewResDTO> getMyReviews(
        @RequestHeader("X-MEMBER-ID") Long memberId,
        @PageParam @RequestParam Integer page
) {
    return reviewService.getMyReviews(memberId, page);
}

