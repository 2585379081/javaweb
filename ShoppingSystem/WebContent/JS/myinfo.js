/**
 * 
 */
/**
 * 
 */

var src;
function preview(file){

	 var prevDiv = document.getElementById('user_img');
	 var reader = new FileReader();
	          //当图片加载完成到内存的时候
	 reader.readAsDataURL(file.files[0]);
	 reader.onload = function(evt) {
	         prevDiv.innerHTML = '<img src="' + evt.target.result + '" width="100" height="150"/><input type="file" class="choose_img" id="image" value="更换图像" onchange = "preview(this)">';
	          src = evt.target.result;
	         $('.content').attr('src',src);
	         
	         
/*	       //把图片写到数据库中
	     	$.ajax({
	     		type:"POST",
	     		url:"http://localhost:8080/Shop/GoodsServlet?method=test",
	     		data:{"src":src

	     		},
	     		
	     		success:function(reader){
	     			alert("chengon");
	     			
	     		},
	     		
	     		error:function(){
	     			alert("操作失败");
	     		}
	     	
	     	})   */
	         
	 }
	 

	
}

function submit_user_info(userId){
	var nickName = document.getElementById("nickName").value;
	var phone = document.getElementById("phone").value;
	var userAddress = document.getElementById("userAddress").value;
	
	
	//通过ajax把信息保存
	$.ajax({
 		type:"POST",
 		url:"http://localhost:8080/ShoppingSystem/UserServlet?method=userAlterInf",
 		data:{"src":src,
 			"nickName":nickName,
 			"phone":phone,
 			"userAddress":userAddress,
 			"userId":userId

 		},
 		
 		success:function(info){
 			if(info==1){
 				//修改成功
 				Toast("修改成功");
 			}else{
 				Toast("修改失败");
 			}
 			
 		},
 		
 		error:function(){
 			Toast("修改失败");
 		}
 	
 	}) 
	
}


function changeLoginPwd(userId){
	var bfPwd = document.getElementById("bfPwd").value;
	var afPwd = document.getElementById("afPwd").value;
	
	
	//利用ajax来提交
	$.ajax({
 		type:"POST",
 		url:"http://localhost:8080/ShoppingSystem/UserServlet?method=userAlterPwd",
 		data:{"bfPwd":bfPwd,
 			"afPwd":afPwd,
 			"userId":userId

 		},
 		
 		success:function(info){
 			if(info==1){
 				//修改成功
 				Toast("修改成功");
 				document.getElementById("bfPwd").value="";
 				document.getElementById("afPwd").value="";
 			}else if(info==0){
 				Toast("新密码不能和旧密码相同");
 			}else if(info ==-1){
 				Toast("旧密码错误");
 			}else{
 				Toast("修改失败");
 			}
 			
 		},
 		
 		error:function(){
 			Toast("修改失败");
 		}
 	
 	}) 
}



function changePyPwd(userId){
	var userPwd = document.getElementById("userPwd").value;
	var userPayPwd = document.getElementById("userPayPwd").value;
	
	
	//利用ajax来提交
	$.ajax({
 		type:"POST",
 		url:"http://localhost:8080/ShoppingSystem/UserServlet?method=userPayPwd",
 		data:{"userPwd":userPwd,
 			"userPayPwd":userPayPwd,
 			"userId":userId

 		},
 		
 		success:function(info){
 			if(info==1){
 				document.getElementById("userPwd").value="";
 				document.getElementById("userPayPwd").value="";
 				Toast("修改成功");
 			}else{
 				Toast("修改失败");
 			}
 			
 		},
 		
 		error:function(){
 			Toast("修改失败");
 		}
 	
 	}) 
}



function openVip(userId){
	var days = $('input:radio[name="days"]:checked').val();
	
	//利用ajax来开通vip
	$.ajax({
 		type:"POST",
 		url:"http://localhost:8080/ShoppingSystem/UserServlet?method=userOpenVip",
 		data:{"days":days,
 			"userId":userId

 		},
 		
 		success:function(info){
 			if(info==1){
 				Toast("开通成功");
 				window.location.href="http://localhost:8080/ShoppingSystem/UserServlet?method=showBaseInfo"
 			}else{
 				Toast("开通失败");
 			}
 			
 		},
 		
 		error:function(){
 			Toast("开通失败");
 		}
 	
 	}) 
	
}

function changeMoney(){
	var days = $('input:radio[name="days"]:checked').val();
	//假如一天1元
	var price = 1;
	var count = price*days;
	document.getElementById("count").innerHTML=count;
}
