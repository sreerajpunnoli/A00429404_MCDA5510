package com.mcda5510.assignment3.service;

public class TransactionWebserviceImplProxy implements com.mcda5510.assignment3.service.TransactionWebserviceImpl {
  private String _endpoint = null;
  private com.mcda5510.assignment3.service.TransactionWebserviceImpl transactionWebserviceImpl = null;
  
  public TransactionWebserviceImplProxy() {
    _initTransactionWebserviceImplProxy();
  }
  
  public TransactionWebserviceImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initTransactionWebserviceImplProxy();
  }
  
  private void _initTransactionWebserviceImplProxy() {
    try {
      transactionWebserviceImpl = (new com.mcda5510.assignment3.service.TransactionWebserviceImplServiceLocator()).getTransactionWebserviceImpl();
      if (transactionWebserviceImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)transactionWebserviceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)transactionWebserviceImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (transactionWebserviceImpl != null)
      ((javax.xml.rpc.Stub)transactionWebserviceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.mcda5510.assignment3.service.TransactionWebserviceImpl getTransactionWebserviceImpl() {
    if (transactionWebserviceImpl == null)
      _initTransactionWebserviceImplProxy();
    return transactionWebserviceImpl;
  }
  
  public boolean updateTransaction(com.mcda5510.assignment3.entity.Transaction transaction) throws java.rmi.RemoteException{
    if (transactionWebserviceImpl == null)
      _initTransactionWebserviceImplProxy();
    return transactionWebserviceImpl.updateTransaction(transaction);
  }
  
  public boolean removeTransaction(int transactionId) throws java.rmi.RemoteException{
    if (transactionWebserviceImpl == null)
      _initTransactionWebserviceImplProxy();
    return transactionWebserviceImpl.removeTransaction(transactionId);
  }
  
  public boolean createTransaction(com.mcda5510.assignment3.entity.Transaction transaction) throws java.rmi.RemoteException{
    if (transactionWebserviceImpl == null)
      _initTransactionWebserviceImplProxy();
    return transactionWebserviceImpl.createTransaction(transaction);
  }
  
  public com.mcda5510.assignment3.entity.Transaction getTransaction(int transactionId) throws java.rmi.RemoteException{
    if (transactionWebserviceImpl == null)
      _initTransactionWebserviceImplProxy();
    return transactionWebserviceImpl.getTransaction(transactionId);
  }
  
  
}