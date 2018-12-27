
function deleteGoods(goodsid){
	$.ajax({
        url:"ShopCartServlet?method=deleteGoods",
        type:"POST",
        data:{
            "goodsId":goodsid,
        },
        success:function (data) {
        	location.reload(true);
        	//Toast('删除成功',500);
        },
        error:function (data) {

        }
    })
}


//点击减号-
function decGoodsNum(goodsId,subtotalID,goodsprice){
	var inputDom=document.getElementById(goodsId);//input的id和goodsId一样
	var subtotalid=document.getElementById(subtotalID);//获得“小计”id
	
	var goodsQty=parseInt(inputDom.value);//获取input中显示的数字
	
	goodsQty=goodsQty-1;
	var subtotalPrice=goodsQty*goodsprice;//小计总费用
	if(goodsQty<1){
		Toast('商品数量最少为1',1000);
	}else{
		
		$.ajax({
			url:"ShopCartServlet?method=alterGoodsNumber",
	        type:"POST",
	        data:{
	            "goodsId":goodsId,
	            "goodsQty":goodsQty
	        },
	        success:function (data) {
	        	Toast('修改成功',500);
	        	inputDom.value=goodsQty;
	        	subtotalid.innerHTML=subtotalPrice;
	        },
	        error:function (data) {

	        }
	    })
		
	}
	
}

//点击加号+
function addGoodsNum(goodsId,subtotalID,goodsprice){
	var inputDom=document.getElementById(goodsId);//input的id和goodsId一样
	var subtotalid=document.getElementById(subtotalID);//获得“小计”id
	
	console.log(goodsId);
	console.log(subtotalID);
	console.log(goodsprice);
	var goodsQty=parseInt(inputDom.value);//获取input中显示的数字
	console.log(goodsQty);
	goodsQty=goodsQty+1;
	var subtotalPrice=goodsQty*goodsprice;//小计总费用
	$.ajax({
		url:"ShopCartServlet?method=alterGoodsNumber",
        type:"POST",
        data:{
            "goodsId":goodsId,
            "goodsQty":goodsQty
        },
        success:function (data) {
        	if(data==-1){
        		Toast('店家没有那么多货',1000);
        	}else{
        		Toast('修改成功',500);
            	inputDom.value=goodsQty;
            	subtotalid.innerHTML=subtotalPrice;
        	}
        	
        },
        error:function (data) {
        	
        }
    })
}

//直接修改数量
function changeGoodsNum(value,goodsId,subtotalID,goodsprice){
	
	var subtotalid=document.getElementById(subtotalID);//获得“小计”id
	if(value>0){
		if (window.XMLHttpRequest)
		  {// code for IE7+, Firefox, Chrome, Opera, Safari
		  xmlhttp=new XMLHttpRequest();
		  }
		else
		  {// code for IE6, IE5
			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		  }
		xmlhttp.onreadystatechange=function()
		  {
		  if (xmlhttp.readyState==4 && xmlhttp.status==200)
		    {
			  var result=parseInt(this.responseText);
			  
			  if(result!=-1){
				  subtotalid.innerHTML=value*goodsprice;
				  
				  Toast('修改成功',500);
			  }else{
				  Toast('没有那么多货了',1000);
			  }
			  //totalpriceID.innerHTML=xmlhttp.responseText;
			  
		    }
		  }
//		get方式
//		xmlhttp.open("GET","/ajax/getcustomer.asp?q="+str,true);
//		xmlhttp.send();
		xmlhttp.open("POST","ShopCartServlet?method=alterGoodsNumber",true);
		//以表单的形式提交
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		//要post的数据
		xmlhttp.send("goodsQty="+value+"&goodsId="+goodsId);
	}else{
		Toast('商品数量最少为1',1000);
	}
}


//让div滚动到顶部就固定
function scrollDiv  () {
    var ie6 = document.all;
    var dv = $('.table_header'), st;
    var bv = $('.table_bottom');
	var viewHeight=$(window).outerHeight();
    dv.attr('otop', dv.offset().top); //键值对存储table_header原来的距离顶部的距离
    bv.attr('obottom', bv.offset().top+$(".table_bottom").height()); //键值对存储table_bottom底部到文档顶部距离
	//如果一开始table_bottom距文档顶部的距离>窗口可使区域的宽，就让table_bottom固定在底部
	if(bv.attr('obottom')>$(window).height()){
        if (bv.css('position') != 'fixed') {
            bv.css({ 'position': 'fixed', bottom: 0 ,right:0,left:0});
        }
	}
	//滚动条监听事件
    $(window).scroll(function () {
        //滚动条卷去的高度（超出窗口上面的部分的高度）
        st = Math.max(document.body.scrollTop || document.documentElement.scrollTop);
        if (st+30 > parseInt(dv.attr('otop'))) {
            if (ie6) {//IE6不支持fixed属性，所以只能靠设置position为absolute和top实现此效果
                dv.css({ position: 'absolute', top: st });
            }
            else if (dv.css('position') != 'fixed') {
                dv.css({ 'position': 'fixed', top: 30 ,right:0,left:0});
                // alert(234);
            }
        } else if (dv.css('position') != 'static'){
            dv.css({ 'position': 'static'});
		}

		//table_bottom底部到文档顶部距离-（窗口可视区域高+滚动条卷去的高度）
		if(bv.attr('obottom')-($(window).height()+st)<0){
		    if(bv.css('position') != 'static')
                bv.css({ 'position': 'static'});
		}else {
            if(bv.css('position') != 'fixed')
                bv.css({ 'position': 'fixed', bottom: 0 ,right:0,left:0});
        }
    });

}

$(document).ready(function(){
    scrollDiv();//滚动条滚动时div时而固定
    
    
    
    
    
    var sumPrice=0;//订单总金额
    var hasChooseNumId=document.getElementById("hasChooseNumId");//选中几条的span
    var hasChooseNum=0;
    
    //复选框监听事件
    $('input[name="check"]').click(function(){
    	var sumPriceId=document.getElementById("sumPriceId");//应付总价的span
    	if($(this).is(':checked')){
    		var goodsId=$(this).val();//获取goodsId,为了方便获得小计id
    		var subtotalid=document.getElementById("price"+goodsId);//获得“小计”id
    		var subtotalprice=parseInt(subtotalid.innerHTML);//小计费用
//    		var addgoodsId=document.getElementById("add"+goodsId);//a标签加号
//    		var subtotalprice=parseInt(subtotalid.innerHTML);//小计费用
//    		
//    		subgoodsId.attr('disabled',"true");//添加disabled属性 (禁用a标签减号)
//    		addgoodsId.attr('disabled',"true");
    		
    		sumPrice+=subtotalprice;
    		sumPriceId.innerHTML=sumPrice;//让总价数字改变为现在的值
    		hasChooseNum++;
    		hasChooseNumId.innerHTML=hasChooseNum;
    		
    	}else{
    		var goodsId=$(this).val();
    		var subtotalid=document.getElementById("price"+goodsId);//获得“小计”id
    		var subtotalprice=parseInt(subtotalid.innerHTML);//小计费用
//    		var subgoodsId=document.getElementById("sub"+goodsId);//a标签减号
//    		var addgoodsId=document.getElementById("add"+goodsId);//a标签加号
//    		
//    		subgoodsId.removeAttr("disabled"); //移除disabled属性
//    		addgoodsId.removeAttr("disabled"); //移除disabled属性
    		sumPrice-=subtotalprice;
    		hasChooseNum--;
    		if(sumPrice<0){
    			alert("商品总价出错")
    		}
    		sumPriceId.innerHTML=sumPrice;
    		hasChooseNumId.innerHTML=hasChooseNum;
    	}
    });
    
//    $('#button').attr('disabled',"true");添加disabled属性 
//    $('#button').removeAttr("disabled"); 移除disabled属性
  //复选框全选/全不选
    $("#chooseAll").click(function(){
        if($(this).is(':checked')){
        	sumPrice=0;//将总价先清0，防止之前选过复选框给sumPrice赋了值
            $('input[name="check"]').each(function(){
                //此处如果用attr，会出现第三次失效的情况
                $(this).prop("checked",true);
                var goodsId=$(this).val();
        		var subtotalid=document.getElementById("price"+goodsId);//获得“小计”id
        		var subtotalprice=parseInt(subtotalid.innerHTML);//小计费用
//        		var subgoodsId=document.getElementById("sub"+goodsId);//a标签减号
//        		var addgoodsId=document.getElementById("add"+goodsId);//a标签加号
//        		
//        		subgoodsId.attr('disabled',"true");//添加disabled属性 (禁用a标签减号)
//        		addgoodsId.attr('disabled',"true");
        		
        		sumPrice+=subtotalprice;
        		sumPriceId.innerHTML=sumPrice;
        		hasChooseNum++;
                
            });
            hasChooseNumId.innerHTML=hasChooseNum;
        }else {
            $('input[name="check"]').each(function(){
                //此处如果用attr，会出现第三次失效的情况
                $(this).prop("checked",false);
                var goodsId=$(this).val();
        		var subtotalid=document.getElementById("price"+goodsId);//获得“小计”id
        		var subtotalprice=parseInt(subtotalid.innerHTML);//小计费用
//        		var subgoodsId=document.getElementById("sub"+goodsId);//a标签减号
//        		var addgoodsId=document.getElementById("add"+goodsId);//a标签加号
//        		
//        		subgoodsId.removeAttr("disabled"); //移除disabled属性
//        		addgoodsId.removeAttr("disabled"); //移除disabled属性
        		
        		sumPrice=0;
        		hasChooseNum=0;
        		hasChooseNumId.innerHTML=hasChooseNum;
        		if(sumPrice<0){
        			alert("商品总价出错")
        		}
        		sumPriceId.innerHTML=sumPrice;
            });
        }
    });

    //点击结算。获取复选框中的值
    $(".btn_price").click(function(){
    	var userId=document.getElementsByClassName(".user_name");
    	var userInfoIsComplete=false;
    	//判断用户基本信息是否完整
    	$.ajax({
    		url:"UserServlet?method=judgeBaseInfo",
            type:"POST",
            data:{
                
            },
            success:function (data) {
            	if(data==0){
            		Toast('请先完善基本信息',1000);
            		userInfoIsComplete=false;
            	}else{
            		userInfoIsComplete=true;
            		$.each(goodsIdList,function(n,value) {  
                		var inputDom=document.getElementById(value);//input的id和goodsId一样
                		var subtotalid=document.getElementById("price"+value);//获得“小计”id
                		var goodsQty=parseInt(inputDom.value);//获取input中显示的数字
                		var subtotalprice=parseInt(subtotalid.innerHTML);//小计费用
         
                		sumPrice+=subtotalprice;
                		goodsQtyList.push(goodsQty);
                     });  
                	
                	$.ajaxSettings.traditional=true;//ajax接收多个值list时千万不能掉
                	$.ajax({
                		url:"OrderServlet?method=addOrder",
                        type:"POST",
                        data:{
                            "goodsIdList":goodsIdList,
                            "goodsQtyList":goodsQtyList
                        },
                        success:function (data) {
                        	Toast('订单生成成功',500);
                        	window.location.href = "OrderServlet?method=getAllOrder";
                        },
                        error:function (data) {
                        	
                        }
                    })
            	}
            },
            error:function (data) {
            	
            }
        })
    	
    	var sumPriceId=document.getElementById("sumPriceId");//应付总价的span
        var goodsIdList =[],goodsQtyList=[];
        
        $('input[name="check"]:checked').each(function(){
        	goodsIdList.push($(this).val());//在jsp中使得每一个复选框的值都是goodsId
        });
        
        
        if(goodsIdList.length==0 ){
        	Toast('您未选中任何商品',1000);
        }
    });
});

















