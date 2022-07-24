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
	<form method=post action='/articleBoard/articleListIndex'>
		<span> 제목 검색 </span>
		<c:if test="${SearchWord != null}">
			<input type=text name=title value="${SearchWord}" size=70 maxlength=70>
		</c:if>
		<c:if test="${SearchWord == null}">
			<input type=text name=title size=70 maxlength=70>
		</c:if>
		<input type=submit value = "검색" >
		

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
					<td width = 500><a href = '/articleBoard/selectedArticle/${Articles.id}'><c:out value="${Articles.title}"/></a></td>
					<td width = 100><c:out value="${Articles.writer}"/></td>
					<td width = 100><c:out value="${fn:substring(Articles.updateDate,0,11)}"/></td>
				</tr>
			</c:forEach>
		</table>
		
		<input type = button value = "등록" onclick = "location.href='/articleBoard/articleSubmitForm'">
		
		<div class="text-center">
			
			<a href='/articleBoard/articleList/${ArticlePagination.ppPage}/${SearchWord}'><c:out value="<<"/></a>
			<a href='/articleBoard/articleList/${ArticlePagination.pPage}/${SearchWord}'><c:out value="<"/></a>
	
			<c:forEach var="i" begin="${ArticlePagination.startPage}" end="${ArticlePagination.lastPage}">
			  <b><a href = '/articleBoard/articleList/${i - 1}/${SearchWord}'>${i}</a></b>
			</c:forEach>
		
			<a href='/articleBoard/articleList/${ArticlePagination.nPage}/${SearchWord}'><c:out value=">"/></a>
			<a href='/articleBoard/articleList/${ArticlePagination.nnPage}/${SearchWord}'><c:out value=">>"/></a>

		</div>
	</form>
</body>
</html>