package com.preproject.inflearnhomework.domain.company.team;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    String name;

    String manager;

    int memberCount;

    public Team(String name, String manager) {
        this.name = name;
        this.manager = manager;
    }
    public Team(){}

    public void addMemberCount() {
        ++memberCount;
    }



}
