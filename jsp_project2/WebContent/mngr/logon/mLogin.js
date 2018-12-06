/**
 * 관리자 로그인 화면
 */
$(document).ready(function() {
	$("#login").click(function() {
		var query = {
				id:$("#id").val(),
				passwd:$("#passwd").val()
		};
		
		$.ajax({
			type:"post",
			url:"/jsp_project/mg/managerLoginPro.do",
			data:query,
			success:function(data) {
				location.href="/jsp_project/mg/managerMain.do";
			}
		});
	});
	
	$("#logout").click(function() {
		$.ajax({
			type:"post",
			url:"/jsp_project/mg/managerLogout.do",
			success:function(data) {
				location.href="/jsp_project/mg/managerMain.do";
			}
		});
	});
});