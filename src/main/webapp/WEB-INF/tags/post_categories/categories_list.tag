<%@ tag pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<table class="table">
    <thead>
    <tr>
        <th>ID</th>
        <th>名称</th>
        <th>创建时间</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.content}" var="category">
        <tr>
            <td>${category.id}</td>
            <td>
                <spring:url value="/post_categories/${category.id}" var="view_postCategory_path"/>
                <a href="${view_postCategory_path}">${category.name}</a>
            </td>
            <td>${category.createdAt}</td>
            <td>
                <spring:url value="/post_categories/${category.id}/posts/new" var="add_post_path"/>
                <a href="${add_post_path}">添加文章</a>
                <a href="">修改</a>
                <a href="">删除</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div>
    <common:pagination></common:pagination>
</div>
