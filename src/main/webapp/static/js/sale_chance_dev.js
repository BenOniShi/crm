$(function () {
    $("#dg").edatagrid({
        saveUrl: ctx+"/cusDevPlan/save?saleChanceid="+$("#saleChanceId").val(),
        updateUrl: ctx+"/cusDevPlan/update?saleChanceid="+$("#saleChanceId").val(),
        destroyUrl:ctx+"/cusDevPlan/delete"
    })
});
function saveCusDevPlan() {
    $("#dg").edatagrid("saveRow");
    $("#dg").edatagrid("load")
}


function delCusDevPlan() {
    /**
     * 删除的两种方法  1.使用edatagrid  组件      的  destroyRow 方法
     *                2. ajax
     */
    // $("#dg").edatagrid("destroyRow")
    // $("#dg").edatagrid("load")


    var rows = $("#dg").edatagrid("getSelections");
    if (rows.length>1){
        $.messager.alert("来自crm","暂不支持删除多条数据","info")
        return;
    }
    if (rows.length==0){
        $.messager.alert("来自crm","请选择要删除的数据","info")
        return;
    }
    $.messager.confirm("来自crm","确认删除吗",function (r) {
        if (r){
            $.ajax({
                type:'post',
                url:ctx+"/cusDevPlan/delete",
                data:{
                    id:rows[0].id
                },
                datetype:'json',
                success:function (data) {
                    if (data.code==200){
                        $.messager.alert("来自crm","删除成功","info")
                        $("#dg").edatagrid("load")
                    } else {
                        $.messager.alert("来自crm",data.msg,"info")
                        $("#dg").edatagrid("load")
                    }
                }
            });
        }
    })

}

