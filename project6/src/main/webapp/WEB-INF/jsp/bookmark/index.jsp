<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.web.bookmark.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bookmark</title>
</head>
<body>
	<section>
		<form action="./bookmark" method="post">
			<!-- 북마크 등록 작업 -->
			<div>
				<!-- 등록 실패 시 입력내용을 초기값으로 현재페이지 재로드
					(페이지 로드 시 에러가 발생하는데 아래의 init 속성은 doPost()에서 생성되었기 때문에
					 페이지 로드하는 doGet()에서는 존재하지 않는 속성으로 null값을 받아오면서 NullPointerException 발생
					 ? Controller의 doPost()를 실행하지 않은 상태에서 그 안의 값을 요구하므로) -->
				<%
					BookMarkDTO dto = new BookMarkDTO();
					if(request.getAttribute("init") != null) {
						// 다운캐스팅(? getAttribute()의 반환타입은 Object형)
						dto = (BookMarkDTO)request.getAttribute("init");
					}
				%>
				<input type="text" name="alias" placeholder="별칭 입력">
				<%=dto.getAlias() %>
				<input type="text" name="url" placeholder="url 주소 입력">
				<%=dto.getUrl() %>
			</div>
			<div>
				<button type="submit">등록</button>
			</div>
		</form>
	</section>
	
	<section>
		<ul>
			<li><a href="#">별칭1</a></li>
			<li><a href="#">별칭2</a></li>
			<li><a href="#">별칭3</a></li>
			<li><a href="#">별칭4</a></li>
		</ul>
	</section>
</body>
</html>