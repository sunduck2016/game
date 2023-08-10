<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
tr.link{
	background-color:white;
	color:black;
	cursor:pointer;
}
tr.link:hover{
	background-color:blue;
	color:yellow;
	cursor:pointer;
}
</style>
</head>
<body>
	<table border="1">
		<tr>
			<th>number</th>
			<th>name</th>
			<th>age</th>
			<th>address</th>
		</tr>
		<tbody id = "KiChanisBest">
		</tbody>
	</table>
	<script>
		function goPage(num){
			location.href = '/views/one?num='+num;
		}
		//const loadFunc = function(){
		/*function goPage(num){
			alert(num);
		}*/
		function getList(){
			const xhr = new XMLHttpRequest();
			/*const searchStr = document.querySelector('#searchStr');
			const serachType = document.querySelelctor('#searchType');
			
			let url = '/json/list?';
			if(searchStr.value!==''){
				url += 'searchType' + searchType.value + '&searchStr='+searchStr.value;
			}*/
			
			//xhr.open('GET',url);
			xhr.open('GET','/list/list');
			xhr.onreadystatechange = function(){
				if(xhr.readyState===4){
					if(xhr.status===200){
						const list = JSON.parse(xhr.responseText);
						let html = '';
						/*for(const board of list){
							html += '<tr>';
							html += '<td>'+"이름1"+'</td>';
							html += '<td>'+"살"+'</td>';
							html += '<td>'+"일산"+'</td>';
							html += '</tr>';
						}*/
						/*const map = list[0];
						html += '<tr>';
						html += '<td>'+map.name+'</td>';
						html += '<td>'+map.age+'</td>';
						html += '<td>'+map.address+'</td>';
						html += '</tr>';*/
						for(const map of list){
							html += '<tr class="link" onclick="goPage('+map.num+')">';
							html += '<td>'+map.num+'</td>';
							html += '<td>'+map.name+'</td>';
							html += '<td>'+map.age+'</td>';
							html += '<td>'+map.address+'</td>';
							html += '</tr>';
						}
						document.querySelector('#KiChanisBest').innerHTML = html;
						colsole.log(html);
					}
				}
			}
			xhr.send();
		}
		//window.addEventListener('load',loadFunc);
		window.addEventListener('load',getList);
		//window.addEventListener('load',goPage);
	</script>
</body>
</html>