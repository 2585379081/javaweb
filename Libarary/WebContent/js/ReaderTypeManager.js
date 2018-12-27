/**
 * 
 */

/**
 * 
 */

function change(){
	$('#rdName').removeAttr("disabled"); 
	$('#rdSex').removeAttr("disabled"); 
	$('#rdType').removeAttr("disabled"); 
	$('#rdAdminRoles').removeAttr("disabled"); 
	$('#rdID').attr("disabled",true);
	$('#conChange').removeAttr("disabled"); 
	
}


function deleted(){
	var rdID = document.getElementById("rdID").value;
	
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/Libarary/servlet/CancelServlet?id=5",
		data:{"rdID":rdID,

		},
		
		success:function(Info){
			//将信息显示出来
		alert("操作成功");
		location.reload();
			
		},
		
		error:function(){
			alert("操作失败");
		}
	
	})
	
}

function conChange(){
	var rdID = document.getElementById("rdID").value;
	var rdName = document.getElementById("rdName").value;
	var rdSex = document.getElementById("rdSex").value;
	var rdType = document.getElementById("rdType").value;
	var rdAdminRoles = document.getElementById("rdAdminRoles").value;
	
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/Libarary/servlet/ReaderTypeManager",
		data:{"rdID":rdID,
			"rdName":rdName,
			"rdSex":rdSex,
			"rdType":rdType,
			"rdAdminRoles":rdAdminRoles

		},
		
		success:function(Info){
			//将信息显示出来
		alert("操作成功");
		find();
		$('#rdName').attr("disabled",true);
		$('#rdSex').attr("disabled",true);
		$('#rdType').attr("disabled",true);
		$('#rdAdminRoles').attr("disabled",true);
		$('#conChange').attr("disabled",true);
		$('#rdID').removeAttr("disabled"); 
			
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
			document.getElementById("rdAdminRoles").value=infos[5];
			
		},
		
		error:function(){
			alert("操作失败");
		}
	
	})
}