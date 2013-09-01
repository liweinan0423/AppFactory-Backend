<%@ tag pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="activeMenu" %>

<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="<c:url value="/" />">App 后台管理</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">功能列表 <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="<c:url value='/post_categories' />">文章管理</a></li>
                        <li><a href="<c:url value='/appconfig/menu_page/layout' />">菜单布局</a></li>
                        <li><a href="<c:url value='/appconfig/menu_page/cells' />">宫格配置</a></li>
                        <li><a href="<c:url value='/company_info/edit' />">企业信息</a></li>
                        <li><a href="<c:url value='/contact_info' />">一键呼叫</a></li>
                    </ul>
                </li>
            </ul>
            <form class="navbar-form navbar-right">
                <div class="form-group">
                    <input type="text" placeholder="用户名" class="form-control">
                </div>
                <div class="form-group">
                    <input type="password" placeholder="密码" class="form-control">
                </div>
                <button type="submit" class="btn btn-success">登 录</button>
            </form>
        </div>
    </div>
</div>