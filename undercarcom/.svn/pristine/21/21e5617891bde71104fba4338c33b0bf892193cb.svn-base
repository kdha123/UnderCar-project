<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정</title>
<script type="text/javascript">
	$(function() {

		var grade = ${param.grade}
		;
		if (grade == 1) {
			$("#bmember").hide();
		} else {
			$("#bmember").show();
		}
	});
</script>
</head>
<body>
	<h1>회원정보수정</h1>
	<form action="update.do" method="post">
	<input type="hidden" value="${dto.pw }" name="pw">
		<div class="form-group">
			<label for="id">아이디(수정불가)</label> <input type="text"
				class="form-control" id="id" name="id" value="${dto.id }"
				readonly="readonly">
		</div>
		
		<div class="form-group">
			<label for="name">이름(수정불가)</label> <input type="text"
				class="form-control" id="name" name="name" value="${dto.name }"
				readonly="readonly">
		</div>
		<div class="form-group">
			<label for="birth">생년월일(수정불가)</label> <input type="text"
				class="form-control" id="birth" name="birth" value="${dto.birth }"
				readonly="readonly">
		</div>
		<div class="form-group">
			<label for="gender">성별(수정불가)</label> <input type="text"
				class="form-control" id="gender" name="gender" value="${dto.gender }"
				readonly="readonly">
		</div>
		<div class="form-group">
			<label for="tel">전화번호</label> <input type="text"
				class="form-control" id="tel" name="tel" value="${dto.tel }" pattern="^\d{2,3}-\d{3,4}-\d{4}$" title="(2,3자리)-(3,4)자리-(4)자리 로  입력해주세요." required="required">
		</div>

	    <div class="form-group">
<!-- maxlength : 최대 입력 글자 수, title : 말풍선메시지 or 오류메시지에서 출력 -->
<!-- type = "email"로 작성하면 이메일 형식에 맞는지도 검사한다. 단, 오류 시 title이 적용 안 됨 -->
      <label for="email">Email : </label>
      <input type="email" class="form-control" id="email" value="${dto.email }" name="email"
     		 maxlength="50" required="required" pattern="^[a-bA-Z][_0-9a-zA-Z-]{3,19}+@[0-9a-zA-Z-]+\\.[0-9a-zA-Z-]*$" title="이메일 형식에 맞게 입력해주세요."
     		 /><br/>
     		 이메일 형식 - 예) kkkk@naver.com, kkkk@webjjagng.co.kr
    </div>
    <div class="form-group" id="bmember">
    	<div>
	    <label for="bno">사업자번호: </label><br/>
     	 <input type="text" class="form-control" id="bno" value="${dto.bno }" name="bno"
      maxlength="20"  title="-을 빼고 입력해주세요."/>
    	</div>
    	<div>
	    <label for="baddr">회사주소: </label><br/>
     	 <input type="text" class="form-control" id="baddr" value="${dto.baddr }" name="baddr"
      maxlength="20"  title="주소를 입력해주세요."/>
    	</div>
    	<div>
	    <label for="bname">회사명: </label><br/>
     	 <input type="text" class="form-control" id="bname" value="${dto.bname }" name="bname"
      maxlength="20"  title="회사명을 입력해주세요"/>
    	</div>
    	<div>
	    <label for="btel">회사번호: </label><br/>
     	 <input type="text" class="form-control" id="btel" value="${dto.btel }" name="btel"
      maxlength="20"  title="-을 빼고 입력해주세요."/>
    	</div>
    	<div>
	    <label for="content">소개글: </label><br/>
     	 <textarea class="form-control" id="content" name="content" rows="5" cols="50"  title="소개글을 입력해주세요.">${dto.content }</textarea>
    	</div>
    </div>
		<button>수정</button>
		<button type="reset">다시입력</button>
		<button onclick="history.back()">취소</button>
	</form>
</body>
</html>