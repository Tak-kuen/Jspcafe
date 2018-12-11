<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="../css/userMain.css" type="text/css" />
<script src="/jsp_project/js/jquery-3.3.1.min.js"></script>
<script src="/jsp_project/js/userMain.js"></script>
<c:if test="${not empty sessionScope.num }">
	<div id=information>
		<div>
			<span class="info_name">${customer.cus_name}</span> <span>님!!</span><br />
			<span>적립금</span> <span class="info_mile">${customer.cus_mile}</span>
			<span>원</span><br /> <span>보유 중 입니다.</span><br />
		</div>
		<div id="infobutton">
			<button id="info_button">주문내역 보기</button>
		</div>
	</div>
</c:if>