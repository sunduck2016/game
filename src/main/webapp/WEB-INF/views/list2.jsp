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
			<td>number</td>
			<td>name</td>
			<td>age</td>
			<td>address</td>
		</tr>
		<tbody id = "KiChanIsBest"></tbody>
	</table>
	<script>
	function getList(){
		const xhr = new XMLHttpRequest();
		
		xhr.open('GET','/list2');
		xhr.onreadystatechange = function(){
			if(xhr.readyState===4){
				if(xhr.status===200){
					const list2 = JSON.parse(xhr.responseText);
					let html = '';
					for(const map of list2){
						html += '<tr>';
						html += '<td>'+map.number+'</td>';
						html += '<td>'+map.name+'</td>';
						html += '<td>'+map.age+'</td>';
						html += '<td>'+map.address+'</td>';
						html += '</tr>';
					}
					document.querySelector('#KiChanIsBest').innerHTML = html;
				}
			}
		}
		xhr.send();
	}
	window.addEventListener('load',getList);
	</script>
</body>
</html>