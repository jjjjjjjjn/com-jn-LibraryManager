<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/"; %>
<html>
<script type="text/javascript" src="statics/js/jquery-1.8.3.min.js"></script>
<script>
    function click1() {

        alert("123");

    }

</script>
<head>
    <title>用户界面</title>
</head>
<body id="tBody">
你好：${name}
你的id是：${uid}
你的余额为:${money}
用户界面

<div id="div1"></div>

<input type="button" onclick="click1()" name="button1" id="bu" value="点击">

</body>
</html>
