package com.mcda5510.assignment3;

import java.util.logging.Logger;

import com.mcda5510.assignment3.connect.ConnectionFactory;
import com.mcda5510.assignment3.connect.DBConnection;
import com.mcda5510.assignment3.connect.DatabaseType;
import com.mcda5510.assignment3.connect.MySqlConnectionFactory;
import com.mcda5510.assignment3.dao.MySQLAccess;

public class Assignment3 {

	private final Logger l = Logger.getLogger("Assignment3");

	public MySQLAccess dao = null;

	public static Assignment3 a = null;

	private Assignment3() {
	}

	public static Assignment3 getInstance() {
		if (a == null) {
			a = new Assignment3();
			a.createConnection();
		}
		return a;
	}

	public void createConnection() {
		if (dao == null) {
			ConnectionFactory connectionFactory = getConnectionFactory(DatabaseType.MYSQL);
			DBConnection connection = connectionFactory.getConnection();

			dao = (MySQLAccess) connection.connect();
			l.info("MYSQL Connection created");

		}
	}

	private ConnectionFactory getConnectionFactory(DatabaseType databaseType) {
		switch (databaseType) {
		case MYSQL:
			return new MySqlConnectionFactory();
		default:
			throw new RuntimeException("Database Not supported");
		}
	}

}
