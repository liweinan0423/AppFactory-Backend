<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/templates" %>
<%@ taglib prefix="post_categories" tagdir="/WEB-INF/tags/post_categories" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<template:master pageTitle="分类列表" activeMenu="post_category">
    <jsp:body>
        <div class="container">
            <a class="btn btn-primary" href="<c:url value='/products/new' />">新增产品</a>
            <table class="table">
                <thead>
                    <tr>
                        <th>名称</th>
                        <th>图片</th>
                        <th>所属分类</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${products}" var="product">
                    <tr>
                        <td>${product.name}</td>
                        <td>
                            <img class="img-thumbnail" width="100" height="100" src="<c:url value='${product.primaryImage.url}' />" />
                        </td>
                        <td>
                            ${product.category.name}
                        </td>
                        <td>
                            <div class="btn-group">
                                <a class="btn btn-primary" href="">修改</a>
                                <a class="btn btn-danger" data-method="delete" data-confirm="are you sure?" href="<c:url value='/products/${product.id}' />">删除</a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </jsp:body>
</template:master>
