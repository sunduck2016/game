<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="GET" action="/calc">
		<input type="number" name="num1">
		<select name="op">
			<option value="+">+</option>
			<option value="-">-</option>
			<option value="*">*</option>
			<option value="/">/</option>
			<option value="%">&</option>
		</select>
		<input type="number" name="num2"><br>
		<button onclick="set()">set</button>
		result : <scan id="result">0</scan>
	</form>
	<script>
		function sent(){
			const num1 = document.querySelector('#num1').value;
			const num2 = document.querySelector('#num2').value;
			const op = document.querySelector('#op').value;
			const url = '/calc?num1='+num1+'&num2='+num2+'&op='+encodeURIComponent(op);
			const xhr = new XMLHttpRequest();
			xhr.open('GET',url);
			xhr.onreadystatechange = function(){
				if(xhr.readyState === 4){
					if(xhr.status===200){
						document.querySelector('#result').innerText=xhr.responseText;
					}
				}
			}
			xhr.send();
		}
	</script>
</body>
</html>