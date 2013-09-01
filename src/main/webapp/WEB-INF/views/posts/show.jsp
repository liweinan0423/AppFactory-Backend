<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/templates" %>
<%@ taglib prefix="post_categories" tagdir="/WEB-INF/tags/post_categories" %>
<%@ taglib prefix="posts" tagdir="/WEB-INF/tags/posts" %>
<template:headless>
    <jsp:body>
        ${post.content}
    </jsp:body>
</template:headless>
