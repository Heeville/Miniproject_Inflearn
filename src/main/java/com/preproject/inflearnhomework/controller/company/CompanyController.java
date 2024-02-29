package com.preproject.inflearnhomework.controller.company;

import com.preproject.inflearnhomework.dto.company.member.request.MemberCreateRequest;
import com.preproject.inflearnhomework.dto.company.team.request.TeamCreateRequest;
import com.preproject.inflearnhomework.service.company.CompanyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/create/team")
    public void createTeam(@RequestBody TeamCreateRequest request){
        companyService.createTeam(request.getName(),request.getManager());
    }

    @PostMapping("/create/member")
    public void createMember(@RequestBody MemberCreateRequest request){
        companyService.createMember(request.getName(),request.getTeamName(),request.isRole(),request.getBirthday(),request.getWorkStartDate());
    }
}
