package com.mcda5510.assignment3.connect;

import com.mcda5510.assignment3.dao.SQLAccess;

public interface DBConnection {
	
	public SQLAccess connect();

	public void closeConnection();
}