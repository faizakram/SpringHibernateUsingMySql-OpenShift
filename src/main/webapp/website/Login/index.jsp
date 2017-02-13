<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Accer Business Solutions | Log in</title>
    <!--=========== BEGIN HEADER SECTION ================-->
   			 <%@ include file="../Admin/file/css.jsp" %>
	<!--=========== END HEADER SECTION ================--> 
 <style type="text/css">
    #msg { 
  color: green;
  font-size: 16px;
  font-weight: 600;
  font-style: italic;
  font-family: "Times New Roman", Times, serif;
}
#error { 
  color: red;
  font-size: 16px;
  font-weight: 600;
  font-style: italic;
  font-family: "Times New Roman", Times, serif;
}
    </style>
  </head>
  <body class="hold-transition login-page">
    <div class="login-box">
      <div class="login-logo">
         <a href="index">Acer Business Solutions
</a>						
      </div><!-- /.login-logo -->
      <div class="login-box-body">
        <p class="login-box-msg">Sign in to start your session</p>
        <form action="<c:url value='j_spring_security_check'/>" method="POST" class="form-horizontal" role="form">
          <div class="form-group has-feedback">
            <input type="email" class="form-control" name="username" id="userEmail" placeholder="Email" required="required">
            <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
          </div>
          <div class="form-group has-feedback">
            <input type="password" class="form-control" name="password" id="password"  placeholder="Password">
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
          </div>
          <div class="row">
            <input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
            <div class="col-xs-12">
            	<div id="error">${error}</div>
			    <div id="msg">${msg}</div>
              <button type="submit" id="LoginButton" class="btn btn-primary btn-block btn-flat">Login</button>
            </div><!-- /.col -->
          </div>
        </form>

        <!-- <div class="social-auth-links text-center">
          <p>- OR -</p>
          <a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-facebook"></i> Sign in using Facebook</a>
          <a href="#" class="btn btn-block btn-social btn-google btn-flat"><i class="fa fa-google-plus"></i> Sign in using Google+</a>
        </div> --><!-- /.social-auth-links -->


      </div><!-- /.login-box-body -->
    </div><!-- /.login-box -->


    <script src="resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <!-- Bootstrap 3.3.5 -->
    <script src="resources/bootstrap/js/bootstrap.min.js"></script>
    <!-- iCheck -->
    <script src="resources/plugins/iCheck/icheck.min.js"></script>
    <script>
      $(function () {
        $('input').iCheck({
          checkboxClass: 'icheckbox_square-blue',
          radioClass: 'iradio_square-blue',
          increaseArea: '20%' // optional
        });
      });
    </script>
  </body>
</html>