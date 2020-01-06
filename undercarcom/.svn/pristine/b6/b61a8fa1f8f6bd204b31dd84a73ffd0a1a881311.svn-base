<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>faq 리스트</title>
<style type="text/css">
.dataRow:hover{
background: #eee;
cursor: pointer;
}
</style>
</head> 
<body>
<div class="container">
 <h1>faq 리스트</h1>
 
 <table class ="table">
 <tr>
 <td>글번호</td>
 <td>제목</td>
 
 </tr>
 <c:forEach items="${list }" var="dto">
 <tr class="dataRow">
 <td class="no">${dto.no}</td>
 <td>
       ${(dto.levNo > 0)? "":"" }
	<c:forEach begin="1" end="${dto.levNo * 5 }">&nbsp;</c:forEach>
<i class="material-icons">${(dto.levNo > 0)?"&#xe5da;":"" }</i>
${dto.title }</td>
 </tr>
 
 </c:forEach>
 
 <tr>
 <td colspan="2">
 <a href="writeForm.do"><button>질문하기</button> </a>
 </td>
 </tr>
 </table>


</div>

</body>
</html>