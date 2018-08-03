<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/7/30
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>菜单管理</title>
    <jsp:include page="${pageContext.request.contextPath}/WEB-INF/include.jsp"/>
</head>
<body>
<div style="margin-left: 290px;margin-top: 110px">
    <button class="layui-btn">添加菜单</button>
    <table id="demo" lay-filter="test" ></table>
</div>
</body>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script>
    layui.use(['table','layer'], function(){
        var table = layui.table;
        var layer = layui.layer;
        table.render({
            elem: '#demo'
            ,width:1000
            ,cols: [[ //表头
                {field: 'id', title: 'ID', sort: true}
                ,{field: 'name', title: '菜单名'}
                ,{field: 'url', title: 'url',width:150}
                ,{field: 'pid', title: 'pid'}
                ,{field: 'visible', title: '是否可用'}
                // ,{field: 'icon', title: '图标'}
                ,{field: 'isparent', title: '是否是父菜单'}
                ,{field:'operation',title:'操作',toolbar: '#barDemo',width:120}
            ]]
            ,url: '/menu/list/all' //数据接口
            ,page: true //开启分页
            ,done:function(res){
                //userPage.data = res.data;
            }
        });


        //监听工具条--用于检测是否点击编辑和删除
        table.on('tool(test)', function(obj){
            var data = obj.data;
             if(obj.event == 'del'){
                layer.confirm('真的删除行么', function(index){
                    obj.del();
                    layer.close(index);
                });
            } else if(obj.event == 'edit'){
                layer.alert('编辑行：<br>'+ JSON.stringify(data))
            }
        });
    });
</script>
</html>
