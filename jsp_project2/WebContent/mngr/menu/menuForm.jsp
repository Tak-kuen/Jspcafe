<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/jsp_project/css/menuForm.css" type="text/css" />
<script src="/jsp_project/js/jquery-form.min.js"></script>
<div class="category">
	<ul>
		<li><span id="coffee" class="menuLink">Coffee</span></li>
		<li><span id="ade" class="menuLink" >Ade</span></li>
		<li><span id="ice" class="menuLink" >Icecream</span></li>
	</ul>
</div>
<div id="menuList">
	<c:forEach var="menu" items="${sessionScope.menus}">
		<c:if test="${menu.menu_ctgr == 1}">
		<div class="coffee">
			<div class="items"><img src="/jsp_project/images${menu.menu_image}"/></div>
			<div class="items">${menu.menu_name}</div>
			<div class="items">${menu.menu_price}</div>
		</div>
		</c:if>
		<c:if test="${menu.menu_ctgr == 2}">
		<div class="ade">
			<div class="items"><img src="/jsp_project/images${menu.menu_image}"/></div>
			<div class="items">${menu.menu_name}</div>
			<div class="items">${menu.menu_price}</div>
		</div>
		</c:if>
		<c:if test="${menu.menu_ctgr == 3}">
		<div class="ice">
			<div class="items"><img src="/jsp_project/images${menu.menu_image}"/></div>
			<div class="items">${menu.menu_name}</div>
			<div class="items">${menu.menu_price}</div>
		</div>
		</c:if>
	</c:forEach>	
</div>
<div id="menuUpdate">
	<form id="upForm1" action="/jsp_project/mg/cafe/imageUpload.do" method="post"
			enctype="multipart/form-data">
	<div id="menuEdit">
		<div id="menuName">
			<span class="menuLeft">메뉴명</span>
			<input type="text" id="nameText" name="nameText" maxlength="15" size="10" value=""/>
			<span  class="menuRight"></span>
		</div>
		<div id="menuPrice">
			<span class="menuLeft">가격</span>
			<input type="text" id="priceText" name="priceText" maxlength="10" size="10" value=""/>
			<span class="menuRight"></span>
		</div>
		<div id="menuImage">
			<span class="menuLeft">이미지</span><div class="menuRight"></div>
		</div>
	</div>
	
	
	<div id="form">
		<div class="imgUpdate">
			<input type="file" id="file1" name="file1">
			<button id="insert">등록</button>
			<input type="submit" id="upPro1" value="수정"/>
			<button id="cancel">취소</button>
		</div>
	</div>
	</form>
	<div id="upResult2"></div>
</div>
<script src="/jsp_project/js/menuForm.js"></script>