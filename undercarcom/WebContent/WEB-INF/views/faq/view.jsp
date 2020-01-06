<%@page import="com.undercar.member.dto.LoginDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>faq 글보기</title>
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
<script type="text/javascript">
$(function(){
	// 버튼 이벤트 처리
	$("#deleteBtn").click(function(){
		if(!confirm("정말 삭제하시겠습니까?"))
			return false; // a tag의 href를 취소 시킨다. -> location.href를 변경하는 태그 a
		
	});

	var grade = "<%=grade%>";
	if(grade!=9){
$("#update,#delete").hide();
	}
});
</script>

<style type="text/css">


</style>
</head>
<body>
<h1>faq 글보기</h1>

<table class="table">
<tr>
<td ><strong>제목:</strong></td><td width="60%">${dto.title }</td>
<td  ><strong>글번호</strong></td><td >${dto.no}</td>
</tr>
<tr><td colspan="4" align="center" width="80%"><strong>글내용</strong></td>
</tr>
<tr>
<td colspan="4" style="white-space: pre;">${dto.content }

</tr>
<tr>
<td  align="right" colspan="4">
<a id="update" href="updateForm.do?no=${dto.no }&page=${param.page }&perPageNum=${param.perPageNum}&key=${param.key}&word=${param.word}"><button>수정</button></a>
<a id="delete" href="delete.do?no=${dto.no }&perPageNum=${param.perPageNum }"id="deleteBtn"><button>삭제</button></a>
<a href="list.do?page=${param.page }&perPageNum=${param.perPageNum }&key=${param.key }&word=${param.word}"><button>목록</button></a>
</td>
</tr>
</table>

</body>
</html>