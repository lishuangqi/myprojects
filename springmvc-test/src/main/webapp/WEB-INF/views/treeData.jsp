<%--
  Created by IntelliJ IDEA.
  User: michael
  Date: 2017/12/15
  Time: 下午4:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script>
    var zTree;
    function initzTree() {
        var treeNodes;
        $.ajax({
            async: false,
            cache: false,
            type: 'POST',
            dataType: "json",
            url: "${base}//treeData.json",//请求的action路径
            error: function () {//请求失败处理函数
                alert('请求失败');
            },
            success: function (data) { //请求成功后处理函数。
                treeNodes = data;   //把后台封装好的简单Json格式赋给treeNodes
            }
        });
        zTree = $.fn.zTree.init($("#treeDemo"), setting, treeNodes);
    }
</script>
<body>

</body>
</html>
