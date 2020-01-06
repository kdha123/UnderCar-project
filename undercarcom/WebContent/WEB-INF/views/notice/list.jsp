<%@page import="com.undercar.member.dto.LoginDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tl" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 리스트</title>
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
		${(!empty pageObject.word)?
				   " + \"&key=" += pageObject.key += "&word=" += pageObject.word += "\"":""};
	});
	
	
	var id = "${login.id}";
	$("#writeBtn").click(function(){
		if(id != admin){
			location = "/error/nonAuth.jsp";
		}	
	})
	
	$(".pagination > li:not('.active')").click(function(){
		var page = $(this).data("page");
		location = "list.do?page=" + page + "&perPageNum=${pageObject.perPageNum}"
					+ "&key=${pageObject.key}" + "&word=${pageObject.word}";
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
	<div class="row">
		<div id="searchDiv">
			<form action="list.do" class="form-inline">
				<input name="page" value="1" type="hidden" />
				<input name="perPageNum" value="${pageObject.perPageNum }" type="hidden"/>
					<div class="form-group">
						<select class="form-control" id="key" name="key">
							<option value="t" ${(param.key =="t")?"selected='selected'":"" }>제목</option>
						</select>
					</div>					
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Search" 
							name="word" value="${param.word }">
			    		<div class="input-group-btn">
			    			<button class="btn btn-default" type="submit">
			        			<i class="glyphicon glyphicon-search"></i>
			      			</button>
			    		</div>
		    		</div>
				</form>
		  </div>
	</div>
	<table class="table">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>시작일</th>
			<th>종료일</th>
		</tr>	
<%-- 		<c:if test="${login.grade==9 }"> --%>
		<c:forEach items="${list }" var="dto">
		<tr class="dataRow">
			<td class="no">${dto.no }</td>
			<td>${dto.title }</td>
			<td>${dto.startDate }</td>
			<td>${dto.endDate }</td>
		</tr>		
		</c:forEach>
<%-- 		</c:if> --%>
		<tr>
			<td colspan="5">
				<ul class="pagination">
					<tl:pageNav endPage="${pageObject.endPage }" totalPage="${pageObject.totalPage }" startPage="${pageObject.startPage }" page="${pageObject.page }"></tl:pageNav>
				</ul> 
			</td>
		</tr>
		<tr>
			<td colspan="4">
				<a href="writeForm.do?perPageNum=${pageObject.perPageNum }" class="btn btn-default" id="writeBtn">공지등록</a>
				<a href="list.do?page=1&perPageNum=${pageObject.perPageNum }" class="btn btn-default">전체목록</a>
			</td>	
		</tr>
	</table>
</div>
</body>
</html>