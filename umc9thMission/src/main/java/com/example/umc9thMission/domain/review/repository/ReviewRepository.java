package com.example.umc9thMission.domain.review.repository;

import com.example.umc9thMission.domain.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long>,ReviewRepositoryCustom{

}
