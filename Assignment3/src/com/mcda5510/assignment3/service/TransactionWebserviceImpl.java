package com.mcda5510.assignment3.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import com.mcda5510.assignment3.Assignment3;
import com.mcda5510.assignment3.entity.Transaction;

public class TransactionWebserviceImpl implements TransactionWebservice {

	private String LOG_PROPERTIES = "log.properties";

	private Logger l = null;

	@Override
	public boolean updateTransaction(Transaction transaction) {
		Assignment3 a = Assignment3.getInstance();
		addLogProperties();

		return a.dao.updateTransaction(transaction);
	}

	@Override
	public Transaction getTransaction(int transactionId) {
		Assignment3 a = Assignment3.getInstance();
		addLogProperties();

		return a.dao.getTransaction(transactionId);
	}

	@Override
	public boolean removeTransaction(int transactionId) {
		Assignment3 a = Assignment3.getInstance();
		addLogProperties();

		return a.dao.removeTransaction(transactionId);
	}

	@Override
	public boolean createTransaction(Transaction transaction) {
		Assignment3 a = Assignment3.getInstance();
		addLogProperties();

		return a.dao.createTransaction(transaction);
	}

	private void addLogProperties() {
		if (l == null) {
			l = Logger.getLogger("Assignment2");
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream(LOG_PROPERTIES);
			try {
				LogManager.getLogManager().readConfiguration(inputStream);
			} catch (Exception e) {
				l.severe("" + e);
			}

			try {
				inputStream.close();
			} catch (IOException e) {
				l.severe("" + e);
			}
		}
	}
}
