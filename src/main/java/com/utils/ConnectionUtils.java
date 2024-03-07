package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;

import com.constants.DatabaseConstants;

public class ConnectionUtils {

	static Connection connection;
	public static Connection getConnection()
	{
		try {
			Class.forName(DatabaseConstants.mySqlDriverClassName);
			connection=DriverManager.getConnection(DatabaseConstants.databaseUrl, DatabaseConstants.databaseUserName, DatabaseConstants.databasePassword);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		return connection;
	}
}
