package com.example.christina.Repository;

import com.example.christina.enity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Integer> {
    List<Store> findBystorename (String storename);
}
