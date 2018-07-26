package com.shuangqi.kafkaTest.test3;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Arrays;
import java.util.Properties;

/**
 * 
* Title: KafkaConsumerTest
* Description:
*  kafka消费者 
* Version:1.0.0  
* @author pancm
* @date 2017年12月29日
 */
public class KafkaConsumerTest31 extends Thread {

	private final KafkaConsumer<String, String> consumer;
	private ConsumerRecords<String, String> msgList;
	private final String topic;
	private static final String GROUPID = "groupA2";
	private final String servers="10.1.251.52:9092";
//    private final String servers="192.169.2.156:9092,192.169.2.98:9092,192.169.2.188:9092";
	
	public KafkaConsumerTest31(String topicName) {
		Properties props = new Properties();
		//kafka消费的的地址
		props.put("bootstrap.servers", servers);
		//组名 不同组名可以重复消费
		props.put("group.id", GROUPID);
		//是否自动提交
		props.put("enable.auto.commit", "false");
		//从poll(拉)的回话处理时长
		props.put("auto.commit.interval.ms", "1000");
		//超时时间
		props.put("session.timeout.ms", "30000");
		props.put("max.poll.records", "100");
//		earliest当各分区下有已提交的offset时，从提交的offset开始消费；无提交的offset时，从头开始消费 
//		latest 
//		当各分区下有已提交的offset时，从提交的offset开始消费；无提交的offset时，消费新产生的该分区下的数据 
//		none 
//		topic各分区都存在已提交的offset时，从offset后开始消费；只要有一个分区不存在已提交的offset，则抛出异常
		props.put("auto.offset.reset", "earliest");
		//序列化
		props.put("key.deserializer", StringDeserializer.class.getName());
		props.put("value.deserializer", StringDeserializer.class.getName());
		this.consumer = new KafkaConsumer<String, String>(props);
		this.topic = topicName;
		//订阅者主题
		this.consumer.subscribe(Arrays.asList(topic));
	}

	@Override
	public void run() {
		
		int messageNo = 0;
		System.out.println("---------开始消费---------");
		try {
			for (;;) {
					msgList = consumer.poll(100);
					if(null!=msgList&&msgList.count()>0){
//						System.out.println("msgList:"+msgList.count());
					for (ConsumerRecord<String, String> record : msgList) {
						//消费100条就打印 ,但打印的数据不一定是这个规律的
						if(messageNo%100==0){
							System.out.println(topic+"     "+ "=======receive: key = " + record.key() + ", value = " + record.value()+" offset==="+record.offset());
//							consumer.commitAsync();
						}
						
//						if(messageNo==101){
//							System.out.println("=======receive: key = " + record.key() + ", value = " + record.value()+" offset==="+record.offset());
//							break;
//						}
//						//当消费了1000条就退出
//						if(messageNo%1000==0){
//							break;
//						}
					}
					messageNo++;
				}else{	
					Thread.sleep(1000);
					System.out.println("休眠中...");
				}
			}		
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			consumer.close();
		}
	}
   
	public static void main(String args[]) {
		KafkaConsumerTest31 test1 = new KafkaConsumerTest31("KAFKA_TEST");
//		KafkaConsumerTest test2 = new KafkaConsumerTest("1001_INSERT");
//		KafkaConsumerTest test3 = new KafkaConsumerTest("1002_INSERT");
		Thread thread1 = new Thread(test1);
//		Thread thread2 = new Thread(test2);
//		Thread thread3 = new Thread(test3);
		thread1.start();
//		thread2.start();
//		thread3.start();
	}
}
