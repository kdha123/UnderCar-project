<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 창</title>
<script type="text/javascript">
$(function(){
	$("#notagree").click(function(){
		alert("약관에 동의를 하지않으면 회원가입할 수 없습니다.");
		$("#agree").focus();
	});
	$("#agreeBtn").click(function(){    
        if($("#agree").is(":checked") == false){
            alert("약관에 동의 하셔야 다음 단계로 진행 가능합니다.");
            return false;
        }
	});
});
</script>
</head>
<body>
 <table style="margin: auto;">
  <tr>
   <td>
    <b>회원약관 확인</b>
    <br>
    <hr>
   </td>
  </tr>
  <tr>
   <td width="100%" height="50%" align="center">
   <br>
   <textarea
     rows="20" cols="130">언더카(주)에 회원가입 신청하시는 분께 차량 광고등록에 관련한 제한사항에 대해 안내해 드리니, 자세히 읽은 후 동의해 주시기 바랍니다.

광고제한
1) 허위매물로 신고가 접수되어 관리자에 의해 확인된 차량
2) 딜러 회원이 개인 ID를 생성하여 등록한 개인 위장 매물
3) 차량의 실 소유주(차주)에게 허위매물로 신고된 차량
4) 차량이 판매되었으나 삭제하지 않은 모든 차량
5) 사이트 이용정지 시 등록되어 있는 모든 차량
6) 딜러 회원이 소속된 단지 차량이 아닌 타 단지에 등록된 차량
7) 실소유주(차주) 또는 동일 상사 직원이 감가 사유 없이 현저히 낮은 금액으로 광고하는 차량
8) 소속 조합에 정상 제시되지 않은 차량
9) 사진상 차량번호와 광고에 입력된 차량번호가 다른 차량
10) 개인 정보를 실제와 다르게 입력한 회원의 등록된 모든 차량
11) 판매 약관, 이용약관 및 관리자의 안내에 반하여 사이트에 등록된 모든 차량
※ 허위매물 신고 접수 후 7일 이내 관리자 요청 서류를 통한 소명 가능, 기간 이후 신고 삭제 불가

사이트 이용 정지
- 1년 이용 정지
  1) 관리자에 의해 허위매물 등록자로 확인된 경우 신고 횟수에 상관없이 1년 이용정지
  2) 허위매물 신고 5회 받을 시 1년 이용정지
  3) 자동 업데이트, 차량등록 프로그램 등 서버에 무리를 주는 불법 프로그램 사용 적발 시 허위매물 신고와 상관없이 1년 이용정지
  4) 사이트 내의 게시판 혹은 회원 광고 차량 구매 문의에 과도한 매입 광고를 한 경우 1년 이용정지
  5) 타인의 개인 연락처를 도용하여 사용하는 경우 1년 이용정지
- 영구 이용 정지
  1) 기존 이용 정지자가 다른 ID를 사용해서 차량을 등록하거나, 등록 시도를 하는 경우 신고 횟수와 상관없이 영구 이용정지
  2) 기존 이용 정지자의 정보를 입력하거나 사용 또는 사용 시도 하는 경우 영구 이용정지
  3) 명백한 사기행위, 공서양속에 반하는 행위를 한 이용자의 경우 영구 이용정지
  4) 이용정지 2회 누적 시 영구 이용정지
  5) 이용정지 상태가 아닌 허위매물 신고 누적 횟수가 4회 이상일 땐 환불 요청이 가능하지만, 해당 ID 영구 이용정지 조치 후 환불 규정에 따라 환불 처리
※ 이용정지시 로그인, 차량등록 제한 및 등록차량 삭제, 등록비 등 일체 비용 환불 불가

상사 제한
동일 상사에 소속된 딜러 회원 중 이용 정지자가 3명 이상 발생한 경우 아래와 같이 처리

1) 해당 상사에서 보유한 모든 차량, 엔카 광고등록 제한
2) 해당 상사에 소속된 모든 회원, 엔카 이용 제한
※ 명백한 사기행위, 공서양속에 반하는 행위를 한 상사 직원 확인 시 정지자 수 상관없이 상사 제한 가능

개인정보 도용
타인의 주민등록번호를 도용하여 ID를 생성한 경우 신고횟수와 상관없이 영구 제명되며 형사고발을 통해 처벌될 수 있음
※2006년 9월 24일 개정된 주민등록법 제21조 2항 제9호에 의거, 3년 이하의 징역 또는 1천만 원 이하의 벌금 부과

허위 신고자 이용제한 및 허위 신고 기준
1) 보복성으로 허위 신고를 한 경우 허위 신고 횟수에 상관없이 1년 이용정지
2) 신고 내용에 의미 없는 내용으로만 작성하여 신고한 경우
3) 신고내용이 사실과 다른 경우
4) 허위매물 허위 신고가 5건 누적되는 경우 1년 이용정지
5) 관리자에 의해 악의적인 허위신고라 판단되는 경우 신고 횟수와 상관없이 1년 이용정지
   </textarea>
   <br>
   <input type="checkbox" id="agree" required="required"> 언더카 규정 및 약관에 동의합니다.
   </td>
  </tr>
  <tr>
   <td align="center" valign="top">
    <a href="joinForm.do?grade=${param.grade }"><button id="agreeBtn">동의</button></a>
    <button id="notagree">동의안함</button>
   </td>
  </tr>
 </table>
</body>
</html>