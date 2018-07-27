<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/7/26
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
    <jsp:include page="${pageContext.request.contextPath}/WEB-INF/include.jsp"/>
</head>
<body>
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px">
        <legend>常规使用:普通文件上传</legend>
    </fieldset>
    <div class="layui-upload-button">
        <button type="button" class="layui-btn layui-btn-normal" id="test1">
            <i class="layui-icon">&#xe67c;</i>上传图片
        </button>
    </div>

</body>
<script>
    layui.use('upload', function(){
        var upload = layui.upload;

        //执行实例
        var uploadInst = upload.render({
            elem: '#test1' //绑定元素
            ,url: '/file/upload' //上传接口
            ,done: function(res){
                //上传完毕回调
                console.log(res);
            }
            ,error: function(){
                //请求异常回调
            }
        });
    });
</script>
</html>
