package com.example.christina.Repository;

import com.example.christina.enity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomRepository extends JpaRepository<Customer, Integer> {

}
