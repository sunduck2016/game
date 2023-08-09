<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>게시물 상세화면</h3>
<div class="container">
	<!-- <form method="POST" action="/maple-info/delete">
	<input type="hidden" name="miNum" value="${maple.miNum}">-->
	<table class="table table-bordered">
		<thead>
			<tr>
				<th scope="col">number</th>
				<td id="miNum">${param.miNum }</td>
			</tr>
			<tr>
				<th scope="col">name</th>
				<td id="miName"><!--${maple.miTitle }--></td>
			</tr>
			<tr>
				<th scope="col">server</th>
				<td id="miServer"></td>
			</tr>
			<tr>
				<th scope="col">job</th>
				<td id="uiJob"></td>
			</tr>
			<!-- <c:if test="${user.uiNum == maple.uiNum}">-->
			<!-- </c:if>-->
		</thead>
	</table>
	<!-- </form>-->
<script>
function goPage(url){
	location.href=url;
}
function loadFunc(){
	const xhr = new XMLHttpRequest();
	xhr.open('GET','/json/one?miNum=${param.miNum}');
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4){
			if(xhr.status === 200) {
				//console.log(xhr.responseText);
				const maple = JSON.parse(xhr.responseText);
				//console.log(maple);
				for(let key in maple){
					console.log(key, maple[key])
					if(document.querySelector('#'+key)){
						document.querySelector('#'+key).innerText = maple[key];
					}
				}
			}
		}
	}
	xhr.send();
}
window.addEventListener('load',loadFunc);
</script>
</div>
</body>
</html>