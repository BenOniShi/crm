function searchStatedSaleChance() {
    $("#dg").datagrid("load", {
        customerName: $("#s_customerName").val(),
        createMan: $("#s_createMan").val()
    })
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

function formatterOp(val,rows) {
    if (rows.devResult==0||rows.devResult==1){
        var href="javascript:openCusDevPlanTab('执行开发"+rows.id+"',"+rows.id+")";
        return "<a href="+href+" >开发</a>";
    }else {
        var href="javascript:openCusDevPlanTab('查看详情"+rows.id+"',"+rows.id+")";
        return "<a href="+href+">查看详情</a>";
    }
}
function openCusDevPlanTab(title,sid) {
    console.log(sid)
    window.parent.openTab(title,ctx+"/saleChance/querySaleChanceBySid?sid="+sid,null)
}