/**
 * 
 */




function selectRow(obj){
	if(event.srcElement.tagName=="TD"){
	curRow=event.srcElement.parentElement;
	
	for(var i  = 0;i<document.getElementById("tb").rows.length;i++){
		document.getElementById("tb").rows[i].style.background="none";
		
		if(i==curRow.rowIndex){
			curRow.style.background="#f2f2f2";
		}
		
	}
	
	//curRow.style.background="#f2f2f2";
	
	var i = curRow.rowIndex;
	
	var rdID=document.getElementById("tb").rows[i].cells[0].innerHTML;

	//把rdID读者信息显示出来
	
		$.ajax({
			type:"GET",
			url:"http://localhost:8080/Libarary/servlet/QueryReader",
			data:{"rdID":rdID
	
			},
			
			success:function(reader){
				var infos = reader.split(",");
				document.getElementById("rdID").value=infos[0];
				document.getElementById("rdName").value=infos[1];
				document.getElementById("rdPwd").value=infos[2];
				document.getElementById("rdSex").value=infos[3];
				document.getElementById("rdBorrowNum").value=infos[4];
				document.getElementById("rdStatus").value=infos[5];
				document.getElementById("rdAdminRoles").value=infos[6];
				document.getElementById("rdType").value=infos[7];
				document.getElementById("rdDept").value=infos[8];
				document.getElementById("rdPhone").value=infos[9];
				document.getElementById("rdEmail").value=infos[10];
				document.getElementById("rdDateReg").value=infos[11];
				document.getElementById("rdPhoto").src=infos[12];
				
			},
			
			error:function(){
				alert("操作失败");
			}
		
		})
	
	
	}
}



function preview(file){

	 var prevDiv = document.getElementById('right_image');
	 var reader = new FileReader();
	          //当图片加载完成到内存的时候

	 reader.onload = function(evt) {
	         prevDiv.innerHTML = '<img src="' + evt.target.result + '" width="100" height="150"/>';
	 }
	 reader.readAsDataURL(file.files[0]);


}


function cancel(){
	location.reload();
}


function exit(){
	window.location.href = "http://localhost:8080/Libarary/login.jsp";
}

function runCard(){
	var rdID= document.getElementById("rdID");
	var rdName = document.getElementById("rdName");
	var rdPwd = document.getElementById("rdPwd");
	var rdSex =document.getElementById("rdSex");
	var rdBorrowNum= document.getElementById("rdBorrowNum");
	var rdStatus= document.getElementById("rdStatus");
	var rdAdminRoles= document.getElementById("rdAdminRoles");
	var rdType = document.getElementById("rdType");
	var rdDept =document.getElementById("rdDept");
	var rdPhone = document.getElementById("rdPhone");
	var rdEmail= document.getElementById("rdEmail");
	var rdDateReg =document.getElementById("rdDateReg");
	var thePic = document.getElementById("thePic");
	$('#changInfo').attr("disabled",true);
	$('#conChangeInfo').attr("disabled",true);
	$('#conRunCard').removeAttr("disabled");


	rdID.removeAttribute("disabled");
	rdID.value ="";
	rdName.removeAttribute("disabled");
	rdName.value ="";
	rdPwd.removeAttribute("disabled");
	rdPwd.value ="123";
	rdSex.removeAttribute("disabled");
	rdSex.value ="男";
	rdBorrowNum.value ="0";
	rdStatus.value ="有效";
	rdAdminRoles.value ="0";
	rdType.removeAttribute("disabled");
	rdType.value ="本科生";
	rdDept.removeAttribute("disabled");
	rdDept.value ="";
	rdPhone.removeAttribute("disabled");
	rdPhone.value ="";
	rdEmail.removeAttribute("disabled");
	rdEmail.value ="";
	
	thePic.removeAttribute("disabled");
	
	var date = new Date();
    var seperator1 = "-";
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = year + seperator1 + month + seperator1 + strDate;
	
	rdDateReg.value = currentdate;
}


function conRunCard(){
	var rdID= document.getElementById("rdID").value;
	var rdName = document.getElementById("rdName").value;
	var rdPwd = document.getElementById("rdPwd").value;
	var rdSex =document.getElementById("rdSex").value;
	var rdType = document.getElementById("rdType").value;
	var rdDept =document.getElementById("rdDept").value;
	var rdPhone = document.getElementById("rdPhone").value;
	var rdEmail= document.getElementById("rdEmail").value;
	var rdPhoto = document.getElementById("thePic").value;
	$('#changInfo').removeAttr("disabled");
	$('#conChangeInfo').removeAttr("disabled");

	
	
	if(rdID==""|rdName==""){
		alert("请输入完整的信息");
	}else{
		
		$.ajax({
			type:"GET",
			url:"http://localhost:8080/Libarary/servlet/RegisterReader",
			data:{"rdID":rdID,
				"rdName":rdName,
				"rdPwd":rdPwd,
				"rdSex":rdSex,
				"rdType":rdType,
				"rdDept":rdDept,
				"rdPhone":rdPhone,
				"rdEmail":rdEmail,
				"rdPhoto":rdPhoto

			},
			
			success:function(reader){
				location.reload();
				alert("操作成功");
				
			},
			
			error:function(){
				alert("操作失败");
			}
		
		})
		
	}
	
}


function changeInfo(){
	

	var rdName = document.getElementById("rdName");
	var rdPwd = document.getElementById("rdPwd");
	var rdSex =document.getElementById("rdSex");
	var rdBorrowNum= document.getElementById("rdBorrowNum");
	var rdStatus= document.getElementById("rdStatus");
	var rdAdminRoles= document.getElementById("rdAdminRoles");
	var rdType = document.getElementById("rdType");
	var rdDept =document.getElementById("rdDept");
	var rdPhone = document.getElementById("rdPhone");
	var rdEmail= document.getElementById("rdEmail");
	var rdDateReg =document.getElementById("rdDateReg");
	var rdPhoto = document.getElementById("thePic");
	$('#runCard').attr("disabled",true);
	$('#conRunCard').attr("disabled",true);
	$('#conChangeInfo').removeAttr("disabled");
	
	
	rdPhoto.removeAttribute("disabled");
	rdName.removeAttribute("disabled");
	rdPwd.removeAttribute("disabled");
	rdSex.removeAttribute("disabled");
	rdType.removeAttribute("disabled");
	rdDept.removeAttribute("disabled");
	rdPhone.removeAttribute("disabled");
	rdEmail.removeAttribute("disabled");
	
}

function conChangeInfo(){
	var rdID= document.getElementById("rdID").value;
	var rdName = document.getElementById("rdName").value;
	var rdPwd = document.getElementById("rdPwd").value;
	var rdSex =document.getElementById("rdSex").value;
	var rdType = document.getElementById("rdType").value;
	var rdDept =document.getElementById("rdDept").value;
	var rdPhone = document.getElementById("rdPhone").value;
	var rdEmail= document.getElementById("rdEmail").value;
	var rdPhoto = document.getElementById("thePic").value;
	$('#runCard').removeAttr("disabled");
	$('#conRunCard').removeAttr("disabled");
	//然后写一个更新的servlet，再到readerMapper中写一个statement，进行update操作
	
	
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/Libarary/servlet/UpdateReader",
		data:{"rdID":rdID,
			"rdName":rdName,
			"rdPwd":rdPwd,
			"rdSex":rdSex,
			"rdType":rdType,
			"rdDept":rdDept,
			"rdPhone":rdPhone,
			"rdEmail":rdEmail,
			"rdPhoto":rdPhoto

		},
		
		success:function(reader){
			//重新查询
			//window.location.href = "http://localhost:8080/Libarary/servlet/LoginServlet?rdID="+rdID+"&rdPwd="+rdPwd;
			location.reload();
			alert("操作成功");
			
		},
		
		error:function(){
			alert("操作失败");
		}
	
	})
}
