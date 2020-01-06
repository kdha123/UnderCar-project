<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach items="${list }" var="dto" varStatus="vs">
<!-- col 시작 : no, title, id, writeDate, fileName -->
	<div class="col-md-3 dataRow">
		<div class="thumbnail">
		<img src="${dto.file1 }" alt="${dto.file1 }" style="width:100%">
			<div class="caption">
			<input type="hidden" class="no" id="no" name="no" value="${dto.no }">
				<p>${dto.year } ${dto.grade }</p>
				<p>${dto.spec }<span id="condition" name="condition" value="${dto.condition}"></span></p>
				<p>${dto.distance } km</p>
				<p><span style="width:130px; height:390px">${dto.price }원</span></p>
			</div>
		</div>
	</div>
<!-- 이미지를 3개 출력하면 줄을 바꾸는 처리 -->
	<c:if test="${vs.count % 3 == 0 }">
	<%="</div><div class='row'>" %>
	</c:if>
<!-- col의 끝 -->
</c:forEach>
		    <!-- 데이터가 있는 만큼 반복문처리 끝. -->