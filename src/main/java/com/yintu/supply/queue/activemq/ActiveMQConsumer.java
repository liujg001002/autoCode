//package com.yintu.supply.queue.activemq;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jms.annotation.JmsListener;
//import org.springframework.stereotype.Service;
//
//import com.yintu.supply.service.RedisService;
//
//
//@Service
//public class ActiveMQConsumer {
//	
//	@Autowired
//	private  RedisService redisService;
//	
//	// 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
//	@JmsListener(destination = "seckill.queue")
//	public void receiveQueue(String message) {
//	    //收到通道的消息之后执行操作(超卖)
//    	String[] array = message.split(";"); 
//    	//TODO 判断的
//		WebSocketServer.sendInfo(array[0].toString(), "成功");//推送给前台
//		redisUtil.cacheValue(array[0], "ok");//
//	}
//}
