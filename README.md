<code>
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
</code>
