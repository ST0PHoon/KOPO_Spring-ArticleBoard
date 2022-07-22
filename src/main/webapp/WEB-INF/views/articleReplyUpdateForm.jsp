<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글 수정</title>
</head>
<body>
	<table width=650 border=1 cellspacing=1>
			<tr align="center">
				<td> 
					댓 글	
				</td>
				<td>
					작 성 자
				</td>
				<td rowspan = 2>
					<input type = submit value = "수정" onclick = "location.href='/articleBoard/updateArticleReplyForm/${articleReplies.id}">
				</td>
			</tr>
			<tr align="center">
				<td> 
					<input type=text name=title size=70 maxlength=70 value="${updateArticleReply.replyContent}">
				</td>
				<td>
					<input type=text name=title size=70 maxlength=70 value="${updateArticleReply.replyWriter}">
				</td>
			</tr>
</body>
</html>