<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<table>
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
    <c:if test="${not page.hasContent()}">
        <h2>没有文章可以显示</h2>
    </c:if>
    <c:if test="${page.hasContent()}">
        <c:forEach items="${page.content}" var="post">
            <tr>
                <td>${post.id}</td>
                <td>${post.title}</td>
                <td>${post.createdAt}</td>
                <td>${post.content}</td>
                <td></td>
            </tr>
        </c:forEach>
    </c:if>
    </tbody>
</table>
<div>
    <common:pagination></common:pagination>
</div>