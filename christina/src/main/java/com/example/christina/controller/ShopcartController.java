package com.example.christina.controller;

import com.example.christina.Repository.ShopcartRepository;
import com.example.christina.enity.Shopcart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "shopcart")
public class ShopcartController {

    @Autowired
    private ShopcartRepository shopcartRepository;

    @PostMapping(path = "addShopcart")
    public void addShopcart(@RequestBody Shopcart shopcart){
        shopcartRepository.save(shopcart);
    }

    @DeleteMapping(path = "deleteShopcart")
    public void deleteShopcart(@RequestBody Shopcart shopcart){
        shopcartRepository.delete(shopcart);
    }


}
