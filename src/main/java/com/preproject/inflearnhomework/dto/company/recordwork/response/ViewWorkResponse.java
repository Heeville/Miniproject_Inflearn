package com.preproject.inflearnhomework.dto.company.recordwork.response;

import lombok.Getter;

import java.util.List;

@Getter
public class ViewWorkResponse {
    List<DayWorkResponse> detail;

    int sum;


    public ViewWorkResponse(List<DayWorkResponse> detail, int sum) {
        this.detail = detail;
        this.sum = sum;
    }
}
