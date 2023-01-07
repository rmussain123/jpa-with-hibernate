package com.studies.hibernate.jpawithhibernate.controller;


import com.studies.hibernate.jpawithhibernate.model.Address;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class AddressController {

    @RequestMapping("/get-address")
    public List<Address> retrieveAllAddress() {
        return Arrays.asList(new Address("Hussain", "22", "New Street", "Salem", "Tamilnadu"));

    }
}
