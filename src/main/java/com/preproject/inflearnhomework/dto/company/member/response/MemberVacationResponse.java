package com.preproject.inflearnhomework.dto.company.member.response;

import lombok.Getter;

@Getter
public class MemberVacationResponse {
    String name;
    String teamName;
    int restVacation;

    public MemberVacationResponse(String name, String teamName, int restVacation) {
        this.name = name;
        this.teamName = teamName;
        this.restVacation = restVacation;
    }
}
