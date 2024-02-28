package com.preproject.inflearnhomework.domain.fruit;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
@Getter
public class Fruit2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    private String name;


    private Date warehousing_date;

    private long price;

    @Column(nullable = true)
    @JsonIgnore
    private boolean sales;

    public Fruit2(){}

    public Fruit2(String name, Date warehousing_date, long price, boolean sales) {
        this.name = name;
        this.warehousing_date = warehousing_date;
        this.price = price;
        this.sales = sales;
    }


}
