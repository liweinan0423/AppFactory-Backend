<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/templates" %>
<%@ taglib prefix="post_categories" tagdir="/WEB-INF/tags/post_categories" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>

<template:master pageTitle="新增分类">
    <jsp:body>
        <form:form cssClass="form" servletRelativeAction="/products" method="post" enctype="multipart/form-data"
                   commandName="productData">
            <common:textField name="name" label="产品名称"/>

            <label>封面图片</label>
            <input type="file" class="form-control" name="primaryImage"/>

            <label>更多图片</label> <a href="#" id="add_image">增加</a>

            <div id="images">
                <div class="row">
                    <div class="col-lg-11">
                        <input type="file" class="form-control" name="otherImages"/>
                    </div>
                    <div class="col-lg-1">
                        <a href="#" class="btn btn-danger remove_image" onclick="appfactory.product.removeUploadComponent(this);return false;">删除</a>
                    </div>
                </div>
            </div>

            <common:ckEditor name="desc" label="产品详细描述"/>
            <button class="btn btn-default" type="submit">保存</button>
        </form:form>
    </jsp:body>

</template:master>
