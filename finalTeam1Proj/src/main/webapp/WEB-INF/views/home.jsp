<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
   <title>Home</title>
   <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />
   <link rel="stylesheet" type="text/css" href="/static/front-end/css/haf.css">
   <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css"/>
   <script src="https://kit.fontawesome.com/16a2fd4cc5.js" crossorigin="anonymous"></script>
   <style>
   @font-face {
  font-family: "Cafe24Oneprettynight";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.1/Cafe24Oneprettynight.woff")
    format("woff");
  font-weight: normal;
  font-style: normal;
}

body {
  margin: 0;
  font-family: "Cafe24Oneprettynight";
}

.user_name {
   font-size: 18px;
   width: 1140px;
   margin: 0 auto;
}

.swiper {
        width: 1240px;
        height: 600px;
        margin-top: 30px;
      }

      .swiper-slide {
        text-align: center;
        font-size: 18px;
        background: #fff;

        /* Center slide text vertically */
        display: -webkit-box;
        display: -ms-flexbox;
        display: -webkit-flex;
        display: flex;
        -webkit-box-pack: center;
        -ms-flex-pack: center;
        -webkit-justify-content: center;
        justify-content: center;
        -webkit-box-align: center;
        -ms-flex-align: center;
        -webkit-align-items: center;
        align-items: center;
      }

      .swiper-slide img {
        display: block;
        width: 100%;
        height: 100%;
      }

.content {
  width: 1140px;
  display: grid;
  grid-template-columns: 350px 350px 350px;
  grid-template-rows: 550px 550px 550px;
  justify-content: space-between;
  margin: 30px auto;
}

.content_table {
  width: 320px;
  height: 320px;
}


.content_head {
  text-align: right;
  margin-right: 300px;
}

.content_body {
  table-layout: fixed;
  word-break: break-all;
}

.content_body:hover {
  cursor: pointer;
}

.body_img {
  border: 1px solid black;
  width: 200px;
  height: 300px;
  text-align: center;
  margin: 0;
}

.body_img:hover {
  transform: scale(1.02);
  transform: translateY(-10px);
  transition: all 0.35s;
  box-shadow: 0px 4px 8px rgb(146, 146, 146);
}

.body_writer {
  font-size: 22px;
  font-weight: bolder;
  padding-bottom: 20px;
}

.body_text {
  box-sizing: border-box;
  font-size: 20px;
  border-bottom: 2px solid black;
  vertical-align: top;
  height: 50px;
}

.content_foot {
  text-align: left;
  word-break: break-all;
}

.content_foot td:last-child i:hover {
  transform: scale(1.25);
  transition: all 0.35s;
  cursor: pointer;
  color: red;
}

.content_foot td:last-child {
  text-align: right;
  cursor: pointer;
}

.content_foot td:last-child i:hover {
  transform: scale(1.25);
  transition: all 0.35s;
}

@media screen and (max-width: 820px) {
  .content {
    width: auto;
    display: grid;
    grid-template-columns: 430px 430px;
    grid-template-rows: 530px 530px 530px;
    margin: 0 auto;
  }
}

@media screen and (max-width: 600px) {
  .content {
    width: auto;
    display: grid;
    grid-template-columns: 430px;
    grid-template-rows: 530px 530px 530px;
    margin: 0 auto;
    margin-left: 100px;
  }
}   
.diary_paging {
		margin: 0 auto;
		width: 1140px;
		margin-bottom: 20px;
	}
	
	.paging_wrap {
		display: flex;
		justify-content: space-between;
		align-items: center;
		font-size: 1.3rem;
	}
	.paging_number span a {
		padding: 10px;
		color: #333;
		font-size: 20px;
		font-weight: 700;
		transition: .3s linear;
	}
	
	.paging_number span a:hover {
		color: red;
		border-bottom: 3px solid red;
		transform: scale(1.25);
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
   
   <!-- Swiper -->
        <div class="swiper mySwiper">
            <div class="swiper-wrapper">
              <div class="swiper-slide"><img src='http://drive.google.com/uc?export=view&id=1Z_CkphTQu_s3O-p0nsPj0rzN9Eh1gDNU' /><br></div>
              <div class="swiper-slide"><img src='http://drive.google.com/uc?export=view&id=1cBKrcreZKonpcjtKvP1aYezfqtlYd7UX' /><br></div>
              <div class="swiper-slide"><img src='http://drive.google.com/uc?export=view&id=1YwVcvGRSNt-zopKSIAyRza_Fl5hUa4sq' /><br></div>
      
            </div>
            <div class="swiper-button-next"></div>
            <div class="swiper-button-prev"></div>
            <div class="swiper-pagination"></div>
          </div>
   
      <!-- Swiper JS -->
    <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

    <!-- Initialize Swiper -->
    <script>
      var swiper = new Swiper(".mySwiper", {
        cssMode: true,
        navigation: {
          nextEl: ".swiper-button-next",
          prevEl: ".swiper-button-prev",
        },
        pagination: {
          el: ".swiper-pagination",
        },
        mousewheel: true,
        keyboard: true,
      });

      var myImage = document.getElementById("img01");
   var imageArray = [ "withpet01.jpg",
         "withpet02.jpg", 
            "withpet01.jpg" ];
   var imageIndex = 0;

   function changeImage() {
      myImage.setAttribute("src", imageArray[imageIndex]);
      imageIndex++;
      if (imageIndex >= imageArray.length) {
         imageIndex = 0;
      }
   }
   setInterval(changeImage, 3000);     
    </script>
      
   <!-- 일기 보여지는 부분 -->
    <div class="content">
       <c:set var="page" value="${empty param.page ? 1 : param.page }" />
       <c:forEach var="num" begin="${(page - 1) * 9 }" end="${page * 9 - 1 }" varStatus="status">
           <div class="content_wrap">
               <table class="content_table">
                   
                   <tbody class="content_body">
                       <tr>
                           <td colspan="8" class="body_img">
                              <a href="/diary/detail?dno=${datas[num].dno }">
                            <img alt="img" src="${files[status.index].fileurl }" width=100% height=100%>
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
                  <span><a href="/?page=${page+1}">${page+1 }</a></span>
               </c:if>
               <c:if test="${loop.last }">
                  <c:if test="${datas.size() mod 9 ne 0 }">
                     <span><a href="/?page=${page+1}">${page+1 }</a></span>
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