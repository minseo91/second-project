<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
div {
	text-align: center;
}
</style>

<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>


<script type="text/javascript">
	google.charts.load('current', {
		'packages' : [ 'corechart' ]
	});
	google.charts.setOnLoadCallback(drawChart);

	function drawChart() {
		var data = google.visualization.arrayToDataTable([
				[ 'Task', 'Hours per Day' ], [ '탁주', 2 ], [ '청주', 5 ],
				[ '과실주', 11 ], [ '증류주', 6 ], ]);

		var options = {
			title : '매출 통계'
		};

		var chart = new google.visualization.PieChart(document
				.getElementById('piechart'));

		chart.draw(data, options);
	}
</script>
</head>
<body>

	<div>
		<div id="piechart" style="width:100% ; height: 600px;"></div>
	</div>

</body>
</html>