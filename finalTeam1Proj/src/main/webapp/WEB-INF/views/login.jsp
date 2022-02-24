<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <style>
    /* 배경 */
     body {
       background-image: url(http://drive.google.com/uc?export=view&id=12x7ITWk3e6nndu9-MBtc2klEN9AROHVb);
       background-repeat: repeat;
       background-size: 30%; 
     }
	.login_container {
		width: 28vw;
		height: 100vh;
		margin: 0 auto;
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
	}

	form {
		width: 100%;
		height: 80vh;
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
		background-color: white;
		border-radius: 100px;
		box-shadow: 0 0 15px rgb(0, 0, 0, 70%);
		position: static;
	}

	.login_logo img {
  		width: 200px;
  		margin-bottom: 55px;
	}

	.login_input {
	  	width: 70%;
	  	position: relative;
	  	height: 70px;
	  	overflow: hidden;
	}

	.login_input input {
	  	display: flex;
	  	flex-direction: column;
	  	width: 100%;
	  	height: 100%;
	  	padding-top: 50px;
	  	border: none;
	  	box-sizing: border-box;
	  	outline: none;
	}

	.login_input label {
	  	position: absolute;
	  	bottom: 0;
	  	left: 0;
	  	width: 100%;
	  	height: 100%;
	  	pointer-events: none;
	  	font-weight: bolder;
	  	border-bottom: 1px solid black;
	  	color: silver;
	}

	.login_input label::after {
	  	content: "";
	  	position: absolute;
	  	left: 0px;
	  	bottom: 0px;
	  	height: 100%;
	  	width: 100%;
	  	border-bottom: 2px solid silver;
	  	transform: translateX(-100%);
	  	transition: transform 3s ease;
	}

	.content_name {
	  	position: absolute;
	  	bottom: 5px;
	  	left: 0px;
	  	transition: all 0.5s ease;
	}

	.login_input input:focus + .label_name .content_name,
	.login_input input:valid + .label_name .content_name {
	  	transform: translateY(-100%);
	  	font-size: 14px;
	}

	.login_input input:focus .label_name::after,
	.login_input input:valid + .label_name::after {
  		transform: translateX(0%);
	}

	.btn_style {
	  	margin-top: 30px;
	  	width: 70%;
	  	height: 30px;
	  	display: flex;
	  	justify-content: space-between;
	}

	.btn_login {
	  	width: 45%;
	  	background-color: white;
	  	font-weight: bold;
	  	color: black;
	  	border: 0 none;
	  	border-radius: 1px;
	  	cursor: pointer;
	  	box-shadow: 0 0 0 2px white, 0 0 0 3px orange;
	}
	.btn_login:hover {
	  	background-color: wheat;
	  	transition: all 0.5s ease;
	  	cursor: pointer;
	}

	.btn_join {
	  	width: 45%;
	  	background-color: white;
	  	font-weight: bold;
	  	color: black;
	  	border: 0 none;
	  	border-radius: 1px;
	  	cursor: pointer;
	  	box-shadow: 0 0 0 2px white, 0 0 0 3px gray;
	}

	.btn_join:hover {
	  	background-color: gainsboro;
	  	transition: all 0.5s ease;
	  	cursor: pointer;
	}
	.error {
	    margin-top: 20px;
	    color : red;
	}
    </style>
</head>
<body>	
	<div class="login_container">
        
        <form class="login_wrap" action="/login" method="post">
        	<div class="login_logo">
                <img src='http://drive.google.com/uc?export=view&id=14d2f4JHBjotnnV-DcNWY-eHQDkKSbW2p' />
            </div>
			<c:if test="${not empty param.next }">
				<input type="hidden" name="next" value="${param.next} ">
			</c:if>
			<div class="login_input">
                <input type="text"  name="username" id="id" autocomplete="off" required>
                <label for="id" class="label_name">
                    <span class="content_name">ID</span>
                </label>
            </div>
			<div class="login_input">
                <input type="password" name="password" id="pw" autocomplete="off" required>
                <label for="pw" class="label_name">
                    <span class="content_name">password</span>
                </label>
            </div>
            <div class="error"> 
				<c:if test="${not empty error}">
					<span>${error }</span>
				</c:if>
			</div>
			<div class="btn_style">
                <button type="submit" class="btn_login">로그인</button>
                <button type="button" class="btn_join" onclick="location.href='/join'">회원가입</button>
            </div>
		</form>
    </div>
</body>
</html>