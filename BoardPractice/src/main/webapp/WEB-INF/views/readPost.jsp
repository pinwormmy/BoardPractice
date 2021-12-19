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
	
	<c:if test="${loginMember != null and loginMember.memberId == readPost.postWriter}">
		<button type="button" onclick="location.href='/modifyPost?postNum=${readPost.postNum}'">수정</button>
		<button type="button" onclick="location.href='/deletePost?postNum=${readPost.postNum}'">삭제</button>
	</c:if>
	<button type="button" onclick="location.href='/'">목록</button><br>
	
	<hr>
	
	<c:forEach items="${readComment}" var="readComment">
	
		${readComment.commentWriter} 님의 댓글 &nbsp;&nbsp;&nbsp;&nbsp; ${readComment.commentTime}
		
		<c:if test="${loginMember != null and loginMember.memberId == readComment.commentWriter}">
				<button type="button" onclick="location.href='/deleteComment?commentNum=${readComment.commentNum}'">삭제</button>
		</c:if><br>
		
		<textarea rows="3" cols="200"> ${readComment.commentContent} </textarea><br>
	
	</c:forEach>
	
	
	<c:if test="${loginMember != null}">
		<form action="/submitComment" method="POST">
			작성자 : ${loginMember.memberId}
			<input type="hidden" name="commentWriter" value="${loginMember.memberId}" required>
			<input type="hidden" name="postNum" value="${readPost.postNum}" ><br>
			내용 <br>
			<textarea name="commentContent" rows="2" cols="180"></textarea><br>
			<button>댓글쓰기</button>
			<button type="button" onclick="location.href='/'">목록</button>
		</form>
	</c:if>

</body>
</html>