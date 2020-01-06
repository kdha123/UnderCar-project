<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서버오류</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
#logoDiv{
font-size:50px;
padding:  50px;
text-align: center;
background: black;
color: red;
}
</style>

</head>
<body>
<div class="container">

<h2>서버오류</h2>
    <div class="panel panel-danger">
      <div class="panel-heading"><%=exception.getMessage() %></div>
      <div class="panel-body">
      <div id ="logoDiv"><span class="glyphicon glyphicon-remove"></span></div>
      <div>
         요청하신 페이지를 처리하는중 서버에 오류가 발생되었습니다.<br>
      다시 한번 시도해주세요<br/>
      지속적으로 되면 연락주세요
      </div>
    <div align="center" class="panel-footer">
      <a href="/main.do"><button>메인페이지</button></a>
      <a href="javascript:history.back()"><button>전페이지</button></a>
    </div>
      </div>
      
    </div>

</div>
</body>
</html>