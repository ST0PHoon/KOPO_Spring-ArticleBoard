<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글확인</title>
<script>
	function submitFormArticleContent(mode) {
		var myform = document.articleContent;
		if (mode == 1) {
			myform.action = "/articleBoard/articleUpdateForm";
		}
		if (mode == 2) {
			myform.action = "/articleBoard/deleteArticle";
		}
	}
	
	function submitFormArticleReplyDepthOne(mode) {
		var myform = document.articleReplyDepthOne;
		if (mode == 1) {
			myform.action = "/articleBoard/createArticleReply";
		}
	}
	
	function submitFormArticleReplyDepthTwo(mode) {
		var myform = document.articleReplyDepthTwo;
		if (mode == 1) {
			myform.action = "/articleBoard/createArticleReply";
		}
	}
</script>

</head>
<body>
	<h2> 상세 정보 </h2>
	<form method=post name='articleContent'>
		<input type = submit value = "수정" onclick = "submitFormArticleContent(1)">
		<input type = submit value = "삭제" onclick = "submitFormArticleContent(2)">
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
		
		<input type = hidden name = id value = "${selectedArticleItem.id}">
	</form>	
	
	<br>
		
	<form method=post name='articleReplyDepthOne'>
		<input type = submit value = "댓글 작성" onclick = "submitFormArticleReplyDepthOne(1)">
		<table width=650 border=1 cellspacing=1>
			<tr align = center>
				<td width=50>작성자</td>
				<td width=460>댓 글</td>
			</tr>
			<tr>
				<td>
					<input type=text name=replyWriter required='required'>
				</td>
				<td>
					<textarea style='width:450px; height:20px; resize:none;' name =replyContent cols=70 row=600 required='required'></textarea>
				</td>
			</tr>
		</table>
		
		<input type = hidden name = depth value = 1>
		<input type = hidden name = replyId value = "${selectedArticleItem.id}">
	</form>
	
	<br>
		
	<form method=post name='articleReplyDepthTwo'>
		<table width=650 border=1 cellspacing=1>
			<tr align="center">
				<td colspan="3"> 
					댓   글	
				</td>
			</tr>
			
			<c:if test="${empty selectedArticleReplies}">
				<tr align="center">
					<td>
						등록된 댓글이 없습니다.
					</td>
				</tr>
			</c:if>
		
			<c:forEach var="articleReplies" items="${selectedArticleReplies}">
				<tr>
					<td width= 490>
						<c:if test="${articleReplies.depth == 1}">
							<c:out value="${articleReplies.replyContent}"/>
						</c:if>
						<c:if test="${articleReplies.depth == 2}">
							-> <c:out value="${articleReplies.replyContent}"/>
						</c:if>
					</td>
					<td colspan = 2>
						<input type = button value = "삭제" onclick = "location.href='/articleBoard/deleteArticleReply/${articleReplies.id}'">
						<input type = button value = "수정" onclick = "location.href='/articleBoard/updateArticleReplyForm/${articleReplies.id}'">
					</td>
				</tr>
				<c:if test="${articleReplies.depth == 1}">
					<tr align = center>
						<td width=460>댓 글</td>
						<td width=50>작성자</td>
					</tr>
					<tr>
						<td>
							<textarea style='width:450px; height:20px; resize:none;' name =replyContent cols=70 row=600 required='required'></textarea>
						</td>
						<td>
							<input type=text name=replyWriter required='required'>
						</td>
						<td>
							<input type = button value = "댓글" onclick = "location.href='#'">
						</td>
					</tr>
				</c:if>
				<input type = hidden value="${articleReplies.id}" name = id >
			</c:forEach>
		</table>
		
		<input type = hidden value = 2 name = depth >
		<input type = hidden name = replyId value = "${selectedArticleItem.id}">
	</form>

</body>
</html>