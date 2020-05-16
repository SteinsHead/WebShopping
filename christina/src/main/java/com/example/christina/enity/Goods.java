package com.example.christina.enity;

/*
* 商品的实体类，分别有商品的图片属性，名称属性，价格属性。
* 更多的属性以后再慢慢添加。
 */
public class Goods {
    private String cover;       //商品图片，用cover表示
    private String goodName;    //商品名称
    private double price;       //商品价格

    //定义set方法
    public void setCover(String cover){
        this.cover = cover;
    }
    public void setGoodName(String goodName){
        this.goodName = goodName;
    }
    public void setPrice(double price){
        this.price = price;
    }

    //定义get方法
    public String getCover(){
        return cover;
    }
    public String getGoodName(){
        return goodName;
    }
    public double getPrice(){
        return price;
    }
}
