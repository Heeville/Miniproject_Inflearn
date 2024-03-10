package com.preproject.inflearnhomework.domain.company.member;

import com.preproject.inflearnhomework.domain.company.recordwork.MemberRecordWorks;
import com.preproject.inflearnhomework.dto.company.recordwork.response.DayWorkResponse;
import com.preproject.inflearnhomework.dto.company.recordwork.response.ViewWorkResponse;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
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
    LocalDate birthday;
    LocalDate workStartDate;
    int vacation=15;

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MemberRecordWorks> memberRecordWorks =new ArrayList<>();

    public Member(){}

    public Member(String name, String teamName, boolean isManager, LocalDate birthday, LocalDate workStartDate) {
        if (workStartDate.getYear()==2024){
            this.vacation=11;
        }
        this.name = name;
        this.teamName = teamName;
        this.isManager=isManager;
        this.birthday = birthday;
        this.workStartDate = workStartDate;
    }

    public void enterWork(LocalDate today, LocalTime enter){
        //this.memberRecordWorks.add(new MemberRecordWorks(this.id,this.name,today,enter));
        this.memberRecordWorks.add(new MemberRecordWorks(this,today,enter));
    }

    public void leaveWork(LocalDate today,LocalTime enter){
        for(MemberRecordWorks m:memberRecordWorks){
            if (m.getToday().equals(today)){
                m.setLeave_work(enter);
            }
        }
    }

    public ViewWorkResponse calculateWorkforMonth(String year_month){

        List<DayWorkResponse> dayWorkResponses=new ArrayList<>();
        LocalDate startDate= LocalDate.parse(year_month+"-01");

        int lastDayofMonth=startDate.lengthOfMonth();
        int monthtotal=0;

        for(int day=1; day<=lastDayofMonth; day++){
            LocalDate date=startDate.withDayOfMonth(day);
            int daytotal=this.memberRecordWorks.stream().filter(work -> work.getToday().isEqual(date))
                    .mapToInt(work->calculateWokrMinutes(work.getEnter_work(),work.getLeave_work()))
                    .sum();
            monthtotal+=daytotal;
            dayWorkResponses.add(new DayWorkResponse(date,daytotal));
        }
       return new ViewWorkResponse(dayWorkResponses,monthtotal);
    }

    private int calculateWokrMinutes(LocalTime enter, LocalTime leave){
        int start=enter.getHour()*60+enter.getMinute();
        int end=leave.getHour()*60+leave.getMinute();
        return end-start;
    }




}
