package com.example.christina.enity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/*
* 管理员的实体类，目前的属性是管理员的用户名和密码
* 更多的属性以后添加
 */
@Entity
@Getter
@Setter
public class Administrator {
    //设置id作为自增主键
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "adminname", nullable = false)
    private String adminname;       //管理员用户名

    @Column(name = "adminpassword", nullable = false)
    private String adminpassword;   //管理员密码
    /*
    * 暂时没想到别的什么属性，先暂时这样吧
    * 233
     */

}
