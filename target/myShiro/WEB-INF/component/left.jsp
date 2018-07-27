<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/6/12
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
        <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
        <ul class="layui-nav layui-nav-tree"  lay-filter="test" id="layui-ul">
            <li class="layui-nav-item layui-nav-itemed">
                <a class="" href="javascript:;">模块管理<span class="layui-nav-more"></span></a>
                 <dl class="layui-nav-child">
                     <dd><a href="javascript:;" class="a-tab-add" data-type="tabAdd" data-val="订单模块" data-url="/module/order" data-id="2">订单模块</a></dd>
                     <dd><a href="javascript:;" class="a-tab-add" data-type="tabAdd" data-val="活动模块" data-url="/module/activity" data-id="4">活动模块</a></dd>
                 </dl>
            </li>
        </ul>
    </div>
</div>
