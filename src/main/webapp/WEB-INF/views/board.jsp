<%@ page 
  language="java" 
  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<style type = "text/css">
		  table, th, td {
		    border: 1px solid #bcbcbc;
		  }
		  table {
		    height: 100px;
		    margin-left: auto;
		    margin-right: auto;
		  }
		</style>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>방명록</title>
	</head>
	<body style="text-align:center;">
		<div id = "wrapper">
		<c:choose>
			<c:when test="${boardCond == 'update'}">
				<jsp:include page="update.jsp"/>
		    </c:when>
		    <c:otherwise>
				<jsp:include page="add.jsp"/>
		    </c:otherwise>
		</c:choose>
		<br><h1>방명록</h1>		
		<table>
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
			  <td><a href='?bno=${entity.bno}'>[수정]</a></td>
			</tr>
			</c:forEach>
		</table>
		</div>
	</body>
</html>