<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>update</h3>
<form method="POST" action="/user-info/update">
	<input type="hidden" name="uiNum" value="${userInfo.uiNum}">	
	<input type="text" name="uiId" placeholder="id" value="${userInfo.uiId}"><br>
	<input type="text" name="uiName" placeholder="name" value="${userInfo.uiName}"><br>
	<input type="password" name="uiPwd" placeholder="password" ><br>
	<textarea name="uiDesc" placeholder="desc">${userInfo.uiDesc}</textarea><br>
	<input type="date" name="uiBirth" placeholder="birth" value="${userInfo.uiBirth}"><br>
	<button>수정</button>
	<button type="reset">취소</button>
</form>
<!-- <form method="POST" action="/user-info/update">
	<input type="text" name="uiName" placeholder="name"><br>
	<input type="password" name="uiPwd" placeholder="password"><br>
	<textarea name="uiDesc" placeholder="desc"></textarea><br>
	<input type="date" name="uiBirth" placeholder="birth"><br>
	<button>update</button>
	<button type="reset">cancel</button>
</form> -->
</body>
</html>