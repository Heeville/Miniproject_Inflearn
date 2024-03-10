package com.preproject.inflearnhomework.dto.company.team.request;

import lombok.*;

@Getter
public class TeamCreateRequest {
    private String name;
    private String manager =null;
    private int vacationStandardDate=7;


}
