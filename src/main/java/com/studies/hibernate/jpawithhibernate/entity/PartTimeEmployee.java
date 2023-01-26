package com.studies.hibernate.jpawithhibernate.entity;

import java.math.BigDecimal;
// Change from jakarta to jakarta
import jakarta.persistence.Entity;

@Entity
public class PartTimeEmployee extends employee {

    protected PartTimeEmployee() {
    }

    public PartTimeEmployee(String name, BigDecimal hourlyWage) {
        super(name);
        this.hourlyWage = hourlyWage;
    }

    private BigDecimal hourlyWage;

}