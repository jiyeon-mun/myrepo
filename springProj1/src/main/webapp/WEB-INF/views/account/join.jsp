<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원 가입</title>
	<jsp:include page="/WEB-INF/views/module/default_js_css.jsp" flush="false" />
	<script type="text/javascript" src="/static/js/join.js"></script>
</head>

<body onload="regEvent();">
	<header>
		<jsp:include page="/WEB-INF/views/common/top_nav.jsp" flush="false" >
			<jsp:param name="logined" value="${sessionScope.logined}" />
		</jsp:include>
	</header>
	<section class="container mt-3">
		<div class="row justify-content-center">
			<div class="col-sm-6">
				<form action="./join" method="post">
					<h2 class="row mb-3">회원가입</h2>
					<div class="row mb-3">
						<label class="col-sm-3 col-form-label col-form-label-sm">아이디</label>
						<div class="col-sm-10">
							<input class="form-control form-control-sm" type="text" id="id_username" name="username"
							 placeholder="4자 영 소문 or 영 소문+숫자" required>
							<div class=""></div>
						</div>
					</div>
					<div class="row mb-3">
						<label class="col-sm-3 col-form-label col-form-label-sm">패스워드</label>
						<div class="col-sm-10">
							<input class="form-control form-control-sm" type="password" id="id_password" name="password"
							 placeholder="6~20자 영문+숫자+특수문자" required >
							<div class=""></div>
						</div>
					</div>
					<div class="row mb-3">
						<label class="col-sm-3 col-form-label col-form-label-sm">패스워드 확인</label>
						<div class="col-sm-10">
							<input class="form-control form-control-sm" type="password" id="id_passchk" name="passchk" >
							<div class=""></div>
						</div>
					</div>
					<div class="row mb-3">
						<label class="col-sm-3 col-form-label col-form-label-sm">이메일</label>
						<div class="col-sm-10">
							<input class="form-control form-control-sm" type="email" id="id_email1" name="email1" required >
							<div class=""></div>
						</div>
					</div>
					<div class="row mb-3">
						<label class="col-sm-3 col-form-label col-form-label-sm">보조 이메일</label>
						<div class="col-sm-10">
							<input class="form-control form-control-sm" type="email" id="id_email2" name="email2" required >
							<div class=""></div>
						</div>
					</div>
					<div class="row mb-3 ax-12">
						<label class="col-sm-3 col-form-label col-form-label-sm">생년월일</label>
						<div class="col-sm-10">
							<input class="form-control form-control-sm" type="date" id="id_birthday" name="birthday" required >
							<div class=""></div>
						</div>
					</div>
					<div class="row mb-3">
						<label class="col-sm-10 col-form-label col-form-label-sm"></label>
						<button class="col-sm-2 btn btn-online-primary btn-sm" type="submit" onclick="joinCheck(this.form);">가입</button>
					</div>
				</form>
			</div>
		</div>
	</section>
</body>
</html>