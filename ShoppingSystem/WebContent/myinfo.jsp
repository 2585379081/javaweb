<%@ page language="java" contentType="text/html; charset=UTF-8" import = "com.shop.pojo.*,com.shop.tool.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String userId = (String)request.getSession().getAttribute("userId");
User user = (User)request.getSession().getAttribute("user");
String image="images/user.png";
String vipImage = "images/novip.png";
String openVipText = "开通vip";
if(user==null){
	user = new User();
	user.setNickName("");
	user.setPhone("");
	user.setUserAddress("");
	
}else{
	user =(User)request.getSession().getAttribute("user");
	if(user.getUserImage()!=null){
		byte[] bytes = user.getUserImage();
		String base64 = urlTrsBase64.byteToBase64(bytes);
		image = "data:image/jpeg;base64,"+base64 ;
	}
	
	if(user.getIsVip()>=1){
		vipImage = "images/welcomvip.png";
		openVipText = "续费";
	}
}

%>
<html lang="zh">
<head>
	<base href ="basePath"/>
    <meta charset="UTF-8">
    <title>个人资料</title>
    <link rel="stylesheet" href="CSS/bootstrap.min.css">
    <script src="JS/jquery.min.js"></script>
    <script src="JS/bootstrap.min.js"></script>
    <script src="JS/tools.js"></script>
	<script src="JS/myinfo.js"></script>
    <!--<link rel="stylesheet" href="CSS/min.css">-->
    <link rel="stylesheet" href="CSS/myinfo.css">

</head>
<body>
<!-------------------------------顶部bar----------------------------->
<div class="topbar">
    <div class="topbar_center">
        <div class="topbar_left"><a href="IndexServlet">首页</a></div>
        <div class="topbar_right user_name"><%=user.getNickName() %></div>
        <div class="topbar_right goto_shopcart"><a href="ShopCartServlet?method=getAllShopCart">购物车</a></div>
        <div class="topbar_right goto_order"><a href="#">我的订单</a></div>
    </div>
</div>
<div class="header">
    <div class="h_center">
        <div class="header_left">

        </div>
        <div class="header_right">

        </div>
    </div>

</div>
<!--标题导航-->
<div class="nav_title">
    <div class="nav_center">
        <div class="title_content"><a >基本信息</a></div>
        <div class="title_content"><a >会员信息</a></div>
        <div class="title_content"><a >安全设置</a></div>
    </div>
</div>
<!--用户所有信息-->
<div class="user_info">

    <!--等待提交的基本信息form-->
    <form action="" >
        <div class="left_info">
            <div class="left_title">基本信息</div>
            <div class="info_account">
                <div>账号:</div>
                <div class="account"><%=userId %></div>
            </div>
            <div class="info_nickname">
                <div>昵称:</div>
                <input type="text" id = "nickName" name="nickName" value = "<%=user.getNickName()%>">
            </div>
            <div class="info_nickname">
                <div>电话:</div>
                <input type="text" id = "phone" name="phone" value = "<%=user.getPhone()%>">
            </div>
            <div class="info_nickname">
                <div>收获地址:</div>
                <input type="text"  id ="userAddress" name="userAddress" value = "<%=user.getUserAddress()%>">
            </div>
            <input type="button" class="submit_user_info" value="保存修改" onclick = "submit_user_info('<%=userId%>')">
        </div>
        <div class="user_img" id = "user_img">
            <img src="<%=image %>" alt="">
            <input type="file" class="choose_img" id="image" value="更换图像" onchange = "preview(this)">
        </div>
    </form>
    <!--等待提交的会员信息form-->
    <form action="">
        <div class="right_info">
            <div class="right_title">会员信息</div>
            <img src="<%=vipImage %>" alt="" class="vip_status">
            <div class="joinVip"><%=openVipText %></div>
            <form>
                <label><input type="radio" name="days" value = "30" onchange="changeMoney()" >30天</label>
                <label><input type="radio" name="days" value = "60" onchange="changeMoney()" >60天</label>
                <label><input type="radio" name="days" value ="90" onchange="changeMoney()" >90天</label>
                <span>总价：<span id ="count">--</span></span>
                <input type="button" value="<%=openVipText %>" class="btn_vip" onclick = "openVip('<%=userId%>')">
            </form>
        </div>
    </form>
    <!--等待提交的安全设置form-->
    <!--<form action="">-->
    <div class="safe_setting">
        <div class="safe_title">安全设置</div>
        <!--登录密码安全设置-->
        <div class="login_pwd_safe safe_div">
            <form action="">
                <div>
                    <div>旧登录密码:</div>
                    <input type="text" placeholder="输入旧登录密码" id = "bfPwd" name="bfPwd">
                </div>
                <div>
                    <div>新登录密码:</div>
                    <input type="text" placeholder="输入新密码" id= "afPwd" name="afPwd">
                    <input type="button" onclick = "changeLoginPwd('<%=userId%>')" value = "提交">
                </div>
            </form>
        </div>
        <!--支付密码设置-->
        <div class="pay_pwd_safe safe_div">
            <form action="">
                <div>
                    <div>登录密码:</div>
                    <input type="text" placeholder="输入登录密码用于验证" name="userPwd" id = "userPwd">
                </div>
                <div>
                    <div>新支付密码:</div>
                    <input type="text" placeholder="输入新支付密码" name="userPayPwd" id= "userPayPwd">
                    <input type="button" onclick = "changePyPwd('<%=userId%>')" value = "提交">
                </div>
            </form>
        </div>
    </div>
    <!--</form>-->
</div>
</body>
</html>