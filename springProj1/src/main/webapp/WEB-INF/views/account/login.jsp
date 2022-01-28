<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인</title>
	<jsp:include page="/WEB-INF/views/module/default_js_css.jsp" flush="false" />
	<script type="text/javascript" src="/static/js/login.js"></script>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/views/common/top_nav.jsp" flush="false" >
			<jsp:param name="logined" value="${sessionScope.logined}" />
		</jsp:include>
	</header>
	<section class="container mt-3">
		<div class="row justify-content-center">
			<div class="col-sm-8">
				<div class="card border-light mb-3">
					<div class="card-header"><h3>로그인</h3></div>
					<div class="card-body">
						<form class="row g-2" action="./login" method="post">
							<c:if test="${not empty param.next }">
								<input type="hidden" value="${param.next }" name="next"> <!-- LoingCheckInterceptor 에 걸려 로그인 페이지를 요청한 주소로 이동하도록 -->
							</c:if>
							<label class="col-sm-3 col-form-label col-form-label-sm" for="id_username">아이디</label>
							<div class="col-sm-9">
								<input class="form-control form-control-sm" type="text"
									id="id_username" name="username" required>
								<div class=""></div>
							</div>
							<label class="col-sm-3 col-form-label col-form-label-sm" for="id_password">패스워드</label>
							<div class="col-sm-9">
								<input class="form-control form-control-sm" type="password"
									id="id_password" name="password" required>
								<div class=""></div>
							</div>
							<div class="col-sm-3 offset-sm-9 text-end">
								<button class="btn btn-outline-primary btn-sm" type="submit" onclick="loginCheck(this.form);">로그인</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>	
</body>
</html>