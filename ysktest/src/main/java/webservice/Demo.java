package webservice; 


import java.net.ConnectException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub;
import com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.Data_LoginMode;
import com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.Data_ReportMode;

import org.apache.axis2.AxisFault;
import org.apache.axis2.databinding.types.UnsignedByte;
import org.apache.axis2.databinding.types.UnsignedInt;
import org.apache.axis2.databinding.types.UnsignedShort;

import java.rmi.RemoteException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.axis2.AxisFault;


public class Demo  implements Runnable{
	private static final Logger LOGGER = LoggerFactory.getLogger(Demo.class);

    public static final byte RESULT_SUCC = 0;
    public static final byte RESULT_SUCC_AND_DATA = 1;  //成功并且有数据返回
    public static final byte RESULT_FAIL = -1;
   
    private byte BTCOUNT_MAX = 5;
    
    public static DisSystemWebServiceStub disStub;   //调度系统接口
    public static DemoCallback democallback;   //调度系统回调接口

    
    private boolean runflag = false;
    private Thread thr;
    private long hbInterval = 1000*10;//心跳时间为10秒
    private byte resendCount = 0; //重发次数大于最大值登出，并停止心跳线程
  
    private UnsignedShort disCenterNo;
    private UnsignedShort dispatcherNo;
    private UnsignedInt sessonId;
    
    private static Demo des;
    
	public Demo()
	{
		disLogin();
		createConf();
	}
	
	public static void main (String [] args) {
        try {
        	disStub = new DisSystemWebServiceStub("http://10.168.20.191/cgi-bin/soapcgi-dir");
        	disStub._getServiceClient().getOptions().setProperty(org.apache.axis2.transport.http.HTTPConstants.CHUNKED, Boolean.FALSE); 
        	
        	democallback = new DemoCallback();
        	
        	des = new Demo();
        	
        } catch (AxisFault e) {
            // TODO Auto-generated catch block
        	System.out.println("login error!");
            e.printStackTrace();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
        	System.out.println("login error failed!");
            e.printStackTrace();
        }
        
    }
	

    @SuppressWarnings("rawtypes")
    public void disLogin(){
        try {
            DisSystemWebServiceStub.Data_callnum centerno = new  DisSystemWebServiceStub.Data_callnum();
            centerno.setData_callnum("6666");//调度中心号
                      
            org.apache.axis2.databinding.types.UnsignedByte lmode = new org.apache.axis2.databinding.types.UnsignedByte();
            lmode.setValue(0);
            /*DisSystemWebServiceStub.Data_LoginMode loginmode = new DisSystemWebServiceStub.Data_LoginMode(lmode,true);

            org.apache.axis2.databinding.types.UnsignedByte rmode = new org.apache.axis2.databinding.types.UnsignedByte();
            rmode.setValue(1);
            DisSystemWebServiceStub.Data_ReportMode reportmode = new DisSystemWebServiceStub.Data_ReportMode(rmode,true);*/
         
            DisSystemWebServiceStub.DisLogin login = new DisSystemWebServiceStub.DisLogin();
            login.setLoginmode(Data_LoginMode.value2);
            login.setReportmode(Data_ReportMode.value2);
            login.setCenterno(centerno);
            login.setDspusername("root1");
            login.setPassword("123456");          
            
            LOGGER.debug("disLogin start");

            DisSystemWebServiceStub.DisLoginResponse response = disStub.disLogin(login);
            DisSystemWebServiceStub.Data_returnflag returnflag = response.getReturnflag();
            
            if((null!= response) && (response.getReturnflag().getValue() == RESULT_SUCC)){
            	this.disCenterNo = response.getDiscenterno();
            	this.dispatcherNo = response.getDispatcherno();
            	this.sessonId = response.getSessionid();
                
                LOGGER.debug("disLogin OK sessonId="+this.sessonId+" dispatcherNo="+this.dispatcherNo+" disCenterNo="+this.disCenterNo);
                if(null !=  thr && thr.isAlive()){
                    thr.stop(); 
                }
                
                thr = new Thread(this);
                thr.start(); //启动心跳
                
            }else{
                LOGGER.error("disLogin fail,returnflag="+response.getReturnflag().getValue());
            }
        } catch (AxisFault e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
	  
    @SuppressWarnings("rawtypes")
    public void disHeartBeat(){
        
        if(null == sessonId || null == dispatcherNo){
            LOGGER.error("disHeartBeat: no login ,sessonId or dispatcherNo is null");
            return;
        }
        try {
            DisSystemWebServiceStub.DisHeartBeat bean = new DisSystemWebServiceStub.DisHeartBeat();
            bean.setSessionid(sessonId);
            bean.setDispatcherno(dispatcherNo);
            DisSystemWebServiceStub.DisHeartBeatResponse response = disStub.disHeartBeat(bean);
            if((null!= response) && (response.getReturnflag().getValue() == RESULT_SUCC)){
                //LOGGER.debug("disHeartBeat succ"+" sessonId="+sessonId+" dispatcherNo="+dispatcherNo); 
                resendCount = 0;
            }else{
                LOGGER.error("disHeartBeat fail,returnflag="+response.getReturnflag().getValue()+" sessonId="+sessonId+" dispatcherNo="+dispatcherNo); 
                resendCount++;
                if(resendCount>=BTCOUNT_MAX){
                    resendCount = 0;
                    disLogout();
                    stopService();
                    LOGGER.error("disHeartBeat fail count>3 logout"); 
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            LOGGER.debug("disHeartBeat exception：sessonId="+sessonId+" dispatcherNo="+dispatcherNo); 
            resendCount++;
            if(resendCount>=BTCOUNT_MAX){
                resendCount = 0;
                disLogout();
                
                stopService();
                LOGGER.error("disHeartBeat fail count>3 logout"); 
            }
        }
    }
    
    /** 
    * @Title: stopService 
    * @Description: TODO 停止进程，并初始化资源
    * @param     
    * @return void
    * @throws 
    */
    public void stopService(){
        dispatcherNo = null;
        sessonId = null;
        disCenterNo = null;
        try{
            if(null != thr && thr.isAlive()){
                thr.stop();
                cancel();//停止心跳线程
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void run() {
        runflag = true;
        long waittime = 0;
        while(runflag){
            if(waittime>=hbInterval){
            	this.disHeartBeat(); //给调度系统发心跳
            	this.queryConflist();
                waittime = 0;
            }
            try {
                Thread.sleep(hbInterval);
                waittime += hbInterval;
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                cancel();
            }
        }
    }
    public void cancel(){
        runflag = false;
        Thread.currentThread().interrupt();
    }
    

    @SuppressWarnings("rawtypes")
    public void disLogout(){
        
        if(null == sessonId || null == dispatcherNo){
            LOGGER.error("disLogout: no login ,sessonId or dispatcherNo is null");
            return;
        }
        LOGGER.debug("sessonId="+sessonId+" dispatcherNo="+dispatcherNo);
        try {
            DisSystemWebServiceStub.DisLogout bean = new DisSystemWebServiceStub.DisLogout();
            bean.setSessionid(sessonId);
            bean.setDispatcherno(dispatcherNo);
            DisSystemWebServiceStub.DisLogoutResponse response = disStub.disLogout(bean);
            if((null!= response) && (response.getReturnflag().getValue() == RESULT_SUCC)){
                LOGGER.debug("disLogout succ"); 
            }else{
                LOGGER.error("disLogout fail,returnflag="+response.getReturnflag().getValue()+" sessonId="+sessonId+" dispatcherNo="+dispatcherNo); 
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            LOGGER.debug("disLogout exception：sessonId="+sessonId+" dispatcherNo="+dispatcherNo); 
        }
    }

    /********************************创建会场，异步*************************************/
  	@SuppressWarnings("unchecked")
    public void createConf(){	
		try {
		   DisSystemWebServiceStub.DisCreateConf  createconfBean = new DisSystemWebServiceStub.DisCreateConf();
		      
		   createconfBean.setDispatcherno(dispatcherNo);
		   createconfBean.setSessionid(sessonId);
		   createconfBean.setConfname("你好");;
		   createconfBean.setHeadcount(new UnsignedShort(10));
		   createconfBean.setVideoflag(new UnsignedByte(0));
		   createconfBean.setVieweachpage(new UnsignedByte(4));
		   
		   LOGGER.debug("异步调用！");   
		   
		   disStub.startdisCreateConf(createconfBean, democallback); 
       }catch (RemoteException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }catch (Exception e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
    }

    /********************************查询类*************************************/
  	@SuppressWarnings("unchecked")
    public void queryConflist(){	
		try {
		   DisSystemWebServiceStub.DisQueryConfList  queryconfBean = new DisSystemWebServiceStub.DisQueryConfList();
		      
	       queryconfBean.setDispatcherno(dispatcherNo);
	       queryconfBean.setSessionid(sessonId);
	       queryconfBean.setRecordstart(new UnsignedShort(0));
	       queryconfBean.setRecordnum(new UnsignedShort(32));
		        
       	   DisSystemWebServiceStub.DisQueryConfListResponse response =disStub.disQueryConfList(queryconfBean);
       		
           DisSystemWebServiceStub.Data_returnflag returnflag = response.getReturnflag();
         
           if (returnflag.getValue() == RESULT_SUCC)
           {
               LOGGER.debug("queryConflist OK no data");
           }
           else if(returnflag.getValue() == RESULT_SUCC_AND_DATA){
               for(int i = 0; i<response.getConfItemResult().length; i++){
            	   LOGGER.debug("queryConflist i:"+i+" getSvrno"+response.getConfItemResult()[i].getSvrno()+
            			   " getConfname:"+response.getConfItemResult()[i].getConfname()+
            			   " getMemnum:"+response.getConfItemResult()[i].getMemnum()+
            			   " getMemnum:"+response.getConfItemResult()[i].getMemnum()+
            			   " getPlayflag:"+response.getConfItemResult()[i].getPlayflag()+
            			   " getRecordflag:"+response.getConfItemResult()[i].getRecordflag());
               }
               
           }else{
               LOGGER.debug("queryConflist Fail");
           }
       }catch (RemoteException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }catch (Exception e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
    }
  	
  	
}
