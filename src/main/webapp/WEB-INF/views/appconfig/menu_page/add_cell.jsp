<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/templates" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="post_categories" tagdir="/WEB-INF/tags/post_categories" %>
<%@ taglib prefix="appconfig" tagdir="/WEB-INF/tags/appconfig" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<template:master>
    <jsp:body>
        <form:form action="/appconfig/menu_page/cells" enctype="multipart/form-data" method="post" class="form" role="form" commandName="cell">
            <common:textField name="title" label="标题" />
            <common:numberField name="order" label="排序" />

            <common:selectField name="functionCode" label="功能代码" valueMap="${function_code_map}" />

            <label>图标</label>
            <input type="file" name="icon" class="form-control" />

            <button type="submit" class="btn btn-success">保存</button>
        </form:form>
    </jsp:body>
</template:master>
