/**
 * 
 */

function cancel(){
	var rdID = document.getElementById("rdID").value;
	
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/Libarary/servlet/CancelServlet?id=4",
		data:{"rdID":rdID

		},
		
		success:function(Info){
			//将信息显示出来
			var infos = Info.split(",");
			document.getElementById("rdName").value=infos[1];
			document.getElementById("rdSex").value=infos[2];
			document.getElementById("rdType").value=infos[3];
			document.getElementById("rdStatus").value=infos[4];
			alert("操作成功");
		},
		
		error:function(){
			alert("操作失败");
		}
	
	})
	
}

function removeLost(){
	var rdID = document.getElementById("rdID").value;
	var rdStatus = document.getElementById("rdStatus").value;
	
	if(rdStatus=="注销"){
		alert("用户已经注销");
		return;
	}
	
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/Libarary/servlet/CancelServlet?id=3",
		data:{"rdID":rdID

		},
		
		success:function(Info){
			//将信息显示出来
			var infos = Info.split(",");
			document.getElementById("rdName").value=infos[1];
			document.getElementById("rdSex").value=infos[2];
			document.getElementById("rdType").value=infos[3];
			document.getElementById("rdStatus").value=infos[4];
			alert("操作成功");
		},
		
		error:function(){
			alert("操作失败");
		}
	
	})
	
}

function lost(){
	var rdID = document.getElementById("rdID").value;
	var rdStatus = document.getElementById("rdStatus").value;
	
	if(rdStatus=="注销"){
		alert("用户已经注销");
		return;
	}
	
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/Libarary/servlet/CancelServlet?id=2",
		data:{"rdID":rdID

		},
		
		success:function(Info){
			//将信息显示出来
			var infos = Info.split(",");
			document.getElementById("rdName").value=infos[1];
			document.getElementById("rdSex").value=infos[2];
			document.getElementById("rdType").value=infos[3];
			document.getElementById("rdStatus").value=infos[4];
			alert("操作成功");
		},
		
		error:function(){
			alert("操作失败");
		}
	
	})
	
}


function find(){
	var rdID = document.getElementById("rdID").value;
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/Libarary/servlet/CancelServlet?id=1",
		data:{"rdID":rdID

		},
		
		success:function(Info){
			//将信息显示出来
			var infos = Info.split(",");
			document.getElementById("rdName").value=infos[1];
			document.getElementById("rdSex").value=infos[2];
			document.getElementById("rdType").value=infos[3];
			document.getElementById("rdStatus").value=infos[4];
			
		},
		
		error:function(){
			alert("操作失败");
		}
	
	})
}