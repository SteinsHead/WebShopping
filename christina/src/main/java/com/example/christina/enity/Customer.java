package com.example.christina.enity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/*
* 顾客的实体类，目前的属性是用户名和密码
* 更多的属性以后再慢慢添加
 */
@Entity
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username", nullable = false)
    private String username;    //用户名属性

    @Column(name = "password", nullable = false)
    private String password;    //密码属性
    /*
    * 这里的剩余信息。例如邮箱，电话号码，身份证号之类的酌情看看是否需要添加
    * 目前先这些吧
     */

}
