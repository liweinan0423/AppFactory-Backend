<%@ tag pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/templates" %>
<%@ taglib prefix="contact_info" tagdir="/WEB-INF/tags/contact_info" %>
<template:master>
    <jsp:doBody />
    <jsp:attribute name="pageScripts">
        <jsp:invoke fragment="pageScripts" />
    </jsp:attribute>
</template:master>
