<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%!
	private int num = 10;
	private Random rand = new Random();
%>
<!DOCTYPE html>
<html>
<head lang="ko">
<meta charset="UTF-8">
<title>First JSP</title>
</head>
<body>
	<%@ include file="./module/header.jsp" %> <!-- 상대경로 -->
	<p>
	<%-- 스크립트 태그 표현식 
		<%=num %>
	--%>
		<%= rand.nextInt(10) %>
	</p>
	<p>
		<%
			// 스크립틀릿 안의 주석은 기본 자바 주석
			if(rand.nextInt(10) % 2 == 0) {
				out.print("짝수");
			} else {
				out.print("홀수");
			}
		%>
	</p>
	<ul>
		<%
			for(int i=1; i<10;i++) {
				out.print("<li>"+i+"</li>");
			}
		%>
	</ul>
	
	<ul>
		<li><a href="/account/index.html">회원가입</a></li>
		<li><a href="/guest">방명록</a></li>
		<li><a href="/bookmark">북마크</a></li>
	</ul>
</body>
</html>