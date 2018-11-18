package com.mcda5510.assignment3.service;

import com.mcda5510.assignment3.Assignment3;
import com.mcda5510.assignment3.entity.Transaction;

public class TransactionWebserviceImpl implements TransactionWebservice {

	@Override
	public boolean updateTransaction(Transaction transaction) {
		Assignment3 a = Assignment3.getInstance();

		return a.dao.updateTransaction(transaction);
	}

	@Override
	public Transaction getTransaction(int transactionId) {
		Assignment3 a = Assignment3.getInstance();

		return a.dao.getTransaction(transactionId);
	}

	@Override
	public boolean removeTransaction(int transactionId) {
		Assignment3 a = Assignment3.getInstance();

		return a.dao.removeTransaction(transactionId);
	}

	@Override
	public boolean createTransaction(Transaction transaction) {
		Assignment3 a = Assignment3.getInstance();

		return a.dao.createTransaction(transaction);
	}

}
