/**
 * 
 */
$(document).ready(function() {
	var customer = $('.customer');

	customer.click(function() {
		var tg = $(this);

		var cus_num = tg.find('> .cusInfo:eq(0)');
		var cus_name = tg.find('> .cusInfo:eq(1)');
		var cus_mile = tg.find('> .cusInfo:eq(2)');
		var cus_regdate = tg.find('> .cusInfo:eq(3)');
		
		$('#cus_num').val(cus_num.text());
		$('#cus_name').val(cus_name.text());
		$('#cus_mile').val(cus_mile.text());
		$('#cus_regdate').val(cus_regdate.text());
	});

	function modifyCus(infos) {
		
	}

	$('#update').click(function() {
		var updated = confirm("수정하시겠습니까?");
		if (updated == true) {
			var query = {
				cus_num : $('#cus_num').val(),
				cus_name : $('#cus_name').val(),
				cus_mile : $('#cus_mile').val(),
				cus_regdate : $('#cus_regdate').val()
			};

			$.ajax({
				type : "post",
				url : "/jsp_project/mg/customer/customerUpdate.do",
				data : query,
				success : function(data) {
					location.href = "/jsp_project/mg/customer/customerForm.do"
				}
			});// ajax
		}// if
	});// update버튼

	$('#insert').click(function() {
		var inserted = confirm("수정하시겠습니까?");
		if (inserted == true) {
			var query = {
				cus_num : $('#cus_num').val(),
				cus_name : $('#cus_name').val(),
				cus_mile : $('#cus_mile').val(),
				cus_regdate : $('#cus_regdate').val()
			};

			$.ajax({
				type : "post",
				url : "/jsp_project/mg/customer/customerInsert.do",
				data : query,
				success : function(data) {
					location.href = "/jsp_project/mg/customer/customerForm.do"
				}
			});// ajax
		}// if
	});// insert버튼
	$('#delete').click(function() {
		var deleted = confirm("정말 삭제하시겠습니까?");

		if (deleted == true) {
			var query = {
				cus_num : $('#cus_num').val()
			}
			$.ajax({
				type : "post",
				url : "/jsp_project/mg/customer/customerDelete.do",
				data : query,
				success : function(data) {
					location.href = "/jsp_project/mg/customer/customerForm.do"
				}
			});// ajax
		}// if
	});// delete버튼

	$('#cancel').click(function() {
		var canceled = confirm('취소하시겠습니까?');
	});
});