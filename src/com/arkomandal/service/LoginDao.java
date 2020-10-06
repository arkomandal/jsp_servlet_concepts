package com.arkomandal.service;

//STEP 1. Import required packages
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.arkomandal.db.DbCred;
import com.arkomandal.model.LoginBean;

public class LoginDao {

	public String validate(LoginBean loginBean) throws ClassNotFoundException {
		String username = null;
		DbCred dbCred = new DbCred();

		try {
			//STEP 2: Register JDBC driver
			Class.forName(dbCred.getJDBC_DRIVER());
			
			//STEP 3: Open a connection
			Connection connection = DriverManager.getConnection(dbCred.getDB_URL(), dbCred.getUSER(), dbCred.getPASS());

			//STEP 4: Execute a query
			String query = "select id, name from users where email = ? and password = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, loginBean.getEmail());
			preparedStatement.setString(2, loginBean.getPassword());
			System.out.println(preparedStatement);
			
			//STEP 5: Extract data from result set
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				username = rs.getString(2); //param two is name
			}
			
			//STEP 6: Clean-up environment
			rs.close();
			connection.close();

		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);
		}
		return username;
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