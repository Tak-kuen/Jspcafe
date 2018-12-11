<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="org.json.simple.*"%>
<%-- <link rel="stylesheet" href="/jsp_project/css/mLoginForm.css" type="text/css" /> --%>
<script src="/jsp_project/js/jquery-3.3.1.min.js"></script>
<h3>마일리지 관리</h3>
<div id="mileagemanagement">
	<div id="mileageset">
		적립금 설정: <input name="set" id="set" type="text" maxlength="10">
		원 이상 구매 시 <input name="set2" id="set2" type="text" maxlength="10">
		% 적립<br /> 사용 제한: <input name="set3" id="set3" type="text"
			maxlength="10"> 원 이상 보유 시 <input name="set4" id="set4"
			type="text" maxlength="10"> 원 단위로 사용 가능 <input type="button"
			id="setBtn" value="적용">
	</div>
</div>
<div id="mile"></div><div id="mile2"></div><br />
<div id="mile3"></div><div id="mile4"></div>
<script>
	$(document).ready(function() {
		//버튼눌렀을때 세션에 저장시키기
		$('#setBtn').click(function() {
			var query={
					min_amt:$('#set').val(),
					percent:$('#set2').val(),
					uselimit:$('#set3').val(),
					usemeasure:$('#set4').val()
			};
			console.log(query.min_amt);
			console.log(query.percent);
			console.log(query.uselimit);
			console.log(query.usemeasure);
			$.ajax({
				type:"post",
				url:"/jsp_project/mg/mile/milePro.do",
				data:query,
				success: function(data) {
					location.href="/jsp_project/mg/mile/mileMain.do";	
				}
			});
		});

		//세션에 저장됐는지 확인
		$('#mile').text('${sessionScope.mileset.min_amt}');
		$("#mile2").text('${sessionScope.mileset.percent}');
		$('#mile3').text('${sessionScope.mileset.uselimit}');
		$("#mile4").text('${sessionScope.mileset.usemeasure}');
	});
</script>