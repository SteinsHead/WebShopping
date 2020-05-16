package com.example.christina.enity;

/*
* 商家的实体类，
* 剩下的属性后面再添加吧233
 */
public class Store {
    private String storeName;       //商家用户名
    private String storePassWord;   //商家密码
    private int storeId;            //店铺的id号码

    // set方法
    public void setStoreName(String storeName){
        this.storeName = storeName;
    }
    public void setStorePassWord(String storePassWord){
        this.storePassWord = storePassWord;
    }
    public void setStoreId(int storeId){
        this.storeId = storeId;
    }

    // get方法
    public String getStoreName(){
        return storeName;
    }
    public String getStorePassWord(){
        return storePassWord;
    }
    public int getStoreId(){
        return storeId;
    }
}
