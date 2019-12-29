<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<h1>방명록 남기기</h1>
<form action='add.do' method='post'>
	이메일<br><input type='text' name='email'><br>
	암호<br><input type='password' name='password'><br>
	<label for="content">내용</label><br>
	<textarea id="content" name='content' rows="5" cols="40"></textarea><br><br>
	<input type='submit' value='추가'>
	<input type='button' value='취소' onclick='location.href="/board"'>
</form>