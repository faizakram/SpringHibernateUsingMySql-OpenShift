<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
 
<aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
          <!-- Sidebar user panel -->
          <div class="user-panel">
            <div class="pull-left image">
             	 <c:choose>
                  		<c:when test="${empty UserProfile.profilePic}">
                  		<img src="resources/dashboard/dist/img/user3-128x128.jpg" class="img-circle" alt="User Image">
                  		</c:when>
                  		<c:otherwise>
                  		<img src="${UserProfile.profilePic}" class="img-circle" alt="User Image">
                  		</c:otherwise>
                  </c:choose>
            </div>
            <div class="pull-left info">
              <p>${UserProfile.name}</p>
              <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
          </div>
          <!-- search form -->
          <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
              <input type="text" name="q" class="form-control" placeholder="Search...">
              <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i></button>
              </span>
            </div>
          </form>
          <!-- /.search form -->
          <!-- sidebar menu: : style can be found in sidebar.less -->
          <ul class="sidebar-menu">
            <li class="header">MAIN NAVIGATION</li>
            	
            	
             <%-- <%		
                        String uri = request.getRequestURI();
             	System.out.println(uri);
					if(uri.contains("student"))
						out.print("<li class='treeview active'>");
					else
						out.print("<li class='treeview'>");
					
				%>   
              <a href="#">
                <i class="fa fa-users" aria-hidden="true"></i>
                <span>Student</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
              	<% 
              	if(uri.contains("student/Registration"))
              		out.print("<li class='active'><a href='studentRegistrationOpenForm'><i class='fa fa-circle-o'></i> Registration Form</a></li>");
              	else
              		out.print("<li><a href='studentRegistrationOpenForm'><i class='fa fa-circle-o'></i> Registration Form</a></li>");
              	%>
                <li><a href="AddResult"><i class="fa fa-circle-o"></i> Add Result</a></li>
                <li><a href="AddCertificate"><i class="fa fa-circle-o"></i> Add Certificate</a></li>
                <% 
              	if(uri.contains("student/StudentList"))
                out.print("<li class='active'><a href='StudentList'><i class='fa fa-circle-o'></i> Student List</a></li>");
                else
                out.print("<li><a href='StudentList'><i class='fa fa-circle-o'></i> Student List</a></li>");
                %>
                <li><a href="ResultList"><i class="fa fa-circle-o"></i> Result List</a></li>
                <li><a href="CertifiedStudentList"><i class="fa fa-circle-o"></i> Certified List</a></li>
              </ul>
            </li>
            <%		
					if(uri.contains("Course"))
						
						out.print("<li class='treeview active'>");
					else
						out.print("<li class='treeview'>");
					
				%> 
              <a href="#">
                <i class="fa fa-edit"></i> <span>Course</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
              <%		
					if(uri.contains("Course/AddCourse"))
						
						out.print("<li  class='active'><a href='AddCoursesForm'><i class='fa fa-circle-o'></i> Add Course</a></li>");
					else
						out.print("<li><a href='AddCoursesForm'><i class='fa fa-circle-o'></i> Add Course</a></li>");
					
				%>
                <%		
					if(uri.contains("Course/CoursesList"))
						
						out.print("<li class='active'><a href='CoursesList'><i class='fa fa-circle-o'></i> Courses List</a></li>");
					else
						out.print("<li ><a href='CoursesList'><i class='fa fa-circle-o'></i> Courses List</a></li>");
					
				%>
              </ul>
            </li>
            
            	<%		
					if(uri.contains("partner"))
						
						out.print("<li class='treeview active'>");
					else
						out.print("<li class='treeview'>");
					
				%>   
              <a href="#">
                <i class="fa fa-handshake-o" aria-hidden="true"></i>
				 <span>Partner's</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
              <%		
					if(uri.contains("partner/Registration"))
						
						out.print("<li class='active'><a href='addNewPartner'><i class='fa fa-circle-o'></i> Add Partner</a></li>");
					else
						out.print("<li><a href='addNewPartner'><i class='fa fa-circle-o'></i> Add Partner</a></li>");
					
				%>
                <%		
					if(uri.contains("partner/List"))
						
						out.print("<li class='active'><a href='findAllPartner'><i class='fa fa-circle-o'></i> Partner List</a></li>");
					else
						out.print("<li><a href='findAllPartner'><i class='fa fa-circle-o'></i> Partner List</a></li>");
					
				%>   
                
              </ul>
            </li>
            <%		
					if(uri.contains("Instructors"))
						
						out.print("<li class='treeview active'>");
					else
						out.print("<li class='treeview'>");
					
				%>   
              <a href="#">
                <i class="fa fa-user-circle" aria-hidden="true"></i>
				 <span>Instructors</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
               <%		
					if(uri.contains("Instructors/AddInstructors"))
						
						out.print("<li class='active'><a href='InstructorForm'><i class='fa fa-circle-o'></i>Add Instructor</a></li>");
					else
						out.print("<li><a href='InstructorForm'><i class='fa fa-circle-o'></i> Add Instructor</a></li>");
					
				%>
                <%		
					if(uri.contains("Instructors/ListInstructors"))
						
						out.print("<li class='active'><a href='Instructorlist'><i class='fa fa-circle-o'></i> Instructor List</a></li>");
					else
						out.print("<li><a href='Instructorlist'><i class='fa fa-circle-o'></i> Instructor List</a></li>");
					
				%>
              </ul>
            </li> --%>
            <li class="treeview">
              <a href="#">
                <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
				 <span>Blog</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li><a href="pages/forms/general.html"><i class="fa fa-circle-o"></i> Add Blog</a></li>
                 <li><a href="pages/forms/advanced.html"><i class="fa fa-circle-o"></i> Blog List</a></li>
                <li><a href="pages/forms/general.html"><i class="fa fa-circle-o"></i> Verify Blog Comment</a></li>
              </ul>
            </li>
            <li class="treeview">
              <a href="#">
                <i class="fa fa-newspaper-o" aria-hidden="true"></i>
				 <span>News</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li><a href="pages/forms/general.html"><i class="fa fa-circle-o"></i> Add News</a></li>
                 <li><a href="pages/forms/advanced.html"><i class="fa fa-circle-o"></i> News List</a></li>
              </ul>
            </li>
            <li class="treeview">
              <a href="#">
                <i class="fa fa-address-book-o" aria-hidden="true"></i>
				 <span>Contact</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                 <li><a href="pages/forms/general.html"><i class="fa fa-circle-o"></i> Add Contact</a></li>
                 <li><a href="pages/forms/advanced.html"><i class="fa fa-circle-o"></i> Contact List</a></li>
              </ul>
            </li>
            <li class="treeview">
              <a href="#">
                <i class="fa fa-paper-plane" aria-hidden="true"></i>
				 <span>Message</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                 <li><a href="pages/forms/general.html"><i class="fa fa-circle-o"></i> Send By SMS</a></li>
                 <li><a href="pages/forms/advanced.html"><i class="fa fa-circle-o"></i> Send By E-mail</a></li>
              </ul>
            </li>
            <li class="header">Contact Us</li>
            <li><a href="mailto:faiz.krm@gmail.com"><i class="fa fa-circle-o text-red"></i> <span>faiz.krm@gmail.com</span></a></li>
            <li><a href="tel:+91-999-085-8653"><i class="fa fa-circle-o text-red"></i> <span>+91-999-085-8653</span></a></li>
          </ul>
        </section>
        <!-- /.sidebar -->
      </aside>
</body>
</html>