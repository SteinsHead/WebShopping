package com.example.christina.enity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/*
* 商家的实体类，
* 剩下的属性后面再添加吧233
 */
@Entity
@Getter
@Setter
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer storeId;            //店铺的id号码

    @Column(name = "storename", nullable = false)
    private String storename;       //商家用户名

    @Column(name = "storepassword", nullable = false)
    private String storepassword;   //商家密码


}
