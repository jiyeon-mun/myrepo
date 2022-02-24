<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="ko">
<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>Information</title>
   <link rel="stylesheet" type="text/css" href="/static/front-end/css/haf.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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

body {
  font-family: "Cafe24Oneprettynight";
   margin: 0;
   padding: 0;
}
.container {
  width: 1140px;
  margin: 0 auto;
}

.info_list {
  height: 515px;
  display: flex;
  flex-direction: row;
}

.list-group {
  width: 15%;
  padding: 15px 0;
}

.list-group a {
  display: flex;
  justify-content: center;
  margin: 30px 0;
  padding: 20px 0;
}

.list-group a:hover {
  cursor: pointer;
  background-color: bisque;
  border-radius: 10px;
}

.list-group a:active {
  background-color: bisque;
  border-radius: 10px;
}

#myinfo {
  width: 100%;
}

#myinfo .info_title,
#expire .info_title,
#changepw .info_title {
  font-size: 28px;
  font-weight: bolder;
  margin: 50px 0 3px 30px;
}

#expire .info_title,
#changepw .info_title {
  padding-bottom: 15px;
}

#myinfo .account {
  font-size: 22px;
  margin: 15px 0 15px 30px;
  display: flex;
  flex-direction: column;
}

#myinfo .account label{
   padding: 12px 0;
}



#changepw {
  width: 100%;
}


#changepw .password_wrap {
  font-size: 22px;
  margin: 15px 0 15px 30px;
}

#changepw .password_wrap input[type="password"] {
  width: 600px;
  padding: 5px;
  border: none;
  border-bottom: 2px solid black;
}

#changepw .password_wrap input[type="password"]:focus {
  outline: none;
}

#changepw .password_msg {
  font-size: 18px;
  margin: 15px 0 15px 180px;
  color: rgba(252, 71, 71, 0.829);
}

#changepw .password_btn {
  margin-right: 30px;
  float: right;
}


#expire {
  width: 100%;
}


#expire .expire_wrap {
  font-size: 22px;
  margin: 15px 0 15px 30px;
}

#expire .password_btn {
  margin-right: 30px;
  float: right;
}

#expire .current_password input[type="password"] {
  width: 600px;
  padding: 5px;
  border: none;
  border-bottom: 2px solid black;
}
#expire .current_password input[type="password"]:focus {
  outline: none;
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
<script type="text/javascript">
   function domyinfo() {
      var myinfo = document.getElementById("myinfo");
      var changepw = document.getElementById("changepw");
      var expire = document.getElementById("expire");

      if (changepw.style.display == 'block') {
         changepw.style.display = 'none';
      }
      if (expire.style.display == 'block') {
         expire.style.display = 'none';
      }
      if (myinfo.style.display == 'none') {
         myinfo.style.display = 'block';
      } else {
         myinfo.style.display = 'none';
      }
   }
   function dochangepw() {
      var myinfo = document.getElementById("myinfo");
      var changepw = document.getElementById("changepw");
      var expire = document.getElementById("expire");

      if (myinfo.style.display == 'block') {
         myinfo.style.display = 'none';
      }
      if (expire.style.display == 'block') {
         expire.style.display = 'none';
      }
      if (changepw.style.display == 'none') {
         changepw.style.display = 'block';
      } else {
         changepw.style.display = 'none';
      }
   }
   function doexpire() {
      var myinfo = document.getElementById("myinfo");
      var changepw = document.getElementById("changepw");
      var expire = document.getElementById("expire");
      if (changepw.style.display == 'block') {
         changepw.style.display = 'none';
      }
      if (myinfo.style.display == 'block') {
         myinfo.style.display = 'none';
      }
      if (expire.style.display == 'none') {
         expire.style.display = 'block';
      } else {
         expire.style.display = 'none';
      }
   }

       function changepw() {
      var password = $("#password").val();
      var modify = $("#modify").val();

      $.ajax({
         url : "/changepw",
         type : "POST",
         dataType : "json",
         data : {
            password : password,
            modify : modify
         },
         success : function(data) {
            if (data.state === "success") {
               alert(data.message);
               window.location.href = "./logout";
            } else {
               alert(data.message);
            }
         }
      });
   }
       
       function expire(){
          var password = $("#password").val();
          
          $.ajax({
             url: "/expire",
             type : "POST",
             dataType : "json",
             data : {
                password : password
             },
             success : function(data){
                if(data.state ==="success"){
                   alert(data.message);
                   window.location.href = "./logout";
                } else{
                   alert(data.message);
                }
             }
          });
       }
</script>
</head>
<body>
   <header>
      <jsp:include page="/WEB-INF/views/common/navbar.jsp">
         <jsp:param value="${sessionScope.account }" name="account"/>
      </jsp:include>
   </header>
   
   <section class="container">
      <article class="list_wrap">
         <aside class="info_list">
            <div class="list-group">
               <a href="javascript:dochangepw()">패스워드 변경</a> 
               <a href="javascript:doexpire()">회원 탈퇴</a>
            </div>
            <div id="myinfo" style="display: none">
               <div class="info_title">
                  <label>기본 정보</label>
               </div>


            </div>
            <div id="changepw" style="display: none">
               <div class="info_title">
                  <label>비밀번호 변경</label>
               </div>
               <div class="password_wrap">
                  <div class="current_password">
                     <label>현재 비밀번호 : </label> <input type="password" name="password"
                        id="password">
                  </div>
               </div>
               <div class="password_wrap">
                  <div class="modify">
                     <label>변경 비밀번호 : </label> <input type="password"
                        name="modify" id="modify">
                  </div>
               </div>
               <div class="password_msg">
                  <p>* 패스워드 양식에 맞게 입력해주세요.</p>
                  <p>* 6~16자리의 영문 + 숫자 / 영문 + 특수문자 / 영문 + 숫자 + 특수문자</p>
               </div>
               <div class="password_btn">
                  <button type="button" onclick="changepw();" class="raise">변경</button>
               </div>
            </div>
            <div id="expire" style="display: none">
               <form class="expire">
                  <div class="info_title">
                     <label>회원탈퇴</label>
                  </div>
                  <div class="expire_wrap">
                     <div class="current_password">
                        <label>비밀번호 입력 : </label> <input type="password" name="password">
                     </div>
                  </div>
                  <div class="password_btn">
                     <button type="button" onclick="expire();" class="raise">회원탈퇴</button>
                  </div>
               </form>
            </div>
         </aside>
      </article>
   </section>
   
   <footer>
      <jsp:include page="/WEB-INF/views/common/footer.jsp" />
   </footer>
</body>
</html>