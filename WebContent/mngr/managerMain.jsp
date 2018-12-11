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
							<li><span id="coffee" class="menuLink">Coffee</span></li>
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
					<div class="paylists">
						<c:if test="${not empty sessionScope.listHtml}">
						${ listHtml}
						</c:if>
					</div>
					<div id="member">
						결제금액 <input id="paytext" readonly="readonly" disabled="disabled" value="${sum}">
						<div class="memberLogin" id="memp1" style="display: block">
							<label>전화번호</label> <input type="text" id="m-phone">
						</div>
						<div class="memberLogin" id="memp2" style="display: none">
							<label>고객 명</label><input id="name" value="" type="text" readonly="readonly" disabled="disabled">
							<div id="memeber-name"></div>
							<label>잔여 포인트</label><input id="currentpoint" type="text" readonly="readonly" disabled="disabled"><br>
							<label>사용할 포인트</label><input id="usepoint" type="text" value="">
							<button id="apply">적용</button>
						</div>
					</div>
					<div id="m-gruop1" class="member-group" style="display: block">
						<button class="btn-mem" id="query">조회</button>
					</div>
					<div id="m-gruop2" class="member-group" style="display: none">
						<button class="btn-mem" id="back">뒤로가기</button>
					</div>
					<div id="m-group2" class="member-group" >
						<button class="btn-mem" id="pay">결제하기</button>
					</div>
				</div>
			<%--<div id="paymentlist" class="box">
					<button id="orderReset">주문취소</button>
					<div class="paylists">
					<c:if test="${not empty sessionScope.listHtml}">
					${ listHtml}
					</c:if>
					</div>
					<div class="userMile">
						전화번호<c:if test="${not empty sessionScope.cus_num}">
						<input type="text" id="numFormile" size="15" value="${sessionScope.cus_num}">
						</c:if>
						<c:if test="${empty sessionScope.cus_num }">
						<input type="text" id="numFormile" size="15">
						</c:if>
						<button id="mileselect">조회</button><br/>
						적립금<span id="mileageMoney">
						<c:if test="${not empty sessionScope.cus_mile}">${sessionScope.cus_mile}
						</c:if></span>
					</div>
					<div class="payresult">
						<div id="payMoney">
						결제금액<br/>
						</div>
						<button id="payBtn">결제하기</button>
					</div>
				</div> --%>
			</div>
		</div>
	</c:if>
	<script>
	/**
	 * 매니저 메인화면 버튼 핸들링
	 */
	$(document).ready(function() {
		var isMile = true;
		var coffee=$('.coffee');
		var ade=$('.ade');
		var ice=$('.ice');
		var sum=0;
		coffee.click(function() {
			addPayLists(this);
			countLists(this);
		});
		ade.click(function() {
			addPayLists(this);
			countLists(this);
		});
		ice.click(function() {
			addPayLists(this);
			countLists(this);
		});
		$('#orderReset').click(function() {
			$('.paylists').empty();
			$('#paytext').val("");
			sum=0;
		});
		
		function addPayLists(items) {
			var tg=$(items);
			var mCount=1;
			var name=tg.find('> .items:eq(1)');
			var price=tg.find('> .items:eq(2)');
			$('.paylists').append('<div class="name"><div class="order">'+name.text()+
					'</div><div class="order">' +mCount+'</div><div class="order">' +price.text()+'</div></div>');
			$('#paytext').val();
		}
		
		function countLists(items) {
			var tg=$(items);
			var price=tg.find('> .items:eq(2)').html();
			sum = Number(Number(price) + Number(sum));
			console.log(sum);
			console.log(typeof sum);
			$('#paytext').val(sum);
			//var numC=nameC.next().text();
			//console.log(nameC.text());
			//console.log(numC);
		}
		<%--$('#mileselect').click(function() {
			console.log($('.paylists').html());
			var orderlist=$('.paylists').html();
			var query= {
					cus_num:$('#numFormile').val(),
					orderlist:orderlist
			};
			$.ajax({
				type:"post",
				url:"/jsp_project/mg/order/milseSelect.do",
				data:query,
				success:function(data) {
					location.href="/jsp_project/mg/managerMain.do";
				}
			});
		});--%>
		$("#query").click(function(){
		      var hp = $("#m-phone").val();
		         if(hp==""){
		      alert("번호를 입력해주세요");
		      }else{
		         var data2 = JSON.parse('${customlists}');
		         for(var i=0;i<data2.length;i++){
		            if(data2[i].cus_num==$("#m-phone").val()){
		               $("#name").val(data2[i].cus_name);
		               $("#currentpoint").val(data2[i].cus_mile);

		               $("#memp1").css("display","none");
		               $("#memp2").css("display","block");
		               $("#m-gruop1").css("display","none");
		               $("#m-gruop2").css("display","block");
		            }
		         }
		      }
		   });
		 $("#apply").click(function(){
		      var upoint = Number($("#usepoint").val());
		      var cpoint = Number($("#currentpoint").val());
		      console.log(typeof upoint);
		      console.log(cpoint);
		      
		      if(upoint>cpoint){
		         alert("사용할 포인트가 잔여 포인트보다 많습니다");
		         $("#usepoint").val("");
		      }else{
		         //var point = cpoint - upoint;
		         
		         $("#currentpoint").val($("#currentpoint").val()-$("#usepoint").val());
		         var pay = $("#paytext").val();
		         var sum = pay-upoint;
		         $("#paytext").val(sum);
		         console.log($("#usepoint").val());
		         $('#usepoint').val("");
		      }
		   });
		   
		   $("#back").click(function(){
		      $("#m-gruop1").css("display","block");
		      $("#m-gruop2").css("display","none");
		      $("#memp1").css("display","block");
		      $("#memp2").css("display","none");
		      $("#m-phone").val("");
		      $("#currentpoint").val($("#currentpoint").val()+$("#usepoint").val());
		      if(Number($('#paytext').val())<0){
		    	  $('#paytext').val("");
		      };
		   });
		   
		   $('#pay').click(function() {
				console.log(Number($('#paytext').val()));
				var order_money=Number($('#paytext').val());
				var cus_mile =order_money*0.1 + Number($('#currentpoint').val());
				console.log(cus_mile);
				console.log(typeof cus_mile);
				var query={
						order_money:order_money,
						admin_id: '${sessionScope.id}',
						cus_mile: cus_mile,
						cus_num:$('#m-phone').val()
				};
				
			   console.log(query.admin_id);
			   console.log(query.cus_num);
			   console.log(query.cus_mile);
				$.ajax({
					type:"post",
					url:"/jsp_project/mg/order/payPro.do",
					data:query,
					success:function(data) {
						alert("결제가 되었습니다.");
						location.href="/jsp_project/mg/managerMain.do";
					}
			   });
		   });

	});
	</script>
</body>
</html>