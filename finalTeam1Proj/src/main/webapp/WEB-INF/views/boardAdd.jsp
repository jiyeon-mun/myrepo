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
    <link rel="stylesheet" type="text/css" href="/static/front-end/css/haf.css">
    <title>boardwrite</title>
    <style>

@font-face {
		  font-family: "Cafe24Oneprettynight";
		  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.1/Cafe24Oneprettynight.woff")
		    format("woff");
		  font-weight: normal;
		  font-style: normal;
		}
		
		@font-face {
    font-family: 'KyoboHandwriting2020A';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2112@1.0/KyoboHandwriting2020A.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
		
		
		.user_name {
			font-size: 18px;
			width: 1140px;
			margin: 0 auto;
		}
		
		/* 선택창 */
		
		/* 제목입력 */
		body {
		  margin: 0;
		  padding: 0;
		  font-family: "Cafe24Oneprettynight";
		}
		
		.board_container {
		  width: 80vw;
		  margin: 0 auto;
		  margin-top: 30px;
		}
		
		thead {
		  text-align: left;
		  font-size: 24px;
		}
		
		thead tr th {
		  padding-bottom: 10px;
		  border-bottom: 1px solid black;
		}
		
		.board_category {
		  float: left;
		  margin: 8px 0;
		}
		
		.board_category td input {
			width: 450px;
			border: none;
			border-bottom: 1px solid black;
		}
		
		tbody tr:nth-child(2) td {
		  border-collapse: collapse;
		}
		
		tbody > .board_content {
		  text-align: left;
		  vertical-align: top;
		  height: 220px;
		  min-height: 300px;
		}
		
		tbody > .board_content td textarea {
		  width: 99%;
		  height: 220px;
		  border: 1px solid black;
		  resize: none;
		}
		
		@media screen and (max-width: 820px) {
		  .board_info td {
		    width: 10vw;
		  }
		}
		
		/* button */
		
		.list_btn_wrap {
		  width: 80vw;
		  margin: 0 auto;
		  display: flex;
		  justify-content: flex-end;
		  margin-bottom: 10px;
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
    
    </style>
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
    <form action="/board/add" method="post" enctype="multipart/form-data">
	    <input type="hidden" name="mid" value="${sessionScope.account.mid}"> <!-- name="userid" -->
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
	                    placeholder="제목을 입력해 주세요" value="${param.title}">
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
                		<textarea class="writebar" id="editor1" name="content" required>${param.content}</textarea>
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
	        <%-- <td>
	                    <textarea class="writebar" name="content" rows="10"
	                    placeholder="내용을 입력해 주세요">${param.content}</textarea>
	                </td> --%>
	    </table>
		<div class="btn_style">
        	<div class="list_btn_wrap">
	            <button type="submit" class="btn_save">저장하기</button>
	            <button type="button" class="btn_cancle" onclick="location.href='/board/list'">목록</button>
	            <button type="button" class="btn_cancle" onclick="history.back();">취소</button>
            </div>
    	</div>
    </form>
    
   <!--  <script type="text/javascript">
	$(function(){
	   
	   // 이미지 업로드시 썸네일(미리보기) 
	   var file = document.getElementById('image');
	   file.onchange = function(e) {
	      var reader = new FileReader();
	      var container = document.getElementById("image_container");
	      reader.readAsDataURL(e.target.files[0]);
	      reader.onload = function(e) {
	         $("img:first").remove();
	         var img = document.createElement("img"); 
	         img.setAttribute("src", e.target.result);
	         img.style.width ="20%";
	         img.style.height ="20%";
	         container.appendChild(img);
	      }
	   }
	});
	</script> -->

    <footer>
		<jsp:include page="/WEB-INF/views/common/footer.jsp" />
	</footer> 
</body>
</html>