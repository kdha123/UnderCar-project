<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tl" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 리스트</title>
<style type="text/css">
.dataRow:hover{
	background: #eee;
	cursor: pointer;
}
</style>
<script type="text/javascript">
$(function(){
	$(".dataRow").click(function(){
		var no = $(this).find(".no").text();
		location = "view.do?no=" + no + "&page=${pageObject.page}"
					+ "&perPageNum=${pageObject.perPageNum}";
	});
	
	$(".pagination > li:not('.active')").click(function(){
		var page = $(this).data("page");
		location = "list.do?page=" + page + "&perPageNum=${pageObject.perPageNum}";
// 					+ "&key=${pageObject.key}" + "&word=${pageObject.word}";
		return false;
	});
	
	$("li.active").click(function(){
		return false;
	});
});
</script>
</head>
<body>
<div class="container">
	<table class="table">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>대표이미지</th>
			<th>시작일</th>
			<th>종료일</th>
		</tr>	
		<c:forEach items="${list }" var="dto">
		<tr class="dataRow">
			<td class="no">${dto.no }</td>
			<td>${dto.title }</td>
			<td><img alt="" src="${dto.repImage }"></td>
			<td>${dto.startDate }</td>
			<td>${dto.endDate }</td>
		</tr>		
		</c:forEach>
		<tr>
			<td colspan="5">
				<ul class="pagination">
					<tl:pageNav endPage="${pageObject.endPage }" totalPage="${pageObject.totalPage }" startPage="${pageObject.startPage }" page="${pageObject.page }"></tl:pageNav>
				</ul> 
			</td>
		</tr>
		<tr>
			<td colspan="4">
				<a href="writeForm.do" class="btn btn-default">이벤트등록</a>
			</td>	
		</tr>
	</table>
</div>
</body>
</html>