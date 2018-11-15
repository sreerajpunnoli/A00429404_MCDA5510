package com.mcda5510.assignment3;

import java.util.logging.Logger;

import com.mcda5510.assignment3.connect.ConnectionFactory;
import com.mcda5510.assignment3.connect.DBConnection;
import com.mcda5510.assignment3.connect.DatabaseType;
import com.mcda5510.assignment3.connect.MySqlConnectionFactory;
import com.mcda5510.assignment3.dao.MySQLAccess;

public class Assignment3 {

	public final Logger l = Logger.getLogger("Assignment3");

	MySQLAccess mysqlAccess = null;

	private void createConnection() {
		if (mysqlAccess == null) {
			ConnectionFactory connectionFactory = getConnectionFactory(DatabaseType.MYSQL);
			DBConnection connection = connectionFactory.getConnection();

			mysqlAccess = (MySQLAccess) connection.connect();

//		connection.closeConnection();
		}
	}

	private static ConnectionFactory getConnectionFactory(DatabaseType databaseType) {
		switch (databaseType) {
		case MYSQL:
			return new MySqlConnectionFactory();
		default:
			throw new RuntimeException("Database Not supported");
		}
	}

}
