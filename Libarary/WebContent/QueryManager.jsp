<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*,com.libarary.model.*"
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
<title>查询页面</title>

<link rel="stylesheet" type="text/css" href="<%=basePath %>css/QueryManager.css">

<script src = "<%=basePath %>js/jQuery.js" ></script>
<script src = "<%=basePath %>js/QueryManager.js" ></script>
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

<div id = "query">

<p>
<a href="http://localhost:8080/Libarary/SimpleQuery.jsp" target="topIframe">简单查询&nbsp;&nbsp;&nbsp;&nbsp;</a>
<a href="http://localhost:8080/Libarary/ComQuery.jsp" target="topIframe">高级查询</a>
</p>

<iframe id = "iframe" name="topIframe" width="100%" height="150px" src="http://localhost:8080/Libarary/SimpleQuery.jsp" frameborder="1" scrolling="auto"></iframe>

</div>

<div id ="result">
	查询结果：<br/>
	
	<table border = "1px" cellspacing = "0px"  id="tb" onclick="selectRow(this)">
	<tr>
	<td width= "100px">ID</td>
	<td width= "100px">索书号</td>
	<td width= "100px">书名</td>
	<td width= "100px">作者</td>
	<td width= "100px">出版社</td>
	<td width= "100px">出版日期</td>
	<td width= "100px">ISBN</td>
	<td width= "100px">分类号</td>
	<td width= "100px">语种</td>
	<td width= "100px">页数</td>
	<td width= "100px">价格</td>
	<td width= "100px">入馆时间</td>
	<td width= "100px">状态</td>
	</tr>
	<%
	 List<Book> list =(List)request.getAttribute("list");
		if(list!=null){
			for(int i =0;i<list.size();i++){
				Book book = list.get(i);
				
	%>
	
	<tr>
	<td width= "100px"><%=book.getBkID() %></td>
	<td width= "100px"><%=book.getBkCode() %></td>
	<td width= "100px"><%=book.getBkName() %></td>
	<td width= "100px"><%=book.getBkAuthor() %></td>
	<td width= "100px"><%=book.getBkPress() %></td>
	<td width= "100px"><%=book.getBkDatePress() %></td>
	<td width= "100px"><%=book.getBkISBN() %></td>
	<td width= "100px"><%=book.getBkCatalog() %></td>
	<td width= "100px"><%=book.getBkLanguage() %></td>
	<td width= "100px"><%=book.getBkPages() %></td>
	<td width= "100px"><%=book.getBkPrice() %></td>
	<td width= "100px"><%=book.getBkDateIn() %></td>
	<td width= "100px"><%=book.getBkStatus() %></td>
	</tr>
	<%
		}
	}
	%>
	</table>

</div>

<div id ="bottom">
<input type = "button" value = "查询" onclick = "query()"/>
<input type = "button" value ="删除" onclick = "deleted()"/>
<input type = "button" value ="返回" onclick = "exit()"/>
</div>


</body>
</html>