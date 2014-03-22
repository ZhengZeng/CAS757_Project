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
		var role = "<s:property value="#request.user.role"/>";
		$('#role').val(role);
		//alert(role);
		var comments = "<s:property value="#request.user.comments"/>";
		$('#comments').val(comments);
		
		var userNo = $('#userNo').val();
		if ($.trim(userNo) == null || $.trim(userNo).length == 0) {
			$('#createBtn').removeAttr("disabled");
			$('#updateBtn').attr("disabled", "disabled");
			$('#deleteBtn').attr("disabled", "disabled");
		} else {
			$('#createBtn').attr("disabled", "disabled")
			$('#updateBtn').removeAttr("disabled");
			$('#deleteBtn').removeAttr("disabled");
		}
		
		$('.spreadsheet tbody tr').click(function() {
						var userId = $(this).find("td:first").text();
						with (document.getElementById("adminIndexForm")) {
							method = "post";
							action = "adminAction!pickUser.action?page=${userInfo.page}&hidUserId=" + userId;
							submit();
						}
					});
					
		$('#clearBtn').click(function() {
						$('#userNo').val('');	
						$('#username').val('');
						$('#password').val('');
						$('#role').val(0);	
						$('#comments').val('');	
						$('#createBtn').removeAttr("disabled");
						$('#updateBtn').attr("disabled", "disabled");
						$('#deleteBtn').attr("disabled", "disabled");
		});
		
		$('#createBtn').click(function() {
						if(checkEmpty("username")) {
							return false;
						}
						if(checkEmpty("password") ) {
							return false;
						}
						if($('#role').val() == '0'){
							alert("Please select a role.");
							return false;
						}else{
							if(checkEmpty("role") ) {
								return false;
							}
						}

						with (document.getElementById("adminIndexForm")) {
							method = "post";
							action = "adminAction!createUser.action";
							submit();
						}
					});	
					
		$('#updateBtn').click(function() {
						if(checkEmpty("username")) {
							return false;
						}
						if(checkEmpty("password")) {
							return false;
						}
						if($('#role').val() == '0'){
							alert("Please select a role.");
							return false;
						}else{
							if(checkEmpty("role") ) {
								return false;
							}
						}
						with (document.getElementById("adminIndexForm")) {
							method = "post";
							action = "adminAction!updateUser.action?page=${userInfo.page}";
							submit();
						}
					});	
					
		$('#deleteBtn').click(function() {
						if(checkEmpty("username")) {
							return false;
						}
						if(checkEmpty("password")) {
							return false;
						}
						if(checkEmpty("role")) {
							return false;
						}
						var flag = del();
						if (flag) {
							with (document.getElementById("adminIndexForm")) {
								method = "post";
								action = "adminAction!delUser.action?page=${userInfo.page}";
								submit();
							}
						}
					});						
		
	});
</script>
</head>
<body>
<div id="header" style="background-color:#FFA500;">
<h1 style="margin-bottom:0;align:center" >Acute Psychiatric Inpatient Observation System</h1></div>

<div id="menu" style="background-color:#FFD700;height:620px;width:150px;float:left;">
<b>Menu</b><br>
<a href="/CAS757_Project/">Login Page</a><br>
Doctor Module<br>
<a href="/CAS757_Project/nurse/nurseAction!initSearchPatient.action">Nurse Module</a><br>
</br></div>
<div>
<form id="adminIndexForm">
<div class="title">Administrator</div>
<div class="ml-5 mt-2">
<fieldset><legend>User Information</legend>
<table class="w-850">
  
	<tr>
		<td></td>
		<td colspan="2"><input type="hidden" id="userNo" name="user.id" value='<s:property value="#request.user.id"/>' /></td>
	</tr>

	<tr>
		<td>User Name</td>
		<td><input type="text" id="username" name="txtUserName" value='<s:property value="#request.user.name"/>' /></td>
		<td><s:if test="#request.error1 != null"> 
			<span class="error1">Username exist, please change one.</span>
		</s:if> <s:elseif test="#request.error2 != null">
			<span class="error2">Username can not be modified.</span>
		</s:elseif></td>
	</tr>
	<tr>
		<td>Password</td>
		<td colspan="2"><input type="password" id="password" name="txtPwd" value='<s:property value="#request.user.password"/>' />
		</td>
	</tr>
	<tr>
		<td colspan="2"><s:select id="role" list="#{0:'--Please Select--',1:'Doctor',2:'Nurse',3:'Admin',4:'Patient'}" name="ddRole" label="Role" listKey="key" listValue="value" value="#request.user.role" />
		</td>
	</tr>
	<tr>
		<td>Comments</td>
		<td colspan="2">
		<s:textarea cssClass="textarea" id="comments" theme="simple" name="txtCom" rows="2" cols="20" >
		</s:textarea>
		</td>
	</tr>
	<tr>
		<td colspan="3" class="h-30 ta-r">
			<input type="button" class="w-60" value="Clear" id="clearBtn"></input>
			<input type="button" class="w-60" value="Create" id="createBtn"></input> 
			<input type="button" class="w-60" value="Update" id="updateBtn"></input> 
			<input type="button" class="w-60" value="Delete" id="deleteBtn"></input>
		</td>
	</tr>
</table>
</fieldset>
</div>

<div class="ml-5 mt-2">
	<display:table class="spreadsheet" id="userList" name="users" requestURI="adminAction!searchUser.action">
		<display:column class="content" property="id" titleKey="SN" sortable="true" />
		<display:column class="content" property="name" titleKey="Name" sortable="true" />
		<display:column class="content" property="role" titleKey="Role" />
		<display:column class="content" property="comments" titleKey="Comments" />
	</display:table>
</div>
</form>
</div>
<div id="footer" style="background-color:#FFA500;clear:both;text-align:center;">
Copyright CAS 757 Group 6</div>
</body>
</html>