<%@ page language="java" contentType="text/html; charset=UTF-8"  import = "java.util.*,com.shop.pojo.*,com.shop.tool.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>店家首页</title>
    <link rel="stylesheet" href="CSS/bootstrap.min.css">
    <script src="JS/jquery.min.js"></script>
    <script src="JS/bootstrap.min.js"></script>
    <link rel="stylesheet" href="CSS/min.css">
    <link rel="stylesheet" href="CSS/servermain.css">

</head>
<body>
<div class="header">
    <div class="header_left"><img src="images/logo1.png" alt=""></div>
    <div class="header_right">
        <div class="menue"><a href="">首页</a></div>
        <div class="menue"><a href="OrderServlet?method=getAllOrders">查看订单</a></div>
        <div class="menue"><a href="goodsmeneger.jsp">添加商品</a></div>
        <div class="menue"><a href="message.jsp">消息</a></div>
    </div>
</div>
<div class="welcom_top">Welcome&nbsp;To</div>
<div class="welcome_bottom">Shopping&nbsp;System</div>
<div class="title">
    <div class="left_img"></div>
    <div class="center_title">所有商品</div>
    <div class="right_img"></div>
</div>
<!-----------------------------商品展示区------------------------------->
<div class="goods_content">
    <div class="center_conten">
        <!--------jsp循环-------->
         <%
        	List<Goods> goodsList =(List<Goods>)request.getAttribute("goodsList");
        	if(goodsList!=null)
        	for(Goods goods :goodsList){
        			String base64 =urlTrsBase64.byteToBase64(goods.getGoodsImage());
   
        
        %>
        
        <div class="goods_item">
            <div class="goods_img">
                <img src="data:image/jpeg;base64,<%=base64%>" alt="">
                <div class="show_alter_goods">
                    <a href="GoodsServlet?method=alterGoods&goodsId=<%=goods.getGoodsId() %>" class="alter_goods">修改</a>
                    <a href="GoodsServlet?method=deleteGoods&goodsId=<%=goods.getGoodsId() %>" class="alter_goods">删除</a>
                </div>
            </div>
            <div class="goods_name goods_info">剩余数量：<span><%=goods.getGoodsNum() %></span></div>
            <div class="goods_price goods_info">商品价格：<span><%=goods.getGoodsPrice() %></span></div>
            <div class="goods_name">商品名称：<span><%=goods.getGoodsName() %></span></div>
        </div>
        
        
        
        <%
        	}
        	
        %>
    
    </div>
</div>

<div class="footer">
    <div class="center"></div>
</div>
</body>
</html>