/**
 * 
 */


var bkID ;
function exit(){
	location.reload();
}

function selectRow(obj){
	if(event.srcElement.tagName=="TD"){
	curRow=event.srcElement.parentElement;
	
	for(var i  = 0;i<document.getElementById("tb").rows.length;i++){
		document.getElementById("tb").rows[i].style.background="none";
		
		if(i==curRow.rowIndex){
			curRow.style.background="#f2f2f2";
		}
		
	}
	
	var i = curRow.rowIndex;
	
	bkID=document.getElementById("tb").rows[i].cells[0].innerHTML;
	//删除bkID对应的书
	
	}
}


function deleted(){
	
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/Libarary/servlet/RemoveBook",
		data:{"bkID":bkID

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

function query(){

	//利用content Window可以得到里面iframe的子窗口
	//在子窗口中写了一个hidden id是page   通过id 来区分是简单查询还是复杂查询
	var a =$("#iframe")[0].contentWindow;
	var page =a.document.getElementById("page").value;
	if(page=="simpleQuery"){
		simpleQuery();
		
	}else{
		comQuery();
	}
}


function simpleQuery(){
	//获得简单查询的值
	var a =$("#iframe")[0].contentWindow;
	var queryType = a.document.getElementById("queryType").value;
	var queryName = a.document.getElementById("queryName").value;
	
	//不用ajax
	window.location.href  ="http://localhost:8080/Libarary/servlet/QueryBook?queryType="+queryType+"&queryName="+queryName;
	
}

function comQuery(){
	var a =$("#iframe")[0].contentWindow;
	var bkName = a.document.getElementById("bkName").value;
	var bkAuthor = a.document.getElementById("bkAuthor").value;
	var bkBrief = a.document.getElementById("bkBrief").value;
	var bkPress = a.document.getElementById("bkPress").value;
	var bkCatalog = a.document.getElementById("bkCatalog").value;
	var bkPressYear = a.document.getElementById("bkPressYear").value;
	
	window.location.href ="http://localhost:8080/Libarary/servlet/QueryBook?bkName="+bkName+"&bkAuthor="+bkAuthor+"&bkBrief="+bkBrief+"&bkPress="+bkPress+"&bkCatalog="+bkCatalog+"&bkPressYear"+bkPressYear;
	
}