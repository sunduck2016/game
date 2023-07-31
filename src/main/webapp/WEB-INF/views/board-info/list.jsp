<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>게시판</h3>
	<form action="/board-info/list" method="GET">
	<select name = "searchType">
		<option value="1">title</option>
		<option value="2">uiName</option>
		<option value="3">content</option>
		<option value="4">title+content</option>
		<option value="5">uiName+content</option>
		<option value="6">title+uiName</option>
		<option value="7">title+uiName+content</option>
	</select>
	<input type="text" name="searchStr" placeholder="search">
	<button>search</button>
	</form>
	<div class="container">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">번호</th>
					<th scope="col">제목</th>
					<th scope="col">작성자</th>
					<th scope="col">작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${biList}" var="board">
				<tr>
					<td>${board.biNum}</td>
					<td><a href="/board-info/view?biNum=${board.biNum}">${board.biTitle}</a></td>
					<td>${board.uiName}</td>
					<td>${board.credat}</td>
				</tr>
				</c:forEach>
				<tr>
					<td colspan="4" align="right">
						<button type="button" class="btn btn-primary" onclick="goPage('/board-info/insert')">등록</button>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
<script>
	function goPage(url){
		location.href = url;
	}
</script>
</body>
</html>




