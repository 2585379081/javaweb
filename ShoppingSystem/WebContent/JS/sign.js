
$(document).ready(function(){
    //点击按钮翻转面板
    $(".rotate_to_sign_in").click(function(){
        $('.container').css({
            'Transform':'rotateY(0deg)',
        })

    });
    $(".rotate_to_sign_up").click(function(){
        $('.container').css({
            'Transform':'rotateY(180deg)',
        })
    });

});


//用户登录提交
$(function() {
	
	  $('#loginform').submit(function() { //当提交表单时，会发生 submit 事件。
          //此处可做表单验证
          if ($("#loginUsername").val() == "") {
          	Toast('用户名不能为空',1000);
              return false;
          }else if($("#loginPassword").val() == ""){
          	Toast('密码不能为空',1000);
          	return false;
          }else{
          	var postData = $("#loginform").serialize(); //序列化表单，后台可正常通过post方法获取数据
              console.log(postData);
              $.ajax({
                  type: "POST",
                  url: "UserServlet?method=userLogin",
                  data: postData,
                  beforeSend: function() {
                      //$("#loginSubmitBtn").attr("disabled", true);//提交表单前的处理，防止用户多次点击【登陆】，重复提交表单
                      //$("#loginSubmitBtn").val("正在登陆...");
                  },
                  success: function(data) {
                  	//alert(JSON.stringify(data));
                  	//这段代码老是保存不了，所以没有执行
                  	if(data==0){
                  		Toast('用户名或密码错误',2000);	
                  	}else{
                  		Toast('登录成功',2000);
                  		window.location.href="IndexServlet";//跳转到主界面
                  	}    	
                  }
              });
          }
      });
  });

//用户注册
$(function() {
	
	  $('#signupform').submit(function() { //当提交表单时，会发生 submit 事件。
        //此处可做表单验证
        if ($("#signupUsername").val() == "") {
        	Toast('用户名不能为空',1000);
            return false;
        }else if($("#signupPassword").val() == ""){
        	Toast('密码不能为空',1000);
        	return false;
        }else{
        	var postData = $("#signupform").serialize(); //序列化表单，后台可正常通过post方法获取数据
            console.log(postData);
            $.ajax({
                type: "POST",
                url: "UserServlet?method=userReigster",
                data: postData,
                beforeSend: function() {
                    //$("#loginSubmitBtn").attr("disabled", true);//提交表单前的处理，防止用户多次点击【登陆】，重复提交表单
                    //$("#loginSubmitBtn").val("正在登陆...");
                },
                success: function(data) {
                	//alert(JSON.stringify(data));
                	//这段代码老是保存不了，所以没有执行
                	if(data==0){
                		Toast('用户名已注册',2000);	
                	}else{
                		Toast('注册成功，请登录',2000);
                		 $('.container').css({
                	        'Transform':'rotateY(180deg)',
                	     })
                	}    	
                }
            });
        }
    });
});













