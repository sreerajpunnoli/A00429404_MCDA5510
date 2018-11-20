package com.mcda5510.assignment3.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mcda5510.assignment3.dao.MySQLAccess;

public class MySqlConnection implements DBConnection {

	Connection connection = null;

	Statement statement = null;

	@Override
	public MySQLAccess connect() {

		MySQLAccess transactionWebservice = null;

		try {
			if (connection == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");

				//Local MySQL Config
//				String url = "jdbc:mysql://localhost/transactions";
//				String username = "root";
//				String password = "bullet";
				//Server MySQL Config
				String url = "jdbc:mysql://localhost/s_punnoli";
				String username = "s_punnoli";
				String password = "A00429404";

				connection = DriverManager.getConnection(url + "?" + "user=" + username + "&password=" + password // Creds
						+ "&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"); // timezone
			}

			if (statement == null) {
				statement = connection.createStatement();
			}

			transactionWebservice = new MySQLAccess(statement);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return transactionWebservice;
	}

	@Override
	public void closeConnection() {
		try {
			if (statement != null) {
				statement.close();
			}

			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}