/**
 * 打开对话框
 *
 * @param diadlgid
 * @param title
 */

function openDialog(diadlgid,title){
    $("#"+diadlgid).dialog("open").dialog("setTitle",title);
}
function closeDialog(diadlgid) {
    $("#"+diadlgid).dialog("close");
}

/**
 * 保存或者修改的封装
 * 1.   获取隐藏域中的值
 * 2.   判断id是否为空   空为添加    非空为修改
 * 3.   表单的提交事件   设置url   表单的onSubmit  返回校验结果
 * 4.   判断结果集  将json格式的数据转换成js对象  判断返回结果中的code的值
 *                                              如果值为200
 *                                              更新成功  走刷新方法
 *                                              如果值不等于200
 *                                              更新失败  提示用户
 * @param fmid
 * @param saveurl
 * @param updateurl
 * @param dlgid
 * @param searchCustomersByParams
 */
function saveOrUpdate(fmid,saveurl,updateurl,dlgid,serch) {
    var  id = $("input[name='id']").val();
    console.log(id)
    var  url = updateurl;
    if (isEmpty(id)){
        url=saveurl;
    }
    console.log(url)
    $("#"+fmid).form("submit",{
        url:url,
        onSubmit:function () {
            return $("#"+fmid).form("validate")
        },
        success:function (data) {
          data= JSON.parse(data);
          if (data.code==200){
              $.messager.alert("来自crm","更新成功","info")
              closeDialog(dlgid)
              serch();
          } else {
              $.messager.alert("来自crm",data.msg,"info")
          }
        }
    })
}

/**
 * 删除数据的封装方法
 * 1. 获取选重的网格数据
 * 2. 判断数据的数量
 * 3. 消息框事件   function  r
 * 4. 如果触发了r
 *          ajax提交
 *              type
 *              url
 *              data
 *              datatype
 *              success：function（data）{
 *                  判断data结果做出响应
 *              }
 * @param diadlgid
 * @param deleteurl
 * @param searchCustomersByParams
 */
function deleteRecode(diadlgid,deleteurl,searchCustomersByParams) {
    var rows=$("#"+diadlgid).datagrid("getSelections")
    if (rows.length==0){
        $.messager.alert("来自crm","请选择至少一条数据","info")
        return;
    }
    if (rows.length>1){
        $.messager.alert("来自crm","暂不支持批量删除","info")
        return;
    }
    $.messager.confirm("来自crm","确定删除选中的数据？",function (r) {
        if (r){
            $.ajax({
                type:'post',
                url:deleteurl,
                data:{
                    id:rows[0].id
                },
                datatype:'json',
                success:function (data) {
                    if (data.code==200){
                        $.messager.alert("来自crm","删除成功",'info')
                        searchCustomersByParams()
                    } else {
                        $.messager.alert("来自crm",data.msg,"info")
                    }
                }
            })
        }
    })
}
