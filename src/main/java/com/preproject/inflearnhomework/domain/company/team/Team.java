package com.preproject.inflearnhomework.domain.company.team;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.preproject.inflearnhomework.domain.company.member.Member;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String name;

    String manager;
    int vacationStandardDate;

    int memberCount;

    //@OneToMany(mappedBy = "team",cascade = CascadeType.ALL, orphanRemoval = true)
    //private List<Member> memberList=new ArrayList<>();

    public Team(String name, String manager,int vacationStandardDate) {
        this.name = name;
        this.manager = manager;
        this.vacationStandardDate=vacationStandardDate;
    }
    public Team(){}

    public void addMemberCount() {
        ++memberCount;
    }



}
