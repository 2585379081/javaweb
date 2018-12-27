




//添加到购物车
function addShopCar(goodsid){

		$.ajax({
	        url:"ShopCartServlet?method=addGoods",
	        type:"POST",
	        data:{
	            "goodsId":goodsid,
	            "goodsQty":1
	        },
	        success:function (data) {
	        	if(data==-1){
	        		Toast('还添，老子都没货了',1000);
	        	}else{
	        		Toast('添加成功',1000);
	        	}        	
	        },
	        error:function (data) {

	        }
	    })
	
	
}

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
        $(".right_content").append(createuser($textContent));
       // $(".right_content").append(createserver($textContent));
        //清空input的值
        $('.chat-info').val("");

    });
    
    
    
    $(".btn_price").click(function(){
//    	var userId=document.getElementsByClassName(".user_name");
    	var userInfoIsComplete=false;
    	//判断用户基本信息是否完整
    	$.ajax({
    		url:"UserServlet?method=judgeBaseInfo",
            type:"POST",
            data:{
                
            },
            success:function (data) {
            	if(data==0){
            		Toast('请先完善基本信息',1000);
            		userInfoIsComplete=false;
            	}else{
            		var goodsId = document.getElementById("goodsId").value;
            		var goodsQty = 1;
                	$.ajaxSettings.traditional=true;//ajax接收多个值list时千万不能掉
                	$.ajax({
                		url:"OrderServlet?method=addOrder",
                        type:"POST",
                        data:{
                            "goodsIdList":goodsId,
                            "goodsQtyList":goodsQty
                        },
                        success:function (data) {
                        	Toast('订单生成成功',500);
                        	window.location.href = "OrderServlet?method=getAllOrder";
                        },
                        error:function (data) {
                        	
                        }
                    })
            	}
            },
            error:function (data) {
            	
            }
        })
    	
    	var sumPriceId=document.getElementById("sumPriceId");//应付总价的span
        var goodsIdList =[],goodsQtyList=[];
        
        $('input[name="check"]:checked').each(function(){
        	goodsIdList.push($(this).val());//在jsp中使得每一个复选框的值都是goodsId
        });
        
        
        if(goodsIdList.length==0 ){
        	Toast('您未选中任何商品',1000);
        }
    });

});


function createserver($textContent){
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

function createuser($textContent) {
    var block;
    // 如果胸袭为空
    if($textContent == ''|| $textContent == 'null'){
        Toast('消息不能为空~',1000);
        return;
    }
    
    
    //把$textContent传给客户端，客户端在给服务器端发消息
    //通过ajax发送给客户端
    $.ajax({
		url:"ChatServlet?method=getClient1",
        type:"POST",
        data:{
            "msg":$textContent
        },
        success:function (data) {
        },
        error:function (data) {

        }
    })
    
    block = '<div class="bubbleItem">'+
                '<div class="user-head">'+
                    '<img src="images/user.png" alt="user"/>'+
                '</div>'+
                '<span class="right_triangle"></span>'+
                '<span class="bubble rightBubble">'+
                    $textContent+
                '</span>'+
            '</div>'

    return block;
};




var getting = {
		
		type:"POST",
        url:'ChatServlet?method=sendClient2',

        dataType:'text',

        success:function(res) {
        	if(res !=null && res != ""){
        		//alert(res);
        		  //点击发送滚动条置底
        		  var scrollHeight = $('.right_content').prop("scrollHeight");
                $('.right_content').animate({scrollTop:scrollHeight}, 400);
        		  $(".right_content").append(createserver(res));
               
        	}

        }

};

//关键在这里，Ajax定时访问服务端，不断获取数据 ，这里是1秒请求一次。

window.setInterval(function(){$.ajax(getting)},1000);