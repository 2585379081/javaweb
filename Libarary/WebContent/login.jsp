<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书管理系统</title>

<link rel="stylesheet" href="css/Login.css" type="text/css" media="screen" />
</head>
<body>
<h1 align = "center">图书管理系统</h1>

<iframe width='0' height='0' id="c" name="c" src="" frameborder="0"></iframe>
<div id="left" style="float:left; width:320px; margin-top: 175px; margin-left:140px;_margin-left:70px;"><!--20151105修复ie6/7错位-->
<div id="welcome" style="float:top; height:160px; text-align:left;" class="font1">                                                                                                                                                                                                                                                                                                                               
</div>
</div>
<div id="login" style="float:left; width:300px; height:245px; margin-top: 133px; margin-left:52px;">
<form method="post" action="servlet/LoginServlet" >
<img src = "image/1.png" width = "300px" height = "75px"/>
<div id="inputs">
<input id="username" name="rdID" type="text" placeholder="请输入账号" maxlength="26">
<input id="password" name="rdPwd" type="text" placeholder="请输入密码" maxlength="16">
</div>
<div id="btn" style="height:40px; ">
<input id="submit" type="submit" name="0MKKey" value="登　录" onclick="Clicked();" style="margin-left:34px;">
<input id="submit" type="reset" value="重　置" style="margin-left:15px;">
<input type="hidden" name="v6ip" value="">
</div>
<div id="save" style="float:left; width:130px; height:30px; margin-top:22px; margin-left:3px;" class="font1">
<input type="checkbox" value="1" name="save_me">
记住密码 
</div>
<div id="change" style="float:left; width:130px; height:30px; margin-top:22px; margin-left:25px;" class="font1"> <a href="a29.htm">修改密码</a> </div>
</form>
</div>

<%
String mes = request.getParameter("error");
if(mes!=null){
	if(mes.equals("1")){
		out.println("<div id = 'error'>用户名已挂失</div>");
	}else if(mes.equals("2")){
		out.println("<div id = 'error'>用户名已注销</div>");
	}else if(mes.equals("3")){
		out.println("<div id = 'error'>用户名密码错误</div>");
	}else{
		out.println("<div id = 'error'>用户名不存在</div>");
	}
}
%>
</body>
</html>