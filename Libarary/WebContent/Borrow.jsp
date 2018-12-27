<%@ page language="java" contentType="text/html; charset=UTF-8" import = "com.libarary.po.*,java.util.*,com.libarary.model.*,java.text.*"
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
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/Borrow.css">

<script src = "<%=basePath %>js/jQuery.js" ></script>
<script src = "<%=basePath %>js/Borrow.js" ></script>
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

<%
ReaderInfo readerInfo =(ReaderInfo) request.getSession().getAttribute("readerInfo");
Reader rd =(Reader) request.getSession().getAttribute("reader");
List<BookInfo> bookInfoList = (List)request.getSession().getAttribute("bookInfoList");
%>

<div id = "readerInfo">
	<table>
	<tr>
	<td>读者编号<input type = "text" id ="rdID" value ="<%if(readerInfo!=null) out.print(readerInfo.getRdID()); %>"/></td>
	<td>读者姓名</td>
	
	<td><input type = "text" id = "rdName" disabled value ="<%if(readerInfo!=null) out.print(readerInfo.getRdName()); %>"/></td>
	<td>读者单位</td>
	<td><input type = "text" id ="rdDept" disabled value ="<%if(readerInfo!=null) out.print(readerInfo.getRdDept()); %>"/></td>
	<td>读者类型</td>
	<td><input type = "text" id ="rdType" disabled value ="<%if(readerInfo!=null) out.print(readerInfo.getRdType()); %>"/></td>
	</tr>
	<tr>
	<td align ="center"><input type = "button" value ="查询" onclick = "queryReaderInfo()"/></td>
	<td>可借书数量</td>
	<td><input type = "text" id = "canLendNum" disabled value ="<%if(readerInfo!=null) out.print(readerInfo.getCanLendNum()-readerInfo.getLendedNum()); %>"/></td>
	<td>可借书天数</td>
	<td><input type = "text" id = "canLendDay" disabled value ="<%if(readerInfo!=null) out.print(readerInfo.getCanLendDay()); %>"/></td>
	<td>已借书数量</td>
	<td><input type = "text" id  ="lendedNum" disabled value ="<%if(readerInfo!=null) out.print(readerInfo.getLendedNum()); %>"/></td>
	</tr>
	</table>
</div>

<div id = "lendedBook">
<font >已借图书</font><br/>
<table border =  "1px" cellspacing = "0px" cellpadding = "0px">
<tr>
<td width ="100px">图书序号</td>
<td width ="100px">图书名称</td>
<td width ="100px">图书作者</td>
<td width ="100px">续借次数</td>
<td width ="100px">借阅日期</td>
<td width ="100px">应还日期</td>
<td width ="100px">超期天数</td>
<td width ="100px">超期金额数</td>
<td width = "100px">还书</td>
<td width = "100px">续借</td>
</tr>

<%
if(bookInfoList!=null){
	for(int i =0;i<bookInfoList.size();i++){
		BookInfo bookInfo = bookInfoList.get(i);

%>


<tr>
<td width ="100px"><%=bookInfo.getBkID() %></td>
<td width ="100px"><%=bookInfo.getBkName() %></td>
<td width ="100px"><%=bookInfo.getBkAuthor() %></td>
<td width ="100px"><%=bookInfo.getIdContitueTimes()%></td>
<td width ="100px"><%=bookInfo.getIdDateOut() %></td>
<td width ="100px"><%=bookInfo.getIdDateRetPlan() %></td>
<td width ="100px"><%=bookInfo.getIdOverDay() %></td>
<td width ="100px"><%=bookInfo.getIdOverMoney() %></td>
<td width = "100px"><a   onclick = "returnBook(<%=bookInfo.getBkID()%>,<%if(readerInfo!=null) out.print(readerInfo.getRdID());%>,'<%if(rd!=null) out.print(rd.getRdName());%>')">还书</a></td>
<td width = "100px"><a   onclick = "contitueLend(<%=bookInfo.getBkID()%>,<%if(readerInfo!=null) out.print(readerInfo.getRdID());%>,'<%if(rd!=null) out.print(rd.getRdName());%>')">续借</a></td>
</tr>



<%

		}
	}


%>
</table>
</div>

<div id = "bookInfo">
<font >图书信息</font><br/>
<table>
<tr>
<td>图书序号</td>
<td><input type ="text" id = "bkID"/></td>
<td>图书名称</td>
<td><input type = "text" id ="bkName"/></td>
<td><input type ="button" value ="查询" onclick = "bookQuery()"/></td>
</tr>
</table>
</div>

<div id ="allBook">
<table border ="1px" cellspacing = "0px" cellpadding ="0px">
<tr>
<td width ="100px">序号</td>
<td width ="100px">编号</td>
<td width ="100px">书名</td>
<td width ="100px">作者</td>
<td width ="100px">出版社</td>
<td width ="100px">出版日期</td>
<td width ="100px">ISBN</td>
<td width ="100px">分类号</td>
<td width ="100px">页数</td>
<td width ="100px">价格</td>
<td width ="100px">入馆日期</td>
<td width = "100px">借书</td>
</tr>

<%
String info = request.getParameter("info");
List<Book> bookList = (List)request.getAttribute("bookList");
if(info!=null){
if(bookList!=null){
for(int i = 0;i<bookList.size();i++){
	Book book = bookList.get(i);


%>


<tr>
<td width ="100px"><%=book.getBkID() %></td>
<td width ="100px"><%=book.getBkCode() %></td>
<td width ="100px"><%=book.getBkName() %></td>
<td width ="100px"><%=book.getBkAuthor() %></td>
<td width ="100px"><%=book.getBkPress() %></td>
<td width ="100px"><%=book.getBkDatePress() %></td>
<td width ="100px"><%=book.getBkISBN() %></td>
<td width ="100px"><%=book.getBkCatalog() %></td>
<td width ="100px"><%=book.getBkPages() %></td>
<td width ="100px"><%=book.getBkPrice() %></td>
<td width ="100px"><%=book.getBkDateIn() %></td>
<td width="100px"><a   onclick = "lendBook(<%=book.getBkID()%>,<%if(readerInfo!=null) out.print(readerInfo.getRdID());%>,'<%if(rd!=null) out.print(rd.getRdName());%>')">借书</a></td>
</tr>





<%


		}
	}
}
%>

</table>

</div>


<%
Date date = new Date();
DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String time = format.format(date);


%>

<div id = "dateInfo">
	<div id ="opertor">操作员:<%if(rd!=null) out.print(rd.getRdName());%></div>
	<div id ="date"><%=time%></div>
</div>

</body>
</html>