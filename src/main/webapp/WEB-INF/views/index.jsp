<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
index.jsp
<c:if test="${user!=null}">
	${user.uiName} hello
	<!-- <button onclick="location.href='/user-info/logout'">logout</button>-->
	<ul>
		<li><a href="/user-info/my">내정보</a></li>
		<li><a href="/board-info/list">게시판</a></li>
		<li><a href="/user-info/logout">로그아웃</a></li>
	</ul>
</c:if>
<c:if test="${user==null}">
	<button onclick="location.href='/user-info/login'">login</button>
</c:if>
<h3>hello world</h3>
</body>
</html>