/**
 * 
 */
$( function() {
    var dialog, form,
    	emailRegex = /^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/
     , 	empl_nm = $( "#empl_nm" )
     , 	id = $( "#id" )
     ,  email = $( "#email" )
     ,  pwd = $( "#pwd" ) 
     ,	fjumin = $( "#fjumin" )
     ,	bjumin = $( "#bjumin" ) 
     ,  allFields = $( [] ).add( empl_nm ).add( id ).add( email ).add( pwd )//.add( fjumin ).add( bjumin )
     ,  tips = $( ".validateTips" );
    	//alert($( "#email" ).val());
	$( "#joinUs" ).button().on( "click", function() {
		//alert("띠우나요?");
      dialog.dialog( "open" );
	})
	dialog = $( "#dialog-form" ).dialog({
      autoOpen: false,
      height: 450,
      width: 400,
      modal: true,
      buttons: {
         "회원등록" : addUser,
       	 닫기: function() {
          dialog.dialog( "close" );
        }
      },
      close: function() {
        form[ 0 ].reset();
        allFields.removeClass( "ui-state-error" );
      }
    });
    form = dialog.find( "form" ).on( "submit", function( event ) {
       
      	addUser();
      	return false;
      });
    function updateTips( t ) {
        tips
          .text( t )
          .addClass( "ui-state-highlight" );
        setTimeout(function() {
          tips.removeClass( "ui-state-highlight", 1500 );
        }, 500 );
      }
   
      function checkLength( o, n, min, max ) {
        if ( o.val().length > max || o.val().length < min ) {
          o.addClass( "ui-state-error" );
          updateTips( "회원의 " + n + " 글자수는 " +
            min + " 서부터" + max + "입니다." );
          return false;
        } else {
          return true;
        }
      }
   
      function checkRegexp( o, regexp, n ) {
        if ( !( regexp.test( o.val() ) ) ) {
          o.addClass( "ui-state-error" );
          updateTips( n );
          return false;
        } else {
          return true;
        }
      }
    function addUser() {
    	alert("empl_nm" + empl_nm.val());
    	var url = "allMember?command=AllmemberAdd";
      	var valid = true;
      	allFields.removeClass( "ui-state-error" );
      	
	    valid = valid && checkLength( empl_nm, "회원내임", 3, 16 );
	    valid = valid && checkLength( id, "유저아이디", 3, 16 );
   	   	valid = valid && checkLength( email, "이메일", 6, 80 );
   	   	valid = valid && checkLength( pwd, "비밀번호", 5, 16 );
   	   
	    valid = valid && checkRegexp( empl_nm, /^[a-z가-힝]([0-9a-z가-힝_\s])+$/i);
	    valid = valid && checkRegexp( id, /^[a-z]([0-9a-z_\s])+$/i);
   	   	valid = valid && checkRegexp( email, emailRegex);
   	   	valid = valid && checkRegexp( pwd, /^([0-9a-zA-Z])+$/ );
   	   	
       if ( valid ) {
    	   alert('Ajax Call name = ' + email.val() + ' password = ' + pwd.val());
    	   //var d = 'name='+ name.val() + '&email='+email.val() + '&pwd='+pwd.val();
    	  // alert('d : ' + d);
    	   var d = $("#fmt").serialize();
    	 $.ajax ({
    		 	url : url ,
    		 	data: d,
//    		 		'empl_nm='+ empl_nm.val()+
//    		 		 '&id='+ id.val()+
//    		 		 '&email='+email.val()+
//    		 		 '&pwd='+pwd.val()+
//    		 		 '&fjumin='+fjumin.val()+
//    		 		 '&bjumin='+bjumin.val(),
    		 		 //주민번호 벨리데이션
    		 	type : 'post' ,
    		 	
    			success : function(json) {
    			 	data = JSON.parse(json);
    			 	//json.name
    			 	alert("가입완료 입니다.");
    			 	alert("나머지는 회원정보수정으로 수정부탁합니다.");
    			}	
    	 		
    	 		, error:function(request,status,error){
    	 			alert("실패");
    	 			alert("code:"+request.status+"\n"+
    	 				  "message:"+request.responseText+"\n"+
    	 				  "error:"+error);
    	 		}
        	
    			
    	 });
    	 dialog.dialog( "close" );
       };
       return valid;
    }
});
