<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>내 일기 목록</title>
	<link rel="stylesheet" type="text/css" href="/static/front-end/css/diaryList.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" integrity="sha512-9usAa10IRO0HhonpyAIVpjrylPvoDwiPUiKdWk5t3PyolY1cOd4DSE0Ga+ri4AuTroPR5aQvXU9xC6qOPnzFeg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	
</head>
<script type="text/javascript">
function insertPopup() {
	window.name="diaryList.jsp";
	window.open("/pet/add", "insert", "width=500px,height=700px,toolbars=no,scrollbars=no");
}
</script>

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
	
	 <div class="pat_pro">
	 	<c:forEach var="pet" items="${pets }">
	        <div class="pat_card">
	            <div class="pat_img">
	                <div class="pat_face">
	                    <img alt="petImg" src="${pet.fileurl }">
	                </div>
	            </div>
	            <div class="pat_info">
	            	<c:if test="${pet.mid eq sessionScope.account.mid }">
		            	<form class="pat_delete" action="/pet/delete" method="post">
		            		<input type="hidden" name="pno" value="${pet.pno }">
		            		<button type="submit"style="border:none; background-color:white;"><i class="fa-solid fa-xmark"></i></button>
	                	</form>
                	</c:if>
	                <div class="pat_name">
	                    <span>${pet.petname }</span><br>
                    	<input type="hidden" name="sid" value="${pet.sid }">
	                    <c:choose>
	                    	<c:when test="${pet.sid == 1 }"><span>강아지</span> | </c:when>
	                    	<c:when test="${pet.sid == 2 }"><span>고양이</span> | </c:when>
	                    	<c:when test="${pet.sid == 3 }"><span>기타</span> | </c:when>
	                    </c:choose>
	                    <c:choose>
                    		<c:when test="${pet.sex eq 'f'.charAt(0) }"><span>암컷</span></c:when>
                    		<c:when test="${pet.sex eq 'm'.charAt(0) }"><span>수컷</span></c:when>
                    	</c:choose>
	                </div>
	                <div class="pat_birth">
	                   ${pet.birthday } (${pet.age }살)
	                </div>
	                
	            </div>
	        </div>
        </c:forEach>
        <div class="card_add">
            <a href="javascript:insertPopup();">
            	<i class="fas fa-plus-circle"></i>
            </a>
        </div>
    </div>
    
	<div class="btn_style">
		<button type="button" class="write_btn"onclick="location.href='/diary/add'">글쓰기</button>
	</div>
	
	<div class="content">
    	<c:set var="page" value="${empty param.page ? 1 : param.page }" />
    	<c:forEach var="num" begin="${(page - 1) * 9 }" end="${page * 9 - 1 }" varStatus="status">
	        <div class="content_wrap">
	            <table class="content_table">
	                
	                <tbody class="content_body">
	                    <tr>
	                        <td colspan="8" class="body_img">
		                        <a href="/diary/detail?dno=${datas[num].dno }">
				 					<img src="${datas[num].fileurl }" width=100% height=100%>
				 				</a>
	                        </td>
	                    </tr>
	                    <tr>
	                        <td colspan="8" class="body_writer">${datas[num].username }</td>
	                    </tr>
	                    <tr>
	                        <td colspan="8" class="body_text">${datas[num].title }</td>
	                    </tr>
	                </tbody>
	                <tfoot>
	                    <tr class="content_foot">
	                        <td></td>
	                        <td></td>
	                        <td></td>
	                        <td></td>
	                        <td></td>
	                        <td></td>
	                        <td></td>
	                        <td><i class="far fa-heart"></i>&nbsp; &nbsp;${datas[num].gcnt }</td>
	                    </tr>
	                </tfoot>
	            </table>
	        </div>
        </c:forEach>
    </div>
	
	<div style="clear:both;" class="diary_paging">
		<div class="paging_wrap">
			<div>총 ${datas.size() } 개의 일기들</div>
			<div class="paging_number">
				<c:forEach var="page" begin="0" end="${datas.size() / 9 }" varStatus="loop">
					<c:if test="${not loop.last }">
						<span><a href="/diary/list?page=${page+1}">${page+1 }</a></span>
					</c:if>
					<c:if test="${loop.last }">
						<c:if test="${datas.size() mod 9 ne 0 }">
							<span><a href="/diary/list?page=${page+1}">${page+1 }</a></span>
						</c:if>
					</c:if>
				</c:forEach>
			</div>
		</div>
	</div>
	
	<footer>
		<jsp:include page="/WEB-INF/views/common/footer.jsp" />
	</footer>
</body>
</html>
