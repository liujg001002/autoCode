//package com.yintu.supply.queue.kafka;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Component;
//
//import com.yintu.supply.service.RedisService;
//
///**
// * 消费者 spring-kafka 2.0 + 依赖JDK8
// * @author kwah
// */
//@Component
//public class KafkaConsumer {
//	
//	@Autowired
//	private RedisService redisService;
//    /**
//     * 监听seckill主题,有消息就读取
//     * @param message
//     */
//    @KafkaListener(topics = {"seckill"})
//    public void receiveMessage(String message){
//    	//收到通道的消息之后执行操作
//    	String[] array = message.split(";"); 
//    	
//    	//TODO
//
//    }
//}