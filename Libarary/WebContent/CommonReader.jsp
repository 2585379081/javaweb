<%@ page language="java" contentType="text/html; charset=UTF-8" import ="com.libarary.model.*,java.util.*, 
java.text.SimpleDateFormat,com.libarary.tool.*,javax.imageio.ImageIO,java.io.InputStream,com.libarary.po.*"
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
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/CommonReader.css">

<script src = "<%=basePath %>js/jQuery.js" ></script>
<script src = "<%=basePath %>js/CommonReader.js" ></script>

<title>读者信息</title>
</head>
<body>
<div id="top">
	<ul class = "top_ul">
		<li class = "dropdown" >
			<a href = "http://localhost:8080/Libarary/CommonReader.jsp">我的信息</a>
		</li>
		<li class = "dropdown" >
			<a href = "http://localhost:8080/Libarary/CommonQuery.jsp">借阅图书</a>
		</li>

	</ul>
</div>




<%
Reader rd =(Reader) request.getSession().getAttribute("reader");
SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  

%>

<div class = "info">
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
	<img  width = "100px" height ="150px" src ="<%if(rd!=null) out.print(rd.getRdPhoto());%>" />
</div>
<div class ="right_button">
<input type = "file" id = "thePic"  onchange = "preview(this)" disabled/>
</div>


<div class= "buttom">
<input type = "button" id = "runCard" value = "变更信息" onclick = "changeInfo()"/>
<input type = "button" id = "changInfo" value = "确认变更"  disabled onclick = "conChangeInfo()"/>
<input type = "button" value = "退出" onclick = "exit()"/>
</div>







</body>
</html>