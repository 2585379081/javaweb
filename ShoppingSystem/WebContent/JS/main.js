/*$(document).ready(function(){
    //点击详情按钮
    $('.btn_detail').click(function () {
        window.location.href="goodsdetail.jsp";
    })
});*/

function getDetail(goodsId,userId){
	if(userId ==null || userId == "注册/登录"){
		Toast("您还没登录");
		return;
	}
	window.location.href = "http://localhost:8080/ShoppingSystem/GoodsServlet?method=queryById&goodsId="+goodsId;
}


function query(){
	var goodsName = document.getElementById("goodsName").value;
	window.location.href = "http://localhost:8080/ShoppingSystem/GoodsServlet?method=queryByName&goodsName="+ goodsName;
}


//添加到购物车
function addShopCar(isLogin,goodsid){
	if(isLogin){
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
	}else{
		Toast('您还未登录',1000);
	}
	
}