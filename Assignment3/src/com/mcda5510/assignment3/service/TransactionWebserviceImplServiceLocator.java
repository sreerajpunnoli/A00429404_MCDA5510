/**
 * TransactionWebserviceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mcda5510.assignment3.service;

public class TransactionWebserviceImplServiceLocator extends org.apache.axis.client.Service implements com.mcda5510.assignment3.service.TransactionWebserviceImplService {

    public TransactionWebserviceImplServiceLocator() {
    }


    public TransactionWebserviceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public TransactionWebserviceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for TransactionWebserviceImpl
    private java.lang.String TransactionWebserviceImpl_address = "http://localhost:8080/Assignment3/services/TransactionWebserviceImpl";

    public java.lang.String getTransactionWebserviceImplAddress() {
        return TransactionWebserviceImpl_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TransactionWebserviceImplWSDDServiceName = "TransactionWebserviceImpl";

    public java.lang.String getTransactionWebserviceImplWSDDServiceName() {
        return TransactionWebserviceImplWSDDServiceName;
    }

    public void setTransactionWebserviceImplWSDDServiceName(java.lang.String name) {
        TransactionWebserviceImplWSDDServiceName = name;
    }

    public com.mcda5510.assignment3.service.TransactionWebserviceImpl getTransactionWebserviceImpl() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(TransactionWebserviceImpl_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTransactionWebserviceImpl(endpoint);
    }

    public com.mcda5510.assignment3.service.TransactionWebserviceImpl getTransactionWebserviceImpl(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.mcda5510.assignment3.service.TransactionWebserviceImplSoapBindingStub _stub = new com.mcda5510.assignment3.service.TransactionWebserviceImplSoapBindingStub(portAddress, this);
            _stub.setPortName(getTransactionWebserviceImplWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTransactionWebserviceImplEndpointAddress(java.lang.String address) {
        TransactionWebserviceImpl_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.mcda5510.assignment3.service.TransactionWebserviceImpl.class.isAssignableFrom(serviceEndpointInterface)) {
                com.mcda5510.assignment3.service.TransactionWebserviceImplSoapBindingStub _stub = new com.mcda5510.assignment3.service.TransactionWebserviceImplSoapBindingStub(new java.net.URL(TransactionWebserviceImpl_address), this);
                _stub.setPortName(getTransactionWebserviceImplWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("TransactionWebserviceImpl".equals(inputPortName)) {
            return getTransactionWebserviceImpl();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.assignment3.mcda5510.com", "TransactionWebserviceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.assignment3.mcda5510.com", "TransactionWebserviceImpl"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("TransactionWebserviceImpl".equals(portName)) {
            setTransactionWebserviceImplEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
