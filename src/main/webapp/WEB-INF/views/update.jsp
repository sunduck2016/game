<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- <form method="POST" action="/list/insert">-->
		num : ${param.num}<br>
		name : <input type="text" id="name"><br>
		age : <input type="text" id="age"><br>
		address : <input type="text" id="address"><br>
		<button onclick="sendObj()">update</button>
	<!-- </form>-->
	<script>
		function sendObj(){
			const param = {
					num : '${param.num}',
					name : document.querySelector('#name').value,
					age : document.querySelector('#age').value,
					address : document.querySelector('#address').value
			}
			const json = JSON.stringify(param);
			const xhr = new XMLHttpRequest();
			xhr.open('POST','/list/update');
			xhr.setRequestHeader('Content-Type','application/json');
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
						/* const obj = JSON.parse(xhr.responseText);
						for(const key in obj){
							document.querySelector('#'+key).innerText = obj[key];
						} */
						if(xhr.responseText==='1'){
							alert('정상적으로등록 되었습니다.');
							location.href='/views/list';
						}else{
							alert('오류가 발생하였습니다. 다시 시도해주시기 바랍니다.');
						}
					}
				}
			}
			xhr.send();
		}

		window.addEventListener('load',function(){
			const xhr = new XMLHttpRequest();
			xhr.open('GET','/list/one?num=' + ${param.num});
			xhr.onreadystatechange = function(){
				if(xhr.readyState===4){
					if(xhr.status===200){
						const obj = JSON.parse(xhr.responseText);
						for(const key in obj){
							if(document.querySelector('#' + key)){
								document.querySelector('#' + key).value = obj[key];
							}
						}
					}
				}
			}
			xhr.send();
		})
	</script>
</body>
</html>