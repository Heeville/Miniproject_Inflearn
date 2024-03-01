package com.preproject.inflearnhomework.domain.company.member;

import com.preproject.inflearnhomework.domain.company.recordwork.MemberRecordWorks;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MemberRecordWorks> memberRecordWorks =new ArrayList<>();

    public Member(){}

    public Member(String name, String teamName, boolean isManager, Date birthday, Date workStartDate) {
        this.name = name;
        this.teamName = teamName;
        this.isManager=isManager;
        this.birthday = birthday;
        this.workStartDate = workStartDate;
    }

    public void enterWork(Date today, LocalTime enter){
        //this.memberRecordWorks.add(new MemberRecordWorks(this.id,this.name,today,enter));
        this.memberRecordWorks.add(new MemberRecordWorks(this,today,enter));
    }



}
