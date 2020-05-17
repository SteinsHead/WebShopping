package com.example.christina.controller;

import com.example.christina.Repository.AdminRepository;
import com.example.christina.enity.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "admin")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @PostMapping(path = "addAdmin")
    public void addAdmin(@RequestBody Administrator administrator){
        adminRepository.save(administrator);
    }

    @DeleteMapping(path = "deleteAdmin")
    public void deleteAdmin(@RequestBody Administrator administrator){
        adminRepository.delete(administrator);
    }

    @GetMapping(path = "getAdmin")
    public Administrator getAdmin(String adminname){
        return adminRepository.findByadminname(adminname);
    }
}
