<%@ page language="java" contentType="text/html; charset=UTF-8" import ="com.shop.pojo.*,com.shop.tool.*"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<html>
<head  lang="zh">
	<base href = "<%=basePath%>"/>
    <meta charset="UTF-8">
    <title>商品详情</title>
    <link rel="stylesheet" href="CSS/bootstrap.min.css">
    <script src="JS/jquery.min.js"></script>
    <script src="JS/bootstrap.min.js"></script>

    <link rel="stylesheet" href="CSS/min.css">
    <link rel="stylesheet" href="CSS/goodsdetail.css">
    <script src="JS/tools.js"></script>
    <script src="JS/goodsdetail.js"></script>
</head>
<body>


<div class="global"><!--放两大块的容器-->
    <!----------------------------------左边是商品详情----------------------------->
    
    <%
    	Goods goods =(Goods)request.getAttribute("goods");
   		 String base64 =urlTrsBase64.byteToBase64(goods.getGoodsImage());

    
    %>
    
    <div class="left_content">
        <div class="header">
            Goods&nbsp;&nbsp;<span>Detail</span>
        </div>
        <div class="content">
            <div class="img_div"><img src="data:image/jpeg;base64,<%=base64%>" alt=""></div>
            <div class="goods_info">
                <div>商品名称：<span><%=goods.getGoodsName() %></span></div>
                <div>商品价格：<span><%=goods.getGoodsPrice() %></span>&nbsp;&nbsp;会员价格：<span><%=String.format("%.2f",goods.getGoodsPrice()*0.8) %></span></div>
                <div>
                    <form action="">
                        <!--向服务器传参用-->
                        <input type  ="hidden" id = "goodsId" value = "<%=goods.getGoodsId() %>"/>
                        <input type="hidden">
                        <input type="hidden">
                        <button type="button" class="btn btn-primary btn-block" onclick="addShopCar('<%=goods.getGoodsId()%>')">加入到购物车</button>
                    </form>
                </div>
                <div>
                    <form action="">
                        <!--向服务器传参用-->
                        <input type="hidden">
                        <input type="hidden">
                        <input type="hidden">
                        <button type="button" class="btn btn-primary btn-block btn_price">立即购买</button>
                    </form>
                </div>
            </div>
            <div class="goods_brief">
            <%=goods.getGoodsBrief() %>
            </div>
        </div>
        <div class="content_foot">
                <div class="phone">46315-443133431</div>
        </div>

    </div>
    <!----------------------------------右边是聊天界面(客服)----------------------------->
    <div class="assist_div">
        <!--顶部-->
        <div class="header-title">客服</div>
        <!--底部发消息-->
        <div class="chat-edit">
            <input type="text" class="chat-info">
            <button type="submit" class="btn btn-primary btn-block sendMsg">发送</button>
        </div>
        <div class="right_content">
            <div class="top_zhanwei"></div>

            <!--客服聊天气泡-->
            <div class="bubbleItem">
                <div class="server-head">
                    <img src="images/user.png" alt="server"/>
                </div>
                <span class="left_triangle"></span>
                <span class="bubble leftBubble">
                你好，我是你爸爸，有什么需要帮助的吗？你好，我是你爸爸，有什么需要帮助的吗？你好，我是你爸爸，有什么需要帮助的吗？
            </span>
            </div>
            <!--用户聊天气泡-->
            <div class="bubbleItem">
                <div class="user-head">
                    <img src="images/user.png" alt="user"/>
                </div>
                <span class="right_triangle"></span>
                <span class="bubble rightBubble">
                     ben儿子不需要
                </span>
            </div>
            <!--用户聊天气泡-->
            <div class="bubbleItem">
                <div class="user-head">
                    <img src="images/user.png" alt="user"/>
                </div>
                <span class="right_triangle"></span>
                <span class="bubble rightBubble">
                ben儿子不需要
            </span>
            </div>
            <!--客服聊天气泡-->
            <div class="bubbleItem">
                <div class="server-head">
                    <img src="images/user.png" alt="server"/>
                </div>
                <span class="left_triangle"></span>
                <span class="bubble leftBubble">
                    你好，我是你爸爸，有什么需要帮助的吗？你好，我是你爸爸，有什么需要帮助的吗？你好，我是你爸爸，有什么需要帮助的吗？
                </span>
            </div>
            <!--底部占位让下面的消息靠上面显示-->
            <!--<div class="bottom_zhanwei"></div>-->
        </div>

    </div>


</div>
</body>
</html>