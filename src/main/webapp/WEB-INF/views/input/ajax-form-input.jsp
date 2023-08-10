<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="/input">
		name : <input type = "text" id="name"><br>
		id : <input type = "text" id="id"><br>
		password : <input type = "text" id="pwd"><br>
		desc : <textarea type = "text"></textarea><br>
		trans : <input type="radio" idname"trans" value="man">man<input type="radio" name="trans" value="women">women<br>
		job : 
		<select id="job">
			<option value="">select</option>
			<option value="programer">programer</option>
			<option value="geulja">Geul Ja</option>
			<option value="pang2yo">pang2yo</option>
		</select>
		<button onclick="sendObj()">insert</button>
	</form>
	<script>
		function sendObj(){
			const param = {
					name : document.querySelector('#name').value,
					id : document.querySelector('#id').value,
					pwd : document.querySelector('#pwd').value,
					desc : document.querySelector('#desc').value,
					job : document.querySelector('#job').value,
					trans : document.querySelector('[name=trans]:checked').value
			}
			const json = JSON.stringify(param);
			const xhr = new XMLHttpRequest();
			//console.log(param);
			xhr.open('POST','/input');
			xhr.setRequestHeader('Content-Type','application/json');
			xhr.onreadystatechange=function(){
				if(xhr.readyState===4){
					if(xhr.status===200){
						console.log(xhr.responseText);
					}
				}
			}
			xhr.send(json);
		}
	</script>
</body>
</html>