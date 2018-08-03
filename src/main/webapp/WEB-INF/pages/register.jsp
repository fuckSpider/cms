<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/include.jsp"/>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <jsp:include page="${pageContext.request.contextPath}/WEB-INF/component/header.jsp"/>
    <div class="form-wrapper">
        <div class="capital">用户注册</div>
        <form  id="register_form"  class="layui-form layui-form-pane1 login-form" lay-filter="first">

            <div class="layui-form-item">
                <label class="layui-form-label">用户名</label>
                <div class="layui-input-block">
                    <input type="text" name="username" lay-verify="required|title" required placeholder="请输入用户名" autocomplete="off" class="layui-input" id="username">
                    <span id="username_text" style="color: red"></span>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">密&emsp;码</label>
                <div class="layui-input-block">
                    <input type="password" name="password" lay-verify="required|title" required placeholder="请输入密码" autocomplete="off" class="layui-input" id="password">
                    <span id="password_text" style="color: red"></span>
                </div>
            </div>
            <div>${message}</div>
            <input type="button" id="register_btn" class="login_btn layui-btn layui-btn-normal" value="注册">
        </form>
    </div>
</div>
</body>
<script>
    $(function(){
        layui.use("layer",function(){
            var layer = layui.layer;
            $('#register_btn').on("click" ,function(){
                var username= $('#username').val();
                var password = $('#password').val();
                if(username==null||username==""){
                    $('#username_text').html("用户名为空");
                    return;
                }
                if(password==null||password==""){
                    $('#password_text').html("password为空");
                    return;
                }
                $.ajax({
                    url:"/register",
                    type:"post",
                    data:{"username":username,"password":password},
                    success:function(res){
                        if(res.code==1){
                            layer.msg(res.msg);
                            setTimeout(function(){
                                window.location.href=basePath+"/login";
                            },1500);
                        }else if(res.code==-1){
                           $('#username_text').html(res.msg);
                        } else{
                            layer.msg(res.msg);
                        }
                    }
                });
            });
        });
    });

</script>
</html>