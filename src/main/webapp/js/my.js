$(document).ready(function(){

	$("#loginBtn").click(function(){
		var id=$("#id").val();
		var pw=$("#pw").val();
			
		$.post("login.sms",
			  {			   
			  	
			    id:id,
			    pw:pw
			    
			  },
			  
			
			  function(data, status){
			 		
			 	$.cookie("logined",data);		
			  	$("#msgDiv").html("<h2>"+data+"</h2>");			   
					   
			  }
		); 
	});
	
	$("#memberInsertBtn").click(function(){

		var name=$("#name").val();
		var id=$("#id").val();
		var pw=$("#pw").val();
		
		alert(name+":"+id+":"+pw);
		
		$.post("../memberInsert.sms",
			  {
			    name:name,
			    id:id,
			    pw:pw
			 
			  },
			  function(data, status){			  		    
				//$("#msgDiv", opener.document).html(data+"님의 Spark");	
				alert(data);		    
				window.close();	   
			  }
		);//end post()
	});
	

});
