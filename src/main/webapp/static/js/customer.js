function formatterState(val) {
    if (val == 0) {
        return "未流失"
    } else {
        return "流失"
    }
}

function searchCustomersByParams() {
    $("#dg").datagrid("load", {
        name: $("#name").val(),
        khno: $("#khno").val(),
        level: $("#level").combobox("getValue")
    })
}

//事件
function openCustomerAddDialog() {
    openDialog("dlg", "添加客户");
}

function closeCustomerDialog() {
    closeDialog("dlg");
}
//保存方法   参数  表单的id     url路径       对话框的id      对话框的刷新方法
function saveOrUpdateCustomer() {
    saveOrUpdate("fm", ctx + "/customer/save", ctx + "/customer/update", "dlg", searchCustomersByParams);
}


$(function () {
    $("#dlg").dialog({
        onClose: function () {
            $("#fm").form("clear")
        }
    })
})


function openCustomerModifyDialog() {
    var rows = $("#dg").datagrid("getSelections");
    if (rows.length == 0) {
        $.messager.alert("来自crm", "请选择修改的记录!", "info");
        return;
    }
    if (rows.length > 1) {
        $.messager.alert("来自crm", "暂不支持批量修改!", "info");
        return;
    }

    $("#fm").form("load", rows[0]);

    openDialog("dlg", "修改客户信息");
}


function deleteCustomer() {
    deleteRecode("dg", ctx+"/customer/delete", searchCustomersByParams);
}

/**
 * 订单记录
 * 1.查询当前客户下的订单记录
 */
function openOderTab() {
    var rows = $("#dg").datagrid("getSelections")
    //参数校验
    if (rows.length==0){
        $.messager.alert("来自crm","请选择要查看的订单","Info")
        return;
    }
    if (rows.length>1){
        $.messager.alert("来自crm","不支持多条查看","Info")
        return;
    }
    //打开一个新的视图   order / index
    window.parent.openTab("客户订单查询",ctx+"/order/index?cid="+rows[0].id,null)
}