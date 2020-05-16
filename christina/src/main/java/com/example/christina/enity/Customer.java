package com.example.christina.enity;

/*
* 顾客的实体类，目前的属性是用户名和密码
* 更多的属性以后再慢慢添加
 */
public class Customer {
    private String userName;    //用户名属性
    private String passWord;    //密码属性
    /*
    * 这里的剩余信息。例如邮箱，电话号码，身份证号之类的酌情看看是否需要添加
    * 目前先这些吧
     */

    // set方法
    public void setUserName(String userName){
        this.userName = userName;
    }
    public void setPassWord(String passWord){
        this.passWord = passWord;
    }

    // get方法
    public String getUserName(){
        return userName;
    }
    public String getPassWord(){
        return passWord;
    }
}
