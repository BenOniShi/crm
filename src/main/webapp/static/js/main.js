//打开一个选项卡 text 选项卡的标题  url
function openTab(text, url, iconCls){
    if($("#tabs").tabs("exists",text)){   //判断选项卡的标题有没有  有的话选中
        $("#tabs").tabs("select",text);
    }else{
        //iframe 嵌套了一个网页   url controller 转发的html
        var content="<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='" + url + "'></iframe>";
        $("#tabs").tabs("add",{
            title:text,
            iconCls:iconCls,
            closable:true,
            //content   内容
            content:content
        });
    }
}



function logout() {
    //弹出一个警告框     r是确认触发的函数   function（r）
    $.messager.confirm("来自crm","确定退出系统?",function (r) {
       if(r){
           //发送一个ajax请求
           $.ajax({
               type:"post",
               url:ctx+"/user/exit",
               dataType:"json",
               success:function (data) {
                   //如果返回的code==200
                   if(data.code==200){
                       //弹出框
                       $.messager.alert("来自crm","系统将在2秒钟退出...");
                       //定时执行
                       setTimeout(function () {
                           //清除cookie
                           $.removeCookie("idStr");
                           $.removeCookie("uname");
                           $.removeCookie("tname");
                           window.location.href=ctx+"/openPasswordModifyDialogindex";
                       },2000);

                   }
               }
           })
       }
    });
}


function openPasswordModifyDialog() {
    $("#dlg").dialog("open").dialog("setTitle","密码修改");
}


function modifyPassword() {
    $("#fm").form("submit",{
        url:ctx+"/user/updatePassword",
        onSubmit:function () {
            return $("#fm").form("validate");
        },
        success:function (data) {
            data = JSON.parse(data);
            if(data.code==200){
                $.messager.alert("来自crm","密码修改成功,2秒后自动退出!","info");
                setTimeout(function () {
                    $.removeCookie("idStr");
                    $.removeCookie("uname");
                    $.removeCookie("tname");
                    window.location.href=ctx+"/index";
                },2000);
            }else{
                $.messager.alert("来自crm",data.msg,"error");
            }
        }
    })
}

