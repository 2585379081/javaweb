<%@ page language="java" contentType="text/html; charset=UTF-8" import = "java.util.*,com.shop.pojo.*,com.shop.tool.*"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String userId = (String)request.getSession().getAttribute("userId");
boolean isLogin=false;
if(userId == null){
	userId = "注册/登录";
	isLogin=false;
}else{
	userId =(String)request.getSession().getAttribute("userId");
	isLogin=true;
}
%>
    

<head  lang="zh">
	<base href = "<%=basePath%>"/>
    <title>购物系统</title>
    <link rel="stylesheet" href="CSS/bootstrap.min.css">
    <script src="JS/jquery.min.js"></script>
    <script src="JS/bootstrap.min.js"></script>

    <link rel="stylesheet" href="CSS/main.css">
    <link rel="stylesheet" href="CSS/min.css">
    <script src="JS/tools.js"></script>
    <script src="JS/main.js"></script>
</head>
<body>
    <!----------------------------------顶部-------------------------------->
    <div class="top">
        <div class="top_center">
            <div class="top_center_left">
                <div class="top_logo">
                    <img src="images/logo.jpg" alt="">
                </div>
            </div>
            <!--搜索框-->
            <div class="top_center_search">
                <input type="text" placeholder="输入商品名称" id="goodsName">
                <button onclick ="query()"></button>
            </div>
            <div class="top_center_right">
                <ul>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <img src="images/user.png" alt="" >
                        </a>
                        <!--点击图像时显示的下拉菜单项-->
                        <ul class="dropdown-menu">
                            <li><a href="ShopCartServlet?method=getAllShopCart">我的购物车</a></li>
                            <li><a href="OrderServlet?method=getAllOrder">我的订单</a></li>
                            <li><a href="myinfo.jsp">我的资料</a></li>
                            <li class="divider"></li>
                            <li><a href="#">退出登录</a></li>
                        </ul>
                    </li>
                    <li><a href="sign.jsp"><%=userId %></a></li>
                </ul>
            </div>
        </div>
    </div>

<!----------------------------------------商品区----------------------------------->

    <!--商品顶部的title-->
    <div class="shop_title">
        <div></div>
        <div><h1>衣服类商品</h1></div>
        <div></div>
    </div>

    <!--商品的某一类-->
    <div class="row_item">
        <!--在jsp中可直接重复这一个div就可以-->
        
        <%
        	List<Goods> goodsList =(List<Goods>)request.getAttribute("goodsList");
        	if(goodsList!=null)
        	for(Goods goods :goodsList){
        		if(goods.getGoodsCat().equals("衣服")){
        			String base64 =urlTrsBase64.byteToBase64(goods.getGoodsImage());
   
        
        %>
        
       <div class="each_item">
            <div class="div_gdimg"><img src="data:image/jpeg;base64,<%=base64%>" alt=""></div>
            <div class="price_name">
                <span class="gdname"><%=goods.getGoodsName() %></span>
                <span class="gdprice"><%=goods.getGoodsPrice() %></span>
            </div>
            <div class="div_btn">
                <button class="btn_detail btn_shop" onclick ="getDetail('<%=goods.getGoodsId() %>','<%=userId %>')" id ="<%=goods.getGoodsId()%>" >查看详情</button>
                <button class="btn_addtocart btn_shop" onclick="addShopCar(<%=isLogin%>,'<%=goods.getGoodsId() %>')">加入购物车</button>
            </div>
        </div>
        
        
        
        <%
        		}
        	}
        	
        %>

     

    </div>

<!--------------------------------商品第二类----------------------------------->
    <!--商品顶部的title-->
    <div class="shop_title">
        <div></div>
        <div><h1>鞋类商品</h1></div>
        <div></div>
    </div>

    <!--------------------------商品的某一类------------------->
    <div class="row_item">
        <!--在jsp中可直接重复这一个div就可以-->
         <%
         	if(goodsList!=null)
        	for(Goods goods :goodsList){
        		if(goods.getGoodsCat().equals("鞋")){
        			String base64 =urlTrsBase64.byteToBase64(goods.getGoodsImage());
        
        %>
        
        
        <div class="each_item">
            <div class="div_gdimg"><img src="data:image/jpeg;base64,<%=base64%>" alt=""></div>
            <div class="price_name">
                <span class="gdname"><%=goods.getGoodsName() %></span>
                <span class="gdprice"><%=goods.getGoodsPrice() %></span>
            </div>
            <div class="div_btn">
                <button class="btn_detail btn8_shop" onclick ="getDetail('<%=goods.getGoodsId() %>','<%=userId %>')" id ="<%=goods.getGoodsId()%>">查看详情</button>
                <button class="btn_addtocart btn_shop" onclick="addShopCar(<%=isLogin%>,'<%=goods.getGoodsId() %>')">加入购物车</button>
            </div>
        </div>
        
        
           <%
        		}
        	}
        	
        %>
        
        </div>

        

    <!----------------------------------底部区域---------------------------------->
    <div class="footer">
        <div class="text">
            <div>7天内可退换货</div>
            <div>满99全场免邮</div>
            <div>100%品质保证</div>
        </div>
        <div class="help">
            <p>
                <a href="javascript:;">关于我们</a>
                <span>|</span>
                <a href="javascript:;">帮助中心</a>
                <span>|</span>
                <a href="javascript:;">售后服务</a>
                <span>|</span>
                <a href="javascript:;">购物资讯</a>
                <span>|</span>
                <a href="javascript:;">关于货源</a>
            </p>
            <p class="coty">购物商城版权所有 © 2012-2020</p>
        </div>
    </div>

</body>
</html>