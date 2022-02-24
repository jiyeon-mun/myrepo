<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="//cdn.ckeditor.com/4.17.1/full/ckeditor.js"></script>
    <link rel="stylesheet" href="/static/front-end/css/boardUpdate.css">
    <title>boardupdate</title>

</head>
<body>
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

<!--게시글 작성-->
    <form action="/board/update" method="post" enctype="multipart/form-data">
	    <table class="board_container">
	        <thead>
	            <tr>
	                <th>게시글 작성</th>
	            </tr>
	        </thead>
	        <tbody>
	            <tr class="board_category">
	                <td>
	                    <select class="selectbar" name="catid">
	                        <option value="">선택하기</option>
	                        <option value="1">의료/건강</option>
	                        <option value="2">감동</option>
	                        <option value="3">입양공고</option>
	                        <option value="4">재미</option>
	                        <option value="5">상품평</option>
	                    </select>
	                    <input type="text" class="titlebar" name="title" id="title" 
	                    placeholder="제목을 입력해 주세요" value="${empty data.title ? param.title : data.title}">
	                </td>
	                
	            </tr>
	            <tr class="board_file">
	                <td>
	                    <label for="File"></label>
	                    <input type="file" name="uploadfile" id="File" accept="image/*">
	                </td>
	            </tr>
	            <tr class="board_content">
	            	<td>
                		<textarea class="writebar" id="editor1" name="content" required>${empty data.content ? param.content : data.content}</textarea>
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
	            
	                <%-- <td>
	                    <textarea class="writebar" rows="10" name="content"
	                    placeholder="내용을 입력해 주세요">${empty data.content ? param.content : data.content}</textarea>
	                </td> --%>
	            </tr>
	        </tbody>
	    </table>
	    <input type="hidden" name="bno" value="${empty data.bno ? param.bno : data.bno}"> 
	    <input type="hidden" name="mid" value="${empty data.mid ? param.mid : data.mid}"> <!-- name="userid" -->
        <div class="btn_style">
        	<div class="list_btn_wrap">
	            <button type="button" class="btn_cancle" onclick="history.back();">취소</button>
	            <button type="button" class="btn_cancle" onclick="location.href='/board/list'">목록</button>
	            <button type="submit" class="btn_save">수정하기</button>
            </div>
        </div>
    </form>
    <footer>
		<jsp:include page="/WEB-INF/views/common/footer.jsp" />
	</footer>

</body>
</html>