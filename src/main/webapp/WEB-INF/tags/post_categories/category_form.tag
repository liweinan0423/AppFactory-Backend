<%@ tag pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>

<%@attribute name="action" required="true" %>
<%@attribute name="method" required="true" %>

<form:form servletRelativeAction="${action}" method="${method}" commandName="postCategory">
    <common:textField name="name" label="分类名称" />
    <form:errors />
    <div class="form-actions">
        <button type="submit" class="btn btn-default">确定</button>
    </div>
</form:form>