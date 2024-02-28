package com.preproject.inflearnhomework.dto.fruit.response;

import lombok.*;

@Getter
public class FruitCountResponse {
    private long count;

    public FruitCountResponse(long count) {
        this.count = count;
    }
}
