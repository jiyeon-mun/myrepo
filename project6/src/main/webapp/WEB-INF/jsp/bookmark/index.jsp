<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.web.bookmark.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bookmark</title>
</head>
<body>
	<header></header>
	<section>
            <form action="./bookmark" method="post">
                <div class="inline-form">
                    <input type="text" class="col-1" name="bookmark_name" placeholder="북마크 이름">
                    <input type="text" class="col-auto" name="bookmark_url" placeholder="URL 주소">
                </div>
                <div class="right-form">
                    <button type="submit">등록</button>
                </div>
            </form>
        </section>
	
	<section>
		<ul>
			<li><a href="https://naver.com">네이버</a></li>
            <li><a href="https://daum.net">다음</a></li>
            <li><a href="https://google.com">구글</a></li>
		</ul>
	</section>
	<footer></footer>
</body>
</html>