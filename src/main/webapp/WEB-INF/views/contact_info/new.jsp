<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/templates" %>
<%@ taglib prefix="contact_info" tagdir="/WEB-INF/tags/contact_info" %>
<template:master pageTitle="新增分类">
    <jsp:body>
        <div class="page-header"></div>
        <contact_info:form action="/contact_info" method="post" commandName="contactInfo" />
    </jsp:body>
</template:master>
