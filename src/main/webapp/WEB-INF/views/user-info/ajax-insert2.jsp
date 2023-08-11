<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>insert</h3>
<form method="POST" action="/user-info/insert">
	<input type="text" id="uiId" placeholder="id"><br>
	<input type="text" id="uiName" placeholder="name"><br>
	<input type="password" id="uiPwd" placeholder="password"><br>
	<textarea id="uiDesc" placeholder="desc"></textarea><br>
	<input type="date" id="uiBirth" placeholder="birth"><br>
	<button>insert</button>
	<button type="reset">cancel</button>
	<script>
		function sendObj(){
			const param = {
					uiId : document.querySelector('#uiId').value,
					uiName : document.querySelector('#uiName').value,
					uiPwd : document.querySelector('#uiPwd').value
					uiDesc : document.querySelector('#uiDesc').value,
					uiBirth : document.querySelector('#uiBirth').value
			}
			const json = JSON.stringify(param);
			
			const xhr = new XMLHttpRequest();
			xhr.open('POST','/list/insert');
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
	</script>
</form>
</body>
</html>