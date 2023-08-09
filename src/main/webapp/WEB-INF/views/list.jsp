<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>name</th>
			<th>age</th>
			<th>address</th>
		</tr>
		<tbody id = "Best">
		</tbody>
	</table>
	<script>
		/*function goPage = function(){
			location.href = url;
		}*/
		//const loadFunc = function(){
		function getList(){
			const xhr = new XMLHttpRequest();
			/*const searchStr = document.querySelector('#searchStr');
			const serachType = document.querySelelctor('#searchType');
			
			let url = '/json/list?';
			if(searchStr.value!==''){
				url += 'searchType' + searchType.value + '&searchStr='+searchStr.value;
			}*/
			
			//xhr.open('GET',url);
			xhr.open('GET','/list');
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
							html += '<tr>';
							html += '<td>'+map.name+'</td>';
							html += '<td>'+map.age+'</td>';
							html += '<td>'+map.address+'</td>';
							html += '</tr>';
						}
						document.querySelector('#Best').innerHTML = html;
					}
				}
			}
			xhr.send();
		}
		//window.addEventListener('load',loadFunc);
		window.addEventListener('load',getList);
	</script>
</body>
</html>