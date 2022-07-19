<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기사 목록</title>
</head>
<body>
	<h2>게시판</h2>
	<table cellspacing = 1  border = 1 width=750>
		<tr align=center>
			<td width = 50>번호</td>
			<td width = 500>제목</td>
			<td width = 100>작성자</td>
			<td width = 100>등록일</td>
		</tr>
		
		<c:forEach var="Articles" items="${ArticleItems}" varStatus="status">
			<tr align=center>
			    <td width = 50><c:out value="${Articles.id}"/></td>
				<td width = 500><c:out value="${Articles.title}"/></td>
				<td width = 100><c:out value="${Articles.writer}"/></td>
				<td width = 100><c:out value="${fn:substring(Articles.updateDate,0,11)}"/></td>
			</tr>
		</c:forEach>
	</table>
		
</body>
</html>