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
    <c:forEach items="${postCategories}" var="category">
        <tr>
            <td>${category.id}</td>
            <td>
                <spring:url value="/post_categories/${category.id}" var="view_postCategory_path"/>
                <a href="${view_postCategory_path}">${category.name}</a>
            </td>
            <td>${category.createdAt}</td>
            <td>

                <a href="<spring:url value='/post_categories/${category.id}/posts/new'/>">添加文章</a>
                <a href="<spring:url value='/post_categories/${category.id}/edit' />">修改</a>
                <a href="<spring:url value='/post_categories/${category.id}' />" data-method='delete' data-confirm='are you sure?'>删除</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>