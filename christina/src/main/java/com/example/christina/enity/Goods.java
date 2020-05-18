package com.example.christina.enity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/*
* 商品的实体类，分别有商品的图片属性，名称属性，价格属性。
* 更多的属性以后再慢慢添加。
 */
@Entity
@Getter
@Setter
public class Goods {
    //设置ID作为自增主键
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //标识id可以被初始化
    private Integer id;

    //考虑到商品图片存储的字符串可能很长，暂时不限制长度了，名称也是同理
    @Column(name = "cover", nullable = true /*length = 20*/)     //商品图片，用cover表示
    private String cover;

    @Column(name = "goodname", nullable = true /*length = 20*/)  //商品名称
    private String goodname;

    @Column(name = "price")     //商品价格
    private double price;//float型在大数上有一些问题，于是改成了double型

}
