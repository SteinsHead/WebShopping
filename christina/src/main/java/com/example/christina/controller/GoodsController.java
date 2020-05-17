package com.example.christina.controller;

import com.example.christina.Repository.GoodsRepository;
import com.example.christina.enity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "goods")
public class GoodsController {

    @Autowired
    private GoodsRepository goodsRepository;

    @PostMapping(path = "addGoods")
    public void addGoods(@RequestBody Goods goods){
        goodsRepository.save(goods);
    }

    @DeleteMapping(path = "deleteGoods")
    public void deleteGoods(@RequestBody Goods goods){
        goodsRepository.delete(goods);
    }

    @GetMapping(path = "getGoods")
    public List<Goods> getGoods(String goodname){
        return goodsRepository.findBygoodname(goodname);
    }
}
