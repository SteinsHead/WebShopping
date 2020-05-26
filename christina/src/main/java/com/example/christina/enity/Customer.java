package com.example.christina.enity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.example.christina.enity.idCard.validateAllCard;

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
    @Column(name = "telephone",length = 11, nullable = false)
    private String telephone;  //用户手机号码

    @Column(name = "Email", nullable = false)
    private String Email;//邮箱

    @Column(name = "RecAddress", nullable = false)
    private String Address;//收货地址

    @Column(name = "IDNum", nullable = false)
    private String IDNum;



    public boolean IfDigit(String str){
        //判断某字符串是否为纯数字
        for(int i = str.length(); --i >=0; ){
            if(Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public void SetTelephone(String telephone) {
        //设置手机号信息
        if(telephone.length()==11 && IfDigit(telephone)){
            this.telephone = telephone;
        }
        else{
            System.out.println("手机号码格式有误！");//当手机号格式有误时怎么报错？待完善。。。
        }
    }

    public static boolean isEmail(String string) {
        //判断邮箱合法性
        if (string == null)
            return false;
        String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern p;
        Matcher m;
        p = Pattern.compile(regEx1);
        m = p.matcher(string);
        if (m.matches())
            return true;
        else
            return false;
    }

    public void setEmail(String Email){
        if(isEmail(Email)){
            this.Email = Email;
        }
        else{
            System.out.println("邮箱格式有误！");
        }
    }

    public void setIDNum(String IDNum){
        if(validateAllCard(IDNum)){
            this.IDNum = IDNum;
        }
        else{
            System.out.println("您的身份证格式有误！");
        }
    }


}
