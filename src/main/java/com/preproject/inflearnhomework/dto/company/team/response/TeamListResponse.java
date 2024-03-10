package com.preproject.inflearnhomework.dto.company.team.response;

import lombok.*;

@Getter
public class TeamListResponse {

    private String name;
    private String manager;
    private int memberCount;
    private int vacationStandardDate;

    public TeamListResponse(String name, String manager, int memberCount,int vacationStandardDate) {
        this.name = name;
        this.manager = manager;
        this.memberCount = memberCount;
        this.vacationStandardDate=vacationStandardDate;
    }
}
