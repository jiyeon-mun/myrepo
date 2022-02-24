<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>일기 등록</title>
	<link rel="stylesheet" type="text/css" href="/static/front-end/css/diaryAdd.css">
	<script src="//cdn.ckeditor.com/4.17.1/full/ckeditor.js"></script>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/views/common/navbar.jsp">
			<jsp:param value="${sessionScope.account }" name="account"/>
		</jsp:include>
	</header>
	
	<form action="/diary/add" method="post" enctype="multipart/form-data">
		<input type="hidden" name="mid" value="${sessionScope.account.mid }">
		<table class="board_container">
		    <thead>
		        <tr>
		            <th>일기 작성</th>
		        </tr>
		    </thead>
		    <tbody>
		    	<tr class="content_title">
		    		<td>
		    			<input type="text" name="username" value="${sessionScope.account.username }" readonly>
		    			<input type="text" name="title" placeholder="제목을 입력해주세요.">
		    		</td>
		    	</tr>
		    	
		        <tr class="board_file">
		            <td>
		                <label for="File"></label>
		                <input type="file" id="File" name="uploadfile" accept="image/*" required>
		            </td>
		        </tr>
		        <tr class="board_content">
		            <td>
		                <textarea class="writebar" id="editor1" name="content" required></textarea>
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
		        <button type="submit" class="btn_save">저장하기</button>
		        <button type="button" class="btn_cancle" onclick="history.back();">취소</button>
		    </div>
		</div>
	</form>
	
	<footer>
		<jsp:include page="/WEB-INF/views/common/footer.jsp" />
	</footer>
</body>
</html>