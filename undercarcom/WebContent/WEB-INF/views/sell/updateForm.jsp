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
<style type="text/css">
.fileBox .fileName {display:inline-block;width:190px;height:30px;padding-left:10px;margin-right:5px;line-height:30px;border:1px solid #aaa;background-color:#fff;vertical-align:middle}
.fileBox .btn_file {display:inline-block;border:1px solid #000;width:100px;height:30px;font-size:0.8em;line-height:30px;text-align:center;vertical-align:middle}
.fileBox input[type="file"] {position:absolute;width:1px;height:1px;padding:0;margin:-1px;overflow:hidden;clip:rect(0,0,0,0);border:0}
</style>
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
	
	$('input:checkbox[value=1]').attr("checked", true);
	
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

	var uploadFile = $('.fileBox .uploadBtn');
	uploadFile.on('change', function(){
		if(window.FileReader){
			var filename = $(this)[0].files[0].name;
		} else {
			var filename = $(this).val().split('/').pop().split('\\').pop();
		}
		$(this).siblings('.fileName').val(filename);
	});
	
	$("#updateBtn").click(function(){
		$("#updateForm").submit();
	});
	
});
</script>
</head>
<body>
<div class="container">
	<h2>판매 차량 등록</h2>
	<form action="update.do" method="post" id="updateForm" enctype="multipart/form-data">
		<input type="hidden" name="no" value="${dto.no }"/>
		<input type="hidden" name="deleteFile" value="${dto.file1 }"/>
		<input type="hidden" name="deleteFile" value="${dto.file2 }"/>
		<input type="hidden" name="deleteFile" value="${dto.file3 }"/>
		<input type="hidden" name="deleteFile" value="${dto.file4 }"/>
		<input type="hidden" name="deleteFile" value="${dto.file5 }"/>
		<input type="hidden" name="deleteFile" value="${dto.file6 }"/>
		<input type="hidden" name="deleteFile" value="${dto.file7 }"/>
		<input type="hidden" name="deleteFile" value="${dto.file8 }"/>
		<input type="hidden" name="deleteFile" value="${dto.file9 }"/>
		<input type="hidden" name="deleteFile" value="${dto.file10 }"/>
		<input type="hidden" name="deleteFile" value="${dto.file11 }"/>
		<input type="hidden" name="deleteFile" value="${dto.file12 }"/>
		<input type="hidden" name="deleteFile" value="${dto.file13 }"/>
		<input type="hidden" name="deleteFile" value="${dto.file14 }"/>
		<input type="hidden" name="deleteFile" value="${dto.file15 }"/>
		<input type="hidden" name="deleteFile" value="${dto.file16 }"/>
		<input type="hidden" name="deleteFile" value="${dto.file17 }"/>
		<input type="hidden" name="deleteFile" value="${dto.file18 }"/>
		<input type="hidden" name="deleteFile" value="${dto.file19 }"/>
		<input type="hidden" name="deleteFile" value="${dto.file20 }"/>
		<div class="form-group">
			<label for="writer">작성자</label>
			<input type="text" class="form-control" id="writer" name="writer"
				value="${login.id }" readonly="readonly"/>
		</div>
		<div>
			<table>
				<tr>
					<td>차량번호</td>
					<td><input type="text" class="form-control" id="carnumber" name="carnumber" value="${dto.carnumber }"></td>
					<td>색상</td>
					<td><input type="text" class="form-control" id="color" name="color" value="${dto.color }"></td>
				</tr>
				<tr>
					<td>주행거리</td>
					<td><input type="text" class="form-control" id="distance" name="distance" 
						pattern="^[0-9]{1,7}$" placeholder="숫자로 입력해주세요" value="${dto.distance }"></td>
					<td>가격</td>
					<td><input type="text" class="form-control" id="price" name="price" 
					pattern="^[0-9]{1,9}$" placeholder="숫자로 입력해주세요" value="${dto.price }"></td>
				</tr>
				<tr>
					<td>연료</td>
					<td><input type="text" class="form-control" id="fuel" name="fuel" 
					placeholder="가솔린, 디젤, LPG등" value="${dto.fuel }"></td>
					<td>변속기</td>
					<td><input type="text" class="form-control" id="trans" name="trans" 
					placeholder="자동, 수동 등" value="${dto.trans }"></td>
				</tr>
				<tr>
					<td>지역</td>
					<td><input type="text" class="form-control" id="location" name="location"
						value="${dto.location }"></td>
				</tr>
			</table>
		</div>
		<div class="form-group">
			<label for="content">내용</label>
			<textarea rows="5" cols="8" class="form-control" id="content" name="content"
				placeholder="내용 입력" maxlength="2000">${dto.content }</textarea>
		</div>
		<div class="form-group">
			<select id="brand" name="brand">
				<option selected="selected">${dto.brand }</option>
			</select>
			
			<select id="model" name="model">
				<option selected="selected">${dto.model }</option>
			</select>
			
			<select id="year" name="year">
				<option selected="selected">${dto.year }</option>
			</select>
			
			<select id="cargrade" name="cargrade">
				<option selected="selected">${dto.grade }</option>
			</select>
			
			<select id="spec" name="spec">
				<option selected="selected">${dto.spec }</option>
			</select>
			
		</div>
		<div>
			<table>
				<tr>
					<td>정면<span style="color:red">(필수)</span> :</td>
					<td class="fileBox">
						<input type="text" class="fileName" readonly="readonly" value="${dto.file1 }">
						<label for="uploadBtn" class="btn_file">찾아보기</label>
						<input type="file" name="file1" id="uploadBtn" class="uploadBtn"/>
					</td>
					<td>뒷면<span style="color:red">(필수)</span> :</td>
					<td class="fileBox">
						<input type="text" class="fileName" readonly="readonly" value="${dto.file2 }">
						<label for="uploadBtn" class="btn_file">찾아보기</label>
						<input type="file" name="file2" id="uploadBtn" class="uploadBtn"/>
					</td>
				</tr>
				<tr>
					<td>좌측면<span style="color:red">(필수)</span> :</td>
					<td class="fileBox">
						<input type="text" class="fileName" readonly="readonly" value="${dto.file3 }">
						<label for="uploadBtn" class="btn_file">찾아보기</label>
						<input type="file" name="file3" id="uploadBtn" class="uploadBtn"/>
					</td>
					<td>우측면<span style="color:red">(필수)</span> :</td>
					<td class="fileBox">
						<input type="text" class="fileName" readonly="readonly" value="${dto.file4 }">
						<label for="uploadBtn" class="btn_file">찾아보기</label>
						<input type="file" name="file4" id="uploadBtn" class="uploadBtn"/>
					</td>
				</tr>
				<tr>
					<td>계기판<span style="color:red">(필수)</span> :</td>
					<td class="fileBox">
						<input type="text" class="fileName" readonly="readonly" value="${dto.file5 }">
						<label for="uploadBtn" class="btn_file">찾아보기</label>
						<input type="file" name="file5" id="uploadBtn" class="uploadBtn"/>
					</td>
					<td>휠타이어<span style="color:red">(필수)</span> :</td>
					<td class="fileBox">
						<input type="text" class="fileName" readonly="readonly" value="${dto.file6 }">
						<label for="uploadBtn" class="btn_file">찾아보기</label>
						<input type="file" name="file6" id="uploadBtn" class="uploadBtn"/>
					</td>
				</tr>
				<tr>
					<td>실내<span style="color:red">(필수)</span> :</td>
					<td class="fileBox">
						<input type="text" class="fileName" readonly="readonly" value="${dto.file7 }">
						<label for="uploadBtn" class="btn_file">찾아보기</label>
						<input type="file" name="file7" id="uploadBtn" class="uploadBtn"/>
					</td>
					<td>옵션<span style="color:red">(필수)</span> :</td>
					<td class="fileBox">
						<input type="text" class="fileName" readonly="readonly" value="${dto.file8 }">
						<label for="uploadBtn" class="btn_file">찾아보기</label>
						<input type="file" name="file8" id="uploadBtn" class="uploadBtn"/>
					</td>
				</tr>
				<tr>
					<td>기타1 :</td>
					<td class="fileBox">
						<input type="text" class="fileName" readonly="readonly" value="${dto.file9 }">
						<label for="uploadBtn" class="btn_file">찾아보기</label>
						<input type="file" name="file9" id="uploadBtn" class="uploadBtn"/>
					</td>
					<td>기타2:</td>
					<td class="fileBox">
						<input type="text" class="fileName" readonly="readonly" value="${dto.file10 }">
						<label for="uploadBtn" class="btn_file">찾아보기</label>
						<input type="file" name="file10" id="uploadBtn" class="uploadBtn"/>
					</td>
				</tr>
				<tr>
					<td>기타3 :</td>
					<td class="fileBox">
						<input type="text" class="fileName" readonly="readonly" value="${dto.file11 }">
						<label for="uploadBtn" class="btn_file">찾아보기</label>
						<input type="file" name="file11" id="uploadBtn" class="uploadBtn"/>
					</td>
					<td>기타4 :</td>
					<td class="fileBox">
						<input type="text" class="fileName" readonly="readonly" value="${dto.file12 }">
						<label for="uploadBtn" class="btn_file">찾아보기</label>
						<input type="file" name="file12" id="uploadBtn" class="uploadBtn"/>
					</td>
				</tr>
				<tr>
					<td>기타5 :</td>
					<td class="fileBox">
						<input type="text" class="fileName" readonly="readonly" value="${dto.file13 }">
						<label for="uploadBtn" class="btn_file">찾아보기</label>
						<input type="file" name="file13" id="uploadBtn" class="uploadBtn"/>
					</td>
					<td>기타6 :</td>
					<td class="fileBox">
						<input type="text" class="fileName" readonly="readonly" value="${dto.file14 }">
						<label for="uploadBtn" class="btn_file">찾아보기</label>
						<input type="file" name="file14" id="uploadBtn" class="uploadBtn"/>
					</td>
				</tr>
				<tr>
					<td>기타7 :</td>
					<td class="fileBox">
						<input type="text" class="fileName" readonly="readonly" value="${dto.file15 }">
						<label for="uploadBtn" class="btn_file">찾아보기</label>
						<input type="file" name="file15" id="uploadBtn" class="uploadBtn"/>
					</td>
					<td>기타8 :</td>
					<td class="fileBox">
						<input type="text" class="fileName" readonly="readonly" value="${dto.file16 }">
						<label for="uploadBtn" class="btn_file">찾아보기</label>
						<input type="file" name="file16" id="uploadBtn" class="uploadBtn"/>
					</td>
				</tr>
				<tr>
					<td>기타9 :</td>
					<td class="fileBox">
						<input type="text" class="fileName" readonly="readonly" value="${dto.file17 }">
						<label for="uploadBtn" class="btn_file">찾아보기</label>
						<input type="file" name="file17" id="uploadBtn" class="uploadBtn"/>
					</td>
					<td>기타10 :</td>
					<td class="fileBox">
						<input type="text" class="fileName" readonly="readonly" value="${dto.file18 }">
						<label for="uploadBtn" class="btn_file">찾아보기</label>
						<input type="file" name="file18" id="uploadBtn" class="uploadBtn"/>
					</td>
				</tr>
				<tr>
					<td>기타11 :</td>
					<td class="fileBox">
						<input type="text" class="fileName" readonly="readonly" value="${dto.file19 }">
						<label for="uploadBtn" class="btn_file">찾아보기</label>
						<input type="file" name="file19" id="uploadBtn" class="uploadBtn"/>
					</td>
					<td>기타12 :</td>
					<td class="fileBox">
						<input type="text" class="fileName" readonly="readonly" value="${dto.file20 }">
						<label for="uploadBtn" class="btn_file">찾아보기</label>
						<input type="file" name="file20" id="uploadBtn" class="uploadBtn"/>
					</td>
				</tr>
			</table>
		</div>
		<div>
			<table>
				<tr><td colspan="6"><h4>옵션 체크 사항</h4></td></tr>
				<tr>
					<td><input type="checkbox" id="navi" name="navi" value="${dto.navi }">네비게이션</td>
					<td><input type="checkbox" id="sun" name="sun" value="${dto.sun }">썬루프</td>
					<td><input type="checkbox" id="smart" name="smart" value="${dto.smart }">스마트키</td>
					<td><input type="checkbox" id="wind" name="wind" value="${dto.wind }">통풍시트</td>
					<td><input type="checkbox" id="cruz" name="cruz" value="${dto.cruz }">크루즈 컨트롤</td>
				</tr>
				<tr>
					<td><input type="checkbox" id="handle" name="handle" value="${dto.handle }">핸들열선</td>
					<td><input type="checkbox" id="ldws" name="ldws" value="${dto.ldws }">차선일탈경보(LDWS)</td>
					<td><input type="checkbox" id="aeb" name="aeb" value="${dto.aeb }">자동긴급제동(AEB)</td>
					<td><input type="checkbox" id="airbag" name="airbag" value="${dto.airbag }">사이드&amp;커튼에어백</td>
					<td><input type="checkbox" id="mirror" name="mirror" value="${dto.mirror }">전동접이식미러</td>
				</tr>
				<tr>
					<td><input type="checkbox" id="tpms" name="tpms" value="${dto.tpms }">타이어공기압감지(TPMS)</td>
					<td><input type="checkbox" id="trunk" name="trunk" value="${dto.trunk }">전동트렁크</td>
					<td><input type="checkbox" id="autolight" name="autolight" value="${dto.autolight }">오토라이트</td>
					<td><input type="checkbox" id="wipper" name="wipper" value="${dto.wipper }">레인센서와이퍼</td>
					<td><input type="checkbox" id="parking" name="parking" value="${dto.parking }">주차감지센서</td>
				</tr>
				<tr>
					<td><input type="checkbox" id="hot" name="hot" value="${dto.hot }">열선시트</td>
					<td><input type="checkbox" id="bluetooth" name="bluetooth" value="${dto.bluetooth }">블루투스</td>
					<td><input type="checkbox" id="hipass" name="hipass" value="${dto.hipass }">하이패스룸밀러</td>
					<td><input type="checkbox" id="sheet" name="sheet" value="${dto.sheet }">가죽시트</td>
					<td><input type="checkbox" id="wheel" name="wheel" value="${dto.wheel }">알루미늄휠</td>
				</tr>
				<tr>
					<td><input type="checkbox" id="pano" name="pano" value="${dto.pano }">파노라마썬루프</td>
					<td><input type="checkbox" id="ledlight" name="ledlight" value="${dto.ledlight }">LED헤드라이트</td>
					<td><input type="checkbox" id="airsus" name="airsus" value="${dto.airsus }">에어서스</td>
				</tr>
				<tr>
				<td><h4>다른 옵션이 더 있으신가요?</h4></td>
				</tr>
				<tr>
				<td colspan="2">
					<input type="text" class="form-control" id="ctcontent" name="ctcontent" placeholder="다른 옵션을 적어주세요" maxlength="2000" value="${dto.ctcontent }">
				</td>
				</tr>
			</table>
		</div>
		<div>
		<button type="submit" class="btn btn-default" id="updateBtn">수정완료</button>
		<button type="reset" class="btn btn-default">다시입력</button>
		<button type="button" onclick="history.back()" class="btn btn-default">취소</button>
		</div>
	</form>
</div>
</body>
</html>