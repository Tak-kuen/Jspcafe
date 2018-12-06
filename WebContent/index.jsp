<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<head>
<script src="/jsp_project/js/jquery-3.3.1.min.js"></script>
<script src="/jsp_project/js/index.js"></script>
<link rel="stylesheet" href="/jsp_project/css/index.css" type="text/css" />
<meta charset="UTF-8">
<title>Jsp Project</title>
</head>
<body>
<div id="header">
	<h1 id="title">CAFE</h1>
	<div id="logo" class="box">
		<!-- <img class="noborder" id="logo" src="/jsp_project/images/test.png"/> -->
	</div>
</div>
<div id="nav">
	<c:if test="${not empty sessionScope.id}">
		<c:if test="${sessionScope.type==0 }">
		<c:if test="${sessionScope.check ==2 }">
			
			<ul id="menusection">
				<dl><button id="menu">메뉴<br>관리</button>
				<dl><button id="mileage">적립금<br>관리</button>
				<dl><button id="customer">고객<br>관리</button>
				<dl><button id="admin">직원<br>관리</button>
				<dl><button id="sales">매출<br>관리</button>
				<dl><button id="main">메인<br>메뉴</button>
			</ul>
			
		</c:if>
		<c:if test="${sessionScope.check ==1 }">
			<ul id="menusection">
				<dl><button id="customer">고객<br>관리</button>
				<dl><button id="main">메인<br>메뉴</button>
			</ul>
		</c:if>
		</c:if>
	</c:if>
</div>
<div id="auth" class="box">
	<c:if test="${type == 0}">
		<jsp:include page="mngr/logon/mLoginForm.jsp" />
	</c:if>
	<c:if test="${type == 1 }">
		<jsp:include page="user/logon/uLoginForm.jsp"/>
	</c:if>
</div>
<div id="content" class="box2">
	<jsp:include page="${cont}"/>
</div>

</body>
</html>