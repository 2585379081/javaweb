<%@ page language="java" contentType="text/html; charset=UTF-8" import = "com.shop.pojo.*,com.shop.tool.*,java.util.*,com.shop.tool.*"
    pageEncoding="UTF-8"%>
    
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<HashMap<String,Object>> allList =(List<HashMap<String,Object>>) request.getAttribute("allList");
String oderId =(String) request.getAttribute("orderId");
if(oderId ==null){
	oderId ="--";
}
%>
<html lang="zh">
<head>
	<base href = "basePath"/>
    <meta charset="UTF-8">
    <title>订单详情</title>
    <link rel="stylesheet" href="CSS/bootstrap.min.css">
    <script src="JS/jquery.min.js"></script>
    <script src="JS/bootstrap.min.js"></script>

    <link rel="stylesheet" href="CSS/min.css">
    <link rel="stylesheet" href="CSS/orderdetail.css">
</head>
<body>
<div class="top">
    <div class="top_center">
        <div class="center_left">Order&nbsp;<span>Detail</span></div>
        <div class="center_right">
            <a href="OrderServlet?method=getAllOrder">我的订单</a>
            <a href="ShopCartServlet?method=getAllShopCart">购物车</a>
            <a href="IndexServlet">首页</a>
        </div>
    </div>
</div>
<div class="order_body">
    <div class="order_center">
        <div class="order_top">
            <div class="top_left">
                <div class="order_id">订单号：<span><%=oderId %></span></div>
                <div class="order_operate">
                    <!--如果状态是已经支付，则改为再次购买-->
                    <a href="">去支付</a>
                    <!--在本页面删除订单可以直接跳转至我的订单页面-->
                    <a href="">删除</a>
                </div>
            </div>
            <div class="top_right"></div>
        </div>
        
        <%
        	if(allList !=null)
        		for(HashMap hashMap :allList){
        			byte[] bytes =(byte[])hashMap.get("goodsImage");
        			String base64 =urlTrsBase64.byteToBase64(bytes);
        %>
        <div class="goods_item">
            <a href="" class="goodsImage"><img src="data:image/jpeg;base64,<%=base64%>" alt=""></a>
            <div class="goodsPrice">商品价格：<span><%=hashMap.get("goodsPrice") %></span></div>
            <div class="goodsQty">商品数量：<span><%=hashMap.get("goodsQty") %></span></div>
            <div class="goodsName">商品名称：<span><%=hashMap.get("goodsName") %></span></div>
        </div>
		
		
		<%
        		}
		%>
    </div>
</div>


</body>
</html>