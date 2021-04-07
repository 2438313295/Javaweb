package com.ml.dao;

import java.util.ArrayList;
import java.util.HashMap;

public interface ProductCateGroyDao {
    //抽象出对这两张表要进行的操作--查询图书信息，图书类别名称，图书描述信息
    public ArrayList<HashMap<String, String>> getProductCategory();

    //查询图书名称、图书类别名称、图书描述信息，图书类别描述信息
    public ArrayList<HashMap<String, String>> getProductCategory1();
}


