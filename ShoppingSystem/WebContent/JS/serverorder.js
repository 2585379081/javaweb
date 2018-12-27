
//根据用户名查找订单
function searchOrderById(){
	var userId= document.getElementById("userId").value;
	if(userId==""){
		window.location.href="OrderServlet?method=getAllOrders";
	}else{
		window.location.href="OrderServlet?method=searchOrderById&userId="+userId;
	}
}