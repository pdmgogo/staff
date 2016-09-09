/**
 * 
 */

$(function(){
	var dialog, form
	
	$("#lic").button().on("click" , function(){
		licLog.dialog("open");
	})
	licLog = $("#licList").dialog({
		autoOpen : false,
		height : 400,
		width : 400,
		modal : true,
		buttons : {
			"등록" : licAll,
			닫기 : function() {
				licLog.dialog("close");
			}
		},
		close : function() {
			form[ 0 ].reset();
		}
	});
	form = licLog.find("form").on("submit", function(event) {
		licAll();
		return false;
	});
	function licAll() {
		 $.ajax ({
			
		 })
	}
});