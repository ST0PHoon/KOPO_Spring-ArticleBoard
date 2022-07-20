<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SubmitForm</title>
</head>
<body>
	<h2>게시글 작성</h2>
	<form method=post name='submitForm' action=createArticle>
		<table width=650 cellspacing = 1  border = 1>
			<tr>
				<td>제목</td>
				<td>
					<input type=text name=title size=70 maxlength=70 required='required'>
				</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>
					<input type=text name=writer size=70 maxlength=70 required='required'>
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea style='width:550px; height:250px; resize:none;' name =content cols=70 row=600 required='required'></textarea>
				</td>
			</tr>
		</table>
		<table width=650>
			<tr>
				<td width=600 />
				<td>
					<input type = button value="취소" onclick="location.href='/articleBoard/articleList'">
				</td>
				<td>
					<input type = submit value="작성" onclick="location.href='/articleBoard/createArticle'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>