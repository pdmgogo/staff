/**
 * 
 */

$(function(){
	var dialog , form
	//값
	$("#comp").button().on("click" , function(){
		complog.dialog("open");
	})
	complog = $("#company").dialog({
		autoOpen : false,
		height : 600,
		width : 400,
		modal : true,
		buttons : {
			"등록" : companyAll,
			닫기 : function() {
				complog.dialog("close");
			}
		},
		close : function() {
			form[ 0 ].reset();
		}
	});

	form = complog.find("form").on("submit", function(event) {
		companyAll();
		return false;
	});
	function companyAll() {
		 $.ajax ({
			 
		 })
	}
});