
/**
 * DisSystemWebServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.topshinetech.topway.cu.dis.service;

    /**
     *  DisSystemWebServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class DisSystemWebServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public DisSystemWebServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public DisSystemWebServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for disAddConfMem method
            * override this method for handling normal response from disAddConfMem operation
            */
           public void receiveResultdisAddConfMem(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisAddConfMemResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disAddConfMem operation
           */
            public void receiveErrordisAddConfMem(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disQueryCallIn method
            * override this method for handling normal response from disQueryCallIn operation
            */
           public void receiveResultdisQueryCallIn(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisQueryCallInResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disQueryCallIn operation
           */
            public void receiveErrordisQueryCallIn(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disQueryPredefineConfmemstate method
            * override this method for handling normal response from disQueryPredefineConfmemstate operation
            */
           public void receiveResultdisQueryPredefineConfmemstate(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisQueryPredefineConfmemstateResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disQueryPredefineConfmemstate operation
           */
            public void receiveErrordisQueryPredefineConfmemstate(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disStopMonitor method
            * override this method for handling normal response from disStopMonitor operation
            */
           public void receiveResultdisStopMonitor(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisStopMonitorResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disStopMonitor operation
           */
            public void receiveErrordisStopMonitor(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disDelBlackUser method
            * override this method for handling normal response from disDelBlackUser operation
            */
           public void receiveResultdisDelBlackUser(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisDelBlackUserResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disDelBlackUser operation
           */
            public void receiveErrordisDelBlackUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disMngAddGroup method
            * override this method for handling normal response from disMngAddGroup operation
            */
           public void receiveResultdisMngAddGroup(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisMngAddGroupResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disMngAddGroup operation
           */
            public void receiveErrordisMngAddGroup(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disSelectGroup method
            * override this method for handling normal response from disSelectGroup operation
            */
           public void receiveResultdisSelectGroup(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisSelectGroupResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disSelectGroup operation
           */
            public void receiveErrordisSelectGroup(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disGetPredefineConfInfo method
            * override this method for handling normal response from disGetPredefineConfInfo operation
            */
           public void receiveResultdisGetPredefineConfInfo(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisGetPredefineConfInfoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disGetPredefineConfInfo operation
           */
            public void receiveErrordisGetPredefineConfInfo(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disSayFree method
            * override this method for handling normal response from disSayFree operation
            */
           public void receiveResultdisSayFree(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisSayFreeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disSayFree operation
           */
            public void receiveErrordisSayFree(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disAddPredefineSAduConf method
            * override this method for handling normal response from disAddPredefineSAduConf operation
            */
           public void receiveResultdisAddPredefineSAduConf(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisAddPredefineSAduConfResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disAddPredefineSAduConf operation
           */
            public void receiveErrordisAddPredefineSAduConf(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disCtrlConfBrocast method
            * override this method for handling normal response from disCtrlConfBrocast operation
            */
           public void receiveResultdisCtrlConfBrocast(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisCtrlConfBrocastResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disCtrlConfBrocast operation
           */
            public void receiveErrordisCtrlConfBrocast(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disQueryDispathcer method
            * override this method for handling normal response from disQueryDispathcer operation
            */
           public void receiveResultdisQueryDispathcer(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisQueryDispathcerResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disQueryDispathcer operation
           */
            public void receiveErrordisQueryDispathcer(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disKickConfMem method
            * override this method for handling normal response from disKickConfMem operation
            */
           public void receiveResultdisKickConfMem(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisKickConfMemResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disKickConfMem operation
           */
            public void receiveErrordisKickConfMem(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disAddPredefineSOrdConf method
            * override this method for handling normal response from disAddPredefineSOrdConf operation
            */
           public void receiveResultdisAddPredefineSOrdConf(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisAddPredefineSOrdConfResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disAddPredefineSOrdConf operation
           */
            public void receiveErrordisAddPredefineSOrdConf(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disThreePartyCall method
            * override this method for handling normal response from disThreePartyCall operation
            */
           public void receiveResultdisThreePartyCall(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisThreePartyCallResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disThreePartyCall operation
           */
            public void receiveErrordisThreePartyCall(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disTransferCall method
            * override this method for handling normal response from disTransferCall operation
            */
           public void receiveResultdisTransferCall(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisTransferCallResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disTransferCall operation
           */
            public void receiveErrordisTransferCall(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disAddPredefineXAduConf method
            * override this method for handling normal response from disAddPredefineXAduConf operation
            */
           public void receiveResultdisAddPredefineXAduConf(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisAddPredefineXAduConfResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disAddPredefineXAduConf operation
           */
            public void receiveErrordisAddPredefineXAduConf(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disAnswer method
            * override this method for handling normal response from disAnswer operation
            */
           public void receiveResultdisAnswer(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisAnswerResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disAnswer operation
           */
            public void receiveErrordisAnswer(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disQueryTalkingList method
            * override this method for handling normal response from disQueryTalkingList operation
            */
           public void receiveResultdisQueryTalkingList(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisQueryTalkingListResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disQueryTalkingList operation
           */
            public void receiveErrordisQueryTalkingList(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disQueryDispatcherList method
            * override this method for handling normal response from disQueryDispatcherList operation
            */
           public void receiveResultdisQueryDispatcherList(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisQueryDispatcherListResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disQueryDispatcherList operation
           */
            public void receiveErrordisQueryDispatcherList(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disMdfyPredefineConf method
            * override this method for handling normal response from disMdfyPredefineConf operation
            */
           public void receiveResultdisMdfyPredefineConf(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisMdfyPredefineConfResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disMdfyPredefineConf operation
           */
            public void receiveErrordisMdfyPredefineConf(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disQueryOrdinaryCall method
            * override this method for handling normal response from disQueryOrdinaryCall operation
            */
           public void receiveResultdisQueryOrdinaryCall(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisQueryOrdinaryCallResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disQueryOrdinaryCall operation
           */
            public void receiveErrordisQueryOrdinaryCall(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disQuerySmsList method
            * override this method for handling normal response from disQuerySmsList operation
            */
           public void receiveResultdisQuerySmsList(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisQuerySmsListResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disQuerySmsList operation
           */
            public void receiveErrordisQuerySmsList(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disAddPredefineXOrdConf method
            * override this method for handling normal response from disAddPredefineXOrdConf operation
            */
           public void receiveResultdisAddPredefineXOrdConf(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisAddPredefineXOrdConfResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disAddPredefineXOrdConf operation
           */
            public void receiveErrordisAddPredefineXOrdConf(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disHeartBeat method
            * override this method for handling normal response from disHeartBeat operation
            */
           public void receiveResultdisHeartBeat(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisHeartBeatResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disHeartBeat operation
           */
            public void receiveErrordisHeartBeat(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disCallStopPlay method
            * override this method for handling normal response from disCallStopPlay operation
            */
           public void receiveResultdisCallStopPlay(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisCallStopPlayResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disCallStopPlay operation
           */
            public void receiveErrordisCallStopPlay(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disAddBlackUser method
            * override this method for handling normal response from disAddBlackUser operation
            */
           public void receiveResultdisAddBlackUser(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisAddBlackUserResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disAddBlackUser operation
           */
            public void receiveErrordisAddBlackUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disQueryAllDispathcerinfo method
            * override this method for handling normal response from disQueryAllDispathcerinfo operation
            */
           public void receiveResultdisQueryAllDispathcerinfo(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisQueryAllDispathcerinfoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disQueryAllDispathcerinfo operation
           */
            public void receiveErrordisQueryAllDispathcerinfo(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disOrdinaryCallStopRecord method
            * override this method for handling normal response from disOrdinaryCallStopRecord operation
            */
           public void receiveResultdisOrdinaryCallStopRecord(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisOrdinaryCallStopRecordResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disOrdinaryCallStopRecord operation
           */
            public void receiveErrordisOrdinaryCallStopRecord(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disQueryConfMem method
            * override this method for handling normal response from disQueryConfMem operation
            */
           public void receiveResultdisQueryConfMem(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisQueryConfMemResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disQueryConfMem operation
           */
            public void receiveErrordisQueryConfMem(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disQueryPredefineConflist method
            * override this method for handling normal response from disQueryPredefineConflist operation
            */
           public void receiveResultdisQueryPredefineConflist(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisQueryPredefineConflistResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disQueryPredefineConflist operation
           */
            public void receiveErrordisQueryPredefineConflist(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disQueryHoldList method
            * override this method for handling normal response from disQueryHoldList operation
            */
           public void receiveResultdisQueryHoldList(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisQueryHoldListResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disQueryHoldList operation
           */
            public void receiveErrordisQueryHoldList(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disMngQueryGroupList method
            * override this method for handling normal response from disMngQueryGroupList operation
            */
           public void receiveResultdisMngQueryGroupList(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisMngQueryGroupListResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disMngQueryGroupList operation
           */
            public void receiveErrordisMngQueryGroupList(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disAddPredefineHAConf method
            * override this method for handling normal response from disAddPredefineHAConf operation
            */
           public void receiveResultdisAddPredefineHAConf(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisAddPredefineHAConfResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disAddPredefineHAConf operation
           */
            public void receiveErrordisAddPredefineHAConf(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for queryDispLogigMsg method
            * override this method for handling normal response from queryDispLogigMsg operation
            */
           public void receiveResultqueryDispLogigMsg(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.QueryDispLogigMsgResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from queryDispLogigMsg operation
           */
            public void receiveErrorqueryDispLogigMsg(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disMngMdfyUser method
            * override this method for handling normal response from disMngMdfyUser operation
            */
           public void receiveResultdisMngMdfyUser(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisMngMdfyUserResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disMngMdfyUser operation
           */
            public void receiveErrordisMngMdfyUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disCreateNewSms method
            * override this method for handling normal response from disCreateNewSms operation
            */
           public void receiveResultdisCreateNewSms(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisCreateNewSmsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disCreateNewSms operation
           */
            public void receiveErrordisCreateNewSms(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disChangHand method
            * override this method for handling normal response from disChangHand operation
            */
           public void receiveResultdisChangHand(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisChangHandResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disChangHand operation
           */
            public void receiveErrordisChangHand(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disMngMdfyGroup method
            * override this method for handling normal response from disMngMdfyGroup operation
            */
           public void receiveResultdisMngMdfyGroup(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisMngMdfyGroupResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disMngMdfyGroup operation
           */
            public void receiveErrordisMngMdfyGroup(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disCancelSendSms method
            * override this method for handling normal response from disCancelSendSms operation
            */
           public void receiveResultdisCancelSendSms(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisCancelSendSmsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disCancelSendSms operation
           */
            public void receiveErrordisCancelSendSms(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disForbidSpeech method
            * override this method for handling normal response from disForbidSpeech operation
            */
           public void receiveResultdisForbidSpeech(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisForbidSpeechResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disForbidSpeech operation
           */
            public void receiveErrordisForbidSpeech(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disQueryBlackUser method
            * override this method for handling normal response from disQueryBlackUser operation
            */
           public void receiveResultdisQueryBlackUser(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisQueryBlackUserResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disQueryBlackUser operation
           */
            public void receiveErrordisQueryBlackUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disDelPredefineConf method
            * override this method for handling normal response from disDelPredefineConf operation
            */
           public void receiveResultdisDelPredefineConf(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisDelPredefineConfResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disDelPredefineConf operation
           */
            public void receiveErrordisDelPredefineConf(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disOffHold method
            * override this method for handling normal response from disOffHold operation
            */
           public void receiveResultdisOffHold(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisOffHoldResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disOffHold operation
           */
            public void receiveErrordisOffHold(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disGetStarIP method
            * override this method for handling normal response from disGetStarIP operation
            */
           public void receiveResultdisGetStarIP(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisGetStarIPResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disGetStarIP operation
           */
            public void receiveErrordisGetStarIP(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disCallHold method
            * override this method for handling normal response from disCallHold operation
            */
           public void receiveResultdisCallHold(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisCallHoldResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disCallHold operation
           */
            public void receiveErrordisCallHold(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disStartEvent method
            * override this method for handling normal response from disStartEvent operation
            */
           public void receiveResultdisStartEvent(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisStartEventResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disStartEvent operation
           */
            public void receiveErrordisStartEvent(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disAddPredefineHOConf method
            * override this method for handling normal response from disAddPredefineHOConf operation
            */
           public void receiveResultdisAddPredefineHOConf(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisAddPredefineHOConfResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disAddPredefineHOConf operation
           */
            public void receiveErrordisAddPredefineHOConf(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disQueryMutiGroupState method
            * override this method for handling normal response from disQueryMutiGroupState operation
            */
           public void receiveResultdisQueryMutiGroupState(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisQueryMutiGroupStateResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disQueryMutiGroupState operation
           */
            public void receiveErrordisQueryMutiGroupState(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disSelectCall method
            * override this method for handling normal response from disSelectCall operation
            */
           public void receiveResultdisSelectCall(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisSelectCallResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disSelectCall operation
           */
            public void receiveErrordisSelectCall(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disMngGetGroup method
            * override this method for handling normal response from disMngGetGroup operation
            */
           public void receiveResultdisMngGetGroup(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisMngGetGroupResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disMngGetGroup operation
           */
            public void receiveErrordisMngGetGroup(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disQueryPlayFileList method
            * override this method for handling normal response from disQueryPlayFileList operation
            */
           public void receiveResultdisQueryPlayFileList(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisQueryPlayFileListResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disQueryPlayFileList operation
           */
            public void receiveErrordisQueryPlayFileList(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disStartRollcall method
            * override this method for handling normal response from disStartRollcall operation
            */
           public void receiveResultdisStartRollcall(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisStartRollcallResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disStartRollcall operation
           */
            public void receiveErrordisStartRollcall(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disLongPolling method
            * override this method for handling normal response from disLongPolling operation
            */
           public void receiveResultdisLongPolling(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisLongPollingResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disLongPolling operation
           */
            public void receiveErrordisLongPolling(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disQueryUserList method
            * override this method for handling normal response from disQueryUserList operation
            */
           public void receiveResultdisQueryUserList(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisQueryUserListResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disQueryUserList operation
           */
            public void receiveErrordisQueryUserList(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disCallPlay method
            * override this method for handling normal response from disCallPlay operation
            */
           public void receiveResultdisCallPlay(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisCallPlayResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disCallPlay operation
           */
            public void receiveErrordisCallPlay(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disSendSms method
            * override this method for handling normal response from disSendSms operation
            */
           public void receiveResultdisSendSms(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisSendSmsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disSendSms operation
           */
            public void receiveErrordisSendSms(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disQueryConfList method
            * override this method for handling normal response from disQueryConfList operation
            */
           public void receiveResultdisQueryConfList(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisQueryConfListResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disQueryConfList operation
           */
            public void receiveErrordisQueryConfList(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disModifyBlackUser method
            * override this method for handling normal response from disModifyBlackUser operation
            */
           public void receiveResultdisModifyBlackUser(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisModifyBlackUserResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disModifyBlackUser operation
           */
            public void receiveErrordisModifyBlackUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disCallOut method
            * override this method for handling normal response from disCallOut operation
            */
           public void receiveResultdisCallOut(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisCallOutResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disCallOut operation
           */
            public void receiveErrordisCallOut(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disMngDelUser method
            * override this method for handling normal response from disMngDelUser operation
            */
           public void receiveResultdisMngDelUser(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisMngDelUserResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disMngDelUser operation
           */
            public void receiveErrordisMngDelUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disQueryMutiUserState method
            * override this method for handling normal response from disQueryMutiUserState operation
            */
           public void receiveResultdisQueryMutiUserState(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisQueryMutiUserStateResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disQueryMutiUserState operation
           */
            public void receiveErrordisQueryMutiUserState(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disForbidSpeechByCallcr method
            * override this method for handling normal response from disForbidSpeechByCallcr operation
            */
           public void receiveResultdisForbidSpeechByCallcr(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisForbidSpeechByCallcrResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disForbidSpeechByCallcr operation
           */
            public void receiveErrordisForbidSpeechByCallcr(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disStartGroupConf method
            * override this method for handling normal response from disStartGroupConf operation
            */
           public void receiveResultdisStartGroupConf(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisStartGroupConfResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disStartGroupConf operation
           */
            public void receiveErrordisStartGroupConf(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disMngDelGroup method
            * override this method for handling normal response from disMngDelGroup operation
            */
           public void receiveResultdisMngDelGroup(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisMngDelGroupResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disMngDelGroup operation
           */
            public void receiveErrordisMngDelGroup(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disInsteadOfAnswer method
            * override this method for handling normal response from disInsteadOfAnswer operation
            */
           public void receiveResultdisInsteadOfAnswer(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisInsteadOfAnswerResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disInsteadOfAnswer operation
           */
            public void receiveErrordisInsteadOfAnswer(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disAddPredefineConfV1 method
            * override this method for handling normal response from disAddPredefineConfV1 operation
            */
           public void receiveResultdisAddPredefineConfV1(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisAddPredefineConfV1Response result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disAddPredefineConfV1 operation
           */
            public void receiveErrordisAddPredefineConfV1(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disQueryDispatcheruserlist method
            * override this method for handling normal response from disQueryDispatcheruserlist operation
            */
           public void receiveResultdisQueryDispatcheruserlist(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisQueryDispatcheruserlistResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disQueryDispatcheruserlist operation
           */
            public void receiveErrordisQueryDispatcheruserlist(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disDeletePlayFile method
            * override this method for handling normal response from disDeletePlayFile operation
            */
           public void receiveResultdisDeletePlayFile(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisDeletePlayFileResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disDeletePlayFile operation
           */
            public void receiveErrordisDeletePlayFile(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disStartConf method
            * override this method for handling normal response from disStartConf operation
            */
           public void receiveResultdisStartConf(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisStartConfResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disStartConf operation
           */
            public void receiveErrordisStartConf(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disMultiAnswer method
            * override this method for handling normal response from disMultiAnswer operation
            */
           public void receiveResultdisMultiAnswer(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisMultiAnswerResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disMultiAnswer operation
           */
            public void receiveErrordisMultiAnswer(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disQueryConfmemstate method
            * override this method for handling normal response from disQueryConfmemstate operation
            */
           public void receiveResultdisQueryConfmemstate(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisQueryConfmemstateResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disQueryConfmemstate operation
           */
            public void receiveErrordisQueryConfmemstate(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disPermitSpeech method
            * override this method for handling normal response from disPermitSpeech operation
            */
           public void receiveResultdisPermitSpeech(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisPermitSpeechResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disPermitSpeech operation
           */
            public void receiveErrordisPermitSpeech(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disStopEvent method
            * override this method for handling normal response from disStopEvent operation
            */
           public void receiveResultdisStopEvent(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisStopEventResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disStopEvent operation
           */
            public void receiveErrordisStopEvent(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disRecordCallOut method
            * override this method for handling normal response from disRecordCallOut operation
            */
           public void receiveResultdisRecordCallOut(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisRecordCallOutResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disRecordCallOut operation
           */
            public void receiveErrordisRecordCallOut(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disCtrlConfRecord method
            * override this method for handling normal response from disCtrlConfRecord operation
            */
           public void receiveResultdisCtrlConfRecord(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisCtrlConfRecordResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disCtrlConfRecord operation
           */
            public void receiveErrordisCtrlConfRecord(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disStartConfBrocast method
            * override this method for handling normal response from disStartConfBrocast operation
            */
           public void receiveResultdisStartConfBrocast(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisStartConfBrocastResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disStartConfBrocast operation
           */
            public void receiveErrordisStartConfBrocast(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disForceInsert method
            * override this method for handling normal response from disForceInsert operation
            */
           public void receiveResultdisForceInsert(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisForceInsertResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disForceInsert operation
           */
            public void receiveErrordisForceInsert(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disGetOneSms method
            * override this method for handling normal response from disGetOneSms operation
            */
           public void receiveResultdisGetOneSms(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisGetOneSmsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disGetOneSms operation
           */
            public void receiveErrordisGetOneSms(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disOrdinaryCallStartRecord method
            * override this method for handling normal response from disOrdinaryCallStartRecord operation
            */
           public void receiveResultdisOrdinaryCallStartRecord(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisOrdinaryCallStartRecordResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disOrdinaryCallStartRecord operation
           */
            public void receiveErrordisOrdinaryCallStartRecord(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disSayBusy method
            * override this method for handling normal response from disSayBusy operation
            */
           public void receiveResultdisSayBusy(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisSayBusyResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disSayBusy operation
           */
            public void receiveErrordisSayBusy(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disLogin method
            * override this method for handling normal response from disLogin operation
            */
           public void receiveResultdisLogin(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisLoginResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disLogin operation
           */
            public void receiveErrordisLogin(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disLogout method
            * override this method for handling normal response from disLogout operation
            */
           public void receiveResultdisLogout(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisLogoutResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disLogout operation
           */
            public void receiveErrordisLogout(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disQueryGroupConfmemstate method
            * override this method for handling normal response from disQueryGroupConfmemstate operation
            */
           public void receiveResultdisQueryGroupConfmemstate(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisQueryGroupConfmemstateResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disQueryGroupConfmemstate operation
           */
            public void receiveErrordisQueryGroupConfmemstate(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disPartyCall method
            * override this method for handling normal response from disPartyCall operation
            */
           public void receiveResultdisPartyCall(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisPartyCallResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disPartyCall operation
           */
            public void receiveErrordisPartyCall(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disWebAudition method
            * override this method for handling normal response from disWebAudition operation
            */
           public void receiveResultdisWebAudition(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisWebAuditionResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disWebAudition operation
           */
            public void receiveErrordisWebAudition(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disBreakDown method
            * override this method for handling normal response from disBreakDown operation
            */
           public void receiveResultdisBreakDown(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisBreakDownResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disBreakDown operation
           */
            public void receiveErrordisBreakDown(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disDeleteSms method
            * override this method for handling normal response from disDeleteSms operation
            */
           public void receiveResultdisDeleteSms(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisDeleteSmsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disDeleteSms operation
           */
            public void receiveErrordisDeleteSms(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disQuerySSUserstate method
            * override this method for handling normal response from disQuerySSUserstate operation
            */
           public void receiveResultdisQuerySSUserstate(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisQuerySSUserstateResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disQuerySSUserstate operation
           */
            public void receiveErrordisQuerySSUserstate(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disPermitSpeechByCallcr method
            * override this method for handling normal response from disPermitSpeechByCallcr operation
            */
           public void receiveResultdisPermitSpeechByCallcr(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisPermitSpeechByCallcrResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disPermitSpeechByCallcr operation
           */
            public void receiveErrordisPermitSpeechByCallcr(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disStartMonitor method
            * override this method for handling normal response from disStartMonitor operation
            */
           public void receiveResultdisStartMonitor(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisStartMonitorResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disStartMonitor operation
           */
            public void receiveErrordisStartMonitor(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disDestroyConf method
            * override this method for handling normal response from disDestroyConf operation
            */
           public void receiveResultdisDestroyConf(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisDestroyConfResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disDestroyConf operation
           */
            public void receiveErrordisDestroyConf(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disMngAddUser method
            * override this method for handling normal response from disMngAddUser operation
            */
           public void receiveResultdisMngAddUser(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisMngAddUserResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disMngAddUser operation
           */
            public void receiveErrordisMngAddUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disGetKeyBoardSettings method
            * override this method for handling normal response from disGetKeyBoardSettings operation
            */
           public void receiveResultdisGetKeyBoardSettings(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisGetKeyBoardSettingsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disGetKeyBoardSettings operation
           */
            public void receiveErrordisGetKeyBoardSettings(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disCreateConf method
            * override this method for handling normal response from disCreateConf operation
            */
           public void receiveResultdisCreateConf(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisCreateConfResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disCreateConf operation
           */
            public void receiveErrordisCreateConf(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disSystemMaintain method
            * override this method for handling normal response from disSystemMaintain operation
            */
           public void receiveResultdisSystemMaintain(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisSystemMaintainResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disSystemMaintain operation
           */
            public void receiveErrordisSystemMaintain(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disMngQueryUserList method
            * override this method for handling normal response from disMngQueryUserList operation
            */
           public void receiveResultdisMngQueryUserList(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisMngQueryUserListResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disMngQueryUserList operation
           */
            public void receiveErrordisMngQueryUserList(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disForceRelease method
            * override this method for handling normal response from disForceRelease operation
            */
           public void receiveResultdisForceRelease(
                    com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisForceReleaseResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disForceRelease operation
           */
            public void receiveErrordisForceRelease(java.lang.Exception e) {
            }
                


    }
    