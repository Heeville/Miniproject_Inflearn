package com.preproject.inflearnhomework.domain.company.recordwork;

import com.preproject.inflearnhomework.domain.company.member.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "member_record_works")
public class MemberRecordWorks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    Date today;
    LocalTime enter_work;

    LocalTime leave_work;

    protected MemberRecordWorks(){}

    public MemberRecordWorks(Member member, Date today, LocalTime enter_work) {
        this.member=member;
        this.today = today;
        this.enter_work = enter_work;
        this.setName(member.getName());
    }

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;


}
