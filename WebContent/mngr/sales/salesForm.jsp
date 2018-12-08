<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">

$(document).ready(function() {
//  var slist = '${slist}';
//  alert(slist);

//  var json = JSON.parse('${slist}');
//  console.log(json);
 
 // line차트를 그리는 부분
 new Morris.Line({
    //↓---필수 값(무조건 있어야 함)----↓
    element : 'lineChart', //div id값이 lineChart인 곳에 차트를 그린다.
    data : [{"month":"2018-01","totalSales":10000},{"month":"2018-02","totalSales":5000},{"month":"2018-03","totalSales":3000},{"month":"2018-04","totalSales":12000},{"month":"2018-05","totalSales":7000},{"month":"2018-06","totalSales":2000},{"month":"2018-07","totalSales":6000},{"month":"2018-08","totalSales":2000},{"month":"2018-09","totalSales":5000},{"month":"2018-10","totalSales":5000},{"month":"2018-11","totalSales":15000},{"month":"2018-12","totalSales":32000}],
    xkey : 'month',
    ykeys : [ 'totalSales' ],
    labels : [ '총 매출' ],
    //↑---필수 값(무조건 있어야 함)----↑
    lineColors : [ '#5F735E' ],
    pointSize : 10
 });
});

</script>
<style>
#lineChart{
width:700px;
}
</style>
</head>
<body>
<div>매출관리</div>
<div id="lineChart"></div>
</body>
</html>