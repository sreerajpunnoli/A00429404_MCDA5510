package com.mcda5510.assignment3.service;

import com.mcda5510.assignment3.entity.Transaction;

public interface TransactionWebservice {

	public boolean updateTransaction(Transaction transaction);

	public Transaction getTransaction(int transactionId);

	public boolean removeTransaction(int transactionId);

	public boolean createTransaction(Transaction transaction);
}
