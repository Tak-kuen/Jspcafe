/**
 * 유저 로그인 화면
 */
$(document).ready(function() {
	$("#login").click(function() {
		var query = {
				name:$("#name").val(),
				num:$("#num").val()
		};
		
		$.ajax({
			type:"post",
			url:"/jsp_project/us/userLoginPro.do",
			data:query,
			success:function(data) {
				location.href="/jsp_project/us/userMain.do";
			}
		});
	});
	
	$("#logout").click(function() {
		$.ajax({
			type:"post",
			url:"/jsp_project/us/userLogout.do",
			success:function(data) {
				location.href="/jsp_project/us/userMain.do";
			}
		});
	});
});