/**
 * 
 */
$(document).ready(function() {
	$(".coffee").show();
	$(".ade").hide();
	$(".ice").hide();
	//파일 업로드시 미리보기
	var menuImg;
	$("#file1").change(function(){
		readURL(this);
	});
	function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            
            reader.onload = function (e) {
                $('.menuRight > img').attr('src', e.target.result);
            }
            reader.readAsDataURL(input.files[0]);
            console.log($('div.menuRight > img'));
        }
    }
	//카테고리 클릭시 해당하는 메뉴만 보이기
	$("#coffee").click(function(){
		$(".coffee").show();
		$(".ade").hide();
		$(".ice").hide();
	});
	$("#ade").click(function(){
		$(".coffee").hide();
		$(".ade").show();
		$(".ice").hide();
	});
	$("#ice").click(function(){
		$(".coffee").hide();
		$(".ade").hide();
		$(".ice").show();
	});
	
	//메뉴 눌렀을때 오른쪽 수정창에 띄우기
	var coffee=$('.coffee');
	var ade=$('.ade');
	var ice=$('.ice');
	
	coffee.click(function() {
		modifyMenu(this);
	});
	ade.click(function() {
		modifyMenu(this);
	});
	ice.click(function() {
		modifyMenu(this);
	});
	function modifyMenu(items) {
		var tg=$(items);
		var img=tg.find('> .items:eq(0) > img');
		var name=tg.find('> .items:eq(1)');
		var price=tg.find('> .items:eq(2)');
		var ctgr=tg.find('> .items:eq(3)');
		$('#nameText').val(name.text());
		$('#priceText').val(price.text());
		$('#ctgrText').val(ctgr.text());
		$('#menuImage > .menuRight').empty();
		$('#menuImage > .menuRight').append('<img src="' +img.attr("src") + '"/>');
	}
	//수정 버튼 눌렀을떄
	$("#update").click(function() {
		var updated = confirm("수정하시겠습니까?");
		if(updated==true) {
			var formData = new FormData();
			formData.set("menu_name",$("#nameText").val());
			formData.set("menu_price",$("#priceText").val());
			formData.set("menu_ctgr",$('#ctgrText').val());
			formData.set("menu_image",$("#file1")[0].files[0]);
			
			$.ajax({
				type:"post",
				url:"/jsp_project/mg/cafe/menuUpdate.do",
				data:formData,
				enctype:"multipart/form-data",
				processData:false,
				contentType:false,
				dataType:'text',
				success:function(data) {
					location.href="/jsp_project/mg/cafe/menuMain.do"
				}
			});
		}
	});
	//등록버튼 눌렀을때
	$('#insert').click(function() {
		var inserted=confirm("등록하시겠습니까?");
		
		if(inserted==true) {
			var formData = new FormData();
			formData.set("menu_name",$("#nameText").val());
			formData.set("menu_price",$("#priceText").val());
			formData.set("menu_image",$("#file1")[0].files[0]);
			formData.set("menu_ctgr",$('#ctgrText').val());
			alert(formData.get('menu_ctgr'));
			
			$.ajax({
				type:"post",
				url:"/jsp_project/mg/cafe/menuInsert.do",
				data:formData,
				enctype:"multipart/form-data",
				processData:false,
				contentType:false,
				dataType:'text',
				success:function(data) {
					location.href="/jsp_project/mg/cafe/menuMain.do"
				}
			});
		}
	});
	//삭제 버튼 눌렀을때
	$('#delete').click(function() {
		var deleted=confirm("정말 삭제하시겠습니까?");
		if(deleted==true) {
//			var formData = new FormData();
//			formData.set("menu_name",$("#nameText").val());
//			formData.set("menu_price",$("#priceText").val());
//			formData.set("menu_image",$("#file1")[0].files[0]);
//			formData.set("menu_ctgr",$('#ctgrText').val());
//			alert(formData.get('menu_ctgr'));
			var query= {
				menu_name:$('#nameText').val()	
			};
			$.ajax({
				type:"post",
				url:"/jsp_project/mg/cafe/menuDelete.do",
				data:query,
				success:function(data) {
					location.href="/jsp_project/mg/cafe/menuMain.do"
				}
			});
		}
	});
	
	//취소 버튼 눌렀을때
	$('#cancel').click(function() {
		var canceled=confirm("취소하시겠습니까?");
		if(canceled==true) {
			$('#nameText').val("");
			$('#priceText').val("");
			$('#menuImage > .menuRight').empty();
		}
	});
	
	
});
