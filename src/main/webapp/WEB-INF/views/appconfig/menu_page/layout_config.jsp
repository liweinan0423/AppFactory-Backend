<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/templates" %>
<%@ taglib prefix="post_categories" tagdir="/WEB-INF/tags/post_categories" %>
<%@ taglib prefix="appconfig" tagdir="/WEB-INF/tags/appconfig" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<template:master>
    <jsp:body>

        <form:form servletRelativeAction="/appconfig/menu_page/layout" method="put" commandName="menuPage">
            <form:radiobutton id="GRID_9"  path="layoutType" value="GRID_9" />
            <label for="GRID_9">九宫格</label>

            <form:radiobutton id="GRID_16" path="layoutType" value="GRID_16" />
            <label for="GRID_16">十六宫格</label>

            <form:radiobutton id="LIST" path="layoutType" value="LIST" />
            <label for="LIST">列表</label>


            <button type="submit" class="btn btn-default">保存</button>
        </form:form>
    </jsp:body>
</template:master>
