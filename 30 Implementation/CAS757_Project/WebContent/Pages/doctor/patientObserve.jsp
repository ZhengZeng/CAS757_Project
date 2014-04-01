<%@ include file="/Pages/common/common.jsp"%>
<%@ taglib uri="/WEB-INF/displaytag.tld" prefix="display"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>styles/base.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>styles/position.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>styles/displaytag.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>styles/admin.css" />
<title>Administrator</title>
<script type="text/javascript" src="<%=basePath %>js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath %>js/jscharts.js"></script>

</head>
<body>
<div id="header" style="background-color:#FFA500;">
<h1 style="margin-bottom:0;align:center" >Doctor -Observing Page</h1></div>

<div id="menu" style="background-color:#FFD700;height:620px;width:150px;float:left;">
<b>Menu</b><br>
<a href="/CAS757_Project/">Logout</a><br>
<a href="/CAS757_Project/doctor/doctorAction!initSearchPatient.action">Doctor Page</a>
</div>
<div>
<form id="patientChartForm">
<div class="title">Patient Chart</div>
<br></br>
<div class="ml-5 mt-2" id="graph" >Loading...</div>
<script type="text/javascript">
	
	var myChart = new JSChart('graph', 'line');
	myChart.setDataArray([[1, 80],[2, 40],[3, 60],[4, 65],[5, 50],[6, 50],[7, 60],[8, 80],[9, 150],[10, 100]], 'blue');
	myChart.setDataArray([[1, 100],[2, 55],[3, 80],[4, 115],[5, 80],[6, 70],[7, 30],[8, 130],[9, 160],[10, 170]], 'green');
	myChart.setDataArray([[1, 150],[2, 25],[3, 100],[4, 80],[5, 20],[6, 65],[7, 0],[8, 155],[9, 190],[10, 200]], 'gray');
	myChart.setDataArray([[1, 100],[2, 55],[3, 80],[4, 70],[5, 80],[6, 70],[7, 30],[8, 60],[9, 160],[10, 100]], 'red');
	myChart.setDataArray([[1, 150],[2, 25],[3, 80],[4, 80],[5, 50],[6, 90],[7, 0],[8, 155],[9, 190],[10, 150]], 'purple');	
	myChart.setSize(800, 400);
	myChart.setAxisValuesNumberY(5);
	myChart.setIntervalStartY(0);
	myChart.setIntervalEndY(200);
	myChart.setLabelX([2,'p1']);
	myChart.setLabelX([4,'p2']);
	myChart.setLabelX([6,'p3']);
	myChart.setLabelX([8,'p4']);
	myChart.setLabelX([10,'p5']);
	myChart.setAxisValuesNumberX(5);
	myChart.setShowXValues(false);
	myChart.setTitleColor('#454545');
	myChart.setAxisValuesColor('#454545');
	myChart.setLineColor('#A4D314', 'green');
	myChart.setLineColor('#BBBBBB', 'gray');
	myChart.setLineColor('#E4F364', 'red');
	myChart.setLineColor('#BA2B41', 'purple');
	myChart.setTooltip([1,' ']);
	myChart.setTooltip([2,' ']);
	myChart.setTooltip([3,' ']);
	myChart.setTooltip([4,' ']);
	myChart.setTooltip([5,' ']);
	myChart.setTooltip([6,' ']);
	myChart.setTooltip([7,' ']);
	myChart.setTooltip([8,' ']);
	myChart.setTooltip([9,' ']);
	myChart.setTooltip([10,' ']);
	myChart.setFlagColor('#9D16FC');
	myChart.setFlagRadius(4);
	myChart.setAxisPaddingRight(100);
	myChart.setLegendShow(true);
	myChart.setLegendPosition("bottom left");
	myChart.setLegendForLine('blue', 'Emotional Distress');
	myChart.setLegendForLine('green', 'Widthdraw');
	myChart.setLegendForLine('gray', 'Disinhibition');
	myChart.setLegendForLine('red', 'Psychosis');
	myChart.setLegendForLine('purple', 'Congnitive Impairment');
	myChart.draw();
	
</script>


<div class="ml-5 mt-2">
	<display:table class="spreadsheet" id="patientList" name="patients" requestURI="doctorAction!searchPatient.action">
		<display:column class="content" property="id" titleKey="SN" sortable="true" />
		<display:column class="content" property="name" titleKey="Name" sortable="true" />
		<display:column class="content" property="comments" titleKey="Comments" />
	</display:table>
</div>
</form>
</div>
<div id="footer" style="background-color:#FFA500;clear:both;text-align:center;">
Copyright CAS 757 Group 6</div>
</body>
</html>