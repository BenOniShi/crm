function searchCusSumByParams() {
    $("#dg").datagrid("load",{
        cusName:$("#cusName").val()
    })
}