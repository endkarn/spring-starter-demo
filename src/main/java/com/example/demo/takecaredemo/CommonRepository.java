package com.example.demo.takecaredemo;

import org.springframework.context.annotation.ComponentScan;

import java.sql.Connection;
import java.sql.SQLException;

@ComponentScan
public interface CommonRepository { 
	public Connection getConnection() throws SQLException;
}
