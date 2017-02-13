function forDeActiveMode(partnerEmail, partnerName){
	/*$( document ).on( "click", function( event ) {
		  $(event.target).closest( ".active" ).removeClass( "btn-success").addClass('btn-danger');
		});*/
	
				swal({
					title: "Are you sure to de-activate?",
					text: partnerName+" is going to De-Activated As Partner Account.",
					type: "warning",
					showCancelButton: true,
					confirmButtonColor: '#DD6B55',
					confirmButtonText: 'Click, To Confirm!',
					cancelButtonText: "No, Cancel!",
					closeOnConfirm: false,
					closeOnCancel: false
				},
				function(isConfirm){
			    if (isConfirm){
			     
			    	 $.ajax(
							    {
								    url : 'DeActivateParterAccount',
							        type: "POST",
							        data : {emailId: partnerEmail},
							        success:function(response) 
							        {
								      	if(response.status == "Success")
									      {
								      		swal("De-Activated", partnerName+" has been successfully de-activated.", "success");
								      		setTimeout("location.reload(true);",1500);
									      }
								      	else
								      		{
								      		swal("Try Again", "No User Found.  Kindly refresh Page", "error");
								      		}

									  
							        },
							        error: function(jqXHR, textStatus, errorThrown) 
							        {
							        	swal("Try Again", "Server Exception  Kindly do it again.", "error");
							    		
							        }
							    });
			      
			    } else {
			      swal("Cancelled", "De-Activation Process Cancelled.", "error");
			    }
				});
				
		}

function forActiveMode(partnerEmail, partnerName){
	swal({
		title: "Are you sure?",
		text: partnerName+" is going to Activated As Partner Account.",
		type: "warning",
		showCancelButton: true,
		confirmButtonColor: '#00a65a',
		confirmButtonText: 'Click, To Confirm!',
		cancelButtonText: "No, Cancel!",
		closeOnConfirm: false,
		closeOnCancel: false
	},
	function(isConfirm){
    if (isConfirm){
     
    	 $.ajax({
				url : 'ActivateParterAccount',
				type: "POST",
				data : {emailId: partnerEmail},
				success:function(response) 
				{
				if(response.status == "Success")
				 {
					swal("Activated", partnerName+" has been successfully activated.", "success");
					setTimeout("location.reload(true);",1500);
				 }
					else
						{
					      		swal("Try Again", "No User Found.  Kindly refresh Page", "error");
					      		}
				        },
				        error: function(jqXHR, textStatus, errorThrown) 
				        {
				        	swal("Try Again", "Server Exception. Kindly do it again.", "error");
				    		
				        }
				    });
      
    } else {
    	swal("Cancelled", "Activation Process Cancelled.", "error");
    }
	});
	
}

function forDeletePartnerPayment(paymentId, partnerEmail){
	swal({
		title: "Are you sure?",
		text: partnerEmail+" is going to Activated As Partner Account.",
		type: "warning",
		showCancelButton: true,
		confirmButtonColor: '#00a65a',
		confirmButtonText: 'Click, To Confirm!',
		cancelButtonText: "No, Cancel!",
		closeOnConfirm: false,
		closeOnCancel: false
	},
	function(isConfirm){
    if (isConfirm){
     
    	 $.ajax({
				url : 'deletePartnerPaymentInfo',
				type: "POST",
				data : {paymentId: paymentId},
				success:function(response) 
				{
				if(response.status == "Success")
				 {
					swal("Activated", paymentId+" has been successfully activated.", "success");
					setTimeout("location.reload(true);",1500);
				 }
					else
						{
					      		swal("Try Again", "No User Found.  Kindly refresh Page", "error");
					      		}
				        },
				        error: function(jqXHR, textStatus, errorThrown) 
				        {
				        	swal("Try Again", "Server Exception. Kindly do it again.", "error");
				    		
				        }
				    });
      
    } else {
    	swal("Cancelled", "Activation Process Cancelled.", "error");
    }
	});
	
}
	