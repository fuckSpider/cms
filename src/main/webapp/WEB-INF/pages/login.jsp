
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/include.jsp"/>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/component/header.jsp"/>
    <div class="form-wrapper">
        <div class="capital">用户登录</div>
        <form  id="login_form" action="/login" method="post"  class="layui-form layui-form-pane1 login-form" lay-filter="first">

            <div class="layui-form-item">
                <label class="layui-form-label">用户名</label>
                <div class="layui-input-block">
                    <input type="text" name="username" lay-verify="required|title" required placeholder="请输入用户名" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">密&emsp;码</label>
                <div class="layui-input-block">
                    <input type="password" name="password" lay-verify="required|title" required placeholder="请输入密码" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div>${message}</div>
            <input type="submit"  class="login_btn layui-btn layui-btn-normal" value="登录">
        </form>
    </div>

</div>
</body>
</html>
