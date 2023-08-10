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
		name : <input type="text" id="name"><br>
		age : <input type="text" id="age"><br>
		address : <input type="text" id="address"><br>
		<button onclick="sendObj()">insert</button>
	<!-- </form>-->
	<script>
		function sendObj(){
			const param = {
					name : document.querySelector('#name').value,
					age : document.querySelector('#age').value,
					address : document.querySelector('#address').value
			}
			const json = JSON.stringify(param);
			const xhr = new XMLHttpRequest();
			//const formDate = new FormData();
			xhr.open('POST','/list/insert');
			xhr.setRequestHeader('Content-Type','application/json');
			xhr.onreadystatechange = function(){
				if(xhr.readyState===4){
					if(xhr.status===200){
						/* const obj = JSON.parse(xhr.responseText);
						for(const key in obj){
							document.querySelector('#'+key).innerText = obj[key];
						} */
						if(xhr.responseText==='1'){
							alert('insert success');
							location.href='/views/list';
						}else{
							alert('insert fail');
						}
					}
				}
			}
			xhr.send(json);
		}
	</script>
</body>
</html>