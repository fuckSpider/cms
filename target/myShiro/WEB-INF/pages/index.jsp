
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>后台主页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon"/>
    <jsp:include page="../include.jsp"/>

</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <!--头部导航-->
    <jsp:include page="../component/header.jsp"></jsp:include>
    <!--左侧导航区域-->
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <ul class="layui-nav layui-nav-tree"  lay-filter="test" id="layui-ul">

            </ul>
        </div>
    </div>
    <!-- 内容主体区域 -->
    <div class="content-body">
        <div class="layui-tab " lay-filter="demo" lay-allowClose="true">
            <ul class="layui-tab-title">

            </ul>
            <div class="layui-tab-content">

            </div>
        </div>
    </div>
</div>
<!--菜单模板-->
<script id="menu_src" type="text/html">
    {{#    layui.each(d.result, function(index, item){
    if(item.parent != null && item.childs != null){
    if (index == 0){
    }}
    <li class="layui-nav-item  layui-nav-itemed">
        {{#       }  else{                                      }}
    <li class="layui-nav-item">
        {{#                     }                               }}
        <a class="" href="javascript:;">{{item.parent.name}}</a>
        <dl class="layui-nav-child">
            {{#     layui.each(item.childs, function(index,child){  }}
            <dd><a href="javascript:;" class="a-tab-add" data-type="tabAdd" data-val="{{child.name}}" data-url="{{child.url}}" data-id="{{child.id}}">{{child.name}}</a></dd>
            {{#     });                                             }}
        </dl>
    </li>
    {{#   } });                                              }}
</script>
</body>
<script src="/js/index.js"></script>
</html>