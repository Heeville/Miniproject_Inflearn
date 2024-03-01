package com.preproject.inflearnhomework.service.company;

import com.preproject.inflearnhomework.domain.company.member.Member;
import com.preproject.inflearnhomework.domain.company.member.MemberRepository;
import com.preproject.inflearnhomework.domain.company.team.Team;
import com.preproject.inflearnhomework.domain.company.team.TeamRepository;
import com.preproject.inflearnhomework.dto.company.member.response.MemberListResponse;
import com.preproject.inflearnhomework.dto.company.team.response.TeamListResponse;
import com.preproject.inflearnhomework.exception.InvalidOptionException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService {
private final TeamRepository teamRepository;
private final MemberRepository memberRepository;

    public CompanyService(TeamRepository teamRepository, MemberRepository memberRepository) {
        this.teamRepository = teamRepository;
        this.memberRepository = memberRepository;
    }

    @Transactional
    public void createTeam(String name,String manager){
        boolean nameisexist = teamRepository.existsByName(name);
        if(nameisexist){
            throw new InvalidOptionException("이름이 중복된 팀이 있습니다. 다시 입력해주세요");
        }
        teamRepository.save(new Team(name,manager));
    }

    @Transactional
    public void createMember(String name, String teamName, boolean isManager, Date birthday, Date workStartDate){

        boolean teamexist=teamRepository.existsByName(teamName);
        if(!teamexist){
            throw new InvalidOptionException("해당하는 팀이름이 없습니다. 다시 입력해주세요");
        }

        memberRepository.save(new Member(name,teamName,isManager,birthday,workStartDate));
        teamRepository.findTeamByName(teamName).addMemberCount();
        if (isManager){
            teamRepository.findTeamByName(teamName).setManager(name);
        }

    }

    @Transactional
    public List<TeamListResponse> teamList(){
        return teamRepository.findAll().stream()
                .map(team -> new TeamListResponse(team.getName(), team.getManager(), team.getMemberCount()))
                .collect(Collectors.toList());
    }

    @Transactional
    public List<MemberListResponse> memberList(){
        return memberRepository.findAll().stream()
                .map(m -> new MemberListResponse(m.getName(),m.getTeamName(),m.isManager()
                        ,m.getBirthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
                        ,m.getWorkStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()))
                .collect(Collectors.toList());
    }

    @Transactional
    public void enterWork(String name, Date today, LocalTime enter){
        Member member=memberRepository.findByName(name)
                .orElseThrow(IllegalArgumentException::new);

        member.enterWork(today,enter);

    }

}
