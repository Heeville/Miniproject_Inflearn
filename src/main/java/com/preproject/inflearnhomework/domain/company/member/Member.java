package com.preproject.inflearnhomework.domain.company.member;

import com.preproject.inflearnhomework.domain.company.recordwork.MemberRecordWorks;
import com.preproject.inflearnhomework.domain.company.team.Team;
import com.preproject.inflearnhomework.domain.company.team.TeamRepository;
import com.preproject.inflearnhomework.domain.company.vacation.VacationDate;
import com.preproject.inflearnhomework.dto.company.recordwork.response.DayWorkResponse;
import com.preproject.inflearnhomework.dto.company.recordwork.response.ViewWorkResponse;
import com.preproject.inflearnhomework.exception.InvalidOptionException;
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

    //@ManyToOne
    //@JoinColumn(name="team_id")
    //private Team team;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VacationDate> vacationDates = new ArrayList<>();


    public Member(){}

    public Member(String name, String teamName, boolean isManager,
                  LocalDate birthday, LocalDate workStartDate,Team team) {
        if (workStartDate.getYear()==2024){
            this.vacation=11;
        }
        this.name = name;
        this.teamName = teamName;
        this.isManager=isManager;
        this.birthday = birthday;
        this.workStartDate = workStartDate;
        //this.team=team;
    }

    public void enterWork(LocalDate today, LocalTime enter){
        if(memberRecordWorks.stream().filter(temp->temp.getToday().isEqual(today) &&
                temp.getLeave_work()==null).count()!=0){
            throw new InvalidOptionException("오늘 퇴근도 안했는데 왜 출근기록을 또 작성하십니까?");
        }
        //this.memberRecordWorks.add(new MemberRecordWorks(this.id,this.name,today,enter));
        this.memberRecordWorks.add(new MemberRecordWorks(this,today,enter));
    }

    public void leaveWork(LocalDate today,LocalTime enter){
        for(MemberRecordWorks m:memberRecordWorks){
            if (m.getToday().equals(today) && m.getLeave_work()==null){
                if(m.getEnter_work().isAfter(enter)){
                    throw new InvalidOptionException("퇴근시간이 출근시간보다 먼저에요. 다시 입력하세요");
                }
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
            if (this.vacationDates.stream().filter(vacationDate -> vacationDate.getDate().equals(date)).findFirst().isPresent()){
                dayWorkResponses.add(new DayWorkResponse(date,daytotal,true));

            }
            else{
                dayWorkResponses.add(new DayWorkResponse(date,daytotal));
            }
        }
       return new ViewWorkResponse(dayWorkResponses,monthtotal);
    }

    private int calculateWokrMinutes(LocalTime enter, LocalTime leave){
        int start=enter.getHour()*60+enter.getMinute();
        int end=leave.getHour()*60+leave.getMinute();
        return end-start;
    }

    public void recordVacation(String name,LocalDate startDate,int duration,int limit){

        if (startDate.plusDays(limit).isAfter(LocalDate.now())){
            throw new InvalidOptionException("연차신청 기간이 지났습니다.");
        }
        if(duration>this.vacation) {
            throw new InvalidOptionException("연차 한도를 초과하였습니다.");
        }
        for(int day=0;day<duration; day++){
            LocalDate vacationday=startDate.plusDays(day);
            vacationDates.add(new VacationDate(vacationday,this));
        }
        this.vacation-=duration;

    }


}
