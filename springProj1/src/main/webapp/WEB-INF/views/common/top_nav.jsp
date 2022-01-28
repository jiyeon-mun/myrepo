<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">Navbar</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item">
					<c:url var="home_url" value="/" />
					<a class="nav-link" href="${home_url }">Home</a>
				</li>
				<li class="nav-item">
					<c:url var="guest_url" value="/guestbook" />
					<a class="nav-link" href="${guest_url }">방명록</a>
				</li>
				<li class="nav-item">
					<c:url var="board_url" value="/board" />
					<a class="nav-link" href="${board_url }">게시판</a>
				</li>
			</ul>
			<div class="d-flex">
				<ul class="navbar-nav">
				<c:choose>
					<c:when test="${param.logined }">
						<li class="nav-item">
							<c:url var="info_url" value="/account/info"></c:url>
							<a class="nav-link" href="${info_url }">내 정보</a>
						</li>
						<li class="nav-item">
							<c:url var="logout_url" value="/account/logout"></c:url>
							<a class="nav-link" href="${logout_url }">로그아웃</a>
						</li>
					</c:when>
					<c:otherwise>
						<li class="nav-item">
							<c:url var="join_url" value="/account/join"></c:url>
							<a class="nav-link" href="${join_url }">회원가입</a>
						</li>
						<li class="nav-item">
							<c:url var="login_url" value="/account/login"></c:url>
							<a class="nav-link" href="${login_url }">로그인</a>
						</li>
					</c:otherwise>
				</c:choose>
				</ul>
			</div>
		</div>
	</div>
</nav>
