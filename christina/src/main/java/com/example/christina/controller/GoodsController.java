package com.example.christina.controller;

import com.example.christina.Repository.GoodsRepository;
import com.example.christina.enity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "goods")
public class GoodsController {

    @Autowired
    private GoodsRepository goodsRepository;

    @PostMapping(path = "addGoods")
    public void addGoods(Goods goods){
        goodsRepository.save(goods);
    }

    @DeleteMapping(path = "deleteGoods")
    public void deleteGoods(Goods goods){
        goodsRepository.delete(goods);
    }
}
