$(function () {
    $("#dg").edatagrid({
        url: ctx + "/customerRepr/list?lossId=" + $("#lossId").val(),
        saveUrl: ctx + "/customerRepr/save?lossId=" + $("#lossId").val(),
        destroyUrl: ctx + "/customerRepr/delete"
    })
})

function saveCustomerRepr() {
    $("#dg").edatagrid("saveRow").edatagrid("load")
}

function delCustomerRepr() {
    var rows = $("#dg").edatagrid("getSelections");
    if (rows.length > 1) {
        $.messager.alert("来自crm", "暂不支持删除多条数据", "info")
        return;
    }
    if (rows.length == 0) {
        $.messager.alert("来自crm", "请选择要删除的数据", "info")
        return;
    }
    $.messager.confirm("来自crm", "您确定要删除吗", function (r) {
        if (r) {
            $.ajax({
                type: 'post',
                url: ctx + "/customerRepr/delete",
                data: {
                    id: rows[0].id
                },
                datatype: 'json',
                success: function (data) {
                    if (data.code == 200) {
                        $.messager.alert("来自crm", "删除成功", "info")
                        $("#dg").edatagrid("load");
                    } else {
                        $.messager.alert("来自crm", data.msg, "info")
                    }
                }

            })
        }
    })
}


function updateCustomerLossState() {
    var  lossid=$("#lossId").val();
    $.messager.confirm("来自crm","您确定要流失当前客户吗",function (r) {
        if (r){
            $.messager.prompt("来自crm","请输入流失信息",function (t) {
                $.ajax({
                    type:'post',
                    url:ctx+"/customerLoss/updateCustomerLossByLossId",
                    data:{
                        lossid:lossid,
                        mesg:t
                    },
                    datatype:'json',
                    success:function (data) {
                        if (data.code==200) {
                            $.messager.alert("来自crm","终止成功，请强制刷新整个页面","info")
                            location.reload();
                        }else {
                            $.messager.alert("来自crm",data.msg,"info")
                        }
                    }
                })
            })
        }
    })
}

