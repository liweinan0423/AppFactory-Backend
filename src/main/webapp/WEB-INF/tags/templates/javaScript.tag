<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:url value="/resources/bootstrap-3.0/js/bootstrap.min.js" var="bootstrap_js_path" />

<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript" src="${bootstrap_js_path}"></script>
<script type="text/javascript" src="<spring:url value='/resources/common/js/ujs.js' />"></script>