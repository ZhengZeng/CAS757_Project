<%@ include file="/Pages/common/common.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>

<head>
<base href="${pageContext.request.contextPath}/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CAS 757 Project</title>

<link rel="stylesheet" type="text/css" href="<%=basePath %>styles/login.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>styles/boxy.css" />
<script type="text/javascript" src="<%=basePath %>js/jquery.js"></script>	
<script type="text/javascript" src="<%=basePath %>js/jquery.corner.js"></script>
<script type="text/javascript" src="<%=basePath %>js/jquery.boxy.js"></script>
<script type="text/javascript" src="<%=basePath %>js/login.js"></script>
</head>
<body>
<div id="header" style="background-color:#FFA500;">
<h1 style="margin-bottom:0;align:center" >Acute Psychiatric Inpatient Observation System</h1></div>

<div id="menu" style="background-color:#FFD700;height:500px;width:150px;float:left;">
<b>Menu</b><br>
Admin Module<br>
Doctor Module<br>
Nurse Module</div>
<div id="login">
<s:form id="loginForm" validate="true">
	<table align="center">
		<tr>
			<td class="title" colspan="2">Log in to your account</td>
		</tr>
		<tr>
			<td colspan="2"><div id="errorArea">
				<s:fielderror cssStyle="errorArea">
					<s:param>error</s:param>
				</s:fielderror>
			</div></td>
		</tr>
		<tr>
			<td class="column">User Id</td>
			<td></td>
		</tr>
		<tr>
			<td class="column" colspan="2"><input type="text" class="loginInput" id="username" name="username" />
			</td>
		</tr>
		<tr>
			<td class="column">Password</td>
			<td></td>
		</tr>
		<tr>
			<td class="column" colspan="2"><input type="password" class="loginInput" id="password" name="pwd_login" />
			</td>
		</tr>
		<tr>
			<td><div id="loginBtn" class="default" title="Log in to your account"><span>Log-in</span></div></td>
		</tr>		
	</table>
</s:form>
</div>
<div id="footer" style="background-color:#FFA500;clear:both;text-align:center;">
Copyright CAS 757 Group 6</div>
</body>
</html>