package com.mcda5510.assignment3.connect;

public class MySqlConnectionFactory implements ConnectionFactory {

	@Override
	public DBConnection getConnection() {
		return new MySqlConnection();
	}

}