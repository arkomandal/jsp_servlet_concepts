package com.arkomandal.db;

public class DbCred {
//	final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; //Deprecated
	final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	final String DB_URL = "jdbc:mysql://localhost:3306/mysql_database?useSSL=false";
	final String USER = "root";
	final String PASS = "User(123)";
	
	public String getJDBC_DRIVER() {
		return JDBC_DRIVER;
	}
	public String getDB_URL() {
		return DB_URL;
	}
	public String getUSER() {
		return USER;
	}
	public String getPASS() {
		return PASS;
	}
	
}