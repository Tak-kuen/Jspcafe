<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="/jsp_project/js/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="/jsp_project/css/managerMain.css"
	type="text/css" />
<script src="/jsp_project/mngr/managerMain.js"></script>
<title>managerMain.jsp</title>
</head>
<body>
	<c:if test="${empty sessionScope.id }">
		<div id="mList"></div>
		<div id="mList"></div>
		<div id="mMain"></div>
	</c:if>
	<c:if test="${not empty sessionScope.id }">
		<div id="mMain">
			<div id="calc">
				<div id="orderctgr">
					<div class="category">
						<ul>
							<li><span id="coffee" class="menuLink" >Coffee</span></li>
							<li><span id="ade" class="menuLink">Ade</span></li>
							<li><span id="ice" class="menuLink">Icecream</span></li>
						</ul>
					</div>
				</div>
				<div id="orderlist" class="box">
					<c:forEach var="menu" items="${sessionScope.menus}">
						<c:if test="${menu.menu_ctgr == 1}">
							<div class="coffee">
								<div class="items">
									<img src="/jsp_project/images${menu.menu_image}" />
								</div>
								<div class="items">${menu.menu_name}</div>
								<div class="items">${menu.menu_price}</div>
							</div>
						</c:if>
						<c:if test="${menu.menu_ctgr == 2}">
							<div class="ade">
								<div class="items">
									<img src="/jsp_project/images${menu.menu_image}" />
								</div>
								<div class="items">${menu.menu_name}</div>
								<div class="items">${menu.menu_price}</div>
							</div>
						</c:if>
						<c:if test="${menu.menu_ctgr == 3}">
							<div class="ice">
								<div class="items">
									<img src="/jsp_project/images${menu.menu_image}" />
								</div>
								<div class="items">${menu.menu_name}</div>
								<div class="items">${menu.menu_price}</div>
							</div>
						</c:if>
					</c:forEach>
				</div>
				<div id="paymentlist" class="box">
					<button id="orderReset">주문취소</button>
					<div class="paylists"></div>
					<div class="userMile">
						전화번호<input type="text" id="userName" size="15">
						<button id="mileselect">조회</button><br/>
						적립금<span id="mileageMoney"></span>
					</div>
					<div class="payresult">
						<div id="payMoney">
						결제금액<br/>
						</div>
						
						<button id="payBtn">결제하기</button>
					</div>
						
				</div>
			</div>
		</div>
	</c:if>
</body>
</html>