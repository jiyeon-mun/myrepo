<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Board_list</title>
<link rel="stylesheet" type="text/css" href="/static/front-end/css/haf.css">
<style>
@font-face {
	font-family: "Cafe24Oneprettynight";
	src:
		url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.1/Cafe24Oneprettynight.woff")
		format("woff");
	font-weight: normal;
	font-style: normal;
}

.user_name {
	font-size: 18px;
	width: 1040px;
	margin: 0 auto;
}

body {
	margin: 0;
	padding: 0;
	font-family: "Cafe24Oneprettynight";
}

.list_wrap {
	width: 1040px;
	margin: 0 auto;
	min-height: 300px;
}

.category_wrap {
	margin: 30px auto;
}

table {
	width: 1040px;
	margin: 0 auto;
	justify-content: space-between;
	border-spacing: 0 5px;
}

tbody {
	text-align: center;
}

button {
	display: inline-block;
	padding: 7.1px 30px;
	border: 1px solid #dfdfdf;
	border-radius: 5px;
	background-color: #ffffff;
	text-align: center;
	cursor: pointer;
	font-family: "Cafe24Oneprettynight";
}

button:hover {
	background-color: #ffc6a6;
	color: #ffffff;
}

select {
	padding: 5px;
	font-family: "Cafe24Oneprettynight";
}

.radio_btn input[type="radio"] {
	display: none;
}

.radio_btn input[type="radio"]+span {
	display: inline-block;
	padding: 10px 30px;
	border: 1px solid #dfdfdf;
	border-radius: 5px;
	background-color: #ffffff;
	text-align: center;
	cursor: pointer;
}

.radio_btn input[type="radio"]:checked+span {
	background-color: #ffc6a6;
	color: #ffffff;
}

.search {
	font-family: "Cafe24Oneprettynight";
}

.search_wrap {
	display: flex;
	justify-content: flex-end;
	margin-bottom: 10px;
}

.search_wrap select, input {
	margin: 0 5px;
	padding: 5px 2px;
}

.search_wrap select {
	width: 90px;
}

.search_wrap .search_input {
	width: 200px;
}
.table_content {
   line-height : 30px 
   }
   
.table_header th {
	font-size: 18px;
	font-weight: bolder;
}

.table_content td:nth-child(3) {
	text-align: left;
}

.table_content th, td {
	border-bottom: 1px solid black;
	border-top: 1px solid black;
}

.table_content:hover {
	box-shadow: 1px 2px 5px silver inset;
}

.radio_div {
	width: 1040px;
}

.key_div {
	width: 1040px;
	margin: 10px 0;
	display: flex;
	justify-content: flex-start;
}

.key_div .write_btn_wrap {
	display: flex;
	justify-content: flex-end;
	width: 690px;
}
</style>
</head>
<body>
	<!-- header -->
	<header>
		<jsp:include page="/WEB-INF/views/common/navbar.jsp">
			<jsp:param value="${sessionScope.account }" name="account"/>
		</jsp:include>
	</header>
	<div class="user_name">
		<c:if test="${not empty sessionScope.account}">
			<input type="hidden" name="mid" value="${sessionScope.account.mid }">
			<h4>${sessionScope.account.username} 님 로그인 중.</h4>
		</c:if>
	</div>
	<!-- 게시판 목록 페이지 -->
	<!-- 검색 테스트용 -->

	<div class="board_form">
		<form class="radio_form" action="list" method="get">
			<div class="category_wrap">
				<div class="radio_div" style="margin: 0 auto;">
					<label class="radio_btn"> <input type="radio"
						name="options" id="option1" value="1" autocomplete="off">
						<span>의료/건강</span>
					</label> <label class="radio_btn"> <input type="radio"
						name="options" id="option2" value="2" autocomplete="off">
						<span>감동</span>
					</label> <label class="radio_btn"> <input type="radio"
						name="options" id="option3" value="3" autocomplete="off">
						<span>입양공고</span>
					</label> <label class="radio_btn"> <input type="radio"
						name="options" id="option4" value="4" autocomplete="off">
						<span>재미</span>
					</label> <label class="radio_btn"> <input type="radio"
						name="options" id="option5" value="5" autocomplete="off">
						<span>상품평</span>
					</label>
					<div class="key_div">
						<select name="keynum" class="">
							<option value="1">제목</option>
							<option value="2">작성자</option>
						</select>
						<input class="search" type="text" name="keyword"
							style="width: 180px;" class="" placeholder="검색어입력">
						<button class="radio_btn" type="submit" value="검색">검색</button>
						<div class="write_btn_wrap">
							<button class="radio_btn" type="button" onclick="location.href='/board/add'">글쓰기</button>
						</div>
					</div>
				</div>
				
				<table class="list_table">
					<colgroup>
						<col width="5%">
						<col width="15%">
						<col width="50%">
						<col width="20%">
						<col width="5%">
						<col width="5%">
					</colgroup>
					<thead>
						<tr class="table_header">
							<th>번호</th>
							<th>말머리</th>
							<th>제목</th>
							<th>작성자</th>
							<th>조회수</th>
							<th>추천</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="data" items="${datas}">
							<tr class="table_content">
								<td>${data.bno}</td>
								<td>${data.catname}</td>
								<td><a href="/board/detail?bno=${data.bno}">${data.title}</a></td>
								<td>${data.username}</td>
								<td>${data.vcnt}</td>
								<td>${data.gcnt}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</form>
	</div>

	<footer>
		<jsp:include page="/WEB-INF/views/common/footer.jsp" />
	</footer>
</body>
</html>