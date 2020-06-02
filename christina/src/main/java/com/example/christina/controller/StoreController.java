package com.example.christina.controller;

import com.example.christina.Repository.StoreRepository;
import com.example.christina.enity.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "store")
public class StoreController {

    @Autowired
    StoreRepository storeRepository;

    @PostMapping(path = "addStore")
    public void addStore(@RequestBody Store store){
        storeRepository.save(store);
    }

    @DeleteMapping(path = "deleteStore")
    public void deleteStore(@RequestBody Store store){
        storeRepository.delete(store);
    }

    @GetMapping(path = "getAllStores")
    public List<?> getAllStores(){
        return storeRepository.findAll();
    }

    @GetMapping(path = "getStore")
    public List<?> getStores(@RequestParam String storename){
        return storeRepository.findBystorename(storename);
    }
}
