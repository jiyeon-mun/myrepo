<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시판 목록</title>
	<jsp:include page="/WEB-INF/views/module/default_js_css.jsp" flush="false" />
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/views/common/top_nav.jsp" flush="false" >
			<jsp:param name="logined" value="${sessionScope.logined}" />
		</jsp:include>
	</header>
	
	<section class="container">
		<div class="text-end">
			<c:url var="add_url" value="/board/add" />
			<button type="button" class="btn btn-outline-dark btn-sm" onclick="location.href='${add_url}'">글쓰기</button>
		</div>
		<div>
			<table class="table table-hover table-striped">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
						<th>좋아요</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${datas }">
						<tr>
							<td>${item.id }</td>
							<td><a href="/board/detail?id=${item.id }">${item.title }</a></td>
							<td>${item.memname }</td>
							<td>${item.createdate }</td>
							<td>${item.vcnt }</td>
							<td>${item.gcnt }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="row">
			<form method="get" action="/board">
				<table class="pull-right">
					<tr>
						<td><select class="form-control" id="search_type">
								<option value="title">제목</option>
								<option value="writer">작성자</option>
						</select></td>
						<td><input type="text" class="form-control"
							placeholder="검색어 입력" name="val" maxlength="100"></td>
						<td><button type="button" class="btn btn-success" onclick="search(this.form);">검색</button></td>
					</tr>
				</table>
			</form>
			<script type="text/javascript">
				function search(f) {
					f.val.name = f.search_type.value;
					f.submit();
				}
			</script>
		</div>
	</section>
</body>
</html>