package com.yintu.supply.common.utils;
import org.apache.commons.codec.digest.DigestUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * 程序工具类，提供便捷方法
 * @author kwah 2018年10月12日  
 */
public class ApplicationUtils {
	
    /**
     * 雪花算法id编号
     *
     * @return UUID
     */
    public static long snowFlakeID() {
        SnowFlakeUtil snowFlakeUtil = SnowFlakeUtil.getFlowIdInstance();
        return snowFlakeUtil.nextId();
    }

    /**
     * 产生一个36个字符的UUID
     *
     * @return UUID
     */
    public static String randomUUID() {
        return UUID.randomUUID().toString();
    }

    /**
     * 产生一个32个字符的UUID
     *
     * @return UUID
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * md5加密
     *
     * @param value 要加密的值
     * @return md5加密后的值
     */
    public static String md5Hex(String value) {
        return DigestUtils.md5Hex(value);
    }

    /**
     * sha1加密
     *
     * @param value 要加密的值
     * @return sha1加密后的值
     */
    public static String sha1Hex(String value) {
        return DigestUtils.sha1Hex(value);
    }

    /**
     * sha256加密
     *
     * @param value 要加密的值
     * @return sha256加密后的值
     */
    public static String sha256Hex(String value) {
        return DigestUtils.sha256Hex(value);
    }

    /**
     * 获取多少位随机数
     * @param num
     * @return
     */
    public static String getNumStringRandom(int num){
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        //随机生成数字，并添加到字符串
        for(int i = 0;i<num;i++){
            str.append(random.nextInt(10));
        }
        return  str.toString();
    }

    /**
     * 获取区间内的随机数
     * @param min
     * @param max
     * @return
     */
    public static int getRandomBetween(int min, int max){
        Random random = new Random();
        int s = random.nextInt(max)%(max-min+1) + min;
        return s;
    }

    /**
     * 多个数字相乘保留2位小数 最低0.01
     * @return
     */
    public static BigDecimal multiply(BigDecimal... values){
        BigDecimal reValue = BigDecimal.ZERO;
        for (int i = 0; i < values.length; i++) {
            if(i==0){
                reValue = values[i];
            }else{
                reValue = reValue.multiply(values[i]);
            }
        }
        reValue = reValue.compareTo(BigDecimal.ZERO)==1?reValue:new BigDecimal(0.01);
        return reValue.setScale(2, RoundingMode.DOWN);
    }

    /**
     *
     * @param date 需修改时间
     * @param type 年月日，时分秒 目前只有天
     * @param time
     * @return
     */
    public static Date dateUtil(Date date,String type,int time){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if("day".equals(type)){
            calendar.add(Calendar.DAY_OF_MONTH,time);//利用Calendar 实现 Date日期+3天
        }
        if("month".equals(type)){
            calendar.add(Calendar.MONTH,time);//利用Calendar 实现 Date日期+3月
        }
        return calendar.getTime();
    }


}