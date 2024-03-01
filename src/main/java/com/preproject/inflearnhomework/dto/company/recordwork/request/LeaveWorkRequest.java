package com.preproject.inflearnhomework.dto.company.recordwork.request;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Getter
public class LeaveWorkRequest {

    String name;
    LocalDate today;
    LocalTime leave;
}
