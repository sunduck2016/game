<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	num : <span id="num">${param.num}</span><br>
	name : <span id="name"></span><br>
	age : <span id="age"></span><br>
	address : <span id="address"></span><br>
	<button onclick="goPage('/list/update?num=${param.num}')">update</button><button onclick="deleteObj()">delete</button>
	<script>
		function deleteObj(){
			const xhr = new XMLHttpRequest();
			xhr.open('POST','/list/delete?num=${param.num}');
			xhr.onreadystatechange = function(){
				if(xhr.readyState===4){
					if(xhr.status===200){
						if(xhr.responseText==='1'){
							alert('delete success');
						}else {
							alert('always deleted');
						}
						location.href='/views/list';
					}
				}
			}
			xhr.send();
		}
		function goPage(url){
			location.href = url;
		}
		window.addEventListener('load',function(){
			const xhr = new XMLHttpRequest();
				xhr.open('GET','/list/one?num='+${param.num});
				xhr.onreadystatechange = function(){
					if(xhr.readyState===4){
						if(xhr.status===200){
							/* const list = JSON.parse(xhr.responseText);
							let html = '';
							for(const map of list){
								html += '<tr class="link" onclick="">';
								html += '<td>'+map.num+'</td>';
								html += '<td>'+map.name+'</td>';
								html += '<td>'+map.age+'</td>';
								html += '<td>'+map.address+'</td>';
								html += '</tr>';
							}
							document.querySelector('#KiChanisBest').innerHTML = html;
							colsole.log(html); */
							//console.log(xhr.responseTest);
							const obj = JSON.parse(xhr.responseText);
							for(const key in obj){
								document.querySelector('#'+key).innerText = obj[key];
							}
						}
					}
				}
				xhr.send();
		})
	</script>
</body>
</html>