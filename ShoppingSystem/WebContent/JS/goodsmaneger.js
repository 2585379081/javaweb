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
	         prevDiv.innerHTML = '<img src="' + evt.target.result + '" width="100" height="150"/><input type="file" class="choose_img" value="更换图像" onchange = "preview(this)">';
	          src = evt.target.result;
	         $('.content').attr('src',src);
	 }
	 

	
}

function alter_goods(){
	
	var goodsName= document.getElementById("goodsName").value;
	var goodsCat= document.getElementById("goodsCat").value;
	var goodsNum= document.getElementById("goodsNum").value;
	var goodsPrice= document.getElementById("goodsPrice").value;
	var goodsId= document.getElementById("goodsId").value;
	var goodsBrief= document.getElementById("goodsBrief").value;
	
	//通过ajax来提交
	
 	$.ajax({
 		type:"POST",
 		url:"GoodsServlet?method=updateGoods",
 		data:{"src":src,
 			"goodsName":goodsName,
 			"goodsCat":goodsCat,
 			"goodsNum":goodsNum,
 			"goodsPrice":goodsPrice,
 			"goodsId":goodsId,
 			"goodsBrief":goodsBrief

 		},
 		
 		success:function(info){
 			if(info==1){
 				Toast("修改成功");
 				document.getElementById("goodsName").value="";
 				document.getElementById("goodsCat").value="";
 				document.getElementById("goodsNum").value="";
 				document.getElementById("goodsPrice").value="";
 				document.getElementById("goodsId").value="";
 				document.getElementById("goodsBrief").value="";
 				//document.getElementById("goodsImage").src="images/user.png";
 			}else{
 				Toast("修改失败");
 			}
 			
 		},
 		
 		error:function(){
 			Toast("修改失败");
 		}
 	
 	}) 
	
}


function submit_goods(){
	var goodsName= document.getElementById("goodsName").value;
	var goodsCat= document.getElementById("goodsCat").value;
	var goodsNum= document.getElementById("goodsNum").value;
	var goodsPrice= document.getElementById("goodsPrice").value;
	var goodsId= document.getElementById("goodsId").value;
	var goodsBrief= document.getElementById("goodsBrief").value;
	
	//通过ajax来提交
	
 	$.ajax({
 		type:"POST",
 		url:"GoodsServlet?method=addGoods",
 		data:{"src":src,
 			"goodsName":goodsName,
 			"goodsCat":goodsCat,
 			"goodsNum":goodsNum,
 			"goodsPrice":goodsPrice,
 			"goodsId":goodsId,
 			"goodsBrief":goodsBrief

 		},
 		
 		success:function(info){
 			if(info==1){
 				Toast("添加成功");
 				document.getElementById("goodsName").value="";
 				document.getElementById("goodsCat").value="";
 				document.getElementById("goodsNum").value="";
 				document.getElementById("goodsPrice").value="";
 				document.getElementById("goodsId").value="";
 				document.getElementById("goodsBrief").value="";
 				//document.getElementById("goodsImage").src="images/user.png";
 			}else{
 				Toast("添加失败");
 			}
 			
 		},
 		
 		error:function(){
 			Toast("添加失败");
 		}
 	
 	}) 
}
