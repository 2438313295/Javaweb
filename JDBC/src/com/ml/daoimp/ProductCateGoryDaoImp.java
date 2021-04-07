package com.ml.daoimp;

import com.ml.dao.ProductCateGroyDao;
import com.ml.util.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class ProductCateGoryDaoImp extends database implements ProductCateGroyDao {

    @Override
    public ArrayList<HashMap<String, String>> getProductCategory() {
        //1.定义数据存储的中间结构（集合）
        ArrayList<HashMap<String, String>> pclist = new ArrayList<HashMap<String, String>>();
        //2.遍历数据库，将数据库中的记录存储在集合中
        String sql = "select p.name pname,c.name cname,p.descn from product p,category c where p.category=c.catid";
        ResultSet rs = this.getResult(sql);
        try {
            while (rs.next()) {
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("pname", rs.getString("pname"));//将图书名称字段及数据放在map中
                map.put("cname", rs.getString("cname"));//将图书类别字段及数据放在map中
                map.put("descn", rs.getString("descn"));//将图书描述字段及数据放在map中
                pclist.add(map);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return pclist;
    }

    @Override
    public ArrayList<HashMap<String, String>> getProductCategory1() {
        //1.定义数据存储的中间结构（集合）
        ArrayList<HashMap<String, String>> pclist = new ArrayList<HashMap<String, String>>();
        //2.遍历数据库，将数据库中的记录存储在集合中
        String sql = "select p.name pname,c.name cname,p.descn pdescn,c.descn cdescn from product p,category c where p.category=c.catid";
        ResultSet rs = this.getResult(sql);
        try {
            while (rs.next()) {
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("pname", rs.getString("pname"));//将图书名称字段及数据放在map中
                map.put("cname", rs.getString("cname"));//将图书类别字段及数据放在map中
                map.put("pdescn", rs.getString("pdescn"));//将图书描述字段及数据放在map中
                map.put("cdescn", rs.getString("cdescn"));//将图书描述字段及数据放在map中
                pclist.add(map);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return pclist;
    }
}
