<%@ tag pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ attribute name="posts" required="true" type="java.util.List" %>
<ul>
    <c:forEach items="${posts}" var="post">
        <li>
            ${post.title}
        </li>
    </c:forEach>
</ul>
</table>