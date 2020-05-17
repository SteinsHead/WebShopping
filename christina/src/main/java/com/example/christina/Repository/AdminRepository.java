package com.example.christina.Repository;

import com.example.christina.enity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Administrator, Integer> {
    Administrator findByadminname(String adminname);
}
