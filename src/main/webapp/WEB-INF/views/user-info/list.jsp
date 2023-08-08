<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>user test</h3>
	<!--<c:forEach items="${userInfoList}" var="userInfo">
		${userInfo.uiNum}, ${userInfo.uiName}, <a href="/user-info/view?uiNum=${userInfo.uiNum}">${userInfo.uiId}</a><br>
	</c:forEach>-->
	<a href="/user-info/insert">insert</a>
	<select name = "searchType" id="searchType">
		<option value="1">title</option>
		<option value="2">uiName</option>
		<option value="3">content</option>
	</select>
	<input type="text" name="searchStr" placeholder="search" id="searchStr">
	<div class = "container">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">number</th>
					<th scope="col">name</th>
					<th scope="col">desc</th>
					<th scope="col">birth</th>
				</tr>
			</thead>
			<tbody id="Ki-Chan is Best"></tbody>
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
							html += '<td>'+user.uiNum+'</td>';
							html += '<td><a href="/views/board-info/view?biNum='+user.uiNum + '">'+user.uiName+'</a></td>';
							html += '<td>'+user.uiId+'</td>';
							html += '<td>'+user.uiBirth+'</td>';
							html += '<td>'+user.credat+'</td>';
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