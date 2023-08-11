<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>update</h3>
<form method="POST" action="/user-info/update">
	<input type="hidden" id="uiNum" value="${userInfo.uiNum}">	
	<input type="text" id="uiId" placeholder="id" value="${userInfo.uiId}"><br>
	<input type="text" id="uiName" placeholder="name" value="${userInfo.uiName}"><br>
	<input type="password" id="uiPwd" placeholder="password" ><br>
	<textarea id="uiDesc" placeholder="desc">${userInfo.uiDesc}</textarea><br>
	<input type="date" id="uiBirth" placeholder="birth" value="${userInfo.uiBirth}"><br>
	<button>수정</button>
	<button type="reset">취소</button>
</form>
<!-- <form method="POST" action="/user-info/update">
	<input type="text" name="uiName" placeholder="name"><br>
	<input type="password" name="uiPwd" placeholder="password"><br>
	<textarea name="uiDesc" placeholder="desc"></textarea><br>
	<input type="date" name="uiBirth" placeholder="birth"><br>
	<button>update</button>
	<button type="reset">cancel</button>
</form> -->
<script>
	
	function sendObj(){
		const param = {
				uiNum : '${userInfo.uiNum}',
				uiId : document.querySelector('#uiId').value,
				uiName : document.querySelector('#uiName').value,
				uiPwd : document.querySelector('#uiPwd').value,
				uiDesc : document.querySelector('#uiDesc').value,
				uiBirth : document.querySelector('#uiBirth').value
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
		xhr.send();
	})
</script>
</body>
</html>