<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
session.getAttribute("login");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판매 정보보기</title>
<script type="text/javascript" src="/js/regExUtil.js"></script>
<style type="text/css">
#message:hover{
	cursor: pointer;
}
</style>
<script type="text/javascript">
$(function(){
	var id = "${login.id }"
	$('input:checkbox[value=1]').attr("checked", true);

	var price = "${dto.price }";
    function comma(price) {
    	price = String(price);
        return price.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
    }
    $("#price").html(comma(price));
    
	var distance = "${dto.distance }";
    function comma(distance) {
    	distance = String(distance);
        return distance.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
    }
    $("#distance").html(comma(distance));
	
	// 버튼 이벤트 처리
	$("#deleteBtn").click(function(){
		if(!confirm("정말 삭제하시겠습니까?"))
			return false; // a tag의 href를 취소 시킨다. -> location.href를 변경하는 태그 a
	});
	
	$("#message").click(function(){
		if(id == ""){
			alert("로그인이 필요한 서비스 입니다.")
			location = "/member/loginForm.do";
		} else
			$("#messageModal").modal();
	});
	
	// reg 검사
	$("#modal_form").submit(function() {
		if(!inputDataCheck(title_RegEx, "#modal_title", title_err_msg))
			return false;
		if(!inputDataCheck(content_RegEx, "#modal_content", content_err_msg))
			return false;
	});
			if($("#condition").val()==0){
				$("#condition").append("<span style=\"color:red\">[판매중]</span>");
			}else if($("#condition").val()==1){
				$("#condition").append("<span style=\"color:blue\">[판매완료]</span>");
			}// end of else if
});
</script>
</head>
<body>
<div class="container">
	<div class="carousel slide" data-ride="carousel" id="myCarousel"
		style="float: left; width: 49%;">
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
			<li data-target="#myCarousel" data-slide-to="3"></li>
			<li data-target="#myCarousel" data-slide-to="4"></li>
			<li data-target="#myCarousel" data-slide-to="5"></li>
			<li data-target="#myCarousel" data-slide-to="6"></li>
			<li data-target="#myCarousel" data-slide-to="7"></li>
			<li data-target="#myCarousel" data-slide-to="8"></li>
			<li data-target="#myCarousel" data-slide-to="9"></li>
			<li data-target="#myCarousel" data-slide-to="10"></li>
		</ol>
		<div class="carousel-inner">
			<div class="item active">
				<img src="${dto.file1 }" alt="${dto.file1 }" style="width: 100%">
			</div>
			<div class="item">
				<img src="${dto.file2 }" alt="${dto.file2 }" style="width: 100%">
			</div>
			<div class="item">
				<img src="${dto.file3 }" alt="${dto.file3 }" style="width: 100%">
			</div>
			<div class="item">
				<img src="${dto.file4 }" alt="${dto.file4 }" style="width: 100%">
			</div>
			<div class="item">
				<img src="${dto.file5 }" alt="${dto.file5 }" style="width: 100%">
			</div>
			<div class="item">
				<img src="${dto.file6 }" alt="${dto.file6 }" style="width: 100%">
			</div>
			<div class="item">
				<img src="${dto.file7 }" alt="${dto.file7 }" style="width: 100%">
			</div>
			<div class="item">
				<img src="${dto.file8 }" alt="${dto.file8 }" style="width: 100%">
			</div>
			<div class="item">
				<img src="${dto.file9 }" alt="${dto.file9 }" style="width: 100%">
			</div>
			<div class="item">
				<img src="${dto.file10 }" alt="${dto.file10 }" style="width: 100%">
			</div>
			<div class="item">
				<img src="${dto.file11 }" alt="${dto.file11 }" style="width: 100%">
			</div>
			<div class="item">
				<img src="${dto.file12 }" alt="${dto.file12 }" style="width: 100%">
			</div>
			<div class="item">
				<img src="${dto.file13 }" alt="${dto.file13 }" style="width: 100%">
			</div>
			<div class="item">
				<img src="${dto.file14 }" alt="${dto.file14 }" style="width: 100%">
			</div>
			<div class="item">
				<img src="${dto.file15 }" alt="${dto.file15 }" style="width: 100%">
			</div>
			<div class="item">
				<img src="${dto.file16 }" alt="${dto.file16 }" style="width: 100%">
			</div>
			<div class="item">
				<img src="${dto.file17 }" alt="${dto.file17 }" style="width: 100%">
			</div>
			<div class="item">
				<img src="${dto.file18 }" alt="${dto.file18 }" style="width: 100%">
			</div>
			<div class="item">
				<img src="${dto.file19 }" alt="${dto.file19 }" style="width: 100%">
			</div>
			<div class="item">
				<img src="${dto.file20 }" alt="${dto.file20 }" style="width: 100%">
			</div>
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
	</div>
	<div style="float: right; width: 49%;">
		<table class="table">

			<tr>
				<th>번호[판매상태]</th>
				<td>${dto.carnumber }
				<c:if test="${dto.condition == 0 }">
				<span style="color:red">[판매중]</span>
				</c:if>
				<c:if test="${dto.condition == 1 }">
				<span style="color:blue">[판매완료]</span>
				</c:if>
				</td>
			</tr>
			<tr>
				<th>
					작성자 <span class="glyphicon glyphicon-envelope" id="message"></span>
				</th>
				<td>
					${dto.writer }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${dto.content }</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${dto.writeDate }</td>
			</tr>
			<tr>
				<th>등급</th>
				<td>${dto.year } ${dto.grade } ${dto.spec }</td>
			</tr>
			<tr>
				<th>지역</th>
				<td>${dto.location }</td>
			</tr>
			<tr>
				<th>주행거리</th>
				<td><span id="distance"></span>km</td>
			</tr>
			<tr>
				<th>차량가격</th>
				<td><span id="price"></span>원</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="hidden" value="${dto.no }" id="no" name="no" >
				</td>
			</tr>

		</table>
	</div>
</div>
	<div style="padding:10px;">
		<table>
			<tr>
				<td colspan="6"><h4>
						옵션 체크 사항
						</h4></td>
			</tr>
			<tr>
				<td><input type="checkbox" id="navi" name="navi" value="${dto.navi }" disabled="disabled">네비게이션</td>
				<td><input type="checkbox" id="sun" name="sun" value="${dto.sun }" disabled="disabled">썬루프</td>
				<td><input type="checkbox" id="smart" name="smart" value="${dto.smart }" disabled="disabled">스마트키</td>
				<td><input type="checkbox" id="wind" name="wind" value="${dto.wind }" disabled="disabled">통풍시트</td>
				<td><input type="checkbox" id="cruz" name="cruz" value="${dto.cruz }" disabled="disabled">크루즈
					컨트롤</td>
			</tr>
			<tr>
				<td><input type="checkbox" id="handle" name="handle" value="${dto.handle }" disabled="disabled">핸들열선</td>
				<td><input type="checkbox" id="ldws" name="ldws" value="${dto.ldws }" disabled="disabled">차선일탈경보(LDWS)</td>
				<td><input type="checkbox" id="aeb" name="aeb" value="${dto.aeb }" disabled="disabled">자동긴급제동(AEB)</td>
				<td><input type="checkbox" id="airbag" name="airbag" value="${dto.airbag }" disabled="disabled">사이드&amp;커튼에어백</td>
				<td><input type="checkbox" id="mirror" name="mirror" value="${dto.mirror }" disabled="disabled">전동접이식미러</td>
			</tr>
			<tr>
				<td><input type="checkbox" id="tpms" name="tpms" value="${dto.tpms }" disabled="disabled">타이어공기압감지(TPMS)</td>
				<td><input type="checkbox" id="trunk" name="trunk" value="${dto.trunk }" disabled="disabled">전동트렁크</td>
				<td><input type="checkbox" id="autolight" name="autolight" value="${dto.autolight }" disabled="disabled">오토라이트</td>
				<td><input type="checkbox" id="wipper" name="wipper" value="${dto.wipper }" disabled="disabled">레인센서와이퍼</td>
				<td><input type="checkbox" id="parking" name="parking" value="${dto.parking }" disabled="disabled">주차감지센서</td>
			</tr>
			<tr>
				<td><input type="checkbox" id="hot" name="hot" value="${dto.hot }" disabled="disabled">열선시트</td>
				<td><input type="checkbox" id="bluetooth" name="bluetooth" value="${dto.bluetooth }" disabled="disabled">블루투스</td>
				<td><input type="checkbox" id="hipass" name="hipass" value="${dto.hipass }" disabled="disabled">하이패스룸밀러</td>
				<td><input type="checkbox" id="sheet" name="sheet" value="${dto.sheet }" disabled="disabled">가죽시트</td>
				<td><input type="checkbox" id="wheel" name="wheel" value="${dto.wheel }" disabled="disabled">알루미늄휠</td>
			</tr>
			<tr>
				<td><input type="checkbox" id="pano" name="pano" value="${dto.pano }" disabled="disabled">파노라마썬루프</td>
				<td><input type="checkbox" id="ledlight" name="ledlight" value="${dto.ledlight }" disabled="disabled">LED헤드라이트</td>
				<td><input type="checkbox" id="airsus" name="airsus" value="${dto.airsus }" disabled="disabled">에어서스</td>
			</tr>
		</table>
		<table class="table">
			<tr>
			<td>추가옵션</td>
			<td>${dto.ctcontent }</td>
			</tr>
		</table>
	</div>
	<div>
		<table>
			<tr>
				<c:if test="${login.id == dto.writer || login.id == 'admin' }">
				<td colspan="3"><a href="updateForm.do?no=${dto.no }" class="btn btn-success">수정</a>
					<a href="delete.do?no=${dto.no }"><button class="btn btn-danger" id="deleteBtn">삭제</button></a> 
				</td>
				<c:if test="${dto.condition == 0 }">
				<td>
				<a href="complete.do?no=${dto.no }"><button class="btn btn-warning">판매완료</button></a>
				</td>
				</c:if>
				</c:if>
					<td>
					<a
					href="list.do?page=${param.page }&perPageNum=${param.perPageNum }"
					class="btn btn-default">리스트</a>
					</td>
			</tr>

		</table>
	</div>


<!-- 판매글 작성자에게 VIEW화면에서 메세지를 보내기 위한 Modal -->
  <div class="modal fade" id="messageModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header" style="padding:35px 50px;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4><span class="glyphicon glyphicon-envelope"></span> 메세지 보내기</h4>
        </div>
        <div class="modal-body" style="padding:40px 50px;">
          <form action="/message/write.do" role="form" method="post" id="modal_form">
            <input name="no" type="hidden" value="${dto.no }" />
			<input name="page" type="hidden" value="${param.page }" />
			<input name="perPageNum" type="hidden" value="${param.perPageNum }" />
			<input name="accCheck" type="hidden" value="2" />
            <div class="form-group">
              <label for="modal_content">
                <span class="glyphicon glyphicon-user"></span>
               	받는 사람
              </label>
              <%-- disabled 속성을 사용하면 데이터가 넘어가지 않는다 --%>
              <input class="form-control" id="modal_accepter" name="accepter" value="${dto.writer }" readonly="readonly">
            </div>
            <div class="form-group">
              <label for="modal_content">
                <span class="glyphicon glyphicon-comment"></span>
               	제목
              </label>
              <input class="form-control" id="modal_title" name="title">
            </div>
            <div class="form-group">
              <label for="modal_content">
                <span class="glyphicon glyphicon-calendar"></span>
               	내용
              </label>
              <textarea class="form-control" id="modal_content" name="content"rows="10"></textarea>
            </div>
            <div class="btn-group right">
             <button type="submit" class="btn btn-default btn-sm" id="messageModal_messageBtn">
          	 	<span class="glyphicon glyphicon-envelope"></span> 보내기 
        	 </button>
          	 <button type="button" class="btn btn-warning" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> 취소</button>
			</div> 
          </form>
        </div>
    </div>
  </div> 
</div>

</body>
</html>