<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.web.join.model.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원가입</title>
	<script type="text/javascript" src="/static/js/join.js"></script>
</head>
<body>
	<%
		JoinDTO initData = new JoinDTO(); // 로그인 실패 시 패스워드 제외한 나머지 입력란에 기존 입력 내용 초기화한 상태로 페이지 로드
		if(request.getAttribute("initData") != null) {
			initData = (JoinDTO) request.getAttribute("initData");
		}
	%>
	<form action="./join" method="post">
		<div>
			<input type="text" name="username" value="<%=initData.getUsername() %>" placeholder="아이디" required>
		</div>
		<div>
			<input type="password" id="id_pass1" name="password" placeholder="패스워드" required>
		</div>
		<div>
			<input type="password" id="id_pass2" name="password_check" placeholder="패스워드 확인" required>
			<div><label></label></div>
		</div>
		<div>
			<input type="email" name="email" value="<%=initData.getEmail() %>" placeholder="이메일" required>
		</div>
		<div>
			<button type="submit">제출</button>
		</div>
	</form>
</body>
</html>