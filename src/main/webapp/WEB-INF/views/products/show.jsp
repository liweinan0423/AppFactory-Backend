<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/templates" %>
<%@ taglib prefix="post_categories" tagdir="/WEB-INF/tags/post_categories" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<template:master>
    <jsp:body>
        <div class="container well">
            <div class="row">
                <h3>名称</h3>
                    ${product.name}
            </div>
            <div class="row">
                <h3>所属分类</h3>
                    ${product.category.name}
            </div>
            <div class="row">
                <h3>封面图片</h3>
                <img class="img-thumbnail" src="<c:url value='${product.primaryImage.url}'/>"/>
            </div>

            <h3>其他图片</h3>
            <div class="row">
                <c:forEach items="${product.productImages}" var="image">
                    <c:if test="${!image.primary}">
                        <div class="col-lg-4">
                            <img class="img-thumbnail" src="<c:url value='${image.url}'/>"/>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
        </div>
    </jsp:body>
</template:master>
