package com.pixelpalace.msMarketTransactions.util;

import java.util.Map;
import java.util.Optional;

public enum CategoryTypeEnum {

    ACTION("Action"),
    ADVENTURE("Adventure"),
    TERROR("Terror"),
    STRATEGY("Strategy"),
    SPORTS("Sports"),
    HORROR("Horror"),
    RACING("Racing"),
    FREE_GAMES("Free games"),
    FIGHTING("Fighting"),
    CIENCE("Cience");

    private String description;

    CategoryTypeEnum(String description) {
        this.description = description;
    }

    public String getDescription(){return description;}

    public static Optional<CategoryTypeEnum> getCategoryType(String category) {
        return Optional.ofNullable(Map.of(
                "ACTION", CategoryTypeEnum.ACTION,
                "ADVENTURE", CategoryTypeEnum.ADVENTURE,
                "TERROR", CategoryTypeEnum.TERROR,
                "STRATEGY", CategoryTypeEnum.STRATEGY,
                "SPORTS", CategoryTypeEnum.SPORTS,
                "HORROR", CategoryTypeEnum.HORROR,
                "RACING", CategoryTypeEnum.RACING,
                "FREE_GAMES", CategoryTypeEnum.FREE_GAMES,
                "FIGHTING", CategoryTypeEnum.FIGHTING,
                "CIENCE", CategoryTypeEnum.CIENCE
        ).get(category));
    }

}
