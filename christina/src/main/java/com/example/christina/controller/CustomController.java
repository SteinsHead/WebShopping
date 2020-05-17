package com.example.christina.controller;

import com.example.christina.Repository.CustomRepository;
import com.example.christina.enity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "customer")
public class CustomController {

    @Autowired
    private CustomRepository customRepository;

    @PostMapping(path = "addCustomer")
    public void addCustomer(@RequestBody Customer customer){
        customRepository.save(customer);
    }

    @DeleteMapping(path = "deleteCustomer")
    public void deleteCustomer(@RequestBody Customer customer){
        customRepository.delete(customer);
    }

}
