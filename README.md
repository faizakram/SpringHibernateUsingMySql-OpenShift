<h1>Author<a href="http://faizakram.com" target="_blank"><br>Md Faiz Akram</a></h1>



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
	
<h3>View Resolver Configuration</h3>
	<beans:bean id="viewResolver"
		class="org.springframework.web.servlet.view.UrlBasedViewResolver">
		<beans:property name="prefix" value="/website/" />
		<beans:property name="suffix" value=".jsp" />
		<beans:property name="viewClass"
			value="org.springframework.web.servlet.view.JstlView" />
	</beans:bean>

