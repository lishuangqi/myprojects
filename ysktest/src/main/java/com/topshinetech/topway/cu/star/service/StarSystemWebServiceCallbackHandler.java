
/**
 * StarSystemWebServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.topshinetech.topway.cu.dis.service;

    /**
     *  StarSystemWebServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class StarSystemWebServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public StarSystemWebServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public StarSystemWebServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for deleteRecord method
            * override this method for handling normal response from deleteRecord operation
            */
           public void receiveResultdeleteRecord(
                    com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DeleteRecordResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteRecord operation
           */
            public void receiveErrordeleteRecord(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for downloadCdr method
            * override this method for handling normal response from downloadCdr operation
            */
           public void receiveResultdownloadCdr(
                    com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DownloadCdrResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from downloadCdr operation
           */
            public void receiveErrordownloadCdr(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteCdr method
            * override this method for handling normal response from deleteCdr operation
            */
           public void receiveResultdeleteCdr(
                    com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.DeleteCdrResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteCdr operation
           */
            public void receiveErrordeleteCdr(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for queryCdr method
            * override this method for handling normal response from queryCdr operation
            */
           public void receiveResultqueryCdr(
                    com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.QueryCdrResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from queryCdr operation
           */
            public void receiveErrorqueryCdr(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for queryRecord method
            * override this method for handling normal response from queryRecord operation
            */
           public void receiveResultqueryRecord(
                    com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub.QueryRecordResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from queryRecord operation
           */
            public void receiveErrorqueryRecord(java.lang.Exception e) {
            }
                


    }
    