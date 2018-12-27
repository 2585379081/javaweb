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
<title>Insert title here</title>
<script src = "<%=basePath %>js/jQuery.js" ></script>
<script src = "<%=basePath %>js/SimpleQuery.js" ></script>
</head>
<body>
<table>
<tr>
<td>检索字段</td>
<td><input type = "text" list = "typeList" id ="queryType"/>
<datalist id = "typeList">
<option>书名</option>
<option>作者</option>
</datalist>
</td>
<td><input type = "text" id = "queryName"/></td>
<td><input type = "hidden" id = "page" value = "simpleQuery"/></td>
</tr>

</table>
</body>
</html>