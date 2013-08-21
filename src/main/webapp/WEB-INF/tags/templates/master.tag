<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true" %>
<%@ attribute name="pageTitle" required="false" rtexprvalue="true" %>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags/templates" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>${not empty pageTitle ? pageTitle : 'Default Title'}</title>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <%-- CSS Files Are Loaded First as they can be downloaded in parallel --%>
    <template:styleSheets/>
</head>
<body class="showgrid">
<div class="container">
    <h1>App后台管理</h1>
    <jsp:doBody/>
</div>
<template:javaScript/>
</body>
</html>
