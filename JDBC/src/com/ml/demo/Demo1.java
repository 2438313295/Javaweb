package com.ml.demo;

import java.sql.*;
import java.util.Scanner;

public class Demo1 {
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/bookstore?characterEncoding=utf-8";
    static String username = "root";
    static String password = "003513";

    public static void main(String[] args) {
        Connection conn = null;
        Statement sm = null;
        ResultSet rs = null;
        try {
            //1.加载驱动
            Class.forName(driver);
            //2.建立连接
            conn = DriverManager.getConnection(url, username, password);
            //3.执行sql语句
            sm = conn.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            
        }
        //利用标准输入输出流来输入数据
        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户名");
        String uname = input.next();
        System.out.println("请输入密码");
        String pwd = input.next();
        String sql = "SELECT * FROM signon WHERE username='" + uname + "' AND password='" + pwd + "'";
        try {
            rs = sm.executeQuery(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        boolean flag = false;
        while (true) {
            try {
                if (!rs.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            flag = true;
        }
        if (flag) {
            System.out.println("登陆成功");
        } else
            System.out.println("登陆失败");

        try {
            rs.close();
            sm.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}


