<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/templates" %>
<%@ taglib prefix="post_categories" tagdir="/WEB-INF/tags/post_categories" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<template:master>
    <jsp:attribute name="pageScripts">
        <script type="text/javascript" src="<s:url value='/resources/common/js/add_product_category.js' />"></script>
    </jsp:attribute>
    <jsp:body>
        <div class="page-header"></div>
        <form:form cssClass="form well" servletRelativeAction="/products/categories" method="post"
                   enctype="multipart/form-data" commandName="productCategory">
            <common:textField name="name" label="分类名称"/>
            <common:textField name="desc" label="描述"/>
            <label>上级分类</label>

            <div class="form-group">
                <input type="checkbox" id="checkboxRoot"/>根节点
                <form:select id="parent_category" cssClass="form-control" path="parent.id" items="${categories}" itemLabel="name"
                             itemValue="id"/>
            </div>
            <label>图标</label>
            <input type="file" class="form-control" name="icon"/>

            <button class="btn btn-default" type="submit">保存</button>
        </form:form>
    </jsp:body>
</template:master>
