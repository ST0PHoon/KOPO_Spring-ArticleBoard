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
	<input type = button value = "수정" onclick = "location.href='update'">
	<input type = button value = "삭제" onclick = "location.href='delete'">
	
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
	<table width=650 border=1 cellspacing=1>
		<c:forEach var="artircleReplies" items="${selectedArticleReplies}">
			<tr>
				<td width= 540>
					<c:if test="${artircleReplies.depth == 1}">
						<c:out value="${artircleReplies.replyContent}"/>
					</c:if>
					<c:if test="${artircleReplies.depth == 2}">
						-> <c:out value="${artircleReplies.replyContent}"/>
					</c:if>
				</td>
				<td>
					<input type = button value = "삭제" onclick = "location.href='update'">
					<c:if test="${artircleReplies.depth == 1}">
						<input type = button value = "댓글" onclick = "location.href='delete'">
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>