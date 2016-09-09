/**
 * 
 */

$(function(){
	var dialog, form

	$("#school").button().on("click" , function(){
		schoolLog.dialog("open");
	})
	schoolLog = $("#schoolList").dialog({
		autoOpen : false,
		height : 600,
		width : 400,
		modal : true,
		buttons : {
			"등록" : schoolAll,
			닫기 : function() {
				schoolLog.dialog("close");
			}
		},
		close : function() {
			form[ 0 ].reset();
		}
	});
	form = schoolLog.find("form").on("submit", function(event) {
		schoolAll();
		return false;
	});
	function schoolAll() {
		 $.ajax ({
			 
		 })
	}
});