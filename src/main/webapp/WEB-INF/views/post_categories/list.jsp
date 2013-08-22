<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/templates" %>
<%@ taglib prefix="post_categories" tagdir="/WEB-INF/tags/post_categories" %>
<template:master pageTitle="分类列表" activeMenu="post_category">
    <jsp:body>
        <div class="container">
            <div class="page-header">
                <a href="${pageContext.request.contextPath}/post_categories/new" class="btn btn-default">新增分类</a>
            </div>
            <div class="row">
                <post_categories:categories_list/>
            </div>
        </div>
    </jsp:body>
</template:master>
