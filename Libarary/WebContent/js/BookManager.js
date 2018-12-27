/**
 * 
 */

function preview(file){

	 var prevDiv = document.getElementById('right_image');
	 var reader = new FileReader();
	          //当图片加载完成到内存的时候

	 reader.onload = function(evt) {
	         prevDiv.innerHTML = '<img src="' + evt.target.result + '" width="350px" height="310px"/>';
	 }
	 reader.readAsDataURL(file.files[0]);


}

function addBook(){
	
	
	var bkCode = document.getElementById("bkCode").value;
	var bkName = document.getElementById("bkName").value;
	var bkAuthor =document.getElementById("bkAuthor").value;
	var bkPress= document.getElementById("bkPress").value;
	var bkDatePress= document.getElementById("bkDatePress").value;
	var bkISBN= document.getElementById("bkISBN").value;
	var bkCatalog =document.getElementById("bkCatalog").value;
	var bkLanguage = document.getElementById("bkLanguage").value;
	var bkPages =document.getElementById("bkPages").value;
	var bkPrice = document.getElementById("bkPrice").value;
	var bkDateIn= document.getElementById("bkDateIn").value;
	var bkBrief = document.getElementById("bkBrief").value;
	var bkNum =document.getElementById("bkNum").value;
	var bkClassName = document.getElementById("bkClassName").value;
	var bkCover = document.getElementById("thePic").value;
	
	//然后向发给servlet，向数据库中写
	
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/Libarary/servlet/AddBook",
		data:{"bkCode":bkCode,
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
		
		success:function(book){
			location.reload();
			alert("操作成功");
			
		},
		
		error:function(){
			alert("操作失败");
		}
	
	})
	
}