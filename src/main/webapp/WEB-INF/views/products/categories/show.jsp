<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/templates" %>
<%@ taglib prefix="post_categories" tagdir="/WEB-INF/tags/post_categories" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<template:master pageTitle="分类列表" activeMenu="post_category">
    <jsp:body>
        <div class="container">
            <div class="page-header">
                <a href="<c:url value='/products/categories/${id}/new' />" class="btn btn-default">新增分类</a>
            </div>
            <div class="row">
                <table class="table">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>名称</th>
                        <th>图标</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${children}" var="category">
                        <tr>
                            <td>${category.id}</td>
                            <td>
                                    ${category.name}
                            </td>
                            <td>
                                <img width="100" height="100" src="<c:url value='${category.iconURL}' />" class="img-thumbnail"/>
                            </td>
                            <td>
                                <a href="<c:url value='/products/categories/${category.id}/edit' />">修改</a>
                                <a href="<c:url value='/products/categories/${category.id}' />" data-method='delete'
                                   data-confirm='are you sure?'>删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </jsp:body>
</template:master>
