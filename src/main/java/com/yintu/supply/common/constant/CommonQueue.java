package com.yintu.supply.common.constant;

public class CommonQueue {
    //////////////////////////////////kafka队列/////////////////////////////////////
    /*
     * 返利队列topic
     */
    public static final String STLKAFKAREBATE = "tustore_stl_kafka_rebate";
    /*
     * 月享红包队列topic
     */
    public static final String STLKAFKAMONTHLYENJOYMENT = "tustore_stl_kafka_monthly_enjoyment";
    /*
     * 会员缓冲续费队列topic
     */
    public static final String STLKAFKABUFFER = "tustore_stl_kafka_bufferMsg";

    /*
     * 退款队列topic
     */
    public static final String STLKAFKAREFUND = "store_stl_kafka_refund";
    /*
     * 供应链付款topic
     */
    public static final String STLKAFKAREBATESCM = "tustore_stl_kafka_rebate_scm";

    //////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////kafka组/////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////
    /*
     * 返利队列消费组
     */
    public static final String STLKAFKAREBATEGROUP = "tustore_stl_kafka_rebate_consumer";
    /*
     * 月享红包队列消费组
     */
    public static final String STLKAFKAMONTHLYENJOYMENTGROUP = "tustore_stl_kafka_monthly_enjoyment_consumer";
    /*
     * 会员缓冲续费队列消费组
     */
    public static final String STLKAFKABUFFERGROUP = "tustore_stl_kafka_bufferMsg_consumer";

    /*
     * 退款消费组
     */
    public static final String STLKAFKAREFUNDGROUP = "store_stl_kafka_refund_consumer";
    /*
     * 供应链付款消费组
     */
    public static final String STLKAFKAREBATESCMGROUP = "tustore_stl_kafka_rebate_scm_consumer";

}
