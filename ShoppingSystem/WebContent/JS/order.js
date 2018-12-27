

//点击模态框的提交
function submitPay(orderId) {
    $.ajax({
        url:"OrderServlet?method=payOrder",
        type:"POST",
        data:{
            "orderId":orderId
        },
        success:function (data) {
            Toast('购买成功',1000);
            //window.location.href("OrderServlet?method=getAllOrder");
            location.reload();
            
        },
        error:function (data) {
            alert('false');
        }
    });
}

//删除订单
function deleteOrder(orderId) {
    $.ajax({
        url:"OrderServlet?method=deleteOrder",
        type:"POST",
        data:{
            "orderId":orderId
        },
        success:function (data) {
            Toast('删除成功',1000);
            //window.location.href("OrderServlet?method=getAllOrder");
            location.reload();
            
        },
        error:function (data) {
            alert('false');
        }
    });
}
