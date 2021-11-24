<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>file upload test</title>
</head>
<body>                                   <!-- 파일업로드 필수 속성 -->
	<form action="/upload" method="post" enctype="multipart/form-data" >
		<div>
			<input type="text" name="title" > <!-- 텍스트 전송 -->
		</div>
		<div>
			<input type="file" name="uploadFile" > <!-- 파일 전송 -->
			<%
				if(request.getAttribute("error")!=null) {
			%>
				<label><%=(String)request.getAttribute("error") %></label>
			<%
				}
			%>
		</div>
		<div>
			<button type="submit">전송</button>
		</div>
	</form>
</body>
</html>