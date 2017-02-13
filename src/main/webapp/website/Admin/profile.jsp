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
<meta charset="UTF-8">
<title>Cybotech Campus | Profile</title>
<!--=========== BEGIN HEADER SECTION ================-->
<%@ include file="file/css.jsp"%>
<!--=========== END HEADER SECTION ================-->
<script type="text/javascript">
	$(document).ready(
			function() {
				$("#UploadProfileDetials").submit(
						function() {
							var formData = new FormData($(this)[0]);
							var formURL = $(this).attr("action");

							$.ajax({
								url : formURL,
								type : 'POST',
								data : formData,
								async : false,
								success : function(data) {
									if (data == "Success")
										swal("Profile Photo Changed !",
												"Successfully Updated",
												"success");
									else
										swal("Try Again!", data, "error");

								},
								cache : false,
								contentType : false,
								processData : false
							});
							setTimeout("location.reload(true);", 1500);
							return false;
						});
			});
</script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<!--=========== BEGIN HEADER SECTION ================-->
		<%@ include file="header/index.jsp"%>
		<!--=========== END HEADER SECTION ================-->
		<!-- Left side column. contains the logo and sidebar -->
		<!--=========== BEGIN HEADER SECTION ================-->
		<%@ include file="aside/index.jsp"%>
		<!--=========== END HEADER SECTION ================-->

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>User Profile</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li><a href="#">Examples</a></li>
					<li class="active">User profile</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">

				<div class="row">
					<div class="col-md-3">

						<!-- Profile Image -->
						<div class="box box-primary">
							<div class="box-body box-profile">
								<c:choose>
									<c:when test="${empty UserProfile.profilePic}">
										<img src="resources/dashboard/dist/img/user3-128x128.jpg"
											class="profile-user-img img-responsive img-circle"
											alt="User Image">
									</c:when>
									<c:otherwise>
										<img src="${UserProfile.profilePic}"
											class="profile-user-img img-responsive img-circle"
											alt="User Image">
									</c:otherwise>
								</c:choose>
								<h3 class="profile-username text-center">${UserProfile.name}
									/ ${role}</h3>
								<p class="text-muted text-center">${UserProfile.doj}</p>

								<ul class="list-group list-group-unbordered">
									<li class="list-group-item"><b><i class="fa fa-user"></i>
											Admin</b> <a class="pull-right">1,322</a></li>
									<li class="list-group-item"><b> <i class="fa fa-users"></i>
											Partner
									</b> <a class="pull-right">543</a></li>
									<li class="list-group-item"><b> <i class="fa fa-users"></i>
											Instructor
									</b> <a class="pull-right">543</a></li>
									<li class="list-group-item"><b><i class="fa fa-users"></i>
											Student</b> <a class="pull-right">543</a></li>
								</ul>

								<a href="#" class="btn btn-primary btn-block"><b>Follow</b></a>
							</div>
							<!-- /.box-body -->
						</div>
						<!-- /.box -->


					</div>
					<!-- /.col -->
					<div class="col-md-9">
						<div class="nav-tabs-custom">
							<ul class="nav nav-tabs">
								<li class="active"><a href="#Profile" data-toggle="tab">Profile</a></li>
								<li><a href="#Setting" data-toggle="tab">Settings</a></li>
							</ul>
							<div class="tab-content">
								<div class="active tab-pane" id="Profile">
									<h3 class="text-center">Update User Profile</h3>
									<br />
									<form class="form-horizontal" id="UploadProfileDetials"
										action="UploadProfileDetials" method="post"
										enctype="multipart/form-data">
										<div class="form-group">
											<label for="inputEmail" class="col-sm-2 control-label">Name
											</label>
											<div class="col-sm-10">
												<div class="input-group">
													<div class="input-group-addon">
														<i class="fa fa-user-circle-o" aria-hidden="true"></i>
													</div>
													<input type="text" autocomplete="off" name="userName"
														value="${UserProfile.name}" class="form-control"
														placeholder="Enter User Name">
												</div>
											</div>
										</div>
										<div class="form-group">
											<label for="inputEmail" class="col-sm-2 control-label">Name
											</label>
											<div class="col-sm-10">
												<div class="input-group">
													<div class="input-group-addon">
														<i class="fa fa-user-circle-o" aria-hidden="true"></i>
													</div>
													<input type="text" autocomplete="off" name="userEmail"
														disabled="disabled" value="${UserProfile.userEmailId}"
														class="form-control" placeholder="Enter User Name">
												</div>
											</div>
										</div>
										<div class="form-group">
											<label for="inputEmail" class="col-sm-2 control-label">Mobile
												Number:</label>
											<div class="col-sm-10">
												<div class="input-group">
													<div class="input-group-addon">
														<i class="fa fa-phone"></i>
													</div>
													<input type="text" class="form-control" name="userMobile"
														value="${UserProfile.mobileNo}"
														data-inputmask='"mask": "(999) 999-9999"' data-mask>
												</div>
												<!-- /.input group -->
											</div>
										</div>
										<!--  -->
										<div class="form-group">
											<label for="inputEmail" class="col-sm-2 control-label">Facebook
												Link:</label>
											<div class="col-sm-10">
												<div class="input-group">
													<div class="input-group-addon">
														<i class="fa fa-fw fa-facebook-square"></i>
													</div>
													<input type="text" autocomplete="off" name="FacebookLink"
														class="form-control" value="${UserProfile.facebook}" placeholder="Enter Facebook Link">
												</div>
											</div>
										</div>

										<div class="form-group">
											<label for="inputEmail" class="col-sm-2 control-label">LinkedIn
												Link:</label>
											<div class="col-sm-10">
												<div class="input-group">
													<div class="input-group-addon">
														<i class="fa fa-fw fa-linkedin-square"></i>
													</div>
													<input type="text" autocomplete="off" name="LinkedInLink"
														class="form-control" value="${UserProfile.linkedIn}" placeholder="Enter LinkedIn Link">
												</div>
											</div>
										</div>

										<div class="form-group">
											<label for="inputEmail" class="col-sm-2 control-label">Google
												Plus:</label>
											<div class="col-sm-10">
												<div class="input-group">
													<div class="input-group-addon">
														<i class="fa fa-google-plus-square" aria-hidden="true"></i>
													</div>
													<input type="text" autocomplete="off" name="GoogleLink"
														class="form-control" value="${UserProfile.googlePlus}" placeholder="Enter Google Link">
												</div>
											</div>
										</div>

										<div class="form-group">
											<label for="inputEmail" class="col-sm-2 control-label">Twitter
												Link:</label>
											<div class="col-sm-10">
												<div class="input-group">
													<div class="input-group-addon">
														<i class="fa fa-fw fa-twitter-square"></i>
													</div>
													<input type="text" autocomplete="off" name="TwitterLink"
														class="form-control" value="${UserProfile.twitter}" placeholder="Enter Twitter Link">
												</div>
											</div>
										</div>
										<div class="form-group">
											<label for="inputEmail" class="col-sm-2 control-label">Skype
												Id:</label>
											<div class="col-sm-10">
												<div class="input-group">
													<div class="input-group-addon">
														<i class="fa fa-fw fa-skype"></i>
													</div>
													<input type="text" autocomplete="off" name="SkypeId"
														class="form-control" value="${UserProfile.skype}" placeholder="Enter Skype Id">
												</div>
											</div>
										</div>

										<div class="form-group">
											<label for="inputEmail" class="col-sm-2 control-label">Website
												URL:</label>
											<div class="col-sm-10">
												<div class="input-group">
													<div class="input-group-addon">
														<i class="fa fa-fw fa-globe"></i>
													</div>
													<input type="text" autocomplete="off" name="WebsiteURL"
														class="form-control" value="${UserProfile.website}" placeholder="Enter Website URL">
												</div>
											</div>
										</div>
										<div class="form-group">
											<label for="inputEmail" class="col-sm-2 control-label">Address* </label>
											<div class="col-sm-10">
												<div class="input-group">
													<div class="input-group-addon">
														<i class="fa fa-fw fa-home"></i>
													</div>
													<textarea class="form-control" required="required"
														name="Address" rows="2" 
														placeholder="Address">${UserProfile.address}</textarea>
												</div>
											</div>
										</div>
										<!--  -->
										<div class="form-group">
											<label for="inputEmail" class="col-sm-2 control-label">Upload
												Image</label>
											<div class="col-sm-10">
												<input id="file-0a file" name="file" class="file"
													name="userImage" type="file" accept="image/jpeg" multiple
													data-min-file-count="1">
											</div>
										</div>

										<div class="form-group">
											<div class="col-sm-offset-2 col-sm-10">
												<button type="submit" class="btn btn-danger"
													onclick="uploadProfileDetials();">Update</button>
											</div>
										</div>
									</form>
								</div>
								<!-- /.tab-pane -->
								<div class="tab-pane" id="Setting">
									<h3 class="text-center">Update New Password</h3>
									<br />
									<form class="form-horizontal">
										<div class="form-group">
											<label for="inputName" class="col-sm-2 control-label">New
												Password</label>
											<div class="col-sm-10">
												<input type="password" class="form-control" id="inputName"
													placeholder="New Password">
											</div>
										</div>
										<div class="form-group">
											<label for="inputName" class="col-sm-2 control-label">Repeat
												Password</label>
											<div class="col-sm-10">
												<input type="password" class="form-control" id="inputName"
													placeholder="Repeat New Password">
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-offset-2 col-sm-10">
												<button type="submit" class="btn btn-danger">Update</button>
											</div>
										</div>
									</form>
								</div>
							</div>
							<!-- /.tab-content -->
						</div>
						<!-- /.nav-tabs-custom -->
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->

			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
		<!--=========== BEGIN HEADER SECTION ================-->
		<%@ include file="footer/index.jsp"%>
		<!--=========== END HEADER SECTION ================-->
		<!-- Add the sidebar's background. This div must be placed
           immediately after the control sidebar -->
		<div class="control-sidebar-bg"></div>
	</div>
	<!-- ./wrapper -->
	<!--=========== BEGIN HEADER SECTION ================-->
	<%@ include file="file/js.jsp"%>
	<!--=========== END HEADER SECTION ================-->
</body>
</html>
