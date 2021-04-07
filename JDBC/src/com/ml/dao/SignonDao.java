package com.ml.dao;

import com.ml.entity.Signon;

import java.util.ArrayList;

//抽象出对该表的主要操作
public interface SignonDao {
    //1.根据用户名和密码的查询
    public ArrayList<Signon> getSignonByUnameAndPwd(String uname,String pwd);
    //2.插入操作
    public  void insertSignon(String uname,String pwd);
    //3.查询所有信息
    public ArrayList<Signon> getAllSignon();
    //4.根据用户名和密码的查询
    public ArrayList<Signon> getSignonByUnameAndPwd(String[] param);
    //5,一次插入多个用户信息
    public  void insertSignon(String uname1,String pwd1,String uname2,String pwd2);
}
