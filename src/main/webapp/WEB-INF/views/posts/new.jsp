<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/templates" %>
<%@ taglib prefix="posts" tagdir="/WEB-INF/tags/posts" %>
<template:master pageTitle="新增分类">
    <jsp:body>
        <posts:post_form action="/post_categories/${category_id}/posts/create" method="POST" commandName="post" />
    </jsp:body>
</template:master>
