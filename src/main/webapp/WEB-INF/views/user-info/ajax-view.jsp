<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>user detail screan</h3>
name : ${userInfo.uiName}<br>
birth : ${userInfo.uiBirth}<br>
desc : ${userInfo.uiDesc}<br>
credat : ${userInfo.Credat}<br>
<!-- <a href="/user-info/update">update</a> -->
<button type="button" onclick="location.href='/user-info/update?uiNum=${userInfo.uiNum}'">update</button>
<button>delete</button>
<!-- <a href="/user-info/delete">delete</a> -->
</body>
</html>