package com.preproject.inflearnhomework.controller.company;

import com.preproject.inflearnhomework.domain.company.team.Team;
import com.preproject.inflearnhomework.dto.company.member.request.MemberCreateRequest;
import com.preproject.inflearnhomework.dto.company.member.response.MemberListResponse;
import com.preproject.inflearnhomework.dto.company.member.response.MemberVacationResponse;
import com.preproject.inflearnhomework.dto.company.recordwork.request.EnterWorkRequest;
import com.preproject.inflearnhomework.dto.company.recordwork.request.LeaveWorkRequest;
import com.preproject.inflearnhomework.dto.company.recordwork.response.ViewWorkResponse;
import com.preproject.inflearnhomework.dto.company.team.request.TeamCreateRequest;
import com.preproject.inflearnhomework.dto.company.team.response.TeamListResponse;
import com.preproject.inflearnhomework.service.company.CompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/create/team")
    public void createTeam(@RequestBody TeamCreateRequest request){
        companyService.createTeam(request.getName(),request.getManager(),request.getVacationStandardDate());
    }

    @PostMapping("/create/member")
    public void createMember(@RequestBody MemberCreateRequest request){
        companyService.createMember(request.getName(),request.getTeamName(),request.isRole(),request.getBirthday(),request.getWorkStartDate());
    }

    @GetMapping("/view/teamlist")
    public List<TeamListResponse> viewTeamList(){
        return companyService.teamList();
    }

    @GetMapping("/view/memberlist")
    public List<MemberListResponse> viewMemberList(){
        return companyService.memberList();
    }

    @PostMapping("/record/enter")
    public void enterCompany(@RequestBody EnterWorkRequest request){
        companyService.enterWork(request.getName(),request.getToday(),request.getEnter());
    }

    @PostMapping("/record/leave")
    public void leaveCompany(@RequestBody LeaveWorkRequest request){
        companyService.leaveWork(request.getName(), request.getToday(),request.getLeave());
    }

    @GetMapping("view/memberwork")
    public ViewWorkResponse viewMemberWork(@RequestParam long id, @RequestParam String year_month){
        return companyService.viewMemberWork(id,year_month);
    }

    @GetMapping("view/membervacation")
    public MemberVacationResponse vacationResponse(@RequestParam long id){
        return companyService.vacationResponse(id);
    }

}
