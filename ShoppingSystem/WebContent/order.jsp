<%@page import="com.shop.tool.urlTrsBase64"%>
<%@page import="java.util.ArrayList,java.util.HashMap,com.shop.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	ArrayList<HashMap> orderList = (ArrayList<HashMap>)request.getAttribute("orderList");
%>
<%User user=(User)request.getSession().getAttribute("user"); 
String nickName ="--";
if(user!=null){
	nickName = user.getNickName();
}

%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>订单</title>
    <link rel="stylesheet" href="CSS/bootstrap.min.css">
    <script src="JS/jquery.min.js"></script>
    <script src="JS/bootstrap.min.js"></script>
    <script src="JS/tools.js"></script>

    
    <link rel="stylesheet" href="CSS/order.css">
    <script src="JS/order.js"></script>

</head>
<body>
<div class="topbar">
    <div class="topbar_center">
        <div class="topbar_left"><a href="IndexServlet">首页</a></div>
        <div class="topbar_right user_name"><%=nickName %></div>
        <div class="topbar_right goto_shopcart"><a href="ShopCartServlet?method=getAllShopCart">购物车</a></div>
        <div class="topbar_right goto_order"><a href="OrderServlet?method=getAllOrder">我的订单</a></div>
    </div>
</div>
<!-------------------------------顶部bar完----------------------------->
<!------------------------------top部分----------------------------->
<div class="top">
    <div class="topbar_left">
        MY<span>ORDER</span>
    </div>
    <div class="top_right"></div>
</div>
<div class="all_orders">
<%
	for(HashMap hashMap: orderList){
%>
    <div class="order_item">
        <div class="order_info">订单号：<%=hashMap.get("orderId") %></div>
        <div class="order_info">商品种类数：<%=hashMap.get("goodsNumber") %></div>
        <div class="order_info">支付状态：<%=hashMap.get("isPay") %></div>
        <div class="order_info">总金额：<%=hashMap.get("sumPrice") %></div>
        <div class="order_info">收获地址：<%=user.getUserAddress() %></div>
        <!--等待支付a标签需要用jsp判断是否已支付，如果已经支付，则这个标签改为删除-->
        <%if((boolean)hashMap.get("isPay") == false){%>
        <a href="#" data-toggle="modal" data-target="#payModal<%=hashMap.get("orderId")%>">支付</a>
        <%} else{ %>
        <a href="javascript:;" onclick="deleteOrder(<%=hashMap.get("orderId") %>)">删除</a>
        <%} %>
        <a href="OrderDetailsServlet?method=getOrderDetailsById&orderId=<%=(int)hashMap.get("orderId")%>">查看详情</a>
    </div>
    
	    <!----------------------------支付模态框----------------------------->
	<div class="modal fade" id="payModal<%=hashMap.get("orderId") %>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h4 class="modal-title" id="myModalLabel">支付订单</h4>
	            </div>
	            <div class="modal-body">
	                <form action="" class="pay_form">
	                    <div class="left_info">
	                        <p style="text-align: center; font-size: 20px;">信息核对</p>
	                        <div class="pay_item">
	                            <div class="user_name">用户名：<span><%=user.getUserId() %></span></div>
	                        </div>
	                        <div class="pay_item">
	                            <div class="phone">电话号码：<span><%=user.getPhone() %></span></div>
	                        </div>
	                        <div class="pay_item">
	                            <div class="order_id">订单号：<span><%=hashMap.get("orderId") %></span></div>
	                        </div>
	                        <div class="pay_item">
	                            <div class="address">收获地址：<span><%=user.getUserAddress() %></span></div>
	                        </div>
	                        <div class="pay_item">
	                            <div class="totalPrice">总价：<span><%=hashMap.get("sumPrice") %></span>&nbsp;元</div>
	                            <button type="button" class="btn btn-primary" onclick="submitPay('<%=hashMap.get("orderId") %>')">确认支付</button>
	                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	                        </div>
	                    </div>
	                    <div class="right_info">
	                   		<%
	                   		ArrayList<byte[]> goodsImageList = (ArrayList<byte[]>)hashMap.get("goodsImageList");
	                   		for(byte[] imageByte:goodsImageList)
	                   		{
	                   			
	                   			String imageBase64 = urlTrsBase64.byteToBase64(imageByte);
	                   			
	                   		%>
	                   			<img src="data:image/jpeg;base64,<%=imageBase64%>" >
	                   		<%
	                   		}
	                   		%>

	                    </div>
	                </form>
	            </div>
	
	        </div><!-- /.modal-content -->
	    </div><!-- /.modal -->
	  </div>
<%
	}
%>
</div>

<div class="footer">

</div>





</body>
</html>