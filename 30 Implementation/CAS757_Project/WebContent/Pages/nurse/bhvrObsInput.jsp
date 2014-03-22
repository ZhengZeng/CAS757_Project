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
<script type="text/javascript" src="<%=basePath %>js/adminIndex.js"></script>
<script type="text/javascript">
	$(function() {
						
		$('#saveBtn').click(function() {
						if(checkEmpty("patientname")) {
							return false;
						}

						with (document.getElementById("searchPatientForm")) {
							method = "post";
							action = "nurseAction!saveObservationData.action";
							submit();
						}
					});	
							
	});
</script>
</head>
<body>
<div id="header" style="background-color:#FFA500;">
<h1 style="margin-bottom:0;align:center" >Acute Psychiatric Inpatient Observation System</h1></div>

<div id="menu" style="background-color:#FFD700;height:1460px;width:150px;float:left;">
<b>Menu</b><br>
<a href="/CAS757_Project/">Login Page</a><br>
Doctor Page<br>
<a href="/CAS757_Project/nurse/nurseAction!initSearchPatient.action">Nurse Module</a><br>
</div>
<div>
<form id="searchPatientForm">
<div class="title">Patient behaviour Observation Input</div>

<div class="ml-5 mt-2">
<fieldset>
	<legend><b>Patient Information</b></legend>
	<table class="w-850">
	
		<tr>
			<td>Patient Name</td>
			<td><input type="text" id="patientname" name="txtPatientName" /></td>
		</tr>
		<tr>
			<td colspan="3" class="h-30 ta-r">
				<input type="button" class="w-60" value="Save" id="saveBtn"></input>
			</td>
		</tr>
	</table>
</fieldset>

<fieldset>
	<legend><b>Emotional Distress</b></legend>
	<table class="w-850">
		<tr>
			<td> <s:checkbox id="fearfulness" name="fearfulness" label="Fearfulness" value="false" fieldValue="20"/></td>
			<td> <s:checkbox id="sadness" name="sadness" label="Sadness" value="false" fieldValue="20"/></td>
			<td> <s:checkbox id="tension" name="tension" label="Tension" value="false" fieldValue="20"/></td>
			<td> <s:checkbox id="despair" name="despair" label="Despair" value="false" fieldValue="20"/></td>
			<td> <s:checkbox id="mentalang" name="mentalang" label="Mental Anguish" value="false" fieldValue="20"/></td>
		</tr>
	</table>
</fieldset>

<fieldset>
	<legend><b>Widthdraw</b></legend>
	<table class="w-850">
		<tr>
			<td> <s:checkbox id="inaction" name="inaction" label="Inaction" value="false" fieldValue="20"/></td>
			<td> <s:checkbox id="isolation" name="isolation" label="Sadness" value="false" fieldValue="20"/></td>
			<td> <s:checkbox id="seclusivenes" name="seclusivenes" label="Seclusivenes" value="false" fieldValue="20"/></td>
			<td> <s:checkbox id="passivity" name="passivity" label="Passivity" value="false" fieldValue="20"/></td>
			<td> <s:checkbox id="avoidance" name="avoidance" label="Avoidance" value="false" fieldValue="20"/></td>
		</tr>
	</table>
</fieldset>

<fieldset>
	<legend><b>Disinhibition</b></legend>
	<table class="w-850">
		<tr>
			<td> <s:checkbox id="fearfulness_d" name="fearfulness_d" label="Fearfulness" value="false" fieldValue="20"/></td>
			<td> <s:checkbox id="sadness_d" name="sadness_d" label="Sadness" value="false" fieldValue="20"/></td>
			<td> <s:checkbox id="tension_d" name="tension_d" label="Tension" value="false" fieldValue="20"/></td>
			<td> <s:checkbox id="despair_d" name="despair_d" label="Despair" value="false" fieldValue="20"/></td>
			<td> <s:checkbox id="isolation" name="isolation" label="Isolation" value="false" fieldValue="20"/></td>
			<td> <s:checkbox id="passivity_d" name="passivity_d" label="Passivity" value="false" fieldValue="20"/></td>
			<td> <s:checkbox id="avoidance_d" name="avoidance_d" label="Avoidance" value="false" fieldValue="20"/></td>
		</tr>
	</table>
</fieldset>

<fieldset>
	<legend><b>Psychosis</b></legend>
	<table class="w-850">
		<tr>
			<td> <s:checkbox id="fearfulness_p" name="fearfulness_p" label="Fearfulness" value="false" fieldValue="20"/></td>
			<td> <s:checkbox id="sadness_p" name="sadness_p" label="Sadness" value="false" fieldValue="20"/></td>
			<td> <s:checkbox id="tension_p" name="tension_p" label="Tension" value="false" fieldValue="20"/></td>
			<td> <s:checkbox id="despair_p" name="despair_p" label="Despair" value="false" fieldValue="20"/></td>
			<td> <s:checkbox id="isolation_p" name="isolation_p" label="Isolation" value="false" fieldValue="20"/></td>
		</tr>
	</table>
</fieldset>

<fieldset>
	<legend><b>Congnitive Impairment</b></legend>
	<table class="w-850">
		<tr>
			<td> <s:checkbox id="fearfulness_c" name="fearfulness_c" label="Fearfulness" value="false" fieldValue="20"/></td>
			<td> <s:checkbox id="sadness_c" name="sadness_c" label="Sadness" value="false" fieldValue="20"/></td>
			<td> <s:checkbox id="tension_c" name="tension_c" label="Tension" value="false" fieldValue="20"/></td>
			<td> <s:checkbox id="despair_c" name="despair_c" label="Despair" value="false" fieldValue="20"/></td>
			<td> <s:checkbox id="mentalang_c" name="mentalang_c" label="Mental Anguish" value="false" fieldValue="20"/></td>
		</tr>
	</table>
</fieldset>

</div>

</form>
</div>
<div id="footer" style="background-color:#FFA500;clear:both;text-align:center;">
Copyright CAS 757 Group 6</div>
</body>
</html>