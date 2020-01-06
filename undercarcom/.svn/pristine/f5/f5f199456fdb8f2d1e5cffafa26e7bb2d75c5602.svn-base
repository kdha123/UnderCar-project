<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보보기</title>
<script type="text/javascript">
	$(function() {

		var grade = ${dto.grade};
		if (grade == 1) {
			$("#bmember").hide();
		} else {
			$("#bmember").show();
		}
		
		$("#deleteBtn").click(function(){
			$("#deleteModal").modal();
		});

		//ajax 처리
		$("#modal_pw").on({"keyup":function(){
			var pw = $("#modal_pw").val().trim();
// 			alert(pw);
			$("#modal_pw").val(pw);
			var id = "${dto.id}";
			if(pw.length == 0){
				$("#pw_Check").html("비밀번호를 입력하세요.");
			}else if(pw.length < 4 || pw.length > 20){
			
				$("#pw_Check").html("비밀번호는 4자이상 20자 이내로 작성해주세요.");
			}else{
				$("#pw_Check").load("/ajax/pwCheck.do?pw="+pw+"&id="+id);
			}}
		});

		$("#modal_delete_form").on("submit", function(){
			if($("#pw_Check").text().indexOf("일치하는")<= -1){
				alert("비밀번호가 틀렸습니다. 다시 입력해주세요.");
				$("#modal_pw").focus();
				return false;
			}else{
				alert("회원탈퇴가 되었습니다.")
			}
		});
		
		$("#pwBtn").click(function(){
			var ids = "${dto.id}";
// 			alert(ids);
			location = "pwUpdateForm.do?id="+ids;
			return false;
		});
	});
</script>
</head>
<body>
	<div class="container">
		<h2>내 정보보기</h2>
		<table class="table">
			<tr>
				<th>아이디</th>
				<td>${dto.id}</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${dto.name}</td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td>${dto.birth}</td>
			</tr>
			<tr>
				<th>성별</th>
				<td>${dto.gender}</td>
			</tr>
			<tr>
				<th>연락처</th>
				<td>${dto.tel}</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>${dto.email}</td>
			</tr>
			<tr>
				<th>등급명</th>
				<td>${login.gradeName}</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><button id="pwBtn">비밀번호 변경</button></td>
			</tr>
			<tbody id="bmember">
				<tr>
					<th>사업자번호</th>
					<td>${dto.bno}</td>
				</tr>
				<tr>
					<th>회사주소</th>
					<td>${dto.baddr}</td>
				</tr>
				<tr>
					<th>회사명</th>
					<td>${dto.bname}</td>
				</tr>
				<tr>
					<th>회사번호</th>
					<td>${dto.btel}</td>
				</tr>
				<tr>
					<th>소개글</th>
					<td>${dto.content}</td>
				</tr>
			</tbody>
			<tr>
				<td colspan="2">
				<a href="updateForm.do?grade=${dto.grade }"><button class="btn btn-default">수정</button></a>
				<button id="deleteBtn" class="btn btn-default">회원탈퇴</button>
					<button type="button" onclick="history.back();" class="btn btn-default">이전화면으로</button></td>
			</tr>
		</table>
	</div>

  <!-- 멤버 삭제를 위한 Modal -->
  <div class="modal fade" id="deleteModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
          <form role="form" method="post" id="modal_delete_form" action="delete.do">
        <div class="modal-header" style="padding:35px 50px;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4><span class="glyphicon glyphicon-remove"></span> 회원 탈퇴</h4>
        </div>
        <div class="modal-body" style="padding:40px 50px;">
	        <div class="alert alert-warning">
			  <strong>주의</strong> 정말로 회원탈퇴를 하시겠습니까?
			</div>
            <div class="form-group">
            <label for="modal_content">
             <span class="glyphicon glyphicon-pencil"></span>
             	회원탈퇴를 위해 비밀번호를 입력해주세요.
            </label>
              <input class="form-control" id="modal_pw" name="pw" type="password">
            <input type="hidden" name="id" value="${dto.id}">
              <div id="pw_Check">입력하세요.</div>
            </div>
		</div>
        <div class="modal-footer" style="padding:40px 50px;">
            <div class="btn-group">
             <button type="submit" class="btn btn-primary">삭제</button>
          	 <button type="button" class="btn btn-warning" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> 취소</button>
			</div> 
        </div>
      
          </form>
    </div>
  </div> 
</div>
</body>
</html>