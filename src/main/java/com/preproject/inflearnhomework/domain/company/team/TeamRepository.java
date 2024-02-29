package com.preproject.inflearnhomework.domain.company.team;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team,String> {

    boolean existsByName(String name);
    Team findTeamByName(String name);


}
