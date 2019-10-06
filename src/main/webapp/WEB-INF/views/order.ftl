<html>
<head>
    <#include "common.ftl" >
    <script type="text/javascript" src="${ctx}/static/js/common.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/base.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/order.js"></script>


</head>
<body style="margin: 1px">
<table id="dg"  class="easyui-datagrid"
       fitColumns="true" pagination="true" rownumbers="true"
       url="${ctx}/order/list?cid=${cid}" fit="true" toolbar="#tb" singleSelect="true">
    <thead>
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="id" width="50" align="center">编号</th>
        <th field="orderNo" width="200" align="center" >订单号</th>
        <th field="orderDate" width="100" align="center">下单日期</th>
        <th field="address" width="100" align="center">收货地址</th>
        <th field="state" width="100" align="center"  formatter="formatterState">支付状态</th>
        <th field="createDate" width="100" align="center">创建时间</th>
        <th field="updateDate" width="100" align="center">更新时间</th>
        <th field="as" width="100" align="center" formatter="formatterOp">操作</th>
    </tr>
    </thead>
</table>



<div id="tb">

    <div>
        订单编号： <input type="text" id="orderNo" size="20" onkeydown="if(event.keyCode==13) searchOrdersByParams()"/>
        <a href="javascript:searchOrdersByParams()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
    </div>
</div>




<div id="goods" class="easyui-dialog" style="width:800px;height:500px;padding: 10px 20px" closed="true">

    <div class="easyui-panel"  style="height: 100px">
        <form id="orderInfo">
            <table cellspacing="8px">
                <tr>
                    <td>订单编号：</td>
                    <td><input name="orderNo" type="text"/></td>
                    <td>    </td>
                    <td>下单日期:</td>
                    <td><input name="date" type="text" /></td>
                </tr>
                <tr>
                    <td>总金额(￥)：</td>
                    <td><input name="total" type="text"/></td>
                    <td>    </td>
                    <td>支付状态:</td>
                    <td><input name="state" type="text" formatter="formatterState"/></td>
                </tr>
            </table>
        </form>


    </div>

    <br/>


    <table id="orderDetail"  class="easyui-datagrid"
           fitColumns="true" pagination="true" rownumbers="true"
           singleSelect="true" style="height: 300px;">
        <thead>
        <tr>
            <th field="id" width="50" align="center">编号</th>
            <th field="goodsName" width="100" align="center">商品名称</th>
            <th field="goodsNum" width="100" align="center">商品数量</th>
            <th field="unit" width="100" align="center" >单位</th>
            <th field="price" width="100" align="center"  >单价</th>
            <th field="sum" width="100" align="center" >总金额</th>
            <th field="createDate" width="100" align="center">创建时间</th>
            <th field="updateDate" width="100" align="center">更新时间</th>
        </tr>
        </thead>
    </table>

</div>


</body>
</html>
