package com.example.christina.enity;

/*
* 管理员的实体类，目前的属性是管理员的用户名和密码
* 更多的属性以后添加
 */
public class Administrator {
    private String adminName;       //管理员用户名
    private String adminPassWord;   //管理员密码
    /*
    * 暂时没想到别的什么属性，先暂时这样吧
    * 233
     */

    // set方法
    public void setAdminUserName(String adminName){
        this.adminName = adminName;
    }
    public void setAdminPassWord(String adminPassWord){
        this.adminPassWord = adminPassWord;
    }

    // get方法
    public String getAdminUserName(){
        return adminName;
    }
    public String getAdminPassWord(){
        return adminPassWord;
    }
}
