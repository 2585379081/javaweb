<%@ page language="java" contentType="text/html; charset=UTF-8" import ="com.shop.pojo.*,com.shop.tool.*"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
User user = (User)request.getSession().getAttribute("user");
String image= "images/user.png";
//System.out.print(user);
if(user!=null){
	//image = "data:image/jpeg;base64,"+urlTrsBase64.byteToBase64(user.getUserImage());
	//System.out.print("user");
}
%>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>消息</title>
    <link rel="stylesheet" href="CSS/bootstrap.min.css">
    <script src="JS/jquery.min.js"></script>
    <script src="JS/bootstrap.min.js"></script>

    <link rel="stylesheet" href="CSS/min.css">
    <script src="JS/tools.js"></script>

    <link rel="stylesheet" href="CSS/message.css">
    <script src="JS/message.js"></script>

</head>
<body>
<div class="global">
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