function login() {
    var  userName=$("input[name='username']").val();
    var userPwd=$("input[name='password']").val();
    if(isEmpty(userName)){
        alert("请输入用户名!");
        return;
    }

    if(isEmpty(userPwd)){
        alert("请输入密码!");
        return;
    }

    $.ajax({
        type:"post",
        url:ctx+"/user/login",
        data:{
            userName:userName,
            userPwd:userPwd
        },
        dataType:"json",
        success:function (data) {
            if(data.code==200){
                //设置cookie       $.cookie(key,value)      需要引入 jquery.cookie包
                $.cookie("idStr",data.result.idStr);
                $.cookie("uname",data.result.userName);
                $.cookie("tname",data.result.trueName);
                window.location.href=ctx+"/main";
            }else{
                alert(data.msg);
            }
        }
    })
}




