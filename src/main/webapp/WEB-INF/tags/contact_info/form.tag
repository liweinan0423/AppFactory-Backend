<%@ tag pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>

<%@ attribute name="method" required="true" %>
<%@ attribute name="commandName" required="true" %>
<%@ attribute name="action" required="true" %>

<form:form servletRelativeAction="${action}" method="${method}" commandName="${commandName}">

    <form:hidden path="id" />
    <common:textField name="phoneName" label="电话名称" />
    <common:textField name="phoneNumber" label="电话号码" />
    <div class="">
        <button type="submit" class="btn btn-default">确定</button>
    </div>
</form:form>