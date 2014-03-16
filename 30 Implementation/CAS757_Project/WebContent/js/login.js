$(function() {
	$('#login').corner("13px");
	$('#loginBtn').corner("8px");
	$('#loginBtn').mouseover(function() {
		$(this).removeClass("default");
		$(this).addClass("activited");
	});
	$('#loginBtn').mouseout(function() {
		$(this).removeClass("activited");
		$(this).addClass("default");
	});
	$('#loginBtn').click(function() {
		var flag = false;
		if (vierfyEmpty($('#username'))) {
			flag = true;
		}
		if (!flag && vierfyEmpty($('#password'))) {
			flag = true;
		}
		if (!flag) {
			with (document.getElementById("loginForm")) {
				method = "post";
				action = "userManager/userAction!loginUser.action";
				submit();
			}
		}
	});
});

function vierfyEmpty(e) {
	var msg;
	var value = e.val();
	if ($.trim(value) == null || $.trim(value) == "" || $.trim(value).length == 0
			|| $.trim(value) == "-1") {
		msg = e.parent().parent().prev().find('td.column').text() + " can not be empty.";
		Boxy.alert(msg);
		return true;
	}
	return false;
}