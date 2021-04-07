package com.ml.util;

import java.sql.*;
import java.util.ArrayList;

//工具类
public class database {
    //抽取重复的属性，构成该类的成员变量
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/bookstore?characterEncoding=utf-8";
    String username = "root";
    String password = "003513";
    Connection conn = null;
    Statement sm = null;
    ResultSet rs = null;
    PreparedStatement ps = null;

    //抽取重复的操作，构成该类的成员方法
    public database() {
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
    }

    //查询数据库，获取结果集
    public ResultSet getResult(String sql) {
        try {
            rs = sm.executeQuery(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rs;
    }

    //优化查询1--通用
    public ResultSet getResult(String sql, Object[] param) {
        try {
            ps = conn.prepareStatement(sql);//预加载方式
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    ps.setObject(i + 1, param[i]);
                }
            }
            rs = ps.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rs;
    }

    //优化查询2--通用
    public ResultSet getResult(String sql, ArrayList param) {
        try {
            ps = conn.prepareStatement(sql);
            if (param != null) {
                for (int i = 0; i < param.size(); i++) {
                    ps.setObject(i + 1, param.get(i));
                }
            }
            rs = ps.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rs;
    }

    //增删改DML
    public void executeDML(String sql) throws SQLException {

            sm.executeUpdate(sql);

    }

    //关闭资源
    public void close() {
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

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
}
