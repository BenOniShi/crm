<html>
<head>
    <#include "common.ftl" >
    <script type="text/javascript" src="${ctx}/static/js/common.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/base.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/customer.loss.js"></script>



</head>
<body style="margin: 1px">
<table id="dg"  class="easyui-datagrid"
       fitColumns="true" pagination="true" rownumbers="true"
       url="${ctx}/customerLoss/list" fit="true" toolbar="#tb">
    <thead>
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="id" width="50" align="center">编号</th>
        <th field="cusNo" width="50" align="center">客户编号</th>
        <th field="cusName" width="200" align="center" >客户名称</th>
        <th field="cusManager" width="100" align="center">客户经理</th>
        <th field="lastOrderTime" width="100" align="center">最后下单时间</th>
        <th field="confirmLossTime" width="100" align="center">确认流失时间</th>
        <th field="state" width="100" align="center" formatter="formatterState">流失状态</th>
        <th field="lossReason" width="100" align="center">流失原因</th>
        <th field="createDate" width="100" align="center">创建时间</th>
        <th field="updateDate" width="100" align="center">更新时间</th>
        <th field="abc" width="100" align="center" formatter="formatterOp">操作</th>
    </tr>
    </thead>
</table>

<div id="tb">
    <div>
        客户编号： <input type="text" id="cusNo" size="20" onkeydown="if(event.keyCode==13) searchCustomerLossByParams()"/>
        客户名： <input type="text" id="cusName" size="20" onkeydown="if(event.keyCode==13) searchCustomerLossByParams()"/>
        流失状态：<select id="state" class="easyui-combobox" name="state"  panelHeight="auto">
            <option value="">请选择</option>
            <option value="0">暂缓流失</option>
            <option value="1">确认流失</option>
        </select>
        <a href="javascript:searchCustomerLossByParams()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
    </div>
</div>




</body>
</html>
