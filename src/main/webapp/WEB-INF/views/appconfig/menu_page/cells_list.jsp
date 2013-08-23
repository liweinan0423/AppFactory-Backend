<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/templates" %>
<%@ taglib prefix="post_categories" tagdir="/WEB-INF/tags/post_categories" %>
<%@ taglib prefix="appconfig" tagdir="/WEB-INF/tags/appconfig" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<template:master>
    <jsp:body>
        <div class="page-header">
            <h3>菜单页面模板配置</h3>
        </div>
        <div class="btn-group">
            <a class="btn btn-default" href="<c:url value='/appconfig/menu_page/cells/new' />">添加宫格</a>
        </div>

        <div class="row">
            <c:forEach items="${menuPage.cells}" var="cell">
                <appconfig:cell cell="${cell}"></appconfig:cell>
            </c:forEach>
        </div>
    </jsp:body>
</template:master>
