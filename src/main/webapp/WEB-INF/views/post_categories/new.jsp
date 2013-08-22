<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/templates" %>
<%@ taglib prefix="post_categories" tagdir="/WEB-INF/tags/post_categories" %>
<template:master pageTitle="新增分类">
    <jsp:body>
        <div class="page-header"></div>
        <post_categories:category_form/>
    </jsp:body>
</template:master>
