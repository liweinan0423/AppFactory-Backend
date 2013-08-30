<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/templates" %>
<%@ taglib prefix="posts" tagdir="/WEB-INF/tags/posts" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<template:headless>
    <jsp:body>
        <div data-role="page" class="row container">
            ${companyInfo.content}
        </div>
    </jsp:body>
</template:headless>

