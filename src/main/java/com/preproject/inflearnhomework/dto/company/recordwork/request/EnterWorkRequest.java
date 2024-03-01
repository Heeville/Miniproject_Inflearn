package com.preproject.inflearnhomework.dto.company.recordwork.request;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Getter
public class EnterWorkRequest {
    String name;
    LocalDate today;
    LocalTime enter;

}
