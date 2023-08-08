<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>게시판</h3>
	<!-- <form action="/board-info/list" method="GET">-->
	<select name = "searchType" id="searchType">
		<option value="1">title</option>
		<option value="2">uiName</option>
		<option value="3">content</option>
		<option value="4">title+content</option>
		<option value="5">uiName+content</option>
		<option value="6">title+uiName</option>
		<option value="7">title+uiName+content</option>
	</select>
	<input type="text" name="searchStr" placeholder="search" id="searchStr">
	<button onclick="loadFunc()">search</button>
	<!--  </form>-->
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
			<tbody id = "Best">
				<!--<c:forEach items="${biList}" var="board">
				<tr>
					<td>${board.biNum}</td>
					<td><a href="/board-info/view?biNum=${board.biNum}">${board.biTitle}</a></td>
					<td>${board.uiName}</td>
					<td>${board.credat}</td>
				</tr>
				</c:forEach>-->
				<!--<tr>
					<td colspan="4" align="right">
						<button type="button" class="btn btn-primary" onclick="goPage('/board-info/insert')">등록</button>
					</td>
				</tr>-->
			</tbody>
			<tr>
				<td colspan="4" align="right">
					<button type="button" class="btn btn-primary" onclick="goPage('/board-info/insert')">등록</button>
				</td>
			</tr>
		</table>
	</div>
<script>
	function goPage(url){
		location.href = url;
	}
	const loadFunc = function(){
		//alert('do something');
		const xhr = new XMLHttpRequest();
		const searchStr = document.querySelector('#searchStr');
		const searchType = document.querySelector('#searchType');
		
		let url = '/json/list?';
		if(searchStr.value!==''){
			//alert(searchStr.value);
			//alert(searchType.value);
			url += 'searchType=' + searchType.value + '&searchStr='+searchStr.value;
			//alert(url);
			//return;
			//'/json/list'
		}
		
		xhr.open('GET',url);
		xhr.onreadystatechange = function(){
			if(xhr.readyState === 4){
				if(xhr.status === 200){
					const list = JSON.parse(xhr.responseText);
					let html = '';
					for(const board of list){
						html += '<tr>';
						html += '<td>'+board.biNum+'</td>';
						html += '<td><a href="/views/board-info/view?biNum='+board.biNum + '">'+board.biTitle+'</a></td>';
						html += '<td>'+board.uiName+'</td>';
						html += '<td>'+board.credat+'</td>';
						html += '<tr>';
					}
					document.querySelector('#Best').innerHTML = html;
				}
			}
		}
		xhr.send();
	}
	window.addEventListener('load',loadFunc);
</script>
</body>
</html>




