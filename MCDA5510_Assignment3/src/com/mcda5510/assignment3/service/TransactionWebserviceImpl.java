package com.mcda5510.assignment3.service;

import com.mcda5510.assignment3.Assignment3;
import com.mcda5510.assignment3.entity.Transaction;

public class TransactionWebserviceImpl implements TransactionWebservice {

	Assignment3 a = null;

	@Override
	public boolean updateTransaction(Transaction transaction) {
		if (a == null) {
			a = new Assignment3();
			a.createConnection();
		}
		
		return a.mysqlAccess.updateTransaction(transaction);
	}

	@Override
	public Transaction getTransaction(int transactionId) {
		if (a == null) {
			a = new Assignment3();
			a.createConnection();
		}
		return a.mysqlAccess.getTransaction(transactionId);
	}

	@Override
	public boolean removeTransaction(int transactionId) {
		if (a == null) {
			a = new Assignment3();
			a.createConnection();
		}
		return a.mysqlAccess.removeTransaction(transactionId);
	}

	@Override
	public boolean createTransaction(Transaction transaction) {
		if (a == null) {
			a = new Assignment3();
			a.createConnection();
		}
		return a.mysqlAccess.createTransaction(transaction);
	}

}
