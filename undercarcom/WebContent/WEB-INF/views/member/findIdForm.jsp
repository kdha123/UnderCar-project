<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
$( function() {
	
	var check = "${param.check}";
	if(check==1){
		alert("존재하지 않는 이메일입니다. 다시 입력해주세요.");
	}
	
});
</script>
</head>
<body>
<h2>아이디 찾기</h2>

<form action="findId.do" method="post" id="" >
<p>회원가입한 이메일을 통해 아이디를 찾을 수 있습니다. 이메일을 입력해주세요.</p>
<!-- 이메일 입력 -->
    <div class="form-group">
<!-- maxlength : 최대 입력 글자 수, title : 말풍선메시지 or 오류메시지에서 출력 -->
<!-- type = "email"로 작성하면 이메일 형식에 맞는지도 검사한다. 단, 오류 시 title이 적용 안 됨 -->
      <label for="email">Email : </label>
      <input type="email" class="form-control" id="email" placeholder="Enter Email" name="email"
     		 maxlength="50" required="required" pattern="^[a-bA-Z][_0-9a-zA-Z-]{3,19}+@[0-9a-zA-Z-]+\\.[0-9a-zA-Z-]*$" 
     		 /><br/>
     		 이메일 형식 - 예) kkkk@naver.com, kkkk@webjjagng.co.kr
    </div>
	
<button type="submit" class="btn btn-default">아이디 찾기</button>

</form>
</body>
</html>