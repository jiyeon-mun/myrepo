<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" type="text/css" href="/static/front-end/css/haf.css">
</head>
<body>
	<nav class="navbar">
        <div class="navbar_logo">
            <img src='http://drive.google.com/uc?export=view&id=14d2f4JHBjotnnV-DcNWY-eHQDkKSbW2p' /><br>
        </div>
        <div class="menu_wrap">
            <ul class="navbar_menu">
                <li><a href="/">MAIN</a></li>
                <li><a href="/diary/list">DIARY</a></li>
                <li><a href="/board/list">BOARD</a></li>
                <c:choose>
                	<c:when test="${empty sessionScope.account}">
                		<li><a href="/join">ACCOUNT</a></li>
               			<li><a href="/login">LOGIN</a></li>
                	</c:when>
                	<c:otherwise>
                		<li><a href="/memInfo">INFO</a></li>
               			<li><a href="/logout">LOGOUT</a></li>
                	</c:otherwise>
                </c:choose>
            </ul>
        </div>
    </nav>
</body>

</html>
	