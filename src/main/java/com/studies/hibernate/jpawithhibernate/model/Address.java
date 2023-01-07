package com.studies.hibernate.jpawithhibernate.model;

import lombok.Data;

@Data
public class Address {

    public Address(String name, String doorNo, String street, String city, String state) {
        this.name = name;
        this.doorNo = doorNo;
        this.street = street;
        this.city = city;
        this.state = state;
    }

    public String name;
    public String doorNo;


    public String street;
    public String city;
    public String state;

}
