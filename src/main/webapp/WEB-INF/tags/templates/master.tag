<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true" pageEncoding="UTF-8" %>
<%@ attribute name="pageTitle" required="false" rtexprvalue="true" %>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags/templates" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>${pageTitle}</title>

    <template:styleSheets></template:styleSheets>


    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="${pageContext.request.contextPath}/resources/common/js/html5shiv.js"></script>
    <script src="${pageContext.request.contextPath}/resources/common/js/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<template:nav_bar/>

<div class="container jumbotron">
    <jsp:doBody/>
</div>
<template:javaScript/>

</body>
</html>

