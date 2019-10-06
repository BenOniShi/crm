//formatter 函数     判断val    去返回对应的格式化数据
// rowStyler 函数    返回样式


function fomratterState(val, rowData, rowIndex) {
    console.log(val, rowData, rowIndex)
    if (val == 0) {
        return "未分配";
    } else if (val == 1) {
        return "已分配";
    } else {
        return "未知";
    }
}

function formatterDevResult(val) {
    if (val == 0) {
        return "未开发";
    } else if (val == 1) {
        return "开发中";
    } else if (val == 2) {
        return "开发成功";
    } else if (val == 3) {
        return "开发失败";
    } else {
        return "未知";
    }
}


function changeColor(val) {
    if (val == 2) {
        return "color: green"
    } else if (val == 3) {
        return "color: red"
    } else if (val == 0) {
        return "color: blue"
    } else if (val == 1) {
        return "color: yellow"
    }
}

//获取input标签的值 作为queryparam参数是  替换parame的值  url是  datagrid 定义的 url 传递到后台 进行多条件查询
function searchSaleChance() {
    //
    $("#dg").datagrid("load", {
        customerName: $("#s_customerName").val(),
        createMan: $("#s_createMan").val(),
        state: $("#s_state").combobox("getValue")
    })
}


function openSaleChanceAddDialog() {
    $("#dlg").dialog("open").dialog("setTiile", "添加机会数据");

}


function closeSaleChanceDialog() {
    $("#dlg").dialog("close");
}

//监听事件
$(function () {
    $("#dlg").dialog({
        //如果关闭事件触发
        onClose: function () {
            //清空表单数据
            $("#fm").form("clear")
        }
    })
})


//表单的保存方法
function saveOrUpdateSaleChance() {
    //提交事件
    var id = $("input[name='id']").val()
    var url = ctx + "/saleChance/update";
    if (isEmpty(id)) {
        url = ctx + "/saleChance/save"
    }
    $("#fm").form("submit", {
        url: url,
        //提交事件
        onSubmit: function () {
            return $("#fm").form("validate");
        },
        success: function (data) {
            //将结果集转换成json
            data = JSON.parse(data)
            //如果==200
            if (data.code == 200) {
                //提示框
                $.messager.alert("来自crm", "营销机会数据更新成功", "info")
                //关闭对话框
                closeSaleChanceDialog();
                //刷新
                searchSaleChance();
            } else {
                //如果code！=200  弹出消息提示框
                $.messager.alert("来自crm", data.msg, "info")
            }
        }
    })
}

function openSaleChanceModifyDialog() {

    var rows = $("#dg").datagrid("getSelections")
    if (rows.length == 0) {
        $.messager.alert("来自crm", "请选择一条有效数据", "info")
        return;
    }
    if (rows.length > 1) {
        $.messager.alert("来自crm", "暂不支持批量修改!", "info");
        return;
    }
    $("#fm").form("load", rows[0])
    openDialog("dlg", "营销机会数据修改")

}


function deleteSaleChance() {
    var rows = $("#dg").datagrid("getSelections")
    if (rows.length == 0) {
        $.messager.alert("来自crm", "请选择一条有效数据", "info")
        return;
    }
    if (rows.length > 1) {
        $.messager.alert("来自crm", "暂不支持批量修改!", "info");
        return;
    }
    $.messager.confirm("来自crm","确定要删除这条数据吗",function (r) {
        if (r){
            $.ajax({
                type:'post',
                url:ctx+"/saleChance/delete",
                data:{
                    id:rows[0].id
                },
                datatype:"json",
                success:function (data) {
                    if (data.code==200){
                        $.messager.alert("来自crm","删除成功","info")
                        searchSaleChance();
                    } else {
                        $.messager.alert("来自crm",data.msg,"info")
                    }
                }
            })
        }
    })
}


function updateSaleChanceDevResult(result) {
    var sid= $("#saleChanceId").val();
    $.messager.confirm("来子crm","请确认您的操作",function (r) {
        if (r){
            $.ajax({
                type:"post",
                url:ctx+"/saleChance/updateSaleChanceResult",
                data:{
                    sid:sid,
                    result:result
                },
                datatype:'json',
                success:function (data) {
                    if (data.code==200){
                        $.messager.alert("来自crm","操作成功","info")
                        searchSaleChance();
                    } else {
                        $.messager.alert("来自crm",data.msg,"info")
                    }
                }
            })
        }
    })
}