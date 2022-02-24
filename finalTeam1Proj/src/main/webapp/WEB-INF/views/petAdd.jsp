<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>펫 등록</title>
   <!-- <link rel="stylesheet" type="text/css" href="/static/front-end/css/petpage.css"> -->
   <script type="text/javascript" src="/static/jquery/jquery-3.6.0.min.js"></script>
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
   <style>
   @font-face {
  font-family: "Cafe24Oneprettynight";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.1/Cafe24Oneprettynight.woff")
    format("woff");
  font-weight: normal;
  font-style: normal;
}

form {
  display: flex;
  flex-direction: column;
  align-items: center;
  font-size: 18px;
}

hr {
  width: 500px;
  border: 1px solid silver;
}

.logo img{
  width: 200px;
}
.pat_img img {
  width: 200px;
  height: 200px;
}

#image_container {
   margin: 0 auto;
   width: 200px;
   height: 230px;
   display: flex;
   flex-direction: column;
}

.pat_img img {
  border-radius: 50%;
  object-fit: cover; /* 비율 그대로 유지 */
}

.name_wrap,
.birth_wrap,
.age_wrap {
  padding: 10px 0;
}

.name_input,
.birth_input {
  border: none;
  border-bottom: 1px solid silver;
  padding: 5px 0;
}

.age_wrap input {
   width: 25px;
   text-align: right;
   font-size: 16px;
}

.name_input:focus,
.birth_input:focus {
  outline: 1px solid #ffc6a6;
  border-bottom: none;
  border-radius: 10px;
}

.birth_wrap input[type="button"] {
 background-color: #fff;
 border: 1px solid #86C6F4;
 color: #86C6F4;
 border-radius: 5px;
 cursor: pointer;
}

.birth_wrap input[type="button"]:hover {
   background-color: #86C6F4;
   color: #fff;
   

}

/* 팻 체크 */
.radio_wrap {
  padding: 10px;
}

.check_btn input {
  display: none;
}

.check_btn label {
  background-color: rgb(161, 161, 161);
  color: rgb(39, 39, 39);
  padding: 0.5rem 1rem;
  border-radius: 1rem;
  user-select: none;
  cursor: pointer;
}

/* 성별 체크 */
.gender_wrap {
  padding: 10px;
}

.gender_btn input[type="radio"] {
  display: none;
}

.gender_btn input[type="radio"] + span {
  display: inline-block;
  padding: 10px 50px;
  border: 1px solid #dfdfdf;
  background-color: #ffffff;
  text-align: center;
  cursor: pointer;
}

.gender_btn input[type="radio"]:checked + span {
  background-color: #ffc6a6;
  color: #ffffff;
}

/* 버튼 */
.btn_wrap {
  padding: 10px;
}
.btn_wrap input {
  font-size: 18px;
  width: 100px;
  height: 30px;
  border: 1px solid #ffc6a6;
  border-radius: 2em;
  background-color: white;
  color: black;
  font-family: "Cafe24Oneprettynight";
}

.btn_wrap input:hover {
  border-radius: 2em;
  background-color: #ffc6a6;
  color: black;
  border: 1px solid #ffc6a6;
  cursor: pointer;
}
   
   </style>
</head>
<script type="text/javascript">
function setThumbnail(event) { // 이미지 업로드 미리보기
   var reader = new FileReader(); 
   reader.onload = function(event) { 
      var img = document.createElement("img"); 
      img.setAttribute("src", event.target.result); 
      document.querySelector("div#image_container").appendChild(img); 
   }; 
   reader.readAsDataURL(event.target.files[0]); 
}

function popupClose(form) { // 펫 정보 등록 버튼 누르면 서브 창 자동으로 닫음.
   form.target = opener.name;
   form.submit();
   if(opener != null) {
      opener.insert = null;
      self.close();
   }
}

function calcAge() { // 생년월일 입력 받아서 나이 도출
   var birth = document.getElementById("birthday").value.split('-');
   var today = new Date();
   
   var bYear = parseInt(birth[0]);
   var bMonth = parseInt(birth[1]-1);
   var bDay = parseInt(birth[2]);
   
   var age = today.getFullYear() - bYear + 1;
   document.getElementById("age").value = age;
}
</script>
<body>
    <form class="form_wrap" action="/pet/add" method="post"  enctype="multipart/form-data">
       <input type="hidden" name="mid" value="${sessionScope.account.mid }">
        <div class="logo">
            <img src='http://drive.google.com/uc?export=view&id=14d2f4JHBjotnnV-DcNWY-eHQDkKSbW2p'>
        </div>
        <hr>
        <div class="pat_img">
           
           <div id="image_container">
              <input type="file" id="file" name="uploadfile" accept="image/*" onchange="setThumbnail(event);" required>
           </div>
        </div>
        <hr>
        <div>
           <div class="name_wrap">
               이름 : <input class="name_input" type="text" name="petname">
           </div>
           <div class="birth_wrap">
               생년월일 : <input class="birth_input" type="date" name="birthday" id="birthday" required>
               <input type="button" onclick="calcAge();" value="저장">
           </div>
           <div class="age_wrap">
               나이 : <input class="birth_input" type="number" min="0" name="age" id="age" readonly required>살
           </div>
        </div>
        
        <div class="radio_wrap">
            <input type="radio" id="dog" name="sid" value="1" required>
            <label for="dog">강아지</label>
            <input type="radio" id="cat" name="sid" value="2">
            <label for="cat">고양이</label>
            <input type="radio" id="etc" name="sid" value="3">
            <label for="etc">기타</label>
        </div>
        <div class="gender_wrap">
            <label class="gender_btn">
                <input type="radio" id="man" name="sex" value="m" required>
                <span>수컷</span>
            </label>
            <label class="gender_btn">
                <input type="radio" id="woman" name="sex" value="f">
                <span>암컷</span>
            </label>
        </div>
        <div class="btn_wrap">
            <input type="submit" id="man" value="등록하기" onclick="popupClose(this.form);">
        </div>
   </form>

</body>
</html>