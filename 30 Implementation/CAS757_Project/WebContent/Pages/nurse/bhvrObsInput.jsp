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
<a href="/CAS757_Project/">LogOut</a><br>
<a href="/CAS757_Project/nurse/nurseAction!initSearchPatient.action">Nurse Page</a><br>
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
			<td> <s:checkbox id="fearfulness" name="emtDis" label="Fearfulness" value="false" fieldValue="20"/></td>
			<td> <s:checkbox id="sadness" name="emtDis" label="Sadness" value="false" fieldValue="20"/></td>
			<td> <s:checkbox id="tension" name="emtDis" label="Tension" value="false" fieldValue="20"/></td>
			<td> <s:checkbox id="despair" name="emtDis" label="Despair" value="false" fieldValue="20"/></td>
			<td> <s:checkbox id="mentalang" name="emtDis" label="Mental Anguish" value="false" fieldValue="20"/></td>
		</tr>
	</table>
</fieldset>

<fieldset>
	<legend><b>Withdraw</b></legend>
	<table class="w-850">
		<tr>
			<td> <s:checkbox id="inaction" name="withdraw" label="Inaction" value="false" fieldValue="20"/></td>
			<td> <s:checkbox id="isolation" name="withdraw" label="Sadness" value="false" fieldValue="20"/></td>
			<td> <s:checkbox id="seclusivenes" name="withdraw" label="Seclusivenes" value="false" fieldValue="20"/></td>
			<td> <s:checkbox id="passivity" name="withdraw" label="Passivity" value="false" fieldValue="20"/></td>
			<td> <s:checkbox id="avoidance" name="withdraw" label="Avoidance" value="false" fieldValue="20"/></td>
		</tr>
	</table>
</fieldset>

<fieldset>
	<legend><b>Disinhibition</b></legend>
	<table class="w-850">
		<tr>
			<td> <s:checkbox id="fearfulness_d" name="disinhibition" label="Fearfulness" value="false" fieldValue="20"/></td>
			<td> <s:checkbox id="sadness_d" name="disinhibition" label="Sadness" value="false" fieldValue="20"/></td>
			<td> <s:checkbox id="tension_d" name="disinhibition" label="Tension" value="false" fieldValue="20"/></td>
			<td> <s:checkbox id="despair_d" name="disinhibition" label="Despair" value="false" fieldValue="20"/></td>
			<td> <s:checkbox id="isolation" name="disinhibition" label="Isolation" value="false" fieldValue="20"/></td>
			<td> <s:checkbox id="passivity_d" name="disinhibition" label="Passivity" value="false" fieldValue="20"/></td>
			<td> <s:checkbox id="avoidance_d" name="disinhibition" label="Avoidance" value="false" fieldValue="20"/></td>
		</tr>
	</table>
</fieldset>

<fieldset>
	<legend><b>Psychosis</b></legend>
	<table class="w-850">
		<tr>
			<td> <s:checkbox id="fearfulness_p" name="psychosis" label="Fearfulness" value="false" fieldValue="20"/></td>
			<td> <s:checkbox id="sadness_p" name="psychosis" label="Sadness" value="false" fieldValue="20"/></td>
			<td> <s:checkbox id="tension_p" name="psychosis" label="Tension" value="false" fieldValue="20"/></td>
			<td> <s:checkbox id="despair_p" name="psychosis" label="Despair" value="false" fieldValue="20"/></td>
			<td> <s:checkbox id="isolation_p" name="psychosis" label="Isolation" value="false" fieldValue="20"/></td>
		</tr>
	</table>
</fieldset>

<fieldset>
	<legend><b>Congnitive Impairment</b></legend>
	<table class="w-850">
		<tr>
			<td> <s:checkbox id="fearfulness_c" name="congImp" label="Fearfulness" value="false" fieldValue="20"/></td>
			<td> <s:checkbox id="sadness_c" name="congImp" label="Sadness" value="false" fieldValue="20"/></td>
			<td> <s:checkbox id="tension_c" name="congImp" label="Tension" value="false" fieldValue="20"/></td>
			<td> <s:checkbox id="despair_c" name="congImp" label="Despair" value="false" fieldValue="20"/></td>
			<td> <s:checkbox id="mentalang_c" name="congImp" label="Mental Anguish" value="false" fieldValue="20"/></td>
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