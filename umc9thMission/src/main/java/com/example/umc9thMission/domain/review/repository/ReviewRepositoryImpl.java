package com.example.umc9thMission.domain.review.repository;

import com.example.umc9thMission.domain.restaurant.entity.QRestaurant;
import com.example.umc9thMission.domain.review.entity.QReview;
import com.example.umc9thMission.domain.review.entity.Review;
import com.example.umc9thMission.domain.review.enums.Rating;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    @Override

    public List<Review> findMyReviews(Long memberId, String restaurantName, Rating rating) {
        QReview review = QReview.review;
        QRestaurant restaurant=QRestaurant.restaurant;

        return queryFactory
                .selectFrom(review)
                .join(review.restaurant, restaurant).fetchJoin()
                .where(
                        memberId !=null ? review.member.id.eq(memberId):null,
                        restaurantName !=null ? restaurant.name.eq(restaurantName) : null,
                        rating != null ? review.rating.eq(rating) : null
                )
                .orderBy(review.id.desc())
                .fetch();

    }

}
