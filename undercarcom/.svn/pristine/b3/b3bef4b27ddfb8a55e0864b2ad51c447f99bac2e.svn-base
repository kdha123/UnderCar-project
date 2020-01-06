<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>faq 업데이트</title>
<script type="text/javascript" src="/js/regExUtil2.js"></script>
<script type="text/javascript">
$(function(){
	 $("#updateForm").submit(function(){

		 if(!inputDataCheck(title_RegEx, "#title", title_err_msg))
				return false;
			//내용- 데이터가 유효하지 않으면(!) 더이상 진행하지 않고 false 를 리턴한다.	
			if(!inputDataCheck(content_RegEx,"#content",content_err_msg))		 
				return false;
});
});
</script>
</head>
<body>
<h1>수정하기</h1>

<form action="update.do" method="post" id="updateForm">
<input type="hidden" name="page" value="${param.page }">
		<input type="hidden" name="perPageNum" value="${param.perPageNum }">
		<input type="hidden" name="key" value="${param.key }">
		<input type="hidden" name="word" value="${param.word }">
<div class="form-group">
<label for="no">번호(수정불가)</label>
<input type="text" class="form-control" id="no" name="no" value="${dto.no }" readonly="readonly">
</div>

<div class="form-group">
<label for="title">제목</label>
<input type="text" class="form-control" id="title" name="title"
title="제목을 4~100 글자 사이로 입력하셔야 합니다." value="${dto.title }">

</div>
<div>
<label for="content">내용</label>
<textarea rows="10" cols="130" id="content" name="content" class="form-control"> ${dto.content }</textarea>
</div>
<div>
<button>수정</button>
		<button type="reset">다시입력</button>
		<button type="button" onclick="history.back()">취소</button>
</div>
</form>
</body>
</html>