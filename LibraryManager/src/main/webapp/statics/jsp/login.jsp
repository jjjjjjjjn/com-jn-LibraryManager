<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/11/29
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<% String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/"; %>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset=UTF-8>
    <title>Title</title>
</head>
<body>
<h2 align="center">
    图书借阅与管理系统<br><br><br><br>
    请登录查看信息<br><br><br><br>
<form action="login" method="post" >
    <input type="text" name="name" value="jiaonan" ><br><br>
    <input type="password" name="password" value="123456" ><br><br>
    <input type="submit" value="登陆">
</form>
    <br><br><br><br>
    <br><br><br><br>
    所有种类
    <form action="showType" method="post" >
        <input type="submit" value="showType">
    </form>
    <br><br><br><br>
    <br><br><br><br>
     按种类展示书籍
    <form action="showByType" method="post" >
        <input type="text" name="type" value="A马克思主义、列宁主义、毛泽东思想、邓小平理论" ><br><br>
        <input type="text" name="pageNo"  value="2"><br><br>
        <input type="submit" value="showByType">
    </form>
    <br><br><br><br>
    <br><br><br><br>
     搜索书籍
    <form action="searchbook" method="post" >
        <input type="text" name="name" value="中国" ><br><br>
        <input type="text" name="pageNo"  value="2"><br><br>
        <input type="submit" value="searchbook">
    </form>
    <br><br><br><br>
    <br><br><br><br>
    借书
    <form action="lend" method="post" >
        <input type="text" name="book_id" value="2" ><br><br>
        <input type="submit" value="lend">
    </form>

    <br><br><br><br>
    <br><br><br><br>

    查看借书记录
    <form action="lendRecord" method="post" >
        <input type="text" name="pageNo" value="1" ><br><br>
        <input type="submit" value="lendRecord">
    </form>

    <br><br><br><br>
    <br><br><br><br>
     还书
    <form action="return1" method="post" >
        <input type="text" name="re_id" value="re_id" ><br><br>
        <input type="text" name="book_id" value="book_id" ><br><br>
        <input type="submit" value="return1">
    </form>
    <br><br><br><br>
    <br><br><br><br>
    用户更改用户名和密码
    <form action="userSelfupdate" method="post" >
        <input type="text" name="oldname" value="jiaonan" ><br><br>
        <input type="password" name="oldpassword"  value="123456"><br><br>
        <input type="text" name="newname" value="jiaonan1" ><br><br>
        <input type="password" name="newpassword"  value="123456"><br><br>
        <input type="submit" value="userSelfupdate">
    </form>

    <br><br><br><br>
    <br><br><br><br>
    搜索用户
    <form action="searchuser" method="post" >
        <input type="text" name="user_id" value="111" ><br><br>
        <input type="text" name="user_name"  value="jianan"><br><br>
        <input type="submit" value="searchuser">
    </form>

    <br><br><br><br>
    <br><br><br><br>
    增加用户
    <form action="adduser" method="post" >
        <input type="text" name="user_name" value="jiaonan" ><br><br>
        <input type="text" name="user_password"  value="123456"><br><br>
        <input type="text" name="money" value="100" ><br><br>
        <input type="submit" value="adduser">
    </form>

    <br><br><br><br>
    <br><br><br><br>
    删除用户
    <form action="deleteuser" method="post" >
        <input type="text" name="user_id" value="111" ><br><br>
        <input type="submit" value="deleteuser">
    </form>

    <br><br><br><br>
    <br><br><br><br>
    修改用户信息
    <form action="changeuser" method="post" >

        <input type="text" name="olduser_id" value="111" ><br><br>
        <input type="text" name="olduser_name"  value="jiaonan"><br><br>
        <input type="text" name="olduser_password"  value="123456"><br><br>

        <input type="text" name="user_name"  value="jiaonan"><br><br>
        <input type="text" name="user_password"  value="123456"><br><br>
        <input type="text" name="money" value="100" ><br><br>
        <input type="text" name="lnumber" value="100" ><br><br>
        <input type="submit" value="changeuser">
    </form>


</h2>

</body>
</html>
