/**
 * 
 */
$(document).ready(function() {
	//파일 업로드시 미리보기
	var menuImg;
	$("#file1").change(function(){
		readURL(this);
	});
	function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            
            reader.onload = function (e) {
                $('.stfRight > img').attr('src', e.target.result);
            }
            reader.readAsDataURL(input.files[0]);
            console.log($('div.stfRight > img'));
        }
    }
	
	//왼쪽화면에서 클릭시 입력창으로 정보 가져오기
	var staff=$('.staff');
	
	staff.click(function() {
		modifyStf(this);
	});
	function modifyStf(infos) {
		var tg=$(infos);
		
		var admin_id=tg.find('> .stfInfo:eq(0)');
		var admin_pass=tg.find('> .stfInfo:eq(1)');
		var admin_regdate=tg.find('> .stfInfo:eq(2)');
		var admin_addr=tg.find('> .stfInfo:eq(3)');
		var admin_num=tg.find('> .stfInfo:eq(4)');
		var admin_profile=tg.find('> .stfInfo:eq(5) > img');
		var admin_name=tg.find('> .stfInfo:eq(6)');
		
		$('#admin_id').val(admin_id.text());
		$('#admin_pass').val(admin_pass.text());
		$('#admin_regdate').val(admin_regdate.text());
		$('#admin_addr').val(admin_addr.text());
		$('#admin_num').val(admin_num.text());
		$('#admin_name').val(admin_name.text());
		$('#stfImg > .stfRight').empty();
		$('#stfImg > .stfRight').append('<img src="' +admin_profile.attr('src') + '"/>');
	}
	
	$("#update").click(function() {
		var updated = confirm("수정하시겠습니까?");
		if(updated==true) {
			var formData = new FormData();
			formData.set("admin_id",$("#admin_id").val());
			formData.set("admin_pass",$("#admin_pass").val());
			formData.set("admin_regdate",$('#admin_regdate').val());
			formData.set("admin_addr",$("#admin_addr").val());
			formData.set("admin_num",$("#admin_num").val());
			formData.set("admin_name",$('#admin_name').val());
			formData.set("admin_profile",$("#file1")[0].files[0]);
			
			$.ajax({
				type:"post",
				url:"/jsp_project/mg/staff/staffUpdate.do",
				data:formData,
				enctype:"multipart/form-data",
				processData:false,
				contentType:false,
				dataType:'text',
				success:function(data) {
					location.href="/jsp_project/mg/staff/staffForm.do";
				}
			});
		}
	});
	
	$('#insert').click(function() {
		var inserted=confirm("등록하시겠습니까?");
		
		if(inserted==true) {
			var formData = new FormData();
			formData.set("admin_id",$("#admin_id").val());
			formData.set("admin_pass",$("#admin_pass").val());
			formData.set("admin_regdate",$('#admin_regdate').val());
			formData.set("admin_addr",$("#admin_addr").val());
			formData.set("admin_num",$("#admin_num").val());
			formData.set("admin_name",$('#admin_name').val());
			formData.set("admin_profile",$("#file1")[0].files[0]);
			
			$.ajax({
				type:"post",
				url:"/jsp_project/mg/staff/staffInsert.do",
				data:formData,
				enctype:"multipart/form-data",
				processData:false,
				contentType:false,
				dataType:'text',
				success:function(data) {
					location.href="/jsp_project/mg/staff/staffForm.do"
				}
			});
		}
	});
	$('#delete').click(function() {
		var deleted=confirm("정말 삭제하시겠습니까?");
		
		if(deleted==true) {
			var query= {
					admin_id:$('#admin_id').val()
			}
			$.ajax({
				type:"post",
				url:"/jsp_project/mg/staff/staffDelete.do",
				data:query,
				success:function(data) {
					location.href="/jsp_project/mg/staff/staffForm.do"
				}
			});
		}
	});
	$('#cancel').click(function() {
		var canceled=confirm("취소하시겠습니까?");
		if(canceled==true) {
			$('#admin_id').val("");
			$('#admin_pass').val("");
			$('#admin_regdate').val("");
			$('#admin_addr').val("");
			$('#admin_num').val("");
			$('#admin_name').val("");
			$('#stfImg > .stfRight').empty();
		}
	});
	
	
	
});