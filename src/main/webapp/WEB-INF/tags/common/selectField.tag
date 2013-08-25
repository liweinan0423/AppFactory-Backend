<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ attribute name="name" required="true" rtexprvalue="true"
              description="Name of corresponding property in bean object" %>
<%@ attribute name="label" required="true" rtexprvalue="true"
              description="Label appears in red color if input is considered as invalid after submission" %>

<%@ attribute name="valueMap" required="true" type="java.util.Map" %>

<spring:bind path="${name}">
    <c:set var="cssGroup" value="form-group ${status.error ? 'error' : '' }"/>
    <div class="${cssGroup}">
        <label>${label}</label>
        <div>
            <form:select path="${name}" items="${valueMap}" cssClass="form-control"/>
            <span class="help-inline">${status.errorMessage}</span>
        </div>
    </div>
</spring:bind>