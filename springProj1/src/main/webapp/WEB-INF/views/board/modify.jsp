<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시글 수정</title>
	<jsp:include page="/WEB-INF/views/module/default_js_css.jsp" flush="false" />
	<script src="https://cdn.ckeditor.com/ckeditor5/31.1.0/classic/ckeditor.js"></script>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/views/common/top_nav.jsp" flush="false" >
			<jsp:param name="logined" value="${sessionScope.logined}" />
		</jsp:include>
	</header>
	<section class="container">
		<h3>게시글 수정</h3>
		<form action="/board/modify" method="post">
			<div class="card text-dark bg-light">
				<div class="card-body">
					<input type="hidden" name="id" value="${data.id}">
					<input type="hidden" name="memid" value="${sessionScope.account.id}">
					<h5 class="row card-title">
						<input class="form-control" type="text" name="title" value="${data.title}">
					</h5>
					<div class="row mb-3">
						<input class="form-control" type="text" name="writer"
						 value="${sessionScope.account.username}" readonly>
					</div>
					<div>
						<textarea id="ckeditor" rows="10" name="content">${data.content}</textarea>
					</div>
				</div>
				<div class="card-footer text-end">
					<button class="btn btn-outline-primary" type="submit">저장</button>
					<button class="btn btn-outline-primary" type="reset" onclick="history.back()">취소</button>
				</div>
			</div>
		</form>
	</section>
	<script type="text/javascript">
		ClassicEditor.create(document.querySelector("#ckeditor"), {
			toolbar: {
				items: [
					'heading', '|',
					'bold', 'italic', '|',
					'undo', 'redo', '|',
					'numberedList', 'bulletedList', '|',
					'insertTable', '|',
					'outdent', 'indent', '|',
					'uploadImage'
				]
			}
		})
	</script>
</body>
</html>