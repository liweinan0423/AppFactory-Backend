<%@ tag pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="baseUrl" %>

第${page.number + 1}页/共${page.totalPages}页
<c:if test="${page.hasPreviousPage()}">
    <a href="${baseUrl}?page.size=${page.size}&page.number=${page.number - 1}">上一页</a> |
</c:if>
<c:if test="${page.hasNextPage()}">
    <a href="${baseUrl}?page.size=${page.size}&page.number=${page.number + 1}">下一页</a>
</c:if>