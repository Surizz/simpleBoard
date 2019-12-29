<%@ page 
  language="java" 
  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
<h1>방명록</h1>
<table border="1">
<tr> 
  <td>내용</td>
  <td>작성자</td>
  <td>최종 수정 시간</td>
</tr>
<c:forEach var="entity" items="${boardList}">
<tr> 
  <td>${entity.content}</td>
  <td>${entity.email}</td>
  <td>${entity.modifiedDate}</td>
</tr>
</c:forEach>
</table>
</body>
</html>