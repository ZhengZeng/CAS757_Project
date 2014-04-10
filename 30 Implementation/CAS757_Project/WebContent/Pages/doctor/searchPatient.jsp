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
<script type="text/javascript" src="<%=basePath %>js/adminIndex.js"></script>
<script type="text/javascript">
	$(function() {
				
		$('.spreadsheet tbody tr').click(function() {
						var patientId = $(this).find("td:first").text();
						with (document.getElementById("searchPatientForm")) {
							method = "post";
							action = "doctorAction!pickPatient.action?hidPatientId=" + patientId;
							submit();
						}
					});
		
		$('#searchBtn').click(function() {
						if(checkEmpty("patientname")) {
							return false;
						}

						with (document.getElementById("searchPatientForm")) {
							method = "post";
							action = "doctorAction!searchPatient.action";
							submit();
						}
					});	
							
	});
</script>
</head>
<body>
<div id="header" style="background-color:#FFA500;">
<h1 style="margin-bottom:0;align:center" >Doctor - Acute Psychiatric Inpatient Observation System</h1></div>

<div id="menu" style="background-color:#FFD700;height:620px;width:150px;float:left;">
<b>Menu</b><br>
<a href="/CAS757_Project/">Logout</a><br>
<a href="/CAS757_Project/doctor/doctorAction!initSearchPatient.action">Doctor Page</a>
</div>
<div>
<form id="searchPatientForm">
<div class="title">Patient Search Page</div>

<div class="ml-5 mt-2">
<fieldset><legend>Search Patient</legend>
<table class="w-850">

	<tr>
		<td>Patient Name</td>
		<td><input type="text" id="patientname" name="txtPatientName" /></td>
	</tr>
	<tr>
		<td colspan="3" class="h-30 ta-r">
			<input type="button" class="w-60" value="Search" id="searchBtn"></input>
		</td>
	</tr>
</table>
</fieldset>
</div>

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