<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메시지 상세보기</title>
<style type="text/css">
table{margin: 5px 5px 5px 5px;}
th{width: 200px;}
#reply{margin-left: 100px;}
</style>
<script type="text/javascript">
$(function(){
	// 삭제 전 확인
	$("#deleteBtn").click(function() {
		if (!confirm("정말 삭제하시겠습니까?"))
			return false;
	});
	// 이전 페이지의 URL 가져오기
	var url =  document.referrer;
	$("#deleteBtn").click(function(){
		// URL을 확인 후 받은 메시지 함인지 보낸 메시지 함인지, 안읽은 메시지함인지에 따른 pageType변수 설정
		// 받은 메시지함에서의 삭제 요청 시 -> pageType = 1 -> list.do로 redirect 
		if(url.indexOf("/list.do?pageType=acc") > 0){
			location = "delete.do?no="+${dto.no }+"&pageType=acc&deleteType=1&page=${param.page }&perPageNum=${param.perPageNum}&key=${param.key}&word=${param.word}";
		} else if(url.indexOf("/list.do?pageType=sen") > 0){
			location = "delete.do?no="+${dto.no }+"&pageType=sen&deleteType=1&page=${param.page }&perPageNum=${param.perPageNum}&key=${param.key}&word=${param.word}";
		} else if(url.indexOf("/list.do?pageType=no") > 0){
			location = "delete.do?no="+${dto.no }+"&pageType=no&deleteType=1&page=${param.page }&perPageNum=${param.perPageNum}&key=${param.key}&word=${param.word}";
		} else {
			location = "delete.do?no="+${dto.no }+"&pageType=all&deleteType=1&page=${param.page }&perPageNum=${param.perPageNum}&key=${param.key}&word=${param.word}";
		}
	});
	
	var accepter = "${dto.accepter }";
	var id = "${login.id }";
	if(accepter == id){
		$("#resend").show();
	} else {
		$("#resend").hide();
	}
	
});
</script>
</head>
<body>
<div>
<table class="table">
	<tr>
		<th>번호</th><td>${dto.no } [읽은 날짜: ${dto.acceptDate }]</td>
	</tr>
	<tr>
		<th>보낸 사람</th><td>${dto.sender }</td>
	</tr>
	<tr>
		<th>받은 사람</th><td>${dto.accepter }</td>
	</tr>
	<tr>
		<th>제목</th><td>${dto.title }</td>
	</tr>
	<tr>
		<th>내용</th><td><span>${dto.content }</span></td>
	</tr>
	<tr>
		<th>보낸 날짜</th><td>${dto.sendDate }</td>
	</tr>
	<tr>
		<td colspan="2">
			<a href="delete.do?no=${dto.no }&pageType=acc&deleteType=1&page=${param.page }&perPageNum=${param.perPageNum}&key=${param.key}&word=${param.word}">
			<button id="deleteBtn">삭제</button></a>
			<a href="list.do?page=${param.page }&perPageNum=${param.perPageNum}&key=${param.key}&word=${param.word}">
			<button>목록</button></a>
			<a href="writeForm.do?resend=1&sender=${dto.sender }" id="reply"><button id="resend">답변하기</button></a>
		</td>
	</tr>
</table>
</div>
</body>
</html>