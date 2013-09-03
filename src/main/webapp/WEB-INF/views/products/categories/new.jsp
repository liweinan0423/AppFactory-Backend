<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/templates" %>
<%@ taglib prefix="post_categories" tagdir="/WEB-INF/tags/post_categories" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<template:master pageTitle="新增分类">
    <jsp:body>
        <div class="page-header"></div>
        <form:form cssClass="form" servletRelativeAction="/products/categories" method="post" enctype="multipart/form-data" commandName="productCategory">
            <common:textField name="name" label="分类名称" />
            <label>图标</label>
            <input type="file" class="form-control" name="icon" />

            <button class="btn btn-default" type="submit">保存</button>
        </form:form>
    </jsp:body>
</template:master>
