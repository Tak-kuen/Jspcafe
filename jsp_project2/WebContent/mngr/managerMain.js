/**
 * 매니저 메인화면 버튼 핸들링
 */
$(document).ready(function() {
	var coffee=$('.coffee');
	var ade=$('.ade');
	var ice=$('.ice');
	var count=1;
	coffee.click(function() {
		addPayLists(this);
	});
	ade.click(function() {
		addPayLists(this);
	});
	ice.click(function() {
		addPayLists(this);
		countLists(this);
	});
	$('#orderReset').click(function() {
		count=1;
		$('.paylists').empty();
	});
	
	function addPayLists(items) {
		var tg=$(items);
		var mCount=1;
		var name=tg.find('> .items:eq(1)');
		var price=tg.find('> .items:eq(2)');
		$('.paylists').append('<div class="name"><div class="order">'+count+'</div><div class="order">'+name.text()+
				'</div><div class="order">' +mCount+'</div><div class="order">' +price.text()+'</div></div>');
		count++;
	}
	function countLists(items) {
		var tg=$(items);
		var name=tg.find('> .items:eq(1)');
		var nameC = $('.paylists > .name').children().eq(1);
		var numC=nameC.next().text();
		console.log(nameC.text());
		console.log(numC);
	}
});