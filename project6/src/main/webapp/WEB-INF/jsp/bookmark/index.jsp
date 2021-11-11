<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bookmark</title>
</head>
<body>
	<section>
		<form action="./bookmark" method="post"> <!-- 북마크 등록 작업 -->
			<div>
				<input type="text" name="alias" placeholder="별칭 입력">
				<input type="text" name="url" placeholder="url 주소 입력">
			</div>
			<div>
				<button type="submit">등록</button>
			</div>
		</form>
	</section>
	
	<section>
		<ul>
			<li>별칭1</li>
			<li>별칭2</li>
			<li>별칭3</li>
			<li>별칭4</li>
		</ul>
	</section>
</body>
</html>