<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>존재하지 않는URL</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>
<div id="a"  class="container">

<h2 align="center">페이지를 확인할수 없습니다...</h2>
    <div align="center">
    <div style="width: 60%" class="panel panel-danger">
      <div  class="panel-heading"><strong>Please check again!</strong>
The requested URL cannot be found.
Please check the address (URL) again.</div>
      <div class="panel-body">
      <div id ="logoDiv">
      <img alt="에러 화면입니다." src="/image/04.png">
      </div>
    <div align="center" class="panel-footer">
      <a href="/main.do"><button>메인페이지</button></a>
      <a href="javascript:history.back()"><button>전페이지</button></a>
    </div>
      </div>
      
    </div>
  </div>
</div>
</body>
</html>