<%@page import="com.undercar.member.dto.LoginDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="tl" tagdir="/WEB-INF/tags"%>
    
<!DOCTYPE html>
<html>
<head>

<%

request.setCharacterEncoding("utf-8");//post 요청 한글처리
//******* id  얻기
LoginDTO dto = (LoginDTO)session.getAttribute("login");
int grade;
if(dto != null){
	grade= dto.getGrade();
}else{
	grade = 0;
}


%>
<meta charset="UTF-8">
<title>faq 리스트</title>
<script type="text/javascript">
$(function() {
$(".dataRow").click(function() {
	var no = $(this).find(".no").text();
	location = "view.do?no=" + no
	+ "&page=${pageObject.page}"
	+ "&perPageNum=${pageObject.perPageNum}"
	   ${(!empty pageObject.word)? 
			   " + \"&key=" += pageObject.key += "&word="
			   += pageObject.word += "\"":""}
	    ;
});

var grade = "<%=grade%>";
	if(grade<9){
$("#write").hide();

	}//관리자 아니면 글쓰기 없애기

//페이지 네이션의 클릭 이벤트 처리
$(".pagination > li:not('.active')").click(
		function() {
			// 		alert("페이지 이동 클릭");
			// .data("page") ==> 속성 중에서 data-page 라는 속성의 값을 가져온다.
			var page = $(this).data("page");

			location = "list.do?page=" + page
					+ "&perPageNum=${pageObject.perPageNum}"
					+ "&key=${pageObject.key}"
					+ "&word=${pageObject.word}";
			// a tag의 페이지 이동을 취소 시킨다.
			return false;
		});
$("li.active").click(function() {
	return false;
});
// 한페이지에 나타날 글의 갯수 변경 이벤트 처리
$("#perPageRow").on({
	"change":function(){
		perPageNum = $("#perPageRow").val();
		location="list.do?page=1"
			+ "&perPageNum=" + perPageNum
			+ "&key=${pageObject.key}"
			+ "&word=${pageObject.word}";
	}
});






});//끝

</script>
<style type="text/css">
.dataRow:hover{
background: #eee;
cursor: pointer;
}
</style>
</head> 
<body>
<div class="container">
 <h1 align="center">자주하는 질문</h1>
				<h3 align="right"><a href="faq1.do">간단질문보러가기</a></h3>
 <div id="searchDiv">
			<form action="list.do" class="form-inline">
				<input name="page" value="1" type="hidden"/>
				<input name="perPageNum" value="${pageObject.perPageNum }" type="hidden"/>
				<div class="form-group">
					<select class="form-control" id="key" name="key">
						<option value="t" ${(param.key == "t")?"selected='selected'":"" }>제목</option>
						<option value="c" ${(param.key == "c")?"selected='selected'":"" }>내용</option>
						<option value="tc" ${(param.key=="tc")?"selected='selected'":"" }>제목/내용</option>
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
				<div class="input-group right">
				 <span class="input-group-addon">Rows/Page</span>
				 <select class="form-control" id="perPageRow">
				 <option ${(pageObject.perPageNum == 10)?"selected='selected'":""}>10</option>
				 <option ${(pageObject.perPageNum == 15)?"selected='selected'":""}>15</option>
				 <option ${(pageObject.perPageNum == 20)?"selected='selected'":""}>20</option>
				 <option ${(pageObject.perPageNum == 25)?"selected='selected'":""}>25</option>
				 
				 </select>
				</div>
			</form>
		</div>
 <table class ="table">
 <tr>
 <td width="10%">글번호</td>
 <td>제목</td>
 
 </tr>
 <c:forEach items="${list }" var="dto">
 <tr class="dataRow">
 <td class="no">${dto.no}</td>
 <td>
${dto.title }</td>
 </tr>
 
 </c:forEach>
 <!-- 페이지를 이동시키는 페이지네이션 -->
			<tr>
				<td colspan="5">
								<tl:pageNav  page="${pageObject.page }"
			 startPage="${pageObject.startPage }" endPage="${pageObject.endPage }" 
			 totalPage="${pageObject.totalPage }" />

				</td>
			</tr>
 <tr>
 <td colspan="2">
 <a id ="write" href="writeForm.do"><button>등록하기</button> </a>
 </td>
 </tr>
 </table>


</div>

</body>
</html>