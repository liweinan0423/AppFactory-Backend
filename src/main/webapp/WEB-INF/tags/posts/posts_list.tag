<%@ tag pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ attribute name="posts" required="true" type="java.util.List" %>
<ul>
    <c:forEach items="${posts}" var="post">
        <li>
            <a href="<c:url value='/post_categories/${post.category.id}/posts/${post.id}' />">${post.title}</a> |
            <div class="btn-group">
                <a class="btn btn-primary" href="<c:url value='/post_categories/${post.category.id}/posts/${post.id}/edit' />">编辑</a>
                <a class="btn btn-danger" href="<c:url value='/post_categories/${post.category.id}/posts/${post.id}' />" data-method="delete" data-confirm="are you sure?">删除</a>
            </div>
        </li>
    </c:forEach>
</ul>
</table>