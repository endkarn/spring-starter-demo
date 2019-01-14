package com.example.demo.takecaredemo;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@Repository("CommonRepository")
@ComponentScan(basePackages = "com.hdw.erp.common")
public class CommonRepositoryImpl implements CommonRepository{	
	private ComboPooledDataSource cpds; 
	
	@Bean
	public ComboPooledDataSource dataSource() throws IOException, SQLException, PropertyVetoException {
		cpds = new ComboPooledDataSource();
		cpds.setDriverClass(ApplicationConstant.DRIVER_CLASS); // loads the jdbc driver
		cpds.setJdbcUrl(ApplicationConstant.JDBC_URL);
		cpds.setUser(ApplicationConstant.JDBC_USERNAME);
		cpds.setPassword(ApplicationConstant.JDBC_PASSWORD);

		// the settings below are optional -- c3p0 can work with defaults
		cpds.setMinPoolSize(5);
		cpds.setAcquireIncrement(5);
		cpds.setMaxPoolSize(20);
		cpds.setMaxStatements(180);
		cpds.setIdleConnectionTestPeriod(300);
		
		return cpds;		
	}

	public Connection getConnection() throws SQLException {
		return this.cpds.getConnection();
	}
}
