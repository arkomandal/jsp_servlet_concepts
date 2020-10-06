package com.arkomandal.service;

//STEP 1. Import required packages
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.arkomandal.db.DbCred;
import com.arkomandal.model.SignupBean;

public class SignupDao {

	public boolean validate(SignupBean signupBean) throws ClassNotFoundException {
		boolean status = false;
		DbCred dbCred = new DbCred();

		try {
			// STEP 2: Register JDBC driver
			Class.forName(dbCred.getJDBC_DRIVER());

			// STEP 3: Open a connection
			Connection connection = DriverManager.getConnection(dbCred.getDB_URL(), dbCred.getUSER(), dbCred.getPASS());

			// STEP 4: Execute a query
			String query = "INSERT INTO users (name, email, password) VALUES('" + signupBean.getName() + "', '"
					+ signupBean.getEmail() + "', '" + signupBean.getPassword() + "')";
			Statement statement = connection.createStatement();

			// STEP 5: Extract data from result set
			status = statement.execute(query);

			// STEP 6: Clean-up environment
			connection.close();
			
		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);
		}
		
		return status;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}