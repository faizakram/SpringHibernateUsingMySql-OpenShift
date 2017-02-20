<h1>Author<a href="http://faizakram.com" target="_blank"><br>Md Faiz Akram</a></h1>
<h2>Mobile: - 9990858653</h2>
<img src="http://faizakram.com/github/SpringHibernateUsingMySql/login.png"/ style="width:400px;">
<img src="http://faizakram.com/github/SpringHibernateUsingMySql/SignUp.png"/ style="width:400px;">
<img src="http://faizakram.com/github/SpringHibernateUsingMySql/Dashboard.png"/ style="width:400px;">
<img src="http://faizakram.com/github/SpringHibernateUsingMySql/Profile.png"/ style="width:400px;">

<h2>Projcect Features Backed</h2>
   <ul>
	<li> Spring MVC</li>
	<li>Spring Security</li>
	<li>Hibernate</li>
	<li>Maven</li>
	<li>JSP</li>
	<li>Mailing API</li>
	<li>File Uploading</li>
	<li>File Compressor</li>
	<li>Ajax Call with File Uploading</li>
	<li>JSTL</li>
	<li>JSP</li>
	<li>HTML</li>
	<li>CSS</li>
	<li>jQuery</li>
	<li>JS</li>
	<li>BootStrap</li>
	<li>Sweet Alert JS</li>
	<li>Basic Dashboard</li>
	<li>Basic Profile</li>
   </ul>



<h3>Connection Pulling using hibernate c3p0</h3>
<!-- Local Data base Configuration and Manage Connection Pulling Concept Block -->
	<beans:bean id="myDataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource"
		destroy-method="close">
		<beans:property name="driverClass" value="com.mysql.jdbc.Driver" />
		<beans:property name="jdbcUrl"
			value="jdbc:mysql://localhost:3306/accer?autoReconnect=true" />
		<beans:property name="user" value="root" />
		<beans:property name="password" value="root"/>
		<beans:property name="initialPoolSize" value="5"/>
		<beans:property name="minPoolSize" value="5" />
		<beans:property name="maxPoolSize" value="100" />
		<beans:property name="acquireIncrement" value="5" />
		<beans:property name="acquireRetryDelay" value="1000" />
		<beans:property name="debugUnreturnedConnectionStackTraces"
			value="true"/>
		<beans:property name="maxIdleTime" value="300"/>
		<beans:property name="unreturnedConnectionTimeout"
			value="300000" />
		<beans:property name="checkoutTimeout" value="3000000" />
		<beans:property name="idleConnectionTestPeriod" value="600000" />
	</beans:bean>

<h3>Mailing API Configuration</h3>
	<beans:bean id="MailingAPI" class="com.sun.jersey.api.client.filter.HTTPBasicAuthFilter">
		<beans:constructor-arg value="api" type="java.lang.String"/>
		<beans:constructor-arg value="Put Your Key Here" type="java.lang.String"/>
	</beans:bean>
	
<h3>ViewResolver Configuration</h3>
	<beans:bean id="viewResolver"
		class="org.springframework.web.servlet.view.UrlBasedViewResolver">
		<beans:property name="prefix" value="/website/" />
		<beans:property name="suffix" value=".jsp" />
		<beans:property name="viewClass"
			value="org.springframework.web.servlet.view.JstlView" />
	</beans:bean>
	
<h3>Genrate you own Password crypto.bcrypt.BCryptPasswordEncoder</h3>
``` 
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
public class PasswordEncoderGenerator {
	
	public static void main(String[] args) {

		 int i = 0;
		 while (i < 10) {
		  String password = "1234";
		  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		  String hashedPassword = passwordEncoder.encode(password);

		  System.out.println(hashedPassword);
		  i++;
		 }

		  }
}
```	
<h3>Project Table Schema View</h3>


<html>
<head>
<title>Schema for database</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">

</head>
<body bgcolor='#ffffff' topmargin="0">
<table width="100%" border="0" cellspacing="0" cellpadding="5">
<tr>
<td class="toptext"><p align="center">accer</td>
</tr>
</table>
<a name="header">&nbsp</a><ul>
	<li><a href="#roles"><p class="normal">roles</a></li>
	<li><a href="#user_profile"><p class="normal">user_profile</a></li>
	<li><a href="#user_role"><p class="normal">user_role</a></li>
	<li><a href="#user_verfication"><p class="normal">user_verfication</a></li>
	<li><a href="#users"><p class="normal">users</a></li>
</ul>
<br class=page>
<p><a name='roles'>&nbsp</a>
<table width="100%" border="0" cellspacing="0" cellpadding="3">
<tr>
	<td class="headtext" width="30%" align="left" valign="top">roles</td>
	<td>&nbsp</td>
<tr>
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="3">
<tr>
	<td class="fieldheader" width="100%" align="left" valign="top">Fields</td>
</tr>
</table>
<table width="100%" cellspacing="0" cellapdding="2" border="1">
<tr>
	<td align="center" valign="top" class="fieldcolumn">Field</td>
	<td align="center" valign="top" class="fieldcolumn">Type</td>
	<td align="center" valign="top" class="fieldcolumn">Collation</td>
	<td align="center" valign="top" class="fieldcolumn">Null</td>
	<td align="center" valign="top" class="fieldcolumn">Key</td>
	<td align="center" valign="top" class="fieldcolumn">Default</td>
	<td align="center" valign="top" class="fieldcolumn">Extra</td>
	<td align="center" valign="top" class="fieldcolumn">Privileges</td>
	<td align="center" valign="top" class="fieldcolumn">Comment</td>
</tr>
<tr>
	<td align="left" valign="top"><p class="normal">Id</td>
	<td align="left" valign="top"><p class="normal">int(11)</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">NO</td>
	<td align="left" valign="top"><p class="normal">PRI</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">auto_increment</td>
	<td align="left" valign="top"><p class="normal">select,insert,update,references</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
</tr>
<tr>
	<td align="left" valign="top"><p class="normal">Role</td>
	<td align="left" valign="top"><p class="normal">varchar(20)</td>
	<td align="left" valign="top"><p class="normal">latin1_swedish_ci</td>
	<td align="left" valign="top"><p class="normal">NO</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">select,insert,update,references</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
</tr>
</table>


<table width="100%" border="0" cellspacing="0" cellpadding="3">
<tr>
	<td class="fieldheader" width="100%" align="left" valign="top">Indexes</td>
</tr>
</table>
<table width="100%" cellspacing="0" cellapdding="2" border="1">
<tr>
	<td align="left" valign="top" class="fieldcolumn">Table</td>
	<td align="left" valign="top" class="fieldcolumn">Non<br>unique</td>
	<td align="left" valign="top" class="fieldcolumn">Key<br>name</td>
	<td align="left" valign="top" class="fieldcolumn">Seq<br>in<br>index</td>
	<td align="left" valign="top" class="fieldcolumn">Column<br>name</td>
	<td align="left" valign="top" class="fieldcolumn">Collation</td>
	<td align="left" valign="top" class="fieldcolumn">Cardinality</td>
	<td align="left" valign="top" class="fieldcolumn">Sub<br>part</td>
	<td align="left" valign="top" class="fieldcolumn">Packed</td>
	<td align="left" valign="top" class="fieldcolumn">Null</td>
	<td align="left" valign="top" class="fieldcolumn">Index<br>type</td>
	<td align="left" valign="top" class="fieldcolumn">Comment</td>
	<td align="left" valign="top" class="fieldcolumn">Index<br>comment</td>
</tr>
<tr>
	<td align="left" valign="top"><p class="normal">roles</td>
	<td align="left" valign="top"><p class="normal">0</td>
	<td align="left" valign="top"><p class="normal">PRIMARY</td>
	<td align="left" valign="top"><p class="normal">1</td>
	<td align="left" valign="top"><p class="normal">Id</td>
	<td align="left" valign="top"><p class="normal">A</td>
	<td align="left" valign="top"><p class="normal">4</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">BTREE</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
</tr>
<tr>
	<td align="left" valign="top"><p class="normal">roles</td>
	<td align="left" valign="top"><p class="normal">0</td>
	<td align="left" valign="top"><p class="normal">Role_Id</td>
	<td align="left" valign="top"><p class="normal">1</td>
	<td align="left" valign="top"><p class="normal">Id</td>
	<td align="left" valign="top"><p class="normal">A</td>
	<td align="left" valign="top"><p class="normal">4</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">BTREE</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
</tr>
</table>


<a href="#header"><p class="normal">Back</a><br class=page>
<p><a name='user_profile'>&nbsp</a>
<table width="100%" border="0" cellspacing="0" cellpadding="3">
<tr>
	<td class="headtext" width="30%" align="left" valign="top">user_profile</td>
	<td>&nbsp</td>
<tr>
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="3">
<tr>
	<td class="fieldheader" width="100%" align="left" valign="top">Fields</td>
</tr>
</table>
<table width="100%" cellspacing="0" cellapdding="2" border="1">
<tr>
	<td align="center" valign="top" class="fieldcolumn">Field</td>
	<td align="center" valign="top" class="fieldcolumn">Type</td>
	<td align="center" valign="top" class="fieldcolumn">Collation</td>
	<td align="center" valign="top" class="fieldcolumn">Null</td>
	<td align="center" valign="top" class="fieldcolumn">Key</td>
	<td align="center" valign="top" class="fieldcolumn">Default</td>
	<td align="center" valign="top" class="fieldcolumn">Extra</td>
	<td align="center" valign="top" class="fieldcolumn">Privileges</td>
	<td align="center" valign="top" class="fieldcolumn">Comment</td>
</tr>
<tr>
	<td align="left" valign="top"><p class="normal">User_Email_Id</td>
	<td align="left" valign="top"><p class="normal">varchar(60)</td>
	<td align="left" valign="top"><p class="normal">latin1_swedish_ci</td>
	<td align="left" valign="top"><p class="normal">NO</td>
	<td align="left" valign="top"><p class="normal">PRI</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">select,insert,update,references</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
</tr>
<tr>
	<td align="left" valign="top"><p class="normal">Name</td>
	<td align="left" valign="top"><p class="normal">varchar(60)</td>
	<td align="left" valign="top"><p class="normal">latin1_swedish_ci</td>
	<td align="left" valign="top"><p class="normal">NO</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">select,insert,update,references</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
</tr>
<tr>
	<td align="left" valign="top"><p class="normal">DOB</td>
	<td align="left" valign="top"><p class="normal">varchar(20)</td>
	<td align="left" valign="top"><p class="normal">latin1_swedish_ci</td>
	<td align="left" valign="top"><p class="normal">YES</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">select,insert,update,references</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
</tr>
<tr>
	<td align="left" valign="top"><p class="normal">DOJ</td>
	<td align="left" valign="top"><p class="normal">varchar(60)</td>
	<td align="left" valign="top"><p class="normal">latin1_swedish_ci</td>
	<td align="left" valign="top"><p class="normal">NO</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">select,insert,update,references</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
</tr>
<tr>
	<td align="left" valign="top"><p class="normal">MobileNo</td>
	<td align="left" valign="top"><p class="normal">varchar(10)</td>
	<td align="left" valign="top"><p class="normal">latin1_swedish_ci</td>
	<td align="left" valign="top"><p class="normal">YES</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">select,insert,update,references</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
</tr>
<tr>
	<td align="left" valign="top"><p class="normal">Skype</td>
	<td align="left" valign="top"><p class="normal">text</td>
	<td align="left" valign="top"><p class="normal">latin1_swedish_ci</td>
	<td align="left" valign="top"><p class="normal">YES</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">select,insert,update,references</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
</tr>
<tr>
	<td align="left" valign="top"><p class="normal">LinkedIn</td>
	<td align="left" valign="top"><p class="normal">text</td>
	<td align="left" valign="top"><p class="normal">latin1_swedish_ci</td>
	<td align="left" valign="top"><p class="normal">YES</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">select,insert,update,references</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
</tr>
<tr>
	<td align="left" valign="top"><p class="normal">Facebook</td>
	<td align="left" valign="top"><p class="normal">text</td>
	<td align="left" valign="top"><p class="normal">latin1_swedish_ci</td>
	<td align="left" valign="top"><p class="normal">YES</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">select,insert,update,references</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
</tr>
<tr>
	<td align="left" valign="top"><p class="normal">Twitter</td>
	<td align="left" valign="top"><p class="normal">text</td>
	<td align="left" valign="top"><p class="normal">latin1_swedish_ci</td>
	<td align="left" valign="top"><p class="normal">YES</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">select,insert,update,references</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
</tr>
<tr>
	<td align="left" valign="top"><p class="normal">GooglePlus</td>
	<td align="left" valign="top"><p class="normal">text</td>
	<td align="left" valign="top"><p class="normal">latin1_swedish_ci</td>
	<td align="left" valign="top"><p class="normal">YES</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">select,insert,update,references</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
</tr>
<tr>
	<td align="left" valign="top"><p class="normal">Website</td>
	<td align="left" valign="top"><p class="normal">text</td>
	<td align="left" valign="top"><p class="normal">latin1_swedish_ci</td>
	<td align="left" valign="top"><p class="normal">YES</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">select,insert,update,references</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
</tr>
<tr>
	<td align="left" valign="top"><p class="normal">Address</td>
	<td align="left" valign="top"><p class="normal">text</td>
	<td align="left" valign="top"><p class="normal">latin1_swedish_ci</td>
	<td align="left" valign="top"><p class="normal">YES</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">select,insert,update,references</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
</tr>
<tr>
	<td align="left" valign="top"><p class="normal">ProfilePic</td>
	<td align="left" valign="top"><p class="normal">text</td>
	<td align="left" valign="top"><p class="normal">latin1_swedish_ci</td>
	<td align="left" valign="top"><p class="normal">YES</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">select,insert,update,references</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
</tr>
</table>


<table width="100%" border="0" cellspacing="0" cellpadding="3">
<tr>
	<td class="fieldheader" width="100%" align="left" valign="top">Indexes</td>
</tr>
</table>
<table width="100%" cellspacing="0" cellapdding="2" border="1">
<tr>
	<td align="left" valign="top" class="fieldcolumn">Table</td>
	<td align="left" valign="top" class="fieldcolumn">Non<br>unique</td>
	<td align="left" valign="top" class="fieldcolumn">Key<br>name</td>
	<td align="left" valign="top" class="fieldcolumn">Seq<br>in<br>index</td>
	<td align="left" valign="top" class="fieldcolumn">Column<br>name</td>
	<td align="left" valign="top" class="fieldcolumn">Collation</td>
	<td align="left" valign="top" class="fieldcolumn">Cardinality</td>
	<td align="left" valign="top" class="fieldcolumn">Sub<br>part</td>
	<td align="left" valign="top" class="fieldcolumn">Packed</td>
	<td align="left" valign="top" class="fieldcolumn">Null</td>
	<td align="left" valign="top" class="fieldcolumn">Index<br>type</td>
	<td align="left" valign="top" class="fieldcolumn">Comment</td>
	<td align="left" valign="top" class="fieldcolumn">Index<br>comment</td>
</tr>
<tr>
	<td align="left" valign="top"><p class="normal">user_profile</td>
	<td align="left" valign="top"><p class="normal">0</td>
	<td align="left" valign="top"><p class="normal">PRIMARY</td>
	<td align="left" valign="top"><p class="normal">1</td>
	<td align="left" valign="top"><p class="normal">User_Email_Id</td>
	<td align="left" valign="top"><p class="normal">A</td>
	<td align="left" valign="top"><p class="normal">4</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">BTREE</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
</tr>
<tr>
	<td align="left" valign="top"><p class="normal">user_profile</td>
	<td align="left" valign="top"><p class="normal">1</td>
	<td align="left" valign="top"><p class="normal">User_Email_Id</td>
	<td align="left" valign="top"><p class="normal">1</td>
	<td align="left" valign="top"><p class="normal">User_Email_Id</td>
	<td align="left" valign="top"><p class="normal">A</td>
	<td align="left" valign="top"><p class="normal">4</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">BTREE</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
</tr>
<tr>
	<td align="left" valign="top"><p class="normal">user_profile</td>
	<td align="left" valign="top"><p class="normal">1</td>
	<td align="left" valign="top"><p class="normal">ix_some_id</td>
	<td align="left" valign="top"><p class="normal">1</td>
	<td align="left" valign="top"><p class="normal">User_Email_Id</td>
	<td align="left" valign="top"><p class="normal">A</td>
	<td align="left" valign="top"><p class="normal">4</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">BTREE</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
</tr>
</table>


<a href="#header"><p class="normal">Back</a><br class=page>
<p><a name='user_role'>&nbsp</a>
<table width="100%" border="0" cellspacing="0" cellpadding="3">
<tr>
	<td class="headtext" width="30%" align="left" valign="top">user_role</td>
	<td>&nbsp</td>
<tr>
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="3">
<tr>
	<td class="fieldheader" width="100%" align="left" valign="top">Fields</td>
</tr>
</table>
<table width="100%" cellspacing="0" cellapdding="2" border="1">
<tr>
	<td align="center" valign="top" class="fieldcolumn">Field</td>
	<td align="center" valign="top" class="fieldcolumn">Type</td>
	<td align="center" valign="top" class="fieldcolumn">Collation</td>
	<td align="center" valign="top" class="fieldcolumn">Null</td>
	<td align="center" valign="top" class="fieldcolumn">Key</td>
	<td align="center" valign="top" class="fieldcolumn">Default</td>
	<td align="center" valign="top" class="fieldcolumn">Extra</td>
	<td align="center" valign="top" class="fieldcolumn">Privileges</td>
	<td align="center" valign="top" class="fieldcolumn">Comment</td>
</tr>
<tr>
	<td align="left" valign="top"><p class="normal">User_Id</td>
	<td align="left" valign="top"><p class="normal">int(11)</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">NO</td>
	<td align="left" valign="top"><p class="normal">MUL</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">select,insert,update,references</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
</tr>
<tr>
	<td align="left" valign="top"><p class="normal">Role_Id</td>
	<td align="left" valign="top"><p class="normal">int(11)</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">NO</td>
	<td align="left" valign="top"><p class="normal">MUL</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">select,insert,update,references</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
</tr>
</table>


<table width="100%" border="0" cellspacing="0" cellpadding="3">
<tr>
	<td class="fieldheader" width="100%" align="left" valign="top">Indexes</td>
</tr>
</table>
<table width="100%" cellspacing="0" cellapdding="2" border="1">
<tr>
	<td align="left" valign="top" class="fieldcolumn">Table</td>
	<td align="left" valign="top" class="fieldcolumn">Non<br>unique</td>
	<td align="left" valign="top" class="fieldcolumn">Key<br>name</td>
	<td align="left" valign="top" class="fieldcolumn">Seq<br>in<br>index</td>
	<td align="left" valign="top" class="fieldcolumn">Column<br>name</td>
	<td align="left" valign="top" class="fieldcolumn">Collation</td>
	<td align="left" valign="top" class="fieldcolumn">Cardinality</td>
	<td align="left" valign="top" class="fieldcolumn">Sub<br>part</td>
	<td align="left" valign="top" class="fieldcolumn">Packed</td>
	<td align="left" valign="top" class="fieldcolumn">Null</td>
	<td align="left" valign="top" class="fieldcolumn">Index<br>type</td>
	<td align="left" valign="top" class="fieldcolumn">Comment</td>
	<td align="left" valign="top" class="fieldcolumn">Index<br>comment</td>
</tr>
<tr>
	<td align="left" valign="top"><p class="normal">user_role</td>
	<td align="left" valign="top"><p class="normal">1</td>
	<td align="left" valign="top"><p class="normal">FK143BF46A7214966</td>
	<td align="left" valign="top"><p class="normal">1</td>
	<td align="left" valign="top"><p class="normal">Role_Id</td>
	<td align="left" valign="top"><p class="normal">A</td>
	<td align="left" valign="top"><p class="normal">4</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">BTREE</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
</tr>
<tr>
	<td align="left" valign="top"><p class="normal">user_role</td>
	<td align="left" valign="top"><p class="normal">1</td>
	<td align="left" valign="top"><p class="normal">FK143BF46AAC4C0D46</td>
	<td align="left" valign="top"><p class="normal">1</td>
	<td align="left" valign="top"><p class="normal">User_Id</td>
	<td align="left" valign="top"><p class="normal">A</td>
	<td align="left" valign="top"><p class="normal">4</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">BTREE</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
</tr>
</table>


<table width="100%" border="0" cellspacing="0" cellpadding="3">
<tr>
	<td class="fieldheader" width="100%" align="left" valign="top">Foreign Key Relationships</td>
</tr>
</table>
<table width="100%" cellspacing="0" cellapdding="2" border="1">
<tr>
	<td align="left" valign="top" class="fieldcolumn">FK Id</td>
	<td align="left" valign="top" class="fieldcolumn">Reference Table</td>
	<td align="left" valign="top" class="fieldcolumn">Source Column</td>
	<td align="left" valign="top" class="fieldcolumn">Target Column</td>
	<td align="left" valign="top" class="fieldcolumn">Extra Info</td>
</tr>
<tr>
	<td align="left" valign="top"><p class="normal">user_role_ibfk_1</td>
	<td align="left" valign="top"><p class="normal">users</td>
	<td align="left" valign="top"><p class="normal">`User_Id`</td>
	<td align="left" valign="top"><p class="normal">`Id`</td>
	<td align="left" valign="top"><p class="normal"> ON DELETE CASCADE ON UPDATE CASCADE,</td>
<tr>
<tr>
	<td align="left" valign="top"><p class="normal">user_role_ibfk_2</td>
	<td align="left" valign="top"><p class="normal">roles</td>
	<td align="left" valign="top"><p class="normal">`Role_Id`</td>
	<td align="left" valign="top"><p class="normal">`Id`</td>
	<td align="left" valign="top"><p class="normal"> ON DELETE CASCADE ON UPDATE CASCADE</td>
<tr>
</table>


<a href="#header"><p class="normal">Back</a><br class=page>
<p><a name='user_verfication'>&nbsp</a>
<table width="100%" border="0" cellspacing="0" cellpadding="3">
<tr>
	<td class="headtext" width="30%" align="left" valign="top">user_verfication</td>
	<td>&nbsp</td>
<tr>
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="3">
<tr>
	<td class="fieldheader" width="100%" align="left" valign="top">Fields</td>
</tr>
</table>
<table width="100%" cellspacing="0" cellapdding="2" border="1">
<tr>
	<td align="center" valign="top" class="fieldcolumn">Field</td>
	<td align="center" valign="top" class="fieldcolumn">Type</td>
	<td align="center" valign="top" class="fieldcolumn">Collation</td>
	<td align="center" valign="top" class="fieldcolumn">Null</td>
	<td align="center" valign="top" class="fieldcolumn">Key</td>
	<td align="center" valign="top" class="fieldcolumn">Default</td>
	<td align="center" valign="top" class="fieldcolumn">Extra</td>
	<td align="center" valign="top" class="fieldcolumn">Privileges</td>
	<td align="center" valign="top" class="fieldcolumn">Comment</td>
</tr>
<tr>
	<td align="left" valign="top"><p class="normal">Verification_Id</td>
	<td align="left" valign="top"><p class="normal">int(10)</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">NO</td>
	<td align="left" valign="top"><p class="normal">PRI</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">auto_increment</td>
	<td align="left" valign="top"><p class="normal">select,insert,update,references</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
</tr>
<tr>
	<td align="left" valign="top"><p class="normal">User_Email_Id</td>
	<td align="left" valign="top"><p class="normal">varchar(60)</td>
	<td align="left" valign="top"><p class="normal">latin1_swedish_ci</td>
	<td align="left" valign="top"><p class="normal">NO</td>
	<td align="left" valign="top"><p class="normal">MUL</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">select,insert,update,references</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
</tr>
<tr>
	<td align="left" valign="top"><p class="normal">Admin_Email_Verification</td>
	<td align="left" valign="top"><p class="normal">text</td>
	<td align="left" valign="top"><p class="normal">latin1_swedish_ci</td>
	<td align="left" valign="top"><p class="normal">YES</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">select,insert,update,references</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
</tr>
<tr>
	<td align="left" valign="top"><p class="normal">User_Email_Verification</td>
	<td align="left" valign="top"><p class="normal">text</td>
	<td align="left" valign="top"><p class="normal">latin1_swedish_ci</td>
	<td align="left" valign="top"><p class="normal">YES</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">select,insert,update,references</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
</tr>
<tr>
	<td align="left" valign="top"><p class="normal">Mobile_Verification</td>
	<td align="left" valign="top"><p class="normal">varchar(10)</td>
	<td align="left" valign="top"><p class="normal">latin1_swedish_ci</td>
	<td align="left" valign="top"><p class="normal">YES</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">select,insert,update,references</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
</tr>
<tr>
	<td align="left" valign="top"><p class="normal">Forgot_Password</td>
	<td align="left" valign="top"><p class="normal">text</td>
	<td align="left" valign="top"><p class="normal">latin1_swedish_ci</td>
	<td align="left" valign="top"><p class="normal">YES</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">select,insert,update,references</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
</tr>
<tr>
	<td align="left" valign="top"><p class="normal">Account_Status</td>
	<td align="left" valign="top"><p class="normal">varchar(20)</td>
	<td align="left" valign="top"><p class="normal">latin1_swedish_ci</td>
	<td align="left" valign="top"><p class="normal">YES</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">select,insert,update,references</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
</tr>
</table>


<table width="100%" border="0" cellspacing="0" cellpadding="3">
<tr>
	<td class="fieldheader" width="100%" align="left" valign="top">Indexes</td>
</tr>
</table>
<table width="100%" cellspacing="0" cellapdding="2" border="1">
<tr>
	<td align="left" valign="top" class="fieldcolumn">Table</td>
	<td align="left" valign="top" class="fieldcolumn">Non<br>unique</td>
	<td align="left" valign="top" class="fieldcolumn">Key<br>name</td>
	<td align="left" valign="top" class="fieldcolumn">Seq<br>in<br>index</td>
	<td align="left" valign="top" class="fieldcolumn">Column<br>name</td>
	<td align="left" valign="top" class="fieldcolumn">Collation</td>
	<td align="left" valign="top" class="fieldcolumn">Cardinality</td>
	<td align="left" valign="top" class="fieldcolumn">Sub<br>part</td>
	<td align="left" valign="top" class="fieldcolumn">Packed</td>
	<td align="left" valign="top" class="fieldcolumn">Null</td>
	<td align="left" valign="top" class="fieldcolumn">Index<br>type</td>
	<td align="left" valign="top" class="fieldcolumn">Comment</td>
	<td align="left" valign="top" class="fieldcolumn">Index<br>comment</td>
</tr>
<tr>
	<td align="left" valign="top"><p class="normal">user_verfication</td>
	<td align="left" valign="top"><p class="normal">0</td>
	<td align="left" valign="top"><p class="normal">PRIMARY</td>
	<td align="left" valign="top"><p class="normal">1</td>
	<td align="left" valign="top"><p class="normal">Verification_Id</td>
	<td align="left" valign="top"><p class="normal">A</td>
	<td align="left" valign="top"><p class="normal">3</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">BTREE</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
</tr>
<tr>
	<td align="left" valign="top"><p class="normal">user_verfication</td>
	<td align="left" valign="top"><p class="normal">1</td>
	<td align="left" valign="top"><p class="normal">User_Email_Id</td>
	<td align="left" valign="top"><p class="normal">1</td>
	<td align="left" valign="top"><p class="normal">User_Email_Id</td>
	<td align="left" valign="top"><p class="normal">A</td>
	<td align="left" valign="top"><p class="normal">3</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">BTREE</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
</tr>
</table>


<table width="100%" border="0" cellspacing="0" cellpadding="3">
<tr>
	<td class="fieldheader" width="100%" align="left" valign="top">Foreign Key Relationships</td>
</tr>
</table>
<table width="100%" cellspacing="0" cellapdding="2" border="1">
<tr>
	<td align="left" valign="top" class="fieldcolumn">FK Id</td>
	<td align="left" valign="top" class="fieldcolumn">Reference Table</td>
	<td align="left" valign="top" class="fieldcolumn">Source Column</td>
	<td align="left" valign="top" class="fieldcolumn">Target Column</td>
	<td align="left" valign="top" class="fieldcolumn">Extra Info</td>
</tr>
<tr>
	<td align="left" valign="top"><p class="normal">user_verfication_ibfk_1</td>
	<td align="left" valign="top"><p class="normal">user_profile</td>
	<td align="left" valign="top"><p class="normal">`User_Email_Id`</td>
	<td align="left" valign="top"><p class="normal">`User_Email_Id`</td>
	<td align="left" valign="top"><p class="normal"> ON DELETE CASCADE ON UPDATE CASCADE</td>
<tr>
</table>


<a href="#header"><p class="normal">Back</a><br class=page>
<p><a name='users'>&nbsp</a>
<table width="100%" border="0" cellspacing="0" cellpadding="3">
<tr>
	<td class="headtext" width="30%" align="left" valign="top">users</td>
	<td>&nbsp</td>
<tr>
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="3">
<tr>
	<td class="fieldheader" width="100%" align="left" valign="top">Fields</td>
</tr>
</table>
<table width="100%" cellspacing="0" cellapdding="2" border="1">
<tr>
	<td align="center" valign="top" class="fieldcolumn">Field</td>
	<td align="center" valign="top" class="fieldcolumn">Type</td>
	<td align="center" valign="top" class="fieldcolumn">Collation</td>
	<td align="center" valign="top" class="fieldcolumn">Null</td>
	<td align="center" valign="top" class="fieldcolumn">Key</td>
	<td align="center" valign="top" class="fieldcolumn">Default</td>
	<td align="center" valign="top" class="fieldcolumn">Extra</td>
	<td align="center" valign="top" class="fieldcolumn">Privileges</td>
	<td align="center" valign="top" class="fieldcolumn">Comment</td>
</tr>
<tr>
	<td align="left" valign="top"><p class="normal">Id</td>
	<td align="left" valign="top"><p class="normal">int(11)</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">NO</td>
	<td align="left" valign="top"><p class="normal">PRI</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">auto_increment</td>
	<td align="left" valign="top"><p class="normal">select,insert,update,references</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
</tr>
<tr>
	<td align="left" valign="top"><p class="normal">User_Email_Id</td>
	<td align="left" valign="top"><p class="normal">varchar(60)</td>
	<td align="left" valign="top"><p class="normal">latin1_swedish_ci</td>
	<td align="left" valign="top"><p class="normal">NO</td>
	<td align="left" valign="top"><p class="normal">UNI</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">select,insert,update,references</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
</tr>
<tr>
	<td align="left" valign="top"><p class="normal">Password</td>
	<td align="left" valign="top"><p class="normal">varchar(60)</td>
	<td align="left" valign="top"><p class="normal">latin1_swedish_ci</td>
	<td align="left" valign="top"><p class="normal">NO</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">select,insert,update,references</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
</tr>
<tr>
	<td align="left" valign="top"><p class="normal">Enable</td>
	<td align="left" valign="top"><p class="normal">tinyint(1)</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">NO</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">select,insert,update,references</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
</tr>
</table>


<table width="100%" border="0" cellspacing="0" cellpadding="3">
<tr>
	<td class="fieldheader" width="100%" align="left" valign="top">Indexes</td>
</tr>
</table>
<table width="100%" cellspacing="0" cellapdding="2" border="1">
<tr>
	<td align="left" valign="top" class="fieldcolumn">Table</td>
	<td align="left" valign="top" class="fieldcolumn">Non<br>unique</td>
	<td align="left" valign="top" class="fieldcolumn">Key<br>name</td>
	<td align="left" valign="top" class="fieldcolumn">Seq<br>in<br>index</td>
	<td align="left" valign="top" class="fieldcolumn">Column<br>name</td>
	<td align="left" valign="top" class="fieldcolumn">Collation</td>
	<td align="left" valign="top" class="fieldcolumn">Cardinality</td>
	<td align="left" valign="top" class="fieldcolumn">Sub<br>part</td>
	<td align="left" valign="top" class="fieldcolumn">Packed</td>
	<td align="left" valign="top" class="fieldcolumn">Null</td>
	<td align="left" valign="top" class="fieldcolumn">Index<br>type</td>
	<td align="left" valign="top" class="fieldcolumn">Comment</td>
	<td align="left" valign="top" class="fieldcolumn">Index<br>comment</td>
</tr>
<tr>
	<td align="left" valign="top"><p class="normal">users</td>
	<td align="left" valign="top"><p class="normal">0</td>
	<td align="left" valign="top"><p class="normal">PRIMARY</td>
	<td align="left" valign="top"><p class="normal">1</td>
	<td align="left" valign="top"><p class="normal">Id</td>
	<td align="left" valign="top"><p class="normal">A</td>
	<td align="left" valign="top"><p class="normal">4</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">BTREE</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
</tr>
<tr>
	<td align="left" valign="top"><p class="normal">users</td>
	<td align="left" valign="top"><p class="normal">0</td>
	<td align="left" valign="top"><p class="normal">User_Id</td>
	<td align="left" valign="top"><p class="normal">1</td>
	<td align="left" valign="top"><p class="normal">Id</td>
	<td align="left" valign="top"><p class="normal">A</td>
	<td align="left" valign="top"><p class="normal">4</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">BTREE</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
</tr>
<tr>
	<td align="left" valign="top"><p class="normal">users</td>
	<td align="left" valign="top"><p class="normal">0</td>
	<td align="left" valign="top"><p class="normal">Email_Id</td>
	<td align="left" valign="top"><p class="normal">1</td>
	<td align="left" valign="top"><p class="normal">User_Email_Id</td>
	<td align="left" valign="top"><p class="normal">A</td>
	<td align="left" valign="top"><p class="normal">4</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">(NULL)</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">BTREE</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
	<td align="left" valign="top"><p class="normal">&nbsp;</td>
</tr>
</table>


<table width="100%" border="0" cellspacing="0" cellpadding="3">
<tr>
	<td class="fieldheader" width="100%" align="left" valign="top">Foreign Key Relationships</td>
</tr>
</table>
<table width="100%" cellspacing="0" cellapdding="2" border="1">
<tr>
	<td align="left" valign="top" class="fieldcolumn">FK Id</td>
	<td align="left" valign="top" class="fieldcolumn">Reference Table</td>
	<td align="left" valign="top" class="fieldcolumn">Source Column</td>
	<td align="left" valign="top" class="fieldcolumn">Target Column</td>
	<td align="left" valign="top" class="fieldcolumn">Extra Info</td>
</tr>
<tr>
	<td align="left" valign="top"><p class="normal">users_ibfk_1</td>
	<td align="left" valign="top"><p class="normal">user_profile</td>
	<td align="left" valign="top"><p class="normal">`User_Email_Id`</td>
	<td align="left" valign="top"><p class="normal">`User_Email_Id`</td>
	<td align="left" valign="top"><p class="normal"> ON DELETE CASCADE ON UPDATE CASCADE</td>
<tr>
</table>


<a href="#header"><p class="normal">Back</a>
<h1 width="100%"></body>
</html>


