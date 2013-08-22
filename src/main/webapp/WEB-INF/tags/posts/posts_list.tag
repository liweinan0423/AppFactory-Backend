<%@ tag pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ attribute name="posts" required="true" type="java.util.List" %>
<table class="table">
    <thead>
    <tr>
        <th>ID</th>
        <th>标题</th>
        <th>创建时间</th>
        <th>内容</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${posts}" var="post">
        <tr>
            <td>${post.id}</td>
            <td>${post.title}</td>
            <td>${post.createdAt}</td>
            <td>${post.content}</td>
            <td>
                <spring:url value="/post_categories/${category_id}/posts/${post.id}/edit" var="edit_post_path" />
                <a href="${edit_post_path}">编辑</a>

                <spring:url value="/post_categories/${category_id}/posts/${post.id}" var="post_path" />
                <form:form action="${post_path}" method="DELETE" cssStyle="display:inline">
                    <a data-confirm="are you sure?1" class="alert" type="submit">删除</a>
                </form:form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>