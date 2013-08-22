<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="template" tagdir="/WEB-INF/tags/templates" %>
<%@taglib prefix="post" tagdir="/WEB-INF/tags/posts" %>
<template:master pageTitle="文章列表">
    <jsp:body>
        <post:posts_list></post:posts_list>
    </jsp:body>
</template:master>
