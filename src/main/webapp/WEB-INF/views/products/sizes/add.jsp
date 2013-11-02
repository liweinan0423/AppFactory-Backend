<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/templates" %>
<%@ taglib prefix="post_categories" tagdir="/WEB-INF/tags/post_categories" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<template:master>
    <form:form cssClass="form" servletRelativeAction="/products/${id}/sizes" method="post" commandName="productSize">

        <common:textField name="name" label="名称" />
        <common:textField name="price" label="价格" />

        <button class="btn btn-default" type="submit">保存</button>
    </form:form>

</template:master>
