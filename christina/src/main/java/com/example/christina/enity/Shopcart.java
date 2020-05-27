package com.example.christina.enity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Shopcart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "goodname", nullable = false)
    private String goodname;

    @Column(name = "goodnumber", nullable = false)
    private Integer goodnumber;

    @Column(name = "price", nullable = false)
    private double price;   //总价

}
