<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="javax.servlet.http.Cookie" %>
<!DOCTYPE html>
<html>
<head lang="ko">
<meta charset="UTF-8">
<title>First JSP</title>
</head>
<%
	Cookie[] cookie = request.getCookies();
	boolean logined = false;
	String username = "";
	
	if(cookie != null) {
		for(Cookie c: cookie) {
			if(c.getName().equals("login_name")) { // 만든 쿠키명과 매치하는지 비교
				logined = true;
				username = c.getValue(); // 해당 쿠키값 가져오기
			}
		}
	}
%>
<body>	
	<ul>
		<li><a href="/account/join">회원가입account</a></li>
		<li><a href="/guest">방명록</a></li>
		<li><a href="/bookmark">북마크</a></li>
		<li><a href="/upload">파일업로드</a></li>
		
		<%
			if(logined) {
		%>
			<!-- 로그인 상태가 맞는 경우 -->
			<li><a href="info">내정보</a></li>
			<li><a href="/logout">로그아웃</a></li>
		<% } else { %>
			<!-- 로그인 상태가 아닌 경우 -->
			<li><a href="/login">로그인</a></li>
			<li><a href="/join">회원가입join</a></li>
		<% } %>
	</ul>
	
	<%
		if(logined) {
	%>
		<h1>Cookie -> <%=username %> 님 환영합니다.</h1>
	<%
		}
	%>
	
	<%
		if(session.getAttribute("login_name") != null) {
	%>					<!-- 다운캐스팅: 객체를 문자열로 -->
		<h1>Session -> <%=(String)session.getAttribute("login_name") %> 님 환영합니다.</h1>
	<%
		}
	%>
</body>
</html>