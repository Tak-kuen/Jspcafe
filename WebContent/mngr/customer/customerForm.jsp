<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="/jsp_project/js/jquery-3.3.1.min.js"></script>
<script src="/jsp_project/js/customerForm.js"></script>
<link rel="stylesheet" href="/jsp_project/css/customerForm.css"
	type="text/css" />

<div id="cusList">
<h2>고객관리</h2>
	<div id="customTable">
	<div id="column">
		<div class="colInfo">전화번호</div>
		<div class="colInfo">성명</div>
		<div class="colInfo">적립금</div>
	</div>
	<c:forEach var="customer" items="${customlists}">
		<div class="customer">
			<div class="cusInfo">${customer.cus_num}</div>
			<div class="cusInfo">${customer.cus_name}</div>
			<div class="cusInfo">${customer.cus_mile}</div>
		</div>
	</c:forEach>
	</div>
</div>

<div id="cusEdit">
	<form id="cusForm1" method="post" enctype="multipart/form-data">
		<div id="cusInfo">
			
			<div id="cusNum">
				<span class="cusLeft">전화번호</span>
				<input type="text" id="cus_num" name="cus_num" maxlength="15" size="15" />
				<span class="cusRight"></span>
			</div>
			<div id="cusName">
				<span class="cusLeft">이름&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> 
				<input type="text" id="cus_name" name="cus_name" maxlength="5" size="5" />
				<span class="cusRight"></span>
			</div>
			<div id="cusMile">
				<span class="cusLeft">적립금&nbsp;&nbsp;&nbsp;</span>
				<input type="text" id="cus_mile" name="cus_mile" maxlength="5" size="5" />
				<span class="cusRight"></span>
			</div>
			<div id="cusRegDate">
			</div>
		</div>
		<div id="cusBtn">
			<input type="submit" id="insert" value="등록" />
			<input type="submit" id="update" value="수정" />
			<input type="submit" id="delete" value="삭제" />
			<button id="cancel">취소</button>
		</div>
	</form>
</div>