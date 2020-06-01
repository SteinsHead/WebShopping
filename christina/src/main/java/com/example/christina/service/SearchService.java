package com.example.christina.service;

import com.example.christina.controller.GoodsController;
import com.example.christina.controller.StoreController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    @Autowired
    private GoodsController goodsController;

    @Autowired
    private StoreController storeController;

    /*
    * 查询商品操作
     */
    public List<?> SearchGood(String goodsname) {
        return goodsController.getGoods(goodsname);
    }

    /*
    * 查询店铺操作
     */
    public List<?> SearchStore(String storename) {
        return storeController.getStores(storename);
    }

    /*
    * 总的查询操作
     */
    

}
