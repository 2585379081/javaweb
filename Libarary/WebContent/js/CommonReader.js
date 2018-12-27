/**
 * 
 */


function preview(file){

	 var prevDiv = document.getElementById('right_image');
	 var reader = new FileReader();
	          //当图片加载完成到内存的时候

	 reader.onload = function(evt) {
	         prevDiv.innerHTML = '<img src="' + evt.target.result + '" width="100" height="150"/>';
	 }
	 reader.readAsDataURL(file.files[0]);


}


function exit(){
	window.location.href = "http://localhost:8080/Libarary/login.jsp";
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
	var changInfo = document.getElementById("changInfo");
	
	
	rdPhoto.removeAttribute("disabled");
	rdName.removeAttribute("disabled");
	rdPwd.removeAttribute("disabled");
	rdSex.removeAttribute("disabled");
	rdPhone.removeAttribute("disabled");
	rdEmail.removeAttribute("disabled");
	changInfo.removeAttribute("disabled");
	
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
			window.location.href = "http://localhost:8080/Libarary/servlet/LoginServlet?rdID="+rdID+"&rdPwd="+rdPwd;
			alert("操作成功");
			
		},
		
		error:function(){
			alert("操作失败");
		}
	
	})
}