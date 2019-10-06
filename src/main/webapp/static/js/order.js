function formatterState(val) {
    if (val == 0){
        return"成功";

    }else {
        return "失败"
    }
}

function formatterOp() {
    var href="javascript:openOrderDetailDialog()";
    return "<a href="+href+">查看订单详情</a>";
}


function searchOrdersByParams() {
    $("#dg").datagrid("load",{
        OrderNo:$("#orderNo").val()
    })
}


function openOrderDetailDialog() {
    //获取选中 的数据
    var  rows=$("#dg").datagrid("getSelections")
    console.log(rows)
    $.ajax({
        type:'post',
        url:ctx+"/order/queryOrderInfoByOrderNo",
        data:{
            orderNo:rows[0].orderNo
        },
        datatype:'json',
        success:function (data) {

            $("#orderInfo").form("load",data)
        }
    });
    //子容器窗口的表格url设置
    $("#orderDetail").datagrid({
        url:ctx+"/orderDetails/list?orderId="+rows[0].id
    })
    //打开一个子容器
    openDialog("goods","订单详情")
}
