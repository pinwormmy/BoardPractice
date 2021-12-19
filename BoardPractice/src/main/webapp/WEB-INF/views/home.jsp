<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<title>게시판 제작 복습</title>
<meta charset="UTF-8" />
<style>
	a{text-decoration:none; color:black;}
	a:hover{text-decoration-line:underline;}
</style>
</head>
<body>
<h1>
	게시판 제작 복습하기
</h1>

<P>구글링 최대한 안 하고 만들어보기</P>
<p>개념 하나하나 이해하고 진행</p>


<c:if test="${loginMember == null}">
	<form action="/login" method="post">
		ID : <input type="text" name="memberId" required>
		비밀번호 : <input type="password" name="memberPassword" required>
		<button>로그인</button>
		<button type="button" onclick="location.href='/signUp'">회원가입</button>
	</form>
</c:if>

<c:if test="${loginMember != null}">
<p>
	${loginMember.memberId}님께서 로그인 중입니다. 
	<button type="button" onclick="location.href='/logout'">로그아웃</button>
</p>
</c:if>

<hr>

<table>
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성시간</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${postList}" var="postList" begin="${postStartNum - 1}" end="${postLastNum - 1}">
			<tr>
				<td>${postList.postNum}</td>
				<td> <a href="/readPost?postNum=${postList.postNum}">${postList.postTitle}</a> </td>
				<td>${postList.postWriter}</td>
				<td>${postList.postTime}</td>
				<td>${postList.viewCount}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<hr>

<form action="/search">
	<select name="searchOption">
		<option value="searchPostTitle">제목</option>
		<option value="searchPostContent">내용</option>
		<option value="searchPostWriter">작성자</option>
		<option value="searchPostTitleAndContent" selected>제목+내용</option>
	</select>
	<input type="text" name="searchKeyword">
	<input type="hidden" name="pageNum" value="1">
	<button>검색</button>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<c:if test="${loginMember != null}">
		<button type="button" onclick="location.href='/writePost'" >글쓰기</button>
	</c:if>
	<button type="button" onclick="location.href='/'" >목록</button>
</form>



<c:if test="${pageStartNum > 10}">
<a href="/page?pageNum=${pageStartNum - 1}">☜</a>
</c:if>

<c:forEach var="pageNumber" begin="${pageStartNum}" end="${pageLastNum}">

	<c:if test="${pageRecentNum == pageNumber}">
		<b>${pageNumber}</b>  
	</c:if>
	<c:if test="${pageRecentNum != pageNumber}">
		<a href="/page?pageNum=${pageNumber}"> ${pageNumber} </a>
	</c:if>
	
</c:forEach>

<c:if test="${pageLastNum < pageTotalEndNum}">
<a href="/page?pageNum=${pageLastNum + 1}">☞</a>
</c:if>

</body>
</html>