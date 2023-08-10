<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산기</title>
</head>
<body>
	<form method="GET" action="/calc">
		<input type="number" name="num1">
		<select name="op">
			<option value="+">+</option>
			<option value="-">-</option>
		</select>
		<input type="number" name="num2"><br>
		<button onclick="set()">set</button>
	</form>
	<script>
		function sent(){
			
			/* const param = {
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
						if(xhr.responseText==='1'){
							alert('정상적으로등록 되었습니다.');
							location.href='/views/list';
						}else{
							alert('오류가 발생하였습니다. 다시 시도해주시기 바랍니다.');
						}
					}
				}
			}
			xhr.send(json);
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
			xhr.send(); */
		})
	</script>
</body>
</html>