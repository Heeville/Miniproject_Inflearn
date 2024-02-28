package com.preproject.inflearnhomework.dto.fruit.response;


import lombok.*;

@Getter
@Setter
public class FruitPriceSumResponse {

    private long salesAmount;
    private long notSalesAmount;

    public FruitPriceSumResponse(long salesAmount, long notSalesAmount) {
        this.salesAmount = salesAmount;
        this.notSalesAmount = notSalesAmount;
    }
}
