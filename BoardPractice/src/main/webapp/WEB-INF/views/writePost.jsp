<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<title>게시글 작성하기</title>
<meta charset="UTF-8" />
</head>
<body>

<form action="/submitWritePost" method="POST">
	제목 <input type="text" name="postTitle" required style="width:500px"><br>
	작성자 <input type="text" name="postWriter" required><br>
	내용 <br>
	<textarea name="postContent" rows="30" cols="200"></textarea><br>
	<button>게시하기</button>
	<button type="button" onclick="location.href='/'">목록</button>
</form>

</body>
</html>