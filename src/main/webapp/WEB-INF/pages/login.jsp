
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
                    <input type="text" name="username" lay-verify="required|title" required placeholder="请输入用户名" autocomplete="off" class="layui-input" id="username">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">密&emsp;码</label>
                <div class="layui-input-block">
                    <input type="password" name="password" lay-verify="required|title" required placeholder="请输入密码" autocomplete="off" class="layui-input" id="password">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">验证码</label>
                <div class="layui-input-block">
                    <input type="text" name="code" style="width: 80px;" lay-verify="required" id="captcha"/>
                    <img id="imgObj" alt="验证码" src="/getCode"><a href="#" id="changeImg">换一张</a><br/>
                </div>
            </div>
            <div>${message}</div>
            <input type="submit"  class="login_btn layui-btn layui-btn-normal" value="登录" id="submit">
        </form>
    </div>

</div>
    <script>
        layui.use('form',function(){
            var form = layui.from;
            $('#changeImg').click(changeCaptcha);
            // $('#submit').on('click',login);

        })
        function changeCaptcha(){
            var path = "/getCode?s="+Math.random();
            $('#imgObj').attr("src",path);
        }

        // function login (){
        //     layui.use('layer',function(){
        //         //获取账号
        //         var username = $('#username').val();
        //         //获取密码
        //         var password = $('#password').val();
        //         //获取验证码
        //         var captcha = $('#captcha').val();
        //
        //         if(username==null||username ==""){
        //             layer.open({
        //                 title: '提示'
        //                 ,content: '请填写用户名！'
        //             });
        //             return;
        //         }
        //         if(password==null||password ==""){
        //             layer.open({
        //                 title: '提示'
        //                 ,content: '请填写密码！'
        //             });
        //             return;
        //         }
        //         if(captcha==null||captcha ==""){
        //             layer.open({
        //                 title: '提示'
        //                 ,content: '请填写验证码！'
        //             });
        //             return;
        //         }
        //         console.log(username+":"+password+":"+captcha);
        //         var params = {"username":username,"password":password,"captcha":captcha};
        //         $.post("/login",params);
        //     })
        //
        // }
    </script>
</body>
</html>
