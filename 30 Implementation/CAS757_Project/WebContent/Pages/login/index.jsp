<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
<base href="${pageContext.request.contextPath}/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CAS 757 Project</title>

<link href="css/site_before.css" media="all" rel="stylesheet"
	type="text/css">
<link href="css/home.css" media="screen" rel="stylesheet"
	type="text/css">

<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/jquery.validator.js" type="text/javascript"></script>
<script src="js/jquery.corners.min.js" type="text/javascript"></script>

<style>
.errorTip {
	background-image: url(images/access_disallow.gif);
	background-repeat: no-repeat;
	padding-left: 16px;
}

.errorInput {
	background-color: #FFCC33;
}

.validTip {
	background-image: url('images/access_allow.gif');
	background-repeat: no-repeat;
	background-position: left top;
	padding: 2px;
}
</style>
<script type="text/javascript">
			$(document).ready(function() {
				$("#userName").blur(function() {
					var $parent = $(this).parent();
					$parent.find(".formtips").remove();
			
					}).keyup(function() {
							$(this).triggerHandler("blur");
						}).focus(function() {
							$(this).triggerHandler("blur");
						});// end blur
			
				// submit and check
				$('#sub').click(function() {
					var userNameCheck = document.getElementById("userNameCheckDiv").innerHTML;
					var emailCheck = document.getElementById("emailCheckDiv").innerHTML;
					var userName = document.getElementById("userName").value;
					var email = document.getElementById("email").value;
			
					if (userName == "" || userName.length < 6 || userName.length > 16) {
						var errorMsg = 'Please enter 6 - 16 characters';
						alert(errorMsg);
						return false;
					}
			
					if (userNameCheck == "&nbsp;&nbsp;&nbsp;Unavaliable user name") {
						alert('Please use another name', 'Error Message');
						userName.innerHTML = "";
						return false;
					}			
				});
			});
			// Reset
			var xmlHttp;
			function createXMLHttpRequest() {
				if (window.ActiveXObject) {
					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
				} else if (window.XMLHttpRequest) {
					xmlHttp = new XMLHttpRequest();
				}
			}
			
			function ajaxCheckName() {
				var userName = encodeURI(document.getElementById("userName").value);
				createXMLHttpRequest();
				xmlHttp.onreadystatechange = processajaxCheckName;
				var url = "userManager/userAction!checkUserName.action?userName="
						+ encodeURI(userName);
				xmlHttp.open("GET", url, true);
				xmlHttp.send(null);
			}
			
	</script>
<body id="home" class="purple alternate">
	<header class="main"> </header>
	<div class="container">
		<div class="elements">
			<form class="ui inline-login form"
				action="userManager/userAction!loginUser.action" method="post">
				<div class="field">
					<label for="email"> User Name </label> <input type="text" name="userName"
						tabindex="1" class="filled">
				</div>
				<div class="field">
					<label for="password"> Password </label> <input type="password"
						name="pwd_login" tabindex="2">
				</div>

				<input style="width: 60px;"  type="submit"> 

			</form>
		</div>
	</div>


	<footer class="main">
	<div class="container"></div>
	</footer>
</body>
</html>