package com.preproject.inflearnhomework.dto.company.member.response;

import lombok.*;

import java.time.LocalDate;

@Getter
public class MemberListResponse {

    private String name;
    private String teamName;
    private String role;
    private LocalDate birthday;
    private LocalDate workStartDate;

    public MemberListResponse(String name, String teamName, boolean role, LocalDate birthday, LocalDate workStartDate) {
        this.name = name;
        this.teamName = teamName;
        this.birthday = birthday;
        this.workStartDate = workStartDate;
        if (role==true){
            this.role="MANAGER";
        }
        else{
            this.role="MEMBER";
        }
    }
}
