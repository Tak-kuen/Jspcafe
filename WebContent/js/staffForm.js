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
		
		console.log(admin_profile.attr('src'));
		$('#admin_id').val(admin_id.text());
		$('#admin_pass').val(admin_pass.text());
		$('#admin_regdate').val(admin_regdate.text());
		$('#admin_addr').val(admin_addr.text());
		$('#admin_num').val(admin_num.text());
		$('#admin_name').val(admin_name.text());
		$('#stfImg > .stfRight').empty();
		$('#stfImg > .stfRight').append('<img src="' +admin_profile.attr('src') + '"/>');
		console.log($('#stfImg > .stfRight').html());
	}
	
});