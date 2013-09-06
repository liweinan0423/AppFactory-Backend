<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/templates" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<template:master pageTitle="新增分类">
    <jsp:body>
        <form:form cssClass="form" servletRelativeAction="/products/${product.id}" method="patch"
                   enctype="multipart/form-data"
                   commandName="productData">
            <form:hidden path="id" />
            <common:textField name="name" label="产品名称"/>

            <label>封面图片</label>

            <div>
                <img class="img-thumbnail" width="100" height="100"
                     src="<spring:url value='${productData.primaryImage.url}' />"/>
                <common:uploadButton name="primaryImage" label="更改" />
            </div>
            <label>更多图片</label> <a href="#" id="add_image">增加</a>

            <div id="images">
                <div class="row">
                    <c:forEach items="${productData.productImages}" var="image">
                        <c:if test="${!image.primary}">
                            <div class="col-lg-4">
                                <img class="img-thumbnail" src="<c:url value='${image.url}' />"/>

                                <div class="btn-group">
                                    <common:uploadButton name="otherImages" label="更改" />
                                    <button class="btn btn-danger">删除</button>
                                </div>
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
            </div>

            <common:ckEditor name="desc" label="产品详细描述"/>
            <button class="btn btn-default" type="submit">保存</button>
        </form:form>
    </jsp:body>

</template:master>
