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
        <form:form servletRelativeAction="/appconfig/menu_page/cells/${cell.id}"  method="patch"
                   class="form" role="form" commandName="cell">
            <common:textField name="title" label="标题"/>
            <common:numberField name="order" label="排序"/>
            <form:hidden path="id" />
            <form:hidden path="iconURL" />
            <div class="form-group">
                <label>功能代码</label>

                <div>
                    <form:select id="function_select" path="functionCode" items="${function_code_map}"/>
                    <form:select path="functionId" id="category_select" style="display:none;" items="${postCategories}" itemLabel="name" itemValue="id" />
                    <form:select path="functionId" id="post_select" style="display:none;" items="${posts}" itemLabel="title" itemValue="id" />
                </div>
            </div>

            <button type="submit" class="btn btn-primary">保存</button>
        </form:form>
    </jsp:body>
</template:master>
