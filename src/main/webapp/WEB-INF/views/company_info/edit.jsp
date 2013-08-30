<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/templates" %>
<%@ taglib prefix="posts" tagdir="/WEB-INF/tags/posts" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<template:master pageTitle="新增分类">
    <jsp:body>
        <form:form servletRelativeAction="/company_info" commandName="companyInfo" method="put">
            <common:ckEditor name="content" label="企业信息" />
            <button class="btn btn-primary" type="submit">保存</button>
        </form:form>
    </jsp:body>
</template:master>
