package webservice;

import com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.topshinetech.topway.cu.dis.service.DisSystemWebServiceCallbackHandler;

public class DemoCallback extends DisSystemWebServiceCallbackHandler{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DemoCallback.class);
   
	public static final byte RESULT_SUCC = 0;
    public static final byte RESULT_SUCC_AND_DATA = 1;  //�ɹ����������ݷ���
    public static final byte RESULT_FAIL = -1;
  
    public void receiveResultdisCreateConf(com.topshinetech.topway.cu.dis.service.DisSystemWebServiceStub.DisCreateConfResponse result) {
    	
    	 DisSystemWebServiceStub.Data_returnflag returnflag = result.getReturnflag();
         
         if (returnflag.getValue() == RESULT_SUCC)
         {
        	 LOGGER.debug("create conf OK getSvrno:"+result.getSvrno()+"  getConfname:"+
        			 		result.getConfname()+"  confstate:"+result.getConfstate()+"  getMemnum:"+result.getMemnum());
            
         }
         else{
             LOGGER.debug("create conf Fail returnflag:"+returnflag.getValue());
         }
   }
}
