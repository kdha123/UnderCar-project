<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script type="text/javascript">
var check = "${param.check}";
var fail = "${param.fail}"
if(check==2){
	alert("회원님의 이메일로 아이디 또는 비밀번호가 발송되었습니다. 이메일을 확인해주세요!");
}
if(fail==1){
	alert("로그인이 실패하였습니다. 다시 시도해주세요!");
}
</script>
</head>
<body>
	<div class="container">

		<!-- header - > h1 : 첫번째 나오는 제목 / 자동줄바꿈 -->
		<h2>로그인</h2>
		<p>${msg }</p>
		<form action="login.do" method="post">
			<div class="form-group" >
				<!-- 아이디 입력 - 4자이상 20자이내, 영묹와 숫자만 가능, 맨앞자리는 영문자 필수입력 -->
				<!-- maxlength : 최대입력 글자수, pattern : 입력글자의 형식,title : 마우스를 올려놨을 때 메세지, 또는 형식에 안맞을 때 경고메세지 -->
				<label for="id">아이디:</label> <input type="text" class="form-control"
					id="id" placeholder="아이디입력" name="id" maxlength="20"
					required="required" pattern="^[A-Za-Z][A-Za-z0-9]{3,19}$"
					title="4-20자 영숫자, 맨앞자는 영문자" />
			</div>
			<div class="form-group">
				<!-- 비밀번호 입력 - 아무문자나 가능, 4자 20자 이내, 입력된 문자가 대체 필수입력 -->
				<label for="pw">비밀번호:</label> <input type="password"
					class="form-control" id="pw" placeholder="비밀번호입력" name="pw"
					maxlength="20" required="required" pattern="^.{4,20}$"
					title="4-20자 이내의 글자입력" />
			</div>
			<button type="submit" class="btn btn-default">로그인</button>
		</form>
		<div style="text-align: right;">
			<a href="select.do"><button class="btn btn-default">회원가입</button></a>
			<a href="findIdForm.do"><button class="btn btn-default">아이디 찾기</button></a>
			<a href="findPwForm.do"><button class="btn btn-default">비밀번호 찾기</button></a>
		</div>
	</div>
</body>
</html>