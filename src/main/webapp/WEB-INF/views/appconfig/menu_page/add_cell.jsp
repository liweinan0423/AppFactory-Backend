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
        <form:form servletRelativeAction="/appconfig/menu_page/cells" enctype="multipart/form-data" method="post"
                   class="form" role="form" commandName="cell">
            <common:textField name="title" label="标题"/>
            <common:numberField name="order" label="排序"/>

            <div class="form-group">
                <label>功能代码</label>

                <div>
                    <form:select id="function_select" path="functionCode" items="${function_code_map}"/>
                    <form:select id="category_select" path="functionId" style="display:none;" items="${postCategories}" itemLabel="name" itemValue="id" />
                    <form:select id="post_select" path="functionId" style="display:none;" items="${posts}" itemLabel="title" itemValue="id" />
                </div>
            </div>
            <label>图标</label>
            <input type="file" name="icon" class="form-control"/>
            <button type="submit" class="btn btn-success">保存</button>
        </form:form>
    </jsp:body>
</template:master>
