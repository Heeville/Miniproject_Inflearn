package com.preproject.inflearnhomework.dto.company.recordwork.request;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class EnterVacationRequest {
    String name;
    LocalDate startDate;
    int duration;

    public EnterVacationRequest(String name, LocalDate startDate, int duration) {
        this.name = name;
        this.startDate = startDate;
        this.duration = duration;
    }
}
