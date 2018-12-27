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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书管理</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/BookManager.css">

<script src = "<%=basePath %>js/jQuery.js" ></script>
<script src = "<%=basePath %>js/BookManager.js" ></script>


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

<div id = "info">
<table >
<tr>
<td>图书起始序号</td>
<td><input type ="text" id ="bkID" disabled/></td>
</tr>
<tr>
<td>索书号</td>
<td><input type ="text" id = "bkCode"/></td>
</tr>
<tr>
<td>图书名称</td>
<td><input type ="text" id ="bkName"/></td>
</tr>
<tr>
<td>图书作者</td>
<td><input type ="text" id ="bkAuthor"/></td>
</tr>
<tr>
<td>出版商</td>
<td><input type ="text" id = "bkPress"/></td>
</tr>
<tr>
<td>出版日期</td>
<td><input type ="text" id = "bkDatePress"/></td>
</tr>
<tr>
<td>ISBN</td>
<td><input type ="text" id ="bkISBN"/></td>
</tr>
<tr>
<td>分类号</td>
<td><input type ="text" list= "typeList" id = "bkCatalog"/>
<datalist id = "typeList">
<option>TP312</option>
<option>ET312</option>
</datalist>
</td>
</tr>
<tr>
<td>分类名</td>
<td><input type ="text" id = "bkClassName" list ="typeBook"/></td>
<datalist id = "typeBook">
<option>计算机</option>
<option>文学</option>
</datalist>
</tr>
<tr>
<td>语言</td>
<td><input type ="text" list= "langList" id ="bkLanguage"/>
<datalist id = "langList">
<option>0-中文</option>
<option>1-英文</option>
</datalist>
</td>
</tr>
<tr>
<td>图书页面</td>
<td><input type ="text" id="bkPages"/></td>
</tr>
<tr>
<td>图书价值</td>
<td><input type ="text" id="bkPrice"/></td>
</tr>
<tr>
<td>入馆时间</td>
<td><input type ="text" id ="bkDateIn"/></td>
</tr>
<tr>
<td>图书本书</td>
<td><input type ="text" id ="bkNum"/></td>
</tr>
</table>
</div>


<div id = "introduce">
内容简介：<br/>

<textarea rows="20" cols="50" id= "bkBrief"></textarea>

</div>

<div id = "page">
封面：<br/>

	<div id = "right_image">
		<img  width ="350px" height ="310px"/>
	</div>
	<br/>

	<div id = "page_button">
		<input type = "file" id = "thePic"  onchange = "preview(this)" />
	</div>
</div>


<div id ="bottom">
	<input type = "button" value ="添加" onclick = "addBook()"/>
	<input type = "button" value ="取消"/>
	<input type = "button" value ="返回"/>
</div>



</body>
</html>