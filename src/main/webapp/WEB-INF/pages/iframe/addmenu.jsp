<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/8/3
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="${pageContext.request.contextPath}/WEB-INF/include.jsp"/>
</head>
<body>
    <form class="layui-form layui-form-pane">
        <div class="layui-form-item">
            <label class="layui-form-label">菜单名字</label>
            <div class="layui-input-inline">
                <input type="text" name="menu_name" lay-verify="menu_name" autocomplete="off" placeholder="请输入菜单名字" class="layui-input" id="name">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">菜单地址</label>
            <div class="layui-input-inline">
                <input type="text" name="menu_url" lay-verify="menu_url" autocomplete="off" placeholder="请输入菜单地址" class="layui-input" id="url">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">父级菜单</label>
            <div class="layui-input-inline">
                <input type="checkbox"  name="open" lay-skin="switch" lay-filter="switchTest" title="开关" id="isparent">
             </div>
        </div>
        <div class="layui-form-item"  id="parent_select">
            <label class="layui-form-label">选择父级菜单</label>
            <div class="layui-input-inline">
               <select id="select_parent">
                   <option value="">请选择父级菜单</option>
                   <c:forEach items="${parent}" var="item">
                       <option value="${item.id}">${item.name}</option>
                   </c:forEach>
               </select>
            </div>
        </div>
    </form>
</body>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/include.jsp"/>
<script>
    //JavaScript代码区域
    layui.use(['element','form'], function(){

        var element = layui.element;
        var form = layui.form;

        form.on('switch(switchTest)', function(data){
            if(this.checked){
                $('#parent_select').prop("hidden",true);
            }else{
                $('#parent_select').prop("hidden",false);
            }
        });



    });

    // function addmenu(){
    //     //获取菜单名字
    //     var name = $('#name').val();
    //     //获取菜单地址
    //     var url = $('#url').val();
    //     //获取是否是父菜单
    //     var isparent = $('#isparent').prop('checked')? 1 :0;
    //     //if判断
    //     var pid = 0;
    //     if(isparent==0){
    //         pid =$('#select_parent option:selected').val();
    //     }
    //     var params = {"name":name,"url":url,"isparent":isparent,"pid":pid};
    //     console.log(params);
    //     //非空验证
    //     //发送请求
    //     //交互
    //     //本页面关闭
    // }
</script>
</html>
