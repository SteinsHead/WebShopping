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

    /*
    * 添加商品
     */
    @PostMapping(path = "addGoods")
    public void addGoods(@RequestBody Goods goods){
        goodsRepository.save(goods);
    }

    /*
    * 删除商品
     */
    @DeleteMapping(path = "deleteGoods")
    public void deleteGoods(@RequestBody Goods goods){
        goodsRepository.delete(goods);
    }

    /*
    * 根据商品名称来查询商品
    * 查询结果使用List来列出
     */
    @GetMapping(path = "getGoods")
    public List<Goods> getGoods(@RequestParam String goodname){
        return goodsRepository.findBygoodname(goodname);
    }
}
