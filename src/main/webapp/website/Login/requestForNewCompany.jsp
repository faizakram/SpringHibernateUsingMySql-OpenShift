
<%@ page import="net.tanesha.recaptcha.ReCaptcha"%>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Support Store | Registration Page</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.5 -->
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<link rel="stylesheet" href="resources/dist/css/AdminLTE.min.css">
<link rel="stylesheet"
	href="resources/dist/css/skins/_all-skins.min.css">

<!-- File Uploading Imported File Open -->
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css"
	rel="stylesheet">

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$(".alert-danger").hide();
	$(".alert-success").hide();
	$(".alert-warning").hide();
	$("#requestForNewCompanyCaptcha").submit(function(e)
	   {
	       var postData = $(this).serializeArray();
	       var formURL = $(this).attr("action");
	        
	       $.ajax(
	       {
	           url : formURL,
	           type: "POST",
	           data : postData,
	           success:function(response)
	           {
	           if(response == "true")
	        	 {
	        	document.getElementById("requestForNewCompanyCaptcha").reset();
	        	$(".alert-success").show();
	       		  }
	           
	           else
	           {
	        	   $(".alert-warning").show();
	           }
	       },
	           error: function(jqXHR, textStatus, errorThrown) 
	           {
	        	   $(".alert-danger").show();
	           }
	       });
	       e.preventDefault();
	       e.unbind(); 
	   });
});
</script>
</head>
<body class="hold-transition register-page">
	<div class="register-box">
		<div class="register-logo">
			<i class="fa fa-fw fa-user"></i> <a href="http://faizakram.com/"
				target="_blank"><b>Faiz </b> Akram</a>
		</div>
		<div class="register-box-body">
			<p class="login-box-msg">Register A New Company Request</p>
			<form action="requestForNewCompanyCaptcha" id="requestForNewCompanyCaptcha" method="post">
				<div class="form-group has-feedback">
					<input type="text" class="form-control" name="fullName"
						id="userName"
						placeholder="Company Full name" required="required"> <span
						class="glyphicon glyphicon-user form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="email" class="form-control" name="userEmail"
						id="userEmail" placeholder="Email" required="required"> <span
						class="glyphicon glyphicon-envelope form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="url" class="form-control" name="url"
						id="password" placeholder="Enter Company Website URL" required="required"> <span
						class="glyphicon glyphicon-globe form-control-feedback"></span>
				</div>				
				<div class="form-group">
					<%
						ReCaptcha c = ReCaptchaFactory.newReCaptcha("6LfsqygTAAAAAIgMQUYC-xTkBHoPCTchHuyfSHoa",
								"6LfsqygTAAAAAGaUUQ_0G9V6wWXqX5wKsYZvBQpu", false);
						out.print(c.createRecaptchaHtml(null, null));
					%>
				</div>
				
				<div class="row">
					<div class="col-xs-12">
						<button type="submit" class="btn btn-primary btn-block btn-flat">Register</button>
					</div>
					<!-- /.col -->
				</div>
			</form>
			<a href="index" class="text-center">I already have a Company
				Account</a>
		</div>
		<div class="status">
			 <div class="alert alert-danger alert-dismissable">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                    <h4><i class="icon fa fa-ban"></i> Alert!</h4>
                    Please refresh the page. Some Technical Issues.......
       		 </div>
       		 <div class="alert alert-warning alert-dismissable">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                    <h4><i class="icon fa fa-warning"></i> Alert!</h4>
                    Captcha Not Matched. Refresh The Captcha And Re-Submit Again!
             </div>
       		 <div class="alert alert-success alert-dismissable">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                    <h4>	<i class="icon fa fa-check"></i> Alert!</h4>
                    Request Successfully Submitted....
             </div>
        </div>
		<!-- /.form-box -->
	</div>
	<!-- /.register-box -->

	<!-- jQuery 2.1.4 -->
	<script src="resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
	<!-- Bootstrap 3.3.5 -->
	<script src="resources/bootstrap/js/bootstrap.min.js"></script>
	<!-- iCheck -->
	<script src="https://www.google.com/recaptcha/api.js"></script>
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
