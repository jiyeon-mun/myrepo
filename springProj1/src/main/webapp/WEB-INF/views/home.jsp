<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
	<title>Home</title>
	<jsp:include page="/WEB-INF/views/module/default_js_css.jsp" flush="false" />
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/views/common/top_nav.jsp" flush="false" >
			<jsp:param name="logined" value="${sessionScope.logined}" />
		</jsp:include>
	</header>
	<c:if test="${sessionScope.logined}">
		<h1>${sessionScope.account.username}님 환영합니다.</h1>
	</c:if>
	<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
