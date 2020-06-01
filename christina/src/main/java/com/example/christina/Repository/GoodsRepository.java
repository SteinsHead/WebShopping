package com.example.christina.Repository;

import com.example.christina.enity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*
* 商品的Repository接口，想要自定义的方法写在这里面就可以了
* 剩下的功能都可以添加
 */
public interface GoodsRepository extends JpaRepository<Goods, Integer> {
    List<?> findBygoodname(String goodname);
}
