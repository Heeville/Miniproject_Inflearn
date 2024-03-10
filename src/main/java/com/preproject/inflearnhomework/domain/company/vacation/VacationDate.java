package com.preproject.inflearnhomework.domain.company.vacation;

import com.preproject.inflearnhomework.domain.company.member.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class VacationDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public VacationDate(LocalDate date, Member member) {
        this.date = date;
        this.member = member;
    }

    public VacationDate(){}
}
