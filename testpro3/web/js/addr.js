/**
 * 
 */
$(function(){
	var dialog, form
	,	addrno = 	$("#addrno")
	,	zip_cd = 	$("#zip_cd")
	,	sido =		$("#sido")
	,	sigungu = 	$("#sigungu")
	,	dong =		$("#dong")
	,	ri = 		$("#ri")
	,	bldg = 		$("#bldg")
	,	bungi = 	$("#bungi")
	,	allAddrs = 	$([]).add(addrno).add(zip_cd).add(sido).add(sigungu).add(dong).add(ri).add(bldg).add(bungi)
	$("#addr").button().on("click" , function(){
		dialog.dialog("open");
	})
	dialog = $("#SearchAddr").dialog({
		autoOpen : false,
		height : 600,
		width : 400,
		modal : true,
		buttons : {
			"찾기" : selectAddr,
			닫기 : function() {
				dialog.dialog("close");
			}
		},
		close : function() {
			form[ 0 ].reset();
		}
	});
	form = dialog.find("form").on("submit", function(event) {
		selectAddr();
		return false;
	});
	function selectAddr() {
		 $.ajax ({
			 
		 })
	}
});