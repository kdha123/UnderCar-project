<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 글쓰기 폼</title>
</head>
<body>
<div class="container">
	<form action="write.do" method="post" id="writeForm" enctype="multipart/form-data">
		<div class="form-group">
			<label for="title">제목</label>
			<input type="text" class="form-control" id="title" name="title">
		</div>		
		<div class="form-group">
			<label for="image">이미지</label>
			<input multiple="multiple" type="file" class="form-control" id="image" name="image">
		</div>
		<div class="form-group">
			<label for="repImage">대표이미지</label>
			<input multiple="multiple" type="file" class="form-control" id="repImage" name="repImage">
		</div>
		
		<button type="submit" class="btn btn-success">등록</button>
		<button type="reset" class="btn btn-default">다시입력</button>
		<button type="button" onclick="history.back()" class="btn btn-warning">취소</button>
	</form>	
	</div>
</body>
</html>