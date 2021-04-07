package com.ml.demo;

import java.sql.*;

public class Demo3 {
    //实现对signon和account表的同时操作 引入事务机制
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
            //利用标准输入输出流来输入数据  --begin
            String sql1 = "insert into signon values('test3','test123')";
            String sql2 = "insert into account(userid,email) values('test3','123456')";
            sm = conn.createStatement();
            try {
                //事务第一步
                conn.setAutoCommit(false);
                sm.executeUpdate(sql1);
                sm.executeUpdate(sql2);
                //事务第二步
                conn.commit();
                System.out.println("插入成功");
            } catch (SQLException throwables) {
                System.out.println("插入失败，进行回滚");
                //事务第三步
                conn.rollback();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (rs != null)
                rs.close();
            if (sm != null)
                sm.close();
            if (conn != null)
                conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}


