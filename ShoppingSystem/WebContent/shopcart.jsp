<%@page import="com.shop.tool.urlTrsBase64"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>
<%
	java.util.ArrayList<java.util.HashMap> list = (java.util.ArrayList<java.util.HashMap>)request.getAttribute("list");
	String userId=request.getSession().getAttribute("userId").toString();
%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <link rel="stylesheet" href="CSS/bootstrap.min.css">
    <script src="JS/jquery.min.js"></script>
    <script src="JS/bootstrap.min.js"></script>

    <link rel="stylesheet" href="CSS/min.css">
    <link rel="stylesheet" href="CSS/shopcart.css">
    <script src="JS/tools.js"></script>
    <script src="JS/shopcart.js"></script>

</head>
<body>

<!-------------------------------顶部bar----------------------------->
    <div class="topbar">
        <div class="topbar_center">
            <div class="topbar_left"><a href="IndexServlet">首页</a></div>
            <div class="topbar_right user_name"><%=userId %></div>
        </div>
    </div>
<!------------------------------top部分----------------------------->
    <div class="top">
        <div class="topbar_left">
            SHOP<span>CART</span>
        </div>
        <div class="top_right"></div>
    </div>
<!--------------------------------购物车表-------------------------->
    <div class="table_header">
        <div class="header_name">选择</div>
        <div class="header_name">商品</div>
        <div class="header_name">单价</div>
        <div class="header_name">数量</div>
        <div class="header_name">小计</div>
        <div class="header_name">操作</div>
    </div>
<!----------表格每一列，jsp中通过循环添加行----------->
<%
	
	if(list.size() != 0){
		for(java.util.HashMap e: list){
			String subtotalID="price"+e.get("goodsId");//“小计”列的id,便于修改数量时小计也更变
%>
    <div class="table_content">
        <div class="col_item">
            <div class="item_checkbox">
                <input type="checkbox" name="check" value="<%=e.get("goodsId")%>">
            </div>
        </div>
        <div class="col_item">
            <div class="goods_img_div">
            	<%String base64 = urlTrsBase64.byteToBase64((byte[])e.get("goodsImage")); %>
                <a href="#"><img src="data:image/jpeg;base64,<%=base64 %>" alt=""></a>
            </div>
            <div class="goods_name_div"><%=(String)e.get("goodsName") %></div>
        </div>
        <div class="col_item goods_price_div"><%=(float)e.get("goodsPrice") %></div>
        <div class="col_item goods_num_div">
        
			<a href="javascript:void(0);" id="sub<%=e.get("goodsId") %>" onclick="decGoodsNum(<%=e.get("goodsId") %>,'<%=subtotalID %>',<%=e.get("goodsPrice") %>)" >-</a><!--减少购物数量-->
			<input id="<%=e.get("goodsId") %>" type="text" autocomplete="off" min="1" value="<%=e.get("goodsQty") %>" onchange="changeGoodsNum(this.value,<%=e.get("goodsId") %>,'<%=subtotalID %>',<%=e.get("goodsPrice") %>)">
        	<a href="javascript:void(0);" id="add<%=e.get("goodsId") %>"  onclick="addGoodsNum('<%=e.get("goodsId") %>','<%=subtotalID %>','<%=e.get("goodsPrice") %>')" >+</a>
        </div>
        <div class="col_item goods_total_price_div" id="<%=subtotalID%>"><%=(int)e.get("goodsQty")*(float)e.get("goodsPrice") %></div>
        <div class="col_item goods_operate_div"><a href="javascript:void(0);" onclick="deleteGoods(<%=e.get("goodsId") %>)">删除</a></div>
    </div>
<% 
	
	}
}
%>

    <!--表格选中商品总计-->
    <div class="table_bottom">
        <div class="bottom_checkbox">
            <!--全选所有商品-->
            <input type="checkbox" id="chooseAll">
        </div>
        <div class="has_chose_num">共选中<span id="hasChooseNumId">0</span>条</div>
        <a href="javascript:void(0);"><button class="btn_price">结算</button></a>
        <div class="total_price">应付：<span id="sumPriceId">0</span>元</div>
    </div>
    <div class="footer">

    </div>

</body>
</html>