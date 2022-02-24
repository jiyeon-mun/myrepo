<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>회원가입</title>
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
   </head>

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
  border: 20px;
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
</style>
<script type="text/javascript">

function joinCheck(f) {
   if(!f.username.value) {
      f.username.nextElementSibling.innerText = "필수 입력입니다.";
      f.username.addEventListener("blur", isExists);
   }
   
   if(!f.password[0].value) {
      f.password[0].nextElementSibling.innerText = "필수 입력입니다.";
      f.password[0].addEventListener("blur", isExists);
   }
   
   if(!f.password[1].value) {
      f.password[1].nextElementSibling.innerText = "필수 입력입니다.";
      f.password[1].addEventListener("blur", isExists);
   }
}
//input 입력값 작성시 문구삭제
function isExists(e) {
   if(e.target.value) {
      e.target.nextElementSibling.innerText = "";
      e.target.removeEventListener("blur", isExists);
   }
}

//입력 시간
var stTime, edTime;

function isDuplication(e) { // 아이디 중복
   if(!stTime) {
      stTime = new Date().getTime();
   } else {
      edTime = new Date().getTime();
   }
   
   if(stTime && edTime) {
      var t = edTime - stTime;
      stTime = edTime;
      edTime = undefined;
   }
   
   if(t < 1000 && !(e.KeyCode === 13)) {
      return;
   } else {
      $.ajax({
         url: "/join/duplicate",
         type: "get",
         dataType: "json",
         data: {
            username: e.value
         },
         success: function(data) {
            if(data.state === "success") {               
               e.nextElementSibling.innerText = data.msg;
               e.nextElementSibling.style.color =  "blue";
               
            } else if(data.state === "fail") {               
               e.nextElementSibling.innerText = data.msg;
               e.nextElementSibling.style.color =  "red";
            }
         }
      });
   }
}

function isValidPass(v) { // 패스워드 유효성 체크(AJAX)
   if(!stTime) {
      stTime = new Date().getTime();
   } else {
      edTime = new Date().getTime();
   }
   
   if(stTime && edTime) {
      var t = edTime - stTime;
      stTime = edTime;
      edTime = undefined;
   }
   
   if(t < 1000 && !(v.KeyCode === 13)) {
      return;
   } else {
      $.ajax({
         url: "/join/passValid",
         type: "get",
         dataType: "json",
         data: {
            password: v.value
         },
         success: function(data) {
            if(data.state === "success") {
                 v.nextElementSibling.innerText = data.msg;
            } else if(data.state === "fail") {
               v.nextElementSibling.innerText = data.msg;
            }
         }
      });
   }
}

function ispassConfirm(c) { // 패스워드 동일 체크(자바스크립트)
   var password = document.getElementById("id_password");
   var passcheck = document.getElementById("id_passcheck");
   
   if(password.value == passcheck.value) {
      c.classList.remove("is-invalid");
      c.nextElementSibling.innerText = "패스워드가 일치합니다.";
      c.nextElementSibling.style.color =  "blue";
   } else {
      c.classList.remove("is-valid");
      c.nextElementSibling.innerText = "패스워드가 일치하지 않습니다.";
      c.nextElementSibling.style.color =  "red";
   }
}

function regEvent() {
   var username = document.getElementById("id_username");
   username.addEventListener("keyup", isduplicate); // 입력할 때마다, 엔터키 누를 때 전달
   username.addEventListener("blur", isduplicate); // 포거스 아웃할 때 전달
   
   var password = document.getElementById("id_password");
   password.addEventListener("keyup", isValidPass);
   password.addEventListener("blur", isValidPass);
   
    var passcheck = document.getElementById("id_passcheck");
   passcheck.addEventListener("keyup", passConfirm);
   passcheck.addEventListener("blur", passConfirm);
}
</script>


<body>
   <div class="login_container">
       <form class="login_wrap" action="/join" method="post">
            <div class="login_logo">
                <img src='http://drive.google.com/uc?export=view&id=14d2f4JHBjotnnV-DcNWY-eHQDkKSbW2p' />
            </div>
            <div class="login_input">
                <input type="text" name="username" autocomplete="off" oninput="isDuplication(this);" required>
                <label for="id" class="label_name">
                    <span class="content_name">ID</span>
                </label>
                <div class=""></div>
            </div>
            <div class="login_input">
                <input type="password" id="id_password" name="password" autocomplete="off" oninput="isValidPass(this);" required>
                <label for="pw" class="label_name">
                    <span class="content_name">Password</span>
                </label>
                 <div class=""></div>
                
            </div>
            <div class="login_input">
                <input type="password" id="id_passcheck" name="passcheck" autocomplete="off" oninput="ispassConfirm(this);" required>
                <label for="pw" class="label_name">
                      <span class="content_name">Passwordcheck</span>
                  </label>
                 <div class=""></div>
                
            </div>
            <div class="btn_style">
                <button type="button" class="btn_login" onclick="location.href='/login'">로그인</button>
                <button type="submit" class="btn_join" onclick="joinCheck(this.form);">등록</button>
            </div>
       </form>
    </div>
</body>

</html>