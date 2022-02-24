<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
	<title>일기 수정</title>
	<link rel="stylesheet" type="text/css" href="/static/front-end/css/diaryAdd.css">
	<script src="//cdn.ckeditor.com/4.17.1/full/ckeditor.js"></script>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/views/common/navbar.jsp">
			<jsp:param value="${sessionScope.account }" name="account"/>
		</jsp:include>
	</header>
    
	<form action="/diary/update" method="post" enctype="multipart/form-data">
		<input type="hidden" name="dno" value="${data.dno }">
		<input type="hidden" name="mid" value="${data.mid }">
		<table class="board_container">
		    <thead>
		        <tr>
		            <th>일기 수정</th>
		        </tr>
		    </thead>
		    <tbody>
		    	<tr class="content_title">
		    		<td>
		    			<input type="text" name="username" value="${sessionScope.account.username }" readonly>
		    			<input type="text" name="title" value="${data.title }">
		    		</td>
		    	</tr>
		        <tr class="board_file">
		            <td>
		                <label for="File"></label>
		                <input type="file" id="File" name="uploadfile" accept="image/gif, image/jpeg, image/png" required>
		            </td>
		        </tr>
		        <tr class="board_content">
		            <td>
		                <textarea class="writebar" id="editor1" name="content" required>${data.content }</textarea>
						<script type="text/javascript">
							CKEDITOR.replace("editor1", {
								toolbarGroups: [
									{"name": "basicstyles", "groups": ["basicstyles"]},
									{"name": "links", "groups": ["links"]},
									{"name": "paragraph", "groups": ["list", "blocks"]}
								]
							});
						</script>
		            </td>
		        </tr>
		    </tbody>
		</table>
		<div class="list_btn_wrap">
		    <div class="btn_style">
		        <button type="button" class="btn_cancle" onclick="history.back();">취소</button>
		        <button type="submit" class="btn_save">수정</button>
		    </div>
		</div>
	</form>
	
	<footer>
		<jsp:include page="/WEB-INF/views/common/footer.jsp" />
	</footer>
</body>
</html>
