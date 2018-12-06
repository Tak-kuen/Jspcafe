/**
 * 
 */

$(document).ready(function() {
	$("#menu").click(function() {
		location.href="/jsp_project/mg/cafe/menuMain.do";
	});
	$("#mileage").click(function() {
		location.href="/jsp_project/mg/mile/mileMain.do";
	});
	$("#customer").click(function() {
		location.href="/jsp_project/mg/customer/customerForm.do";
	});
	$("#admin").click(function() {
		location.href="/jsp_project/mg/staff/staffForm.do";
	});
	$("#sales").click(function() {
		location.href="/jsp_project/mg/managerMain.do";
	});
	$("#main").click(function() {
		location.href="/jsp_project/mg/managerMain.do";
	});
	
	
	$(".coffee").show();
	$(".ade").hide();
	$(".ice").hide();
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
	
});