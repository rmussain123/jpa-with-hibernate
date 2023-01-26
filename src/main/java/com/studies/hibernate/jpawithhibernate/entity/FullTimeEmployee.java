package com.studies.hibernate.jpawithhibernate.entity;

import java.math.BigDecimal;
// Change from jakarta to jakarta
import jakarta.persistence.Entity;

@Entity
public class FullTimeEmployee extends employee {
    protected FullTimeEmployee() {
    }

    public FullTimeEmployee(String name, BigDecimal salary) {
        super(name);
        this.salary = salary;
    }

    private BigDecimal salary;

}