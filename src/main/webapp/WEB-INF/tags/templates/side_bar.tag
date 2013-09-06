<%@ tag pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="activeMenu" %>

<ul class="nav">
    <li><a href="<c:url value='/post_categories' />">文章管理</a></li>
    <li><a href="<c:url value='/appconfig/menu_page/layout' />">菜单布局</a></li>
    <li><a href="<c:url value='/appconfig/menu_page/cells' />">宫格配置</a></li>
    <li><a href="<c:url value='/company_info/edit' />">企业信息</a></li>
    <li><a href="<c:url value='/contact_info' />">一键呼叫</a></li>
    <li><a href="<c:url value="/products/categories" />">产品分类</a></li>
    <li><a href="<c:url value="/products" />">产品</a></li>
</ul>