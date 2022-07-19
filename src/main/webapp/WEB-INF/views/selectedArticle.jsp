<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글확인</title>
</head>
<body>
	<h2> 상세 정보 </h2>
	<input type = button value = "수정" onclick = "location.href='update'"></td>
	<input type = button value = "삭제" onclick = "location.href='delete'"></td>
	
	<table width=650 border=1 cellspacing=1>
		<c:forEach var="article" items="${selectedArticleItem}">
			<tr>
				<td>제목 : <c:out value="${article.title}"/></td>
				<td>작성자: <c:out value="${article.writer}"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<textarea style='width:640px; height:250px; resize:none;' name =content cols=70 row=600 readonly><c:out value="${article.content}"/></textarea>
				</td>
			</tr>
		</c:forEach>
	</table>
	<table>
		<c:forEach var="artircleReplies" items="${selectedArticleReplies}">
			
		
			<p><c:out value="${artircleReplies.replyContent}"/></p>
			<p><c:out value="${artircleReplies.replyWriter}"/></p>
			<p><c:out value="${artircleReplies.depth}"/></p>
		</c:forEach>
	</table>

</body>
</html>