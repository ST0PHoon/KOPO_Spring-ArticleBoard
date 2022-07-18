<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글달기</title>
</head>
<body>
	This is List 
	<c:forEach var="item" items="${reInsertItem}" varStatus="status">
	    <p>${status.count}</p>
		<p><c:out value="${item.title}"/></p>
		<p><c:out value="${item.content}"/></p>
		<p><c:out value="${item.created}"/></p>
	</c:forEach>

	!
</body>
</html>