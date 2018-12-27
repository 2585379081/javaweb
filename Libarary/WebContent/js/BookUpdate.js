/**
 * 
 */


function exit(){
	location.reload();
}


function change(){
	var bkID = document.getElementById("bkID").value;
	var bkCode = document.getElementById("bkCode").value;
	var bkName =document.getElementById("bkName").value;
	var bkAuthor =document.getElementById("bkAuthor").value;
	var bkPress =document.getElementById("bkPress").value;
	var bkDatePress = document.getElementById("bkDatePress").value;
	var bkISBN =document.getElementById("bkISBN").value;
	var bkCatalog=document.getElementById("bkCatalog").value;
	var bkClassName =document.getElementById("bkClassName").value;
	var bkLanguage =document.getElementById("bkLanguage").value;
	var bkPages=document.getElementById("bkPages").value;
	var bkPrice =document.getElementById("bkPrice").value;
	var bkDateIn=document.getElementById("bkDateIn").value;
	var bkNum =document.getElementById("bkNum").value;
	var bkBrief =document.getElementById("bkBrief").value;
	var bkCover=document.getElementById("thePic").value;
	
	
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/Libarary/servlet/BookUpdate?update=1",
		data:{"bkID":bkID,
			"bkCode":bkCode,
			"bkName":bkName,
			"bkAuthor":bkAuthor,
			"bkPress":bkPress,
			"bkDatePress":bkDatePress,
			"bkISBN":bkISBN,
			"bkCatalog":bkCatalog,
			"bkLanguage":bkLanguage,
			"bkPages":bkPages,
			"bkPrice":bkPrice,
			"bkDateIn":bkDateIn,
			"bkBrief":bkBrief,
			"bkNum":bkNum,
			"bkClassName":bkClassName,
			"bkCover":bkCover

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



function find(){
	var bkID = document.getElementById("bkID").value;
	
	if(bkID ==null || bkID ==""){
		alert("请输入bkID");
		return;
	}
	
	$('#bkID').attr("disabled",true);
	
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/Libarary/servlet/BookUpdate?select=1",
		data:{"bkID":bkID

		},
		
		success:function(Info){
			//将信息显示出来
			var infos = Info.split(",");
			document.getElementById("bkID").value=infos[0];
			document.getElementById("bkCode").value=infos[1];
			document.getElementById("bkName").value=infos[2];
			document.getElementById("bkAuthor").value=infos[3];
			document.getElementById("bkPress").value=infos[4];
			document.getElementById("bkDatePress").value=infos[5];
			document.getElementById("bkISBN").value=infos[6];
			document.getElementById("bkCatalog").value=infos[7];
			document.getElementById("bkClassName").value=infos[8];
			document.getElementById("bkLanguage").value=infos[9];
			document.getElementById("bkPages").value=infos[10];
			document.getElementById("bkPrice").value=infos[11];
			document.getElementById("bkDateIn").value=infos[12];
			document.getElementById("bkNum").value=infos[13];
			document.getElementById("bkBrief").value=infos[14];
			document.getElementById("bkCover").src=infos[15];
		},
		
		error:function(){
			alert("操作失败");
		}
	
	})
	
	
}





function preview(file){

	 var prevDiv = document.getElementById('right_image');
	 var reader = new FileReader();
	          //当图片加载完成到内存的时候

	 reader.onload = function(evt) {
	         prevDiv.innerHTML = '<img src="' + evt.target.result + '" width="350px" height="310px"/>';
	 }
	 reader.readAsDataURL(file.files[0]);


}