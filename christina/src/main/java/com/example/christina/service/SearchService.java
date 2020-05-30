package com.example.christina.service;

import com.example.christina.controller.GoodsController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    @Autowired
    private GoodsController goodsController;

    /*
    * 查询商品操作
     */
    public List<?> Search(String goodsname) {
        return goodsController.getGoods(goodsname);
    }

}
