
/**
 * StarSystemWebServiceStub.java
 * <p>
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package com.topshinetech.topway.cu.dis.service;

/*
        *  StarSystemWebServiceStub java implementation
        */


public class StarSystemWebServiceStub extends org.apache.axis2.client.Stub {
    protected org.apache.axis2.description.AxisOperation[] _operations;

    //hashmaps to keep the fault mapping
    private java.util.HashMap faultExceptionNameMap = new java.util.HashMap();
    private java.util.HashMap faultExceptionClassNameMap = new java.util.HashMap();
    private java.util.HashMap faultMessageMap = new java.util.HashMap();

    private static int counter = 0;

    private static synchronized java.lang.String getUniqueSuffix() {
        // reset the counter if it is greater than 99999
        if (counter > 99999) {
            counter = 0;
        }
        counter = counter + 1;
        return java.lang.Long.toString(java.lang.System.currentTimeMillis()) + "_" + counter;
    }


    private void populateAxisService() throws org.apache.axis2.AxisFault {

        //creating the Service with a unique name
        _service = new org.apache.axis2.description.AxisService("StarSystemWebService" + getUniqueSuffix());
        addAnonymousOperations();

        //creating the operations
        org.apache.axis2.description.AxisOperation __operation;

        _operations = new org.apache.axis2.description.AxisOperation[5];

        __operation = new org.apache.axis2.description.OutInAxisOperation();


        __operation.setName(new javax.xml.namespace.QName("http://starsystem.sample/", "deleteRecord"));
        _service.addOperation(__operation);


        _operations[0] = __operation;


        __operation = new org.apache.axis2.description.OutInAxisOperation();


        __operation.setName(new javax.xml.namespace.QName("http://starsystem.sample/", "downloadCdr"));
        _service.addOperation(__operation);


        _operations[1] = __operation;


        __operation = new org.apache.axis2.description.OutInAxisOperation();


        __operation.setName(new javax.xml.namespace.QName("http://starsystem.sample/", "deleteCdr"));
        _service.addOperation(__operation);


        _operations[2] = __operation;


        __operation = new org.apache.axis2.description.OutInAxisOperation();


        __operation.setName(new javax.xml.namespace.QName("http://starsystem.sample/", "queryCdr"));
        _service.addOperation(__operation);


        _operations[3] = __operation;


        __operation = new org.apache.axis2.description.OutInAxisOperation();


        __operation.setName(new javax.xml.namespace.QName("http://starsystem.sample/", "queryRecord"));
        _service.addOperation(__operation);


        _operations[4] = __operation;


    }

    //populates the faults
    private void populateFaults() {


    }

    /**
     *Constructor that takes in a configContext
     */

    public StarSystemWebServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext,
                                    java.lang.String targetEndpoint)
            throws org.apache.axis2.AxisFault {
        this(configurationContext, targetEndpoint, false);
    }


    /**
     * Constructor that takes in a configContext  and useseperate listner
     */
    public StarSystemWebServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext,
                                    java.lang.String targetEndpoint, boolean useSeparateListener)
            throws org.apache.axis2.AxisFault {
        //To populate AxisService
        populateAxisService();
        populateFaults();

        _serviceClient = new org.apache.axis2.client.ServiceClient(configurationContext, _service);


        _serviceClient.getOptions().setTo(new org.apache.axis2.addressing.EndpointReference(
                targetEndpoint));
        _serviceClient.getOptions().setUseSeparateListener(useSeparateListener);

        //Set the soap version
        _serviceClient.getOptions().setSoapVersionURI(org.apache.axiom.soap.SOAP12Constants.SOAP_ENVELOPE_NAMESPACE_URI);


    }

    /**
     * Default Constructor
     */
    public StarSystemWebServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext) throws org.apache.axis2.AxisFault {

        this(configurationContext, "http://10.168.20.60:8085/cgi-bin/soapcgi");

    }

    /**
     * Default Constructor
     */
    public StarSystemWebServiceStub() throws org.apache.axis2.AxisFault {

        this("http://10.168.20.60:8085/cgi-bin/soapcgi");

    }

    /**
     * Constructor taking the target endpoint
     */
    public StarSystemWebServiceStub(java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
        this(null, targetEndpoint);
    }


    /**
     * Auto generated method signature
     *
     * @see com.topshinetech.topway.cu.dis.service.StarSystemWebService#deleteRecord
     * @param deleteRecord0

     */


    public com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DeleteRecordResponse deleteRecord(

            com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DeleteRecord deleteRecord0)


            throws java.rmi.RemoteException

    {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
            _operationClient.getOptions().setAction("http://starsystem.sample/DeleteRecord");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);


            addPropertyToOperationClient(_operationClient, org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");


            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();


            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;


            env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                    deleteRecord0,
                    optimizeContent(new javax.xml.namespace.QName("http://starsystem.sample/",
                            "deleteRecord")), new javax.xml.namespace.QName("http://starsystem.sample/",
                            "deleteRecord"));

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);


            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                    org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();


            java.lang.Object object = fromOM(
                    _returnEnv.getBody().getFirstElement(),
                    com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DeleteRecordResponse.class,
                    getEnvelopeNamespaces(_returnEnv));


            return (com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DeleteRecordResponse) object;

        } catch (org.apache.axis2.AxisFault f) {

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "DeleteRecord"))) {
                    //make the fault by reflection
                    try {
                        java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "DeleteRecord"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        //message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "DeleteRecord"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new java.lang.Class[]{messageClass});
                        m.invoke(ex, new java.lang.Object[]{messageObject});


                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (java.lang.ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see com.topshinetech.topway.cu.dis.service.StarSystemWebService#startdeleteRecord
     * @param deleteRecord0

     */
    public void startdeleteRecord(

            com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DeleteRecord deleteRecord0,

            final com.topshinetech.topway.cu.dis.service.StarSystemWebServiceCallbackHandler callback)

            throws java.rmi.RemoteException {

        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
        _operationClient.getOptions().setAction("http://starsystem.sample/DeleteRecord");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);


        addPropertyToOperationClient(_operationClient, org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");


        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();


        //Style is Doc.


        env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                deleteRecord0,
                optimizeContent(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "deleteRecord")), new javax.xml.namespace.QName("http://starsystem.sample/",
                        "deleteRecord"));

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                            com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DeleteRecordResponse.class,
                            getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultdeleteRecord(
                            (com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DeleteRecordResponse) object);

                } catch (org.apache.axis2.AxisFault e) {
                    callback.receiveErrordeleteRecord(e);
                }
            }

            public void onError(java.lang.Exception error) {
                if (error instanceof org.apache.axis2.AxisFault) {
                    org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();
                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "DeleteRecord"))) {
                            //make the fault by reflection
                            try {
                                java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "DeleteRecord"));
                                java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                                java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                                //message class
                                java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "DeleteRecord"));
                                java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                                java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                                java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                        new java.lang.Class[]{messageClass});
                                m.invoke(ex, new java.lang.Object[]{messageObject});


                                callback.receiveErrordeleteRecord(new java.rmi.RemoteException(ex.getMessage(), ex));
                            } catch (java.lang.ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrordeleteRecord(f);
                            } catch (java.lang.ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrordeleteRecord(f);
                            } catch (java.lang.NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrordeleteRecord(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrordeleteRecord(f);
                            } catch (java.lang.IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrordeleteRecord(f);
                            } catch (java.lang.InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrordeleteRecord(f);
                            } catch (org.apache.axis2.AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrordeleteRecord(f);
                            }
                        } else {
                            callback.receiveErrordeleteRecord(f);
                        }
                    } else {
                        callback.receiveErrordeleteRecord(f);
                    }
                } else {
                    callback.receiveErrordeleteRecord(error);
                }
            }

            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                } catch (org.apache.axis2.AxisFault axisFault) {
                    callback.receiveErrordeleteRecord(axisFault);
                }
            }
        });


        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if (_operations[0].getMessageReceiver() == null && _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[0].setMessageReceiver(
                    _callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);

    }

    /**
     * Auto generated method signature
     *
     * @see com.topshinetech.topway.cu.dis.service.StarSystemWebService#downloadCdr
     * @param downloadCdr2

     */


    public com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DownloadCdrResponse downloadCdr(

            com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DownloadCdr downloadCdr2)


            throws java.rmi.RemoteException

    {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
            _operationClient.getOptions().setAction("http://starsystem.sample/DownloadCdr");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);


            addPropertyToOperationClient(_operationClient, org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");


            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();


            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;


            env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                    downloadCdr2,
                    optimizeContent(new javax.xml.namespace.QName("http://starsystem.sample/",
                            "downloadCdr")), new javax.xml.namespace.QName("http://starsystem.sample/",
                            "downloadCdr"));

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);


            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                    org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();


            java.lang.Object object = fromOM(
                    _returnEnv.getBody().getFirstElement(),
                    com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DownloadCdrResponse.class,
                    getEnvelopeNamespaces(_returnEnv));


            return (com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DownloadCdrResponse) object;

        } catch (org.apache.axis2.AxisFault f) {

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "DownloadCdr"))) {
                    //make the fault by reflection
                    try {
                        java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "DownloadCdr"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        //message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "DownloadCdr"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new java.lang.Class[]{messageClass});
                        m.invoke(ex, new java.lang.Object[]{messageObject});


                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (java.lang.ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see com.topshinetech.topway.cu.dis.service.StarSystemWebService#startdownloadCdr
     * @param downloadCdr2

     */
    public void startdownloadCdr(

            com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DownloadCdr downloadCdr2,

            final com.topshinetech.topway.cu.dis.service.StarSystemWebServiceCallbackHandler callback)

            throws java.rmi.RemoteException {

        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
        _operationClient.getOptions().setAction("http://starsystem.sample/DownloadCdr");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);


        addPropertyToOperationClient(_operationClient, org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");


        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();


        //Style is Doc.


        env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                downloadCdr2,
                optimizeContent(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "downloadCdr")), new javax.xml.namespace.QName("http://starsystem.sample/",
                        "downloadCdr"));

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                            com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DownloadCdrResponse.class,
                            getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultdownloadCdr(
                            (com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DownloadCdrResponse) object);

                } catch (org.apache.axis2.AxisFault e) {
                    callback.receiveErrordownloadCdr(e);
                }
            }

            public void onError(java.lang.Exception error) {
                if (error instanceof org.apache.axis2.AxisFault) {
                    org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();
                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "DownloadCdr"))) {
                            //make the fault by reflection
                            try {
                                java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "DownloadCdr"));
                                java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                                java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                                //message class
                                java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "DownloadCdr"));
                                java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                                java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                                java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                        new java.lang.Class[]{messageClass});
                                m.invoke(ex, new java.lang.Object[]{messageObject});


                                callback.receiveErrordownloadCdr(new java.rmi.RemoteException(ex.getMessage(), ex));
                            } catch (java.lang.ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrordownloadCdr(f);
                            } catch (java.lang.ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrordownloadCdr(f);
                            } catch (java.lang.NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrordownloadCdr(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrordownloadCdr(f);
                            } catch (java.lang.IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrordownloadCdr(f);
                            } catch (java.lang.InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrordownloadCdr(f);
                            } catch (org.apache.axis2.AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrordownloadCdr(f);
                            }
                        } else {
                            callback.receiveErrordownloadCdr(f);
                        }
                    } else {
                        callback.receiveErrordownloadCdr(f);
                    }
                } else {
                    callback.receiveErrordownloadCdr(error);
                }
            }

            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                } catch (org.apache.axis2.AxisFault axisFault) {
                    callback.receiveErrordownloadCdr(axisFault);
                }
            }
        });


        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if (_operations[1].getMessageReceiver() == null && _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[1].setMessageReceiver(
                    _callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);

    }

    /**
     * Auto generated method signature
     *
     * @see com.topshinetech.topway.cu.dis.service.StarSystemWebService#deleteCdr
     * @param deleteCdr4

     */


    public com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DeleteCdrResponse deleteCdr(

            com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DeleteCdr deleteCdr4)


            throws java.rmi.RemoteException

    {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[2].getName());
            _operationClient.getOptions().setAction("http://starsystem.sample/DeleteCdr");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);


            addPropertyToOperationClient(_operationClient, org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");


            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();


            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;


            env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                    deleteCdr4,
                    optimizeContent(new javax.xml.namespace.QName("http://starsystem.sample/",
                            "deleteCdr")), new javax.xml.namespace.QName("http://starsystem.sample/",
                            "deleteCdr"));

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);


            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                    org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();


            java.lang.Object object = fromOM(
                    _returnEnv.getBody().getFirstElement(),
                    com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DeleteCdrResponse.class,
                    getEnvelopeNamespaces(_returnEnv));


            return (com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DeleteCdrResponse) object;

        } catch (org.apache.axis2.AxisFault f) {

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "DeleteCdr"))) {
                    //make the fault by reflection
                    try {
                        java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "DeleteCdr"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        //message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "DeleteCdr"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new java.lang.Class[]{messageClass});
                        m.invoke(ex, new java.lang.Object[]{messageObject});


                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (java.lang.ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see com.topshinetech.topway.cu.dis.service.StarSystemWebService#startdeleteCdr
     * @param deleteCdr4

     */
    public void startdeleteCdr(

            com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DeleteCdr deleteCdr4,

            final com.topshinetech.topway.cu.dis.service.StarSystemWebServiceCallbackHandler callback)

            throws java.rmi.RemoteException {

        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[2].getName());
        _operationClient.getOptions().setAction("http://starsystem.sample/DeleteCdr");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);


        addPropertyToOperationClient(_operationClient, org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");


        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();


        //Style is Doc.


        env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                deleteCdr4,
                optimizeContent(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "deleteCdr")), new javax.xml.namespace.QName("http://starsystem.sample/",
                        "deleteCdr"));

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                            com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DeleteCdrResponse.class,
                            getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultdeleteCdr(
                            (com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DeleteCdrResponse) object);

                } catch (org.apache.axis2.AxisFault e) {
                    callback.receiveErrordeleteCdr(e);
                }
            }

            public void onError(java.lang.Exception error) {
                if (error instanceof org.apache.axis2.AxisFault) {
                    org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();
                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "DeleteCdr"))) {
                            //make the fault by reflection
                            try {
                                java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "DeleteCdr"));
                                java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                                java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                                //message class
                                java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "DeleteCdr"));
                                java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                                java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                                java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                        new java.lang.Class[]{messageClass});
                                m.invoke(ex, new java.lang.Object[]{messageObject});


                                callback.receiveErrordeleteCdr(new java.rmi.RemoteException(ex.getMessage(), ex));
                            } catch (java.lang.ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrordeleteCdr(f);
                            } catch (java.lang.ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrordeleteCdr(f);
                            } catch (java.lang.NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrordeleteCdr(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrordeleteCdr(f);
                            } catch (java.lang.IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrordeleteCdr(f);
                            } catch (java.lang.InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrordeleteCdr(f);
                            } catch (org.apache.axis2.AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrordeleteCdr(f);
                            }
                        } else {
                            callback.receiveErrordeleteCdr(f);
                        }
                    } else {
                        callback.receiveErrordeleteCdr(f);
                    }
                } else {
                    callback.receiveErrordeleteCdr(error);
                }
            }

            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                } catch (org.apache.axis2.AxisFault axisFault) {
                    callback.receiveErrordeleteCdr(axisFault);
                }
            }
        });


        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if (_operations[2].getMessageReceiver() == null && _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[2].setMessageReceiver(
                    _callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);

    }

    /**
     * Auto generated method signature
     *
     * @see com.topshinetech.topway.cu.dis.service.StarSystemWebService#queryCdr
     * @param queryCdr6

     */


    public com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.QueryCdrResponse queryCdr(

            com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.QueryCdr queryCdr6)


            throws java.rmi.RemoteException

    {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[3].getName());
            _operationClient.getOptions().setAction("http://starsystem.sample/QueryCdr");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);


            addPropertyToOperationClient(_operationClient, org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");


            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();


            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;


            env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                    queryCdr6,
                    optimizeContent(new javax.xml.namespace.QName("http://starsystem.sample/",
                            "queryCdr")), new javax.xml.namespace.QName("http://starsystem.sample/",
                            "queryCdr"));

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);


            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                    org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();


            java.lang.Object object = fromOM(
                    _returnEnv.getBody().getFirstElement(),
                    com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.QueryCdrResponse.class,
                    getEnvelopeNamespaces(_returnEnv));


            return (com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.QueryCdrResponse) object;

        } catch (org.apache.axis2.AxisFault f) {

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "QueryCdr"))) {
                    //make the fault by reflection
                    try {
                        java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "QueryCdr"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        //message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "QueryCdr"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new java.lang.Class[]{messageClass});
                        m.invoke(ex, new java.lang.Object[]{messageObject});


                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (java.lang.ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see com.topshinetech.topway.cu.dis.service.StarSystemWebService#startqueryCdr
     * @param queryCdr6

     */
    public void startqueryCdr(

            com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.QueryCdr queryCdr6,

            final com.topshinetech.topway.cu.dis.service.StarSystemWebServiceCallbackHandler callback)

            throws java.rmi.RemoteException {

        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[3].getName());
        _operationClient.getOptions().setAction("http://starsystem.sample/QueryCdr");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);


        addPropertyToOperationClient(_operationClient, org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");


        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();


        //Style is Doc.


        env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                queryCdr6,
                optimizeContent(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "queryCdr")), new javax.xml.namespace.QName("http://starsystem.sample/",
                        "queryCdr"));

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                            com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.QueryCdrResponse.class,
                            getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultqueryCdr(
                            (com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.QueryCdrResponse) object);

                } catch (org.apache.axis2.AxisFault e) {
                    callback.receiveErrorqueryCdr(e);
                }
            }

            public void onError(java.lang.Exception error) {
                if (error instanceof org.apache.axis2.AxisFault) {
                    org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();
                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "QueryCdr"))) {
                            //make the fault by reflection
                            try {
                                java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "QueryCdr"));
                                java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                                java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                                //message class
                                java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "QueryCdr"));
                                java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                                java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                                java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                        new java.lang.Class[]{messageClass});
                                m.invoke(ex, new java.lang.Object[]{messageObject});


                                callback.receiveErrorqueryCdr(new java.rmi.RemoteException(ex.getMessage(), ex));
                            } catch (java.lang.ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorqueryCdr(f);
                            } catch (java.lang.ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorqueryCdr(f);
                            } catch (java.lang.NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorqueryCdr(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorqueryCdr(f);
                            } catch (java.lang.IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorqueryCdr(f);
                            } catch (java.lang.InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorqueryCdr(f);
                            } catch (org.apache.axis2.AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorqueryCdr(f);
                            }
                        } else {
                            callback.receiveErrorqueryCdr(f);
                        }
                    } else {
                        callback.receiveErrorqueryCdr(f);
                    }
                } else {
                    callback.receiveErrorqueryCdr(error);
                }
            }

            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                } catch (org.apache.axis2.AxisFault axisFault) {
                    callback.receiveErrorqueryCdr(axisFault);
                }
            }
        });


        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if (_operations[3].getMessageReceiver() == null && _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[3].setMessageReceiver(
                    _callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);

    }

    /**
     * Auto generated method signature
     *
     * @see com.topshinetech.topway.cu.dis.service.StarSystemWebService#queryRecord
     * @param queryRecord8

     */


    public com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.QueryRecordResponse queryRecord(

            com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.QueryRecord queryRecord8)


            throws java.rmi.RemoteException

    {
        org.apache.axis2.context.MessageContext _messageContext = null;
        try {
            org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[4].getName());
            _operationClient.getOptions().setAction("http://starsystem.sample/QueryRecord");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);


            addPropertyToOperationClient(_operationClient, org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");


            // create a message context
            _messageContext = new org.apache.axis2.context.MessageContext();


            // create SOAP envelope with that payload
            org.apache.axiom.soap.SOAPEnvelope env = null;


            env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                    queryRecord8,
                    optimizeContent(new javax.xml.namespace.QName("http://starsystem.sample/",
                            "queryRecord")), new javax.xml.namespace.QName("http://starsystem.sample/",
                            "queryRecord"));

            //adding SOAP soap_headers
            _serviceClient.addHeadersToEnvelope(env);
            // set the message context with that soap envelope
            _messageContext.setEnvelope(env);

            // add the message contxt to the operation client
            _operationClient.addMessageContext(_messageContext);

            //execute the operation client
            _operationClient.execute(true);


            org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                    org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
            org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            java.lang.Object object = fromOM(
                    _returnEnv.getBody().getFirstElement(),
                    com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.QueryRecordResponse.class,
                    getEnvelopeNamespaces(_returnEnv));


            return (com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.QueryRecordResponse) object;

        } catch (org.apache.axis2.AxisFault f) {

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt != null) {
                if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "QueryRecord"))) {
                    //make the fault by reflection
                    try {
                        java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "QueryRecord"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        //message class
                        java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "QueryRecord"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                new java.lang.Class[]{messageClass});
                        m.invoke(ex, new java.lang.Object[]{messageObject});


                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    } catch (java.lang.ClassCastException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                } else {
                    throw f;
                }
            } else {
                throw f;
            }
        } finally {
            if (_messageContext.getTransportOut() != null) {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
    }

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     * @see com.topshinetech.topway.cu.dis.service.StarSystemWebService#startqueryRecord
     * @param queryRecord8

     */
    public void startqueryRecord(

            com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.QueryRecord queryRecord8,

            final com.topshinetech.topway.cu.dis.service.StarSystemWebServiceCallbackHandler callback)

            throws java.rmi.RemoteException {

        org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[4].getName());
        _operationClient.getOptions().setAction("http://starsystem.sample/QueryRecord");
        _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);


        addPropertyToOperationClient(_operationClient, org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");


        // create SOAP envelope with that payload
        org.apache.axiom.soap.SOAPEnvelope env = null;
        final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();


        //Style is Doc.


        env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                queryRecord8,
                optimizeContent(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "queryRecord")), new javax.xml.namespace.QName("http://starsystem.sample/",
                        "queryRecord"));

        // adding SOAP soap_headers
        _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                try {
                    org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                    java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                            com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.QueryRecordResponse.class,
                            getEnvelopeNamespaces(resultEnv));
                    callback.receiveResultqueryRecord(
                            (com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.QueryRecordResponse) object);

                } catch (org.apache.axis2.AxisFault e) {
                    callback.receiveErrorqueryRecord(e);
                }
            }

            public void onError(java.lang.Exception error) {
                if (error instanceof org.apache.axis2.AxisFault) {
                    org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
                    org.apache.axiom.om.OMElement faultElt = f.getDetail();
                    if (faultElt != null) {
                        if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "QueryRecord"))) {
                            //make the fault by reflection
                            try {
                                java.lang.String exceptionClassName = (java.lang.String) faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "QueryRecord"));
                                java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                                java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                                //message class
                                java.lang.String messageClassName = (java.lang.String) faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "QueryRecord"));
                                java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                                java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                                java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                        new java.lang.Class[]{messageClass});
                                m.invoke(ex, new java.lang.Object[]{messageObject});


                                callback.receiveErrorqueryRecord(new java.rmi.RemoteException(ex.getMessage(), ex));
                            } catch (java.lang.ClassCastException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorqueryRecord(f);
                            } catch (java.lang.ClassNotFoundException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorqueryRecord(f);
                            } catch (java.lang.NoSuchMethodException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorqueryRecord(f);
                            } catch (java.lang.reflect.InvocationTargetException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorqueryRecord(f);
                            } catch (java.lang.IllegalAccessException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorqueryRecord(f);
                            } catch (java.lang.InstantiationException e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorqueryRecord(f);
                            } catch (org.apache.axis2.AxisFault e) {
                                // we cannot intantiate the class - throw the original Axis fault
                                callback.receiveErrorqueryRecord(f);
                            }
                        } else {
                            callback.receiveErrorqueryRecord(f);
                        }
                    } else {
                        callback.receiveErrorqueryRecord(f);
                    }
                } else {
                    callback.receiveErrorqueryRecord(error);
                }
            }

            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                onError(fault);
            }

            public void onComplete() {
                try {
                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                } catch (org.apache.axis2.AxisFault axisFault) {
                    callback.receiveErrorqueryRecord(axisFault);
                }
            }
        });


        org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if (_operations[4].getMessageReceiver() == null && _operationClient.getOptions().isUseSeparateListener()) {
            _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
            _operations[4].setMessageReceiver(
                    _callbackReceiver);
        }

        //execute the operation client
        _operationClient.execute(false);

    }


    /**
     *  A utility method that copies the namepaces from the SOAPEnvelope
     */
    private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env) {
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
            org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
            returnMap.put(ns.getPrefix(), ns.getNamespaceURI());
        }
        return returnMap;
    }


    private javax.xml.namespace.QName[] opNameArray = null;

    private boolean optimizeContent(javax.xml.namespace.QName opName) {


        if (opNameArray == null) {
            return false;
        }
        for (int i = 0; i < opNameArray.length; i++) {
            if (opName.equals(opNameArray[i])) {
                return true;
            }
        }
        return false;
    }

    //http://10.168.20.60:8085/cgi-bin/soapcgi
    public static class Data_CondiFlag
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://starsystem.sample/",
                "Data_CondiFlag",
                "ns1");


        /**
         * field for Data_CondiFlag
         */


        protected org.apache.axis2.databinding.types.UnsignedByte localData_CondiFlag;

        private static java.util.HashMap _table_ = new java.util.HashMap();

        // Constructor

        protected Data_CondiFlag(org.apache.axis2.databinding.types.UnsignedByte value, boolean isRegisterValue) {
            localData_CondiFlag = value;
            if (isRegisterValue) {

                _table_.put(localData_CondiFlag, this);

            }

        }

        public static final org.apache.axis2.databinding.types.UnsignedByte _value1 =
                org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedByte("0");

        public static final org.apache.axis2.databinding.types.UnsignedByte _value2 =
                org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedByte("1");

        public static final Data_CondiFlag value1 =
                new Data_CondiFlag(_value1, true);

        public static final Data_CondiFlag value2 =
                new Data_CondiFlag(_value2, true);


        public org.apache.axis2.databinding.types.UnsignedByte getValue() {
            return localData_CondiFlag;
        }

        public boolean equals(java.lang.Object obj) {
            return (obj == this);
        }

        public int hashCode() {
            return toString().hashCode();
        }

        public java.lang.String toString() {

            return localData_CondiFlag.toString();


        }


        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {


            org.apache.axiom.om.OMDataSource dataSource =
                    new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {


            //We can safely assume an element has only one type associated with it

            java.lang.String namespace = parentQName.getNamespaceURI();
            java.lang.String _localName = parentQName.getLocalPart();

            writeStartElement(null, namespace, _localName, xmlWriter);

            // add the type details if this is used in a simple type
            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://starsystem.sample/");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":Data_CondiFlag",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "Data_CondiFlag",
                            xmlWriter);
                }
            }

            if (localData_CondiFlag == null) {

                throw new org.apache.axis2.databinding.ADBException("Data_CondiFlag cannot be null !!");

            } else {

                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localData_CondiFlag));

            }

            xmlWriter.writeEndElement();


        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://starsystem.sample/")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }


        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if (uri == null || uri.length() == 0) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }


        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {


            //We can safely assume an element has only one type associated with it
            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                    new java.lang.Object[]{
                            org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localData_CondiFlag)
                    },
                    null);

        }


        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {


            public static Data_CondiFlag fromValue(org.apache.axis2.databinding.types.UnsignedByte value)
                    throws java.lang.IllegalArgumentException {
                Data_CondiFlag enumeration = (Data_CondiFlag)

                        _table_.get(value);


                if ((enumeration == null) && !((value == null) || (value.equals("")))) {
                    throw new java.lang.IllegalArgumentException();
                }
                return enumeration;
            }

            public static Data_CondiFlag fromString(java.lang.String value, java.lang.String namespaceURI)
                    throws java.lang.IllegalArgumentException {
                try {

                    return fromValue(org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedByte(value));


                } catch (java.lang.Exception e) {
                    throw new java.lang.IllegalArgumentException();
                }
            }

            public static Data_CondiFlag fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                                                    java.lang.String content) {
                if (content.indexOf(":") > -1) {
                    java.lang.String prefix = content.substring(0, content.indexOf(":"));
                    java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                    return Data_CondiFlag.Factory.fromString(content, namespaceUri);
                } else {
                    return Data_CondiFlag.Factory.fromString(content, "");
                }
            }


            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static Data_CondiFlag parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                Data_CondiFlag object = null;
                // initialize a hash map to keep values
                java.util.Map attributeMap = new java.util.HashMap();
                java.util.List extraAttributeList = new java.util.ArrayList<org.apache.axiom.om.OMAttribute>();


                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();


                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();


                    while (!reader.isEndElement()) {
                        if (reader.isStartElement() || reader.hasText()) {

                            nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                            if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                                throw new org.apache.axis2.databinding.ADBException("The element: " + "Data_CondiFlag" + "  cannot be null");
                            }


                            java.lang.String content = reader.getElementText();

                            if (content.indexOf(":") > 0) {
                                // this seems to be a Qname so find the namespace and send
                                prefix = content.substring(0, content.indexOf(":"));
                                namespaceuri = reader.getNamespaceURI(prefix);
                                object = Data_CondiFlag.Factory.fromString(content, namespaceuri);
                            } else {
                                // this seems to be not a qname send and empty namespace incase of it is
                                // check is done in fromString method
                                object = Data_CondiFlag.Factory.fromString(content, "");
                            }


                        } else {
                            reader.next();
                        }
                    }  // end of while loop


                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class


    }


    public static class DeleteCdrResponse
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://starsystem.sample/",
                "DeleteCdrResponse",
                "ns1");


        /**
         * field for Returnflag
         */


        protected Data_returnflag localReturnflag;


        /**
         * Auto generated getter method
         * @return Data_returnflag
         */
        public Data_returnflag getReturnflag() {
            return localReturnflag;
        }


        /**
         * Auto generated setter method
         * @param param Returnflag
         */
        public void setReturnflag(Data_returnflag param) {

            this.localReturnflag = param;


        }


        /**
         * field for Totalnum
         */


        protected org.apache.axis2.databinding.types.UnsignedInt localTotalnum;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localTotalnumTracker = false;

        public boolean isTotalnumSpecified() {
            return localTotalnumTracker;
        }


        /**
         * Auto generated getter method
         * @return org.apache.axis2.databinding.types.UnsignedInt
         */
        public org.apache.axis2.databinding.types.UnsignedInt getTotalnum() {
            return localTotalnum;
        }


        /**
         * Auto generated setter method
         * @param param Totalnum
         */
        public void setTotalnum(org.apache.axis2.databinding.types.UnsignedInt param) {
            localTotalnumTracker = param != null;

            this.localTotalnum = param;


        }


        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {


            org.apache.axiom.om.OMDataSource dataSource =
                    new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {


            java.lang.String prefix = null;
            java.lang.String namespace = null;


            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

            if (serializeType) {


                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://starsystem.sample/");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":DeleteCdrResponse",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "DeleteCdrResponse",
                            xmlWriter);
                }


            }

            if (localReturnflag == null) {
                throw new org.apache.axis2.databinding.ADBException("returnflag cannot be null!!");
            }
            localReturnflag.serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "returnflag"),
                    xmlWriter);
            if (localTotalnumTracker) {
                namespace = "http://starsystem.sample/";
                writeStartElement(null, namespace, "totalnum", xmlWriter);


                if (localTotalnum == null) {
                    // write the nil attribute

                    throw new org.apache.axis2.databinding.ADBException("totalnum cannot be null!!");

                } else {


                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTotalnum));

                }

                xmlWriter.writeEndElement();
            }
            xmlWriter.writeEndElement();


        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://starsystem.sample/")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }


        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if (uri == null || uri.length() == 0) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }


        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {


            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();


            elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                    "returnflag"));


            if (localReturnflag == null) {
                throw new org.apache.axis2.databinding.ADBException("returnflag cannot be null!!");
            }
            elementList.add(localReturnflag);
            if (localTotalnumTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "totalnum"));

                if (localTotalnum != null) {
                    elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTotalnum));
                } else {
                    throw new org.apache.axis2.databinding.ADBException("totalnum cannot be null!!");
                }
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());


        }


        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {


            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static DeleteCdrResponse parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                DeleteCdrResponse object =
                        new DeleteCdrResponse();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();


                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "type");
                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if (!"DeleteCdrResponse".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (DeleteCdrResponse) ExtensionMapper.getTypeObject(
                                        nsUri, type, reader);
                            }


                        }


                    }


                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();


                    reader.next();


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "returnflag").equals(reader.getName())) {

                        object.setReturnflag(Data_returnflag.Factory.parse(reader));

                        reader.next();

                    }  // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "totalnum").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException("The element: " + "totalnum" + "  cannot be null");
                        }


                        java.lang.String content = reader.getElementText();

                        object.setTotalnum(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedInt(content));

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());


                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class


    }


    public static class DownloadCdrResponse
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://starsystem.sample/",
                "DownloadCdrResponse",
                "ns1");


        /**
         * field for Returnflag
         */


        protected Data_returnflag localReturnflag;


        /**
         * Auto generated getter method
         * @return Data_returnflag
         */
        public Data_returnflag getReturnflag() {
            return localReturnflag;
        }


        /**
         * Auto generated setter method
         * @param param Returnflag
         */
        public void setReturnflag(Data_returnflag param) {

            this.localReturnflag = param;


        }


        /**
         * field for Cdrpath
         */


        protected java.lang.String localCdrpath;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localCdrpathTracker = false;

        public boolean isCdrpathSpecified() {
            return localCdrpathTracker;
        }


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getCdrpath() {
            return localCdrpath;
        }


        /**
         * Auto generated setter method
         * @param param Cdrpath
         */
        public void setCdrpath(java.lang.String param) {
            localCdrpathTracker = param != null;

            this.localCdrpath = param;


        }


        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {


            org.apache.axiom.om.OMDataSource dataSource =
                    new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {


            java.lang.String prefix = null;
            java.lang.String namespace = null;


            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

            if (serializeType) {


                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://starsystem.sample/");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":DownloadCdrResponse",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "DownloadCdrResponse",
                            xmlWriter);
                }


            }

            if (localReturnflag == null) {
                throw new org.apache.axis2.databinding.ADBException("returnflag cannot be null!!");
            }
            localReturnflag.serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "returnflag"),
                    xmlWriter);
            if (localCdrpathTracker) {
                namespace = "http://starsystem.sample/";
                writeStartElement(null, namespace, "cdrpath", xmlWriter);


                if (localCdrpath == null) {
                    // write the nil attribute

                    throw new org.apache.axis2.databinding.ADBException("cdrpath cannot be null!!");

                } else {


                    xmlWriter.writeCharacters(localCdrpath);

                }

                xmlWriter.writeEndElement();
            }
            xmlWriter.writeEndElement();


        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://starsystem.sample/")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }


        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if (uri == null || uri.length() == 0) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }


        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {


            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();


            elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                    "returnflag"));


            if (localReturnflag == null) {
                throw new org.apache.axis2.databinding.ADBException("returnflag cannot be null!!");
            }
            elementList.add(localReturnflag);
            if (localCdrpathTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "cdrpath"));

                if (localCdrpath != null) {
                    elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCdrpath));
                } else {
                    throw new org.apache.axis2.databinding.ADBException("cdrpath cannot be null!!");
                }
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());


        }


        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {


            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static DownloadCdrResponse parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                DownloadCdrResponse object =
                        new DownloadCdrResponse();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();


                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "type");
                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if (!"DownloadCdrResponse".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (DownloadCdrResponse) ExtensionMapper.getTypeObject(
                                        nsUri, type, reader);
                            }


                        }


                    }


                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();


                    reader.next();


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "returnflag").equals(reader.getName())) {

                        object.setReturnflag(Data_returnflag.Factory.parse(reader));

                        reader.next();

                    }  // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "cdrpath").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException("The element: " + "cdrpath" + "  cannot be null");
                        }


                        java.lang.String content = reader.getElementText();

                        object.setCdrpath(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());


                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class


    }


    public static class Data_startid
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://starsystem.sample/",
                "Data_startid",
                "ns1");


        /**
         * field for Data_startid
         */


        protected org.apache.axis2.databinding.types.UnsignedInt localData_startid;


        /**
         * Auto generated getter method
         * @return org.apache.axis2.databinding.types.UnsignedInt
         */
        public org.apache.axis2.databinding.types.UnsignedInt getData_startid() {
            return localData_startid;
        }


        /**
         * Auto generated setter method
         * @param param Data_startid
         */
        public void setData_startid(org.apache.axis2.databinding.types.UnsignedInt param) {

            if (org.apache.axis2.databinding.utils.ConverterUtil.convertToString(param).matches("2147483647")) {
                this.localData_startid = param;
            } else {
                throw new java.lang.RuntimeException();
            }


        }


        public java.lang.String toString() {

            return localData_startid.toString();

        }


        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {


            org.apache.axiom.om.OMDataSource dataSource =
                    new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {


            //We can safely assume an element has only one type associated with it

            java.lang.String namespace = parentQName.getNamespaceURI();
            java.lang.String _localName = parentQName.getLocalPart();

            writeStartElement(null, namespace, _localName, xmlWriter);

            // add the type details if this is used in a simple type
            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://starsystem.sample/");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":Data_startid",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "Data_startid",
                            xmlWriter);
                }
            }

            if (localData_startid == null) {

                throw new org.apache.axis2.databinding.ADBException("Data_startid cannot be null !!");

            } else {

                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localData_startid));

            }

            xmlWriter.writeEndElement();


        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://starsystem.sample/")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }


        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if (uri == null || uri.length() == 0) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }


        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {


            //We can safely assume an element has only one type associated with it
            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                    new java.lang.Object[]{
                            org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localData_startid)
                    },
                    null);

        }


        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {


            public static Data_startid fromString(java.lang.String value,
                                                  java.lang.String namespaceURI) {
                Data_startid returnValue = new Data_startid();

                returnValue.setData_startid(
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedInt(value));


                return returnValue;
            }

            public static Data_startid fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                                                  java.lang.String content) {
                if (content.indexOf(":") > -1) {
                    java.lang.String prefix = content.substring(0, content.indexOf(":"));
                    java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                    return Data_startid.Factory.fromString(content, namespaceUri);
                } else {
                    return Data_startid.Factory.fromString(content, "");
                }
            }


            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static Data_startid parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                Data_startid object =
                        new Data_startid();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();


                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();


                    while (!reader.isEndElement()) {
                        if (reader.isStartElement() || reader.hasText()) {

                            if (reader.isStartElement() || reader.hasText()) {

                                nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                                    throw new org.apache.axis2.databinding.ADBException("The element: " + "Data_startid" + "  cannot be null");
                                }


                                java.lang.String content = reader.getElementText();

                                object.setData_startid(
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedInt(content));

                            }  // End of if for expected property start element

                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop


                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class


    }


    public static class Data_recordnum
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://starsystem.sample/",
                "Data_recordnum",
                "ns1");


        /**
         * field for Data_recordnum
         */


        protected org.apache.axis2.databinding.types.UnsignedShort localData_recordnum;


        /**
         * Auto generated getter method
         * @return org.apache.axis2.databinding.types.UnsignedShort
         */
        public org.apache.axis2.databinding.types.UnsignedShort getData_recordnum() {
            return localData_recordnum;
        }


        /**
         * Auto generated setter method
         * @param param Data_recordnum
         */
        public void setData_recordnum(org.apache.axis2.databinding.types.UnsignedShort param) {

            if (org.apache.axis2.databinding.utils.ConverterUtil.convertToString(param).matches("[0-9]|[1-2][0-9]|[3][0-2]")) {
                this.localData_recordnum = param;
            } else {
                throw new java.lang.RuntimeException();
            }


        }


        public java.lang.String toString() {

            return localData_recordnum.toString();

        }


        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {


            org.apache.axiom.om.OMDataSource dataSource =
                    new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {


            //We can safely assume an element has only one type associated with it

            java.lang.String namespace = parentQName.getNamespaceURI();
            java.lang.String _localName = parentQName.getLocalPart();

            writeStartElement(null, namespace, _localName, xmlWriter);

            // add the type details if this is used in a simple type
            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://starsystem.sample/");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":Data_recordnum",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "Data_recordnum",
                            xmlWriter);
                }
            }

            if (localData_recordnum == null) {

                throw new org.apache.axis2.databinding.ADBException("Data_recordnum cannot be null !!");

            } else {

                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localData_recordnum));

            }

            xmlWriter.writeEndElement();


        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://starsystem.sample/")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }


        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if (uri == null || uri.length() == 0) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }


        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {


            //We can safely assume an element has only one type associated with it
            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                    new java.lang.Object[]{
                            org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localData_recordnum)
                    },
                    null);

        }


        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {


            public static Data_recordnum fromString(java.lang.String value,
                                                    java.lang.String namespaceURI) {
                Data_recordnum returnValue = new Data_recordnum();

                returnValue.setData_recordnum(
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedShort(value));


                return returnValue;
            }

            public static Data_recordnum fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                                                    java.lang.String content) {
                if (content.indexOf(":") > -1) {
                    java.lang.String prefix = content.substring(0, content.indexOf(":"));
                    java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                    return Data_recordnum.Factory.fromString(content, namespaceUri);
                } else {
                    return Data_recordnum.Factory.fromString(content, "");
                }
            }


            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static Data_recordnum parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                Data_recordnum object =
                        new Data_recordnum();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();


                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();


                    while (!reader.isEndElement()) {
                        if (reader.isStartElement() || reader.hasText()) {

                            if (reader.isStartElement() || reader.hasText()) {

                                nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                                    throw new org.apache.axis2.databinding.ADBException("The element: " + "Data_recordnum" + "  cannot be null");
                                }


                                java.lang.String content = reader.getElementText();

                                object.setData_recordnum(
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedShort(content));

                            }  // End of if for expected property start element

                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop


                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class


    }


    public static class DeleteRecord
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://starsystem.sample/",
                "DeleteRecord",
                "ns1");


        /**
         * field for Dispatcherno
         */


        protected int localDispatcherno;


        /**
         * Auto generated getter method
         * @return int
         */
        public int getDispatcherno() {
            return localDispatcherno;
        }


        /**
         * Auto generated setter method
         * @param param Dispatcherno
         */
        public void setDispatcherno(int param) {

            this.localDispatcherno = param;


        }


        /**
         * field for Idlist
         */


        protected java.lang.String localIdlist;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localIdlistTracker = false;

        public boolean isIdlistSpecified() {
            return localIdlistTracker;
        }


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getIdlist() {
            return localIdlist;
        }


        /**
         * Auto generated setter method
         * @param param Idlist
         */
        public void setIdlist(java.lang.String param) {
            localIdlistTracker = param != null;

            this.localIdlist = param;


        }


        /**
         * field for Starttime
         */


        protected java.lang.String localStarttime;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localStarttimeTracker = false;

        public boolean isStarttimeSpecified() {
            return localStarttimeTracker;
        }


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getStarttime() {
            return localStarttime;
        }


        /**
         * Auto generated setter method
         * @param param Starttime
         */
        public void setStarttime(java.lang.String param) {
            localStarttimeTracker = param != null;

            this.localStarttime = param;


        }


        /**
         * field for Endtime
         */


        protected java.lang.String localEndtime;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localEndtimeTracker = false;

        public boolean isEndtimeSpecified() {
            return localEndtimeTracker;
        }


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getEndtime() {
            return localEndtime;
        }


        /**
         * Auto generated setter method
         * @param param Endtime
         */
        public void setEndtime(java.lang.String param) {
            localEndtimeTracker = param != null;

            this.localEndtime = param;


        }


        /**
         * field for Callernum
         */


        protected Data_callnum localCallernum;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localCallernumTracker = false;

        public boolean isCallernumSpecified() {
            return localCallernumTracker;
        }


        /**
         * Auto generated getter method
         * @return Data_callnum
         */
        public Data_callnum getCallernum() {
            return localCallernum;
        }


        /**
         * Auto generated setter method
         * @param param Callernum
         */
        public void setCallernum(Data_callnum param) {
            localCallernumTracker = param != null;

            this.localCallernum = param;


        }


        /**
         * field for Callednum
         */


        protected Data_callnum localCallednum;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localCallednumTracker = false;

        public boolean isCallednumSpecified() {
            return localCallednumTracker;
        }


        /**
         * Auto generated getter method
         * @return Data_callnum
         */
        public Data_callnum getCallednum() {
            return localCallednum;
        }


        /**
         * Auto generated setter method
         * @param param Callednum
         */
        public void setCallednum(Data_callnum param) {
            localCallednumTracker = param != null;

            this.localCallednum = param;


        }


        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {


            org.apache.axiom.om.OMDataSource dataSource =
                    new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {


            java.lang.String prefix = null;
            java.lang.String namespace = null;


            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

            if (serializeType) {


                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://starsystem.sample/");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":DeleteRecord",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "DeleteRecord",
                            xmlWriter);
                }


            }

            namespace = "http://starsystem.sample/";
            writeStartElement(null, namespace, "dispatcherno", xmlWriter);

            if (localDispatcherno == java.lang.Integer.MIN_VALUE) {

                throw new org.apache.axis2.databinding.ADBException("dispatcherno cannot be null!!");

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDispatcherno));
            }

            xmlWriter.writeEndElement();
            if (localIdlistTracker) {
                namespace = "http://starsystem.sample/";
                writeStartElement(null, namespace, "idlist", xmlWriter);


                if (localIdlist == null) {
                    // write the nil attribute

                    throw new org.apache.axis2.databinding.ADBException("idlist cannot be null!!");

                } else {


                    xmlWriter.writeCharacters(localIdlist);

                }

                xmlWriter.writeEndElement();
            }
            if (localStarttimeTracker) {
                namespace = "http://starsystem.sample/";
                writeStartElement(null, namespace, "starttime", xmlWriter);


                if (localStarttime == null) {
                    // write the nil attribute

                    throw new org.apache.axis2.databinding.ADBException("starttime cannot be null!!");

                } else {


                    xmlWriter.writeCharacters(localStarttime);

                }

                xmlWriter.writeEndElement();
            }
            if (localEndtimeTracker) {
                namespace = "http://starsystem.sample/";
                writeStartElement(null, namespace, "endtime", xmlWriter);


                if (localEndtime == null) {
                    // write the nil attribute

                    throw new org.apache.axis2.databinding.ADBException("endtime cannot be null!!");

                } else {


                    xmlWriter.writeCharacters(localEndtime);

                }

                xmlWriter.writeEndElement();
            }
            if (localCallernumTracker) {
                if (localCallernum == null) {
                    throw new org.apache.axis2.databinding.ADBException("callernum cannot be null!!");
                }
                localCallernum.serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "callernum"),
                        xmlWriter);
            }
            if (localCallednumTracker) {
                if (localCallednum == null) {
                    throw new org.apache.axis2.databinding.ADBException("callednum cannot be null!!");
                }
                localCallednum.serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "callednum"),
                        xmlWriter);
            }
            xmlWriter.writeEndElement();


        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://starsystem.sample/")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }


        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if (uri == null || uri.length() == 0) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }


        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {


            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();


            elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                    "dispatcherno"));

            elementList.add(
                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDispatcherno));
            if (localIdlistTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "idlist"));

                if (localIdlist != null) {
                    elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIdlist));
                } else {
                    throw new org.apache.axis2.databinding.ADBException("idlist cannot be null!!");
                }
            }
            if (localStarttimeTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "starttime"));

                if (localStarttime != null) {
                    elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localStarttime));
                } else {
                    throw new org.apache.axis2.databinding.ADBException("starttime cannot be null!!");
                }
            }
            if (localEndtimeTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "endtime"));

                if (localEndtime != null) {
                    elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEndtime));
                } else {
                    throw new org.apache.axis2.databinding.ADBException("endtime cannot be null!!");
                }
            }
            if (localCallernumTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "callernum"));


                if (localCallernum == null) {
                    throw new org.apache.axis2.databinding.ADBException("callernum cannot be null!!");
                }
                elementList.add(localCallernum);
            }
            if (localCallednumTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "callednum"));


                if (localCallednum == null) {
                    throw new org.apache.axis2.databinding.ADBException("callednum cannot be null!!");
                }
                elementList.add(localCallednum);
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());


        }


        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {


            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static DeleteRecord parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                DeleteRecord object =
                        new DeleteRecord();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();


                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "type");
                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if (!"DeleteRecord".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (DeleteRecord) ExtensionMapper.getTypeObject(
                                        nsUri, type, reader);
                            }


                        }


                    }


                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();


                    reader.next();

                    while (!reader.isEndElement()) {
                        if (reader.isStartElement()) {

                            if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "dispatcherno").equals(reader.getName())) {

                                nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                                    throw new org.apache.axis2.databinding.ADBException("The element: " + "dispatcherno" + "  cannot be null");
                                }


                                java.lang.String content = reader.getElementText();

                                object.setDispatcherno(
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));

                                reader.next();

                            }  // End of if for expected property start element

                            else if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "idlist").equals(reader.getName())) {

                                nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                                    throw new org.apache.axis2.databinding.ADBException("The element: " + "idlist" + "  cannot be null");
                                }


                                java.lang.String content = reader.getElementText();

                                object.setIdlist(
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                reader.next();

                            }  // End of if for expected property start element

                            else if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "starttime").equals(reader.getName())) {

                                nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                                    throw new org.apache.axis2.databinding.ADBException("The element: " + "starttime" + "  cannot be null");
                                }


                                java.lang.String content = reader.getElementText();

                                object.setStarttime(
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                reader.next();

                            }  // End of if for expected property start element

                            else if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "endtime").equals(reader.getName())) {

                                nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                                    throw new org.apache.axis2.databinding.ADBException("The element: " + "endtime" + "  cannot be null");
                                }


                                java.lang.String content = reader.getElementText();

                                object.setEndtime(
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                reader.next();

                            }  // End of if for expected property start element

                            else if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "callernum").equals(reader.getName())) {

                                object.setCallernum(Data_callnum.Factory.parse(reader));

                                reader.next();

                            }  // End of if for expected property start element

                            else if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "callednum").equals(reader.getName())) {

                                object.setCallednum(Data_callnum.Factory.parse(reader));

                                reader.next();

                            }  // End of if for expected property start element

                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop


                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class


    }


    public static class Data_calltype
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://starsystem.sample/",
                "Data_calltype",
                "ns1");


        /**
         * field for Data_calltype
         */


        protected org.apache.axis2.databinding.types.UnsignedByte localData_calltype;

        private static java.util.HashMap _table_ = new java.util.HashMap();

        // Constructor

        protected Data_calltype(org.apache.axis2.databinding.types.UnsignedByte value, boolean isRegisterValue) {
            localData_calltype = value;
            if (isRegisterValue) {

                _table_.put(localData_calltype, this);

            }

        }

        public static final org.apache.axis2.databinding.types.UnsignedByte _value1 =
                org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedByte("0");

        public static final org.apache.axis2.databinding.types.UnsignedByte _value2 =
                org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedByte("1");

        public static final org.apache.axis2.databinding.types.UnsignedByte _value3 =
                org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedByte("2");

        public static final org.apache.axis2.databinding.types.UnsignedByte _value4 =
                org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedByte("3");

        public static final org.apache.axis2.databinding.types.UnsignedByte _value5 =
                org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedByte("4");

        public static final org.apache.axis2.databinding.types.UnsignedByte _value6 =
                org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedByte("5");

        public static final org.apache.axis2.databinding.types.UnsignedByte _value7 =
                org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedByte("6");

        public static final Data_calltype value1 =
                new Data_calltype(_value1, true);

        public static final Data_calltype value2 =
                new Data_calltype(_value2, true);

        public static final Data_calltype value3 =
                new Data_calltype(_value3, true);

        public static final Data_calltype value4 =
                new Data_calltype(_value4, true);

        public static final Data_calltype value5 =
                new Data_calltype(_value5, true);

        public static final Data_calltype value6 =
                new Data_calltype(_value6, true);

        public static final Data_calltype value7 =
                new Data_calltype(_value7, true);


        public org.apache.axis2.databinding.types.UnsignedByte getValue() {
            return localData_calltype;
        }

        public boolean equals(java.lang.Object obj) {
            return (obj == this);
        }

        public int hashCode() {
            return toString().hashCode();
        }

        public java.lang.String toString() {

            return localData_calltype.toString();


        }


        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {


            org.apache.axiom.om.OMDataSource dataSource =
                    new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {


            //We can safely assume an element has only one type associated with it

            java.lang.String namespace = parentQName.getNamespaceURI();
            java.lang.String _localName = parentQName.getLocalPart();

            writeStartElement(null, namespace, _localName, xmlWriter);

            // add the type details if this is used in a simple type
            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://starsystem.sample/");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":Data_calltype",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "Data_calltype",
                            xmlWriter);
                }
            }

            if (localData_calltype == null) {

                throw new org.apache.axis2.databinding.ADBException("Data_calltype cannot be null !!");

            } else {

                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localData_calltype));

            }

            xmlWriter.writeEndElement();


        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://starsystem.sample/")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }


        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if (uri == null || uri.length() == 0) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }


        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {


            //We can safely assume an element has only one type associated with it
            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                    new java.lang.Object[]{
                            org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localData_calltype)
                    },
                    null);

        }


        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {


            public static Data_calltype fromValue(org.apache.axis2.databinding.types.UnsignedByte value)
                    throws java.lang.IllegalArgumentException {
                Data_calltype enumeration = (Data_calltype)

                        _table_.get(value);


                if ((enumeration == null) && !((value == null) || (value.equals("")))) {
                    throw new java.lang.IllegalArgumentException();
                }
                return enumeration;
            }

            public static Data_calltype fromString(java.lang.String value, java.lang.String namespaceURI)
                    throws java.lang.IllegalArgumentException {
                try {

                    return fromValue(org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedByte(value));


                } catch (java.lang.Exception e) {
                    throw new java.lang.IllegalArgumentException();
                }
            }

            public static Data_calltype fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                                                   java.lang.String content) {
                if (content.indexOf(":") > -1) {
                    java.lang.String prefix = content.substring(0, content.indexOf(":"));
                    java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                    return Data_calltype.Factory.fromString(content, namespaceUri);
                } else {
                    return Data_calltype.Factory.fromString(content, "");
                }
            }


            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static Data_calltype parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                Data_calltype object = null;
                // initialize a hash map to keep values
                java.util.Map attributeMap = new java.util.HashMap();
                java.util.List extraAttributeList = new java.util.ArrayList<org.apache.axiom.om.OMAttribute>();


                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();


                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();


                    while (!reader.isEndElement()) {
                        if (reader.isStartElement() || reader.hasText()) {

                            nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                            if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                                throw new org.apache.axis2.databinding.ADBException("The element: " + "Data_calltype" + "  cannot be null");
                            }


                            java.lang.String content = reader.getElementText();

                            if (content.indexOf(":") > 0) {
                                // this seems to be a Qname so find the namespace and send
                                prefix = content.substring(0, content.indexOf(":"));
                                namespaceuri = reader.getNamespaceURI(prefix);
                                object = Data_calltype.Factory.fromString(content, namespaceuri);
                            } else {
                                // this seems to be not a qname send and empty namespace incase of it is
                                // check is done in fromString method
                                object = Data_calltype.Factory.fromString(content, "");
                            }


                        } else {
                            reader.next();
                        }
                    }  // end of while loop


                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class


    }


    public static class CallCdrItemResult_type0
            implements org.apache.axis2.databinding.ADBBean {
        /* This type was generated from the piece of schema that had
                name = CallCdrItemResult_type0
                Namespace URI = http://starsystem.sample/
                Namespace Prefix = ns1
                */


        /**
         * field for Indexno
         */


        protected org.apache.axis2.databinding.types.UnsignedInt localIndexno;


        /**
         * Auto generated getter method
         * @return org.apache.axis2.databinding.types.UnsignedInt
         */
        public org.apache.axis2.databinding.types.UnsignedInt getIndexno() {
            return localIndexno;
        }


        /**
         * Auto generated setter method
         * @param param Indexno
         */
        public void setIndexno(org.apache.axis2.databinding.types.UnsignedInt param) {

            this.localIndexno = param;


        }


        /**
         * field for Callernum
         */


        protected Data_callnum localCallernum;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localCallernumTracker = false;

        public boolean isCallernumSpecified() {
            return localCallernumTracker;
        }


        /**
         * Auto generated getter method
         * @return Data_callnum
         */
        public Data_callnum getCallernum() {
            return localCallernum;
        }


        /**
         * Auto generated setter method
         * @param param Callernum
         */
        public void setCallernum(Data_callnum param) {
            localCallernumTracker = param != null;

            this.localCallernum = param;


        }


        /**
         * field for Callednum
         */


        protected Data_callnum localCallednum;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localCallednumTracker = false;

        public boolean isCallednumSpecified() {
            return localCallednumTracker;
        }


        /**
         * Auto generated getter method
         * @return Data_callnum
         */
        public Data_callnum getCallednum() {
            return localCallednum;
        }


        /**
         * Auto generated setter method
         * @param param Callednum
         */
        public void setCallednum(Data_callnum param) {
            localCallednumTracker = param != null;

            this.localCallednum = param;


        }


        /**
         * field for Thirdcallnum
         */


        protected Data_callnum localThirdcallnum;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localThirdcallnumTracker = false;

        public boolean isThirdcallnumSpecified() {
            return localThirdcallnumTracker;
        }


        /**
         * Auto generated getter method
         * @return Data_callnum
         */
        public Data_callnum getThirdcallnum() {
            return localThirdcallnum;
        }


        /**
         * Auto generated setter method
         * @param param Thirdcallnum
         */
        public void setThirdcallnum(Data_callnum param) {
            localThirdcallnumTracker = param != null;

            this.localThirdcallnum = param;


        }


        /**
         * field for Confname
         */


        protected java.lang.String localConfname;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localConfnameTracker = false;

        public boolean isConfnameSpecified() {
            return localConfnameTracker;
        }


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getConfname() {
            return localConfname;
        }


        /**
         * Auto generated setter method
         * @param param Confname
         */
        public void setConfname(java.lang.String param) {
            localConfnameTracker = param != null;

            this.localConfname = param;


        }


        /**
         * field for Calltype
         */


        protected Data_calltype localCalltype;


        /**
         * Auto generated getter method
         * @return Data_calltype
         */
        public Data_calltype getCalltype() {
            return localCalltype;
        }


        /**
         * Auto generated setter method
         * @param param Calltype
         */
        public void setCalltype(Data_calltype param) {

            this.localCalltype = param;


        }


        /**
         * field for Starttime
         */


        protected java.lang.String localStarttime;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getStarttime() {
            return localStarttime;
        }


        /**
         * Auto generated setter method
         * @param param Starttime
         */
        public void setStarttime(java.lang.String param) {

            this.localStarttime = param;


        }


        /**
         * field for Endtime
         */


        protected java.lang.String localEndtime;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getEndtime() {
            return localEndtime;
        }


        /**
         * Auto generated setter method
         * @param param Endtime
         */
        public void setEndtime(java.lang.String param) {

            this.localEndtime = param;


        }


        /**
         * field for Releasecause
         */


        protected org.apache.axis2.databinding.types.UnsignedShort localReleasecause;


        /**
         * Auto generated getter method
         * @return org.apache.axis2.databinding.types.UnsignedShort
         */
        public org.apache.axis2.databinding.types.UnsignedShort getReleasecause() {
            return localReleasecause;
        }


        /**
         * Auto generated setter method
         * @param param Releasecause
         */
        public void setReleasecause(org.apache.axis2.databinding.types.UnsignedShort param) {

            this.localReleasecause = param;


        }


        /**
         * field for Recordname
         */


        protected java.lang.String localRecordname;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localRecordnameTracker = false;

        public boolean isRecordnameSpecified() {
            return localRecordnameTracker;
        }


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getRecordname() {
            return localRecordname;
        }


        /**
         * Auto generated setter method
         * @param param Recordname
         */
        public void setRecordname(java.lang.String param) {
            localRecordnameTracker = param != null;

            this.localRecordname = param;


        }


        /**
         * field for Recordpath
         */


        protected java.lang.String localRecordpath;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getRecordpath() {
            return localRecordpath;
        }


        /**
         * Auto generated setter method
         * @param param Recordpath
         */
        public void setRecordpath(java.lang.String param) {

            this.localRecordpath = param;


        }


        /**
         * field for Callerarea
         */


        protected java.lang.String localCallerarea;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localCallerareaTracker = false;

        public boolean isCallerareaSpecified() {
            return localCallerareaTracker;
        }


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getCallerarea() {
            return localCallerarea;
        }


        /**
         * Auto generated setter method
         * @param param Callerarea
         */
        public void setCallerarea(java.lang.String param) {
            localCallerareaTracker = param != null;

            this.localCallerarea = param;


        }


        /**
         * field for Calledarea
         */


        protected java.lang.String localCalledarea;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localCalledareaTracker = false;

        public boolean isCalledareaSpecified() {
            return localCalledareaTracker;
        }


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getCalledarea() {
            return localCalledarea;
        }


        /**
         * Auto generated setter method
         * @param param Calledarea
         */
        public void setCalledarea(java.lang.String param) {
            localCalledareaTracker = param != null;

            this.localCalledarea = param;


        }


        /**
         * field for Thirdcallarea
         */


        protected java.lang.String localThirdcallarea;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localThirdcallareaTracker = false;

        public boolean isThirdcallareaSpecified() {
            return localThirdcallareaTracker;
        }


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getThirdcallarea() {
            return localThirdcallarea;
        }


        /**
         * Auto generated setter method
         * @param param Thirdcallarea
         */
        public void setThirdcallarea(java.lang.String param) {
            localThirdcallareaTracker = param != null;

            this.localThirdcallarea = param;


        }


        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {


            org.apache.axiom.om.OMDataSource dataSource =
                    new org.apache.axis2.databinding.ADBDataSource(this, parentQName);
            return factory.createOMElement(dataSource, parentQName);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {


            java.lang.String prefix = null;
            java.lang.String namespace = null;


            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

            if (serializeType) {


                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://starsystem.sample/");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":CallCdrItemResult_type0",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "CallCdrItemResult_type0",
                            xmlWriter);
                }


            }

            namespace = "http://starsystem.sample/";
            writeStartElement(null, namespace, "indexno", xmlWriter);


            if (localIndexno == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException("indexno cannot be null!!");

            } else {


                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIndexno));

            }

            xmlWriter.writeEndElement();
            if (localCallernumTracker) {
                if (localCallernum == null) {
                    throw new org.apache.axis2.databinding.ADBException("callernum cannot be null!!");
                }
                localCallernum.serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "callernum"),
                        xmlWriter);
            }
            if (localCallednumTracker) {
                if (localCallednum == null) {
                    throw new org.apache.axis2.databinding.ADBException("callednum cannot be null!!");
                }
                localCallednum.serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "callednum"),
                        xmlWriter);
            }
            if (localThirdcallnumTracker) {
                if (localThirdcallnum == null) {
                    throw new org.apache.axis2.databinding.ADBException("thirdcallnum cannot be null!!");
                }
                localThirdcallnum.serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "thirdcallnum"),
                        xmlWriter);
            }
            if (localConfnameTracker) {
                namespace = "http://starsystem.sample/";
                writeStartElement(null, namespace, "confname", xmlWriter);


                if (localConfname == null) {
                    // write the nil attribute

                    throw new org.apache.axis2.databinding.ADBException("confname cannot be null!!");

                } else {


                    xmlWriter.writeCharacters(localConfname);

                }

                xmlWriter.writeEndElement();
            }
            if (localCalltype == null) {
                throw new org.apache.axis2.databinding.ADBException("calltype cannot be null!!");
            }
            localCalltype.serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "calltype"),
                    xmlWriter);

            namespace = "http://starsystem.sample/";
            writeStartElement(null, namespace, "starttime", xmlWriter);


            if (localStarttime == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException("starttime cannot be null!!");

            } else {


                xmlWriter.writeCharacters(localStarttime);

            }

            xmlWriter.writeEndElement();

            namespace = "http://starsystem.sample/";
            writeStartElement(null, namespace, "endtime", xmlWriter);


            if (localEndtime == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException("endtime cannot be null!!");

            } else {


                xmlWriter.writeCharacters(localEndtime);

            }

            xmlWriter.writeEndElement();

            namespace = "http://starsystem.sample/";
            writeStartElement(null, namespace, "releasecause", xmlWriter);


            if (localReleasecause == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException("releasecause cannot be null!!");

            } else {


                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localReleasecause));

            }

            xmlWriter.writeEndElement();
            if (localRecordnameTracker) {
                namespace = "http://starsystem.sample/";
                writeStartElement(null, namespace, "recordname", xmlWriter);


                if (localRecordname == null) {
                    // write the nil attribute

                    throw new org.apache.axis2.databinding.ADBException("recordname cannot be null!!");

                } else {


                    xmlWriter.writeCharacters(localRecordname);

                }

                xmlWriter.writeEndElement();
            }
            namespace = "http://starsystem.sample/";
            writeStartElement(null, namespace, "recordpath", xmlWriter);


            if (localRecordpath == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException("recordpath cannot be null!!");

            } else {


                xmlWriter.writeCharacters(localRecordpath);

            }

            xmlWriter.writeEndElement();
            if (localCallerareaTracker) {
                namespace = "http://starsystem.sample/";
                writeStartElement(null, namespace, "callerarea", xmlWriter);


                if (localCallerarea == null) {
                    // write the nil attribute

                    throw new org.apache.axis2.databinding.ADBException("callerarea cannot be null!!");

                } else {


                    xmlWriter.writeCharacters(localCallerarea);

                }

                xmlWriter.writeEndElement();
            }
            if (localCalledareaTracker) {
                namespace = "http://starsystem.sample/";
                writeStartElement(null, namespace, "calledarea", xmlWriter);


                if (localCalledarea == null) {
                    // write the nil attribute

                    throw new org.apache.axis2.databinding.ADBException("calledarea cannot be null!!");

                } else {


                    xmlWriter.writeCharacters(localCalledarea);

                }

                xmlWriter.writeEndElement();
            }
            if (localThirdcallareaTracker) {
                namespace = "http://starsystem.sample/";
                writeStartElement(null, namespace, "thirdcallarea", xmlWriter);


                if (localThirdcallarea == null) {
                    // write the nil attribute

                    throw new org.apache.axis2.databinding.ADBException("thirdcallarea cannot be null!!");

                } else {


                    xmlWriter.writeCharacters(localThirdcallarea);

                }

                xmlWriter.writeEndElement();
            }
            xmlWriter.writeEndElement();


        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://starsystem.sample/")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }


        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if (uri == null || uri.length() == 0) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }


        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {


            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();


            elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                    "indexno"));

            if (localIndexno != null) {
                elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIndexno));
            } else {
                throw new org.apache.axis2.databinding.ADBException("indexno cannot be null!!");
            }
            if (localCallernumTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "callernum"));


                if (localCallernum == null) {
                    throw new org.apache.axis2.databinding.ADBException("callernum cannot be null!!");
                }
                elementList.add(localCallernum);
            }
            if (localCallednumTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "callednum"));


                if (localCallednum == null) {
                    throw new org.apache.axis2.databinding.ADBException("callednum cannot be null!!");
                }
                elementList.add(localCallednum);
            }
            if (localThirdcallnumTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "thirdcallnum"));


                if (localThirdcallnum == null) {
                    throw new org.apache.axis2.databinding.ADBException("thirdcallnum cannot be null!!");
                }
                elementList.add(localThirdcallnum);
            }
            if (localConfnameTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "confname"));

                if (localConfname != null) {
                    elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localConfname));
                } else {
                    throw new org.apache.axis2.databinding.ADBException("confname cannot be null!!");
                }
            }
            elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                    "calltype"));


            if (localCalltype == null) {
                throw new org.apache.axis2.databinding.ADBException("calltype cannot be null!!");
            }
            elementList.add(localCalltype);

            elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                    "starttime"));

            if (localStarttime != null) {
                elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localStarttime));
            } else {
                throw new org.apache.axis2.databinding.ADBException("starttime cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                    "endtime"));

            if (localEndtime != null) {
                elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEndtime));
            } else {
                throw new org.apache.axis2.databinding.ADBException("endtime cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                    "releasecause"));

            if (localReleasecause != null) {
                elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localReleasecause));
            } else {
                throw new org.apache.axis2.databinding.ADBException("releasecause cannot be null!!");
            }
            if (localRecordnameTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "recordname"));

                if (localRecordname != null) {
                    elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRecordname));
                } else {
                    throw new org.apache.axis2.databinding.ADBException("recordname cannot be null!!");
                }
            }
            elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                    "recordpath"));

            if (localRecordpath != null) {
                elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRecordpath));
            } else {
                throw new org.apache.axis2.databinding.ADBException("recordpath cannot be null!!");
            }
            if (localCallerareaTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "callerarea"));

                if (localCallerarea != null) {
                    elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCallerarea));
                } else {
                    throw new org.apache.axis2.databinding.ADBException("callerarea cannot be null!!");
                }
            }
            if (localCalledareaTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "calledarea"));

                if (localCalledarea != null) {
                    elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCalledarea));
                } else {
                    throw new org.apache.axis2.databinding.ADBException("calledarea cannot be null!!");
                }
            }
            if (localThirdcallareaTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "thirdcallarea"));

                if (localThirdcallarea != null) {
                    elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localThirdcallarea));
                } else {
                    throw new org.apache.axis2.databinding.ADBException("thirdcallarea cannot be null!!");
                }
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());


        }


        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {


            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static CallCdrItemResult_type0 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                CallCdrItemResult_type0 object =
                        new CallCdrItemResult_type0();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();


                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "type");
                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if (!"CallCdrItemResult_type0".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (CallCdrItemResult_type0) ExtensionMapper.getTypeObject(
                                        nsUri, type, reader);
                            }


                        }


                    }


                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();


                    reader.next();


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "indexno").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException("The element: " + "indexno" + "  cannot be null");
                        }


                        java.lang.String content = reader.getElementText();

                        object.setIndexno(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedInt(content));

                        reader.next();

                    }  // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "callernum").equals(reader.getName())) {

                        object.setCallernum(Data_callnum.Factory.parse(reader));

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "callednum").equals(reader.getName())) {

                        object.setCallednum(Data_callnum.Factory.parse(reader));

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "thirdcallnum").equals(reader.getName())) {

                        object.setThirdcallnum(Data_callnum.Factory.parse(reader));

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "confname").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException("The element: " + "confname" + "  cannot be null");
                        }


                        java.lang.String content = reader.getElementText();

                        object.setConfname(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "calltype").equals(reader.getName())) {

                        object.setCalltype(Data_calltype.Factory.parse(reader));

                        reader.next();

                    }  // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "starttime").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException("The element: " + "starttime" + "  cannot be null");
                        }


                        java.lang.String content = reader.getElementText();

                        object.setStarttime(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        reader.next();

                    }  // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "endtime").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException("The element: " + "endtime" + "  cannot be null");
                        }


                        java.lang.String content = reader.getElementText();

                        object.setEndtime(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        reader.next();

                    }  // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "releasecause").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException("The element: " + "releasecause" + "  cannot be null");
                        }


                        java.lang.String content = reader.getElementText();

                        object.setReleasecause(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedShort(content));

                        reader.next();

                    }  // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "recordname").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException("The element: " + "recordname" + "  cannot be null");
                        }


                        java.lang.String content = reader.getElementText();

                        object.setRecordname(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "recordpath").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException("The element: " + "recordpath" + "  cannot be null");
                        }


                        java.lang.String content = reader.getElementText();

                        object.setRecordpath(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        reader.next();

                    }  // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "callerarea").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException("The element: " + "callerarea" + "  cannot be null");
                        }


                        java.lang.String content = reader.getElementText();

                        object.setCallerarea(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "calledarea").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException("The element: " + "calledarea" + "  cannot be null");
                        }


                        java.lang.String content = reader.getElementText();

                        object.setCalledarea(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "thirdcallarea").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException("The element: " + "thirdcallarea" + "  cannot be null");
                        }


                        java.lang.String content = reader.getElementText();

                        object.setThirdcallarea(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());


                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class


    }


    public static class DownloadCdr
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://starsystem.sample/",
                "DownloadCdr",
                "ns1");


        /**
         * field for Cdrtype
         */


        protected Data_cdrtype localCdrtype;


        /**
         * Auto generated getter method
         * @return Data_cdrtype
         */
        public Data_cdrtype getCdrtype() {
            return localCdrtype;
        }


        /**
         * Auto generated setter method
         * @param param Cdrtype
         */
        public void setCdrtype(Data_cdrtype param) {

            this.localCdrtype = param;


        }


        /**
         * field for Dispatcherno
         */


        protected org.apache.axis2.databinding.types.UnsignedShort localDispatcherno;


        /**
         * Auto generated getter method
         * @return org.apache.axis2.databinding.types.UnsignedShort
         */
        public org.apache.axis2.databinding.types.UnsignedShort getDispatcherno() {
            return localDispatcherno;
        }


        /**
         * Auto generated setter method
         * @param param Dispatcherno
         */
        public void setDispatcherno(org.apache.axis2.databinding.types.UnsignedShort param) {

            this.localDispatcherno = param;


        }


        /**
         * field for Flag
         */


        protected Data_CondiFlag localFlag;


        /**
         * Auto generated getter method
         * @return Data_CondiFlag
         */
        public Data_CondiFlag getFlag() {
            return localFlag;
        }


        /**
         * Auto generated setter method
         * @param param Flag
         */
        public void setFlag(Data_CondiFlag param) {

            this.localFlag = param;


        }


        /**
         * field for Startid
         */


        protected Data_startid localStartid;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localStartidTracker = false;

        public boolean isStartidSpecified() {
            return localStartidTracker;
        }


        /**
         * Auto generated getter method
         * @return Data_startid
         */
        public Data_startid getStartid() {
            return localStartid;
        }


        /**
         * Auto generated setter method
         * @param param Startid
         */
        public void setStartid(Data_startid param) {
            localStartidTracker = param != null;

            this.localStartid = param;


        }


        /**
         * field for Direction
         */


        protected Data_direction localDirection;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localDirectionTracker = false;

        public boolean isDirectionSpecified() {
            return localDirectionTracker;
        }


        /**
         * Auto generated getter method
         * @return Data_direction
         */
        public Data_direction getDirection() {
            return localDirection;
        }


        /**
         * Auto generated setter method
         * @param param Direction
         */
        public void setDirection(Data_direction param) {
            localDirectionTracker = param != null;

            this.localDirection = param;


        }


        /**
         * field for Starttime
         */


        protected java.lang.String localStarttime;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localStarttimeTracker = false;

        public boolean isStarttimeSpecified() {
            return localStarttimeTracker;
        }


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getStarttime() {
            return localStarttime;
        }


        /**
         * Auto generated setter method
         * @param param Starttime
         */
        public void setStarttime(java.lang.String param) {
            localStarttimeTracker = param != null;

            this.localStarttime = param;


        }


        /**
         * field for Endtime
         */


        protected java.lang.String localEndtime;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localEndtimeTracker = false;

        public boolean isEndtimeSpecified() {
            return localEndtimeTracker;
        }


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getEndtime() {
            return localEndtime;
        }


        /**
         * Auto generated setter method
         * @param param Endtime
         */
        public void setEndtime(java.lang.String param) {
            localEndtimeTracker = param != null;

            this.localEndtime = param;


        }


        /**
         * field for Callernum
         */


        protected Data_callnum localCallernum;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localCallernumTracker = false;

        public boolean isCallernumSpecified() {
            return localCallernumTracker;
        }


        /**
         * Auto generated getter method
         * @return Data_callnum
         */
        public Data_callnum getCallernum() {
            return localCallernum;
        }


        /**
         * Auto generated setter method
         * @param param Callernum
         */
        public void setCallernum(Data_callnum param) {
            localCallernumTracker = param != null;

            this.localCallernum = param;


        }


        /**
         * field for Callednum
         */


        protected Data_callnum localCallednum;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localCallednumTracker = false;

        public boolean isCallednumSpecified() {
            return localCallednumTracker;
        }


        /**
         * Auto generated getter method
         * @return Data_callnum
         */
        public Data_callnum getCallednum() {
            return localCallednum;
        }


        /**
         * Auto generated setter method
         * @param param Callednum
         */
        public void setCallednum(Data_callnum param) {
            localCallednumTracker = param != null;

            this.localCallednum = param;


        }


        /**
         * field for Servicetype
         */


        protected Data_servicetype localServicetype;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localServicetypeTracker = false;

        public boolean isServicetypeSpecified() {
            return localServicetypeTracker;
        }


        /**
         * Auto generated getter method
         * @return Data_servicetype
         */
        public Data_servicetype getServicetype() {
            return localServicetype;
        }


        /**
         * Auto generated setter method
         * @param param Servicetype
         */
        public void setServicetype(Data_servicetype param) {
            localServicetypeTracker = param != null;

            this.localServicetype = param;


        }


        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {


            org.apache.axiom.om.OMDataSource dataSource =
                    new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {


            java.lang.String prefix = null;
            java.lang.String namespace = null;


            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

            if (serializeType) {


                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://starsystem.sample/");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":DownloadCdr",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "DownloadCdr",
                            xmlWriter);
                }


            }

            if (localCdrtype == null) {
                throw new org.apache.axis2.databinding.ADBException("cdrtype cannot be null!!");
            }
            localCdrtype.serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "cdrtype"),
                    xmlWriter);

            namespace = "http://starsystem.sample/";
            writeStartElement(null, namespace, "dispatcherno", xmlWriter);


            if (localDispatcherno == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException("dispatcherno cannot be null!!");

            } else {


                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDispatcherno));

            }

            xmlWriter.writeEndElement();

            if (localFlag == null) {
                throw new org.apache.axis2.databinding.ADBException("flag cannot be null!!");
            }
            localFlag.serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "flag"),
                    xmlWriter);
            if (localStartidTracker) {
                if (localStartid == null) {
                    throw new org.apache.axis2.databinding.ADBException("startid cannot be null!!");
                }
                localStartid.serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "startid"),
                        xmlWriter);
            }
            if (localDirectionTracker) {
                if (localDirection == null) {
                    throw new org.apache.axis2.databinding.ADBException("direction cannot be null!!");
                }
                localDirection.serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "direction"),
                        xmlWriter);
            }
            if (localStarttimeTracker) {
                namespace = "http://starsystem.sample/";
                writeStartElement(null, namespace, "starttime", xmlWriter);


                if (localStarttime == null) {
                    // write the nil attribute

                    throw new org.apache.axis2.databinding.ADBException("starttime cannot be null!!");

                } else {


                    xmlWriter.writeCharacters(localStarttime);

                }

                xmlWriter.writeEndElement();
            }
            if (localEndtimeTracker) {
                namespace = "http://starsystem.sample/";
                writeStartElement(null, namespace, "endtime", xmlWriter);


                if (localEndtime == null) {
                    // write the nil attribute

                    throw new org.apache.axis2.databinding.ADBException("endtime cannot be null!!");

                } else {


                    xmlWriter.writeCharacters(localEndtime);

                }

                xmlWriter.writeEndElement();
            }
            if (localCallernumTracker) {
                if (localCallernum == null) {
                    throw new org.apache.axis2.databinding.ADBException("callernum cannot be null!!");
                }
                localCallernum.serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "callernum"),
                        xmlWriter);
            }
            if (localCallednumTracker) {
                if (localCallednum == null) {
                    throw new org.apache.axis2.databinding.ADBException("callednum cannot be null!!");
                }
                localCallednum.serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "callednum"),
                        xmlWriter);
            }
            if (localServicetypeTracker) {
                if (localServicetype == null) {
                    throw new org.apache.axis2.databinding.ADBException("servicetype cannot be null!!");
                }
                localServicetype.serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "servicetype"),
                        xmlWriter);
            }
            xmlWriter.writeEndElement();


        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://starsystem.sample/")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }


        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if (uri == null || uri.length() == 0) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }


        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {


            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();


            elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                    "cdrtype"));


            if (localCdrtype == null) {
                throw new org.apache.axis2.databinding.ADBException("cdrtype cannot be null!!");
            }
            elementList.add(localCdrtype);

            elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                    "dispatcherno"));

            if (localDispatcherno != null) {
                elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDispatcherno));
            } else {
                throw new org.apache.axis2.databinding.ADBException("dispatcherno cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                    "flag"));


            if (localFlag == null) {
                throw new org.apache.axis2.databinding.ADBException("flag cannot be null!!");
            }
            elementList.add(localFlag);
            if (localStartidTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "startid"));


                if (localStartid == null) {
                    throw new org.apache.axis2.databinding.ADBException("startid cannot be null!!");
                }
                elementList.add(localStartid);
            }
            if (localDirectionTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "direction"));


                if (localDirection == null) {
                    throw new org.apache.axis2.databinding.ADBException("direction cannot be null!!");
                }
                elementList.add(localDirection);
            }
            if (localStarttimeTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "starttime"));

                if (localStarttime != null) {
                    elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localStarttime));
                } else {
                    throw new org.apache.axis2.databinding.ADBException("starttime cannot be null!!");
                }
            }
            if (localEndtimeTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "endtime"));

                if (localEndtime != null) {
                    elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEndtime));
                } else {
                    throw new org.apache.axis2.databinding.ADBException("endtime cannot be null!!");
                }
            }
            if (localCallernumTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "callernum"));


                if (localCallernum == null) {
                    throw new org.apache.axis2.databinding.ADBException("callernum cannot be null!!");
                }
                elementList.add(localCallernum);
            }
            if (localCallednumTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "callednum"));


                if (localCallednum == null) {
                    throw new org.apache.axis2.databinding.ADBException("callednum cannot be null!!");
                }
                elementList.add(localCallednum);
            }
            if (localServicetypeTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "servicetype"));


                if (localServicetype == null) {
                    throw new org.apache.axis2.databinding.ADBException("servicetype cannot be null!!");
                }
                elementList.add(localServicetype);
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());


        }


        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {


            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static DownloadCdr parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                DownloadCdr object =
                        new DownloadCdr();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();


                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "type");
                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if (!"DownloadCdr".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (DownloadCdr) ExtensionMapper.getTypeObject(
                                        nsUri, type, reader);
                            }


                        }


                    }


                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();


                    reader.next();

                    while (!reader.isEndElement()) {
                        if (reader.isStartElement()) {

                            if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "cdrtype").equals(reader.getName())) {

                                object.setCdrtype(Data_cdrtype.Factory.parse(reader));

                                reader.next();

                            }  // End of if for expected property start element

                            else if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "dispatcherno").equals(reader.getName())) {

                                nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                                    throw new org.apache.axis2.databinding.ADBException("The element: " + "dispatcherno" + "  cannot be null");
                                }


                                java.lang.String content = reader.getElementText();

                                object.setDispatcherno(
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedShort(content));

                                reader.next();

                            }  // End of if for expected property start element

                            else if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "flag").equals(reader.getName())) {

                                object.setFlag(Data_CondiFlag.Factory.parse(reader));

                                reader.next();

                            }  // End of if for expected property start element

                            else if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "startid").equals(reader.getName())) {

                                object.setStartid(Data_startid.Factory.parse(reader));

                                reader.next();

                            }  // End of if for expected property start element

                            else if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "direction").equals(reader.getName())) {

                                object.setDirection(Data_direction.Factory.parse(reader));

                                reader.next();

                            }  // End of if for expected property start element

                            else if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "starttime").equals(reader.getName())) {

                                nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                                    throw new org.apache.axis2.databinding.ADBException("The element: " + "starttime" + "  cannot be null");
                                }


                                java.lang.String content = reader.getElementText();

                                object.setStarttime(
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                reader.next();

                            }  // End of if for expected property start element

                            else if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "endtime").equals(reader.getName())) {

                                nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                                    throw new org.apache.axis2.databinding.ADBException("The element: " + "endtime" + "  cannot be null");
                                }


                                java.lang.String content = reader.getElementText();

                                object.setEndtime(
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                reader.next();

                            }  // End of if for expected property start element

                            else if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "callernum").equals(reader.getName())) {

                                object.setCallernum(Data_callnum.Factory.parse(reader));

                                reader.next();

                            }  // End of if for expected property start element

                            else if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "callednum").equals(reader.getName())) {

                                object.setCallednum(Data_callnum.Factory.parse(reader));

                                reader.next();

                            }  // End of if for expected property start element

                            else if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "servicetype").equals(reader.getName())) {

                                object.setServicetype(Data_servicetype.Factory.parse(reader));

                                reader.next();

                            }  // End of if for expected property start element

                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop


                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class


    }


    public static class DeleteRecordResponse
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://starsystem.sample/",
                "DeleteRecordResponse",
                "ns1");


        /**
         * field for Returnflag
         */


        protected Data_returnflag localReturnflag;


        /**
         * Auto generated getter method
         * @return Data_returnflag
         */
        public Data_returnflag getReturnflag() {
            return localReturnflag;
        }


        /**
         * Auto generated setter method
         * @param param Returnflag
         */
        public void setReturnflag(Data_returnflag param) {

            this.localReturnflag = param;


        }


        /**
         * field for Totalnum
         */


        protected org.apache.axis2.databinding.types.UnsignedInt localTotalnum;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localTotalnumTracker = false;

        public boolean isTotalnumSpecified() {
            return localTotalnumTracker;
        }


        /**
         * Auto generated getter method
         * @return org.apache.axis2.databinding.types.UnsignedInt
         */
        public org.apache.axis2.databinding.types.UnsignedInt getTotalnum() {
            return localTotalnum;
        }


        /**
         * Auto generated setter method
         * @param param Totalnum
         */
        public void setTotalnum(org.apache.axis2.databinding.types.UnsignedInt param) {
            localTotalnumTracker = param != null;

            this.localTotalnum = param;


        }


        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {


            org.apache.axiom.om.OMDataSource dataSource =
                    new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {


            java.lang.String prefix = null;
            java.lang.String namespace = null;


            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

            if (serializeType) {


                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://starsystem.sample/");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":DeleteRecordResponse",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "DeleteRecordResponse",
                            xmlWriter);
                }


            }

            if (localReturnflag == null) {
                throw new org.apache.axis2.databinding.ADBException("returnflag cannot be null!!");
            }
            localReturnflag.serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "returnflag"),
                    xmlWriter);
            if (localTotalnumTracker) {
                namespace = "http://starsystem.sample/";
                writeStartElement(null, namespace, "totalnum", xmlWriter);


                if (localTotalnum == null) {
                    // write the nil attribute

                    throw new org.apache.axis2.databinding.ADBException("totalnum cannot be null!!");

                } else {


                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTotalnum));

                }

                xmlWriter.writeEndElement();
            }
            xmlWriter.writeEndElement();


        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://starsystem.sample/")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }


        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if (uri == null || uri.length() == 0) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }


        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {


            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();


            elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                    "returnflag"));


            if (localReturnflag == null) {
                throw new org.apache.axis2.databinding.ADBException("returnflag cannot be null!!");
            }
            elementList.add(localReturnflag);
            if (localTotalnumTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "totalnum"));

                if (localTotalnum != null) {
                    elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTotalnum));
                } else {
                    throw new org.apache.axis2.databinding.ADBException("totalnum cannot be null!!");
                }
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());


        }


        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {


            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static DeleteRecordResponse parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                DeleteRecordResponse object =
                        new DeleteRecordResponse();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();


                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "type");
                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if (!"DeleteRecordResponse".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (DeleteRecordResponse) ExtensionMapper.getTypeObject(
                                        nsUri, type, reader);
                            }


                        }


                    }


                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();


                    reader.next();


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "returnflag").equals(reader.getName())) {

                        object.setReturnflag(Data_returnflag.Factory.parse(reader));

                        reader.next();

                    }  // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "totalnum").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException("The element: " + "totalnum" + "  cannot be null");
                        }


                        java.lang.String content = reader.getElementText();

                        object.setTotalnum(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedInt(content));

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());


                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class


    }


    public static class QueryCdrResponse
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://starsystem.sample/",
                "QueryCdrResponse",
                "ns1");


        /**
         * field for Returnflag
         */


        protected Data_returnflag localReturnflag;


        /**
         * Auto generated getter method
         * @return Data_returnflag
         */
        public Data_returnflag getReturnflag() {
            return localReturnflag;
        }


        /**
         * Auto generated setter method
         * @param param Returnflag
         */
        public void setReturnflag(Data_returnflag param) {

            this.localReturnflag = param;


        }


        /**
         * field for Totalnum
         */


        protected org.apache.axis2.databinding.types.UnsignedInt localTotalnum;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localTotalnumTracker = false;

        public boolean isTotalnumSpecified() {
            return localTotalnumTracker;
        }


        /**
         * Auto generated getter method
         * @return org.apache.axis2.databinding.types.UnsignedInt
         */
        public org.apache.axis2.databinding.types.UnsignedInt getTotalnum() {
            return localTotalnum;
        }


        /**
         * Auto generated setter method
         * @param param Totalnum
         */
        public void setTotalnum(org.apache.axis2.databinding.types.UnsignedInt param) {
            localTotalnumTracker = param != null;

            this.localTotalnum = param;


        }


        /**
         * field for Recordnum
         */


        protected org.apache.axis2.databinding.types.UnsignedShort localRecordnum;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localRecordnumTracker = false;

        public boolean isRecordnumSpecified() {
            return localRecordnumTracker;
        }


        /**
         * Auto generated getter method
         * @return org.apache.axis2.databinding.types.UnsignedShort
         */
        public org.apache.axis2.databinding.types.UnsignedShort getRecordnum() {
            return localRecordnum;
        }


        /**
         * Auto generated setter method
         * @param param Recordnum
         */
        public void setRecordnum(org.apache.axis2.databinding.types.UnsignedShort param) {
            localRecordnumTracker = param != null;

            this.localRecordnum = param;


        }


        /**
         * field for QueryCdrResponseChoice_type0
         */


        protected QueryCdrResponseChoice_type0 localQueryCdrResponseChoice_type0;


        /**
         * Auto generated getter method
         * @return QueryCdrResponseChoice_type0
         */
        public QueryCdrResponseChoice_type0 getQueryCdrResponseChoice_type0() {
            return localQueryCdrResponseChoice_type0;
        }


        /**
         * Auto generated setter method
         * @param param QueryCdrResponseChoice_type0
         */
        public void setQueryCdrResponseChoice_type0(QueryCdrResponseChoice_type0 param) {

            this.localQueryCdrResponseChoice_type0 = param;


        }


        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {


            org.apache.axiom.om.OMDataSource dataSource =
                    new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {


            java.lang.String prefix = null;
            java.lang.String namespace = null;


            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

            if (serializeType) {


                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://starsystem.sample/");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":QueryCdrResponse",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "QueryCdrResponse",
                            xmlWriter);
                }


            }

            if (localReturnflag == null) {
                throw new org.apache.axis2.databinding.ADBException("returnflag cannot be null!!");
            }
            localReturnflag.serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "returnflag"),
                    xmlWriter);
            if (localTotalnumTracker) {
                namespace = "http://starsystem.sample/";
                writeStartElement(null, namespace, "totalnum", xmlWriter);


                if (localTotalnum == null) {
                    // write the nil attribute

                    throw new org.apache.axis2.databinding.ADBException("totalnum cannot be null!!");

                } else {


                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTotalnum));

                }

                xmlWriter.writeEndElement();
            }
            if (localRecordnumTracker) {
                namespace = "http://starsystem.sample/";
                writeStartElement(null, namespace, "recordnum", xmlWriter);


                if (localRecordnum == null) {
                    // write the nil attribute

                    throw new org.apache.axis2.databinding.ADBException("recordnum cannot be null!!");

                } else {


                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRecordnum));

                }

                xmlWriter.writeEndElement();
            }
            if (localQueryCdrResponseChoice_type0 == null) {
                throw new org.apache.axis2.databinding.ADBException("QueryCdrResponseChoice_type0 cannot be null!!");
            }
            localQueryCdrResponseChoice_type0.serialize(null, xmlWriter);

            xmlWriter.writeEndElement();


        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://starsystem.sample/")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }


        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if (uri == null || uri.length() == 0) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }


        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {


            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();


            elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                    "returnflag"));


            if (localReturnflag == null) {
                throw new org.apache.axis2.databinding.ADBException("returnflag cannot be null!!");
            }
            elementList.add(localReturnflag);
            if (localTotalnumTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "totalnum"));

                if (localTotalnum != null) {
                    elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTotalnum));
                } else {
                    throw new org.apache.axis2.databinding.ADBException("totalnum cannot be null!!");
                }
            }
            if (localRecordnumTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "recordnum"));

                if (localRecordnum != null) {
                    elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRecordnum));
                } else {
                    throw new org.apache.axis2.databinding.ADBException("recordnum cannot be null!!");
                }
            }
            elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                    "QueryCdrResponseChoice_type0"));


            if (localQueryCdrResponseChoice_type0 == null) {
                throw new org.apache.axis2.databinding.ADBException("QueryCdrResponseChoice_type0 cannot be null!!");
            }
            elementList.add(localQueryCdrResponseChoice_type0);


            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());


        }


        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {


            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static QueryCdrResponse parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                QueryCdrResponse object =
                        new QueryCdrResponse();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();


                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "type");
                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if (!"QueryCdrResponse".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (QueryCdrResponse) ExtensionMapper.getTypeObject(
                                        nsUri, type, reader);
                            }


                        }


                    }


                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();


                    reader.next();


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "returnflag").equals(reader.getName())) {

                        object.setReturnflag(Data_returnflag.Factory.parse(reader));

                        reader.next();

                    }  // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "totalnum").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException("The element: " + "totalnum" + "  cannot be null");
                        }


                        java.lang.String content = reader.getElementText();

                        object.setTotalnum(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedInt(content));

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "recordnum").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException("The element: " + "recordnum" + "  cannot be null");
                        }


                        java.lang.String content = reader.getElementText();

                        object.setRecordnum(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedShort(content));

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement()) {

                        object.setQueryCdrResponseChoice_type0(QueryCdrResponseChoice_type0.Factory.parse(reader));

                    }  // End of if for expected property start element

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());


                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class


    }


    public static class Data_direction
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://starsystem.sample/",
                "Data_direction",
                "ns1");


        /**
         * field for Data_direction
         */


        protected org.apache.axis2.databinding.types.UnsignedByte localData_direction;


        /**
         * Auto generated getter method
         * @return org.apache.axis2.databinding.types.UnsignedByte
         */
        public org.apache.axis2.databinding.types.UnsignedByte getData_direction() {
            return localData_direction;
        }


        /**
         * Auto generated setter method
         * @param param Data_direction
         */
        public void setData_direction(org.apache.axis2.databinding.types.UnsignedByte param) {

            if (org.apache.axis2.databinding.utils.ConverterUtil.convertToString(param).matches("0")) {
                this.localData_direction = param;
            } else {
                throw new java.lang.RuntimeException();
            }


        }


        public java.lang.String toString() {

            return localData_direction.toString();

        }


        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {


            org.apache.axiom.om.OMDataSource dataSource =
                    new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {


            //We can safely assume an element has only one type associated with it

            java.lang.String namespace = parentQName.getNamespaceURI();
            java.lang.String _localName = parentQName.getLocalPart();

            writeStartElement(null, namespace, _localName, xmlWriter);

            // add the type details if this is used in a simple type
            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://starsystem.sample/");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":Data_direction",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "Data_direction",
                            xmlWriter);
                }
            }

            if (localData_direction == null) {

                throw new org.apache.axis2.databinding.ADBException("Data_direction cannot be null !!");

            } else {

                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localData_direction));

            }

            xmlWriter.writeEndElement();


        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://starsystem.sample/")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }


        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if (uri == null || uri.length() == 0) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }


        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {


            //We can safely assume an element has only one type associated with it
            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                    new java.lang.Object[]{
                            org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localData_direction)
                    },
                    null);

        }


        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {


            public static Data_direction fromString(java.lang.String value,
                                                    java.lang.String namespaceURI) {
                Data_direction returnValue = new Data_direction();

                returnValue.setData_direction(
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedByte(value));


                return returnValue;
            }

            public static Data_direction fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                                                    java.lang.String content) {
                if (content.indexOf(":") > -1) {
                    java.lang.String prefix = content.substring(0, content.indexOf(":"));
                    java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                    return Data_direction.Factory.fromString(content, namespaceUri);
                } else {
                    return Data_direction.Factory.fromString(content, "");
                }
            }


            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static Data_direction parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                Data_direction object =
                        new Data_direction();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();


                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();


                    while (!reader.isEndElement()) {
                        if (reader.isStartElement() || reader.hasText()) {

                            if (reader.isStartElement() || reader.hasText()) {

                                nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                                    throw new org.apache.axis2.databinding.ADBException("The element: " + "Data_direction" + "  cannot be null");
                                }


                                java.lang.String content = reader.getElementText();

                                object.setData_direction(
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedByte(content));

                            }  // End of if for expected property start element

                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop


                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class


    }


    public static class Data_callnum
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://starsystem.sample/",
                "Data_callnum",
                "ns1");


        /**
         * field for Data_callnum
         */


        protected java.lang.String localData_callnum;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getData_callnum() {
            return localData_callnum;
        }


        /**
         * Auto generated setter method
         * @param param Data_callnum
         */
        public void setData_callnum(java.lang.String param) {

            if (null == param || "".equals(param)) {
                this.localData_callnum = param;
            } else {
                if (org.apache.axis2.databinding.utils.ConverterUtil.convertToString(param).matches("[0-9]{1,24}")) {
                    this.localData_callnum = param;
                } else {
                    throw new java.lang.RuntimeException();
                }
            }


        }


        public java.lang.String toString() {

            return localData_callnum.toString();

        }


        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {


            org.apache.axiom.om.OMDataSource dataSource =
                    new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {


            //We can safely assume an element has only one type associated with it

            java.lang.String namespace = parentQName.getNamespaceURI();
            java.lang.String _localName = parentQName.getLocalPart();

            writeStartElement(null, namespace, _localName, xmlWriter);

            // add the type details if this is used in a simple type
            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://starsystem.sample/");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":Data_callnum",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "Data_callnum",
                            xmlWriter);
                }
            }

            if (localData_callnum == null) {

                throw new org.apache.axis2.databinding.ADBException("Data_callnum cannot be null !!");

            } else {

                xmlWriter.writeCharacters(localData_callnum);

            }

            xmlWriter.writeEndElement();


        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://starsystem.sample/")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }


        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if (uri == null || uri.length() == 0) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }


        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {


            //We can safely assume an element has only one type associated with it
            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                    new java.lang.Object[]{
                            org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localData_callnum)
                    },
                    null);

        }


        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {


            public static Data_callnum fromString(java.lang.String value,
                                                  java.lang.String namespaceURI) {
                Data_callnum returnValue = new Data_callnum();

                returnValue.setData_callnum(
                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(value));


                return returnValue;
            }

            public static Data_callnum fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                                                  java.lang.String content) {
                if (content.indexOf(":") > -1) {
                    java.lang.String prefix = content.substring(0, content.indexOf(":"));
                    java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                    return Data_callnum.Factory.fromString(content, namespaceUri);
                } else {
                    return Data_callnum.Factory.fromString(content, "");
                }
            }


            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static Data_callnum parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                Data_callnum object =
                        new Data_callnum();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();


                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();

                    //修改过
                    if (!reader.hasText()) {
                        object.setData_callnum("");
                        reader.next();
                    } else {

                        while (!reader.isEndElement()) {
                            if (reader.isStartElement() || reader.hasText()) {

                                if (reader.isStartElement() || reader.hasText()) {

                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                                        throw new org.apache.axis2.databinding.ADBException("The element: " + "Data_callnum" + "  cannot be null");
                                    }


                                    java.lang.String content = reader.getElementText();

                                    object.setData_callnum(
                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                }  // End of if for expected property start element

                                else {
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                                }

                            } else {
                                reader.next();
                            }
                        }  // end of while loop


                    }
                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class


    }


    public static class ServiceCdrItemResult_type0
            implements org.apache.axis2.databinding.ADBBean {
        /* This type was generated from the piece of schema that had
                name = ServiceCdrItemResult_type0
                Namespace URI = http://starsystem.sample/
                Namespace Prefix = ns1
                */


        /**
         * field for Indexno
         */


        protected org.apache.axis2.databinding.types.UnsignedInt localIndexno;


        /**
         * Auto generated getter method
         * @return org.apache.axis2.databinding.types.UnsignedInt
         */
        public org.apache.axis2.databinding.types.UnsignedInt getIndexno() {
            return localIndexno;
        }


        /**
         * Auto generated setter method
         * @param param Indexno
         */
        public void setIndexno(org.apache.axis2.databinding.types.UnsignedInt param) {

            this.localIndexno = param;


        }


        /**
         * field for Callernum
         */


        protected Data_callnum localCallernum;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localCallernumTracker = false;

        public boolean isCallernumSpecified() {
            return localCallernumTracker;
        }


        /**
         * Auto generated getter method
         * @return Data_callnum
         */
        public Data_callnum getCallernum() {
            return localCallernum;
        }


        /**
         * Auto generated setter method
         * @param param Callernum
         */
        public void setCallernum(Data_callnum param) {
            localCallernumTracker = param != null;

            this.localCallernum = param;


        }


        /**
         * field for Callednum
         */


        protected Data_callnum localCallednum;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localCallednumTracker = false;

        public boolean isCallednumSpecified() {
            return localCallednumTracker;
        }


        /**
         * Auto generated getter method
         * @return Data_callnum
         */
        public Data_callnum getCallednum() {
            return localCallednum;
        }


        /**
         * Auto generated setter method
         * @param param Callednum
         */
        public void setCallednum(Data_callnum param) {
            localCallednumTracker = param != null;

            this.localCallednum = param;


        }


        /**
         * field for Thirdcallnum
         */


        protected Data_callnum localThirdcallnum;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localThirdcallnumTracker = false;

        public boolean isThirdcallnumSpecified() {
            return localThirdcallnumTracker;
        }


        /**
         * Auto generated getter method
         * @return Data_callnum
         */
        public Data_callnum getThirdcallnum() {
            return localThirdcallnum;
        }


        /**
         * Auto generated setter method
         * @param param Thirdcallnum
         */
        public void setThirdcallnum(Data_callnum param) {
            localThirdcallnumTracker = param != null;

            this.localThirdcallnum = param;


        }


        /**
         * field for Holdnum
         */


        protected Data_callnum localHoldnum;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localHoldnumTracker = false;

        public boolean isHoldnumSpecified() {
            return localHoldnumTracker;
        }


        /**
         * Auto generated getter method
         * @return Data_callnum
         */
        public Data_callnum getHoldnum() {
            return localHoldnum;
        }


        /**
         * Auto generated setter method
         * @param param Holdnum
         */
        public void setHoldnum(Data_callnum param) {
            localHoldnumTracker = param != null;

            this.localHoldnum = param;


        }


        /**
         * field for Finsertnum
         */


        protected Data_callnum localFinsertnum;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localFinsertnumTracker = false;

        public boolean isFinsertnumSpecified() {
            return localFinsertnumTracker;
        }


        /**
         * Auto generated getter method
         * @return Data_callnum
         */
        public Data_callnum getFinsertnum() {
            return localFinsertnum;
        }


        /**
         * Auto generated setter method
         * @param param Finsertnum
         */
        public void setFinsertnum(Data_callnum param) {
            localFinsertnumTracker = param != null;

            this.localFinsertnum = param;


        }


        /**
         * field for Finsertednum
         */


        protected Data_callnum localFinsertednum;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localFinsertednumTracker = false;

        public boolean isFinsertednumSpecified() {
            return localFinsertednumTracker;
        }


        /**
         * Auto generated getter method
         * @return Data_callnum
         */
        public Data_callnum getFinsertednum() {
            return localFinsertednum;
        }


        /**
         * Auto generated setter method
         * @param param Finsertednum
         */
        public void setFinsertednum(Data_callnum param) {
            localFinsertednumTracker = param != null;

            this.localFinsertednum = param;


        }


        /**
         * field for Transfernum
         */


        protected Data_callnum localTransfernum;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localTransfernumTracker = false;

        public boolean isTransfernumSpecified() {
            return localTransfernumTracker;
        }


        /**
         * Auto generated getter method
         * @return Data_callnum
         */
        public Data_callnum getTransfernum() {
            return localTransfernum;
        }


        /**
         * Auto generated setter method
         * @param param Transfernum
         */
        public void setTransfernum(Data_callnum param) {
            localTransfernumTracker = param != null;

            this.localTransfernum = param;


        }


        /**
         * field for Transferednum
         */


        protected Data_callnum localTransferednum;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localTransferednumTracker = false;

        public boolean isTransferednumSpecified() {
            return localTransferednumTracker;
        }


        /**
         * Auto generated getter method
         * @return Data_callnum
         */
        public Data_callnum getTransferednum() {
            return localTransferednum;
        }


        /**
         * Auto generated setter method
         * @param param Transferednum
         */
        public void setTransferednum(Data_callnum param) {
            localTransferednumTracker = param != null;

            this.localTransferednum = param;


        }


        /**
         * field for Confnum
         */


        protected Data_callnum localConfnum;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localConfnumTracker = false;

        public boolean isConfnumSpecified() {
            return localConfnumTracker;
        }


        /**
         * Auto generated getter method
         * @return Data_callnum
         */
        public Data_callnum getConfnum() {
            return localConfnum;
        }


        /**
         * Auto generated setter method
         * @param param Confnum
         */
        public void setConfnum(Data_callnum param) {
            localConfnumTracker = param != null;

            this.localConfnum = param;


        }


        /**
         * field for Confname
         */


        protected java.lang.String localConfname;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localConfnameTracker = false;

        public boolean isConfnameSpecified() {
            return localConfnameTracker;
        }


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getConfname() {
            return localConfname;
        }


        /**
         * Auto generated setter method
         * @param param Confname
         */
        public void setConfname(java.lang.String param) {
            localConfnameTracker = param != null;

            this.localConfname = param;


        }


        /**
         * field for Servicetype
         */


        protected Data_servicetype localServicetype;


        /**
         * Auto generated getter method
         * @return Data_servicetype
         */
        public Data_servicetype getServicetype() {
            return localServicetype;
        }


        /**
         * Auto generated setter method
         * @param param Servicetype
         */
        public void setServicetype(Data_servicetype param) {

            this.localServicetype = param;


        }


        /**
         * field for Starttime
         */


        protected java.lang.String localStarttime;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getStarttime() {
            return localStarttime;
        }


        /**
         * Auto generated setter method
         * @param param Starttime
         */
        public void setStarttime(java.lang.String param) {

            this.localStarttime = param;


        }


        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {


            org.apache.axiom.om.OMDataSource dataSource =
                    new org.apache.axis2.databinding.ADBDataSource(this, parentQName);
            return factory.createOMElement(dataSource, parentQName);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {


            java.lang.String prefix = null;
            java.lang.String namespace = null;


            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

            if (serializeType) {


                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://starsystem.sample/");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":ServiceCdrItemResult_type0",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "ServiceCdrItemResult_type0",
                            xmlWriter);
                }


            }

            namespace = "http://starsystem.sample/";
            writeStartElement(null, namespace, "indexno", xmlWriter);


            if (localIndexno == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException("indexno cannot be null!!");

            } else {


                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIndexno));

            }

            xmlWriter.writeEndElement();
            if (localCallernumTracker) {
                if (localCallernum == null) {
                    throw new org.apache.axis2.databinding.ADBException("callernum cannot be null!!");
                }
                localCallernum.serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "callernum"),
                        xmlWriter);
            }
            if (localCallednumTracker) {
                if (localCallednum == null) {
                    throw new org.apache.axis2.databinding.ADBException("callednum cannot be null!!");
                }
                localCallednum.serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "callednum"),
                        xmlWriter);
            }
            if (localThirdcallnumTracker) {
                if (localThirdcallnum == null) {
                    throw new org.apache.axis2.databinding.ADBException("thirdcallnum cannot be null!!");
                }
                localThirdcallnum.serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "thirdcallnum"),
                        xmlWriter);
            }
            if (localHoldnumTracker) {
                if (localHoldnum == null) {
                    throw new org.apache.axis2.databinding.ADBException("holdnum cannot be null!!");
                }
                localHoldnum.serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "holdnum"),
                        xmlWriter);
            }
            if (localFinsertnumTracker) {
                if (localFinsertnum == null) {
                    throw new org.apache.axis2.databinding.ADBException("finsertnum cannot be null!!");
                }
                localFinsertnum.serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "finsertnum"),
                        xmlWriter);
            }
            if (localFinsertednumTracker) {
                if (localFinsertednum == null) {
                    throw new org.apache.axis2.databinding.ADBException("finsertednum cannot be null!!");
                }
                localFinsertednum.serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "finsertednum"),
                        xmlWriter);
            }
            if (localTransfernumTracker) {
                if (localTransfernum == null) {
                    throw new org.apache.axis2.databinding.ADBException("transfernum cannot be null!!");
                }
                localTransfernum.serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "transfernum"),
                        xmlWriter);
            }
            if (localTransferednumTracker) {
                if (localTransferednum == null) {
                    throw new org.apache.axis2.databinding.ADBException("transferednum cannot be null!!");
                }
                localTransferednum.serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "transferednum"),
                        xmlWriter);
            }
            if (localConfnumTracker) {
                if (localConfnum == null) {
                    throw new org.apache.axis2.databinding.ADBException("confnum cannot be null!!");
                }
                localConfnum.serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "confnum"),
                        xmlWriter);
            }
            if (localConfnameTracker) {
                namespace = "http://starsystem.sample/";
                writeStartElement(null, namespace, "confname", xmlWriter);


                if (localConfname == null) {
                    // write the nil attribute

                    throw new org.apache.axis2.databinding.ADBException("confname cannot be null!!");

                } else {


                    xmlWriter.writeCharacters(localConfname);

                }

                xmlWriter.writeEndElement();
            }
            if (localServicetype == null) {
                throw new org.apache.axis2.databinding.ADBException("servicetype cannot be null!!");
            }
            localServicetype.serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "servicetype"),
                    xmlWriter);

            namespace = "http://starsystem.sample/";
            writeStartElement(null, namespace, "starttime", xmlWriter);


            if (localStarttime == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException("starttime cannot be null!!");

            } else {


                xmlWriter.writeCharacters(localStarttime);

            }

            xmlWriter.writeEndElement();

            xmlWriter.writeEndElement();


        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://starsystem.sample/")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }


        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if (uri == null || uri.length() == 0) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }


        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {


            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();


            elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                    "indexno"));

            if (localIndexno != null) {
                elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIndexno));
            } else {
                throw new org.apache.axis2.databinding.ADBException("indexno cannot be null!!");
            }
            if (localCallernumTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "callernum"));


                if (localCallernum == null) {
                    throw new org.apache.axis2.databinding.ADBException("callernum cannot be null!!");
                }
                elementList.add(localCallernum);
            }
            if (localCallednumTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "callednum"));


                if (localCallednum == null) {
                    throw new org.apache.axis2.databinding.ADBException("callednum cannot be null!!");
                }
                elementList.add(localCallednum);
            }
            if (localThirdcallnumTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "thirdcallnum"));


                if (localThirdcallnum == null) {
                    throw new org.apache.axis2.databinding.ADBException("thirdcallnum cannot be null!!");
                }
                elementList.add(localThirdcallnum);
            }
            if (localHoldnumTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "holdnum"));


                if (localHoldnum == null) {
                    throw new org.apache.axis2.databinding.ADBException("holdnum cannot be null!!");
                }
                elementList.add(localHoldnum);
            }
            if (localFinsertnumTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "finsertnum"));


                if (localFinsertnum == null) {
                    throw new org.apache.axis2.databinding.ADBException("finsertnum cannot be null!!");
                }
                elementList.add(localFinsertnum);
            }
            if (localFinsertednumTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "finsertednum"));


                if (localFinsertednum == null) {
                    throw new org.apache.axis2.databinding.ADBException("finsertednum cannot be null!!");
                }
                elementList.add(localFinsertednum);
            }
            if (localTransfernumTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "transfernum"));


                if (localTransfernum == null) {
                    throw new org.apache.axis2.databinding.ADBException("transfernum cannot be null!!");
                }
                elementList.add(localTransfernum);
            }
            if (localTransferednumTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "transferednum"));


                if (localTransferednum == null) {
                    throw new org.apache.axis2.databinding.ADBException("transferednum cannot be null!!");
                }
                elementList.add(localTransferednum);
            }
            if (localConfnumTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "confnum"));


                if (localConfnum == null) {
                    throw new org.apache.axis2.databinding.ADBException("confnum cannot be null!!");
                }
                elementList.add(localConfnum);
            }
            if (localConfnameTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "confname"));

                if (localConfname != null) {
                    elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localConfname));
                } else {
                    throw new org.apache.axis2.databinding.ADBException("confname cannot be null!!");
                }
            }
            elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                    "servicetype"));


            if (localServicetype == null) {
                throw new org.apache.axis2.databinding.ADBException("servicetype cannot be null!!");
            }
            elementList.add(localServicetype);

            elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                    "starttime"));

            if (localStarttime != null) {
                elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localStarttime));
            } else {
                throw new org.apache.axis2.databinding.ADBException("starttime cannot be null!!");
            }


            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());


        }


        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {


            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static ServiceCdrItemResult_type0 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                ServiceCdrItemResult_type0 object =
                        new ServiceCdrItemResult_type0();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();


                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "type");
                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if (!"ServiceCdrItemResult_type0".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (ServiceCdrItemResult_type0) ExtensionMapper.getTypeObject(
                                        nsUri, type, reader);
                            }


                        }


                    }


                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();


                    reader.next();


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "indexno").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException("The element: " + "indexno" + "  cannot be null");
                        }


                        java.lang.String content = reader.getElementText();

                        object.setIndexno(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedInt(content));

                        reader.next();

                    }  // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "callernum").equals(reader.getName())) {

                        object.setCallernum(Data_callnum.Factory.parse(reader));

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "callednum").equals(reader.getName())) {

                        object.setCallednum(Data_callnum.Factory.parse(reader));

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "thirdcallnum").equals(reader.getName())) {

                        object.setThirdcallnum(Data_callnum.Factory.parse(reader));

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "holdnum").equals(reader.getName())) {

                        object.setHoldnum(Data_callnum.Factory.parse(reader));

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "finsertnum").equals(reader.getName())) {

                        object.setFinsertnum(Data_callnum.Factory.parse(reader));

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "finsertednum").equals(reader.getName())) {

                        object.setFinsertednum(Data_callnum.Factory.parse(reader));

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "transfernum").equals(reader.getName())) {

                        object.setTransfernum(Data_callnum.Factory.parse(reader));

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "transferednum").equals(reader.getName())) {

                        object.setTransferednum(Data_callnum.Factory.parse(reader));

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "confnum").equals(reader.getName())) {

                        object.setConfnum(Data_callnum.Factory.parse(reader));

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "confname").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException("The element: " + "confname" + "  cannot be null");
                        }


                        java.lang.String content = reader.getElementText();

                        object.setConfname(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "servicetype").equals(reader.getName())) {

                        object.setServicetype(Data_servicetype.Factory.parse(reader));

                        reader.next();

                    }  // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "starttime").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException("The element: " + "starttime" + "  cannot be null");
                        }


                        java.lang.String content = reader.getElementText();

                        object.setStarttime(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        reader.next();

                    }  // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());


                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class


    }


    public static class ExtensionMapper {

        public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
                                                     java.lang.String typeName,
                                                     javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {


            if (
                    "http://starsystem.sample/".equals(namespaceURI) &&
                            "Data_callnum".equals(typeName)) {

                return Data_callnum.Factory.parse(reader);


            }


            if (
                    "http://starsystem.sample/".equals(namespaceURI) &&
                            "Data_CondiFlag".equals(typeName)) {

                return Data_CondiFlag.Factory.parse(reader);


            }


            if (
                    "http://starsystem.sample/".equals(namespaceURI) &&
                            "ServiceCdrItemResult_type0".equals(typeName)) {

                return ServiceCdrItemResult_type0.Factory.parse(reader);


            }


            if (
                    "http://starsystem.sample/".equals(namespaceURI) &&
                            "Data_returnflag".equals(typeName)) {

                return Data_returnflag.Factory.parse(reader);


            }


            if (
                    "http://starsystem.sample/".equals(namespaceURI) &&
                            "Data_servicetype".equals(typeName)) {

                return Data_servicetype.Factory.parse(reader);


            }


            if (
                    "http://starsystem.sample/".equals(namespaceURI) &&
                            "Data_recordfilestatus".equals(typeName)) {

                return Data_recordfilestatus.Factory.parse(reader);


            }


            if (
                    "http://starsystem.sample/".equals(namespaceURI) &&
                            "Data_startid".equals(typeName)) {

                return Data_startid.Factory.parse(reader);


            }


            if (
                    "http://starsystem.sample/".equals(namespaceURI) &&
                            "Data_recordnum".equals(typeName)) {

                return Data_recordnum.Factory.parse(reader);


            }


            if (
                    "http://starsystem.sample/".equals(namespaceURI) &&
                            "RecordItemResult_type0".equals(typeName)) {

                return RecordItemResult_type0.Factory.parse(reader);


            }


            if (
                    "http://starsystem.sample/".equals(namespaceURI) &&
                            "Data_cdrtype".equals(typeName)) {

                return Data_cdrtype.Factory.parse(reader);


            }


            if (
                    "http://starsystem.sample/".equals(namespaceURI) &&
                            "Data_calltype".equals(typeName)) {

                return Data_calltype.Factory.parse(reader);


            }


            if (
                    "http://starsystem.sample/".equals(namespaceURI) &&
                            "CallCdrItemResult_type0".equals(typeName)) {

                return CallCdrItemResult_type0.Factory.parse(reader);


            }


            if (
                    "http://starsystem.sample/".equals(namespaceURI) &&
                            "Data_direction".equals(typeName)) {

                return Data_direction.Factory.parse(reader);


            }


            throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
        }

    }

    public static class QueryRecordResponse
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://starsystem.sample/",
                "QueryRecordResponse",
                "ns1");


        /**
         * field for Returnflag
         */


        protected Data_returnflag localReturnflag;


        /**
         * Auto generated getter method
         * @return Data_returnflag
         */
        public Data_returnflag getReturnflag() {
            return localReturnflag;
        }


        /**
         * Auto generated setter method
         * @param param Returnflag
         */
        public void setReturnflag(Data_returnflag param) {

            this.localReturnflag = param;


        }


        /**
         * field for Totalnum
         */


        protected org.apache.axis2.databinding.types.UnsignedInt localTotalnum;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localTotalnumTracker = false;

        public boolean isTotalnumSpecified() {
            return localTotalnumTracker;
        }


        /**
         * Auto generated getter method
         * @return org.apache.axis2.databinding.types.UnsignedInt
         */
        public org.apache.axis2.databinding.types.UnsignedInt getTotalnum() {
            return localTotalnum;
        }


        /**
         * Auto generated setter method
         * @param param Totalnum
         */
        public void setTotalnum(org.apache.axis2.databinding.types.UnsignedInt param) {
            localTotalnumTracker = param != null;

            this.localTotalnum = param;


        }


        /**
         * field for Recordnum
         */


        protected org.apache.axis2.databinding.types.UnsignedShort localRecordnum;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localRecordnumTracker = false;

        public boolean isRecordnumSpecified() {
            return localRecordnumTracker;
        }


        /**
         * Auto generated getter method
         * @return org.apache.axis2.databinding.types.UnsignedShort
         */
        public org.apache.axis2.databinding.types.UnsignedShort getRecordnum() {
            return localRecordnum;
        }


        /**
         * Auto generated setter method
         * @param param Recordnum
         */
        public void setRecordnum(org.apache.axis2.databinding.types.UnsignedShort param) {
            localRecordnumTracker = param != null;

            this.localRecordnum = param;


        }


        /**
         * field for Freesize
         */


        protected org.apache.axis2.databinding.types.UnsignedInt localFreesize;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localFreesizeTracker = false;

        public boolean isFreesizeSpecified() {
            return localFreesizeTracker;
        }


        /**
         * Auto generated getter method
         * @return org.apache.axis2.databinding.types.UnsignedInt
         */
        public org.apache.axis2.databinding.types.UnsignedInt getFreesize() {
            return localFreesize;
        }


        /**
         * Auto generated setter method
         * @param param Freesize
         */
        public void setFreesize(org.apache.axis2.databinding.types.UnsignedInt param) {
            localFreesizeTracker = param != null;

            this.localFreesize = param;


        }


        /**
         * field for Totalsize
         */


        protected org.apache.axis2.databinding.types.UnsignedInt localTotalsize;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localTotalsizeTracker = false;

        public boolean isTotalsizeSpecified() {
            return localTotalsizeTracker;
        }


        /**
         * Auto generated getter method
         * @return org.apache.axis2.databinding.types.UnsignedInt
         */
        public org.apache.axis2.databinding.types.UnsignedInt getTotalsize() {
            return localTotalsize;
        }


        /**
         * Auto generated setter method
         * @param param Totalsize
         */
        public void setTotalsize(org.apache.axis2.databinding.types.UnsignedInt param) {
            localTotalsizeTracker = param != null;

            this.localTotalsize = param;


        }


        /**
         * field for RecordItemResult
         * This was an Array!
         */


        protected RecordItemResult_type0[] localRecordItemResult;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localRecordItemResultTracker = false;

        public boolean isRecordItemResultSpecified() {
            return localRecordItemResultTracker;
        }


        /**
         * Auto generated getter method
         * @return RecordItemResult_type0[]
         */
        public RecordItemResult_type0[] getRecordItemResult() {
            return localRecordItemResult;
        }


        /**
         * validate the array for RecordItemResult
         */
        protected void validateRecordItemResult(RecordItemResult_type0[] param) {

            if ((param != null) && (param.length > 32)) {
                throw new java.lang.RuntimeException();
            }

        }


        /**
         * Auto generated setter method
         * @param param RecordItemResult
         */
        public void setRecordItemResult(RecordItemResult_type0[] param) {

            validateRecordItemResult(param);

            localRecordItemResultTracker = true;

            this.localRecordItemResult = param;
        }


        /**
         * Auto generated add method for the array for convenience
         * @param param RecordItemResult_type0
         */
        public void addRecordItemResult(RecordItemResult_type0 param) {
            if (localRecordItemResult == null) {
                localRecordItemResult = new RecordItemResult_type0[]{};
            }


            //update the setting tracker
            localRecordItemResultTracker = true;


            java.util.List list =
                    org.apache.axis2.databinding.utils.ConverterUtil.toList(localRecordItemResult);
            list.add(param);
            this.localRecordItemResult =
                    (RecordItemResult_type0[]) list.toArray(
                            new RecordItemResult_type0[list.size()]);

        }


        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {


            org.apache.axiom.om.OMDataSource dataSource =
                    new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {


            java.lang.String prefix = null;
            java.lang.String namespace = null;


            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

            if (serializeType) {


                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://starsystem.sample/");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":QueryRecordResponse",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "QueryRecordResponse",
                            xmlWriter);
                }


            }

            if (localReturnflag == null) {
                throw new org.apache.axis2.databinding.ADBException("returnflag cannot be null!!");
            }
            localReturnflag.serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "returnflag"),
                    xmlWriter);
            if (localTotalnumTracker) {
                namespace = "http://starsystem.sample/";
                writeStartElement(null, namespace, "totalnum", xmlWriter);


                if (localTotalnum == null) {
                    // write the nil attribute

                    throw new org.apache.axis2.databinding.ADBException("totalnum cannot be null!!");

                } else {


                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTotalnum));

                }

                xmlWriter.writeEndElement();
            }
            if (localRecordnumTracker) {
                namespace = "http://starsystem.sample/";
                writeStartElement(null, namespace, "recordnum", xmlWriter);


                if (localRecordnum == null) {
                    // write the nil attribute

                    throw new org.apache.axis2.databinding.ADBException("recordnum cannot be null!!");

                } else {


                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRecordnum));

                }

                xmlWriter.writeEndElement();
            }
            if (localFreesizeTracker) {
                namespace = "http://starsystem.sample/";
                writeStartElement(null, namespace, "freesize", xmlWriter);


                if (localFreesize == null) {
                    // write the nil attribute

                    throw new org.apache.axis2.databinding.ADBException("freesize cannot be null!!");

                } else {


                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFreesize));

                }

                xmlWriter.writeEndElement();
            }
            if (localTotalsizeTracker) {
                namespace = "http://starsystem.sample/";
                writeStartElement(null, namespace, "totalsize", xmlWriter);


                if (localTotalsize == null) {
                    // write the nil attribute

                    throw new org.apache.axis2.databinding.ADBException("totalsize cannot be null!!");

                } else {


                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTotalsize));

                }

                xmlWriter.writeEndElement();
            }
            if (localRecordItemResultTracker) {
                if (localRecordItemResult != null) {
                    for (int i = 0; i < localRecordItemResult.length; i++) {
                        if (localRecordItemResult[i] != null) {
                            localRecordItemResult[i].serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "RecordItemResult"),
                                    xmlWriter);
                        } else {

                            writeStartElement(null, "http://starsystem.sample/", "RecordItemResult", xmlWriter);

                            // write the nil attribute
                            writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
                            xmlWriter.writeEndElement();

                        }

                    }
                } else {

                    writeStartElement(null, "http://starsystem.sample/", "RecordItemResult", xmlWriter);

                    // write the nil attribute
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
                    xmlWriter.writeEndElement();

                }
            }
            xmlWriter.writeEndElement();


        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://starsystem.sample/")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }


        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if (uri == null || uri.length() == 0) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }


        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {


            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();


            elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                    "returnflag"));


            if (localReturnflag == null) {
                throw new org.apache.axis2.databinding.ADBException("returnflag cannot be null!!");
            }
            elementList.add(localReturnflag);
            if (localTotalnumTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "totalnum"));

                if (localTotalnum != null) {
                    elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTotalnum));
                } else {
                    throw new org.apache.axis2.databinding.ADBException("totalnum cannot be null!!");
                }
            }
            if (localRecordnumTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "recordnum"));

                if (localRecordnum != null) {
                    elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRecordnum));
                } else {
                    throw new org.apache.axis2.databinding.ADBException("recordnum cannot be null!!");
                }
            }
            if (localFreesizeTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "freesize"));

                if (localFreesize != null) {
                    elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFreesize));
                } else {
                    throw new org.apache.axis2.databinding.ADBException("freesize cannot be null!!");
                }
            }
            if (localTotalsizeTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "totalsize"));

                if (localTotalsize != null) {
                    elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTotalsize));
                } else {
                    throw new org.apache.axis2.databinding.ADBException("totalsize cannot be null!!");
                }
            }
            if (localRecordItemResultTracker) {
                if (localRecordItemResult != null) {
                    for (int i = 0; i < localRecordItemResult.length; i++) {

                        if (localRecordItemResult[i] != null) {
                            elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                                    "RecordItemResult"));
                            elementList.add(localRecordItemResult[i]);
                        } else {

                            elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                                    "RecordItemResult"));
                            elementList.add(null);

                        }

                    }
                } else {

                    elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                            "RecordItemResult"));
                    elementList.add(localRecordItemResult);

                }

            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());


        }


        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {


            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static QueryRecordResponse parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                QueryRecordResponse object =
                        new QueryRecordResponse();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();


                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "type");
                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if (!"QueryRecordResponse".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (QueryRecordResponse) ExtensionMapper.getTypeObject(
                                        nsUri, type, reader);
                            }


                        }


                    }


                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();


                    reader.next();

                    java.util.ArrayList list6 = new java.util.ArrayList();


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "returnflag").equals(reader.getName())) {

                        object.setReturnflag(Data_returnflag.Factory.parse(reader));

                        reader.next();

                    }  // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "totalnum").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException("The element: " + "totalnum" + "  cannot be null");
                        }


                        java.lang.String content = reader.getElementText();

                        object.setTotalnum(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedInt(content));

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "recordnum").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException("The element: " + "recordnum" + "  cannot be null");
                        }


                        java.lang.String content = reader.getElementText();

                        object.setRecordnum(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedShort(content));

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "freesize").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException("The element: " + "freesize" + "  cannot be null");
                        }


                        java.lang.String content = reader.getElementText();

                        object.setFreesize(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedInt(content));

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "totalsize").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException("The element: " + "totalsize" + "  cannot be null");
                        }


                        java.lang.String content = reader.getElementText();

                        object.setTotalsize(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedInt(content));

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "RecordItemResult").equals(reader.getName())) {


                        // Process the array and step past its final element's end.

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            list6.add(null);
                            reader.next();
                        } else {
                            list6.add(RecordItemResult_type0.Factory.parse(reader));
                        }
                        //loop until we find a start element that is not part of this array
                        boolean loopDone6 = false;
                        while (!loopDone6) {
                            // We should be at the end element, but make sure
                            while (!reader.isEndElement())
                                reader.next();
                            // Step out of this element
                            reader.next();
                            // Step to next element event.
                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();
                            if (reader.isEndElement()) {
                                //two continuous end elements means we are exiting the xml structure
                                loopDone6 = true;
                            } else {
                                if (new javax.xml.namespace.QName("http://starsystem.sample/", "RecordItemResult").equals(reader.getName())) {

                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                                        list6.add(null);
                                        reader.next();
                                    } else {
                                        list6.add(RecordItemResult_type0.Factory.parse(reader));
                                    }
                                } else {
                                    loopDone6 = true;
                                }
                            }
                        }
                        // call the converter utility  to convert and set the array

                        object.setRecordItemResult((RecordItemResult_type0[])
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                        RecordItemResult_type0.class,
                                        list6));

                    }  // End of if for expected property start element

                    else {

                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());


                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class


    }


    public static class Data_returnflag
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://starsystem.sample/",
                "Data_returnflag",
                "ns1");


        /**
         * field for Data_returnflag
         */


        protected byte localData_returnflag;

        private static java.util.HashMap _table_ = new java.util.HashMap();

        // Constructor

        protected Data_returnflag(byte value, boolean isRegisterValue) {
            localData_returnflag = value;
            if (isRegisterValue) {

                _table_.put(localData_returnflag + "", this);

            }

        }

        public static final byte _value1 =
                org.apache.axis2.databinding.utils.ConverterUtil.convertToByte("0");

        public static final byte _value2 =
                org.apache.axis2.databinding.utils.ConverterUtil.convertToByte("1");

        public static final byte _value3 =
                org.apache.axis2.databinding.utils.ConverterUtil.convertToByte("-1");

        public static final byte _value4 =
                org.apache.axis2.databinding.utils.ConverterUtil.convertToByte("-2");

        public static final byte _value5 =
                org.apache.axis2.databinding.utils.ConverterUtil.convertToByte("-3");

        public static final byte _value6 =
                org.apache.axis2.databinding.utils.ConverterUtil.convertToByte("-4");

        public static final byte _value7 =
                org.apache.axis2.databinding.utils.ConverterUtil.convertToByte("-5");

        public static final byte _value8 =
                org.apache.axis2.databinding.utils.ConverterUtil.convertToByte("-6");

        public static final byte _value9 =
                org.apache.axis2.databinding.utils.ConverterUtil.convertToByte("-7");

        public static final byte _value10 =
                org.apache.axis2.databinding.utils.ConverterUtil.convertToByte("-8");

        public static final byte _value11 =
                org.apache.axis2.databinding.utils.ConverterUtil.convertToByte("-9");

        public static final byte _value12 =
                org.apache.axis2.databinding.utils.ConverterUtil.convertToByte("-10");

        public static final Data_returnflag value1 =
                new Data_returnflag(_value1, true);

        public static final Data_returnflag value2 =
                new Data_returnflag(_value2, true);

        public static final Data_returnflag value3 =
                new Data_returnflag(_value3, true);

        public static final Data_returnflag value4 =
                new Data_returnflag(_value4, true);

        public static final Data_returnflag value5 =
                new Data_returnflag(_value5, true);

        public static final Data_returnflag value6 =
                new Data_returnflag(_value6, true);

        public static final Data_returnflag value7 =
                new Data_returnflag(_value7, true);

        public static final Data_returnflag value8 =
                new Data_returnflag(_value8, true);

        public static final Data_returnflag value9 =
                new Data_returnflag(_value9, true);

        public static final Data_returnflag value10 =
                new Data_returnflag(_value10, true);

        public static final Data_returnflag value11 =
                new Data_returnflag(_value11, true);

        public static final Data_returnflag value12 =
                new Data_returnflag(_value12, true);

        public byte getValue() {
            return localData_returnflag;
        }

        public boolean equals(java.lang.Object obj) {
            return (obj == this);
        }

        public int hashCode() {
            return toString().hashCode();
        }

        public java.lang.String toString() {

            return org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localData_returnflag);


        }


        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {


            org.apache.axiom.om.OMDataSource dataSource =
                    new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {


            //We can safely assume an element has only one type associated with it

            java.lang.String namespace = parentQName.getNamespaceURI();
            java.lang.String _localName = parentQName.getLocalPart();

            writeStartElement(null, namespace, _localName, xmlWriter);

            // add the type details if this is used in a simple type
            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://starsystem.sample/");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":Data_returnflag",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "Data_returnflag",
                            xmlWriter);
                }
            }

            if (localData_returnflag == java.lang.Byte.MIN_VALUE) {

                throw new org.apache.axis2.databinding.ADBException("property value cannot be null!!");

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localData_returnflag));
            }

            xmlWriter.writeEndElement();


        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://starsystem.sample/")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }


        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if (uri == null || uri.length() == 0) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }


        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {


            //We can safely assume an element has only one type associated with it
            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                    new java.lang.Object[]{
                            org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localData_returnflag)
                    },
                    null);

        }


        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {


            public static Data_returnflag fromValue(byte value)
                    throws java.lang.IllegalArgumentException {
                Data_returnflag enumeration = (Data_returnflag)

                        _table_.get(value + "");

                if (enumeration == null) {
                    //if ((enumeration == null) && !((value == null) || (value.equals("")))) {
                    throw new java.lang.IllegalArgumentException();
                }
                return enumeration;
            }

            public static Data_returnflag fromString(java.lang.String value, java.lang.String namespaceURI)
                    throws java.lang.IllegalArgumentException {
                try {

                    return fromValue(org.apache.axis2.databinding.utils.ConverterUtil.convertToByte(value));


                } catch (java.lang.Exception e) {
                    throw new java.lang.IllegalArgumentException();
                }
            }

            public static Data_returnflag fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                                                     java.lang.String content) {
                if (content.indexOf(":") > -1) {
                    java.lang.String prefix = content.substring(0, content.indexOf(":"));
                    java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                    return Data_returnflag.Factory.fromString(content, namespaceUri);
                } else {
                    return Data_returnflag.Factory.fromString(content, "");
                }
            }


            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static Data_returnflag parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                Data_returnflag object = null;
                // initialize a hash map to keep values
                java.util.Map attributeMap = new java.util.HashMap();
                java.util.List extraAttributeList = new java.util.ArrayList<org.apache.axiom.om.OMAttribute>();


                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();


                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();


                    while (!reader.isEndElement()) {
                        if (reader.isStartElement() || reader.hasText()) {

                            nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                            if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                                throw new org.apache.axis2.databinding.ADBException("The element: " + "Data_returnflag" + "  cannot be null");
                            }


                            java.lang.String content = reader.getElementText();

                            if (content.indexOf(":") > 0) {
                                // this seems to be a Qname so find the namespace and send
                                prefix = content.substring(0, content.indexOf(":"));
                                namespaceuri = reader.getNamespaceURI(prefix);
                                object = Data_returnflag.Factory.fromString(content, namespaceuri);
                            } else {
                                // this seems to be not a qname send and empty namespace incase of it is
                                // check is done in fromString method
                                object = Data_returnflag.Factory.fromString(content, "");
                            }


                        } else {
                            reader.next();
                        }
                    }  // end of while loop


                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class


    }


    public static class Data_servicetype
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://starsystem.sample/",
                "Data_servicetype",
                "ns1");


        /**
         * field for Data_servicetype
         */


        protected org.apache.axis2.databinding.types.UnsignedByte localData_servicetype;

        private static java.util.HashMap _table_ = new java.util.HashMap();

        // Constructor

        protected Data_servicetype(org.apache.axis2.databinding.types.UnsignedByte value, boolean isRegisterValue) {
            localData_servicetype = value;
            if (isRegisterValue) {

                _table_.put(localData_servicetype, this);

            }

        }

        public static final org.apache.axis2.databinding.types.UnsignedByte _value1 =
                org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedByte("0");

        public static final org.apache.axis2.databinding.types.UnsignedByte _value2 =
                org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedByte("1");

        public static final org.apache.axis2.databinding.types.UnsignedByte _value3 =
                org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedByte("2");

        public static final org.apache.axis2.databinding.types.UnsignedByte _value4 =
                org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedByte("3");

        public static final org.apache.axis2.databinding.types.UnsignedByte _value5 =
                org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedByte("4");

        public static final org.apache.axis2.databinding.types.UnsignedByte _value6 =
                org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedByte("5");

        public static final org.apache.axis2.databinding.types.UnsignedByte _value7 =
                org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedByte("6");

        public static final org.apache.axis2.databinding.types.UnsignedByte _value8 =
                org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedByte("7");

        public static final org.apache.axis2.databinding.types.UnsignedByte _value9 =
                org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedByte("8");

        public static final org.apache.axis2.databinding.types.UnsignedByte _value10 =
                org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedByte("9");

        public static final org.apache.axis2.databinding.types.UnsignedByte _value11 =
                org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedByte("10");

        public static final org.apache.axis2.databinding.types.UnsignedByte _value12 =
                org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedByte("11");

        public static final org.apache.axis2.databinding.types.UnsignedByte _value13 =
                org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedByte("12");

        public static final org.apache.axis2.databinding.types.UnsignedByte _value14 =
                org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedByte("13");

        public static final org.apache.axis2.databinding.types.UnsignedByte _value15 =
                org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedByte("14");

        public static final Data_servicetype value1 =
                new Data_servicetype(_value1, true);

        public static final Data_servicetype value2 =
                new Data_servicetype(_value2, true);

        public static final Data_servicetype value3 =
                new Data_servicetype(_value3, true);

        public static final Data_servicetype value4 =
                new Data_servicetype(_value4, true);

        public static final Data_servicetype value5 =
                new Data_servicetype(_value5, true);

        public static final Data_servicetype value6 =
                new Data_servicetype(_value6, true);

        public static final Data_servicetype value7 =
                new Data_servicetype(_value7, true);

        public static final Data_servicetype value8 =
                new Data_servicetype(_value8, true);

        public static final Data_servicetype value9 =
                new Data_servicetype(_value9, true);

        public static final Data_servicetype value10 =
                new Data_servicetype(_value10, true);

        public static final Data_servicetype value11 =
                new Data_servicetype(_value11, true);

        public static final Data_servicetype value12 =
                new Data_servicetype(_value12, true);

        public static final Data_servicetype value13 =
                new Data_servicetype(_value13, true);

        public static final Data_servicetype value14 =
                new Data_servicetype(_value14, true);

        public static final Data_servicetype value15 =
                new Data_servicetype(_value15, true);


        public org.apache.axis2.databinding.types.UnsignedByte getValue() {
            return localData_servicetype;
        }

        public boolean equals(java.lang.Object obj) {
            return (obj == this);
        }

        public int hashCode() {
            return toString().hashCode();
        }

        public java.lang.String toString() {

            return localData_servicetype.toString();


        }


        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {


            org.apache.axiom.om.OMDataSource dataSource =
                    new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {


            //We can safely assume an element has only one type associated with it

            java.lang.String namespace = parentQName.getNamespaceURI();
            java.lang.String _localName = parentQName.getLocalPart();

            writeStartElement(null, namespace, _localName, xmlWriter);

            // add the type details if this is used in a simple type
            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://starsystem.sample/");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":Data_servicetype",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "Data_servicetype",
                            xmlWriter);
                }
            }

            if (localData_servicetype == null) {

                throw new org.apache.axis2.databinding.ADBException("Data_servicetype cannot be null !!");

            } else {

                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localData_servicetype));

            }

            xmlWriter.writeEndElement();


        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://starsystem.sample/")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }


        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if (uri == null || uri.length() == 0) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }


        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {


            //We can safely assume an element has only one type associated with it
            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                    new java.lang.Object[]{
                            org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localData_servicetype)
                    },
                    null);

        }


        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {


            public static Data_servicetype fromValue(org.apache.axis2.databinding.types.UnsignedByte value)
                    throws java.lang.IllegalArgumentException {
                Data_servicetype enumeration = (Data_servicetype)

                        _table_.get(value);


                if ((enumeration == null) && !((value == null) || (value.equals("")))) {
                    throw new java.lang.IllegalArgumentException();
                }
                return enumeration;
            }

            public static Data_servicetype fromString(java.lang.String value, java.lang.String namespaceURI)
                    throws java.lang.IllegalArgumentException {
                try {

                    return fromValue(org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedByte(value));


                } catch (java.lang.Exception e) {
                    throw new java.lang.IllegalArgumentException();
                }
            }

            public static Data_servicetype fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                                                      java.lang.String content) {
                if (content.indexOf(":") > -1) {
                    java.lang.String prefix = content.substring(0, content.indexOf(":"));
                    java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                    return Data_servicetype.Factory.fromString(content, namespaceUri);
                } else {
                    return Data_servicetype.Factory.fromString(content, "");
                }
            }


            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static Data_servicetype parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                Data_servicetype object = null;
                // initialize a hash map to keep values
                java.util.Map attributeMap = new java.util.HashMap();
                java.util.List extraAttributeList = new java.util.ArrayList<org.apache.axiom.om.OMAttribute>();


                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();


                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();


                    while (!reader.isEndElement()) {
                        if (reader.isStartElement() || reader.hasText()) {

                            nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                            if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                                throw new org.apache.axis2.databinding.ADBException("The element: " + "Data_servicetype" + "  cannot be null");
                            }


                            java.lang.String content = reader.getElementText();

                            if (content.indexOf(":") > 0) {
                                // this seems to be a Qname so find the namespace and send
                                prefix = content.substring(0, content.indexOf(":"));
                                namespaceuri = reader.getNamespaceURI(prefix);
                                object = Data_servicetype.Factory.fromString(content, namespaceuri);
                            } else {
                                // this seems to be not a qname send and empty namespace incase of it is
                                // check is done in fromString method
                                object = Data_servicetype.Factory.fromString(content, "");
                            }


                        } else {
                            reader.next();
                        }
                    }  // end of while loop


                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class


    }


    public static class QueryRecord
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://starsystem.sample/",
                "QueryRecord",
                "ns1");


        /**
         * field for Dispatcherno
         */


        protected org.apache.axis2.databinding.types.UnsignedShort localDispatcherno;


        /**
         * Auto generated getter method
         * @return org.apache.axis2.databinding.types.UnsignedShort
         */
        public org.apache.axis2.databinding.types.UnsignedShort getDispatcherno() {
            return localDispatcherno;
        }


        /**
         * Auto generated setter method
         * @param param Dispatcherno
         */
        public void setDispatcherno(org.apache.axis2.databinding.types.UnsignedShort param) {

            this.localDispatcherno = param;


        }


        /**
         * field for Startid
         */


        protected Data_startid localStartid;


        /**
         * Auto generated getter method
         * @return Data_startid
         */
        public Data_startid getStartid() {
            return localStartid;
        }


        /**
         * Auto generated setter method
         * @param param Startid
         */
        public void setStartid(Data_startid param) {

            this.localStartid = param;


        }


        /**
         * field for Skipnum
         */


        protected org.apache.axis2.databinding.types.UnsignedShort localSkipnum;


        /**
         * Auto generated getter method
         * @return org.apache.axis2.databinding.types.UnsignedShort
         */
        public org.apache.axis2.databinding.types.UnsignedShort getSkipnum() {
            return localSkipnum;
        }


        /**
         * Auto generated setter method
         * @param param Skipnum
         */
        public void setSkipnum(org.apache.axis2.databinding.types.UnsignedShort param) {

            this.localSkipnum = param;


        }


        /**
         * field for Recordnum
         */


        protected Data_recordnum localRecordnum;


        /**
         * Auto generated getter method
         * @return Data_recordnum
         */
        public Data_recordnum getRecordnum() {
            return localRecordnum;
        }


        /**
         * Auto generated setter method
         * @param param Recordnum
         */
        public void setRecordnum(Data_recordnum param) {

            this.localRecordnum = param;


        }


        /**
         * field for Direction
         */


        protected Data_direction localDirection;


        /**
         * Auto generated getter method
         * @return Data_direction
         */
        public Data_direction getDirection() {
            return localDirection;
        }


        /**
         * Auto generated setter method
         * @param param Direction
         */
        public void setDirection(Data_direction param) {

            this.localDirection = param;


        }


        /**
         * field for Starttime
         */


        protected java.lang.String localStarttime;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localStarttimeTracker = false;

        public boolean isStarttimeSpecified() {
            return localStarttimeTracker;
        }


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getStarttime() {
            return localStarttime;
        }


        /**
         * Auto generated setter method
         * @param param Starttime
         */
        public void setStarttime(java.lang.String param) {
            localStarttimeTracker = param != null;

            this.localStarttime = param;


        }


        /**
         * field for Endtime
         */


        protected java.lang.String localEndtime;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localEndtimeTracker = false;

        public boolean isEndtimeSpecified() {
            return localEndtimeTracker;
        }


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getEndtime() {
            return localEndtime;
        }


        /**
         * Auto generated setter method
         * @param param Endtime
         */
        public void setEndtime(java.lang.String param) {
            localEndtimeTracker = param != null;

            this.localEndtime = param;


        }


        /**
         * field for Callernum
         */


        protected Data_callnum localCallernum;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localCallernumTracker = false;

        public boolean isCallernumSpecified() {
            return localCallernumTracker;
        }


        /**
         * Auto generated getter method
         * @return Data_callnum
         */
        public Data_callnum getCallernum() {
            return localCallernum;
        }


        /**
         * Auto generated setter method
         * @param param Callernum
         */
        public void setCallernum(Data_callnum param) {
            localCallernumTracker = param != null;

            this.localCallernum = param;


        }


        /**
         * field for Callednum
         */


        protected Data_callnum localCallednum;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localCallednumTracker = false;

        public boolean isCallednumSpecified() {
            return localCallednumTracker;
        }


        /**
         * Auto generated getter method
         * @return Data_callnum
         */
        public Data_callnum getCallednum() {
            return localCallednum;
        }


        /**
         * Auto generated setter method
         * @param param Callednum
         */
        public void setCallednum(Data_callnum param) {
            localCallednumTracker = param != null;

            this.localCallednum = param;


        }


        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {


            org.apache.axiom.om.OMDataSource dataSource =
                    new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {


            java.lang.String prefix = null;
            java.lang.String namespace = null;


            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

            if (serializeType) {


                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://starsystem.sample/");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":QueryRecord",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "QueryRecord",
                            xmlWriter);
                }


            }

            namespace = "http://starsystem.sample/";
            writeStartElement(null, namespace, "dispatcherno", xmlWriter);


            if (localDispatcherno == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException("dispatcherno cannot be null!!");

            } else {


                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDispatcherno));

            }

            xmlWriter.writeEndElement();

            if (localStartid == null) {
                throw new org.apache.axis2.databinding.ADBException("startid cannot be null!!");
            }
            localStartid.serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "startid"),
                    xmlWriter);

            namespace = "http://starsystem.sample/";
            writeStartElement(null, namespace, "skipnum", xmlWriter);


            if (localSkipnum == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException("skipnum cannot be null!!");

            } else {


                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSkipnum));

            }

            xmlWriter.writeEndElement();

            if (localRecordnum == null) {
                throw new org.apache.axis2.databinding.ADBException("recordnum cannot be null!!");
            }
            localRecordnum.serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "recordnum"),
                    xmlWriter);

            if (localDirection == null) {
                throw new org.apache.axis2.databinding.ADBException("direction cannot be null!!");
            }
            localDirection.serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "direction"),
                    xmlWriter);
            if (localStarttimeTracker) {
                namespace = "http://starsystem.sample/";
                writeStartElement(null, namespace, "starttime", xmlWriter);


                if (localStarttime == null) {
                    // write the nil attribute

                    throw new org.apache.axis2.databinding.ADBException("starttime cannot be null!!");

                } else {


                    xmlWriter.writeCharacters(localStarttime);

                }

                xmlWriter.writeEndElement();
            }
            if (localEndtimeTracker) {
                namespace = "http://starsystem.sample/";
                writeStartElement(null, namespace, "endtime", xmlWriter);


                if (localEndtime == null) {
                    // write the nil attribute

                    throw new org.apache.axis2.databinding.ADBException("endtime cannot be null!!");

                } else {


                    xmlWriter.writeCharacters(localEndtime);

                }

                xmlWriter.writeEndElement();
            }
            if (localCallernumTracker) {
                if (localCallernum == null) {
                    throw new org.apache.axis2.databinding.ADBException("callernum cannot be null!!");
                }
                localCallernum.serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "callernum"),
                        xmlWriter);
            }
            if (localCallednumTracker) {
                if (localCallednum == null) {
                    throw new org.apache.axis2.databinding.ADBException("callednum cannot be null!!");
                }
                localCallednum.serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "callednum"),
                        xmlWriter);
            }
            xmlWriter.writeEndElement();


        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://starsystem.sample/")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }


        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if (uri == null || uri.length() == 0) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }


        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {


            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();


            elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                    "dispatcherno"));

            if (localDispatcherno != null) {
                elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDispatcherno));
            } else {
                throw new org.apache.axis2.databinding.ADBException("dispatcherno cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                    "startid"));


            if (localStartid == null) {
                throw new org.apache.axis2.databinding.ADBException("startid cannot be null!!");
            }
            elementList.add(localStartid);

            elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                    "skipnum"));

            if (localSkipnum != null) {
                elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSkipnum));
            } else {
                throw new org.apache.axis2.databinding.ADBException("skipnum cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                    "recordnum"));


            if (localRecordnum == null) {
                throw new org.apache.axis2.databinding.ADBException("recordnum cannot be null!!");
            }
            elementList.add(localRecordnum);

            elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                    "direction"));


            if (localDirection == null) {
                throw new org.apache.axis2.databinding.ADBException("direction cannot be null!!");
            }
            elementList.add(localDirection);
            if (localStarttimeTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "starttime"));

                if (localStarttime != null) {
                    elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localStarttime));
                } else {
                    throw new org.apache.axis2.databinding.ADBException("starttime cannot be null!!");
                }
            }
            if (localEndtimeTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "endtime"));

                if (localEndtime != null) {
                    elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEndtime));
                } else {
                    throw new org.apache.axis2.databinding.ADBException("endtime cannot be null!!");
                }
            }
            if (localCallernumTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "callernum"));


                if (localCallernum == null) {
                    throw new org.apache.axis2.databinding.ADBException("callernum cannot be null!!");
                }
                elementList.add(localCallernum);
            }
            if (localCallednumTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "callednum"));


                if (localCallednum == null) {
                    throw new org.apache.axis2.databinding.ADBException("callednum cannot be null!!");
                }
                elementList.add(localCallednum);
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());


        }


        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {


            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static QueryRecord parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                QueryRecord object =
                        new QueryRecord();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();


                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "type");
                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if (!"QueryRecord".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (QueryRecord) ExtensionMapper.getTypeObject(
                                        nsUri, type, reader);
                            }


                        }


                    }


                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();


                    reader.next();

                    while (!reader.isEndElement()) {
                        if (reader.isStartElement()) {

                            if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "dispatcherno").equals(reader.getName())) {

                                nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                                    throw new org.apache.axis2.databinding.ADBException("The element: " + "dispatcherno" + "  cannot be null");
                                }


                                java.lang.String content = reader.getElementText();

                                object.setDispatcherno(
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedShort(content));

                                reader.next();

                            }  // End of if for expected property start element

                            else if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "startid").equals(reader.getName())) {

                                object.setStartid(Data_startid.Factory.parse(reader));

                                reader.next();

                            }  // End of if for expected property start element

                            else if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "skipnum").equals(reader.getName())) {

                                nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                                    throw new org.apache.axis2.databinding.ADBException("The element: " + "skipnum" + "  cannot be null");
                                }


                                java.lang.String content = reader.getElementText();

                                object.setSkipnum(
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedShort(content));

                                reader.next();

                            }  // End of if for expected property start element

                            else if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "recordnum").equals(reader.getName())) {

                                object.setRecordnum(Data_recordnum.Factory.parse(reader));

                                reader.next();

                            }  // End of if for expected property start element

                            else if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "direction").equals(reader.getName())) {

                                object.setDirection(Data_direction.Factory.parse(reader));

                                reader.next();

                            }  // End of if for expected property start element

                            else if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "starttime").equals(reader.getName())) {

                                nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                                    throw new org.apache.axis2.databinding.ADBException("The element: " + "starttime" + "  cannot be null");
                                }


                                java.lang.String content = reader.getElementText();

                                object.setStarttime(
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                reader.next();

                            }  // End of if for expected property start element

                            else if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "endtime").equals(reader.getName())) {

                                nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                                    throw new org.apache.axis2.databinding.ADBException("The element: " + "endtime" + "  cannot be null");
                                }


                                java.lang.String content = reader.getElementText();

                                object.setEndtime(
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                reader.next();

                            }  // End of if for expected property start element

                            else if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "callernum").equals(reader.getName())) {

                                object.setCallernum(Data_callnum.Factory.parse(reader));

                                reader.next();

                            }  // End of if for expected property start element

                            else if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "callednum").equals(reader.getName())) {

                                object.setCallednum(Data_callnum.Factory.parse(reader));

                                reader.next();

                            }  // End of if for expected property start element

                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop


                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class


    }


    public static class Data_recordfilestatus
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://starsystem.sample/",
                "Data_recordfilestatus",
                "ns1");


        /**
         * field for Data_recordfilestatus
         */


        protected org.apache.axis2.databinding.types.UnsignedByte localData_recordfilestatus;

        private static java.util.HashMap _table_ = new java.util.HashMap();

        // Constructor

        protected Data_recordfilestatus(org.apache.axis2.databinding.types.UnsignedByte value, boolean isRegisterValue) {
            localData_recordfilestatus = value;
            if (isRegisterValue) {

                _table_.put(localData_recordfilestatus, this);

            }

        }

        public static final org.apache.axis2.databinding.types.UnsignedByte _value1 =
                org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedByte("0");

        public static final org.apache.axis2.databinding.types.UnsignedByte _value2 =
                org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedByte("1");

        public static final org.apache.axis2.databinding.types.UnsignedByte _value3 =
                org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedByte("2");

        public static final org.apache.axis2.databinding.types.UnsignedByte _value4 =
                org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedByte("3");

        public static final Data_recordfilestatus value1 =
                new Data_recordfilestatus(_value1, true);

        public static final Data_recordfilestatus value2 =
                new Data_recordfilestatus(_value2, true);

        public static final Data_recordfilestatus value3 =
                new Data_recordfilestatus(_value3, true);

        public static final Data_recordfilestatus value4 =
                new Data_recordfilestatus(_value4, true);


        public org.apache.axis2.databinding.types.UnsignedByte getValue() {
            return localData_recordfilestatus;
        }

        public boolean equals(java.lang.Object obj) {
            return (obj == this);
        }

        public int hashCode() {
            return toString().hashCode();
        }

        public java.lang.String toString() {

            return localData_recordfilestatus.toString();


        }


        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {


            org.apache.axiom.om.OMDataSource dataSource =
                    new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {


            //We can safely assume an element has only one type associated with it

            java.lang.String namespace = parentQName.getNamespaceURI();
            java.lang.String _localName = parentQName.getLocalPart();

            writeStartElement(null, namespace, _localName, xmlWriter);

            // add the type details if this is used in a simple type
            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://starsystem.sample/");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":Data_recordfilestatus",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "Data_recordfilestatus",
                            xmlWriter);
                }
            }

            if (localData_recordfilestatus == null) {

                throw new org.apache.axis2.databinding.ADBException("Data_recordfilestatus cannot be null !!");

            } else {

                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localData_recordfilestatus));

            }

            xmlWriter.writeEndElement();


        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://starsystem.sample/")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }


        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if (uri == null || uri.length() == 0) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }


        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {


            //We can safely assume an element has only one type associated with it
            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                    new java.lang.Object[]{
                            org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localData_recordfilestatus)
                    },
                    null);

        }


        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {


            public static Data_recordfilestatus fromValue(org.apache.axis2.databinding.types.UnsignedByte value)
                    throws java.lang.IllegalArgumentException {
                Data_recordfilestatus enumeration = (Data_recordfilestatus)

                        _table_.get(value);


                if ((enumeration == null) && !((value == null) || (value.equals("")))) {
                    throw new java.lang.IllegalArgumentException();
                }
                return enumeration;
            }

            public static Data_recordfilestatus fromString(java.lang.String value, java.lang.String namespaceURI)
                    throws java.lang.IllegalArgumentException {
                try {

                    return fromValue(org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedByte(value));


                } catch (java.lang.Exception e) {
                    throw new java.lang.IllegalArgumentException();
                }
            }

            public static Data_recordfilestatus fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                                                           java.lang.String content) {
                if (content.indexOf(":") > -1) {
                    java.lang.String prefix = content.substring(0, content.indexOf(":"));
                    java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                    return Data_recordfilestatus.Factory.fromString(content, namespaceUri);
                } else {
                    return Data_recordfilestatus.Factory.fromString(content, "");
                }
            }


            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static Data_recordfilestatus parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                Data_recordfilestatus object = null;
                // initialize a hash map to keep values
                java.util.Map attributeMap = new java.util.HashMap();
                java.util.List extraAttributeList = new java.util.ArrayList<org.apache.axiom.om.OMAttribute>();


                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();


                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();


                    while (!reader.isEndElement()) {
                        if (reader.isStartElement() || reader.hasText()) {

                            nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                            if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                                throw new org.apache.axis2.databinding.ADBException("The element: " + "Data_recordfilestatus" + "  cannot be null");
                            }


                            java.lang.String content = reader.getElementText();

                            if (content.indexOf(":") > 0) {
                                // this seems to be a Qname so find the namespace and send
                                prefix = content.substring(0, content.indexOf(":"));
                                namespaceuri = reader.getNamespaceURI(prefix);
                                object = Data_recordfilestatus.Factory.fromString(content, namespaceuri);
                            } else {
                                // this seems to be not a qname send and empty namespace incase of it is
                                // check is done in fromString method
                                object = Data_recordfilestatus.Factory.fromString(content, "");
                            }


                        } else {
                            reader.next();
                        }
                    }  // end of while loop


                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class


    }


    public static class RecordItemResult_type0
            implements org.apache.axis2.databinding.ADBBean {
        /* This type was generated from the piece of schema that had
                name = RecordItemResult_type0
                Namespace URI = http://starsystem.sample/
                Namespace Prefix = ns1
                */


        /**
         * field for Indexno
         */


        protected org.apache.axis2.databinding.types.UnsignedInt localIndexno;


        /**
         * Auto generated getter method
         * @return org.apache.axis2.databinding.types.UnsignedInt
         */
        public org.apache.axis2.databinding.types.UnsignedInt getIndexno() {
            return localIndexno;
        }


        /**
         * Auto generated setter method
         * @param param Indexno
         */
        public void setIndexno(org.apache.axis2.databinding.types.UnsignedInt param) {

            this.localIndexno = param;


        }


        /**
         * field for Filename
         */


        protected java.lang.String localFilename;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getFilename() {
            return localFilename;
        }


        /**
         * Auto generated setter method
         * @param param Filename
         */
        public void setFilename(java.lang.String param) {

            this.localFilename = param;


        }


        /**
         * field for Filepath
         */


        protected java.lang.String localFilepath;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getFilepath() {
            return localFilepath;
        }


        /**
         * Auto generated setter method
         * @param param Filepath
         */
        public void setFilepath(java.lang.String param) {

            this.localFilepath = param;


        }


        /**
         * field for Filesize
         */


        protected int localFilesize;


        /**
         * Auto generated getter method
         * @return int
         */
        public int getFilesize() {
            return localFilesize;
        }


        /**
         * Auto generated setter method
         * @param param Filesize
         */
        public void setFilesize(int param) {

            this.localFilesize = param;


        }


        /**
         * field for Filestatus
         */


        protected Data_recordfilestatus localFilestatus;


        /**
         * Auto generated getter method
         * @return Data_recordfilestatus
         */
        public Data_recordfilestatus getFilestatus() {
            return localFilestatus;
        }


        /**
         * Auto generated setter method
         * @param param Filestatus
         */
        public void setFilestatus(Data_recordfilestatus param) {

            this.localFilestatus = param;


        }


        /**
         * field for Callernum
         */


        protected Data_callnum localCallernum;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localCallernumTracker = false;

        public boolean isCallernumSpecified() {
            return localCallernumTracker;
        }


        /**
         * Auto generated getter method
         * @return Data_callnum
         */
        public Data_callnum getCallernum() {
            return localCallernum;
        }


        /**
         * Auto generated setter method
         * @param param Callernum
         */
        public void setCallernum(Data_callnum param) {
            localCallernumTracker = param != null;

            this.localCallernum = param;


        }


        /**
         * field for Callednum
         */


        protected Data_callnum localCallednum;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localCallednumTracker = false;

        public boolean isCallednumSpecified() {
            return localCallednumTracker;
        }


        /**
         * Auto generated getter method
         * @return Data_callnum
         */
        public Data_callnum getCallednum() {
            return localCallednum;
        }


        /**
         * Auto generated setter method
         * @param param Callednum
         */
        public void setCallednum(Data_callnum param) {
            localCallednumTracker = param != null;

            this.localCallednum = param;


        }


        /**
         * field for Starttime
         */


        protected java.lang.String localStarttime;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getStarttime() {
            return localStarttime;
        }


        /**
         * Auto generated setter method
         * @param param Starttime
         */
        public void setStarttime(java.lang.String param) {

            this.localStarttime = param;


        }


        /**
         * field for Endtime
         */


        protected java.lang.String localEndtime;


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getEndtime() {
            return localEndtime;
        }


        /**
         * Auto generated setter method
         * @param param Endtime
         */
        public void setEndtime(java.lang.String param) {

            this.localEndtime = param;


        }


        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {


            org.apache.axiom.om.OMDataSource dataSource =
                    new org.apache.axis2.databinding.ADBDataSource(this, parentQName);
            return factory.createOMElement(dataSource, parentQName);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {


            java.lang.String prefix = null;
            java.lang.String namespace = null;


            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

            if (serializeType) {


                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://starsystem.sample/");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":RecordItemResult_type0",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "RecordItemResult_type0",
                            xmlWriter);
                }


            }

            namespace = "http://starsystem.sample/";
            writeStartElement(null, namespace, "indexno", xmlWriter);


            if (localIndexno == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException("indexno cannot be null!!");

            } else {


                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIndexno));

            }

            xmlWriter.writeEndElement();

            namespace = "http://starsystem.sample/";
            writeStartElement(null, namespace, "filename", xmlWriter);


            if (localFilename == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException("filename cannot be null!!");

            } else {


                xmlWriter.writeCharacters(localFilename);

            }

            xmlWriter.writeEndElement();

            namespace = "http://starsystem.sample/";
            writeStartElement(null, namespace, "filepath", xmlWriter);


            if (localFilepath == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException("filepath cannot be null!!");

            } else {


                xmlWriter.writeCharacters(localFilepath);

            }

            xmlWriter.writeEndElement();

            namespace = "http://starsystem.sample/";
            writeStartElement(null, namespace, "filesize", xmlWriter);

            if (localFilesize == java.lang.Integer.MIN_VALUE) {

                throw new org.apache.axis2.databinding.ADBException("filesize cannot be null!!");

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFilesize));
            }

            xmlWriter.writeEndElement();

            if (localFilestatus == null) {
                throw new org.apache.axis2.databinding.ADBException("filestatus cannot be null!!");
            }
            localFilestatus.serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "filestatus"),
                    xmlWriter);
            if (localCallernumTracker) {
                if (localCallernum == null) {
                    throw new org.apache.axis2.databinding.ADBException("callernum cannot be null!!");
                }
                localCallernum.serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "callernum"),
                        xmlWriter);
            }
            if (localCallednumTracker) {
                if (localCallednum == null) {
                    throw new org.apache.axis2.databinding.ADBException("callednum cannot be null!!");
                }
                localCallednum.serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "callednum"),
                        xmlWriter);
            }
            namespace = "http://starsystem.sample/";
            writeStartElement(null, namespace, "starttime", xmlWriter);


            if (localStarttime == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException("starttime cannot be null!!");

            } else {


                xmlWriter.writeCharacters(localStarttime);

            }

            xmlWriter.writeEndElement();

            namespace = "http://starsystem.sample/";
            writeStartElement(null, namespace, "endtime", xmlWriter);


            if (localEndtime == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException("endtime cannot be null!!");

            } else {


                xmlWriter.writeCharacters(localEndtime);

            }

            xmlWriter.writeEndElement();

            xmlWriter.writeEndElement();


        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://starsystem.sample/")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }


        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if (uri == null || uri.length() == 0) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }


        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {


            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();


            elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                    "indexno"));

            if (localIndexno != null) {
                elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIndexno));
            } else {
                throw new org.apache.axis2.databinding.ADBException("indexno cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                    "filename"));

            if (localFilename != null) {
                elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFilename));
            } else {
                throw new org.apache.axis2.databinding.ADBException("filename cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                    "filepath"));

            if (localFilepath != null) {
                elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFilepath));
            } else {
                throw new org.apache.axis2.databinding.ADBException("filepath cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                    "filesize"));

            elementList.add(
                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFilesize));

            elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                    "filestatus"));


            if (localFilestatus == null) {
                throw new org.apache.axis2.databinding.ADBException("filestatus cannot be null!!");
            }
            elementList.add(localFilestatus);
            if (localCallernumTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "callernum"));


                if (localCallernum == null) {
                    throw new org.apache.axis2.databinding.ADBException("callernum cannot be null!!");
                }
                elementList.add(localCallernum);
            }
            if (localCallednumTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "callednum"));


                if (localCallednum == null) {
                    throw new org.apache.axis2.databinding.ADBException("callednum cannot be null!!");
                }
                elementList.add(localCallednum);
            }
            elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                    "starttime"));

            if (localStarttime != null) {
                elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localStarttime));
            } else {
                throw new org.apache.axis2.databinding.ADBException("starttime cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                    "endtime"));

            if (localEndtime != null) {
                elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEndtime));
            } else {
                throw new org.apache.axis2.databinding.ADBException("endtime cannot be null!!");
            }


            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());


        }


        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {


            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static RecordItemResult_type0 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                RecordItemResult_type0 object =
                        new RecordItemResult_type0();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();


                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "type");
                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if (!"RecordItemResult_type0".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (RecordItemResult_type0) ExtensionMapper.getTypeObject(
                                        nsUri, type, reader);
                            }


                        }


                    }


                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();


                    reader.next();


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "indexno").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException("The element: " + "indexno" + "  cannot be null");
                        }


                        java.lang.String content = reader.getElementText();

                        object.setIndexno(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedInt(content));

                        reader.next();

                    }  // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "filename").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException("The element: " + "filename" + "  cannot be null");
                        }


                        java.lang.String content = reader.getElementText();

                        object.setFilename(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        reader.next();

                    }  // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "filepath").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException("The element: " + "filepath" + "  cannot be null");
                        }


                        java.lang.String content = reader.getElementText();

                        object.setFilepath(content);
                        //org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content)


                        reader.next();

                    }  // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "filesize").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException("The element: " + "filesize" + "  cannot be null");
                        }


                        java.lang.String content = reader.getElementText();

                        object.setFilesize(
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));

                        reader.next();

                    }  // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "filestatus").equals(reader.getName())) {

                        object.setFilestatus(Data_recordfilestatus.Factory.parse(reader));

                        reader.next();

                    }  // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "callernum").equals(reader.getName())) {
                                        /*if(reader.isEndElement() && !reader.hasNext()){
                                    		object.setCallernum("");
                                        }else{*/
                        object.setCallernum(Data_callnum.Factory.parse(reader));
                        //}
                        reader.next();

                    }  // End of if for expected property start element

                    else {

                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "callednum").equals(reader.getName())) {

                        object.setCallednum(Data_callnum.Factory.parse(reader));

                        reader.next();

                    }  // End of if for expected property start element

                    else {

                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "starttime").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException("The element: " + "starttime" + "  cannot be null");
                        }


                        java.lang.String content = reader.getElementText();

                        object.setStarttime(content);
                        //org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        reader.next();

                    }  // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                    }


                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "endtime").equals(reader.getName())) {

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            throw new org.apache.axis2.databinding.ADBException("The element: " + "endtime" + "  cannot be null");
                        }


                        java.lang.String content = reader.getElementText();

                        object.setEndtime(content);
                        //org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                        reader.next();

                    }  // End of if for expected property start element

                    else {
                        // A start element we are not expecting indicates an invalid parameter was passed
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                    }

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();

                    if (reader.isStartElement())
                        // A start element we are not expecting indicates a trailing invalid property
                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());


                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class


    }


    public static class Data_cdrtype
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://starsystem.sample/",
                "Data_cdrtype",
                "ns1");


        /**
         * field for Data_cdrtype
         */


        protected org.apache.axis2.databinding.types.UnsignedByte localData_cdrtype;

        private static java.util.HashMap _table_ = new java.util.HashMap();

        // Constructor

        protected Data_cdrtype(org.apache.axis2.databinding.types.UnsignedByte value, boolean isRegisterValue) {
            localData_cdrtype = value;
            if (isRegisterValue) {

                _table_.put(localData_cdrtype, this);

            }

        }

        public static final org.apache.axis2.databinding.types.UnsignedByte _value1 =
                org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedByte("0");

        public static final org.apache.axis2.databinding.types.UnsignedByte _value2 =
                org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedByte("1");

        public static final Data_cdrtype value1 =
                new Data_cdrtype(_value1, true);

        public static final Data_cdrtype value2 =
                new Data_cdrtype(_value2, true);


        public org.apache.axis2.databinding.types.UnsignedByte getValue() {
            return localData_cdrtype;
        }

        public boolean equals(java.lang.Object obj) {
            return (obj == this);
        }

        public int hashCode() {
            return toString().hashCode();
        }

        public java.lang.String toString() {

            return localData_cdrtype.toString();


        }


        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {


            org.apache.axiom.om.OMDataSource dataSource =
                    new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {


            //We can safely assume an element has only one type associated with it

            java.lang.String namespace = parentQName.getNamespaceURI();
            java.lang.String _localName = parentQName.getLocalPart();

            writeStartElement(null, namespace, _localName, xmlWriter);

            // add the type details if this is used in a simple type
            if (serializeType) {
                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://starsystem.sample/");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":Data_cdrtype",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "Data_cdrtype",
                            xmlWriter);
                }
            }

            if (localData_cdrtype == null) {

                throw new org.apache.axis2.databinding.ADBException("Data_cdrtype cannot be null !!");

            } else {

                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localData_cdrtype));

            }

            xmlWriter.writeEndElement();


        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://starsystem.sample/")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }


        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if (uri == null || uri.length() == 0) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }


        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {


            //We can safely assume an element has only one type associated with it
            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(MY_QNAME,
                    new java.lang.Object[]{
                            org.apache.axis2.databinding.utils.reader.ADBXMLStreamReader.ELEMENT_TEXT,
                            org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localData_cdrtype)
                    },
                    null);

        }


        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {


            public static Data_cdrtype fromValue(org.apache.axis2.databinding.types.UnsignedByte value)
                    throws java.lang.IllegalArgumentException {
                Data_cdrtype enumeration = (Data_cdrtype)

                        _table_.get(value);


                if ((enumeration == null) && !((value == null) || (value.equals("")))) {
                    throw new java.lang.IllegalArgumentException();
                }
                return enumeration;
            }

            public static Data_cdrtype fromString(java.lang.String value, java.lang.String namespaceURI)
                    throws java.lang.IllegalArgumentException {
                try {

                    return fromValue(org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedByte(value));


                } catch (java.lang.Exception e) {
                    throw new java.lang.IllegalArgumentException();
                }
            }

            public static Data_cdrtype fromString(javax.xml.stream.XMLStreamReader xmlStreamReader,
                                                  java.lang.String content) {
                if (content.indexOf(":") > -1) {
                    java.lang.String prefix = content.substring(0, content.indexOf(":"));
                    java.lang.String namespaceUri = xmlStreamReader.getNamespaceContext().getNamespaceURI(prefix);
                    return Data_cdrtype.Factory.fromString(content, namespaceUri);
                } else {
                    return Data_cdrtype.Factory.fromString(content, "");
                }
            }


            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static Data_cdrtype parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                Data_cdrtype object = null;
                // initialize a hash map to keep values
                java.util.Map attributeMap = new java.util.HashMap();
                java.util.List extraAttributeList = new java.util.ArrayList<org.apache.axiom.om.OMAttribute>();


                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();


                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();


                    while (!reader.isEndElement()) {
                        if (reader.isStartElement() || reader.hasText()) {

                            nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                            if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                                throw new org.apache.axis2.databinding.ADBException("The element: " + "Data_cdrtype" + "  cannot be null");
                            }


                            java.lang.String content = reader.getElementText();

                            if (content.indexOf(":") > 0) {
                                // this seems to be a Qname so find the namespace and send
                                prefix = content.substring(0, content.indexOf(":"));
                                namespaceuri = reader.getNamespaceURI(prefix);
                                object = Data_cdrtype.Factory.fromString(content, namespaceuri);
                            } else {
                                // this seems to be not a qname send and empty namespace incase of it is
                                // check is done in fromString method
                                object = Data_cdrtype.Factory.fromString(content, "");
                            }


                        } else {
                            reader.next();
                        }
                    }  // end of while loop


                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class


    }


    public static class DeleteCdr
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://starsystem.sample/",
                "DeleteCdr",
                "ns1");


        /**
         * field for Cdrtype
         */


        protected Data_cdrtype localCdrtype;


        /**
         * Auto generated getter method
         * @return Data_cdrtype
         */
        public Data_cdrtype getCdrtype() {
            return localCdrtype;
        }


        /**
         * Auto generated setter method
         * @param param Cdrtype
         */
        public void setCdrtype(Data_cdrtype param) {

            this.localCdrtype = param;


        }


        /**
         * field for Dispatcherno
         */


        protected org.apache.axis2.databinding.types.UnsignedShort localDispatcherno;


        /**
         * Auto generated getter method
         * @return org.apache.axis2.databinding.types.UnsignedShort
         */
        public org.apache.axis2.databinding.types.UnsignedShort getDispatcherno() {
            return localDispatcherno;
        }


        /**
         * Auto generated setter method
         * @param param Dispatcherno
         */
        public void setDispatcherno(org.apache.axis2.databinding.types.UnsignedShort param) {

            this.localDispatcherno = param;


        }


        /**
         * field for Idlist
         */


        protected java.lang.String localIdlist;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localIdlistTracker = false;

        public boolean isIdlistSpecified() {
            return localIdlistTracker;
        }


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getIdlist() {
            return localIdlist;
        }


        /**
         * Auto generated setter method
         * @param param Idlist
         */
        public void setIdlist(java.lang.String param) {
            localIdlistTracker = param != null;

            this.localIdlist = param;


        }


        /**
         * field for Starttime
         */


        protected java.lang.String localStarttime;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localStarttimeTracker = false;

        public boolean isStarttimeSpecified() {
            return localStarttimeTracker;
        }


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getStarttime() {
            return localStarttime;
        }


        /**
         * Auto generated setter method
         * @param param Starttime
         */
        public void setStarttime(java.lang.String param) {
            localStarttimeTracker = param != null;

            this.localStarttime = param;


        }


        /**
         * field for Endtime
         */


        protected java.lang.String localEndtime;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localEndtimeTracker = false;

        public boolean isEndtimeSpecified() {
            return localEndtimeTracker;
        }


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getEndtime() {
            return localEndtime;
        }


        /**
         * Auto generated setter method
         * @param param Endtime
         */
        public void setEndtime(java.lang.String param) {
            localEndtimeTracker = param != null;

            this.localEndtime = param;


        }


        /**
         * field for Callernum
         */


        protected Data_callnum localCallernum;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localCallernumTracker = false;

        public boolean isCallernumSpecified() {
            return localCallernumTracker;
        }


        /**
         * Auto generated getter method
         * @return Data_callnum
         */
        public Data_callnum getCallernum() {
            return localCallernum;
        }


        /**
         * Auto generated setter method
         * @param param Callernum
         */
        public void setCallernum(Data_callnum param) {
            localCallernumTracker = param != null;

            this.localCallernum = param;


        }


        /**
         * field for Callednum
         */


        protected Data_callnum localCallednum;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localCallednumTracker = false;

        public boolean isCallednumSpecified() {
            return localCallednumTracker;
        }


        /**
         * Auto generated getter method
         * @return Data_callnum
         */
        public Data_callnum getCallednum() {
            return localCallednum;
        }


        /**
         * Auto generated setter method
         * @param param Callednum
         */
        public void setCallednum(Data_callnum param) {
            localCallednumTracker = param != null;

            this.localCallednum = param;


        }


        /**
         * field for Servicetype
         */


        protected Data_servicetype localServicetype;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localServicetypeTracker = false;

        public boolean isServicetypeSpecified() {
            return localServicetypeTracker;
        }


        /**
         * Auto generated getter method
         * @return Data_servicetype
         */
        public Data_servicetype getServicetype() {
            return localServicetype;
        }


        /**
         * Auto generated setter method
         * @param param Servicetype
         */
        public void setServicetype(Data_servicetype param) {
            localServicetypeTracker = param != null;

            this.localServicetype = param;


        }


        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {


            org.apache.axiom.om.OMDataSource dataSource =
                    new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {


            java.lang.String prefix = null;
            java.lang.String namespace = null;


            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

            if (serializeType) {


                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://starsystem.sample/");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":DeleteCdr",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "DeleteCdr",
                            xmlWriter);
                }


            }

            if (localCdrtype == null) {
                throw new org.apache.axis2.databinding.ADBException("cdrtype cannot be null!!");
            }
            localCdrtype.serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "cdrtype"),
                    xmlWriter);

            namespace = "http://starsystem.sample/";
            writeStartElement(null, namespace, "dispatcherno", xmlWriter);


            if (localDispatcherno == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException("dispatcherno cannot be null!!");

            } else {


                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDispatcherno));

            }

            xmlWriter.writeEndElement();
            if (localIdlistTracker) {
                namespace = "http://starsystem.sample/";
                writeStartElement(null, namespace, "idlist", xmlWriter);


                if (localIdlist == null) {
                    // write the nil attribute

                    throw new org.apache.axis2.databinding.ADBException("idlist cannot be null!!");

                } else {


                    xmlWriter.writeCharacters(localIdlist);

                }

                xmlWriter.writeEndElement();
            }
            if (localStarttimeTracker) {
                namespace = "http://starsystem.sample/";
                writeStartElement(null, namespace, "starttime", xmlWriter);


                if (localStarttime == null) {
                    // write the nil attribute

                    throw new org.apache.axis2.databinding.ADBException("starttime cannot be null!!");

                } else {


                    xmlWriter.writeCharacters(localStarttime);

                }

                xmlWriter.writeEndElement();
            }
            if (localEndtimeTracker) {
                namespace = "http://starsystem.sample/";
                writeStartElement(null, namespace, "endtime", xmlWriter);


                if (localEndtime == null) {
                    // write the nil attribute

                    throw new org.apache.axis2.databinding.ADBException("endtime cannot be null!!");

                } else {


                    xmlWriter.writeCharacters(localEndtime);

                }

                xmlWriter.writeEndElement();
            }
            if (localCallernumTracker) {
                if (localCallernum == null) {
                    throw new org.apache.axis2.databinding.ADBException("callernum cannot be null!!");
                }
                localCallernum.serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "callernum"),
                        xmlWriter);
            }
            if (localCallednumTracker) {
                if (localCallednum == null) {
                    throw new org.apache.axis2.databinding.ADBException("callednum cannot be null!!");
                }
                localCallednum.serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "callednum"),
                        xmlWriter);
            }
            if (localServicetypeTracker) {
                if (localServicetype == null) {
                    throw new org.apache.axis2.databinding.ADBException("servicetype cannot be null!!");
                }
                localServicetype.serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "servicetype"),
                        xmlWriter);
            }
            xmlWriter.writeEndElement();


        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://starsystem.sample/")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }


        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if (uri == null || uri.length() == 0) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }


        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {


            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();


            elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                    "cdrtype"));


            if (localCdrtype == null) {
                throw new org.apache.axis2.databinding.ADBException("cdrtype cannot be null!!");
            }
            elementList.add(localCdrtype);

            elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                    "dispatcherno"));

            if (localDispatcherno != null) {
                elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDispatcherno));
            } else {
                throw new org.apache.axis2.databinding.ADBException("dispatcherno cannot be null!!");
            }
            if (localIdlistTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "idlist"));

                if (localIdlist != null) {
                    elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIdlist));
                } else {
                    throw new org.apache.axis2.databinding.ADBException("idlist cannot be null!!");
                }
            }
            if (localStarttimeTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "starttime"));

                if (localStarttime != null) {
                    elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localStarttime));
                } else {
                    throw new org.apache.axis2.databinding.ADBException("starttime cannot be null!!");
                }
            }
            if (localEndtimeTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "endtime"));

                if (localEndtime != null) {
                    elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEndtime));
                } else {
                    throw new org.apache.axis2.databinding.ADBException("endtime cannot be null!!");
                }
            }
            if (localCallernumTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "callernum"));


                if (localCallernum == null) {
                    throw new org.apache.axis2.databinding.ADBException("callernum cannot be null!!");
                }
                elementList.add(localCallernum);
            }
            if (localCallednumTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "callednum"));


                if (localCallednum == null) {
                    throw new org.apache.axis2.databinding.ADBException("callednum cannot be null!!");
                }
                elementList.add(localCallednum);
            }
            if (localServicetypeTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "servicetype"));


                if (localServicetype == null) {
                    throw new org.apache.axis2.databinding.ADBException("servicetype cannot be null!!");
                }
                elementList.add(localServicetype);
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());


        }


        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {


            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static DeleteCdr parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                DeleteCdr object =
                        new DeleteCdr();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();


                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "type");
                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if (!"DeleteCdr".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (DeleteCdr) ExtensionMapper.getTypeObject(
                                        nsUri, type, reader);
                            }


                        }


                    }


                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();


                    reader.next();

                    while (!reader.isEndElement()) {
                        if (reader.isStartElement()) {

                            if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "cdrtype").equals(reader.getName())) {

                                object.setCdrtype(Data_cdrtype.Factory.parse(reader));

                                reader.next();

                            }  // End of if for expected property start element

                            else if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "dispatcherno").equals(reader.getName())) {

                                nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                                    throw new org.apache.axis2.databinding.ADBException("The element: " + "dispatcherno" + "  cannot be null");
                                }


                                java.lang.String content = reader.getElementText();

                                object.setDispatcherno(
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedShort(content));

                                reader.next();

                            }  // End of if for expected property start element

                            else if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "idlist").equals(reader.getName())) {

                                nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                                    throw new org.apache.axis2.databinding.ADBException("The element: " + "idlist" + "  cannot be null");
                                }


                                java.lang.String content = reader.getElementText();

                                object.setIdlist(
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                reader.next();

                            }  // End of if for expected property start element

                            else if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "starttime").equals(reader.getName())) {

                                nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                                    throw new org.apache.axis2.databinding.ADBException("The element: " + "starttime" + "  cannot be null");
                                }


                                java.lang.String content = reader.getElementText();

                                object.setStarttime(
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                reader.next();

                            }  // End of if for expected property start element

                            else if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "endtime").equals(reader.getName())) {

                                nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                                    throw new org.apache.axis2.databinding.ADBException("The element: " + "endtime" + "  cannot be null");
                                }


                                java.lang.String content = reader.getElementText();

                                object.setEndtime(
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                reader.next();

                            }  // End of if for expected property start element

                            else if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "callernum").equals(reader.getName())) {

                                object.setCallernum(Data_callnum.Factory.parse(reader));

                                reader.next();

                            }  // End of if for expected property start element

                            else if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "callednum").equals(reader.getName())) {

                                object.setCallednum(Data_callnum.Factory.parse(reader));

                                reader.next();

                            }  // End of if for expected property start element

                            else if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "servicetype").equals(reader.getName())) {

                                object.setServicetype(Data_servicetype.Factory.parse(reader));

                                reader.next();

                            }  // End of if for expected property start element

                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop


                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class


    }


    public static class QueryCdrResponseChoice_type0
            implements org.apache.axis2.databinding.ADBBean {
        /* This type was generated from the piece of schema that had
                name = QueryCdrResponseChoice_type0
                Namespace URI = http://starsystem.sample/
                Namespace Prefix = ns1
                */

        /** Whenever a new property is set ensure all others are unset
         *  There can be only one choice and the last one wins
         */
        private void clearAllSettingTrackers() {

            localCallCdrItemResultTracker = false;

            localServiceCdrItemResultTracker = false;

        }


        /**
         * field for CallCdrItemResult
         * This was an Array!
         */


        protected CallCdrItemResult_type0[] localCallCdrItemResult;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localCallCdrItemResultTracker = false;

        public boolean isCallCdrItemResultSpecified() {
            return localCallCdrItemResultTracker;
        }


        /**
         * Auto generated getter method
         * @return CallCdrItemResult_type0[]
         */
        public CallCdrItemResult_type0[] getCallCdrItemResult() {
            return localCallCdrItemResult;
        }


        /**
         * validate the array for CallCdrItemResult
         */
        protected void validateCallCdrItemResult(CallCdrItemResult_type0[] param) {

            if ((param != null) && (param.length > 32)) {
                throw new java.lang.RuntimeException();
            }

        }


        /**
         * Auto generated setter method
         * @param param CallCdrItemResult
         */
        public void setCallCdrItemResult(CallCdrItemResult_type0[] param) {

            validateCallCdrItemResult(param);


            clearAllSettingTrackers();
            localCallCdrItemResultTracker = true;

            this.localCallCdrItemResult = param;
        }


        /**
         * Auto generated add method for the array for convenience
         * @param param CallCdrItemResult_type0
         */
        public void addCallCdrItemResult(CallCdrItemResult_type0 param) {
            if (localCallCdrItemResult == null) {
                localCallCdrItemResult = new CallCdrItemResult_type0[]{};
            }


            clearAllSettingTrackers();

            //update the setting tracker
            localCallCdrItemResultTracker = true;


            java.util.List list =
                    org.apache.axis2.databinding.utils.ConverterUtil.toList(localCallCdrItemResult);
            list.add(param);
            this.localCallCdrItemResult =
                    (CallCdrItemResult_type0[]) list.toArray(
                            new CallCdrItemResult_type0[list.size()]);

        }


        /**
         * field for ServiceCdrItemResult
         * This was an Array!
         */


        protected ServiceCdrItemResult_type0[] localServiceCdrItemResult;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localServiceCdrItemResultTracker = false;

        public boolean isServiceCdrItemResultSpecified() {
            return localServiceCdrItemResultTracker;
        }


        /**
         * Auto generated getter method
         * @return ServiceCdrItemResult_type0[]
         */
        public ServiceCdrItemResult_type0[] getServiceCdrItemResult() {
            return localServiceCdrItemResult;
        }


        /**
         * validate the array for ServiceCdrItemResult
         */
        protected void validateServiceCdrItemResult(ServiceCdrItemResult_type0[] param) {

            if ((param != null) && (param.length > 32)) {
                throw new java.lang.RuntimeException();
            }

        }


        /**
         * Auto generated setter method
         * @param param ServiceCdrItemResult
         */
        public void setServiceCdrItemResult(ServiceCdrItemResult_type0[] param) {

            validateServiceCdrItemResult(param);


            clearAllSettingTrackers();
            localServiceCdrItemResultTracker = true;

            this.localServiceCdrItemResult = param;
        }


        /**
         * Auto generated add method for the array for convenience
         * @param param ServiceCdrItemResult_type0
         */
        public void addServiceCdrItemResult(ServiceCdrItemResult_type0 param) {
            if (localServiceCdrItemResult == null) {
                localServiceCdrItemResult = new ServiceCdrItemResult_type0[]{};
            }


            clearAllSettingTrackers();

            //update the setting tracker
            localServiceCdrItemResultTracker = true;


            java.util.List list =
                    org.apache.axis2.databinding.utils.ConverterUtil.toList(localServiceCdrItemResult);
            list.add(param);
            this.localServiceCdrItemResult =
                    (ServiceCdrItemResult_type0[]) list.toArray(
                            new ServiceCdrItemResult_type0[list.size()]);

        }


        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {


            org.apache.axiom.om.OMDataSource dataSource =
                    new org.apache.axis2.databinding.ADBDataSource(this, parentQName);
            return factory.createOMElement(dataSource, parentQName);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {


            java.lang.String prefix = null;
            java.lang.String namespace = null;

            if (serializeType) {


                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://starsystem.sample/");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":QueryCdrResponseChoice_type0",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "QueryCdrResponseChoice_type0",
                            xmlWriter);
                }


            }
            if (localCallCdrItemResultTracker) {
                if (localCallCdrItemResult != null) {
                    for (int i = 0; i < localCallCdrItemResult.length; i++) {
                        if (localCallCdrItemResult[i] != null) {
                            localCallCdrItemResult[i].serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "CallCdrItemResult"),
                                    xmlWriter);
                        } else {

                            writeStartElement(null, "http://starsystem.sample/", "CallCdrItemResult", xmlWriter);

                            // write the nil attribute
                            writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
                            xmlWriter.writeEndElement();

                        }

                    }
                } else {

                    writeStartElement(null, "http://starsystem.sample/", "CallCdrItemResult", xmlWriter);

                    // write the nil attribute
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
                    xmlWriter.writeEndElement();

                }
            }
            if (localServiceCdrItemResultTracker) {
                if (localServiceCdrItemResult != null) {
                    for (int i = 0; i < localServiceCdrItemResult.length; i++) {
                        if (localServiceCdrItemResult[i] != null) {
                            localServiceCdrItemResult[i].serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "ServiceCdrItemResult"),
                                    xmlWriter);
                        } else {

                            writeStartElement(null, "http://starsystem.sample/", "ServiceCdrItemResult", xmlWriter);

                            // write the nil attribute
                            writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
                            xmlWriter.writeEndElement();

                        }

                    }
                } else {

                    writeStartElement(null, "http://starsystem.sample/", "ServiceCdrItemResult", xmlWriter);

                    // write the nil attribute
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
                    xmlWriter.writeEndElement();

                }
            }

        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://starsystem.sample/")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }


        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if (uri == null || uri.length() == 0) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }


        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {


            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();

            if (localCallCdrItemResultTracker) {
                if (localCallCdrItemResult != null) {
                    for (int i = 0; i < localCallCdrItemResult.length; i++) {

                        if (localCallCdrItemResult[i] != null) {
                            elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                                    "CallCdrItemResult"));
                            elementList.add(localCallCdrItemResult[i]);
                        } else {

                            elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                                    "CallCdrItemResult"));
                            elementList.add(null);

                        }

                    }
                } else {

                    elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                            "CallCdrItemResult"));
                    elementList.add(localCallCdrItemResult);

                }

            }
            if (localServiceCdrItemResultTracker) {
                if (localServiceCdrItemResult != null) {
                    for (int i = 0; i < localServiceCdrItemResult.length; i++) {

                        if (localServiceCdrItemResult[i] != null) {
                            elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                                    "ServiceCdrItemResult"));
                            elementList.add(localServiceCdrItemResult[i]);
                        } else {

                            elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                                    "ServiceCdrItemResult"));
                            elementList.add(null);

                        }

                    }
                } else {

                    elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                            "ServiceCdrItemResult"));
                    elementList.add(localServiceCdrItemResult);

                }

            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());


        }


        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {


            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static QueryCdrResponseChoice_type0 parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                QueryCdrResponseChoice_type0 object =
                        new QueryCdrResponseChoice_type0();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();


                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();


                    java.util.ArrayList list1 = new java.util.ArrayList();

                    java.util.ArrayList list2 = new java.util.ArrayList();

                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "CallCdrItemResult").equals(reader.getName())) {


                        // Process the array and step past its final element's end.

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            list1.add(null);
                            reader.next();
                        } else {
                            list1.add(CallCdrItemResult_type0.Factory.parse(reader));
                        }
                        //loop until we find a start element that is not part of this array
                        boolean loopDone1 = false;
                        while (!loopDone1) {
                            // We should be at the end element, but make sure
                            while (!reader.isEndElement())
                                reader.next();
                            // Step out of this element
                            reader.next();
                            // Step to next element event.
                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();
                            if (reader.isEndElement()) {
                                //two continuous end elements means we are exiting the xml structure
                                loopDone1 = true;
                            } else {
                                if (new javax.xml.namespace.QName("http://starsystem.sample/", "CallCdrItemResult").equals(reader.getName())) {

                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                                        list1.add(null);
                                        reader.next();
                                    } else {
                                        list1.add(CallCdrItemResult_type0.Factory.parse(reader));
                                    }
                                } else {
                                    loopDone1 = true;
                                }
                            }
                        }
                        // call the converter utility  to convert and set the array

                        object.setCallCdrItemResult((CallCdrItemResult_type0[])
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                        CallCdrItemResult_type0.class,
                                        list1));

                    }  // End of if for expected property start element

                    else if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "ServiceCdrItemResult").equals(reader.getName())) {


                        // Process the array and step past its final element's end.

                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                            list2.add(null);
                            reader.next();
                        } else {
                            list2.add(ServiceCdrItemResult_type0.Factory.parse(reader));
                        }
                        //loop until we find a start element that is not part of this array
                        boolean loopDone2 = false;
                        while (!loopDone2) {
                            // We should be at the end element, but make sure
                            while (!reader.isEndElement())
                                reader.next();
                            // Step out of this element
                            reader.next();
                            // Step to next element event.
                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();
                            if (reader.isEndElement()) {
                                //two continuous end elements means we are exiting the xml structure
                                loopDone2 = true;
                            } else {
                                if (new javax.xml.namespace.QName("http://starsystem.sample/", "ServiceCdrItemResult").equals(reader.getName())) {

                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                                        list2.add(null);
                                        reader.next();
                                    } else {
                                        list2.add(ServiceCdrItemResult_type0.Factory.parse(reader));
                                    }
                                } else {
                                    loopDone2 = true;
                                }
                            }
                        }
                        // call the converter utility  to convert and set the array

                        object.setServiceCdrItemResult((ServiceCdrItemResult_type0[])
                                org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                        ServiceCdrItemResult_type0.class,
                                        list2));

                    }  // End of if for expected property start element


                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class


    }


    public static class QueryCdr
            implements org.apache.axis2.databinding.ADBBean {

        public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://starsystem.sample/",
                "QueryCdr",
                "ns1");


        /**
         * field for Cdrtype
         */


        protected Data_cdrtype localCdrtype;


        /**
         * Auto generated getter method
         * @return Data_cdrtype
         */
        public Data_cdrtype getCdrtype() {
            return localCdrtype;
        }


        /**
         * Auto generated setter method
         * @param param Cdrtype
         */
        public void setCdrtype(Data_cdrtype param) {

            this.localCdrtype = param;


        }


        /**
         * field for Dispatcherno
         */


        protected org.apache.axis2.databinding.types.UnsignedShort localDispatcherno;


        /**
         * Auto generated getter method
         * @return org.apache.axis2.databinding.types.UnsignedShort
         */
        public org.apache.axis2.databinding.types.UnsignedShort getDispatcherno() {
            return localDispatcherno;
        }


        /**
         * Auto generated setter method
         * @param param Dispatcherno
         */
        public void setDispatcherno(org.apache.axis2.databinding.types.UnsignedShort param) {

            this.localDispatcherno = param;


        }


        /**
         * field for Startid
         */


        protected Data_startid localStartid;


        /**
         * Auto generated getter method
         * @return Data_startid
         */
        public Data_startid getStartid() {
            return localStartid;
        }


        /**
         * Auto generated setter method
         * @param param Startid
         */
        public void setStartid(Data_startid param) {

            this.localStartid = param;


        }


        /**
         * field for Skipnum
         */


        protected org.apache.axis2.databinding.types.UnsignedShort localSkipnum;


        /**
         * Auto generated getter method
         * @return org.apache.axis2.databinding.types.UnsignedShort
         */
        public org.apache.axis2.databinding.types.UnsignedShort getSkipnum() {
            return localSkipnum;
        }


        /**
         * Auto generated setter method
         * @param param Skipnum
         */
        public void setSkipnum(org.apache.axis2.databinding.types.UnsignedShort param) {

            this.localSkipnum = param;


        }


        /**
         * field for Recordnum
         */


        protected Data_recordnum localRecordnum;


        /**
         * Auto generated getter method
         * @return Data_recordnum
         */
        public Data_recordnum getRecordnum() {
            return localRecordnum;
        }


        /**
         * Auto generated setter method
         * @param param Recordnum
         */
        public void setRecordnum(Data_recordnum param) {

            this.localRecordnum = param;


        }


        /**
         * field for Direction
         */


        protected Data_direction localDirection;


        /**
         * Auto generated getter method
         * @return Data_direction
         */
        public Data_direction getDirection() {
            return localDirection;
        }


        /**
         * Auto generated setter method
         * @param param Direction
         */
        public void setDirection(Data_direction param) {

            this.localDirection = param;


        }


        /**
         * field for Starttime
         */


        protected java.lang.String localStarttime;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localStarttimeTracker = false;

        public boolean isStarttimeSpecified() {
            return localStarttimeTracker;
        }


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getStarttime() {
            return localStarttime;
        }


        /**
         * Auto generated setter method
         * @param param Starttime
         */
        public void setStarttime(java.lang.String param) {
            localStarttimeTracker = param != null;

            this.localStarttime = param;


        }


        /**
         * field for Endtime
         */


        protected java.lang.String localEndtime;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localEndtimeTracker = false;

        public boolean isEndtimeSpecified() {
            return localEndtimeTracker;
        }


        /**
         * Auto generated getter method
         * @return java.lang.String
         */
        public java.lang.String getEndtime() {
            return localEndtime;
        }


        /**
         * Auto generated setter method
         * @param param Endtime
         */
        public void setEndtime(java.lang.String param) {
            localEndtimeTracker = param != null;

            this.localEndtime = param;


        }


        /**
         * field for Callernum
         */


        protected Data_callnum localCallernum;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localCallernumTracker = false;

        public boolean isCallernumSpecified() {
            return localCallernumTracker;
        }


        /**
         * Auto generated getter method
         * @return Data_callnum
         */
        public Data_callnum getCallernum() {
            return localCallernum;
        }


        /**
         * Auto generated setter method
         * @param param Callernum
         */
        public void setCallernum(Data_callnum param) {
            localCallernumTracker = param != null;

            this.localCallernum = param;


        }


        /**
         * field for Callednum
         */


        protected Data_callnum localCallednum;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localCallednumTracker = false;

        public boolean isCallednumSpecified() {
            return localCallednumTracker;
        }


        /**
         * Auto generated getter method
         * @return Data_callnum
         */
        public Data_callnum getCallednum() {
            return localCallednum;
        }


        /**
         * Auto generated setter method
         * @param param Callednum
         */
        public void setCallednum(Data_callnum param) {
            localCallednumTracker = param != null;

            this.localCallednum = param;


        }


        /**
         * field for Servicetype
         */


        protected Data_servicetype localServicetype;

        /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
        protected boolean localServicetypeTracker = false;

        public boolean isServicetypeSpecified() {
            return localServicetypeTracker;
        }


        /**
         * Auto generated getter method
         * @return Data_servicetype
         */
        public Data_servicetype getServicetype() {
            return localServicetype;
        }


        /**
         * Auto generated setter method
         * @param param Servicetype
         */
        public void setServicetype(Data_servicetype param) {
            localServicetypeTracker = param != null;

            this.localServicetype = param;


        }


        /**
         *
         * @param parentQName
         * @param factory
         * @return org.apache.axiom.om.OMElement
         */
        public org.apache.axiom.om.OMElement getOMElement(
                final javax.xml.namespace.QName parentQName,
                final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {


            org.apache.axiom.om.OMDataSource dataSource =
                    new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
            return factory.createOMElement(dataSource, MY_QNAME);

        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(final javax.xml.namespace.QName parentQName,
                              javax.xml.stream.XMLStreamWriter xmlWriter,
                              boolean serializeType)
                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException {


            java.lang.String prefix = null;
            java.lang.String namespace = null;


            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

            if (serializeType) {


                java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://starsystem.sample/");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            namespacePrefix + ":QueryCdr",
                            xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                            "QueryCdr",
                            xmlWriter);
                }


            }

            if (localCdrtype == null) {
                throw new org.apache.axis2.databinding.ADBException("cdrtype cannot be null!!");
            }
            localCdrtype.serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "cdrtype"),
                    xmlWriter);

            namespace = "http://starsystem.sample/";
            writeStartElement(null, namespace, "dispatcherno", xmlWriter);


            if (localDispatcherno == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException("dispatcherno cannot be null!!");

            } else {


                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDispatcherno));

            }

            xmlWriter.writeEndElement();

            if (localStartid == null) {
                throw new org.apache.axis2.databinding.ADBException("startid cannot be null!!");
            }
            localStartid.serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "startid"),
                    xmlWriter);

            namespace = "http://starsystem.sample/";
            writeStartElement(null, namespace, "skipnum", xmlWriter);


            if (localSkipnum == null) {
                // write the nil attribute

                throw new org.apache.axis2.databinding.ADBException("skipnum cannot be null!!");

            } else {


                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSkipnum));

            }

            xmlWriter.writeEndElement();

            if (localRecordnum == null) {
                throw new org.apache.axis2.databinding.ADBException("recordnum cannot be null!!");
            }
            localRecordnum.serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "recordnum"),
                    xmlWriter);

            if (localDirection == null) {
                throw new org.apache.axis2.databinding.ADBException("direction cannot be null!!");
            }
            localDirection.serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "direction"),
                    xmlWriter);
            if (localStarttimeTracker) {
                namespace = "http://starsystem.sample/";
                writeStartElement(null, namespace, "starttime", xmlWriter);


                if (localStarttime == null) {
                    // write the nil attribute

                    throw new org.apache.axis2.databinding.ADBException("starttime cannot be null!!");

                } else {


                    xmlWriter.writeCharacters(localStarttime);

                }

                xmlWriter.writeEndElement();
            }
            if (localEndtimeTracker) {
                namespace = "http://starsystem.sample/";
                writeStartElement(null, namespace, "endtime", xmlWriter);


                if (localEndtime == null) {
                    // write the nil attribute

                    throw new org.apache.axis2.databinding.ADBException("endtime cannot be null!!");

                } else {


                    xmlWriter.writeCharacters(localEndtime);

                }

                xmlWriter.writeEndElement();
            }
            if (localCallernumTracker) {
                if (localCallernum == null) {
                    throw new org.apache.axis2.databinding.ADBException("callernum cannot be null!!");
                }
                localCallernum.serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "callernum"),
                        xmlWriter);
            }
            if (localCallednumTracker) {
                if (localCallednum == null) {
                    throw new org.apache.axis2.databinding.ADBException("callednum cannot be null!!");
                }
                localCallednum.serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "callednum"),
                        xmlWriter);
            }
            if (localServicetypeTracker) {
                if (localServicetype == null) {
                    throw new org.apache.axis2.databinding.ADBException("servicetype cannot be null!!");
                }
                localServicetype.serialize(new javax.xml.namespace.QName("http://starsystem.sample/", "servicetype"),
                        xmlWriter);
            }
            xmlWriter.writeEndElement();


        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if (namespace.equals("http://starsystem.sample/")) {
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix, java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace, java.lang.String attName,
                                    java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attValue);
            }
        }


        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                         javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            java.lang.String attributeNamespace = qname.getNamespaceURI();
            java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null) {
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            }
            java.lang.String attributeValue;
            if (attributePrefix.trim().length() > 0) {
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            } else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace, attName, attributeValue);
            }
        }

        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0) {
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if (uri == null || uri.length() == 0) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }


        /**
         * databinding method to get an XML representation of this object
         *
         */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                throws org.apache.axis2.databinding.ADBException {


            java.util.ArrayList elementList = new java.util.ArrayList();
            java.util.ArrayList attribList = new java.util.ArrayList();


            elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                    "cdrtype"));


            if (localCdrtype == null) {
                throw new org.apache.axis2.databinding.ADBException("cdrtype cannot be null!!");
            }
            elementList.add(localCdrtype);

            elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                    "dispatcherno"));

            if (localDispatcherno != null) {
                elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDispatcherno));
            } else {
                throw new org.apache.axis2.databinding.ADBException("dispatcherno cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                    "startid"));


            if (localStartid == null) {
                throw new org.apache.axis2.databinding.ADBException("startid cannot be null!!");
            }
            elementList.add(localStartid);

            elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                    "skipnum"));

            if (localSkipnum != null) {
                elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSkipnum));
            } else {
                throw new org.apache.axis2.databinding.ADBException("skipnum cannot be null!!");
            }

            elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                    "recordnum"));


            if (localRecordnum == null) {
                throw new org.apache.axis2.databinding.ADBException("recordnum cannot be null!!");
            }
            elementList.add(localRecordnum);

            elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                    "direction"));


            if (localDirection == null) {
                throw new org.apache.axis2.databinding.ADBException("direction cannot be null!!");
            }
            elementList.add(localDirection);
            if (localStarttimeTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "starttime"));

                if (localStarttime != null) {
                    elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localStarttime));
                } else {
                    throw new org.apache.axis2.databinding.ADBException("starttime cannot be null!!");
                }
            }
            if (localEndtimeTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "endtime"));

                if (localEndtime != null) {
                    elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEndtime));
                } else {
                    throw new org.apache.axis2.databinding.ADBException("endtime cannot be null!!");
                }
            }
            if (localCallernumTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "callernum"));


                if (localCallernum == null) {
                    throw new org.apache.axis2.databinding.ADBException("callernum cannot be null!!");
                }
                elementList.add(localCallernum);
            }
            if (localCallednumTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "callednum"));


                if (localCallednum == null) {
                    throw new org.apache.axis2.databinding.ADBException("callednum cannot be null!!");
                }
                elementList.add(localCallednum);
            }
            if (localServicetypeTracker) {
                elementList.add(new javax.xml.namespace.QName("http://starsystem.sample/",
                        "servicetype"));


                if (localServicetype == null) {
                    throw new org.apache.axis2.databinding.ADBException("servicetype cannot be null!!");
                }
                elementList.add(localServicetype);
            }

            return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());


        }


        /**
         *  Factory class that keeps the parse method
         */
        public static class Factory {


            /**
             * static method to create the object
             * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
             *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
             * Postcondition: If this object is an element, the reader is positioned at its end element
             *                If this object is a complex type, the reader is positioned at the end element of its outer element
             */
            public static QueryCdr parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
                QueryCdr object =
                        new QueryCdr();

                int event;
                java.lang.String nillableValue = null;
                java.lang.String prefix = "";
                java.lang.String namespaceuri = "";
                try {

                    while (!reader.isStartElement() && !reader.isEndElement())
                        reader.next();


                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                                "type");
                        if (fullTypeName != null) {
                            java.lang.String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if (!"QueryCdr".equals(type)) {
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (QueryCdr) ExtensionMapper.getTypeObject(
                                        nsUri, type, reader);
                            }


                        }


                    }


                    // Note all attributes that were handled. Used to differ normal attributes
                    // from anyAttributes.
                    java.util.Vector handledAttributes = new java.util.Vector();


                    reader.next();

                    while (!reader.isEndElement()) {
                        if (reader.isStartElement()) {

                            if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "cdrtype").equals(reader.getName())) {

                                object.setCdrtype(Data_cdrtype.Factory.parse(reader));

                                reader.next();

                            }  // End of if for expected property start element

                            else if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "dispatcherno").equals(reader.getName())) {

                                nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                                    throw new org.apache.axis2.databinding.ADBException("The element: " + "dispatcherno" + "  cannot be null");
                                }


                                java.lang.String content = reader.getElementText();

                                object.setDispatcherno(
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedShort(content));

                                reader.next();

                            }  // End of if for expected property start element

                            else if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "startid").equals(reader.getName())) {

                                object.setStartid(Data_startid.Factory.parse(reader));

                                reader.next();

                            }  // End of if for expected property start element

                            else if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "skipnum").equals(reader.getName())) {

                                nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                                    throw new org.apache.axis2.databinding.ADBException("The element: " + "skipnum" + "  cannot be null");
                                }


                                java.lang.String content = reader.getElementText();

                                object.setSkipnum(
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToUnsignedShort(content));

                                reader.next();

                            }  // End of if for expected property start element

                            else if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "recordnum").equals(reader.getName())) {

                                object.setRecordnum(Data_recordnum.Factory.parse(reader));

                                reader.next();

                            }  // End of if for expected property start element

                            else if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "direction").equals(reader.getName())) {

                                object.setDirection(Data_direction.Factory.parse(reader));

                                reader.next();

                            }  // End of if for expected property start element

                            else if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "starttime").equals(reader.getName())) {

                                nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                                    throw new org.apache.axis2.databinding.ADBException("The element: " + "starttime" + "  cannot be null");
                                }


                                java.lang.String content = reader.getElementText();

                                object.setStarttime(
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                reader.next();

                            }  // End of if for expected property start element

                            else if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "endtime").equals(reader.getName())) {

                                nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if ("true".equals(nillableValue) || "1".equals(nillableValue)) {
                                    throw new org.apache.axis2.databinding.ADBException("The element: " + "endtime" + "  cannot be null");
                                }


                                java.lang.String content = reader.getElementText();

                                object.setEndtime(
                                        org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                reader.next();

                            }  // End of if for expected property start element

                            else if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "callernum").equals(reader.getName())) {

                                object.setCallernum(Data_callnum.Factory.parse(reader));

                                reader.next();

                            }  // End of if for expected property start element

                            else if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "callednum").equals(reader.getName())) {

                                object.setCallednum(Data_callnum.Factory.parse(reader));

                                reader.next();

                            }  // End of if for expected property start element

                            else if (reader.isStartElement() && new javax.xml.namespace.QName("http://starsystem.sample/", "servicetype").equals(reader.getName())) {

                                object.setServicetype(Data_servicetype.Factory.parse(reader));

                                reader.next();

                            }  // End of if for expected property start element

                            else {
                                // A start element we are not expecting indicates an invalid parameter was passed
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                            }

                        } else {
                            reader.next();
                        }
                    }  // end of while loop


                } catch (javax.xml.stream.XMLStreamException e) {
                    throw new java.lang.Exception(e);
                }

                return object;
            }

        }//end of factory class


    }


    private org.apache.axiom.om.OMElement toOM(com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DeleteRecord param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DeleteRecord.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DeleteRecordResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DeleteRecordResponse.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DownloadCdr param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DownloadCdr.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DownloadCdrResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DownloadCdrResponse.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DeleteCdr param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DeleteCdr.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DeleteCdrResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DeleteCdrResponse.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.QueryCdr param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.QueryCdr.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.QueryCdrResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.QueryCdrResponse.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.QueryRecord param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.QueryRecord.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }

    private org.apache.axiom.om.OMElement toOM(com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.QueryRecordResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


        try {
            return param.getOMElement(com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.QueryRecordResponse.MY_QNAME,
                    org.apache.axiom.om.OMAbstractFactory.getOMFactory());
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }


    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DeleteRecord param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
            throws org.apache.axis2.AxisFault {


        try {

            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody().addChild(param.getOMElement(com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DeleteRecord.MY_QNAME, factory));
            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }


                             /* methods to provide back word compatibility */


    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DownloadCdr param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
            throws org.apache.axis2.AxisFault {


        try {

            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody().addChild(param.getOMElement(com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DownloadCdr.MY_QNAME, factory));
            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }


                             /* methods to provide back word compatibility */


    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DeleteCdr param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
            throws org.apache.axis2.AxisFault {


        try {

            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody().addChild(param.getOMElement(com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DeleteCdr.MY_QNAME, factory));
            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }


                             /* methods to provide back word compatibility */


    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.QueryCdr param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
            throws org.apache.axis2.AxisFault {


        try {

            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody().addChild(param.getOMElement(com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.QueryCdr.MY_QNAME, factory));
            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }


                             /* methods to provide back word compatibility */


    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.QueryRecord param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
            throws org.apache.axis2.AxisFault {


        try {

            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody().addChild(param.getOMElement(com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.QueryRecord.MY_QNAME, factory));
            return emptyEnvelope;
        } catch (org.apache.axis2.databinding.ADBException e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }


    }


                             /* methods to provide back word compatibility */


    /**
     *  get the default envelope
     */
    private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory) {
        return factory.getDefaultEnvelope();
    }


    private java.lang.Object fromOM(
            org.apache.axiom.om.OMElement param,
            java.lang.Class type,
            java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault {

        try {

            if (com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DeleteRecord.class.equals(type)) {

                return com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DeleteRecord.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DeleteRecordResponse.class.equals(type)) {

                return com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DeleteRecordResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DownloadCdr.class.equals(type)) {

                return com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DownloadCdr.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DownloadCdrResponse.class.equals(type)) {

                return com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DownloadCdrResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DeleteCdr.class.equals(type)) {

                return com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DeleteCdr.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DeleteCdrResponse.class.equals(type)) {

                return com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DeleteCdrResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.QueryCdr.class.equals(type)) {

                return com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.QueryCdr.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.QueryCdrResponse.class.equals(type)) {

                return com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.QueryCdrResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.QueryRecord.class.equals(type)) {

                return com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.QueryRecord.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

            if (com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.QueryRecordResponse.class.equals(type)) {

                return com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.QueryRecordResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


            }

        } catch (java.lang.Exception e) {
            throw org.apache.axis2.AxisFault.makeFault(e);
        }
        return null;
    }


}
   