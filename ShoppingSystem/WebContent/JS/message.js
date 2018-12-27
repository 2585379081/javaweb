/**
 * 
 */

$(document).ready(function(){
    var scrollHeight = $('.right_content').prop("scrollHeight");
    //点击发送滚动条置底
    $('.right_content').animate({scrollTop:scrollHeight}, 0);
    //点击发送

    $(".sendMsg").click(function () {
        //点击发送滚动条置底
        $('.right_content').animate({scrollTop:scrollHeight}, 400);
        //在.right_content子元素最后添加html代码
        var $textContent = $(".chat-info").val();
        $(".right_content").append(createright($textContent));
       // $(".right_content").append(createleft($textContent));
        //清空input的值
        $('.chat-info').val("");

    });

});

function createright($textContent) {
    var block;
    // 如果胸袭为空
    if($textContent == ''|| $textContent == 'null'){
        Toast('消息不能为空~',1000);
        return;
    }
    
  //把$textContent传给客户端，客户端在给服务器端发消息
    //通过ajax发送给客户端
    $.ajax({
		url:"ChatServlet?method=getClient2",
        type:"POST",
        data:{
            "info":$textContent
        },
        success:function (data) {
        },
        error:function (data) {

        }
    })
    
    block = '<div class="bubbleItem">'+
        '<div class="user-head">'+
        '<img src="images/user.png" alt="server"/>'+
        '</div>'+
        '<span class="right_triangle"></span>'+
        '<span class="bubble rightBubble">'+
        $textContent+
        '</span>'+
        '</div>'

    return block;
};


function createleft($textContent){
    var block;
    // 如果胸袭为空
    if($textContent == ''|| $textContent == 'null'){
        Toast('消息不能为空~',1000);
        return;
    }
    block = '<div class="bubbleItem">'+
        '<div class="server-head">'+
        '<img src="images/user.png" alt="user"/>'+
        '</div>'+
        '<span class="left_triangle"></span>'+
        '<span class="bubble leftBubble">'+
        $textContent+
        '</span>'+
        '</div>'

    return block;
}


var getting = {
		
		type:"POST",
        url:'ChatServlet?method=sendClient1',

        dataType:'text',

        success:function(res) {
        	if(res !=null && res != ""){
        		//alert(res);
        		 //点击发送滚动条置底
        		  var scrollHeight = $('.right_content').prop("scrollHeight");
                $('.right_content').animate({scrollTop:scrollHeight}, 400);
        		$(".right_content").append(createleft(res));
               
        	}

        }

};

//关键在这里，Ajax定时访问服务端，不断获取数据 ，这里是1秒请求一次。

window.setInterval(function(){$.ajax(getting)},1000);