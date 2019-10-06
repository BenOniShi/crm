<html>
<head>
    <link rel="stylesheet" href="${ctx}/static/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
    <script type="text/javascript" src="${ctx}/static/ztree/js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="${ctx}/static/ztree/js/jquery.ztree.core.js"></script>


</head>
<body >

<div>
    <ul id="treeDemo" class="ztree"></ul>
</div>


<SCRIPT type="text/javascript">
    var ctx="${ctx}";
    $(function () {
        $.ajax({
            type:"post",
            url:ctx+"/module/queryAllModules",
            dataType:"json",
            success:function (data) {
                // zTree 的参数配置，深入使用请参考 API 文档（setting 配置详解）
                var setting = {
                    data: {
                        simpleData: {
                            enable: true
                        }
                    }
                };
                $.fn.zTree.init($("#treeDemo"), setting, data);
            }
        })
    });



</SCRIPT>


</body>
</html>
