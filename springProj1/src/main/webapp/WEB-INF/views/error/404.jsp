<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>error</title>
	<jsp:include page="/WEB-INF/views/module/default_js_css.jsp" flush="false" />
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/views/common/top_nav.jsp" flush="false" >
			<jsp:param name="logined" value="${sessionScope.logined}" />
		</jsp:include>
	</header>
	<section class="container mt-3">
		<h2>404 - 요청한 주소의 페이지를 찾을 수 없습니다.</h2>
	</section>
</body>
</html>