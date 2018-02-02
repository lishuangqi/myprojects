/**
 * 
 */
package com.lishuangqi.common.rabbitmq;

import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author whsav
 *
 */
@Component
public class MQSender {
	
	@Autowired 
	private RabbitTemplate amqpTemplate;
	
	public void convertAndSend(Object obj){
		amqpTemplate.convertAndSend(obj);
	}
	
	public void convertAndSend(String exchange,String routingKey,Object obj){
		amqpTemplate.convertAndSend(exchange, routingKey, JSONObject.toJSONString(obj));
	}
	
	public void convert2JsonAndSend(Object obj){
		amqpTemplate.convertAndSend(JSONObject.toJSONString(obj));		
	}
}
