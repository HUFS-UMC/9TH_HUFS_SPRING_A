package com.example.umc9thMission.domain.review.enums;

import lombok.Getter;

@Getter
public enum Rating {
    ONE_STAR(1), TWO_STARS(2), THREE_STARS(3), FOUR_STARS(4), FIVE_STARS(5);

    private final int score;

    Rating(int score) {
        this.score = score;
    }
}
