package com.preproject.inflearnhomework.dto.fruit.request;

import lombok.Getter;

import java.time.LocalDate;
import java.util.Date;

@Getter
public class CreateFruitRequest {

    private String name;
    private Date warehousingDate;
    private long price;
    private boolean sales;
}
