<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>insert</h3>
<form method="POST" action="/user-info/insert">
	<input type="text" name="uiId" placeholder="id"><br>
	<input type="text" name="uiName" placeholder="name"><br>
	<input type="password" name="uiPwd" placeholder="password"><br>
	<textarea name="uiDesc" placeholder="desc"></textarea><br>
	<input type="date" name="uiBirth" placeholder="birth"><br>
	<button>insert</button>
	<button type="reset">cancel</button>
</form>
</body>
</html>