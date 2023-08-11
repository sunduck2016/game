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
	<input type="text" name="uiId" placeholder="id"><br>
	<input type="text" name="uiName" placeholder="name"><br>
	<input type="password" name="uiPwd" placeholder="password"><br>
	<textarea name="uiDesc" placeholder="desc"></textarea><br>
	<input type="date" name="uiBirth" placeholder="birth"><br>
	<button type = "button" onclick="addUser()">insert</button>
	<button type="reset">cancel</button>
	<script>
		function ajax(method,url,callback,param){
			const xhr = new XMLHttpRequest();
			xhr.open('POST','/user-info/insert');
			//xhr.setRequestHeader('Content-Type','application/json');
			xhr.onreadystatechange = function(){
				if(xhr.readyState===4){
					if(xhr.status===200){
						/*if(xhr.responseText==='1'){
							alert('정상적으로등록 되었습니다.');
							location.href='/views/list';
						}else{
							alert('오류가 발생하였습니다. 다시 시도해주시기 바랍니다.');
						}*/
						console.log(xhr.responseText);
					}
				}
			}
			xhr.send(param);
		}
		function addUser(){
			const param = {
					uiId : document.querySelector('input[name=uiId]').value,
					uiName : document.querySelector('input[name=uiId]').value,
					uiPwd : document.querySelector('input[name=uiId]').value
					uiDesc : document.querySelector('input[name=uiId]').value,
					uiBirth : document.querySelector('input[name=uiId]').value
			}
			const json = JSON.stringify(param);
			ajax('POST','/user-info/insert',console.log,json);
			console.log();
		}
	</script>
</body>
</html>