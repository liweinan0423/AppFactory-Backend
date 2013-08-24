<%@ tag pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>

<%@ attribute name="method" required="true" %>
<%@ attribute name="commandName" required="true" %>
<%@ attribute name="action" required="true" %>

<form:form action="${action}" method="${method}" commandName="${commandName}">

    <form:hidden path="id" />
    <common:textField name="title" label="文章标题" />
    <common:ckEditor name="content" label="文章内容" />
    <div class="">
        <button type="submit" class="btn btn-default">确定</button>
    </div>
</form:form>