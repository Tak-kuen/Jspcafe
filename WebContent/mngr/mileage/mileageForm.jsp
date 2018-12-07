<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<!-- <link rel="stylesheet" href="/jsp_project/css/mLoginForm.css" type="text/css" /> -->
<script src="/jsp_project/js/jquery-3.3.1.min.js"></script>
<meta charset="UTF-8">
</head>
<body> 
	<h3>마일리지 관리</h3>
	<div id="mileagemanagement">
	<form class="form" action="/jsp_project/mg/mile/mileMain.do" method ="post">
		<div id="mileageset">적립금 설정: <input name="set" id="set" type="text" maxlength="10">
		 원 이상 구매 시 <input name="set2" id="set2" type="text" maxlength="10"> % 적립
		 <input type="submit" id="setbutton" value="적용">
		</div>
		</form>
		<form class="form" action="/jsp_project/mg/mile/mileMain.do" method ="post">
		<div id="uselimit">사용 제한: <input name="set3" id="limit" type="text" maxlength="10">
		 원 이상 보유 시 <input name="set4" id="limit2" type="text" maxlength="10"> 원 단위로 사용 가능
		 <input type="submit" id="limitbutton" value="적용">
		</div>
		</form>
	</div>
	<script>
$(document).ready(function() {
   //버튼눌렀을때 세션에 저장시키기
   
   
   //세션에 저장됐는지 확인
      $('#mile').text('${sessionScope.mileage}');
	   $("#mile2").text('${sessionScope.mileage2}');
	      $('#mile3').text('${sessionScope.mileage3}');
		   $("#mile4").text('${sessionScope.mileage4}');
});
</script>
<div id="mile">${mileage}</div><div id="mile2">${mileage2}</div><br/>
<div id="mile3">${mileage3}</div><div id="mile4">${mileage4}</div>
</body>
</html>