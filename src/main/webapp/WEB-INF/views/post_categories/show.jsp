<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/templates" %>
<%@ taglib prefix="post_categories" tagdir="/WEB-INF/tags/post_categories" %>
<%@ taglib prefix="posts" tagdir="/WEB-INF/tags/posts" %>
<template:master>
    <jsp:body>
        <div class="page-header">
            <h3>${postCategory.name}</h3>
            <a href="<s:url value='/post_categories/${category_id}/posts/new' />">添加文章</a>
        </div>
        <posts:posts_list posts="${postCategory.posts}"></posts:posts_list>
    </jsp:body>
</template:master>
