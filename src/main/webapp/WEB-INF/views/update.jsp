<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1>방명록 수정</h1>
<form action='update.do' method='post'>
	<input type="hidden" name="bno" value='${boardEntity.bno}'>
	이메일<br><input type='text' name='email' style="width:250px;" value='${boardEntity.email}' readonly><br>
	암호<br><input type='password' name='password' style="width:250px;"><br>
	<label for="content">내용</label><br>
	<textarea id="content" name='content' rows="5" style="width:250px;">${boardEntity.content}</textarea><br><br>
	<input type='submit' value='저장'>
	<input type='button' value='취소' onclick='location.href="/board"'>
</form>