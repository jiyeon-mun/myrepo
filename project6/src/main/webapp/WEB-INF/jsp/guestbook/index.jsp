<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.web.guestbook.model.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>방명록</title>
	<script type="text/javascript" src="/static/js/guestScript.js"></script>
</head>
<body>
	<header>
		<h1>네비게이션 메뉴가 위치 할 곳</h1>
	</header>

	<section>
		<section>	  <!-- 상대 경로 -->
			<form action="./guest" method="post"> <!-- 양식 작성 후 제출 -->
				<div>
				<%
					GuestBookDTO dto = new GuestBookDTO(); // GuestBookDTO 클래스 타입의 dto 객체 생성
					// getAttribute(): setAttribute() 속성을 통한 설정이 없으면 무조건 null 반환, 속성명 init의 속성값을 반환; 반환형이 Object로 형변환 필수
					if(request.getAttribute("init") != null) { // setAttribute()에서 설정된 속성명 init의 속성값이 null이 아닌 경우 
						dto = (GuestBookDTO)request.getAttribute("init"); // 다운캐스팅;GuestBookDTO 클래스 타입으로 형변환 (? 반환형이 Object로 형변환 필수)
					}
				%>						
					<textarea name="context"><%=dto.getContext() %></textarea>
				</div>
				<div>
					<button type="submit">작성</button>
				</div>
			</form>
		</section>
		<section>
			<table>
				<thead>
					<tr>
						<th>번호</th>
						<th>IP주소</th>
						<th colspan="2">내용</th>
						<th>날짜</th>
					</tr>
				</thead>
				<tbody>
					<%
						List<GuestBookDTO> datas = (List<GuestBookDTO>) request.getAttribute("datas");
						for(GuestBookDTO data: datas) {
					%>
					<tr>
						<td><%=data.getId() %></td>
						<td><%=data.getIpaddr() %></td>
						<td><%=data.getContext() %></td>
						<td>									<!-- <td></td> -->
							<button onclick="guestModify(this.parentElement);">수정</button>
							<form action="./guest/delete" method="post">
								<input type="hidden" name="id" value=<%=data.getId() %>>
								<button type="submit">삭제</button>
							</form>
						</td>
						<td><%=data.getDate() %></td>
					</tr>
					<%		
						}
					%>
				</tbody>
			</table>
		</section>
	</section>

	<footer>
		<h2>사이트 정보 영역</h2>
	</footer>
</body>
</html>