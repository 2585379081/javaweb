/**
 * 
 */

function queryReaderInfo(){
	var rdID = document.getElementById("rdID").value;
	
	window.location.href = "http://localhost:8080/Libarary/servlet/BorrowReaderInfo?rdID="+rdID+"&level=1";
	
/*	$.ajax({
		type:"POST",
		url:"http://localhost:8080/Libarary/servlet/BorrowReaderInfo",
		data:{"rdID":rdID,

		},
		
		success:function(Info){
			//将信息显示出来
			var infos = new Array();
			infos = Info.split(" ");
			document.getElementById("rdName").value  = infos[1];
			rdDept = document.getElementById("rdDept").value = infos[2];
			rdType = document.getElementById("rdType").value = infos[3];
			document.getElementById("canLendNum").value=infos[4]-infos[6];
			document.getElementById("canLendDay").value=infos[5];
			lendedNum = document.getElementById("lendedNum").value=infos[6];
		},
		
		error:function(){
			alert("操作失败");
		}
	
	})*/
	
}

function contitueLend(bkID,rdID,operatorLend){
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/Libarary/servlet/LendBook?id=1",
		data:{"rdID":rdID,
			"bkID":bkID,
			"operatorLend":operatorLend

		},
		
		success:function(Info){
			//将信息显示出来
			if(Info=="1"){
				alert("超过最大借书数量");
			
			}else{
				
				queryReaderInfo();
				alert("操作成功");
			}
		},
		
		error:function(){
			alert("操作失败");
		}
	
	})
	
}

function lendBook(bkID,rdID,operatorLend){
	
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/Libarary/servlet/LendBook",
		data:{"rdID":rdID,
			"bkID":bkID,
			"operatorLend":operatorLend

		},
		
		success:function(Info){
			//将信息显示出来
			if(Info=="1"){
				alert("书不在馆");
			
			}else{
			
				queryReaderInfo();
				alert("操作成功");
			}
			
		},
		
		error:function(){
			alert("操作失败");
		}
	
	})
}

function returnBook(bkID,rdID,operatorRet){
	
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/Libarary/servlet/ReturnBook",
		data:{"rdID":rdID,
			"bkID":bkID,
			"operatorRet":operatorRet,

		},
		
		success:function(Info){
			//将信息显示出来
			if(Info=="1"){
				location.reload();
				alert("还书失败");
			
			}else{
			
				queryReaderInfo();
				alert("操作成功");
			}
		},
		
		error:function(){
			alert("操作失败");
		}
	
	})
}


function bookQuery(){
	var bkID = document.getElementById("bkID").value;
	var bkName =document.getElementById("bkName").value;
	var rdID = document.getElementById("rdID").value;
	
	if(rdID ==null || rdID ==""){
		alert("请输入查询ID");
		return;
	}
	
	window.location.href = "http://localhost:8080/Libarary/servlet/BorrowReaderInfo?bkID="+bkID+"&bkName="+bkName+"&level=1";
	
	
}