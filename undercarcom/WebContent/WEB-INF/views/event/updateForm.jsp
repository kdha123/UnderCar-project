<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 글수정 폼</title>
</head>
<body>
<form action="update.do" method="post" id="updateForm" enctype="multipart/form-data">
		<input type="hidden" name="page" value="${param.page }">
		<input type="hidden" name="perPageNum" value="${param.perPageNum }">
		<input type="hidden" name="deleteFile1" value="${dto.image}">
		<input type="hidden" name="deleteFile2" value="${dto.repImage}">
		<div class="form-group">
			<label for="title">번호</label>
			<input type="text" class="form-control" id="no" name="no" value="${dto.no }" readonly="readonly">
		</div>
		<div class="form-group">
			<label for="title">제목</label>
			<input type="text" class="form-control" id="title" name="title" value="${dto.title }">
		</div>
		<div class="form-group">
			<label for="image">이미지</label>
			<input multiple="multiple" type="file" class="form-control" id="image" name="image">
		</div>
		<div class="form-group">
			<label for="repImage">대표이미지</label>
			<input multiple="multiple" type="file" class="form-control" id="repImage" name="repImage">
		</div>
		<div class="form-group">
			<label for="startDate">이벤트 시작일</label>
			<input type="text" class="form-control" id="startDate" name="startDate">
		</div>
		<div class="form-group">
			<label for="endDate">이벤트 종료일</label>
			<input type="text" class="form-control" id="endDate" name="endDate">
		</div>

		<button type="submit" class="btn btn-success">수정</button>
		<button type="reset" class="btn btn-default">다시입력</button>
		<button type="button" onclick="history.back()" class="btn btn-warning">취소</button>
</form>
</body>
</html>