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
<title>Doctor</title>
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
<div class="ml-5 mt-2">
<fieldset>
	<legend><b>Patient Information</b></legend>

	<td>Patient Name : </td>
	<td><input type="text" id="patientname" name="txtPatientName"  style="background:transparent;border:1px solid #ffffff" value='<s:property value="#request.patientEntity.name"/>' /></td>

<br></br>
<div class="ml-5 mt-2" id="graph" >Loading...</div>
<script type="text/javascript">
	//for demo purpose:
	var myChart = new JSChart('graph', 'line');
	var demoId = "<s:property value="#request.patientEntity.comments"/>";
	if(demoId == "stay normal"){
		myChart.setDataArray([[1, 80],[2, 40],[3, 60],[4, 65],[5, 50],[6, 50],[7, 60],[8, 80],[9, 50],[10, 60]], 'blue');
		myChart.setDataArray([[1, 70],[2, 55],[3, 70],[4, 70],[5, 80],[6, 70],[7, 30],[8, 30],[9, 60],[10, 60]], 'green');
		myChart.setDataArray([[1, 50],[2, 25],[3, 60],[4, 60],[5, 20],[6, 65],[7, 10],[8, 55],[9, 90],[10, 30]], 'gray');
		myChart.setDataArray([[1, 70],[2, 55],[3, 80],[4, 70],[5, 80],[6, 70],[7, 30],[8, 60],[9, 60],[10, 40]], 'red');
		myChart.setDataArray([[1, 90],[2, 25],[3, 80],[4, 50],[5, 50],[6, 90],[7, 30],[8, 20],[9, 10],[10, 20]], 'purple');	
	}else if(demoId == "getting better"){
		myChart.setDataArray([[1, 60],[2, 40],[3, 60],[4, 35],[5, 20],[6, 50],[7, 60],[8, 40],[9, 15],[10, 10]], 'blue');
		myChart.setDataArray([[1, 70],[2, 55],[3, 80],[4, 75],[5, 30],[6, 70],[7, 30],[8, 30],[9, 10],[10, 15]], 'green');
		myChart.setDataArray([[1, 80],[2, 25],[3, 70],[4, 30],[5, 20],[6, 65],[7, 5],[8, 15],[9, 20],[10, 25]], 'gray');
		myChart.setDataArray([[1, 80],[2, 55],[3, 70],[4, 75],[5, 55],[6, 70],[7, 30],[8, 20],[9, 60],[10, 30]], 'red');
		myChart.setDataArray([[1, 90],[2, 25],[3, 85],[4, 60],[5, 50],[6, 90],[7, 10],[8, 35],[9, 40],[10, 25]], 'purple');			
	}else{
		myChart.setDataArray([[1, 10],[2, 40],[3, 60],[4, 65],[5, 50],[6, 50],[7, 70],[8, 80],[9, 65],[10, 90]], 'blue');
		myChart.setDataArray([[1, 20],[2, 55],[3, 30],[4, 55],[5, 80],[6, 70],[7, 75],[8, 90],[9, 60],[10, 70]], 'green');
		myChart.setDataArray([[1, 15],[2, 28],[3, 15],[4, 80],[5, 60],[6, 45],[7, 60],[8, 75],[9, 90],[10, 65]], 'gray');
		myChart.setDataArray([[1, 40],[2, 55],[3, 60],[4, 70],[5, 80],[6, 70],[7, 55],[8, 60],[9, 75],[10, 90]], 'red');
		myChart.setDataArray([[1, 20],[2, 25],[3, 10],[4, 20],[5, 25],[6, 30],[7, 10],[8, 35],[9, 70],[10, 75]], 'purple');			
	}
	myChart.setSize(800, 400);
	myChart.setAxisValuesNumberY(5);
	myChart.setIntervalStartY(0);
	myChart.setIntervalEndY(100);
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
	<display:table class="spreadsheet" id="obsDataList" name="obsData" requestURI="doctorAction!pickPatient.action">
		<display:column class="content" property="createDate" titleKey="Date" sortable="true" />
		<display:column class="content" property="emtDisV" titleKey="Emotional Distress"  />
		<display:column class="content" property="withdV" titleKey="Widthdraw"  />
		<display:column class="content" property="disinhV" titleKey="Disinhibition" />
		<display:column class="content" property="psychV" titleKey="Psychosis"  />
		<display:column class="content" property="congImpV" titleKey="Congnitive Impairment" />
	</display:table>
</div>
</form>
</div>
<div id="footer" style="background-color:#FFA500;clear:both;text-align:center;">
Copyright CAS 757 Group 6</div>
</body>
</html>