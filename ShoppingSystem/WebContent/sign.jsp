<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>注册登录</title>
    <link rel="stylesheet" href="CSS/sign.css">
    <script src="JS/jquery-3.3.1.js"></script>
    <script src="JS/tools.js"></script>
    <script src="JS/sign.js"></script>

</head>
<body>

<div class="container">
    <section class="content sign_in">
        <form action="UserServlet?method=userLogin" method="post" id="loginform" onsubmit="return false;">
            <h1>用户登录</h1>
            <div>
                <input type="text" placeholder="用户名"  name="userId" class="username" id="loginUsername"/>
            </div>
            <div>
                <input type="password" placeholder="密码"  name="userPwd" class="password" id="loginPassword"/>
            </div>
            <div class="">
                <span class="help-block u-errormessage" >&nbsp;</span>			</div>
            <div>
                <!-- <input type="submit" value="Log in" /> -->
                <input type="submit" value="登录" class="btn btn-primary" id="loginSubmitBtn"/>
                <a href="#">忘记密码?</a>
                <!-- <a href="#">Register</a> -->
            </div>
        </form><!-- form -->
        <div class="button">
            <a href="javascript:void(0);" class="rotate_to_sign_up">立即注册</a>
        </div> <!-- button -->
    </section><!-- content -->

    <section class="content sign_up">
        <form action="UserSevlet" method="post" id="signupform" onsubmit="return false;">
            <h1>用户注册</h1>
            <div>
                <input type="text" placeholder="注册用户名"  name="userId" class="username" id="signupUsername"/>
            </div>
            <div>
                <input type="password" placeholder="输入密码"  name="userPwd" class="password" id="signupPassword"/>
            </div>
            <div class="">
                <span class="help-block u-errormessage" >&nbsp;</span>			</div>
            <div>
                <!-- <input type="submit" value="Log in" /> -->
                <input type="submit" value="注册" class="btn btn-primary" id="signupSubmitBtn"/>
                <!--<a href="#">忘记密码?</a>-->
                 <a href="#">Register</a>
            </div>
        </form><!-- form -->
        <div class="button">
            <a href="javascript:void(0);" class="rotate_to_sign_in">返回登录</a>
        </div> <!-- button -->
    </section><!-- content -->
</div>
</body>
</html>