<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글확인</title>
<script>
	function submitForm(mode) {
		var myform = document.articleContent;
		if (mode == 1) {
			myform.action = "/articleBoard/articleUpdateForm";
		}
		if (mode == 2) {
			myform.action = "/articleBoard/deleteArticle";
		}
	}
</script>

</head>
<body>
	<h2> 상세 정보 </h2>
	<form method=post name='articleContent'>

		<input type = submit value = "수정" onclick = "submitForm(1)">
		<input type = submit value = "삭제" onclick = "submitForm(2)">
		
		<input type = hidden name = id value = "${selectedArticleItem.id}">
		
		<table width=650 border=1 cellspacing=1>
				<tr>
					<td>제목 : <c:out value="${selectedArticleItem.title}"/></td>
					<td>작성자: <c:out value="${selectedArticleItem.writer}"/></td>
				</tr>
				<tr>
					<td colspan="2">
						<textarea style='width:640px; height:250px; resize:none;' name =content cols=70 row=600 readonly><c:out value="${selectedArticleItem.content}"/></textarea>
					</td>
				</tr>
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
						<input type = button value = "삭제" onclick = "location.href='#'">
						<c:if test="${artircleReplies.depth == 1}">
							<input type = button value = "댓글" onclick = "location.href='#'">
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
	</form>

</body>
</html>