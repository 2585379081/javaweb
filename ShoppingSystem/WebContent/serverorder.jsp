<%@page import="java.util.ArrayList,java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%ArrayList<HashMap> orderList = (ArrayList<HashMap>)request.getAttribute("orderList"); %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>查看订单</title>
    <link rel="stylesheet" href="CSS/bootstrap.min.css">
    <script src="JS/jquery.min.js"></script>
    <script src="JS/bootstrap.min.js"></script>

    <link rel="stylesheet" href="CSS/serverorder.css">
    <script src="JS/tools.js"></script>
    <script src="JS/serverorder.js"></script>
</head>
<body>

<!------------------------------top部分----------------------------->
<div class="top">
    <div class="topbar_left">
       <span>ORDER</span>
    </div>
    <div class="top_right">
        <button onclick="searchOrderById()"></button>
        <!--搜索框-->
        <input type="text" placeholder="输入用户名" id="userId">
    </div>
</div>
<div class="all_orders">
<%
	if(orderList != null){
	for(HashMap hashMap: orderList){
%>
    <div class="order_item">
        <div class="order_info">订单号：<%=hashMap.get("orderId") %></div>
        <div class="order_info">商品种类数：<%=hashMap.get("goodsNumber") %></div>
        <div class="order_info">支付状态：<%=hashMap.get("isPay") %></div>
        <div class="order_info">总金额：<%=hashMap.get("sumPrice") %></div>
        <div class="order_info">用户名：<%=hashMap.get("userId") %></div>
    </div>
<%
	}
}
%>
</div>

<div class="footer">

</div>


</body>
</html>