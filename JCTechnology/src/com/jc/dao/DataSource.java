package com.jc.dao;
import java.io.*;
import java.sql.*;

import org.apache.commons.dbcp.BasicDataSource;

public class DataSource {

	private static DataSource datasource;
	private BasicDataSource ds;

	private DataSource() throws IOException, SQLException{
		ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUsername("root");
		ds.setPassword("password");
		ds.setUrl("jdbc:mysql://localhost:3306/jc");

		// settings optional
		ds.setMinIdle(5);
		ds.setMaxIdle(20);
		//ds.setMaxOpenPreparedStatements(180);

	}
	public static DataSource getInstance() throws IOException, SQLException {
		if (datasource == null) {
			datasource = new DataSource();
			return datasource;
		} else {
			return datasource;
		}
	}

	public Connection getConnection() throws SQLException {
		return this.ds.getConnection();
	}

}