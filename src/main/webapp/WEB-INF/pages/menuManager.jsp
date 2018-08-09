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
    <button class="layui-btn" id="add">添加菜单</button>
    <table id="demo" lay-filter="test" ></table>
</div>
</body>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script type="text/html" id="addmenu">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script>
    layui.use(['table','layer','form'], function(){
        var table = layui.table;
        var layer = layui.layer;
        var form = layui.form;
        //添加菜单模块

        //1.点击添加菜单,弹出layer
        $('#add').click(function(){
            //弹出可编辑 页面
            layer.open({
                type:2,
                title:'添加菜单',
                area: ['700px', '500px'],
                offset: [$(window).height()-670,$(window).height()-390],
                content:'/system/menu/add',
                btn: ['提交', '关闭'],
                yes:function(index,layero){
                    var iframe = $(layero).find("iframe")[0].contentWindow.document;
                    var name =  iframe.getElementById("name").value;
                    var url = iframe.getElementById("url").value;
                    var isparent = iframe.getElementById("isparent").checked?1:0;
                    var pid = 0;
                    if(isparent==0){
                        var select  = iframe.getElementById("select_parent");
                        pid = $(select).find("option:selected").val();
                    }

                    var visible = 1;
                    //非空验证
                    if(name==""||name==null){
                        layer.msg("请先填写菜单名字");
                        return ;
                    }
                    if(url==""||url==null){
                        layer.msg("请先填写菜单地址");
                        return ;
                    }

                    if(isparent==0&&pid==0){
                        layer.msg("请先选择父亲节点");
                        return ;
                    }

                    if(isparent==1){
                        url=null;
                    }

                    //
                    $.post("/menu/addMenu",{"name":name,"url":url,"isParent":isparent,"visible":visible,"pid":pid},function(res){
                        if(res.code==1){
                            layer.msg(res.msg);
                            window.location.reload();
                        }
                        if(res.code==0){
                            layer.msg(res.msg);
                        }
                        layer.close();
                    })
                },
                btn2:function(){
                    layer.close();
                }
            });
        });


        //table渲染
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


        //监听table工具条--用于检测是否点击编辑和删除
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
