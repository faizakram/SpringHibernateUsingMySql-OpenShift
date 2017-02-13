<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@ taglib prefix='security'
	uri='http://www.springframework.org/security/tags'%>
<%@ page isELIgnored="false"%>
<c:url value="/j_spring_security_logout" var="logoutUrl" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Cybotech Campus| Dashboard</title>
<!-- Tell the browser to be responsive to screen width -->
<!--=========== BEGIN HEADER SECTION ================-->
   			 <%@ include file="file/css.jsp" %>
<!--=========== END HEADER SECTION ================--> 
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<!--=========== BEGIN HEADER SECTION ================-->
   			 <%@ include file="header/index.jsp" %>
    	<!--=========== END HEADER SECTION ================--> 
		<!-- Left side column. contains the logo and sidebar -->
		
	<!--=========== BEGIN HEADER SECTION ================-->
   			 <%@ include file="aside/index.jsp" %>
    <!--=========== END HEADER SECTION ================--> 
		
	<!--=========== Middle SECTION ================-->
		<%@ include file="dashboard/index.jsp" %>
	<!--=========== Middle SECTION ================-->	
		<!-- /.content-wrapper -->
		<!--=========== BEGIN HEADER SECTION ================-->
   			 <%@ include file="footer/index.jsp" %>
    	<!--=========== END HEADER SECTION ================--> 
		<!-- /.control-sidebar -->
		<!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
		<div class="control-sidebar-bg"></div>
	</div>
	<!-- ./wrapper -->
	<!--=========== BEGIN HEADER SECTION ================-->
   			 <%@ include file="file/js.jsp" %>
    <!--=========== END HEADER SECTION ================--> 
	
</body>
</html>
