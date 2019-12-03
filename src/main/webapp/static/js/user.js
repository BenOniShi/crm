
function searchUsersByParams() {
    $("#dg").datagrid("load",{
        userName:$("#userName").val(),
        phone:$("#phone").val(),
        mail:$("#mail").val()
    })
}

function openUserAddDialog() {
    $("#dlg").dialog("open").dialog("setTitle","用户添加");
}

function closeUserDialog() {
    $("#dlg").dialog("close");
}

function saveOrUpdateUser() {

    //获取表单中的设在隐藏域中的id值
    var id=$("#userid").val();
    //默认是保存
    var url=ctx+"/user/save";
    //如果id不为空
    if(!(isEmpty(id))){
        //url为更新
        url=ctx+"/user/update";
    }
    //表单提交方法
    $("#fm").form("submit",{
        url:url,
        //表单参数校验的回调
        onSubmit:function () {
            return $("#fm").form("validate");
        },
        //结果
        success:function (data) {
            //将data装换成可以操作的dom对象
            // data =JSON.parse(data);
            if(data.code==200){
                closeUserDialog();
                searchUsersByParams();
            }else{
                $.messager.alert("来自crm",data.msg,"info");
            }
        }
    })
}

//用户删除
function deleteUser() {
    var rows=$("#dg").datagrid("getSelections")
    if (rows.length==0){
        $.messager.alert("来自crm","请选择一条有效数据","info")
        return;
    }
    if(rows.length>1){
        $.messager.alert("来自crm","暂不支持批量删除!","info");
        return;
    }
    $.messager.confirm("来自crm","确定删除选中的记录?",function (r) {
        if(r){
            $.ajax({
                type:"post",
                url:ctx+"/user/delete",
                data:{
                    id:rows[0].id
                },
                dataType:"json",
                success:function (data) {
                    if(data.code==200){
                        searchUsersByParams();
                    }else{
                        $.messager.alert("来自crm",data.msg,"info");
                    }
                }
            })
        }
    });
}


//监听事件
$(function () {
    $("#dlg").dialog({
        //如果关闭事件触发
        onClose:function () {
            //清空表单数据
            $("#fm").form("clear")
        }
    })
})



//修改
function openUserModifyDialog() {
    var rows=$("#dg").datagrid("getSelections")
    console.log(rows)
    if (rows.length==0){
        $.messager.alert("来自crm","请选择一条有效数据","info")
        return;
    }
    if(rows.length>1){
        $.messager.alert("来自crm","暂不支持批量修改!","info");
        return;
    }

    //表单填充方法      将获取到的 dg中的id 填充到表单中
    $("#fm").form("load",rows[0])
    //打开对话框
    $("#dlg").dialog("open").dialog("setTitle","用户更新");

}