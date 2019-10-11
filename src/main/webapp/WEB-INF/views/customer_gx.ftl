<html>
<head>
    <#include "common.ftl" >
    <script type="text/javascript" src="${ctx}/static/js/common.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/base.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/customer.gx.js"></script>



</head>
<body style="margin: 1px">
<table id="dg"  class="easyui-datagrid"
       fitColumns="true" pagination="true" rownumbers="true"
       url="${ctx}/customer/customerNameAndSum" fit="true" toolbar="#tb">
    <thead>
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="cusName" width="50" align="center">客户名称</th>
        <th field="cusSum" width="50" align="center">总金额</th>
    </tr>
    </thead>
</table>
<div id="tb">
    <div>
        客户名称： <input type="text" id="cusName" size="20" onkeydown="if(event.keyCode==13) searchCustomerLossByParams()"/>
        <a href="javascript:searchCusSumByParams()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
    </div>
</div>




</body>
</html>
