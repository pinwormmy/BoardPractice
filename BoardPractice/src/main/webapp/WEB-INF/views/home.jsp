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
		<c:forEach items="${postList}" var="postList">
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

<button type="button" onclick="location.href='/writePost'">글쓰기</button>
<button type="button" onclick="location.href='/'">목록</button>

</body>
</html>