package webservice;


import com.topshinetech.topway.cu.dis.service.StarSystemWebServiceStub;
import org.apache.axis2.AxisFault;
import org.apache.axis2.databinding.types.UnsignedByte;
import org.apache.axis2.databinding.types.UnsignedInt;
import org.apache.axis2.databinding.types.UnsignedShort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.rmi.RemoteException;


public class StarDemo {
	private static final Logger LOGGER = LoggerFactory.getLogger(StarDemo.class);

    public static final byte RESULT_SUCC = 0;
    public static final byte RESULT_SUCC_AND_DATA = 1;  //�ɹ����������ݷ���
    public static final byte RESULT_FAIL = -1;

    private byte BTCOUNT_MAX = 5;

    public static StarSystemWebServiceStub startSub;   //����ϵͳ�ӿ�
    public static DemoCallback democallback;   //����ϵͳ�ص��ӿ�


    private boolean runflag = false;
    private Thread thr;
    private long hbInterval = 1000*10;//����ʱ��Ϊ10��
    private byte resendCount = 0; //�ط������������ֵ�ǳ�����ֹͣ�����߳�

    private UnsignedShort disCenterNo;
    private UnsignedShort dispatcherNo;
    private UnsignedInt sessonId;

    private static StarDemo des;

	public StarDemo()
	{
//		disLogin();
//		createConf();
	}

	public static void main (String [] args) {
        try {
        	startSub = new StarSystemWebServiceStub("http://223.83.17.3:8080/cdrlist");
//        	startSub = new StarSystemWebServiceStub("http://10.168.20.191/cgi-bin/soapcgi-dir");
        	startSub._getServiceClient().getOptions().setProperty(org.apache.axis2.transport.http.HTTPConstants.CHUNKED, Boolean.FALSE);


        	des = new StarDemo();
            des.queryRecord();
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

    /********************************��ѯ��*************************************/
  	@SuppressWarnings("unchecked")
    public void queryRecord(){
		try {
            StarSystemWebServiceStub.QueryRecord queryRecordBean = new StarSystemWebServiceStub.QueryRecord();

            queryRecordBean.setDispatcherno(new UnsignedShort("6002"));
            StarSystemWebServiceStub.Data_startid startid = new StarSystemWebServiceStub.Data_startid();
            startid.setData_startid(new UnsignedInt("2147483647"));
            queryRecordBean.setStartid(startid);
            StarSystemWebServiceStub.Data_recordnum recordnum = new StarSystemWebServiceStub.Data_recordnum();
            recordnum.setData_recordnum(new UnsignedShort("1"));
            queryRecordBean.setRecordnum(recordnum);
            queryRecordBean.setSkipnum(new UnsignedShort("0"));
            StarSystemWebServiceStub.Data_callnum callednum = new StarSystemWebServiceStub.Data_callnum();
            callednum.setData_callnum("6002");
            queryRecordBean.setCallednum(callednum);
            StarSystemWebServiceStub.Data_direction direction = new StarSystemWebServiceStub.Data_direction();
            direction.setData_direction(new UnsignedByte("0"));
            queryRecordBean.setDirection(direction);

            StarSystemWebServiceStub.QueryRecordResponse response =startSub.queryRecord(queryRecordBean);

            StarSystemWebServiceStub.Data_returnflag returnflag = response.getReturnflag();

            if (returnflag.getValue() == RESULT_SUCC)
           {
               LOGGER.debug("queryRecord OK no data");
           }
           else if(returnflag.getValue() == RESULT_SUCC_AND_DATA){
               for(int i = 0; i<response.getRecordItemResult().length; i++){
            	   LOGGER.debug("queryRecord i:"+i+" getSvrno"+response.getRecordItemResult()[i].getFilename()+
            			   " getConfname:"+response.getRecordItemResult()[i].getStarttime()+
            			   " getMemnum:"+response.getRecordItemResult()[i].getEndtime()+
            			   " getMemnum:"+response.getRecordItemResult()[i].getFilesize()+
            			   " getPlayflag:"+response.getRecordItemResult()[i].getFilestatus());
               }
               
           }else{
               LOGGER.debug("queryRecord Fail");
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
