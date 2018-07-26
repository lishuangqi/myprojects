package com.shuangqi.kafkaTest.examples;

public class KafkaProducerConsumerDemo {

	public static final String KAFKASTR = "10.1.251.52:9092";

	public static void main(String[] args) {
		new Producer(KAFKASTR, "t_test").start(); // args[0] 为要发送的 topic
//		new Consumer(KAFKASTR, "t_test").start(); // args[0] 为要接收的 topic
	}
}