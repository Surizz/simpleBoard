<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="Refresh" content="1;url=/board/">
		<title>에러!</title>
	</head>
	<body>
		<h1>
			<c:choose>
				<c:when test="${errorType == 'email'}">
					메일 형식이 올바르지 않습니다.
			    </c:when>
			    <c:when test="${errorType == 'wrongPassword'}">
					비밀번호가 맞지 않습니다.
			    </c:when>
			    <c:otherwise>
					비밀번호를 입력해 주십시오.
			    </c:otherwise>
			</c:choose>		
		<br>잠시 후 방명록으로 돌아갑니다.</h1>
	</body>
</html>