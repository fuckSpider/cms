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
<!--普通文件上传开始-->
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px">
        <legend>常规使用:普通文件上传</legend>
    </fieldset>
    <div class="layui-upload">
        <button type="button" class="layui-btn layui-btn-normal" id="test1">
            <i class="layui-icon">&#xe67c;</i>上传图片
        </button>
        <div class="layui-upload-list">
            <img class="layui-upload-img" id="demo1" style="width: 100px;height: 100px">
            <p id="demoText" style="color: red"></p>
        </div>
    </div>
<!--普通文件上传结束-->

<!--多文件上传开始-->
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px">
        <legend>常规使用:多文件上传</legend>
    </fieldset>
    <div class="layui-upload">
        <button type="button" class="layui-btn layui-btn-normal" id="test2">
            <i class="layui-icon">&#xe67c;</i>多图上传
        </button>
        <blockquote class="layui-elem-quote layui-quote-nm" style="margin-top: 10px">
            <div class="layui-upload-list" id="demo2">
                预览图 :
            </div>
        </blockquote>
    </div>
<!--多文件上传结束-->

<!--选完文件不自动上传开始-->
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px">
        <legend>选完文件后不自动上传</legend>
    </fieldset>
    <div class="layui-upload">
        <button type="button" class="layui-btn layui-btn-normal" id="test3">
            <i class="layui-icon">&#xe67c;</i>选择文件
        </button>
        <%--<span class="layui-inline layui-upload-choose"></span>--%>
        <button type="button" class="layui-btn" id="test4">上传文件</button>
    </div>
<!--选完文件不自动上传结束-->

<!--拖拽上传开始-->
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
        <legend>拖拽上传</legend>
    </fieldset>

    <div class="layui-upload-drag" id="test5">
        <i class="layui-icon"></i>
        <p>点击上传，或将文件拖拽到此处</p>
    </div>
<!--拖拽上传结束-->

<!--制作多文件列表开始-->
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <legend>高级应用：制作一个多文件列表</legend>
</fieldset>

<div class="layui-upload">
    <button type="button" class="layui-btn layui-btn-normal" id="testList">选择多文件</button>
    <div class="layui-upload-list">
        <table class="layui-table">
            <thead>
            <tr><th>文件名</th>
                <th>大小</th>
                <th>状态</th>
                <th>操作</th>
            </tr></thead>
            <tbody id="demoList"></tbody>
        </table>
    </div>
    <button type="button" class="layui-btn" id="testListAction">开始上传</button>
</div>
<!--制作多文件列表结束-->

</body>
<script>
    layui.use(['upload','layer'], function(){
        var upload = layui.upload;
        var layer = layui.layer;
        //执行实例
        var uploadInst = upload.render({
            elem: '#test1' //绑定元素
            ,url: '/file/upload' //上传接口
            , before: function (obj) {
                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    $('#demo1').attr('src', result); //图片链接（base64）
                });
            }
            ,done: function(res){
                //上传完毕回调
                layer.msg(res.msg);
            }
            ,error: function(){
                //上传文件失败,给出提示,并实现重传
                var demoText = $('#demoText');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn  layui-btn-xs demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function () {
                    uploadInst.upload();
                });
            }
        });

        upload.render({
           elem:'#test2' ,
            url:'/file/upload',
            multiple: true,
            before: function (obj) {
                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    $('#demo2').append("<img class=\"layui-upload-img\"  src="+result+" style=\"width: 100px;height: 100px\">") //图片链接（base64）
                });
            },
            done: function(res){
                //上传完毕回调
                layer.msg(res.msg);
             }

        });

        upload.render({
            elem:'#test3' ,
            url:'/file/upload',
            auto:false,
            bindAction:"#test4",
            done: function(res){
                //上传完毕回调
                layer.msg(res.msg);
            }

        });

        upload.render({
            elem:'#test5' ,
            url:'/file/upload',
            done: function(res){
                layer.msg(res.msg);
            }
        });


        //多文件列表示例
        var demoListView = $('#demoList')
            ,uploadListIns = upload.render({
            elem: '#testList'
            ,url: '/file/upload'
            ,accept: 'file'
            ,multiple: true
            ,auto: false
            ,bindAction: '#testListAction'
            ,choose: function(obj){
                var files = this.files = obj.pushFile(); //将每次选择的文件追加到文件队列
                //读取本地文件
                obj.preview(function(index, file, result){
                    var tr = $(['<tr id="upload-'+ index +'">'
                        ,'<td>'+ file.name +'</td>'
                        ,'<td>'+ (file.size/1014).toFixed(1) +'kb</td>'
                        ,'<td>等待上传</td>'
                        ,'<td>'
                        ,'<button class="layui-btn layui-btn-xs demo-reload layui-hide">重传</button>'
                        ,'<button class="layui-btn layui-btn-xs layui-btn-danger demo-delete">删除</button>'
                        ,'</td>'
                        ,'</tr>'].join(''));

                    //单个重传
                    tr.find('.demo-reload').on('click', function(){
                        obj.upload(index, file);
                    });

                    //删除
                    tr.find('.demo-delete').on('click', function(){
                        delete files[index]; //删除对应的文件
                        tr.remove();
                        uploadListIns.config.elem.next()[0].value = ''; //清空 input file 值，以免删除后出现同名文件不可选
                    });

                    demoListView.append(tr);
                });
            }
            ,done: function(res, index, upload){
                if(res.code == 1){ //上传成功
                    var tr = demoListView.find('tr#upload-'+ index)
                        ,tds = tr.children();
                    tds.eq(2).html('<span style="color: #5FB878;">上传成功</span>');
                    tds.eq(3).html(''); //清空操作
                    return delete this.files[index]; //删除文件队列已经上传成功的文件
                }
                this.error(index, upload);
            }
            ,error: function(index, upload){
                var tr = demoListView.find('tr#upload-'+ index)
                    ,tds = tr.children();
                tds.eq(2).html('<span style="color: #FF5722;">上传失败</span>');
                tds.eq(3).find('.demo-reload').removeClass('layui-hide'); //显示重传
            }
        });
    });
</script>
</html>
