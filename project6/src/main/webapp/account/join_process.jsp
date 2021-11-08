<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 진행 결과</title>
</head>
<body>
	<section>
		<h1>회원 가입 진행 결과</h1>
		<%
			request.setCharacterEncoding("UTF-8"); // 한글처리
			
			String username = request.getParameter("username").toLowerCase();
			String password = request.getParameter("password").toLowerCase();
			
			// 유효성 검사 (username)
			// 길이 : 4~16 사이의 문자열 / 문자 종류(옵션) :  소문자, 숫자, 특수문자(_)
			boolean isUsernameValid = true;
            if(username.length() >= 4 && username.length() <= 16) {
                for(int i = 0; i < username.length(); i++) {
                	System.out.println(isUsernameValid);
	                if(username.charAt(i) >= 'a' && username.charAt(i) <= 'z') {
	                	isUsernameValid = true;
	                } else if(username.charAt(i) >= '0' && username.charAt(i) <= '9') {
	                	isUsernameValid = true;
	                } else if(username.charAt(i) == '_') {
	                	isUsernameValid = true;
	                } else {
	                	isUsernameValid = false;
	                }
	                System.out.println(isUsernameValid + "|" + username.charAt(i));
	                if(!isUsernameValid) {
	                	break;
	                }
                }
            } else {
            	isUsernameValid = false;
            }

			// 유효성 검사 (password)
			// 길이 : 4~16 사이의 문자열 / 문자 종류(옵션) :  소문자, 숫자, 특수문자(_)
			boolean isPasswordValid = true;
            if(password.length() >= 4 && password.length() <= 16) {
                for(int i = 0; i < username.length(); i++) {
	                if(!(password.charAt(i) >= 'a' && password.charAt(i) <= 'z')) {
	                	isPasswordValid = false;
	                }
	                
	                if(!(password.charAt(i) >= '0' && password.charAt(i) <= '9')) {
	                	isPasswordValid = false;
	                }
	                
	                if(!(password.charAt(i) == '_')) {
	                	isPasswordValid = false;
	                }
	                if(isPasswordValid == false) {
	                	break;
	                }
                }
            } else {
            	isPasswordValid = false;
            }
			
			// console 에 출력
			System.out.println("username: "+request.getParameter("username"));
			System.out.println("password: "+request.getParameter("password"));
			System.out.println("password-check: "+request.getParameter("password-check"));
			System.out.println("name: "+request.getParameter("name"));
			System.out.println("year: "+request.getParameter("year"));
			System.out.println("month: "+request.getParameter("month"));
			System.out.println("day: "+request.getParameter("day"));
			System.out.println("gender: "+request.getParameter("gender"));
			System.out.println("email: "+request.getParameter("email"));
			System.out.println("phone_code: "+request.getParameter("phone_code"));
			System.out.println("phone_number: "+request.getParameter("phone_number"));
			System.out.println("auth_num: "+request.getParameter("auth_num"));		
		%>
		<p>
			<% if(!isUsernameValid) { %>
                사용자 계정 및 패스워드가 잘못 되었습니다.<br>
                계정은 4 ~ 16자, 소문자, 숫자, 특수문자(_) 조합만 사용할 수 있습니다.<br>
                패스워드는 4 ~ 16자, 소문자, 숫자, 특수문자(_) 조합만 사용할 수 있습니다.
            <% } else { %>
                회원가입에 성공하였습니다.
                가입된 계정은 <%=username %> 입니다.
            <% } %>
		</p>
	</section>
</body>
</html>