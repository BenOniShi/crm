<html>
<head>
    <#include "common.ftl" >
    <script type="text/javascript" src="${ctx}/static/js/common.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/customer.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/base.js"></script>
</head>
<body>
<table id="dg" class="easyui-datagrid"
       pagination="true" rownumbers="true"
       url="${ctx}/customer/list" fit="true"  toolbar="#tb" style="width:700px;height:250px" singleSelect="true">
    <thead frozen="true">
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="id" width="50" align="center">编号</th>
        <th field="name" width="200" align="center">客户名</th>
        <th field="khno" width="100" align="center">客户编号</th>
        <th field="area" width="50" align="center">地区</th>
        <th field="cusManager" width="200" align="center">客户经理</th>
    </tr>
    </thead>
    <thead >
    <tr>
        <th field="myd" width="100" align="center">满意度</th>
        <th field="level" width="100" align="center">客户级别</th>
        <th field="xyd" width="200" align="center">信用度</th>
        <th field="address" width="100" align="center">详细地址</th>
        <th field="postCode" width="150" align="center">邮编</th>
        <th field="phone" width="200" align="center">电话</th>
        <th field="web_site" width="200" align="center">网站</th>
        <th field="fax" width="100" align="center" >传真</th>
        <th field="fr" width="150" align="center">法人</th>
        <th field="yyzzzch" width="200" align="center">营业执照</th>
        <th field="khyh" width="200" align="center">开户行</th>
        <th field="khzh" width="150" align="center">开户账号</th>
        <th field="gsdjh" width="200" align="center">国税</th>
        <th field="dsdjh" width="200" align="center">地税</th>
        <th field="state" width="200" align="center" formatter="formatterState">流失状态</th>
        <th field="createDate" width="200" align="center">创建时间</th>
        <th field="updateDate" width="200" align="center">更新时间</th>
    </tr>
    </thead>

</table>

<div id="tb">
    <div>
        <a href="javascript:openCustomerAddDialog()" class="easyui-linkbutton" iconCls="icon-add"
           plain="true">创建</a>
        <a href="javascript:openCustomerModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit"
           plain="true">修改</a>
        <a href="javascript:deleteCustomer()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
        <a href="javascript:openCustomerModifyDialog()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">联系人查看</a>
        <a href="javascript:openCustomerModifyDialog()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">交往记录</a>
        <a href="javascript:openOderTab()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">订单查看</a>
    </div>


    <div>
        客户名称： <input type="text" id="name" size="20" onkeydown="if(event.keyCode==13) searchCustomerChance()"/>
        客户编号： <input type="text" id="khno" size="20" onkeydown="if(event.keyCode==13) searchCustomerChance()"/>
        等级： <select class="easyui-combobox" id="level" editable="false" panelHeight="auto">
            <option value="">请选择...</option>
            <option value="战略合作伙伴">战略合作伙伴</option>
            <option value="大客户">大客户</option>
            <option value="重点开发客户">重点开发客户</option>
        </select>

        满意度： <select class="easyui-combobox" id="myd" editable="false" panelHeight="auto">
            <option value="">请选择...</option>
            <option value="☆">☆</option>
            <option value="☆☆">☆☆</option>
            <option value="☆☆☆">☆☆☆</option>
            <option value="☆☆☆☆">☆☆☆☆</option>
            <option value="☆☆☆☆☆">☆☆☆☆☆</option>
        </select>
        <a href="javascript:searchCustomersByParams()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
    </div>
</div>


<!--
   营销机会对话框
-->
<div id="dlg" class="easyui-dialog" style="width:700px;height:450px;padding: 10px 20px"
     closed="true" buttons="#dlg-buttons">
    <form id="fm" method="post">
        <table cellspacing="8px">
            <tr>
                <td>客户名：</td>
                <td><input type="text" id="customerName" name="name" class="easyui-validatebox"
                           required="true"/> <font color="red">*</font></td>
                <td></td>
                <td>法人</td>
                <td><input type="text" id="chanceSource" name="fr"/></td>
            </tr>
            <tr>
                <td>联系电话：</td>
                <td><input type="text" id="linkMan" name="phone" class="easyui-validatebox" required="true"/></td>
                <td></td>
                <td>国税：</td>
                <td><input type="text" id="linkPhone" name="gsdjh" class="easyui-validatebox" required="true"/></td>
            </tr>
            <tr>
                <td>地税：</td>
                <td><input type="text" id="cgjl" name="dsdjh"
                           required="true"/></td>
                <td colspan="3"></td>
            </tr>
            <tr>
                <td>营业执照</td>
                <td colspan="4"><input type="text" id="overView" name="yyzzzch" style="width: 420px"/></td>
            </tr>
            <tr>
                <td>注册资金：</td>
                <td colspan="4">
                    <textarea rows="5" cols="50" id="description" name="zczj"></textarea>
                </td>
            </tr>
        </table>

        <input type="hidden" name="id"/>
    </form>
</div>

<div id="dlg-buttons">
    <a href="javascript:saveOrUpdateCustomer()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
    <a href="javascript:closeCustomerDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>


</body>
</html>
