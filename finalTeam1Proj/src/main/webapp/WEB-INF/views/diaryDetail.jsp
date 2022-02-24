<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>일기 상세보기</title>
	<link rel="stylesheet" type="text/css" href="/static/front-end/css/haf.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
	<style>
		@font-face {
  font-family: "Cafe24Oneprettynight";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.1/Cafe24Oneprettynight.woff")
    format("woff");
  font-weight: normal;
  font-style: normal;
}

.user_name {
	font-size: 18px;
	width: 1140px;
	margin: 0 auto;
}

body {
  margin: 0;
  padding: 0;
  font-family: "Cafe24Oneprettynight";
}

.diary_container {
  width: 45vw;
  margin: 0 auto;
  margin-top: 30px;
  margin-bottom: 30px;
}

.diary_wrap {
  margin: 0 auto;
  border: 1px solid black;
  border-radius: 5px;
  box-shadow: 1px 3px 5px 0px rgba(141, 140, 140, 0.493);
}



table {
  margin: 0 auto;
  border-collapse: collapse;
}

table td {
  text-align: center;
}

table th {
  text-align: left;
  vertical-align: middle;
}

.diary_img td img {
  width: 40vw;
  height: auto;
  border: 1px solid black;
}

.diary_content td {
  height: 200px;
  word-break: break-all;
}

.diary_content td:nth-child(2) {
  vertical-align: bottom;
}

.diary_heart td {
  padding-top: 10px;
}

.diary_heart td i:first-child:hover {
  color: red;
  cursor: pointer;
  transform: scale(1.3);
  transition: all 0.35s;
}

.diary_heart td:nth-child(2) {
  text-align: left;
}

.list_btn td {
  text-align: right;
}

.list_btn td:first-child {
	width: 80px;
}
@font-face {
    font-family: 'KyoboHandwriting2020A';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2112@1.0/KyoboHandwriting2020A.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}

.raise:hover,
.raise:focus {
    box-shadow: 0 0.5em 0.5em -0.4em var(--hover);
    transform: translateY(-0.25em);
    color: #ffa260;
}

button {
    font-family: 'KyoboHandwriting2020A';
    background: papayawhip;
    border: 2px solid;
    line-height: 0.5;
    margin: 0.5em;
    padding: 1em 2em;
    border: 0;
    outline: 0;
    border-radius: 40px 80px;
    color: gray;
    cursor: pointer;
  }
  
  h1 { font-weight: 100; }
  
  code { 
    color: #e4cb58;
    font: inherit;
  }

.list_btn form {
  margin-bottom: 0;
  width: 80px;
  float: right;
  margin-right: 30px;
}

.list_btn form button {
	width: 100%;
}


.reply_container {
  margin-top: 10px;

}

.reply_container .reply_input_form {
 display: flex;
 justify-content: space-between;
 margin: 0 15px;
}

.reply_container input {
 width: 78%;
}

.reply_container .reply_submit_btn {
 width: 15%;
}

.reply_add_wrap {
 width: 90%;
 margin: 0 auto;
}

.reply_content_wrap {
 margin-top: 15px;
}



.reply_content_wrap table td {
 border-bottom: 1px solid black;
 padding: 10px 0;
}


.reply_content_wrap table td:nth-child(3) {
 text-align: left;
}

.reply_content_wrap table td {
 vertical-align: middle;
}

.reply_content_wrap form{
 margin-bottom: 0;
}

@media screen and (max-width: 790px) {
  .diary_reply td button[type="submit"] {
    display: none; /* 창 작아지면 댓글안보일까봐 없앴음. */
  }

  .diary_content td button[type="submit"] {
    width: 50px;
  }
}
		
	</style>

</head>


<script type="text/javascript">
function ajaxSendGood() {
	$.ajax({
		url: "/diary/gcnt",
		type: "get",
		dataType: "json",
		data: {
			dno: ${data.dno},
			next: "/diary/detail"
		},
		success: function(data) {
			if(data.state === "success") {
				document.getElementById("gcnt").innerText = data.gcnt
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
		<jsp:include page="/WEB-INF/views/common/navbar.jsp">
			<jsp:param value="${sessionScope.account }" name="account"/>
		</jsp:include>
	</header>
	<input type="hidden" name="logined" value="${sessionScope.account.mid }" >
	
	<div class="diary_container">
        <div class="diary_wrap">
        	<div class="diary_container">
	            <table>
	                <thead>
	                    <tr>
	                        <th><img src='http://drive.google.com/uc?export=view&id=1Y8jTZ_l2MzC8gpwnPxmMKcjptVq4HS2z' width="50px"/></th>
	                        <th colspan="7">${data.username }</th>
	                    </tr>
	                </thead>
	                <tbody>
	                    <tr class="diary_img">
	                        <td colspan="8">
	                        	<img alt="img" src="${upload.fileurl }" width="800px" height="300px">
	                        </td>
	                        
	                    </tr>
	                    <tr class="diary_heart">
	                        <td width="10%">
	                        	<button type="button" onclick="ajaxSendGood();" style="border:none; background-color:white;"><i class="far fa-heart"></i></button>
	                        </td>
	                        <td id="gcnt">${data.gcnt }</td>
	                        
	                    </tr>
	                    <tr class="diary_content">
	                        <td colspan="8">${data.content }</td>
	                    </tr>
	                    <tr class="list_btn">
	                        <c:if test="${data.mid eq sessionScope.account.mid }">
	                        	<td></td>
	                        	<td></td>
	                        	<td>
	                        		<button type="button" class="raise" onclick="location.href='/diary/update?dno=${data.dno}'">수정</button>
	                        		<form action="/diary/delete" method="post">
										<input type="hidden" name="dno" value="${data.dno }">
										<button type="submit" class="raise">삭제</button>
									</form>
	                        	
	                        	</td>
		                       
		                        
	                        </c:if>
	                    </tr>
	                </tbody>
	            </table>
            </div>
            
            <div class="reply_container">
            	<div class="reply_add_wrap">
					<form action="/diary/comment/add" method="post" class="reply_input_form">
						<c:choose>
							<c:when test="${empty sessionScope.account.mid }"> <!-- 비회원에게 비활성화 -->
								<input type="text" name="content" disabled>
								<input type="hidden" name="dno" value="${data.dno }" disabled>
								<input type="hidden" name="mid">
								<button type="button">등록</button>
							</c:when>
							<c:otherwise>
								<input type="text" name="content" placeholder="댓글을 입력하세요.">
								<input type="hidden" name="dno" value="${data.dno }"> <!-- 댓글이 등록되는 게시글 번호 -->
								<input type="hidden" name="mid" value="${sessionScope.account.mid }"> <!-- 댓글 작성자의 번호 -->
								<button type="submit" class="reply_submit_btn">등록</button>
							</c:otherwise>
						</c:choose>
					</form>
				</div>
				<div class="reply_content_wrap">
					<table>
						<colgroup>
							<col width="13%">
							<col width="60%">
							<col width="12%">
							<col width="15%">
						</colgroup>
						<tbody>
						<c:forEach var="comment" items="${comments }">
							<tr>
								<td style="display:none">${comment.mid }</td>
								<td>${comment.username }</td>
								<td>${comment.content }</td>
								<td>${comment.writedate }</td>
								<td>
									<c:if test="${comment.mid eq sessionScope.account.mid }">
										<form action="/diary/comment/delete" method="post">
											<input type="hidden" name="dno" value="${comment.dno }"> <!-- 댓글이 달린 게시글 번호 -->
											<input type="hidden" name="dcid" value="${comment.dcid }"> <!-- 작성된 댓글 번호 -->
											<input type="hidden" name="mid" value="${comment.mid }"> <!-- 댓글 작성자 번호 -->
											<button type="submit">삭제</button>
										</form>
									</c:if>
								</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
            </div>
        </div>
        
    </div>
    
    <footer>
		<jsp:include page="/WEB-INF/views/common/footer.jsp" />
	</footer>
</body>
</html>
