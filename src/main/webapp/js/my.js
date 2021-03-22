$(document).ready(function(){



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
				
				alert(data);		    
				window.close();	   
			  }
		);//end post()
	});
	
	function start_chat(){
		alert();
	}
	


	$("#loginBtn").click(function(){	
		
		var id=$("#id").val();
		var pw=$("#pw").val();
		
		//alert(id+":"+pw);		
		
		$.post("login.sms",
			  {			   
			    id:id,
			    pw:pw
			  },
			  function(data, status){	
			  var obj=JSON.parse(data);			  
			  	if(obj.name){
			  		data = obj.name+"<input type='button' value='logout' id='logoutBtn' class='btn btn-primary'>";	
			  		$.cookie("logined",data);	    
					$("#msgDiv").html(data );	
					$("#msgDiv2").html("님의 Sparking Story");	
				}else{
					alert(obj.msg);
					location.reload();
						
				}				   
			  }
		);
	});

	
	
	$(document).on("click", "#logoutBtn", function(event) { 
	
		$.post("logout.sms",
			  {			   
			   
			  },
			  function(data, status){		  	
			  	
			  	$.removeCookie("logined");	    
				location.reload();						   
			  }
		);//end post() 
	

	

	


});
});