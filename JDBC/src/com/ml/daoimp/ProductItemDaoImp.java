package com.ml.daoimp;

import com.ml.dao.ProductItemDao;
import com.ml.util.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class ProductItemDaoImp extends database implements ProductItemDao {
    @Override
    public ArrayList<HashMap<String, Object>> getProductItem() {
        //定义数据存储的中间载体（集合）
        ArrayList<HashMap<String,Object>> pilist=new ArrayList<HashMap<String,Object>>();
        //遍历数据库，将数据存储在集合（pilist）中
        String sql="SELECT p.name name,i.listprice listprice,i.status STATUS FROM product p,item i WHERE p.productid=i.productid;";
        ResultSet rs=this.getResult(sql);
        try {
            while(rs.next()){
                HashMap<String,Object> map=new HashMap<String,Object>();
                map.put("name",rs.getString("name"));
                map.put("listprice",rs.getString("listprice"));
                map.put("status",rs.getString("status"));
                pilist.add(map);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return pilist;
    }
}
