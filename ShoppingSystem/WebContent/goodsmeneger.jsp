<%@page import="com.shop.pojo.Goods"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" import = "java.util.*,com.shop.tool.*"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Goods goods =(Goods) request.getAttribute("goods");
String image = "images/user.png";
String flag = "添加";
if(goods ==null){
	goods = new Goods();
	goods.setGoodsBrief("");
	goods.setGoodsCat("");
	goods.setGoodsId(0);
	goods.setGoodsName("");
	goods.setGoodsNum(0);
	goods.setGoodsPrice(0);
	
}else{
	
	if(goods.getGoodsImage()!=null){
		byte[] bytes = goods.getGoodsImage();
		String base64 = urlTrsBase64.byteToBase64(bytes);
		image = "data:image/jpeg;base64,"+base64 ;
	}
	flag = "修改";
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh">
<head>
	<base href = "<%=basePath %>"/>
    <meta charset="UTF-8">
    <title>添加商品</title>
    <link rel="stylesheet" href="CSS/bootstrap.min.css">
    <script src="JS/jquery.min.js"></script>
    <script src="JS/tools.js"></script>
    <script src="JS/bootstrap.min.js"></script>
    <script src="JS/goodsmaneger.js"></script>
    <link rel="stylesheet" href="CSS/goodsmeneger.css">

</head>
<body>
<body>
<div class="topbar">
    <div class="topbar_center">
        <div class="topbar_left"><a href="GoodsServlet?method=getAllGoods">首页</a></div>
        <div class="topbar_right user_name">服务名</div>
    </div>
</div>
<!----------------top------------->
<div class="top">
    <div class="topbar_left">
        GOODS&nbsp;<span>MANEGE</span>
    </div>
    <div class="top_right"></div>
</div>
<!--------------类容区---------------->
<div class="user_info">

    <!--等待提交的基本信息form-->
    <form action="">
        <div class="left_info">
            <div class="info_nickname">
                <div>商品名称:</div>
                <input type="text" id = "goodsName" value = "<%=goods.getGoodsName()%>">
            </div>
            <div class="info_account">
                <div>商品类别:</div>
                <input type="text" id = "goodsCat" value = "<%=goods.getGoodsCat()%>">
            </div>
            <div class="info_nickname">
                <div>商品数量:</div>
                <input type="text" id = "goodsNum" value = "<%=goods.getGoodsNum()%>">
            </div>
            <div class="info_nickname">
                <div>商品价格:</div>
                <input type="text" id = "goodsPrice" value = "<%=goods.getGoodsPrice()%>">
            </div>
            <div class="info_nickname">
                <div>商品id:</div>
                <input type="text" id = "goodsId" value = "<%=goods.getGoodsId()%>">
            </div>
            <%
            	if("添加".equals(flag)){
            %>
            <input type="button" class="submit_user_info" value="<%=flag %>" onclick = "submit_goods()">
            
            <%
            	}else{
            %>
            
            <input type="button" class="submit_user_info" value="<%=flag %>" onclick = "alter_goods()">
            
            <%
            	}
            %>
        </div>
        <div class="right_info">
            <div>商品简介</div>
           <textarea  id="goodsBrief" cols="30" rows="10" ><%=goods.getGoodsBrief()%></textarea>
        </div>
        <div class="user_img" id ="user_img">
            <img src="<%=image %>" alt="" id ="goodsImage">
            <input type="file" class="choose_img" value="更换图像" onchange = "preview(this)">
        </div>

    </form>


</div>
</body>
</html>