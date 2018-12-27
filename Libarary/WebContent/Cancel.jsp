<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
response.setContentType("text;charset=UTF-8");
//这两句是为了外联的js和css有效
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";


%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" type="text/css" href="<%=basePath %>css/Cancel.css">
<meta http-equiv="Content-Type" content="%=basePath %>text/html; charset=UTF-8">

<script src = "<%=basePath %>js/jQuery.js" ></script>
<script src = "<%=basePath %>js/Cancel.js" ></script>
<title>注销页面</title>
</head>
<body>


<div id="top">
	<ul class = "top_ul">
		<li class = "dropdown" >
			<a>读者管理</a>
			<ul  class = "menu">
				<li><a href = "http://localhost:8080/Libarary/ReaderManager.jsp">读者管理</a></li>
				<li><a href = "http://localhost:8080/Libarary/Cancel.jsp">挂失和注销</a></li>
			</ul>
		</li>
		<li class = "dropdown" >
			<a>图书管理</a>
			<ul  class = "menu">
				<li><a href = "http://localhost:8080/Libarary/BookManager.jsp">新书入库</a></li>
				<li><a href = "http://localhost:8080/Libarary/QueryManager.jsp">图书查询</a></li>
				<li><a href = "http://localhost:8080/Libarary/BookUpdate.jsp">图书修改</a></li>
			</ul>
		</li>
		<li class = "dropdown" >
			<a href = "http://localhost:8080/Libarary/Borrow.jsp">借阅管理</a>
		</li>
		<li class = "dropdown" >
			<a href = "http://localhost:8080/Libarary/ReaderTypeManager.jsp">用户管理</a>
		</li>

	</ul>
</div>


<div class="rdID">
	<table align = "center">
	<tr>
	<td width = "100px">读者编号</td>
	<td width = "100px"><input type = "text"  id ="rdID" "/></td>
	<td width ="100px"><input type = "button"value= "查询" onclick  ="find()"/></td>
	</tr>
	<tr>
	<td width = "100px">读者姓名</td>
	<td width = "100px"><input type = "text" id = "rdName" disabled/></td>
	<td >读者性别</td>
	<td width = "100px"><input type="text" id ="rdSex" disabled/></td>
	</tr>
	<tr>
	<td width = "100px">读者类别</td>
	<td width = "100px"><input type = "text" id = "rdType" disabled/></td>
	<td >读者状态</td>
	<td width = "100px"><input type = "text" id = "rdStatus" disabled/></td>
	</tr>
	</table>

</div>


<div id = "last">
<input type = "button" value = "挂失" onclick = "lost()"/>
<input type = "button" value = "取消挂失" onclick = "removeLost()"/>
<input type = "button" value = "注销" onclick = "cancel()"/>
</div>


</body>
</html>