<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시판 상세</title>
	<jsp:include page="/WEB-INF/views/module/default_js_css.jsp" flush="false" />
	<script src="https://kit.fontawesome.com/16a2fd4cc5.js" crossorigin="anonymous"></script>
</head>
<script type="text/javascript">
// 비동기 방식으로 추천/비추천 증가
function ajaxSendGood() {
	$.ajax({
		url: "/board/gcnt",
		type: "get",
		dataType: "json",
		data: {
			id: ${data.id},
			next: "/board/detail"
		},
		success: function(data) {
			if(data.state === "success") {
				document.getElementById("gcnt").innerText = data.cnt
			} else if(data.state === "fail") {
				alert(data.msg);
			} else if(data.state === "redirect") {
				location.href = data.url
			}
		}
	});
}

function ajaxSendBad() {
	$.ajax({
		url: "/board/bcnt",
		type: "get",
		dataType: "json",
		data: {
			id: ${data.id},
			next: "/board/detail"
		},
		success: function(data) {
			if(data.state === "success") {
				document.getElementById("bcnt").innerText = data.cnt
			} else if(data.state === "fail") {
				alert(data.msg);
			} else if(data.state === "redirect") {
				location.href = data.url
			}
		}
	});
}
</script>
<body>
	<header>
		<jsp:include page="/WEB-INF/views/common/top_nav.jsp" flush="false" >
			<jsp:param name="logined" value="${sessionScope.logined}" />
		</jsp:include>
	</header>
	<section class="container">
		<h3>게시판 글 상세보기</h3>
		<div class="card text-dark bg-light">
			<div class="card-header">
				<h3>${data.title}</h3>
			</div>
			<div class="card-body">
	            <h6 class="card-subtitle text-muted mb-4">
	            	<i class="fas fa-list"></i> ${data.id} <!-- 게시글 번호 -->
	                 ·
	                <i class="far fa-user"></i> ${data.memname}
	                 ·
	                <i class="far fa-eye"></i> ${data.vcnt}
	                 ·
	                <i class="far fa-thumbs-up"></i> <span id="gcnt">${data.gcnt }</span>
	                 ·
	                <i class="far fa-thumbs-down"></i> <span id="bcnt">${data.bcnt }</span>
	                <br>
	                <i class="far fa-clock"></i> ${data.createdate}
	            </h6>
	            <p class="card-text">${data.content}</p>
	            <div>
	            	파일 : <img alt="img" src="${upload.fileUrl }">${upload.fileName }
	            </div>
			</div>
			<div>
				<button type="button" onclick="ajaxSendGood();">추천</button>
				<button type="button" onclick="ajaxSendBad();">비추천</button>
			</div>
			<div class="card-footer text-end">
				<button class="btn btn-outline-primary" onclick="location.href='/board'">목록</button>
				<c:if test="${data.memid eq sessionScope.account.id}">
					<button class="btn btn-outline-success" onclick="location.href='/board/modify?id=${data.id}'">수정</button>
					<button class="btn btn-outline-danger" onclick="location.href='/board/delete?id=${data.id}'">삭제</button>
				</c:if>
			</div>
		</div>
	</section>
</body>
</html>