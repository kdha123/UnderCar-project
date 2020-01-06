<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
$(function(){
	
  		$(".2").slideUp();
 	 
 	$(".a").click(function(){
      $("#q").css("display","block")
      $("#w,#e,#r,#t,#y,#u,#i").css("display","none")
 	});
 	$(".b").click(function(){
 	 $("#w").css("display","block")
      $("#q,#e,#r,#t,#y,#u,#i").css("display","none")
 	});
 	$(".c").click(function(){
  $("#e").css("display","block")
      $("#q,#w,#r,#t,#y,#u,#i").css("display","none")
	 
 	});
 	$(".d").click(function(){
      $("#r").css("display","block")
      $("#w,#e,#q,#t,#y,#u,#i").css("display","none")
 	});
 	$(".e").click(function(){
 	 $("#t").css("display","block")
      $("#q,#e,#r,#w,#y,#u,#i").css("display","none")
 	});
 	$(".f").click(function(){
  $("#y").css("display","block")
      $("#q,#w,#r,#t,#e,#u,#i").css("display","none")
	 
 	});
	$(".g").click(function(){
		  $("#i").css("display","block")
		      $("#q,#w,#r,#t,#y,#e,#e").css("display","none")
			 
		 	});
		 

	$(".1").on("click",function(){
		$(this).next().slideToggle(500,"linear");
	});
	
});
</script>
</head>
<body>


<img width="500" height="350" src="/image/web-20180113044711237724.png" alt="My Image">
<h2>원하시는 정보를 눌러주세요</h2>
<div class="container">


<span  class="btn btn-success a btn btn-primary btn-lg">언더카는</span>
<span class="btn btn-success b btn btn-primary btn-lg">내차살떄</span>
<span class="btn btn-success c btn btn-primary btn-lg">내차팔때</span>
<span class="btn btn-success d btn btn-primary btn-lg">언더카시세</span>
<span class="btn btn-success e btn btn-primary btn-lg">회원정보</span>
<span class="btn btn-success f btn btn-primary btn-lg">금융문의</span>
<span class="btn btn-success g btn btn-primary btn-lg">서비스</span>


</div>
<div id="zz">
<div class="a1" data-1 id="q"  style="display: none;">
<h2 style="margin-left: 30px;">언더카는</h2>
<ul>
<li id="1"  class="list-group-item list-group-item-success 1">Q.언더카의 다양한 서비스는 등록된 모든 차량에게 제공되는 건가요?</li>
<li id="2" class="list-group-item list-group-item-success 2">A.언더카에서는 고객님들께서 안심하고 차량을 거래하실 수 있도록 다양한 서비스를 제공해드리고 있어요.

다만 언더카 등록된 모든 차량에 대하여 서비스가 제공되는 것은 아니며, 서비스 제공 가능 여부를 차량 상세페이지에 안내해드리고 있으니 꼼꼼하게 확인해주세요!</li>
<li id="3" class="list-group-item list-group-item-info 1">Q.언더카는 유료인가요?</li>
<li id="4"class="list-group-item list-group-item-info 2">A.언더카 서비스는 무료입니다. 
언더카는 고객님들께는 안심하고 편리한 차량 거래를, 딜러님들께서는 온/오프라인 영업활동을 무료로 지원하는 자동차 종합 공유 플랫폼입니다. .</li>
<li id="5"class="list-group-item list-group-item-success 1">Q.언더카의 책임한계 및 면책고지 안내드립니다..</li>
<li id="6"class="list-group-item list-group-item-success 2">A.본 사이트에 제공되는 중고차 매물의 명/묵시적 자료 제공 및 실제 거래의 모든 책임은 자료를 직접 등록한 중고차 판매자에 있습니다</li>

</ul>
</div>
<div class="b1" data-2 id="w" style="display: none;">
<h2 style="margin-left: 30px;">내차살때</h2>
<ul>
<li class="list-group-item list-group-item-success 1">Q.안심번호(050)는 왜 사용하는건가요?></li>
<li class="list-group-item list-group-item-success 2">A.안심번호(050)는 차량광고별로 부여되는 연락처로 안심번호(050)로 통화를 하시면 통화가 녹취되어 혹시라도 나중에 분쟁이 발생하게 될 경우, 사실관계를 확인하는데 용이하답니다..</li>
<li class="list-group-item list-group-item-info 1">Q.안심번호(050)로 연락은 언제까지 가능한가요?</li> 
<li class="list-group-item list-group-item-info 2">A.매물에 대한 안심번호는 판매 완료 전까지 연락이 가능하고, 판매 완료 후에도 14일간 통화가 가능하세요..</li>
<li class="list-group-item list-group-item-success 1">Q.[구해줘언더카] 차를 잘 모르는데, 중고차 살 수 있나요?</li>
<li class="list-group-item list-group-item-success 2">A.럼요! 언더카에서라면 완전 가능! 간단한 조건 입력만으로 딜러가 직접 알맞은 차량을 추천해드리는 구해줘언더카가 있으니까요. </li>
<li class="list-group-item list-group-item-info 1">Q.[구해줘언더카] 추천차량은 어디서 확인하나요?</li> 
<li class="list-group-item list-group-item-info 2">A.구해춰언더카를 통해 추천되는 차량은

1. 언더카 운영팀이 엄선한 믿을 수 있는 딜러의
2. 실차주마크 획득한 딜러 소유차량에 한하여
3. 딜러가 직접 추가정보를 입력하여 추천드리는 차량</li>
<li class="list-group-item list-group-item-success 1">Q.[구해줘언더카] 차를 잘 모르는데, 중고차 살 수 있나요?</li>
<li class="list-group-item list-group-item-success 2">A.구해줘언더카는 고객님께서 신청하는 조건에 부합하는 차량을 가진 딜러가 신청일로부터 48시간 동안 실시간으로 차량을 추천해드려요. 

추천받은 차량은 실시간 알림톡으로 받아보실 수 있고, 언더카 견적함에서도 확인하실 수 있어요. </li>

</ul>
</div>
<div class="c1" data-3 id="e"  style="display: none;">
<h2 style="margin-left: 30px;">내차팔떄</h2>
<ul>
<li class="list-group-item list-group-item-success 1">Q.내 차를 팔고 싶은데 어떻게 팔아야 할까요?</li>
<li class="list-group-item list-group-item-success 2">A.언더카에서는 다양한 방식으로 내 차를 판매하실 수 있어요.</li>
<li class="list-group-item list-group-item-info 1">Q.핫마크에는 어떤 것들이 있나요?</li>
<li class="list-group-item list-group-item-info 2">A.핫마크는 차량의 특/장점을 3개의 마크로 표시하여 내 차의 매력을 뽐낼 수 있는 광고로.</li>
<li class="list-group-item list-group-item-success 1">Q.직거래와 팔아줘, 어떤 방식이 저에게 잘 맞을까요?</li>
<li class="list-group-item list-group-item-success 2">A.거래언더카는 내가 직접 차량을 광고하고 판매하는 것이기 때문에 각종 비용이 없어 딜러를 통하는 것보다 높은 가격에 판매가 가능합니다</li>
<li class="list-group-item list-group-item-info 1">Q.[직거래언더카] 유료인가요?</li>
<li class="list-group-item list-group-item-info 2">A.무료입니다! 각종 비용 없이 높은 가격에 내 차를 직접 등록하고 직접 판매하는 직거래언더카는 각종 비용은 물론 서비스 이용 수수료도 무료니 더욱 높은 가격에 판매하실 수 있어요..</li>
<li class="list-group-item list-group-item-success 1">Q.직거래언더카] 직거래언더카가 뭔가요??</li>
<li class="list-group-item list-group-item-success 2">A.직거래언더카는 딜러를 통하지 않고 내가 직접 내 차량에 대한 광고를 올리고 차량을 판매하는 판매방식으로 판매수수료, 딜러마진 등이 없어 보다 높은 가격에 판매하실 수 있어요.</li>
<li class="list-group-item list-group-item-info 1">Q.[팔아줘언더카] 차량 판매 시, 준비해야 할 서류가 있나요?</li>
<li class="list-group-item list-group-item-info 2">A.차량을 판매하실 때는 아래와 같은 서류들이 필요해요. 다만, 차량을 판매하시게 될 때, 입찰 딜러가 상세하게 안내해드리니 서류 준비에 관해서 부담 갖지 않으셔도 된답니다.</li>
<li class="list-group-item list-group-item-success 1">Q.[팔아줘언더카] 견적 받고 매각은 언제까지 결정해야 하나요?</li>
<li class="list-group-item list-group-item-success 2">A.팔아줘언더카를 통해 받으신 견적은 7일 간 유효해요.</li>

</ul>
</div>
<div class="c1" data-3 id="r"  style="display: none;">
<h2 style="margin-left: 30px;">언더카 시세</h2>
<ul>
<li class="list-group-item list-group-item-success 1">Q.AI기반 국민시세가 뭔가요??</li>
<li class="list-group-item list-group-item-success 2">A.언더카에서는 고객님들께서 보다 믿고 거래하실 수 있도록 AI 기반의 국민 시세를 제공해드리고 있어요. 그렇다면 이 AI기 반의 국민 시세는 어떻게 산정되는 걸까요?.</li>
<li class="list-group-item list-group-item-info 1">Q.중고차 시세에 영향을 주는 변수, 궁금하시죠?</li>
<li class="list-group-item list-group-item-info 2">A.언더카가 KASIT(카이스트)와 협력하여 분석한 중고차 시세에 영향을 미치는 변수, 영향도가 높은 순서대로 알려드릴게요.
 </li>

</ul>
</div>
</div>
<div class="c1" data-3 id="t"  style="display: none;">
<h2 style="margin-left: 30px;">회원정보</h2>
<ul>
<li class="list-group-item list-group-item-success 1">Q.정회원과 준회원의 차이가 있나요?</li>
<li class="list-group-item list-group-item-success 2">A준회원은 SNS를 통해 가입해주신 간편가입 회원으로 일부 서비스에 제한이 있어요. .</li>
<li class="list-group-item list-group-item-info 1">Q.회원가입은 어떻게 하나요?</li>
<li class="list-group-item list-group-item-info 2">A,언더카 회원가입은 APP은 물론 PC와 모바일웹에서도 가능하세요.</li>
<li class="list-group-item list-group-item-success 1">Q.회원가입을 하지않고 서비스를 이용할 순 없나요??</li>
<li class="list-group-item list-group-item-success 2">A.언더카의 서비스는 회원가입을 하셔야 이용하실 수 있어요..</li>

</ul>
</div>
<div class="c1" data-3 id="y"  style="display: none;">
<h2 style="margin-left: 30px;">금융문의</h2>
<ul>
<li class="list-group-item list-group-item-success 1">Q.차량구매 시 대출 신청이 가능한가요?</li>
<li class="list-group-item list-group-item-success 2">A.언더카에서는  등록된 차량에 대하여 무이자, 저금리 상품을 Direct로 제공하고 있어요.  .</li>

</ul>
</div>

<div class="c1" data-3 id="u"  style="display: none;">
<h2 style="margin-left: 30px;">회원정보</h2>
<ul>
<li class="list-group-item list-group-item-success 1">Q.코인은 어떻게 적립하나요??</li>
<li class="list-group-item list-group-item-success 2">A.고객님께서 로그인, 차량 상담, 방문 예약 등 언더카 서비스를 이용하실 때마다 풍성한 코인을 적립해드리고 있어요. 
적립항목은 로그인 ▶ 나의 언더카 ▶ 멤버십 혜택 ▶ 코인 사용/적립내역 ▶ 적립하기에서 확인하실 수 있어요.
언더카의 다양한 서비스 이용하시면서 코인도 적립하시고, 적립하신 코인으로 매물광고, 이벤트 참여 등 많은 혜택도 받아 가세요. :).</li>
<li class="list-group-item list-group-item-info 1">Q.코인을 구매하고 싶어요</li>
<li class="list-group-item list-group-item-info 2">A.코인은 매매 및 양도가 불가능해요..</li>
<li class="list-group-item list-group-item-success 1">Q.코인은 어디에 사용할 수 있나요???</li>
<li class="list-group-item list-group-item-success 2">A.코인은 직거래언더카(개인 직거래 매물 등록) 이용 시 차량이 돋보이게 하는 광고등록을 하실 수도 있고, 룰렛/레이싱 등 언더카가 준비한 다양한 이벤트에 참여하실 수도 있어요.
..</li>

</ul>
</div>
<div class="c1" data-3 id="i"  style="display: none;">
<h2 style="margin-left: 30px;">서비스</h2>
<ul>
<li class="list-group-item list-group-item-success 1">Q.방문예약신청을 했는데 확정은 언제되나요?</li>
<li class="list-group-item list-group-item-success 2">A.방문 예약 신청은 딜러가 해당 내역을 확인 후 확정하게 된답니다. 
딜러가 해당 내역을 확정 혹은 딜러의 사정에 의해 거부할 수 있고, 딜러의 확정 처리가 7일간 지연될 경우 부득이하게 관리자에 의해 신청 내역이 삭제되는 점 양해 부탁드릴게요. </li>
<li class="list-group-item list-group-item-info 1">Q.실차주마크라는 게 뭔가요?</li>
<li class="list-group-item list-group-item-info 2">A.실차주마크란 딜러가 직접 보유하고 있는 차량에게 달아주는 마크로 딜러=차량소유자(실차주)라는 것을 의미해요.
그럼 실차주마크는 뭐가 좋을까요? 딜러가 직접 소유하고 있는 차량이니 허위매물 걱정 끝! 불필요한 수수료 요구 없이 안심하고 거래하실 수 있어요.
차량을 구매하시기 전에 실차주마크를 확인하시고 보다 안심하고 중고차를 거래해보세요. :).</li>
<li class="list-group-item list-group-item-success 1">Q.후기평가는 어떻게 입력하나요?</li>
<li class="list-group-item list-group-item-success 2">A.방문예약, 차량 상담, 팔아줘, 구해줘, 바꿔줘 등 KB차차차의 다양한 서비스를 이용하신 고객님들의 의견을 수렴하고자 만족도 평가 문자를 보내드리고 있어요.
고객님께서 등록해주신 후기는 딜러홈에 노출될 뿐 아니라 고객님의 소중한 의견을 바탕으로 보다 나은 서비스를 제공하기 위함이니 고객님의 소중한 후기를 들려주세요. :).</li>

</ul>
</div>
</body>
</html>