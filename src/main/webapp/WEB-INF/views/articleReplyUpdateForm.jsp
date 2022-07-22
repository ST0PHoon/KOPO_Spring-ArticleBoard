<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글 수정</title>
</head>
<body>

	<form method=post name='articleReplyUpdateForm' action = "articleReplyUpdate">
	
	
			
		<table width=650 border=1 cellspacing=1>
		
			<tr align="center">
				<td> 
					댓 글	
				</td>
				<td>
					작 성 자
				</td>
				<td rowspan = 2>
				<input type=hidden name=id value="${updateArticleReply.id}">
					<input type = submit value = "수정" >
					<!-- <input type = submit value = "수정" onclick = "location.href='/articleBoard/articleReplyUpdate'"> -->
				</td>
			</tr>
			<tr align="center">
				<td> 
					<input type=text name=replyContent size=70 maxlength=70 value="${updateArticleReply.replyContent}">
				</td>
				<td>
					<input type=text name=replyWriter value="${updateArticleReply.replyWriter}" readonly>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>