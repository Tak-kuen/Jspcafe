<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="/jsp_project/js/jquery-3.3.1.min.js"></script>
<script src="/jsp_project/js/staffForm.js"></script>
<link rel="stylesheet" href="/jsp_project/css/staffForm.css"
	type="text/css" />
<div id="stfList">
<h2>직원관리</h2>
	<c:forEach var="staff" items="${stafflists}">
		<c:if test="${staff.admin_class == 2}">
			<div class="staff">
				<div class="stfInfo stfHidden">${staff.admin_id}</div>
				<div class="stfInfo stfHidden">${staff.admin_pass}</div>
				<div class="stfInfo stfHidden">${staff.admin_regdate}</div>
				<div class="stfInfo stfHidden">${staff.admin_addr}</div>
				<div class="stfInfo stfHidden">${staff.admin_num}</div>
				<div class="stfInfo">
					<img src="/jsp_project/images${staff.admin_profile}" />
				</div>
				<div class="stfInfo">${staff.admin_name}</div>
				<br />
			</div>
		</c:if>
	</c:forEach>
</div>
<div id="stfEdit">
	<form id="stfForm1" method="post" enctype="multipart/form-data">
		<div id="stfInfo">
			<div id="stfId">
				<span class="stfLeft">아이디&nbsp;&nbsp;&nbsp;</span> <input type="text" id="admin_id"
					name="admin_id" maxlength="15" size="10" value="" /> <span
					class="stfRight"></span>
			</div>
			<div id="stfPass">
				<span class="stfLeft">비밀번호</span> <input type="text" id="admin_pass"
					name="admin_pass" maxlength="10" size="10" value="" /> <span
					class="stfRight"></span>
			</div>
			<div id="stfAddr">
				<span class="stfLeft">주소&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> <input type="text" id="admin_addr"
					name="admin_addr" maxlength="10" size="10" /> <span
					class="stfRight"></span>
			</div>
			<div id="stfNum">
				<span class="stfLeft">전화번호</span> <input type="text" id="admin_num"
					name="admin_num" maxlength="10" size="10" /> <span
					class="stfRight"></span>
			</div>
			<div id="stfName">
				<span class="stfLeft">이름&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> <input type="text" id="admin_name"
					name="admin_name" maxlength="10" size="10" /> <span
					class="stfRight"></span>
			</div>
			<div id="stfRegDate">
				<span class="stfLeft">등록일&nbsp;&nbsp;&nbsp;</span> <input type="text"
					id="admin_regdate" name="admin_regdate" maxlength="21" size="17" />
				<span class="stfRight"></span>
			</div>

			<div id="stfImg">
				<span class="stfLeft">이미지</span>
				<div class="stfRight"></div>
			</div>
		</div>

		<div id="form">
			<div class="imgUpdate">
				<input type="file" id="file1" name="file1">
				<input type="submit" id="insert" value="등록" />
				<input type="submit" id="update" value="수정" />
				<input type="submit" id="delete" value="삭제" />
				<button id="cancel">취소</button>
			</div>
		</div>
	</form>

</div>