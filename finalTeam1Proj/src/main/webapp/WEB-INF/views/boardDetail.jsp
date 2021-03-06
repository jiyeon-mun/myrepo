<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Boarddetail</title>
	<link rel="stylesheet" type="text/css" href="/static/front-end/css/boardDetail.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" integrity="sha512-9usAa10IRO0HhonpyAIVpjrylPvoDwiPUiKdWk5t3PyolY1cOd4DSE0Ga+ri4AuTroPR5aQvXU9xC6qOPnzFeg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
   
</head>

 <script type="text/javascript">
    	function sendGood() {
    		$.ajax({
    			url:  "/board/good",
    			type: "get",
    			dataType: "json",
    			data: {
    				bno: ${data.bno},
    				next: "/board/detail"
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
    		
    	function sendBad() {
    		$.ajax({
    			url:  "/board/bad",
    			type: "get",
    			dataType: "json",
    			data: {
    				bno: ${data.bno},
    				next: "/board/detail"
    			},
    			success: function(data) {
    				if(data.state === "success") {
    					document.getElementById("bcnt").innerText = data.bcnt
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
	<div class="user_name">
		<c:if test="${not empty sessionScope.account}">
			<input type="hidden" name="mid" value="${sessionScope.account.mid }">
			<h4>${sessionScope.account.username} ??? ????????? ???.</h4>
		</c:if>
	</div>
	    <table class="board_container">
	        <thead>
	            <tr>
	                <th colspan="11">${data.title}</th>
	            </tr>
	        </thead>
	        <tbody>
	            <tr class="board_category">
	                <td colspan="11">
	                    <input type="text" readonly value="${data.catname}">
	                </td>
	                
	            </tr>
	            <tr class="board_info">
	                <td width="6%">?????????</td>
	                <td width="6%" style="text-align: left;">${data.username}</td>
	                <td width="6%">?????????</td> 
	                <td width="6%">${data.vcnt}</td>
	                <td width="4%"><button type="button" onclick="sendGood();"><i class="fa-regular fa-thumbs-up"></i></button></td>
	                <td width="4%" id = "gcnt">${data.gcnt}</td>
	                <td width="5%"><button type="button" onclick="sendBad();"><i class="fa-regular fa-thumbs-down"></i></button></td>
	                <td width="4%" id = "bcnt">${data.bcnt}</td>
	                <td></td>
	                <td width="6%">?????????</td>
	                <td width="12%">${data.writeDate}</td>
	            </tr>
	            
	            <tr class="board_content">
	                <td colspan="11">
	                	<img alt="img" src="${upload.fileUrl}">
	                    <!-- <textarea style="width: 100%; border: 0; resize: none;">
	                        ???????????????.</textarea>-->${data.content}</td>
	            </tr>
	        </tbody>
	    </table>
        <div class="list_btn_wrap" ><!-- class="btn_style" -->
            <button type="button" class="btn_cancle raise" onclick="location.href='/board/list'">??????</button>
            <button type="button" class="btn_save raise" onclick="location.href='/board/update?bno=${data.bno}'">??????</button>
         <form action="/board/delete" method="post">
         	<input type="hidden" name="bno"	value="${data.bno}">
            <button type="submit" class="btn_delete raise">??????</button>
         </form>
        </div>
    <!-- footer -->
    <footer>
		<jsp:include page="/WEB-INF/views/common/footer.jsp" />
	</footer>
</body>
</html>
</html>