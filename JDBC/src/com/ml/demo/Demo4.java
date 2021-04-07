package com.ml.demo;

import com.ml.daoimp.SignonDaoImp;
import com.ml.entity.Signon;

import java.util.ArrayList;

public class Demo4 {
//利用dao模式，实现遍历输出signon表所有信息
    public static void main(String[] args) {
        SignonDaoImp sdi=new SignonDaoImp();
        ArrayList<Signon> slist= sdi.getAllSignon();//得到了所有信息
        for (Signon signon:slist){
            System.out.println(signon);
        }

    }
}
