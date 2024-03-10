package com.preproject.inflearnhomework.dto.company.recordwork.response;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class DayWorkResponse {

    LocalDate date;
    int workingMinutes;
    boolean usingDayOff=false;

    public DayWorkResponse(LocalDate date, int workingMinutes) {
        this.date = date;
        this.workingMinutes = workingMinutes;
    }

    public DayWorkResponse(LocalDate date, int workingMinutes, boolean usingDayOff) {
        this.date = date;
        this.workingMinutes = workingMinutes;
        this.usingDayOff = usingDayOff;
    }
}
