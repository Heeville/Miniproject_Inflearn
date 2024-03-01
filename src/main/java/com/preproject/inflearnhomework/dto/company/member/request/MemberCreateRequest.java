package com.preproject.inflearnhomework.dto.company.member.request;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;


@Getter
public class MemberCreateRequest {

    String name;
    String teamName;
    boolean role;
    LocalDate birthday;
    LocalDate workStartDate;
}
