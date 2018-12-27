<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<td>图书名称:</td>
<td><input type = "text" name ="name" id = "bkName"/></td>
<td>图书作者:</td>
<td><input type ="text" name ="author" id ="bkAuthor"/></td>
<td>图书描述:</td>
<td><input type ="text" name = "introduce" id = "bkBrief"/></td>
<td rowspan ="2"><input type ="hidden" id = "page" value = "comQuery"/></td>
</tr>
<tr>
<td>出版社名:</td>
<td><input type = "text" name ="press" id = "bkPress"/></td>
<td>分类号:</td>
<td><input type ="text" name ="type" id = "bkCatalog"/></td>
<td>出版年:</td>
<td><input type ="text" name = "pressYear" id ="bkPressYear"/></td>

</tr>
</table>
</body>
</html>