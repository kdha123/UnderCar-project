<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
<script type="text/javascript">

$(function(){
	
//ajax 처리
	$("#update_pw").on({"keyup":function(){
		var pw = $("#update_pw").val().trim();
//		alert(pw);
		$("#update_pw").val(pw);
		var id = "${param.id}";
		if(pw.length == 0){
			$("#pwCheck").html("비밀번호를 입력하세요.");
		}else if(pw.length < 4 || pw.length > 20){
		
			$("#pwCheck").html("비밀번호는 4자이상 20자 이내로 작성해주세요.");
		}else{
			$("#pwCheck").load("/ajax/pwCheck.do?pw="+pw+"&id="+id);
		}}
	});
	
	$("#pwUpdate").on("submit", function(){
// 		alert($("#pwCheck").text());
		var check = $("#pwCheck").text();
		if(check.indexOf("일치하는") <= -1){
			alert("비밀번호가 틀렸습니다. 다시 입력해주세요.");
			$("#update_pw").focus();
			return false;
		}else{
			alert("비밀번호가 변경됩니다.");
		}
	});
});
</script>
</head>
<body>
	<div class="container">

		<div class="header" style="padding: 35px 50px;">
			<h4>
				<span class="glyphicon glyphicon-pencil"></span> 비밀번호 변경
			</h4>
		</div>
		<div class="body" style="padding: 40px 50px;">
			<form method="post" id="pwUpdate" action="pwUpdate.do">
				<div class="form-group">
					<span class="glyphicon glyphicon-pencil"></span> 현재 비밀번호 <input
						class="form-control" id="update_pw" name="pw" required="required" type="password">
					<div id="pwCheck">입력하세요.
					</div>
				</div>
				<div class="form-group">
					<span class="glyphicon glyphicon-pencil"></span> 변경할 비밀번호 <input
						class="form-control" id="pwd" name="pwd" required="required" type="password"
						pattern="^.{4,20}$" title="4-20자 이내의 비밀번호 입력">
				</div>
				<div class="btn-group right">
					<button type="submit" class="btn btn-primary">변경</button>
					<button type="button" class="btn btn-primary" onclick="history.back()">취소</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>