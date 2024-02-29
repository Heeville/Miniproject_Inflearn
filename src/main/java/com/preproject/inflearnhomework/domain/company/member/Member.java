package com.preproject.inflearnhomework.domain.company.member;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import java.util.Date;

@Entity
@Getter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String teamName;
    boolean isManager;
    Date birthday;
    Date workStartDate;

    public Member(){}

    public Member(String name, String teamName, boolean isManager, Date birthday, Date workStartDate) {
        this.name = name;
        this.teamName = teamName;
        this.isManager=isManager;
        this.birthday = birthday;
        this.workStartDate = workStartDate;
    }



}
