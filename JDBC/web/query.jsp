<%@ page import="com.ml.daoimp.SignonDaoImp" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ml.entity.Signon" %><%--
  Created by IntelliJ IDEA.
  User: 哲际
  Date: 2021/4/6
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>显示用户信息</title>
</head>
<body>
    <%
        SignonDaoImp sdi=new SignonDaoImp();
        ArrayList<Signon> slist=sdi.getAllSignon();
        for(Signon signon:slist){
            out.println(signon.getUsername()+"/t/t"+signon.getPassword() );
            out.print("<br/>");
        }
    %>
</body>
</html>
