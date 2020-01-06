<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tl" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
session.getAttribute("login");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판매 리스트</title>
<style type="text/css">
.dataRow:hover {
	background: #eee;
	cursor: pointer;
}
#search{border: 2px solid black; margin-bottom: 8px; height: 150px; width: 70%;}
#schTitle{margin-left: 5px;}
#schSelect{float: left;}
#photoDiv, #selDiv{border: 1px solid black; margin-bottom: 7px; margin-top: 3px;}
</style>
<script type="text/javascript">
	$(function() {
		$("#brand").change(function(){
			var brand = $("#brand").val();
			$("#model").empty();
			$("#year").empty();
			$("#cargrade").empty();
			$("#spec").empty();
			var brand = $("#brand").val().toString();
			$("#model").load("/ajax/modelGet.do?brand="+brand);
		});
		
		$("#model").change(function(){
			$("#year").empty();
			$("#cargrade").empty();
			$("#spec").empty();
			var model = $("#model").val();
			$("#year").load("/ajax/yearGet.do?model="+model);
		});
		
		$("#year").change(function(){
			$("#cargrade").empty();
			$("#spec").empty();
			var year = $("#year").val();
			$("#cargrade").load("/ajax/carGradeGet.do?year="+year);
		});
		
		$("#cargrade").change(function(){
			$("#spec").empty();
			var carGrade = $("#cargrade").val();
			$("#spec").load("/ajax/specGet.do?carGrade="+carGrade);
		});
		
		$("#spec").change(function(){
			var brand = $("#brand").val();
			var model = $("#model").val();
			var year = $("#year").val();
			var carGrade = $("#cargrade").val();
			var spec = $("#spec").val();
			alert("brand: "+brand+"\nmodel: "+model+"\nyear: "+year+"\ngrade: "+carGrade+"\nspec: "+spec);
			$("#photoDiv").load("/ajax/photoGet.do?", {brand: brand, model: model, year: year, carGrade: carGrade, spec: spec});
		});
		
		$(".pagination > li:not('.active')").click(
				function() {
					var page = $(this).data("page");
					location = "list.do?page=" + page
							+ "&perPageNum=${pageObject.perPageNum}"
							+ "&key=${pageObject.key}"
							+ "&word=${pageObject.word}";
					return false;
				});
		$("li.active").click(function() {
			return false;
		});
		$(".dataRow").click(function(){
			var no = $(this).find(".no").val();
			location = "view.do?no=" + no + "&page=${pageObject.page}"
						+ "&perPageNum=${pageObject.perPageNum}";
		});
	});
</script>
</head>
<body>
	<div class="container" align="center">
		<h2>판매 리스트</h2>
		<div id="search">
			<div id="schTitle">
				<h4>차량 검색</h4>
				<h5>국산차</h5>
				<form action="schList.do" method="post" id="searchForm">
				<input type="hidden" name="selType" value="1"/>
				<div id="schSelect" class="form-group">
				<div class="form-group" id="selDiv" align="left">
					<select class="form-group" id="brand" name="brand"> 
						<option selected="selected">제조사를 선택하세요.</option>
						<c:forEach var="bdto" items="${carBrandList }">
							<option>${bdto.brand }</option>
						</c:forEach>
					</select>
					<select class="form-group" id="model" name="model">
						<option selected="selected">모델를 선택하세요.</option>
					</select>
					<select class="form-group" id="year" name="year">
						<option selected="selected">연식을 선택하세요.</option>
					</select>
					<select class="form-group" id="cargrade" name="cargrade">
						<option selected="selected">등급을 선택하세요.</option>
					</select>
					<select class="form-group" id="spec" name="spec">
						<option selected="selected">스펙을 선택하세요.</option>
					</select>
					</div>
					<div id="photoDiv"></div>
					<div id="schDiv"><button type="submit"><span>검색</span></button></div>
				</div>
				</form>
			</div>
		</div>

			<div class="col-md-3 dataRow">
				<%if(session.getAttribute("login") != null){%>
				<a href="writeForm.do"><button class="btn btn-default">글쓰기</button></a> 
				<%}else{ %>
				<a href="/member/loginForm.do"><button class="btn btn-default">글쓰기<span style="color:red">(로그인 필요)</span></button></a>
				<%} %>
			</div>
			<div id="searchDiv">
					<form action="list.do" class="form-inline">
						<input name="page" value="1" type="hidden" />
<!-- 						<div class="form-group"> -->
<!-- 							<select class="form-control" id="key" name="key"> -->
<%-- 								<option value="t" ${(param.key == "t")?"selected":"" }>아이디</option> --%>
<%-- 								<option value="c" ${(param.key == "c")?"selected":"" }>이름</option> --%>
<%-- 								<option value="w" ${(param.key == "w")?"selected":"" }>연락처</option> --%>
<%-- 								<option value="tc" ${(param.key == "tc")?"selected":"" }>아이디/이름</option> --%>
<%-- 								<option value="tw" ${(param.key == "tw")?"selected":"" }>아이디/연락처</option> --%>
<%-- 								<option value="cw" ${(param.key == "cw")?"selected":"" }>이름/연락처</option> --%>
<%-- 								<option value="tcw" ${(param.key == "tcw")?"selected":"" }>전체</option> --%>
<!-- 							</select> -->
<!-- 						</div> -->
<!-- 						<div class="input-group"> -->
<!-- 							<input type="text" class="form-control" placeholder="Search" -->
<%-- 								name="word" value="${param.word }" id="word"> --%>
<!-- 							<div class="input-group-btn"> -->
<!-- 								<button class="btn btn-default" type="submit"> -->
<!-- 									<i class="glyphicon glyphicon-search"></i> -->
<!-- 								</button> -->
<!-- 							</div> -->
<!-- 						</div> -->
						<div class="input-group right">
								<span class="input-group-addon">Rows/Page</span>
							  <select class="form-control" id="perPageRow">
							    <option ${(pageObject.perPageNum == 10)?"selected='selected'":"" }>10</option>
							    <option ${(pageObject.perPageNum == 15)?"selected='selected'":"" }>15</option>
							    <option ${(pageObject.perPageNum == 20)?"selected='selected'":"" }>20</option>
							    <option ${(pageObject.perPageNum == 25)?"selected='selected'":"" }>25</option>
							  </select>
							</div>
					</form>
				</div>
		
		<!-- 이미지 겔러리 리스트 작성 -->
		<div class="row" align="center" id="list">
		 <!-- 데이터가 있는 만큼 반복문처리 시작. -->
		 <c:forEach items="${list }" var="dto" varStatus="vs">
			<!-- col 시작 : no, title, id, writeDate, fileName -->
		    <div class="col-md-3 dataRow">
		      <div class="thumbnail"  style="width:100%">
		          <img src="${dto.file1 }" alt="${dto.file1 }" style="width:100%">
		          <div class="caption">
		          <input type="hidden" class="no" id="no" name="no" value="${dto.no }">
		            <p>${dto.year } ${dto.grade }</p>
		            <c:if test="${dto.condition == 0}">
		            <p>${dto.spec } <span style="color:red">[판매중]</span></p>
		            </c:if>
		            <c:if test="${dto.condition == 1}">
		            <p>${dto.spec } <span style="color:blue">[판매완료]</span></p>
		            </c:if>
		            <p><fmt:formatNumber value="${dto.distance }" pattern="#,###"></fmt:formatNumber> km</p>
		            <p><fmt:formatNumber value="${dto.price }" pattern="#,###,###"></fmt:formatNumber> 원</p>
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
		</div>
		</div>
		<!-- row의 끝 -->	
		
		<!-- 페이지 네비게이션 처리 -->
		<div align="center">
			<c:if test="${pageObject.totalPage >= 1 }">
				<tl:pageNav endPage="${pageObject.endPage }" 
				  totalPage="${pageObject.totalPage }"
				  startPage="${pageObject.startPage }"
				  page="${pageObject.page }"></tl:pageNav>
			</c:if>
		</div>
</body>
</html>