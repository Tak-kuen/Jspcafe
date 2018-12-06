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
직원관리
		<c:forEach var="staff" items="${stafflists}">
		<c:if test="${staff.admin_class == 2}">
		<div id="stafflist">
			<div class="staff">${staff.admin_id}</div>
			<div class="staff">${staff.admin_pass}</div>
			<div class="staff">${staff.admin_addr}</div>
			<div class="staff">${staff.admin_num}</div>
			<div class="staff">${staff.admin_profile}</div>
			<div class="staff">${staff.admin_regdate}</div><br/>
		</div>
		</c:if>
		</c:forEach>
</body>
</html>