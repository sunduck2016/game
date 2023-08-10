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
		name : <input type = "text" name="name"><br>
		id : <input type = "text" name="id"><br>
		password : <input type = "text" name="pwd"><br>
		desc : <textarea type = "text" name="desc"></textarea><br>
		trans : <input type="radio" name="trans" value="man">man<input type="radio" name="trans" value="women">women<br>
		job : 
		<select name="job">
			<jobtion value="">select</jobtion>
			<jobtion value="programer">programer</jobtion>
			<jobtion value="geulja">Geul Ja</jobtion>
			<jobtion value="pang2yo">pang2yo</jobtion>
		</select>
		<button>insert</button>
	</form>
	<!-- <script>
		function sent(){
			const name = document.querySelector('#name').value;
			const id = document.querySelector('#id').value;
			const pwd = document.querySelector('#pwd').value;
			const desc = document.querySelector('#desc').value;
			const trans = document.querySelector('#trans').value;
			const job = document.querySelector('#job').value;
			const url = '/calc?name='+name+'&id='+id+'&pwd='+pwd+'&desc='+desc+'&trans='+trans+'&job='+encodeURIComponent(job);
			const xhr = new XMLHttpRequest();
			xhr.joben('GET',url);
			xhr.onreadystatechange = function(){
				if(xhr.readyState === 4){
					if(xhr.status===200){
						document.querySelector('#result').innerText=xhr.responseText;
					}
				}
			}
			xhr.send();
		}
	</script>-->
</body>
</html>