package com.example.umc_workbook.domain.review.dto.res;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ReviewResDTO {
    Long reviewId;
    Long storeId;
    String storeName;
    String content;
    Float rating;
    LocalDateTime createdAt;
}

