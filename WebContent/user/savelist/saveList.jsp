<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="../css/saveList.css" type="text/css" />
<script src="/jsp_project/js/jquery-3.3.1.min.js"></script>
<script>
$(document).ready(function() {
	$("#mainview").click(function() {
		location.href="/jsp_project/us/userMain.do";
	});
	var count=1;
	for(var i=0; i<$('.orders').length; i++) {
		var a=$('.orders').eq(i);
		a.find('> .lists:eq(0)').html(count++);
	}
});
</script>
<div id="saveTitle">
주문내역<button id="mainview">메인 화면</button>
</div>
<div id="saveList">
<c:if test="${not empty orderlists }">
	<c:forEach var="order" items="${sessionScope.orderlists }">
		<div class="orders">
			<div class="lists"></div>
			<div class="lists">${order.order_money}</div>
			<div class="lists">${order.order_date}</div>
		</div>
	</c:forEach>
</c:if>
</div>

