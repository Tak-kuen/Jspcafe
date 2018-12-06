<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="/jsp_project/js/jquery-3.3.1.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
고객관리
		<c:forEach var="customer" items="${customlists}">
		<div id="customerlist">
			<div class="customer">${customer.cus_num}</div>
			<div class="customer">${customer.cus_name}</div>
			<div class="customer">${customer.cus_mile}</div>
			<div class="customer">${customer.cus_regdate}</div>
		</div>
		</c:forEach>
</body>
</html>