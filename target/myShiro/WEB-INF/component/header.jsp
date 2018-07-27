<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="layui-header">
    <div class="layui-logo">阿刚后台</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <c:if test="${username != null}">
        <div class="menu-switch">
            <i class="iconfont icon-caidan"></i>
        </div>
    </c:if>
    <ul class="layui-nav layui-layout-left">
        <c:if test="${username == null}">
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/login">登录</a></li>
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/register">注册</a></li>
        </c:if>
    </ul>
    <c:if test="${username != '' && username != null}">
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                        ${username}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/logout">退了</a></li>
        </ul>
    </c:if>
</div>

