/**
 * TransactionWebserviceImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mcda5510.assignment3.service;

public interface TransactionWebserviceImpl extends java.rmi.Remote {
    public com.mcda5510.assignment3.entity.Transaction getTransaction(int transactionId) throws java.rmi.RemoteException;
    public boolean createTransaction(com.mcda5510.assignment3.entity.Transaction transaction) throws java.rmi.RemoteException;
    public boolean updateTransaction(com.mcda5510.assignment3.entity.Transaction transaction) throws java.rmi.RemoteException;
    public boolean removeTransaction(int transactionId) throws java.rmi.RemoteException;
}
