package com.preproject.inflearnhomework.dto.company.team.response;

import lombok.*;

@Getter
public class TeamListResponse {

    private String name;
    private String manager;
    private int memberCount;

    public TeamListResponse(String name, String manager, int memberCount) {
        this.name = name;
        this.manager = manager;
        this.memberCount = memberCount;
    }
}
