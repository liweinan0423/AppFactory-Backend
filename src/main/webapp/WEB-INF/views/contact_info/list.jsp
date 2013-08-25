<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/templates" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<template:master pageTitle="分类列表" activeMenu="post_category">
    <jsp:body>
        <h3>一键呼叫列表</h3>

        <div class="btn-group">
            <a href="<c:url value='/contact_info/new' />" class="btn btn-default">添加号码</a>
        </div>

        <table class="table">
            <thead>
            <tr>
                <th>电话名称</th>
                <th>电话号码</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${contactInfoList}" var="contactInfo">
                <tr>
                    <td>${contactInfo.phoneName}</td>
                    <td>${contactInfo.phoneNumber}</td>
                    <td>
                        <div class="btn-group">
                            <a class="btn btn-default" href="<c:url value='/contact_info/${contactInfo.id}/edit' />">修改</a>
                            <a class="btn btn-danger" data-method="delete" data-confirm="are you sure?" href="<c:url value='/contact_info/${contactInfo.id}' />">删除</a>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </jsp:body>
</template:master>
