function searchRolesByParams() {
    $("#dg").datagrid("load",{
        roleName:$("#roleName").val()
    })
}


function openRoleAddDialog () {
    openDialog("dlg","添加角色")
    $("#fm").form("clear")

}
function saveOrUpdateRole() {
    saveOrUpdate("fm",ctx+"/role/save",ctx+"/role/update","dlg",searchRolesByParams)
}

function openRoleModifyDialog() {
    openDialog("dlg","修改角色")
    var rows = $("#dg").datagrid("getSelections")
    $("#fm").form("load",rows[0])
}
function closeRoleDialog() {
    closeDialog("dlg")
}

/**
 * 删除
 */
function deleteRole() {
    var rows=$("#dg").datagrid("getSelections")
    if (rows.length==0){
        $.messager.alert("来自crm","请选择一条有效数据","info")
        return;
    }
    if(rows.length>1){
        $.messager.alert("来自crm","暂不支持批量删除!","info");
        return;
    }
    $.messager.confirm("来自crm","确定删除选中的数据",function (r) {
        if (r){
            $.ajax({
                type:'post',
                url:ctx+"/role/delete",
                data:{
                    id:rows[0].id
                },
                datatype:'json',
                success:function (data) {
                    if (data.code==200){
                        $.messager.alert("来自crm","删除成功","info")
                        searchRolesByParams();
                    } else {
                        $.messager.alert("来自crm",data.msg,"info")
                        searchRolesByParams();
                    }
                }
            })
        }
    })
}