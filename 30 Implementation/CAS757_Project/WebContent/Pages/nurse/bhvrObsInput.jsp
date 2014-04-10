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
<title>Nurse</title>
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
<h1 style="margin-bottom:0;align:center" >Nurse - Acute Psychiatric Inpatient Observation System</h1></div>

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
			<td><input style="background:transparent;border:1px solid #ffffff" type="text" id="patientname" name="txtPatientName" value='<s:property value="#request.patientEntity.name"/>'/></td>
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
			<td> <s:checkbox id="inaction" name="withdraw" label="Inaction" value="false" fieldValue="15"/></td>
			<td> <s:checkbox id="isolation" name="withdraw" label="Isolation" value="false" fieldValue="15"/></td>
			<td> <s:checkbox id="seclusiveness" name="withdraw" label="Seclusiveness" value="false" fieldValue="15"/></td>
			<td> <s:checkbox id="absofsociint" name="withdraw" label="Absence of social interaction" value="false" fieldValue="15"/></td>
			<td> <s:checkbox id="passivity" name="withdraw" label="Passivity" value="false" fieldValue="10"/></td>
			<td> <s:checkbox id="avoidance" name="withdraw" label="Avoidance Behaviours" value="false" fieldValue="10"/></td>
			<td> <s:checkbox id="redorquispee" name="withdraw" label="Reduced or quiet speech" value="false" fieldValue="10"/></td>
			<td> <s:checkbox id="markedlyde" name="withdraw" label="Markedly decreased interest in things" value="false" fieldValue="10"/></td>
		</tr>
	</table>
</fieldset>

<fieldset>
	<legend><b>Disinhibition</b></legend>
	<table class="w-850">
		<tr>
			<td> <s:checkbox id="excessisoci" name="disinhibition" label="Excessive sociability" value="false" fieldValue="15"/></td>
			<td> <s:checkbox id="impulsiveness" name="disinhibition" label="Impulsiveness" value="false" fieldValue="15"/></td>
			<td> <s:checkbox id="instrusiveness" name="disinhibition" label="Intrusiveness" value="false" fieldValue="15"/></td>
			<td> <s:checkbox id="demandingness" name="disinhibition" label="Demandingness" value="false" fieldValue="15"/></td>
			<td> <s:checkbox id="disinhibition" name="disinhibition" label="Disinhibition" value="false" fieldValue="10"/></td>
			<td> <s:checkbox id="sexaggreimpul" name="disinhibition" label="Sexual/aggressive impulses" value="false" fieldValue="10"/></td>
			<td> <s:checkbox id="increorloudspee" name="disinhibition" label="Increased or loud speech" value="false" fieldValue="10"/></td>
			<td> <s:checkbox id="markincrint" name="disinhibition" label="Markedly increased interest in things" value="false" fieldValue="10"/></td>
		</tr>
	</table>
</fieldset>

<fieldset>
	<legend><b>Psychosis</b></legend>
	<table class="w-850">
		<tr>
			<td> <s:checkbox id="fearfulness_p" name="psychosis" label="Delusions" value="false" fieldValue="25"/></td>
			<td> <s:checkbox id="sadness_p" name="psychosis" label="Hallucinations" value="false" fieldValue="25"/></td>
			<td> <s:checkbox id="tension_p" name="psychosis" label="Thought disorder" value="false" fieldValue="25"/></td>
			<td> <s:checkbox id="isolation_p" name="psychosis" label="Markedly disorganised behaviour" value="false" fieldValue="25"/></td>
		</tr>
	</table>
</fieldset>

<fieldset>
	<legend><b>Congnitive Impairment</b></legend>
	<table class="w-850">
		<tr>
			<td> <s:checkbox id="fearfulness_c" name="congImp" label="Clouded consciousness (reduced awareness of surroundings, reduced alertness)" value="false" fieldValue="20"/></td>
			<td> <s:checkbox id="sadness_c" name="congImp" label="Disorientation" value="false" fieldValue="20"/></td>
			<td> <s:checkbox id="tension_c" name="congImp" label="Poor memory" value="false" fieldValue="20"/></td>
			<td> <s:checkbox id="despair_c" name="congImp" label="Inattentiveness" value="false" fieldValue="20"/></td>
			<td> <s:checkbox id="forgful" name="congImp" label="Forgetfulness" value="false" fieldValue="10"/></td>
			<td> <s:checkbox id="perplex" name="congImp" label="Perplexity" value="false" fieldValue="10"/></td>
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