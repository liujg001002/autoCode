//package com.yintu.supply.queue.redis;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.yintu.supply.service.RedisService;
//
///**
// * 消费者
// * @author 科帮网 By https://blog.52itstyle.com
// */
//@Service
//public class RedisConsumer {
//	
//	@Autowired
//	private RedisService redisService;
//	
//    public void receiveMessage(String message) {
//        //收到通道的消息之后执行秒杀操作(超卖)
//    	String[] array = message.split(";"); 
//    	if(redisService.get(array[0])==null){//control层已经判断了，其实这里不需要再判断了
//    		Result result = ?.startSeckilDBPCC_TWO(Long.parseLong(array[0]), Long.parseLong(array[1]));
//    		if(result.equals(Result.ok(SeckillStatEnum.SUCCESS))){
//    			WebSocketServer.sendInfo(array[0].toString(), "成功");//推送给前台
//    		}else{
//    			WebSocketServer.sendInfo(array[0].toString(), "失败");//推送给前台
//    			redisUtil.cacheValue(array[0], "ok");//结束
//    		}
//    	}else{
//    		WebSocketServer.sendInfo(array[0].toString(), "失败");//推送给前台
//    	}
//    }
//}