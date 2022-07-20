<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시글 수정</h2>
	<form method=post name='fm'>
		<table width=650 border=1 cellspacing=1>
			<tr>
				<td><b>제목</b></td>
				<td>
					<input type=text name=title size=70 maxlength=70 value="${selectedArticle.title}" readonly>
				</td>
			</tr>
			<tr>
				<td><b>작성자</b></td>
				<td>
					<input type=text name=writer size=70 maxlength=70 required='required' value="${selectedArticle.writer}" >
				</td>
			</tr>
			<tr>
				<td><b>내용</b></td>
				<td>
					<textarea style='width:550px; height:250px; resize:none;' name =content cols=70 row=600 required='required'>${selectedArticle.content}</textarea>
				</td>
			</tr>
		</table>
				<table width=650>
			<tr>
				<td width=600 />
				<td>
					<input type = submit value="취소" onclick="submitForm(1)">
				</td>
				<td>
					<input type = submit value="수정" onclick="submitForm(2)">
				</td>
				<td>
					<input type = submit value="삭제" onclick="submitForm(3)">
				</td>
			</tr>
		</table>
	</form>
	
</body>
</html>