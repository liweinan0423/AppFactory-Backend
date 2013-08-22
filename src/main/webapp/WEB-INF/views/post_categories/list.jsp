<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/templates" %>
<%@ taglib prefix="post_categories" tagdir="/WEB-INF/tags/post_categories" %>
<template:master pageTitle="分类列表">
    <jsp:body>
        <div>
            <a href="${pageContext.request.contextPath}/post_categories/new" class="button">新增分类</a>
        </div>
        <post_categories:categories_list />
    </jsp:body>
</template:master>
