<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<title> ${readPost.postTitle} ㅁㅁ게시판 글읽기 </title>
<meta charset="UTF-8" />
</head>
<body>

	제목 <input type="text" name="postTitle" value="${readPost.postTitle}" required style="width:500px"><br>
	작성자 <input type="text" name="postWriter" value="${readPost.postWriter}" required><br>
	내용 <br>
	<textarea name="postContent" rows="30" cols="200">${readPost.postContent}</textarea><br>
	
	<button type="button" onclick="location.href='/modifyPost?postNum=${readPost.postNum}'">수정</button>
	<button type="button" onclick="location.href='/deletePost?postNum=${readPost.postNum}'">삭제</button>
	<button type="button" onclick="location.href='/'">목록</button>

</body>
</html>