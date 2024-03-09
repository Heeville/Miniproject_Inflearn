package com.preproject.inflearnhomework.dto.company.recordwork.response;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class DayWorkResponse {

    LocalDate date;
    int workingMinutes;

    public DayWorkResponse(LocalDate date, int workingMinutes) {
        this.date = date;
        this.workingMinutes = workingMinutes;
    }
}
