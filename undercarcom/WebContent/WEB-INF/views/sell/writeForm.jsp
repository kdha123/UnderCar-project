<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("utf-8");
session.getAttribute("login");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
// alert("${carBrandList}");
// alert("${carClassList}");
// alert("${kModelList}");
// alert("${hModelList}");
// alert("${sModelList}");
// alert("${ssModelList}");
// alert("${gmModelList}");
// alert("${carItemsList}");
$(function (){
	if($("#brand").val()=="현대"){
		$("brand").val
	}
	$("#brand").change(function(){
// 		alert($("#brand").val());
		var brand = $("#brand").val();
// 		alert(brand);
		if($("#brand").val() == "현대"){
			$("#model").empty();
			$("#year").empty();
			$("#cargrade").empty();
			$("#spec").empty();
			$("#model").append("<option>" + "모델을 선택해주세요" + "</option>");
			$("#model").append("<c:forEach var='hdto' items='${hModelList }'><option>" + "${hdto.model }" + "</option></c:forEach>");
		}else if($("#brand").val() == "기아"){
			$("#model").empty();
			$("#year").empty();
			$("#cargrade").empty();
			$("#spec").empty();
			$("#model").append("<option>" + "모델을 선택해주세요" + "</option>");
			$("#model").append("<c:forEach var='kdto' items='${kModelList }'><option>" + "${kdto.model }" + "</option></c:forEach>");
		}else if($("#brand").val() == "르노삼성"){
			$("#model").empty();
			$("#year").empty();
			$("#cargrade").empty();
			$("#spec").empty();
			$("#model").append("<option>" + "모델을 선택해주세요" + "</option>");
			$("#model").append("<c:forEach var='sdto' items='${sModelList }'><option>" + "${sdto.model }" + "</option></c:forEach>");
		}else if($("#brand").val() == "한국GM"){
			$("#model").empty();
			$("#year").empty();
			$("#cargrade").empty();
			$("#spec").empty();
			$("#model").append("<option>" + "모델을 선택해주세요" + "</option>");
			$("#model").append("<c:forEach var='gmdto' items='${gmModelList }'><option>" + "${gmdto.model }" + "</option></c:forEach>");
		}else if($("#brand").val() == "르노삼성"){
			$("#model").empty();
			$("#year").empty();
			$("#cargrade").empty();
			$("#spec").empty();
			$("#model").append("<option>" + "모델을 선택해주세요" + "</option>");
			$("#model").append("<c:forEach var='sdto' items='${sModelList }'><option>" + "${sdto.model }" + "</option></c:forEach>");
		}else if($("#brand").val() == "쌍용"){
			$("#model").empty();
			$("#year").empty();
			$("#cargrade").empty();
			$("#spec").empty();
			$("#model").append("<option>" + "모델을 선택해주세요" + "</option>");
			$("#model").append("<c:forEach var='ssdto' items='${ssModelList }'><option>" + "${ssdto.model }" + "</option></c:forEach>");
		};
	});
// 	$("#model").change(function(){
// 		if($("#model").val() == "i30"){
// 			$("#year").empty();
// 			$("#year").append("<option>" + "연식을 선택하세요" + "</option>");
// 			$("#year").append("<c:forEach var='year' items='${carItems}'><option>" + "${year}" +"</option></c:forEach>");
// 		}
// 	});
	
	$("#model").change(function(){
// 		alert($("#model").val());
		$("#year").empty();
		$("#cargrade").empty();
		$("#spec").empty();
		var model = $("#model").val().toString();
// 		alert(typeof model);
		$("#year").load("/ajax/yearGet.do?model="+model);
// 		alert("${carmodel}")
		
	});
	$("#year").change(function(){
		$("#cargrade").empty();
		$("#spec").empty();
		var year = $("#year").val();
// 		alert($("#year").val());
		$("#cargrade").load("/ajax/carGradeGet.do?year="+year);
	});
	$("#cargrade").change(function(){
		$("#spec").empty();
		var carGrade = $("#cargrade").val();
// 		alert($("#cargrade").val());
		$("#spec").load("/ajax/specGet.do?carGrade="+carGrade);
	});
	
});
</script>
</head>
<body>
<div class="container">
	<h2>판매 차량 등록</h2>
	<form action="write.do" method="post" id="writeForm" enctype="multipart/form-data">
		<div class="form-group">
			<label for="writer">작성자</label>
			<input type="text" class="form-control" id="writer" name="writer"
				value="${login.id }" readonly="readonly"/>
		</div>
		<div>
			<table>
				<tr>
					<td>차량번호</td>
					<td><input type="text" class="form-control" id="carnumber" name="carnumber"></td>
					<td>색상</td>
					<td><input type="text" class="form-control" id="color" name="color"></td>
				</tr>
				<tr>
					<td>주행거리</td>
					<td><input type="text" class="form-control" id="distance" name="distance" pattern="^[0-9]{1,7}$" placeholder="숫자로 입력해주세요"></td>
					<td>가격</td>
					<td><input type="text" class="form-control" id="price" name="price" pattern="^[0-9]{1,9}$" placeholder="숫자로 입력해주세요"></td>
				</tr>
				<tr>
					<td>연료</td>
					<td><input type="text" class="form-control" id="fuel" name="fuel" placeholder="가솔린, 디젤, LPG등"></td>
					<td>변속기</td>
					<td><input type="text" class="form-control" id="trans" name="trans" placeholder="자동, 수동 등"></td>
				</tr>
				<tr>
					<td>지역</td>
					<td><input type="text" class="form-control" id="location" name="location"></td>
				</tr>
			</table>
		</div>
		<div class="form-group">
			<label for="content">내용</label>
			<textarea rows="5" cols="8" class="form-control" id="content" name="content"
				placeholder="내용 입력" maxlength="2000"></textarea>
		</div>
		<div class="form-group">
			<select id="brand" name="brand">
				<option selected="selected">제조사를 선택하세요</option>
				<c:forEach var="bdto" items="${carBrandList }">
				<option>${bdto.brand }</option>
				</c:forEach>
			</select>
			
			<select class="form-group" id="model" name="model">
			</select>
			
			<select class="form-group" id="year" name="year">
			</select>
			
			<select class="form-group" id="cargrade" name="cargrade">
			</select>
			
			<select class="form-group" id="spec" name="spec">
			</select>
			
		</div>
		<div>
			<table>
				<tr>
					<td>정면<span style="color:red">(필수)</span> :</td>
					<td><input type="file" name="file1"/></td>
					<td>뒷면<span style="color:red">(필수)</span> :</td>
					<td><input type="file" name="file2"/></td>
				</tr>
				<tr>
					<td>좌측면<span style="color:red">(필수)</span> :</td>
					<td><input type="file" name="file3"/></td>
					<td>우측면<span style="color:red">(필수)</span> :</td>
					<td><input type="file" name="file4"/></td>
				</tr>
				<tr>
					<td>계기판<span style="color:red">(필수)</span> :</td>
					<td><input type="file" name="file5"/></td>
					<td>휠타이어<span style="color:red">(필수)</span> :</td>
					<td><input type="file" name="file6"/></td>
				</tr>
				<tr>
					<td>실내<span style="color:red">(필수)</span> :</td>
					<td><input type="file" name="file7"/></td>
					<td>옵션<span style="color:red">(필수)</span> :</td>
					<td><input type="file" name="file8"/></td>
				</tr>
				<tr>
					<td>기타1 :</td>
					<td><input type="file" name="file9"/></td>
					<td>기타2:</td>
					<td><input type="file" name="file10"/></td>
				</tr>
				<tr>
					<td>기타3 :</td>
					<td><input type="file" name="file11"/></td>
					<td>기타4 :</td>
					<td><input type="file" name="file12"/></td>
				</tr>
				<tr>
					<td>기타5 :</td>
					<td><input type="file" name="file13"/></td>
					<td>기타6 :</td>
					<td><input type="file" name="file14"/></td>
				</tr>
				<tr>
					<td>기타7 :</td>
					<td><input type="file" name="file15"/></td>
					<td>기타8 :</td>
					<td><input type="file" name="file16"/></td>
				</tr>
				<tr>
					<td>기타9 :</td>
					<td><input type="file" name="file17"/></td>
					<td>기타10 :</td>
					<td><input type="file" name="file18"/></td>
				</tr>
				<tr>
					<td>기타11 :</td>
					<td><input type="file" name="file19"/></td>
					<td>기타12 :</td>
					<td><input type="file" name="file20"/></td>
				</tr>
			</table>
		</div>
		<div>
			<table>
				<tr><td colspan="6"><h4>옵션 체크 사항</h5></td></tr>
				<tr>
					<td><input type="checkbox" id="navi" name="navi" value="1">네비게이션</td>
					<td><input type="checkbox" id="sun" name="sun" value="1">썬루프</td>
					<td><input type="checkbox" id="smart" name="smart" value="1">스마트키</td>
					<td><input type="checkbox" id="wind" name="wind" value="1">통풍시트</td>
					<td><input type="checkbox" id="cruz" name="cruz" value="1">크루즈 컨트롤</td>
				</tr>
				<tr>
					<td><input type="checkbox" id="handle" name="handle" value="1">핸들열선</td>
					<td><input type="checkbox" id="ldws" name="ldws" value="1">차선일탈경보(LDWS)</td>
					<td><input type="checkbox" id="aeb" name="aeb" value="1">자동긴급제동(AEB)</td>
					<td><input type="checkbox" id="airbag" name="airbag" value="1">사이드&amp;커튼에어백</td>
					<td><input type="checkbox" id="mirror" name="mirror" value="1">전동접이식미러</td>
				</tr>
				<tr>
					<td><input type="checkbox" id="tpms" name="tpms" value="1">타이어공기압감지(TPMS)</td>
					<td><input type="checkbox" id="trunk" name="trunk" value="1">전동트렁크</td>
					<td><input type="checkbox" id="autolight" name="autolight" value="1">오토라이트</td>
					<td><input type="checkbox" id="wipper" name="wipper" value="1">레인센서와이퍼</td>
					<td><input type="checkbox" id="parking" name="parking" value="1">주차감지센서</td>
				</tr>
				<tr>
					<td><input type="checkbox" id="hot" name="hot" value="1">열선시트</td>
					<td><input type="checkbox" id="bluetooth" name="bluetooth" value="1">블루투스</td>
					<td><input type="checkbox" id="hipass" name="hipass" value="1">하이패스룸밀러</td>
					<td><input type="checkbox" id="sheet" name="sheet" value="1">가죽시트</td>
					<td><input type="checkbox" id="wheel" name="sheet" value="1">알루미늄휠</td>
				</tr>
				<tr>
					<td><input type="checkbox" id="pano" name="pano" value="1">파노라마썬루프</td>
					<td><input type="checkbox" id="ledlight" name="ledlight" value="1">LED헤드라이트</td>
					<td><input type="checkbox" id="airsus" name="airsus" value="1">에어서스</td>
				</tr>
				<tr>
				<td><h4>다른 옵션이 더 있으신가요?</h4></td>
				</tr>
				<tr>
				<td colspan="2">
					<input type="text" class="form-control" id="ctcontent" name="ctcontent" placeholder="다른 옵션을 적어주세요" maxlength="2000">
				</td>
				</tr>
			</table>
		</div>
		<div>
		<button type="submit" class="btn btn-success">등록완료</button>
		<button type="reset" class="btn btn-default">다시입력</button>
		<button type="button" onclick="history.back()" class="btn btn-default">취소</button>
		</div>
	</form>
</div>
</body>
</html>