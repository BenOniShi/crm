<html>
<head>
    <#include "common.ftl" >
    <script type="text/javascript" src="${ctx}/static/jquery-easyui-1.3.3/jquery.edatagrid.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/base.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/customer.loss.repr.js"></script>
</head>
<body >


<div id="p" class="easyui-panel" title="客户流失详情" style="width: 700px;height: 300px;padding: 10px">
    <table cellspacing="8px">
        <input type="hidden" id="lossId"  value="${customerLoss.id}"/>
        <tr>
            <td>客户编号：</td>
            <td><input type="text" id="cusNo"  readonly="readonly" value="${(customerLoss.cusNo)!""}" /></td>
            <td>    </td>
            <td>客户名称</td>
            <td><input type="text" id="cusName" readonly="readonly" value="${(customerLoss.cusName)!""}"/></td>
        </tr>
        <tr>
            <td>客户经理：</td>
            <td><input type="text" id="cusManager" eadonly="readonly" value="${(customerLoss.cusManager)!""}"/></td>
            <td>    </td>
            <td>创建时间：</td>
            <td><input type="text"  readonly="readonly" value="${(customerLoss.createDate)?string("yyyy-MM-dd HH:mm:ss")}"/></td>
        </tr>
        <tr>
            <td>更新时间：</td>
            <td><input type="text"readonly="readonly" value="${(customerLoss.updateDate)?string("yyyy-MM-dd HH:mm:ss")}"/></td>
            <td colspan="3">    </td>
        </tr>



        <#if customerLoss.lastOrderTime??>
            <tr>
                <td>最后下单时间：</td>
                <td><input type="text" readonly="readonly"
                           value="${customerLoss.lastOrderTime?string("yyyy-MM-dd HH:mm:ss")}" /></td>
            </tr>
        </#if>
        <#if customerLoss.state==1 >
            <tr>
                <td>流失原因：</td>
                <td><input type="text" readonly="readonly"  value="${(customerLoss.lossReason)!""}" /></td>
                <td>    </td>
                <td>确认流失时间：</td>
                <td>
                    <input type="text" readonly="readonly"
                           value="${(customerLoss.confirmLossTime)?string("yyyy-MM-dd HH:mm:ss")}" />
                </td>
            </tr>
        </#if>

    </table>
</div>


<br/>

<#--开发计划详情记录-->
<table id="dg"  title="暂缓措施" style="width:700px;height:250px"
       toolbar="#toolbar" idField="id"
       pagination="true" rownumbers="true" singleSelect="true" fitColumns="true" >
    <thead>
    <tr>
        <th field="id"  name="id" width="50">编号</th>
        <#if customerLoss.state==0>
            <th field="measure" width="100" editor="{type:'validatebox',options:{required:true}}">暂缓措施</th>
        <#else>
            <th field="measure" width="100" >暂缓措施</th>
        </#if>
        <th field="createDate" width="100" >创建时间</th>
        <th field="updateDate" width="100">更新时间</th>
    </tr>
    </thead>
</table>


<#if customerLoss.state==0>
    <div id="toolbar">
        <a href="javascript:$('#dg').edatagrid('addRow')" class="easyui-linkbutton" iconCls="icon-add" plain="true" >添加暂缓措施</a>
        <#-- <a href="javascript:$('#dg').edatagrid('destroyRow')" class="easyui-linkbutton" iconCls="icon-remove" plain="true" >删除暂缓措施</a>-->
        <a href="javascript:delCustomerRepr()" class="easyui-linkbutton" iconCls="icon-remove" plain="true" >删除暂缓措施</a>
        <a href="javascript:saveCustomerRepr()" class="easyui-linkbutton" iconCls="icon-save" plain="true" >保存暂缓</a>
        <a href="javascript:$('#dg').edatagrid('cancelRow')" class="easyui-linkbutton" iconCls="icon-undo" plain="true" >撤销行</a>
        <a href="javascript:updateCustomerLossState()" class="easyui-linkbutton" iconCls="icon-kfcg" plain="true" >确认流失</a>
    </div>
</#if>



</body>
</html>
