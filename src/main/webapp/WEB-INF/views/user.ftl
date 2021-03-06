<html>
<head>
    <#include "common.ftl" >
    <script type="text/javascript" src="${ctx}/static/js/common.js"></script>

    <script type="text/javascript" src="${ctx}/static/js/user.js"></script>


</head>
<body style="margin: 1px">
<table id="dg"  class="easyui-datagrid"
       fitColumns="true" pagination="true" rownumbers="true"
       url="${ctx}/user/list" fit="true" toolbar="#tb">
    <thead>
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="id" width="50" align="center">编号</th>
        <th field="userName" width="200" align="center" >用户名</th>
        <th field="trueName" width="100" align="center">真实姓名</th>
        <th field="phone" width="50" align="center">手机号</th>
        <th field="email" width="200" align="center">邮箱</th>
        <th field="createDate" width="100" align="center">创建时间</th>
        <th field="updateDate" width="100" align="center">更新时间</th>
        <th field="roleName" width="100" align="center">角色</th>
    </tr>
    </thead>
</table>

<div id="tb">
    <div>
        <a href="javascript:openUserAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">创建</a>
        <a href="javascript:openUserModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
        <a href="javascript:deleteUser()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
    </div>
    <div>
        用户名： <input type="text" id="userName" size="20" onkeydown="if(event.keyCode==13) searchUsersByParams()"/>
        手机号： <input type="text" id="phone" size="20" onkeydown="if(event.keyCode==13) searchUsersByParams()"/>
        邮箱： <input type="text" id="mail" size="20" onkeydown="if(event.keyCode==13) searchUsersByParams()"/>
        <a href="javascript:searchUsersByParams()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
    </div>
</div>




<!--
   用户对话框
-->
<div id="dlg" class="easyui-dialog" style="width:700px;height:450px;padding: 10px 20px"
     closed="true" buttons="#dlg-buttons">
    <form id="fm" method="post">
        <table cellspacing="8px">
            <tr>
                <td>用户名：</td>
                <td><input type="text"  name="userName" class="easyui-validatebox" required="true"/> <font color="red">*</font></td>
                <td>    </td>
                <td>手机号:</td>
                <td><input type="text"  name="phone" /></td>
            </tr>
            <tr>
                <td>邮箱：</td>
                <td><input type="text"name="email"class="easyui-validatebox" required="true" /></td>
                <td>    </td>
                <td>真实姓名：</td>
                <td><input type="text" name="trueName" class="easyui-validatebox" required="true" /></td>
            </tr>
            <tr>
                <td>角色：</td>
                <td><input type="text" name="roleIds"  panelHeight="auto" multiple="true" class="easyui-combobox" url="${ctx}/role/allRoles"  valueField="id" textField="text"/></td>

            </tr>
        </table>

        <input type="hidden"name="id" id="userid"/>
    </form>
</div>

<div id="dlg-buttons">
    <a href="javascript:saveOrUpdateUser()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
    <a href="javascript:closeUserDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>




</body>
</html>
