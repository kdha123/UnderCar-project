<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<div class="container">
  <h2>회원가입</h2>
  <hr>
  <p>회원의 종류를 선택해주세요 :</p><br>
  <p>고객님께서 해당하시는 회원의 종류를 선택해 주세요.<br>
회원종류에 따라 가입절차에 차이가 있으니 반드시 본인이 해당하는 경우를 선택해 주시기 바랍니다.</p>                  
  <ul class="pager">
    <li>
    <a href="agree.do?grade=1" style="display:block-inline; width:300px; height:400px; border:1px  solid; color:FFF; padding:10px">
    <b>개인회원</b><br>
    만 14세 이상의 개인으로 차량을 팔거나<br>
     사려는 회원<br>
    본인 명의로 소유한지 6개월이 지난<br>
    차량을 1년에 4대까지 광고하여 판매</a>
    </li>
    <li>
    <a href="agree.do?grade=4" style="display:block-inline; width:300px; height:400px; border:1px  solid; color:FFF; padding:10px">
   <b>기업회원</b><br>
   차량을 전문적으로 사거나 판매하는<br>
 매매상사 딜러 회원<br>
 자동차관리법 제 2조 제 7항에 규정된<br>
 '자동차매매업'을 영위하는 사업자   </a>
    </li>
  </ul>
</div>
</body>
</html>