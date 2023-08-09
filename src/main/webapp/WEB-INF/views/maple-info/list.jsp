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
	<!-- <form action="/maple-info/list" method="GET">-->
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
					<th scope="col">number</th>
					<th scope="col">name</th>
					<th scope="col">server</th>
					<th scope="col">job</th>
				</tr>
			</thead>
			<tbody id = "Ki-chan is Best">
				<!--<c:forEach items="${miList}" var="maple">
				<tr>
					<td>${maple.miNum}</td>
					<td><a href="/maple-info/view?miNum=${maple.miNum}">${maple.miTitle}</a></td>
					<td>${maple.uiName}</td>
					<td>${maple.credat}</td>
				</tr>
				</c:forEach>-->
				<!--<tr>
					<td colspan="4" align="right">
						<button type="button" class="btn btn-primary" onclick="goPage('/maple-info/insert')">등록</button>
					</td>
				</tr>-->
			</tbody>
			<tr>
				<td colspan="4" align="right">
					<button type="button" class="btn btn-primary" onclick="goPage('/maple-info/insert')">등록</button>
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
					for(const maple of list){
						html += '<tr>';
						html += '<td>'+maple.miNum+'</td>';
						html += '<td><a href="/views/maple-info/view?miNum='+maple.miNum + '">'+maple.miName+'</a></td>';
						html += '<td>'+maple.miServer+'</td>';
						html += '<td>'+maple.miJob+'</td>';
						html += '<tr>';
					}
					document.querySelector('#Ki-chan is Best').innerHTML = html;
				}
			}
		}
		xhr.send();
	}
	window.addEventListener('load',loadFunc);
</script>
</body>
</html>




