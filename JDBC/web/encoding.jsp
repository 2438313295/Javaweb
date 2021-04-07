<%--
  Created by IntelliJ IDEA.
  User: 哲际
  Date: 2021/3/31
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>

<%--language,确定脚本语言--%>
<%@page language="java" contentType="text/html;charset=gbk" pageEncoding="gbk" %>
<html>
<%--1. iso-8859-1 英文
    2. utf-8
    3.gbk
    4.gb2312
    解决乱码：统一编码集
    --%>
<head>
    <title>测试编码集</title>
</head>
<body>

    <%
    out.print("hello world 你好 ！");

    %>
</body>

</html>