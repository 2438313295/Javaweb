package com.ml.demo;

import java.sql.*;
import java.util.Scanner;

public class Demo2 {
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/bookstore?characterEncoding=utf-8";
    static String username = "root";
    static String password = "003513";

    public static void main(String[] args){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //1.加载驱动
            Class.forName(driver);
            //2.建立连接
            conn = DriverManager.getConnection(url, username, password);
            //3.执行sql语句
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //利用标准输入输出流来输入数据
        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户名");
        String uname = input.nextLine();
        System.out.println("请输入密码");
        String pwd = input.nextLine();
        //preparedStatement----begin
        String sql="select * from signon where username=? and password=?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,uname);
            ps.setString(2,pwd);
            rs=ps.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        //preparedStatement----end
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
            if (rs!=null)
            rs.close();
            if (ps!=null)
            ps.close();
            if (conn!=null)
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}


