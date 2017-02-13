<%@ page import="net.tanesha.recaptcha.ReCaptcha"%>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Accer Business Solutions| Registration Page</title>
 <%@ include file="../Admin/file/css.jsp" %>
	<script type="text/javascript">
$(document).ready(function(){
	$("#registerNewAccount").submit(function(){
	    var formData = new FormData($(this)[0]);
	    var formURL = $(this).attr("action");
	    $.ajax({
	        url: formURL,
	        type: 'POST',
	        data: formData,
	        async: false,
	        success: function (response) {
		        alert(response);
	        	if(response == true)
		         {
	        		swal("Success", "Registration in Process. Just Check Your Mail", "success");	  
	        		setTimeout(function(){
	    				location.href="AdminLogin"} , 5000);
	    		}      		
		         
	        	else{
	        		swal("Already Exist", "Verify Your Mail or Contact Your Admin", "error");
		        	}
	        },
	        cache: false,
	        contentType: false,
	        processData: false
	    });

	    return false;
	});
});
</script>
</head>
<body class="hold-transition register-page">
	<div class="register-box">
		<div class="register-logo">
			<a href="index">Accer Business Solutions</a>
		</div>

		<div class="register-box-body">
			<p class="login-box-msg">Register a new membership</p>
			<form action="registerNewAccount" id="registerNewAccount"
				method="post">
				<div class="form-group has-feedback">
					<input type="text" class="form-control" name="fullName"
						id="userName" onchange="checkRegistrationForm()"
						placeholder="Full name" required="required"> <span
						class="glyphicon glyphicon-user form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="email" class="form-control" name="userEmail"
						placeholder="Email"
						required="required"> <span
						class="glyphicon glyphicon-envelope form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" class="form-control" name="password"
						id="password" placeholder="Password"
						onchange="checkRegistrationForm()" required="required"> <span
						class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div> 
				<div class="form-group">
					 
					  <%
						ReCaptcha c = ReCaptchaFactory.newReCaptcha("6Lc-tSgTAAAAAGjOhZJXRBS-RM333rxJKqrgetrz",
								"6Lc-tSgTAAAAAONIeUFk9CEAJN1gbenU-PGOEBTL", false);
						out.print(c.createRecaptchaHtml(null, null));
					  %>
				</div>
				<div class="row">
					<div class="col-xs-12">
						<button type="submit"
							class="btn btn-primary btn-block btn-flat">Register</button>
					</div>
					<!-- /.col -->
				</div>
			</form>


			<a href="AdminLogin" class="text-center">I already have a membership</a>
		</div>
		<!-- /.form-box -->
	</div>
	<!-- /.register-box -->

	<!-- jQuery 2.1.4 -->
	<script src="resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
	<!-- Bootstrap 3.3.5 -->
	<script src="resources/bootstrap/js/bootstrap.min.js"></script>
	<!-- iCheck -->
	<script src="resources/plugins/iCheck/icheck.min.js"></script>
	<script>
		$(function() {
			$('input').iCheck({
				checkboxClass : 'icheckbox_square-blue',
				radioClass : 'iradio_square-blue',
				increaseArea : '20%' // optional
			});
		});
	</script>
</body>
</html>
