package com.example.christina.Repository;

import com.example.christina.enity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Administrator, Integer> {
    List<?> findByadminname(String adminname);
}
