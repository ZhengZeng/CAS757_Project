$(function() {
			adornTableList("userList");

		});

function adornTableList(tableId) {
	var id = "#" + tableId;
	$(id).find('tbody tr').mouseover(function() {
				$(this).addClass("mouseover");
			});

	$(id).find('tbody tr').mouseout(function() {
				$(this).removeClass("mouseover");
			});
}

function del() {
	if (confirm("Are you sure to delete it?")) {
		return true;
	}
	return false;
}

function checkEmpty(objectId) {
	var idt = "#" + objectId;
	var value = $(idt).val();
	if ($.trim(value) == null || $.trim(value).length == 0 || $.trim(value) == "-1") {
		$(idt).focus();
		var tip = $(idt).parent().prev().text();
		alert(tip + " can not be empty.");
		return true;
	}
	return false;
}

