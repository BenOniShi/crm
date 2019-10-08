function formatterState(val) {
    if (val == 0) {
        return "暂缓流失"
    }
    if (val == 1) {
        return "已流失"
    }
}

function formatterOp(val,row) {

    if (row.state == 0) {
        var href = "javascript:openCustomerLossReprTab('添加暂缓" + row.id + "'," + row.id + ")"
        return "<a href=" + href + ">添加暂缓</a>"
    }
    if (row.state == 1) {
        var href = "javascript:openCustomerLossReprTab('查看详情" + row.id + "'," + row.id + ")"
        return "<a href=" + href + ">查看详情</a>"
    }
}


function searchCustomerLossByParams() {
    $("#dg").datagrid("load", {
        cusNo: $("#cusNo").val(),
        cusName: $("#cusName").val(),
        state: $("#state").combobox("getValue")

    })
}


function openCustomerLossReprTab(text,lossId) {
    window.parent.openTab(text,ctx+"/customerLoss/queryCustomerLossByLossId?id="+lossId,null);
}