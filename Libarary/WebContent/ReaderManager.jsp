<%@ page language="java" contentType="text/html; charset=UTF-8" import ="com.libarary.model.*,java.util.*, 
java.text.SimpleDateFormat,com.libarary.tool.*,javax.imageio.ImageIO,java.io.InputStream"
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
<title>长江大学图书管理系统</title>

<link rel="stylesheet" type="text/css" href="<%=basePath %>css/ReaderManager.css">

<script src = "<%=basePath %>js/jQuery.js" ></script>
<script src = "<%=basePath %>js/ReaderManager.js" ></script>

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

<form action = "servlet/ShowReader" method = "post">
<div id = "readerType">读者类别
<input type = "text" list = "typeList"  name ="readerType" />
<datalist id= "typeList">
	<option>教师</option>
	<option>本科生</option>
	<option>研究生</option>
	<option>博士生</option>
</datalist>
</div>

<div id= "dept">单位
<input type = "text" list = "deptList" name ="dept" />
<datalist id= "deptList">
	<option>计科</option>
	<option>石油</option>
</datalist>
</div>


<div id ="name">姓名
<input type = "text" name= "name"/>
</div>

<input type = "submit" value = "查询"/>
</form>
</div>


<div id = "allReader">
<table  border="1px"  id="tb" onclick="selectRow(this)">

<tr>
<td width= "70px">ID</td>
<td width= "70px">姓名</td>
<td width= "70px">性别</td>
<td width= "70px">类型</td>
<td width= "70px">院系</td>
<td width= "70px">电话</td>
<td width= "70px">email</td>
<td width= "70px">状态</td>
<td width= "70px">已借书</td>
<td width= "70px">注册日期</td>
</tr>

<%
List<Reader> list =(List)request.getSession().getAttribute("list");
Reader rd =(Reader) request.getSession().getAttribute("reader");
SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  

if(list!=null){
	for(int i = 0;i<list.size();i++){
		Reader reader = list.get(i);

%>

<tr>
<td width= "70px"><%=reader.getRdID() %></td>
<td width= "70px"><%=reader.getRdName() %></td>
<td width= "70px"><%=reader.getRdSex() %></td>
<td width= "70px"><%=reader.getRdType() %></td>
<td width= "70px"><%=reader.getRdDept() %></td>
<td width= "70px"><%=reader.getRdPhone() %></td>
<td width= "70px"><%=reader.getRdEmail() %></td>
<td width= "70px"><%=reader.getRdStatus() %></td>
<td width= "70px"><%=reader.getRdBorrowNum() %></td>
<td width= "70px"><%=formatter.format(reader.getRdDateReg()) %></td>
</tr>



<%

	}
}
%>
</table>

</div>




<div id = "right">
<table>

<tr>
<td>借书证号</td>
<td><input type = "text" id ="rdID" disabled value = "<%if(rd!=null) out.print(rd.getRdID()); %>" /></td>
</tr>
<tr>
<td>姓名</td>
<td><input type = "text"  id ="rdName" disabled value ="<%if(rd!=null) out.print(rd.getRdName());%>"/></td>
</tr>
<tr>
<td>密码</td>
<td><input type = "password" id ="rdPwd" disabled  value = "<%if(rd!=null) out.print(rd.getRdPwd());%>"/></td>
</tr>
<tr>
<td>性别</td>
<td><input type = "text" list= "sexList" disabled  id = "rdSex" value = "<%if(rd!=null) out.print(rd.getRdSex());%>"/>
<datalist id ="sexList">
	<option>男</option>
	<option>女</option>
</datalist>
</td>
</tr>
<tr>
<td>已借书</td>
<td><input type = "text" id ="rdBorrowNum" disabled value = "<%if(rd!=null) out.print(rd.getRdBorrowNum());%>"/></td>
</tr>
<tr>
<td>证件状态</td>
<td><input type = "text"  id ="rdStatus" disabled value ="<%if(rd!=null) out.print(rd.getRdStatus()); %>"/></td>
</tr>
<tr>
<td>读者角色</td>
<td><input type = "text"  id = "rdAdminRoles" disabled value ="<%if(rd!=null) out.print(rd.getRdAdminRoles()); %>"/></td>
</tr>
<tr>
<td>读者类别</td>
<td><input type = "text" list= "typeList" disabled  id ="rdType" value ="<%if(rd!=null) out.print(rd.getRdTypeName());%>"/>
</td>
</tr>
<tr>
<td>单位</td>
<td><input type = "text" list ="deptList" disabled id ="rdDept" value = "<%if(rd!=null) out.print(rd.getRdDept());%>"/></td>
</tr>
<tr>
<td>电话号码</td>
<td><input type = "text"  id ="rdPhone" disabled value = "<%if(rd!=null) out.print(rd.getRdPhone());%>"/></td>
</tr>
<tr>
<td>电子邮件</td>
<td><input type = "text" id ="rdEmail" disabled value = "<%if(rd!=null) out.print(rd.getRdEmail());%>"/></td>
</tr>
<tr>
<td>办证日期</td>
<td><input type = "text" id ="rdDateReg" disabled value = "<%if(rd!=null) out.print(formatter.format(rd.getRdDateReg()));%>"/></td>

</table>
</div>



<div id= "right_image">
	<img  width = "100px" height ="150px" id = "rdPhoto" src ="<%if(rd!=null) out.print(rd.getRdPhoto());%>" />
</div>
<div id ="right_button">
<input type = "file" id = "thePic"  onchange = "preview(this)" disabled/>
</div>


<div id= "buttom">
<input type = "button" id = "runCard" value = "办借书证" onclick = "runCard()"/>
<input type = "button" id = "changInfo" value = "变更信息" onclick = "changeInfo()"/>
<input type = "button" value = "退出" onclick = "exit()"/>

</div>

<div id = "last">
<input type = "button" id = "conRunCard"  disabled value = "确认办证" onclick = "conRunCard()"/>
<input type = "button" id = "conChangeInfo"  disabled value = "确认变更" onclick = "conChangeInfo()"/>
<input type = "button" value = "取消" onclick = "cancel()"/>
</div>

</body>
</html>