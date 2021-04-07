package com.ml.daoimp;

import com.ml.dao.SignonDao;
import com.ml.entity.Signon;
import com.ml.util.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//继承工具类，实现dao接口
public class SignonDaoImp extends database implements SignonDao {
    @Override
    public ArrayList<Signon> getSignonByUnameAndPwd(String uname, String pwd) {
        //1.定义存储数据的集合
        ArrayList<Signon> slist =new ArrayList<Signon>();
        //2.遍历数据表将数据存储在集合内
        String sql="select * from signon where username='"+uname+"' and password='"+pwd+"'";
        ResultSet rs=this.getResult(sql);
        try {
            while (rs.next()){
                Signon signon =new Signon(rs.getString("username"),rs.getString("password"));
                slist.add(signon);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return slist;
    }

    @Override
    public void insertSignon(String uname, String pwd) {
        String sql="insert into signon values('"+uname+"','"+pwd+"')";
//                this.executeDML(sql);
    }
//查询Signon表的所有信息
    @Override
    public ArrayList<Signon> getAllSignon() {
        //1.定义数据存储的中间载体
        ArrayList<Signon> slist=new ArrayList<Signon>();
        //2.遍历数据表，将数据存储在中间载体（集合）中
        String sql="select * from signon";
        ResultSet rs=this.getResult(sql);
        try {
            while (rs.next()){
                String uname=rs.getString("username");
                String pwd=rs.getString("password");
                Signon signon= new Signon();
                signon.setUsername(uname);
                signon.setPassword(pwd);
                slist.add(signon);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return slist;
    }

    @Override
    public ArrayList<Signon> getSignonByUnameAndPwd(String[] param) {
        //1.定义存储数据的集合
        ArrayList<Signon> slist =new ArrayList<Signon>();
        //2.遍历数据表将数据存储在集合内
        String sql="select * from signon where username=? and password=?";
        ResultSet rs=this.getResult(sql,param);

        try {
            while (rs.next()){
                Signon signon =new Signon(rs.getString("username"),rs.getString("password"));
                slist.add(signon);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return slist;
    }

    @Override
    public void insertSignon(String uname1, String pwd1, String uname2, String pwd2) {
        String sql1= "insert into signon values('" + uname1 +"','"+pwd1+"')";
        String sql2= "insert into signon values('" + uname2 +"','"+pwd2+"')";
        try {
            //1.设置手动提交
            this.getConn().setAutoCommit(false);
            this.executeDML(sql1);
            this.executeDML(sql2);
            System.out.println("提交正常");
            //进行手动提交
            this.getConn().commit();
        } catch (SQLException throwables) {
            System.out.println("提交错误，进行回滚");
            try {
                this.getConn().rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        }
    }

}
