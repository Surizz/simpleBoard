<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script language="javascript">
	function checkValidate() {		
		var email = document.getElementById("email").value;
		var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
		if(exptext.test(email)==false){
			alert("메일형식이 올바르지 않습니다.");
			form.email.focus(); 
			return false;
		}		
	    if(form.password.value=="") {
			alert("비밀번호를 입력해 주세요.");
			form.password.focus();
			return false;
		}
	    if(form.content.value=="") {
			alert("내용을 입력해 주세요.");
			form.content.focus();
			return false;
		}	       
		return true;
	}
</script>

<h1>방명록 남기기</h1>
<form name='form' onsubmit="return checkValidate();" action='add.do' method='post'>
	이메일<br><input type='text' id="email" name='email'><br>
	암호<br><input type='password' name='password'><br>
	<label for="content">내용</label><br>
	<textarea id="content" name='content' rows="5" cols="40"></textarea><br><br>
	<input type='submit' value='추가'>
	<input type='button' value='취소' onclick='location.href="/board"'>
</form>