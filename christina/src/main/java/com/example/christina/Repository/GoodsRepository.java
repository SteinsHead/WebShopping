package com.example.christina.Repository;

import com.example.christina.enity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoodsRepository extends JpaRepository<Goods, Integer> {
    List<Goods> findBygoodname(String goodname);
}
