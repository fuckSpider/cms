<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/8/9
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>excel上传</title>
    <jsp:include page="${pageContext.request.contextPath}/WEB-INF/include.jsp"/>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px">
    <legend>请选择excel上传</legend>
</fieldset>
<div class="layui-upload">
    <button type="button" class="layui-btn layui-btn-normal" id="test3">
        <i class="layui-icon">&#xe67c;</i>选择文件
    </button>
    <%--<span class="layui-inline layui-upload-choose"></span>--%>
    <button type="button" class="layui-btn" id="test4">上传文件</button>
</div>
</body>
<script>
    layui.use(['upload','layer'], function(){
        var upload = layui.upload;
        var layer = layui.layer;

        upload.render({
            elem:'#test3' ,
            url:'/file/upload',
            auto:false,
            bindAction:"#test4",
            accept: 'file',
            done: function(res){
                //上传完毕回调
                layer.msg(res.msg);
            }

        });
        })

</script>
</html>
