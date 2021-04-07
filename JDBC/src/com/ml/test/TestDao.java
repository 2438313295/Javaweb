package com.ml.test;
import com.ml.daoimp.ProductCateGoryDaoImp;
import com.ml.daoimp.ProductItemDaoImp;
import com.ml.daoimp.SignonDaoImp;
import com.ml.entity.Signon;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class TestDao {
    @Test
    public void testSignonIn() {
        SignonDaoImp sdi = new SignonDaoImp();
        ArrayList<Signon> slist = sdi.getSignonByUnameAndPwd("aaa", "123");
        if (slist.size() > 0)
            System.out.println("success");
        else
            System.out.println("error");
    }

    @Test
    public void textSelect() {
        SignonDaoImp sdi = new SignonDaoImp();
        ArrayList<Signon> slist = sdi.getAllSignon();
        for (Signon signon : slist) {
            System.out.println(signon);
        }
    }

    @Test
    public void testInsert1() {
        SignonDaoImp sdi = new SignonDaoImp();
        sdi.insertSignon("m001", "m001");
    }

    //测试同时提交两组数据
    @Test
    public void testInsert2() {
        SignonDaoImp sdi = new SignonDaoImp();
        sdi.insertSignon("m007", "m007", "moo8", "m008");
    }

    @Test
    public void testSelect1() {
        ProductCateGoryDaoImp pcdi = new ProductCateGoryDaoImp();
        ArrayList<HashMap<String, String>> pclist = pcdi.getProductCategory();
        //输出测试
        for (HashMap<String, String> map : pclist) {

            System.out.println(map.get("pname") + "\t" + map.get("cname") + "\t" + map.get("descn"));
        }

    }

    @Test
    public void testSelect2() {
        ProductCateGoryDaoImp pcdi = new ProductCateGoryDaoImp();
        ArrayList<HashMap<String, String>> pclist = pcdi.getProductCategory1();
        //输出测试
        for (HashMap<String, String> map : pclist) {

            System.out.println(map.get("pname") + "\t\t\t\t" + map.get("cname") + "\t" + map.get("pdescn") + "\t" + map.get("cdescn"));
            System.out.println("---------------------------------");
        }

    }

    @Test
    public void testProItem() {
        ProductItemDaoImp pidi = new ProductItemDaoImp();
        ArrayList<HashMap<String, Object>> pilist = pidi.getProductItem();
        for (HashMap<String, Object> map : pilist) {
            System.out.println(map.get("name") + "\t" + map.get("listprice") + "\t" + map.get("status"));
        }
    }
    @Test
    public void  test(){
        System.out.println("helloword");

    }
}
