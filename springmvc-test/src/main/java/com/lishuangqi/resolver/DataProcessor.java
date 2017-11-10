/**
 * 
 */
package com.lishuangqi.resolver;

import com.alibaba.fastjson.JSONObject;
import com.lishuangqi.common.RawMessage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author whsav
 *
 */
public class DataProcessor implements MessageListener {
	private static final int nThreads = 10;
	private static final int MAX_QUEUQ_SIZE = 2000;
	private ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 4, 3, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(MAX_QUEUQ_SIZE),
            new ThreadPoolExecutor.CallerRunsPolicy());
	public static void main(final String... args) throws Exception {  
		  
	    AbstractApplicationContext ctx =  
	        new ClassPathXmlApplicationContext("rabbitmq.xml");  
	    RabbitTemplate template = ctx.getBean(RabbitTemplate.class);  
	    template.convertAndSend("Hello, world!");  
	    Thread.sleep(1000);  
	    ctx.destroy();  
	}
	@Override
	public void onMessage(Message msg) {
		try{
			String strmsg=new String(msg.getBody());
			if(StringUtils.isEmpty(strmsg) && strmsg.length()>500) {
				System.out.println("receive message:" + strmsg.substring(0,500)+"...");
			}else {
				System.out.println("receive message:" + strmsg);
			}
			RawMessage rm=JSONObject.parseObject(strmsg,RawMessage.class);
			threadPool.execute(new ProcessTask(rm));
		}catch(Exception e){
//			LogUtil.appLog.error("receive error:",e);
		}		
	} 
	
}
